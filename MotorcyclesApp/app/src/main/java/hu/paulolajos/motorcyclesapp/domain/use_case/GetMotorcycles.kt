package hu.paulolajos.motorcyclesapp.domain.use_case

import hu.paulolajos.motorcyclesapp.data.MotorcycleRepository
import hu.paulolajos.motorcyclesapp.domain.model.Motorcycle
import hu.paulolajos.motorcyclesapp.domain.util.MotorcycleOrder
import hu.paulolajos.motorcyclesapp.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMotorcycles @Inject constructor(
    private val repository: MotorcycleRepository
) {
    operator fun invoke(
        motorcycleOrder: MotorcycleOrder = MotorcycleOrder.BrandName(OrderType.Descending)
    ): Flow<List<Motorcycle>> = repository.getMotorcycles(motorcycleOrder)
}