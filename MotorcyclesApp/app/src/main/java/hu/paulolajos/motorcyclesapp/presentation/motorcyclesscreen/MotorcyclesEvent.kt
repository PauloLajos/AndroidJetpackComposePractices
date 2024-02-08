package hu.paulolajos.motorcyclesapp.presentation.motorcyclesscreen

import hu.paulolajos.motorcyclesapp.domain.util.MotorcycleOrder

sealed class MotorcyclesEvent {
    data class Order(val motorcycleOrder: MotorcycleOrder) : MotorcyclesEvent()
    object ToggleOrderSection : MotorcyclesEvent()
}