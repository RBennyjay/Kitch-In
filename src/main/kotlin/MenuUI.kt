class MenuUI(
    private val manager: RecipeManager,
    private val storage: FileStorage
) {

    fun start() {

        var running = true

        println("Welcome to Kitch-In!")

        while (running) {

            println("\n--- Main Menu ---")
            println("1. Add Recipe")
            println("2. View All")
            println("3. Search by Ingredient")
            println("4. Edit Recipe")
            println("5. Delete Recipe")
            println("6. Exit")

            print("Select option: ")

            when (readlnOrNull()) {

                "1" -> addRecipe()

                "2" -> viewRecipes()

                "3" -> searchRecipe()

                "4" -> editRecipe()

                "5" -> deleteRecipe()

                "6" -> {
                    storage.saveRecipes(manager.listRecipes())
                    println("Saving data... Goodbye!")
                    running = false
                }

                else -> println("Invalid option.")
            }
        }
    }

    private fun addRecipe() {

        print("Enter recipe name (e.g., Jollof Rice): ")
        val name = readlnOrNull() ?: "Unnamed"

        print("Prep time: ")
        val time = readlnOrNull()?.toIntOrNull() ?: 0

        print("Enter ingredients separated by commas: ")
        val ingredients =
            readlnOrNull()
                ?.split(",")
                ?.map { it.trim() }
                ?.filter { it.isNotEmpty() }
                ?: listOf()

        manager.addRecipe(Recipe(name, time, ingredients))

        println("Recipe added!")
    }

    private fun viewRecipes() {

        val recipes: List<Recipe> = manager.listRecipes()

        if (recipes.isEmpty()) {
            println("No recipes yet.")
            return
        }

        recipes.forEachIndexed { index, recipe ->
            println("${index + 1}. ${recipe.name} (${recipe.prepTimeMinutes} mins)")
            println("   Ingredients: ${recipe.ingredients.joinToString(", ")}")
        }
    }

    private fun searchRecipe() {

        print("Ingredient: ")
        val query = readlnOrNull() ?: ""

        val results = manager.searchByIngredient(query)

        if (results.isEmpty()) {
            println("No recipes found.")
        } else {
            results.forEach { recipe ->
                println("${recipe.name} (${recipe.prepTimeMinutes} mins)")
            }
        }
    }

    private fun editRecipe() {

        val recipes: List<Recipe> = manager.listRecipes()

        if (recipes.isEmpty()) {
            println("No recipes to edit.")
            return
        }

        // Show all recipes with numbers
        recipes.forEachIndexed { index, recipe ->
            println("${index + 1}. ${recipe.name} (${recipe.prepTimeMinutes} mins)")
        }

        print("Enter the number of the recipe to edit: ")
        val index = readlnOrNull()?.toIntOrNull()?.minus(1) ?: -1

        if (index !in recipes.indices) {
            println("Invalid recipe number.")
            return
        }

        val old = recipes[index]
        println("Editing '${old.name}' (leave blank to keep current value)")

        print("New name [${old.name}]: ")
        val newName = readlnOrNull()?.takeIf { it.isNotBlank() } ?: old.name

        print("New prep time [${old.prepTimeMinutes}]: ")
        val newTime = readlnOrNull()?.toIntOrNull() ?: old.prepTimeMinutes

        print("New ingredients (comma separated) [${old.ingredients.joinToString(", ")}]: ")
        val rawIngredients = readlnOrNull()
        val newIngredients = if (!rawIngredients.isNullOrBlank()) {
            rawIngredients.split(",").map { it.trim() }.filter { it.isNotEmpty() }
        } else {
            old.ingredients
        }

        manager.updateRecipe(index, Recipe(newName, newTime, newIngredients))
        println("Recipe updated!")
    }

    private fun deleteRecipe() {

        print("Enter recipe number: ")
        val index = readlnOrNull()?.toIntOrNull()?.minus(1) ?: -1

        val removed = manager.deleteRecipe(index)

        if (removed != null) {
            println("Deleted ${removed.name}")
        } else {
            println("Invalid recipe number.")
        }
    }
}