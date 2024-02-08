package hu.paulolajos.motorcyclesapp.data

import hu.paulolajos.motorcyclesapp.data.di.IoDispatcher
import hu.paulolajos.motorcyclesapp.data.local.LocalMotorcycle
import hu.paulolajos.motorcyclesapp.data.local.MotorcycleDao
import hu.paulolajos.motorcyclesapp.domain.model.Motorcycle
import hu.paulolajos.motorcyclesapp.domain.util.MotorcycleOrder
import hu.paulolajos.motorcyclesapp.domain.util.OrderType
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MotorcycleRepository @Inject constructor(
    private val motorcycleDao: MotorcycleDao,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) {
    fun getMotorcycles(motorcycleOrder: MotorcycleOrder): Flow<List<Motorcycle>> {

        when (motorcycleOrder.orderType) {
            is OrderType.Ascending -> return motorcycleDao.getAll().map { localMotorcycles ->
                when (motorcycleOrder) {
                    is MotorcycleOrder.BrandName -> localMotorcycles.sortedBy { it.brandName.lowercase() }
                        .map {
                            Motorcycle(
                                id = it.id,
                                brandName = it.brandName,
                                model = it.model
                            )
                        }

                    is MotorcycleOrder.Model -> localMotorcycles.sortedBy { it.model.lowercase() }
                        .map {
                            Motorcycle(
                                id = it.id,
                                brandName = it.brandName,
                                model = it.model
                            )
                        }
                }
            }

            is OrderType.Descending -> return motorcycleDao.getAll().map { localMotorcycles ->
                when (motorcycleOrder) {
                    is MotorcycleOrder.BrandName -> localMotorcycles.sortedByDescending { it.brandName.lowercase() }
                        .map {
                            Motorcycle(
                                id = it.id,
                                brandName = it.brandName,
                                model = it.model
                            )
                        }

                    is MotorcycleOrder.Model -> localMotorcycles.sortedByDescending { it.model.lowercase() }
                        .map {
                            Motorcycle(
                                id = it.id,
                                brandName = it.brandName,
                                model = it.model
                            )
                        }
                }
            }

        }

    }

    suspend fun getMotorcycle(id: Int): LocalMotorcycle = motorcycleDao.getMotorcycle(id)

    suspend fun saveMotorcycle(motorcycle: Motorcycle) =
        withContext(dispatcher) {
            motorcycleDao.insert(
                LocalMotorcycle(
                    id = motorcycle.id,
                    brandName = motorcycle.brandName,
                    model = motorcycle.model
                )
            )
        }

    suspend fun updateMotorcycle(id: Int, motorcycle: Motorcycle) =
        withContext(dispatcher) {
            motorcycleDao.update(
                LocalMotorcycle(
                    id = id,
                    brandName = motorcycle.brandName,
                    model = motorcycle.model
                )
            )
        }

    suspend fun deleteMotorcycle(id: Int) =
        withContext(dispatcher) {
            motorcycleDao.delete(id)
        }

    suspend fun deleteAll(): Flow<List<Motorcycle>> {
        withContext(dispatcher) {
            motorcycleDao.deleteAll()
        }
        return getMotorcycles(motorcycleOrder = MotorcycleOrder.BrandName(OrderType.Descending))
    }
}