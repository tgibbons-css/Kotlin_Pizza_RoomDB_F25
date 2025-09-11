package cis3334.kotlin_pizza_roomdb

// --- File: PizzaDao.kt ---

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface PizzaDao {
    @Insert
    suspend fun insert(pizza: PizzaEntity): Long


    @Query("SELECT * FROM pizzas ORDER BY createdAt DESC")
    fun getAll(): Flow<List<PizzaEntity>>


    @Query("DELETE FROM pizzas")
    suspend fun clear()
}