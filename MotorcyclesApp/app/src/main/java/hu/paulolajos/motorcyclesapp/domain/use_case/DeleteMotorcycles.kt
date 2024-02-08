package hu.paulolajos.motorcyclesapp.domain.use_case

import hu.paulolajos.motorcyclesapp.data.MotorcycleRepository
import javax.inject.Inject

class DeleteMotorcycles @Inject constructor(
    private val repository: MotorcycleRepository,
) {
    suspend operator fun invoke()  = repository.deleteAll()
}