import java.io.File

/**
 * Entry point of the Kitch-In application.
 * This function initializes the file storage system,
 * loads saved recipes, creates the recipe manager,
 * and starts the user interface menu.
 */
fun main() {

    val file = File("recipes.txt")

    val storage = FileStorage(file)

    val recipes = storage.loadRecipes()

    val manager = RecipeManager(recipes)

    val menu = MenuUI(manager, storage)

    menu.start()
}