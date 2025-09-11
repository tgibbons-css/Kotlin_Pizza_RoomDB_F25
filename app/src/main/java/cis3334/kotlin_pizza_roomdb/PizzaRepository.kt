package cis3334.kotlin_pizza_roomdb

// --- File: PizzaRepository.kt ---

import kotlinx.coroutines.flow.Flow


class PizzaRepository(private val dao: PizzaDao) {
    fun listPizzas(): Flow<List<PizzaEntity>> = dao.getAll()
    suspend fun addPizza(p: PizzaEntity) { dao.insert(p) }
    suspend fun clearAll() { dao.clear() }
}


// --- OPTIONAL: ViewModel wiring that uses the Repository ---
// If you want MainViewModel to persist orders, you can adapt like this.
// (Place this in your existing MainViewModel.kt and inject repository as needed.)
/*
class MainViewModel(app: Application) : AndroidViewModel(app) {
private val repo = PizzaRepository(PizzaDatabase.get(app).pizzaDao())
val pizzas: StateFlow<List<PizzaEntity>> = repo.listPizzas().stateIn(
viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList()
)


fun addToOrderPersisted(sizeIndex: Int, c: Boolean, p: Boolean, g: Boolean) = viewModelScope.launch {
repo.addPizza(PizzaEntity(sizeIndex = sizeIndex, hasChicken = c, hasPepperoni = p, hasGreenPeppers = g))
}


fun clearPersisted() = viewModelScope.launch { repo.clearAll() }
}
*/