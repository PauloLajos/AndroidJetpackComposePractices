package hu.paulolajos.motorcyclesapp.presentation.motorcyclesscreen

import hu.paulolajos.motorcyclesapp.domain.model.Motorcycle
import hu.paulolajos.motorcyclesapp.domain.util.MotorcycleOrder
import hu.paulolajos.motorcyclesapp.domain.util.OrderType

data class MotorcyclesScreenState(
    val motorcycles: List<Motorcycle> = listOf(),
    val isLoading: Boolean,
    val error: String? = null,
    val motorcycleOrder: MotorcycleOrder = MotorcycleOrder.BrandName(OrderType.Ascending),
    val isOrderSectionVisible: Boolean = false
)
