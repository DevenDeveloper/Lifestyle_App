# KMP Lifestyle App

## Overview

The KMP Lifestyle App consists of two primary screens:

- **My Workout Screen**: The default launch screen, displaying workout details.
- **Custom Workout Screen**: A customizable workout screen where users can manage workout capacities.

The app is developed using Kotlin for Android (with Jetpack Compose) and Swift for iOS (with SwiftUI), utilizing Kotlin Multiplatform (KMP) for shared business logic and data management.

### Features
- **My Workout Screen**: Displays the workout details on launch.
- **Custom Workout Screen**: Allows users to view and manage workout capacities fetched from the shared logic folder.
- Seamless navigation between screens.
- Shared logic and data across platforms (Android and iOS).

## Development Approach

### Native UI Development:
- **Android**: Kotlin and Jetpack Compose are used for building the user interface.
- **iOS**: Swift and SwiftUI are used for creating the user interface.

### Shared Logic:
- A shared/common folder was created for reusable logic and code, which includes data handling (e.g., workout capacities).
- Data is passed between screens using JSON format managed in the shared folder.

### Libraries and Plugins:
- Used libraries for **data serialization** to ensure smooth and efficient data management across both platforms.
- Jetpack Compose for Android UI development.
- SwiftUI for iOS UI development.

### Repository Management:
- The project is managed in a **public GitHub repository**.
- Commit messages are regularly added for clarity and traceability.

## Screenshots
<p align="center">
  <img src="https://github.com/DevenDeveloper/Lifestyle_App/blob/main/Screenshots/Screenshot_20241229_203803.png" width="30%" />
  <img src="https://github.com/DevenDeveloper/Lifestyle_App/blob/main/Screenshots/Screenshot_20241229_204001.png" width="30%" />
  <img src="https://github.com/DevenDeveloper/Lifestyle_App/blob/main/Screenshots/Screenshot_20241229_204107.png" width="30%" />
</p>

## Installation

### Android:
To run the Android app, follow these steps:

1. Clone the repository:
   ```bash
   git clone <GitHub Repository URL>
   ```

2. Open the project in Android Studio.

3. Build and run the app on your Android device or emulator.

4. Alternatively, download the APK file from [here](Download APK) and install it on your device.

### iOS:
To run the iOS app, follow these steps:

1. Clone the repository:
   ```bash
   git clone <GitHub Repository URL>
   ```

2. Open the project in Xcode.

3. Build and run the app on your iOS device or simulator.

## Links
- [Figma Design](<[Figma Design URL](https://www.figma.com/design/pN6ZEwX1UwHUpMDKPxnrHf/Lifestyle-App?node-id=2-2087&t=V4vfIUiBFXid6nmg-0)>)
- [Download APK](<[Download APK URL](https://we.tl/t-3cltkHPzZ9)>)

## Conclusion

This app provides a seamless experience for users to manage their workouts on both Android and iOS devices. The use of Kotlin Multiplatform ensures code reuse across platforms, making development more efficient.

Feel free to reach out for any additional clarifications or questions.

