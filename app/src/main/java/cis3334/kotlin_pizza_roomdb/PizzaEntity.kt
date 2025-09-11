package cis3334.kotlin_pizza_roomdb

// --- File: PizzaEntity.kt ---

import androidx.room.Entity
import androidx.room.PrimaryKey


/** Beginner-friendly Room entity that mirrors the simple UI state.
 * Rather than a Set<Topping>, we store three booleans for clarity. */
@Entity(tableName = "pizzas")
data class PizzaEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val sizeIndex: Int, // 0=Small, 1=Medium, 2=Large, 3=X-Large
    val hasChicken: Boolean,
    val hasPepperoni: Boolean,
    val hasGreenPeppers: Boolean,
    val createdAt: Long = System.currentTimeMillis()
)