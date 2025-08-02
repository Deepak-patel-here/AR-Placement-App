# 📱 AR Alphabet Placement App

An interactive Android AR application that allows users to tap on alphabets and place corresponding 3D models (like "A" for Apple) in their real-world environment using their camera.

Built using **Jetpack Compose**, **ARCore**, and **SceneView** with high-quality `.glb` models.

---

## ✨ Features

- 🔤 Tap on any alphabet (A–Z) to view and place its 3D object
- 📦 High-quality `.glb` 3D model rendering
- 🛋️ Real-world plane detection using ARCore
- 💡 Lighting & shadows via Filament
- 🎮 Touch interaction support for object placement

---

## 🧰 Tech Stack

| Layer         | Technology                       |
|---------------|----------------------------------|
| UI            | Jetpack Compose                  |
| AR Engine     | ARCore + SceneView + Filament    |
| Model Format  | `.glb` (Binary glTF)             |
| Navigation    | Jetpack Compose Navigation       |
| Rendering     | SceneView AR (`ARSceneView`)     |

---

## 📂 Assets Directory Structure

app/
└── src/
└── main/
└── assets/
└── models/
├── apple.glb
├── ball.glb
├── dog.glb
└── ... (A–Z)


