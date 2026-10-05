# Hackermenu GUI Port — Fabric 1.21.11

GUI-only port of the supplied NeoForge screens/assets.

Open the GUI in-game with **H**.

The supplied screen layouts, textures, button hitboxes and page navigation are recreated. The original NeoForge menu/network backend was not supplied, so the action buttons are harmless placeholders and the command text box does not execute or send commands.

Java 21 is required. Build with `gradlew.bat build` after adding a standard Gradle wrapper, or with an installed Gradle 9.x distribution.


## Build

Push the project to GitHub and the `build.yml` workflow will build the mod automatically. You can also run the workflow manually with GitHub Actions. It uses the Gradle wrapper if one is present, otherwise it uses a system Gradle installation. The finished JAR will be in `build\libs`.
