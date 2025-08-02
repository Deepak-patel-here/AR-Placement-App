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


---

## 📦 How to Build & Run

1. **Clone the project**
   ```bash
   git clone https://github.com/Deepak-patel-here/AR-Placement-App.git

### ✅ To use this:

1. Copy the entire code above.
2. Paste it into a new file in your project root: `README.md`.
3. Replace placeholders like:
   - `https://github.com/Deepak-patel-here/AR-Placement-App.git`
   - Your GitHub or LinkedIn links

---

Let me know if you'd like this saved into a file or zipped with your APK/assets!
