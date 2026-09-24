# ComposeTutorial

A minimal, from-scratch Android Studio project for learning Jetpack Compose with Kotlin.

## Opening it
1. Open Android Studio (Ladybug or newer).
2. File > Open... and select the `ComposeTutorial` folder.
3. Let Gradle sync, then run the `app` configuration on an emulator or device (minSdk 24).

## What it demonstrates
- A stateless composable (`GreetingCard`)
- Local state + recomposition (`CounterButton`)
- State hoisting with a text field (`ProfileForm`)
- Efficient lists with `LazyColumn` (`TaskList`)
- App-wide theming with Material 3 (`ui/theme`)
- `Scaffold` + `TopAppBar` screen structure (`MainActivity`)
- Dependency versions centralized in a Gradle **version catalog** (`gradle/libs.versions.toml`)

See `guide.html` (open it in any browser) for a full, annotated walkthrough of every file and of Compose's core concepts.
