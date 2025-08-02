📱 AR Alphabet Placement App
This is an Android AR application built with Jetpack Compose and SceneView, using Google ARCore and Filament to place interactive 3D models based on alphabet selection.

✨ Features
🔤 Tap an alphabet and place its corresponding 3D object (e.g., "A" → apple)

📦 .glb model support for realistic rendering

🛋️ Plane detection & object anchoring using ARCore

🎮 Touch interaction and model scaling (optional)

💡 HDR environmental lighting with real-world depth

🧰 Tech Stack
Layer	Tech
UI	Jetpack Compose
AR Engine	ARCore + SceneView + Filament
Model Format	.glb (GL Transmission Format)
Navigation	Jetpack Compose Navigation
Rendering	SceneView AR (ARSceneView)

📂 Assets Structure
css
Copy
Edit
app/
└── src/
    └── main/
        └── assets/
            └── models/
                ├── apple.glb
                ├── ball.glb
                ├── dog.glb
                ├── ... (A–Z)
📦 How to Install & Run
Clone the project

bash
Copy
Edit
git clone https://github.com/yourusername/ar-alphabet-app.git
cd ar-alphabet-app
Open in Android Studio (Giraffe or higher)
Make sure jitpack.io is added to your settings.gradle.kts

Build the project
Gradle should auto-download dependencies from JitPack and Google

Run on a physical ARCore-supported device

Emulator is not supported for AR apps
