# MyMaps Too

## Project overview
My Maps Too is an attempt at recreating the old Google My Maps Android app. The original app was sadly discontinued in 2021 and we’ve been missing the features ever since. We were not expecting to recreate any significant portion of the old app, but this is our attempt at recreating the core features. The app allowed users to save pins from Google Maps and add them to lists/maps to be reviewed as groups easily (ex: Places to visit during my upcoming trip). The APIs for this project were the Google Maps API and the Google Places API.

## Key features
1. Allow user to search locations (using the Google Places API) and view them on a map (Google Maps API).
2. (Incomplete) Allow user to create individual Maps containing pins/markers they saved.

## Team
* Steph ([@stephaniecp](https://github.com/stephaniecp)): QA Engineer with no prior Kotlin/Android dev experience
* Jon ([@jongarrison](https://github.com/jongarrison)): Sr. Software Engineer with no Kotlin/Android background but joining as mentor

## The parts that are not working with our app
* User is currently able to create multiple pins, there is however no functionality to save a bundle of pins/markers into individual maps or save them between app sessions yet.
* No implemented feature to remove pins/markers
* No feature to auto clear the search bar after adding a pin/marker
* No implemented solution for login/account management
* UI imperfect and contains obsolete/misleading page elements (not specific to this app)

## What we'd do to solve the above issues if we had more time
* Repurpose or remove page elements/fragments that are currently not useful
  * Mail icon in the lower right should be deleted
  * Three dots icon should allow user to log in/out
  * Hamburger menu (left side) should displayed the user’s individual maps saved (instead of the default “Home”, “Gallery”, “Slideshow” menu items)
  * Hamburger menu should also have an option to create a new map
* Enable user to create individual named maps with their respective pins
* Enable user to log in (possibly with their Google account by using OAth 2.0 via Google Sign-In API) and save their Maps on a server side.

## What we learned
* Android Kotlin basic skills
* Gradle basics
* Android Studio and sub tools: Logcat (for troubleshooting), phone emulator tool and the different view types for each project (Project, Android, etc)
* Navigating complex documentation
* Steps to initialize APIs and interact with them
* Art of stepping back and taking a deep breath when computers are not behaving as desired.

## Challenges
* No prior knowledge of Android development, Android Studio, Kotlin, Gradle, Maps SDK or Places SDK
* Difficulties related to using two closely linked APIs (Google Maps and Google Place)
  * Connecting both to the same API key (requiring referring to the api key in both AndroidManifest and from Kotlin code)
  * Interacting with one API (click to save a pin via Google Places API) and sharing results with the other (to display the pin via Google Maps API and add it to a list)
* Occasional outdated information in documentation and adapting examples from slightly different usage contexts, which we mostly resolved using Stack Overflow and other web forums.


## Problem solving approach
* Aimed at bite size features to implement sequentially
* Returned to the last known/working step in code using git
* Revisited the last steps of documentation before encountering an issue. Re-reading carefully and looking for any potential missed steps.
* Pasting error messages to Google when getting an error message that doesn't make sense to us.

## Documentation used
* [Google Places API for Android](https://developers.google.com/maps/documentation/places/android-sdk)
* [Google Maps Api for Android](https://developers.google.com/maps/documentation/android-sdk)
* [Kotlin official documentation](https://kotlinlang.org/docs/home.html)
* [StackOverflow](https://stackoverflow.co/)
* [Gradle](https://docs.gradle.org/current/userguide/userguide.html)

## Projects Links
* [Video presentation](https://youtu.be/Khw6K7a5ou0)
* [Slides deck](https://docs.google.com/presentation/d/1s1S1x6C409ImVLuniXUgWYiNP2WcIXDYVi5lBrcaveQ/edit?usp=sharing)


