package hu.paulolajos.motorcyclesapp.domain.use_case

import hu.paulolajos.motorcyclesapp.data.MotorcycleRepository
import hu.paulolajos.motorcyclesapp.data.local.InvalidMotorcycleException
import hu.paulolajos.motorcyclesapp.domain.model.Motorcycle
import javax.inject.Inject

class SaveOrUpdateMotorcycle @Inject constructor(
    private val repository: MotorcycleRepository
) {
    @Throws(InvalidMotorcycleException::class)
    suspend operator fun invoke(motorcycle: Motorcycle) {

        if (motorcycle.brandName.isBlank()) {
            throw InvalidMotorcycleException("The brand name of the motorcycle can't be empty")
        }

        if (motorcycle.model.isBlank()) {
            throw InvalidMotorcycleException("The model of the motorcycle can't be empty")
        }

        if (motorcycle.id == 0) {
            repository.saveMotorcycle(motorcycle)
        } else {
            repository.updateMotorcycle(motorcycle.id, motorcycle)
        }
    }
}