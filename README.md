# Glasgow Council App

An Android application for the City of Glasgow Council, developed as a final HND assessment project. This app provides Glasgow residents and visitors with information about local attractions, events, and travel options, with user accounts and a community rating/comment system.

> **Note**: This is an academic project created for HND assessment purposes. The SDK versions and build tools reflect the time of development and are documented as-is for historical accuracy.

## Overview

The Glasgow Council App is a comprehensive mobile application that serves as a digital hub for Glasgow city information. Users can create accounts, explore local attractions, discover upcoming events, access travel information, and share reviews and ratings with the community.

## Features

- **User Authentication System**
  - User registration with password security
  - Login functionality
  - Password reset capability
  - Personalized user experience

- **Attractions Guide**
  - Browse 6 featured Glasgow attractions
  - View detailed information about each location
  - Access Google Maps integration for directions
  - Visit official websites directly from the app

- **Events Calendar**
  - Discover upcoming events in Glasgow
  - View event details including venues and dates
  - Get tickets through integrated links
  - Map views for event locations

- **Travel Information**
  - Public transport details
  - Route planning assistance
  - Transit system information

- **Community Features**
  - Rate attractions (1-5 star system)
  - Post comments and reviews
  - View community feedback
  - Timestamped review history

## Technologies Used

- **Platform**: Android
- **Language**: Java
- **Database**: SQLite (local database)
- **Minimum SDK**: API 21 (Android 5.0 Lollipop)
- **Target SDK**: API 25 (Android 7.1 Nougat)
- **Key Libraries**:
  - Android Support Library v7
  - Google Play Services (Maps)
  - Constraint Layout
  - JUnit (Testing)

## Requirements

- Android Studio (Arctic Fox or later recommended)
- Android SDK with API 21+
- Gradle build system
- Android device or emulator running Android 5.0 or higher

## Installation & Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/tattietech/Glasgow-Council-App.git
   cd Glasgow-Council-App
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an existing Android Studio project"
   - Navigate to the cloned repository folder
   - Wait for Gradle sync to complete

3. **Configure Build**
   - Ensure you have Android SDK API 25 installed
   - Build Tools version 27.0.1 required
   - Google Play Services must be available

4. **Run the Application**
   - Connect an Android device via USB (with USB debugging enabled) or start an emulator
   - Click the "Run" button in Android Studio or press Shift+F10
   - Select your target device

## Usage

1. **First Time Setup**
   - Launch the app
   - Register a new account with your details
   - Log in with your credentials

2. **Exploring Features**
   - Navigate through the main menu to access different sections
   - Browse attractions, events, and travel information
   - Click on items for detailed information

3. **Adding Reviews**
   - Navigate to any attraction
   - Enter your comment in the text field
   - Select a rating (1-5 stars)
   - Submit your review

## Project Structure

```
Glasgow-Council-App/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/me/andrewbruce/assessment3/
│   │   │   │   ├── Activities (Login, Register, Menu, Attractions, Events, Travel)
│   │   │   │   ├── DBManager.java (Database management)
│   │   │   │   ├── User.java (User model)
│   │   │   │   ├── Comment.java (Comment model)
│   │   │   │   └── CommentAdapter.java (Custom adapter for comments)
│   │   │   ├── res/
│   │   │   │   ├── layout/ (XML layouts)
│   │   │   │   ├── drawable/ (Images and graphics)
│   │   │   │   └── values/ (Strings, colors, styles)
│   │   │   └── AndroidManifest.xml
│   │   ├── androidTest/ (Instrumented tests)
│   │   └── test/ (Unit tests)
│   └── build.gradle
├── gradle/
├── README.md
└── settings.gradle
```

## Database Schema

The app uses SQLite with two main tables:

- **users**: Stores user account information (id, username, password, first_name, last_name)
- **comments**: Stores user reviews (id, attractionId, username, attractionComment, attractionRating, date)

## Testing

The project includes:
- Unit tests in `app/src/test/`
- Instrumented tests in `app/src/androidTest/`

Run tests using:
```bash
./gradlew test
./gradlew connectedAndroidTest
```

## License

This project was created as an academic assessment for HND qualification.

## Author

Andrew Bruce
- GitHub: [@tattietech](https://github.com/tattietech)

## Acknowledgments

Developed as a final assessment project for Android Development (HND level), demonstrating mobile application development skills including UI design, database management, API integration, and user authentication.
