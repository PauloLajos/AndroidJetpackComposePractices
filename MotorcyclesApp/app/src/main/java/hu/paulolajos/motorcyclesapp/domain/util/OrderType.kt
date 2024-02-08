package hu.paulolajos.motorcyclesapp.domain.util

sealed class OrderType {
    object Ascending : OrderType()
    object Descending : OrderType()
}