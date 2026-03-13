/**
 * RecipeManager handles all business logic related to recipes.
 * It manages the list of recipes and provides functions to
 * add, update, delete, list, and search recipes.
 */
class RecipeManager(private val recipes: MutableList<Recipe>) {

    /**
     * Adds a new recipe to the recipe list.
     *
     * @param recipe The recipe object to be added.
     */
    fun addRecipe(recipe: Recipe) {
        recipes.add(recipe)
    }

    /**
     * Returns a copy of the current list of recipes.
     * This prevents external classes from modifying
     * the internal recipe list directly.
     *
     * @return A list containing all stored recipes.
     */
    fun listRecipes(): List<Recipe> = recipes.toList()

    /**
     * Deletes a recipe from the list using its index.
     *
     * @param index The position of the recipe in the list.
     * @return The removed recipe if successful, or null if the index is invalid.
     */
    fun deleteRecipe(index: Int): Recipe? =
        if (index in recipes.indices) recipes.removeAt(index) else null

    /**
     * Updates an existing recipe with new information.
     *
     * @param index The position of the recipe to update.
     * @param updated The updated recipe object.
     * @return True if the update was successful, otherwise false.
     */
    fun updateRecipe(index: Int, updated: Recipe): Boolean {
        if (index in recipes.indices) {
            recipes[index] = updated
            return true
        }
        return false
    }

    /**
     * Searches for recipes that contain a specific ingredient.
     * The search is case-insensitive.
     *
     * @param query The ingredient keyword entered by the user.
     * @return A list of recipes that contain the ingredient.
     */
    fun searchByIngredient(query: String): List<Recipe> {
        val q = query.trim().lowercase()
        return recipes.filter { recipe ->
            recipe.ingredients.any { it.lowercase().contains(q) }
        }
    }
}
