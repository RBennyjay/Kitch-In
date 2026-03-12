// 1. Data Class Definition (Typically at the top)
data class Recipe(
    val name: String,
    val prepTimeMinutes: Int,
    val isVegetarian: Boolean = false
)

// 2. The Single Entry Point
fun main() {
    // Your initial test success message
    println("--- Kitch-In is officially running! ---")

    // Your first data experiment
    val myFirstRecipe = Recipe("Jollof Rice", 45)
    println("Current Recipe: $myFirstRecipe")

    val veggieVersion = myFirstRecipe.copy(isVegetarian = true)
    println("Vegetarian Version: $veggieVersion")

    println("---------------------------------------")

}

