# LoginApp with android studio

![login0 2](https://github.com/brianlangay4/Login/assets/67788456/bff0e09e-8976-45ff-b34e-7da240e90d60)

##
#BRIAN BARNABAS LANGAY
2322190027
##

# Part I
## App Development Process Document

### Project Overview:

The objective of this project is to create a robust Android app with login and registration functionalities, utilizing SQLite for efficient user data storage and custom notifications for various events. The primary programming languages employed are Java for Android development, SQL for database operations, and XML for layout design.

### Development Tools:

- **Android Studio:** The official IDE for Android app development.
- **SQLite Database:** A lightweight, embedded database for local user information storage.
- **Java:** The primary language for Android app development.
- **XML:** Used for defining the app's layout and appearance.

### Development Steps:

#### 1. Project Setup:

1. **Create a New Android Project:**
   - Launch Android Studio, create a new project, and configure the project structure.

2. **Design User Interface:**
   - Develop login, registration, and main activity layouts using XML.
   - Include input fields for username, password, and necessary information.
   - Implement buttons for login, registration, and logout.

#### 2. Database Setup:

1. **Create Database Helper Class:**
   - Develop a `DatabaseHelper` class managing database creation and version management.
   - Define the table structure for storing user information.

2. **Implement User Data Source:**
   - Create a `UserDataSource` class to interact with the SQLite database.
   - Implement methods for user creation, retrieval, and other database operations.

#### 3. Login and Registration Logic:

1. **Login Activity:**
   - Develop the `Login` activity for user credential input.
   - Implement logic to validate login information against the database.
   - Save login status and username in shared preferences upon successful login.

2. **Registration Activity:**
   - Create the `Register` activity for user registration.
   - Implement logic to store user information in the SQLite database.

#### 4. Custom Notifications:

1. **NotificationHelper Class:**
   - Develop a `NotificationHelper` class to manage custom notifications.
   - Customize notification layout and appearance using XML.

2. **Show Notifications:**
   - Implement notification display in relevant parts of the app.
   - Utilize custom notification layouts for specific events like first-time login.

#### 5. MainActivity Logic:

1. **MainActivity:**
   - Develop the `MainActivity` class as the main screen post-login.
   - Check login status and redirect to the login screen if not logged in.
   - Display logged-in user information, including a custom notification for the first login.

#### 6. Logout Logic:

1. **Logout Functionality:**
   - Implement a logout button in the `MainActivity`.
   - Display a confirmation dialog before logging out.
   - Clear login status and navigate back to the login screen.

### Testing:

1. **Unit Testing:**
   - Conduct unit tests for critical components like database operations and login validation.
   - Ensure proper error handling and edge case testing.

2. **User Acceptance Testing:**
   - Test the app on various Android devices and screen sizes.
   - Validate user flows, including login, registration, and logout processes.

### Deployment:

1. **Prepare for Release:**
   - Optimize app performance and address identified issues during testing.
   - Generate a signed APK for release.

2. **Distribution:**
   - Publish the app on the Google Play Store or other desired platforms.

### Maintenance and Future Development:

1. **Continuous Improvement:**
   - Monitor user feedback and address reported issues promptly.
   - Consider adding new features or enhancements based on user needs.

2. **Security Considerations:**
   - Regularly review and update security measures to protect user data.
   - Stay informed about potential security vulnerabilities in dependencies.

# Update 0.2.0 Login App ⚡️

![Login App](https://github.com/brianlangay4/Login/assets/67788456/c16db399-4011-4d02-8ce3-72f533722686)

[View Video](https://github.com/brianlangay4/Login/assets/67788456/7a6ca0e1-78a3-4fb0-bf53-525a2808aa93)

**Layout Preview**

![Screenshot 1](https://github.com/brianlangay4/Login/assets/67788456/e5ff6f8e-c61a-4813-a119-4106b20f755b)

![Screenshot 2](https://github.com/brianlangay4/Login/assets/67788456/18e814fb-7bad-4ecd-addb-7291b4d4ec68)

![Screenshot 3](https://github.com/brianlangay4/Login/assets/67788456/df8c3d0c-d36a-4cc6-a25b-588c6f6b16ab)

# Part II

## Summary

### Logic
The app features a simple login system developed in Android Studio using Java. It includes user account creation, login functionality, and additional features related to the login system.

#### What's Included:
- Register user
- Login
- Password recovery

### Layout and Designs
The project contains simple XML designs and additional layout designs supported by Adobe XD for a straightforward layout design. Drawables are included in the project.

![Logic and Layout Plan](https://github.com/brianlangay4/Login/assets/67788456/77e6cd7d-e67e-4112-8e62-4e742c9b4504) ***Figure 01***

### Architecture
The login system is designed as depicted in Figure 01. It illustrates the layout plan and structure of the app, managing layout control from the loading activity to the user activity.

### Database Usage
For testing purposes or when there is a need to create an app with a local database system, SQLite is utilized. It is responsible for user management and the app's database, creating and accessing user information. The following are the full steps on how this app works and navigates with the collected data:

1. The application starts with a splash, showing the app's general representation—icon, name, and additional information.
2. The app establishes a background function to check if the user has logged in before. On success, the user is directed to the main view activity. If the user is not logged in, they are directed to the login page.
3. Within the login page, the user has options to either login or register a new user. On the login process, the user provides a username and password, then clicks the login button.
4. The login process checks if the username and password fields are empty. If successful, it continues to the next process.
5. It checks user existence and validation. If the username exists in the database, it then checks if the provided password belongs to this user. On success, it starts the user's main page view. If user information doesn't match, an error message is displayed.

## Updates
### 0.2.0
#### What's New 🚀
- Updated UI and retouched layout components for a better look and response.
- Updated message notifications and eliminated toast, only using custom notification popups.
- Can accept notification title and message.

#### New Look

![Login 0.2](https://github.com/brianlangay4/Login/assets/67788456/bff0e09e-8976-45ff-b34

e-7da240e90d60)

#### Full Video

[View Video](https://github.com/brianlangay4/Login/assets/67788456/1a2a5f42-2abb-4172-bd1b-4e5c97a28b00)
