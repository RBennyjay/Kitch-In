import java.io.File

class FileStorage(private val file: File) {

    fun saveRecipes(recipes: List<Recipe>) {

        val lines = recipes.map {
            "${it.name}|${it.prepTimeMinutes}|${it.ingredients.joinToString(",")}"
        }

        file.writeText(lines.joinToString("\n"))

        println("...Progress saved to ${file.name}")
    }

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