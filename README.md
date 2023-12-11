# Login with android studio

##
BRIAN BARNABAS LANGAY
##
2322190027
##

#
Part i
#

#
overview
# 

##
current state screenshots
##


[rec.webm](https://github.com/brianlangay4/Login/assets/67788456/7a6ca0e1-78a3-4fb0-bf53-525a2808aa93)

**Layout preview**

<img width="227" alt="Screenshot 2023-12-11 at 07 17 47" src="https://github.com/brianlangay4/Login/assets/67788456/e5ff6f8e-c61a-4813-a119-4106b20f755b">


<img width="221" alt="Screenshot 2023-12-11 at 07 23 21" src="https://github.com/brianlangay4/Login/assets/67788456/18e814fb-7bad-4ecd-addb-7291b4d4ec68">


<img width="221" alt="Screenshot 2023-12-11 at 07 20 41" src="https://github.com/brianlangay4/Login/assets/67788456/df8c3d0c-d36a-4cc6-a25b-588c6f6b16ab">





***##Logic##*** 
the app contains simple login system in Android studio project with java 
the app is fully designed to create a user account , login and more littele extra features about loging System 

whats included 
Register user
Login
Password recovery 


Layout and designs 
the projects contain simple xml designs and additional layout design  support from adobe xd for simple layout desin drawables included in project

#
Part ii
#


<img width="730" alt="logic and layout plan" src="https://github.com/brianlangay4/Login/assets/67788456/77e6cd7d-e67e-4112-8e62-4e742c9b4504">

**
figure 01
**

Architect 

the login System is designed as above picture fig01 structure 
shows the layout plan and structure of the app Control management of layout from main activity to the user activity 

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




