import java.io.File

/**
 * FileStorage is responsible for saving recipes to a file
 * and loading them back into the application when it starts.
 * This allows recipe data to persist between program runs.
 */
class FileStorage(private val file: File) {

    /**
     * Saves the list of recipes to the storage file.
     * Each recipe is written as a single line using the format:
     * name | prepTime | ingredient1,ingredient2,ingredient3
     *
     * @param recipes The list of recipes that should be saved.
     */
    fun saveRecipes(recipes: List<Recipe>) {

        val lines = recipes.map {
            "${it.name}|${it.prepTimeMinutes}|${it.ingredients.joinToString(",")}"
        }

        file.writeText(lines.joinToString("\n"))

        println("...Progress saved to ${file.name}")
    }

    /**
     * Loads recipes from the storage file if it exists.
     * The file is read line by line and converted back
     * into Recipe objects which are returned to the program.
     *
     * @return A mutable list containing all loaded recipes.
     */
    fun loadRecipes(): MutableList<Recipe> {

        val recipes = mutableListOf<Recipe>()

        if (file.exists()) {

            file.readLines().forEach { line ->

                val parts = line.split('|')

                if (parts.size == 3) {

                    val name = parts[0]
                    val time = parts[1].toIntOrNull() ?: 0

                    val ingredients =
                        parts[2]
                            .split(",")
                            .map { it.trim() }
                            .filter { it.isNotEmpty() }

                    recipes.add(Recipe(name, time, ingredients))
                }
            }

            println("Loaded ${recipes.size} recipes from memory.")
        }

        return recipes
    }
}