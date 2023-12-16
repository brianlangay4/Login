# Login with android studio

![login0 2](https://github.com/brianlangay4/Login/assets/67788456/bff0e09e-8976-45ff-b34e-7da240e90d60)

##
#BRIAN BARNABAS LANGAY
2322190027
##

#  part i
# App Development Process Document

## Project Overview:

The goal of this project is to create an Android app with login and registration functionality. The app utilizes SQLite for user data storage and includes custom notifications for various events. The primary programming languages used are Java for Android development, SQL for database operations, and XML for layout design.

## Development Tools:

- Android Studio: The official integrated development environment (IDE) for Android app development.
- SQLite Database: A lightweight, embedded database used for storing user information locally on the device.
- Java: The primary programming language for Android app development.
- XML: Used for defining the app's layout and appearance.

## Development Steps:

### 1. Project Setup:

1. **Create a New Android Project:**
   - Launch Android Studio and create a new Android project with an appropriate name.
   - Choose the target Android device and set up the project structure.

2. **Design User Interface:**
   - Design the login, registration, and main activity layouts using XML.
   - Include input fields for username, password, and other required information.
   - Implement buttons for login, registration, and logout.

### 2. Database Setup:

1. **Create Database Helper Class:**
   - Develop a `DatabaseHelper` class to manage database creation and version management.
   - Define the table structure for storing user information, including columns for username, password, etc.

2. **Implement User Data Source:**
   - Create a `UserDataSource` class to interact with the SQLite database.
   - Implement methods for user creation, retrieval, and other database operations.

### 3. Login and Registration Logic:

1. **Login Activity:**
   - Develop the `Login` activity where users can enter their credentials.
   - Implement logic to validate login information against the database.
   - Save login status and username in shared preferences upon successful login.

2. **Registration Activity:**
   - Create the `Register` activity for user registration.
   - Implement logic to store user information in the SQLite database.

### 4. Custom Notifications:

1. **NotificationHelper Class:**
   - Develop a `NotificationHelper` class to handle the display of custom notifications.
   - Customize the layout and appearance of notifications using XML.

2. **Show Notifications:**
   - Implement the display of notifications in relevant parts of the app.
   - Utilize custom notification layouts for specific events like first-time login.

### 5. MainActivity Logic:

1. **MainActivity:**
   - Develop the `MainActivity` class as the main screen after login.
   - Check the login status and redirect to the login screen if not logged in.
   - Display the logged-in user's information, including a custom notification if it's their first login.

### 6. Logout Logic:

1. **Logout Functionality:**
   - Implement a logout button in the `MainActivity`.
   - Display a confirmation dialog before logging out.
   - Clear login status and navigate back to the login screen.

## Testing:

1. **Unit Testing:**
   - Conduct unit tests for critical components such as database operations, login validation, and notification display.
   - Ensure proper error handling and edge case testing.

2. **User Acceptance Testing:**
   - Test the app on different Android devices and screen sizes.
   - Validate user flows, including login, registration, and logout processes.

## Deployment:

1. **Prepare for Release:**
   - Optimize the app's performance and resolve any issues identified during testing.
   - Generate a signed APK for release.

2. **Distribution:**
   - Publish the app on the Google Play Store or any other desired distribution platform.

## Maintenance and Future Development:

1. **Continuous Improvement:**
   - Monitor user feedback and address reported issues promptly.
   - Consider adding new features or enhancements based on user needs.

2. **Security Considerations:**
   - Regularly review and update security measures to protect user data.
   - Stay informed about potential security vulnerabilities in dependencies.

By following these development steps, the app should provide a seamless user experience with robust login functionality, secure data storage, and engaging custom notifications. Regular updates and improvements will ensure the app's longevity and user satisfaction.
##

#update 0.2.0 Login App ⚡️

![fb377433-2cf8-488f-83dc-e2da47e791ae](https://github.com/brianlangay4/Login/assets/67788456/c16db399-4011-4d02-8ce3-72f533722686)


[rec.webm](https://github.com/brianlangay4/Login/assets/67788456/7a6ca0e1-78a3-4fb0-bf53-525a2808aa93)

**Layout preview**

<img width="227" alt="Screenshot 2023-12-11 at 07 17 47" src="https://github.com/brianlangay4/Login/assets/67788456/e5ff6f8e-c61a-4813-a119-4106b20f755b">


<img width="221" alt="Screenshot 2023-12-11 at 07 23 21" src="https://github.com/brianlangay4/Login/assets/67788456/18e814fb-7bad-4ecd-addb-7291b4d4ec68">


<img width="221" alt="Screenshot 2023-12-11 at 07 20 41" src="https://github.com/brianlangay4/Login/assets/67788456/df8c3d0c-d36a-4cc6-a25b-588c6f6b16ab">





<h2>Logic<h2/>
the app contains simple login system in Android studio project with java 
the app is fully designed to create a user account , login and more littele extra features about loging System 

whats included 
Register user
Login
Password recovery 


Layout and designs 
the projects contain simple xml designs and additional layout design  support from adobe xd for simple layout desin drawables included in project

#  Part ii


<img width="730" alt="logic and layout plan" src="https://github.com/brianlangay4/Login/assets/67788456/77e6cd7d-e67e-4112-8e62-4e742c9b4504">

                                        ***figure 01***

<h2>Architect<h2/>

##
the login System is designed as above picture fig01 structure 
shows the layout plan and structure of the app Control management of layout from loading activity to the user activity 
##

***the app uses sqlite for testing purpose or if need to create app with local database system the sqlite is respnsible for usermanagement database of this app creating user and accessing user information below we have the full steps on how this app works and navigate with the data collected***

1st the application will start with the splash showing the application general representation the app main icon and the app name and extra
2nd the app will establish another background function of checking if the user has logged in before and on Success the app willdirect the user to main vuiew activity 
which is is the user activity else if user is not logged in before the  user will be directed to the login page 
3rd within the login page user will have multiple options first to login or register new user on login process the user will have to provide the username and password then 
can hit login button 

4th on login clicked  function onced triggered the login process will begin first condition the function will check if the username edittext is empty on success 
will check if the password edittext is empty if any of this fields is empty display error message "field cannot be empty" on success if both have strings (data/inputs) 
Continue to next process

5th checking user existance and validation if username exists in database then check the password is belongs to this user on success start user main page view else
if user information doesn’t match display error message "user credentials not correct "


# Updates 
## 0.2.0
#
whats new 🚀
updated ui an retouched layout components for better looking and response
updated messsage notification and i gonore toast to only using custom notification popup
can accept notificationn tittle and message.

new look

![login0 2](https://github.com/brianlangay4/Login/assets/67788456/bff0e09e-8976-45ff-b34e-7da240e90d60)

full video

[login0.2.webm](https://github.com/brianlangay4/Login/assets/67788456/1a2a5f42-2abb-4172-bd1b-4e5c97a28b00)











