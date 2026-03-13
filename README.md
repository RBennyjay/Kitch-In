# Kitch-In

Kitch-In

Kitch-In is a simple, CLI-based recipe management tool built in Kotlin. It allows users to add, view, edit, search, and delete recipes, with data persisted to a local file.

Table of Contents

Features

Project Structure

Installation

Usage

Class Diagram

Future Enhancements

Features

Add new recipes with name, prep time, and ingredients.

View all recipes in a clean list format.

Edit existing recipes.

Delete recipes by selection.

Search recipes by ingredient.

Save and load recipes from a file (recipes.txt).

Project Structure
Kitch-In/
│
├── src/
│   └── main/
│       └── kotlin/
│           ├── data/
│           │   └── Recipe.kt
│           │
│           ├── logic/
│           │   └── RecipeManager.kt
│           │
│           ├── storage/
│           │   └── FileStorage.kt
│           │
│           ├── ui/
│           │   └── MenuUI.kt
│           │
│           └── Main.kt
│
├── recipes.txt          # Persistent storage of recipes
└── build.gradle / pom.xml (optional, if using Gradle/Maven)

data/ – Holds the Recipe data class.

logic/ – Holds the RecipeManager class for business logic.

storage/ – Contains FileStorage class for reading/writing recipes.

ui/ – Contains MenuUI for CLI interactions.

Main.kt – Program entry point.

Installation

Clone the repository

git clone <your-repo-url>
cd Kitch-In

Open in IntelliJ IDEA

Go to File > Open and select the project folder.

Ensure your Project SDK is set to Kotlin/JDK 24+.

Build and run

Right-click Main.kt and select Run 'MainKt'.

Or use the terminal:

./gradlew run
Usage

Launch the program.

Navigate the menu:

1. Add Recipe
2. View All
3. Search by Ingredient
4. Edit Recipe
5. Delete Recipe
6. Exit

Follow on-screen prompts to manage recipes.

Recipes are saved automatically when exiting.

Class Diagram

The project has a layered architecture with four main classes:

Recipe – Data model for recipes.

RecipeManager – Business logic (add, edit, delete, search).

FileStorage – Handles file persistence.

MenuUI – CLI interface for user interaction.

Relationships:

RecipeManager manages Recipe objects.

FileStorage reads/writes Recipe objects.

MenuUI depends on both RecipeManager and FileStorage.

Future Enhancements

Add recipe categories (e.g., Breakfast, Lunch, Dinner).

Support multiple users with separate recipe lists.

Export recipes to CSV or JSON.

Improve search with multiple criteria (prep time, vegetarian, etc.).

Add a GUI version for desktop or web.