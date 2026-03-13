# Kitch-In

# 🍳 Kitch-In: Kotlin Recipe Manager
[![Kotlin](https://img.shields.io/badge/Kotlin-1.9%2B-blue.svg)](https://kotlinlang.org/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

**Kitch-In** is a lightweight, CLI-based recipe management system built in Kotlin. Designed with a focus on **Object-Oriented Programming (OOP)** and **Data Persistence**, it allows users to manage their culinary library directly from the terminal.

---

## 🚀 Features
- **Full CRUD Operations**: Create, Read, Update, and Delete recipes seamlessly.
- **Smart Search**: Filter recipes by ingredients using Kotlin's powerful Lambda functions.
- **Data Persistence**: Automatic serialization to `recipes.txt` ensures your data is saved between sessions.
- **Input Validation**: Robust handling of prep times and ingredient formatting.

---

## 📂 Project Structure
The project follows a modular architecture for better maintainability:

```text
Kitch-In/
├── src/
│   └── main/
│       └── kotlin/
│           ├── data/      # Recipe Data Class (The Model)
│           ├── logic/     # Business Logic & Collection Management
│           ├── storage/   # File I/O (Persistence Layer)
│           ├── ui/        # CLI Interface & Input Handling
│           └── Main.kt    # Application Entry Point
├── recipes.txt            # Local flat-file database
└── README.md
🛠️ Installation & Setup
Prerequisites
JDK 24+ (Recommended)

IntelliJ IDEA (Optional but recommended)

Steps
Clone the repository:

Bash
git clone <your-repo-url>
cd Kitch-In
Build and Run:

In IntelliJ, right-click Main.kt and select Run 'MainKt'.

Alternatively, use the terminal:

Bash
java -jar Kitch-In.jar
📖 Usage Guide
Upon launch, navigate through the interactive menu:

Add Recipe: Follow prompts to input name, time, and comma-separated ingredients.

View All: Lists all saved recipes with detailed formatting.

Search: Find recipes containing specific ingredients (e.g., "Rice" or "Pepper").

Edit: Correct existing entries (e.g., updating prep times).

Delete: Remove obsolete recipes from the system.

Exit: Triggers the auto-save sequence to recipes.txt.

📊 Class Architecture
The system is built on a layered architecture:

Recipe: The core data model.

RecipeManager: Manages the MutableList and handles search logic.

FileStorage: Handles the transformation of objects to pipe-delimited text (|).

MenuUI: Orchestrates user input and console output.

🔮 Future Enhancements
[ ] Categories: Tag recipes as Breakfast, Lunch, or Dinner.

[ ] JSON Support: Transition from flat-file to JSON serialization for more complex data.

[ ] GUI Upgrade: Transition the CLI to a Compose for Desktop application.

📝 Author
Ebenezer John (Benny Jay) IT Professional | Full-Stack Developer