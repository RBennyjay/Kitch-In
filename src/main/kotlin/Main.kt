import java.io.File

fun main() {

    val file = File("recipes.txt")

    val storage = FileStorage(file)

    val recipes = storage.loadRecipes()

    val manager = RecipeManager(recipes)

    val menu = MenuUI(manager, storage)

    menu.start()
}