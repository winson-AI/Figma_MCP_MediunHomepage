## MediUn Homepage – Compose Multiplatform

This is a Kotlin Multiplatform (Android/iOS) app implementing a Figma design ("Mediun_Homepage") using Compose Multiplatform (CMP). The UI and assets are mapped directly from the Figma file and rendered via Compose. All shared UI lives under `composeApp` with Android and iOS entry points.

### Project structure
- `composeApp/`
  - `src/commonMain/kotlin/com/example/mediunhomepage/`
    - `App.kt` – the entire UI implementation (kept in a single file as requested)
  - `src/commonMain/composeResources/drawable/` – all images and vector XMLs used by Compose
  - Platform-specific sources in `androidMain/` and `iosMain/`
- `iosApp/` – iOS host application

### Requirements
- JDK 17+
- Android Studio / IntelliJ with Kotlin and Compose plugins
- Xcode (for iOS build and preview)

### Build and run
Android (assemble debug):
```bash
./gradlew :composeApp:assembleDebug
```

iOS (open the Xcode workspace):
```
open iosApp/iosApp.xcodeproj
```
Run the `iosApp` target from Xcode.

### Resources and assets
- All runtime assets are stored in `composeApp/src/commonMain/composeResources/drawable`.
- Images: PNG files (e.g., `best_seller_card_1.png`, `banner_pizza.png`, `recommend_card_1.png`).
- Icons: vector XML files (e.g., `bot_meal.xml`, `nav_home.xml`, `action_bell.xml`, `next_icon_arrow.xml`).
- We removed raw SVG usage for Android compatibility. Vector XMLs are generated to mirror the Figma SVGs.
- Access assets via generated accessors, e.g.:
```kotlin
Image(painterResource(Res.drawable.nav_home), contentDescription = null)
```

### Figma mapping
- Figma file: MediUn Homepage (node `1:102`).
- Implemented sections:
  - Status bar + top search and actions (Frames 59–61)
  - Greeting and categories (Bot-menu)
  - Best Seller list with Next Arrow
  - Promo banner (Frame 71) – pizza image, copy, decorative swoosh, accent circles
  - Recommend cards with rating and price (Frames 68–69)

### Conventions
- UI code centralized in `App.kt` as required
- Resource names are descriptive and kebab-free (snake_case)
- Colors:
  - Text dark: `#391713`
  - Text light: `#F8F8F8`
  - Orange: `#E95322`
  - Yellow 2: `#F3E9B5`

### Troubleshooting
- Android preview error "Android platform doesn't support SVG format": ensure all icons are Vector XMLs, not SVGs
- If a resource isn't found, run a build to regenerate Compose resource accessors

### Contributing
- Keep UI edits in `App.kt`
- Place new images/vectors in `composeResources/drawable/` and prefer Vector XMLs for icons
- Use meaningful, short names for assets and reference them via `Res.drawable.*`

This is a Kotlin Multiplatform project targeting Android, iOS.

* [/composeApp](./composeApp/src) is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - [commonMain](./composeApp/src/commonMain/kotlin) is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    the [iosMain](./composeApp/src/iosMain/kotlin) folder would be the right place for such calls.
    Similarly, if you want to edit the Desktop (JVM) specific part, the [jvmMain](./composeApp/src/jvmMain/kotlin)
    folder is the appropriate location.

* [/iosApp](./iosApp/iosApp) contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform,
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…