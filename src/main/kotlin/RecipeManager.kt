class RecipeManager(private val recipes: MutableList<Recipe>) {

    fun addRecipe(recipe: Recipe) {
        recipes.add(recipe)
    }

    fun listRecipes(): List<Recipe> = recipes.toList()

    fun deleteRecipe(index: Int): Recipe? =
        if (index in recipes.indices) recipes.removeAt(index) else null

    fun updateRecipe(index: Int, updated: Recipe): Boolean {
        if (index in recipes.indices) {
            recipes[index] = updated
            return true
        }
        return false
    }

    fun searchByIngredient(query: String): List<Recipe> {
        val q = query.trim().lowercase()
        return recipes.filter { recipe ->
            recipe.ingredients.any { it.lowercase().contains(q) }
        }
    }
}