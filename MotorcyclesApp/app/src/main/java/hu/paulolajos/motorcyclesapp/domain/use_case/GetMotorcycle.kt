package hu.paulolajos.motorcyclesapp.domain.use_case

import hu.paulolajos.motorcyclesapp.data.MotorcycleRepository
import hu.paulolajos.motorcyclesapp.data.local.LocalMotorcycle
import javax.inject.Inject

class GetMotorcycle @Inject constructor(
    private val repository: MotorcycleRepository,
) {
    suspend operator fun invoke(id: Int) : LocalMotorcycle = repository.getMotorcycle(id)
}