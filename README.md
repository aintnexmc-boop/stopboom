# StopBoom — End-only client mod (Minecraft 1.21.11)

A Fabric **client-side** mod that prevents you from accidentally using a bed in
the End. It does not need to be installed on the server.

## Behavior
- Cancels right-click use on beds **only in the End**.
- Runs on the client before the block-use packet is sent, so the server does
  not receive the bed interaction that would trigger the explosion.
- Shows `BOOM BLOCKED!!` in the action bar when it blocks an interaction.
- `/stopboom enable` and `/stopboom disable` toggle the protection.
- Does not block beds in the Nether or Overworld.

## Build
Requires JDK 21 and a Gradle installation compatible with Fabric Loom 1.14.
Run `gradle build` from this directory. The built JAR will be in `build/libs/`.

Target dependencies are configured in `gradle.properties`:
- Minecraft 1.21.11
- Fabric Loader 0.18.1
- Fabric API 0.141.6+1.21.11

This environment does not have Gradle or dependency-network access, so the
project has not been compiled or launch-tested here. Build it locally before
using it in-game.
