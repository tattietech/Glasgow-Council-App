# Glasgow Council App

> **Note**: This is an academic project created while I was studying Software Engineering. The SDK versions and build tools reflect the time of development and are documented as-is for historical accuracy. It is not live nor will it be maintained any further.

An Android application for the City of Glasgow Council, developed as a final HND assessment project. This app provides Glasgow residents and visitors with information about local attractions, events, and travel options, with user accounts and a community rating/comment system.

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

## License

This project was created as an academic assessment for HND qualification.

## Author

Andrew Bruce
- GitHub: [@tattietech](https://github.com/tattietech)

## Acknowledgments

Developed as a final assessment project for Android Development (HND level), demonstrating mobile application development skills including UI design, database management, API integration, and user authentication.
