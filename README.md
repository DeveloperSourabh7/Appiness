


![App Screenshot](https://www.appinessworld.com/assets/images/appiness-logo.svg)


# Appiness

This is the repository for the Android Assignment Task provided by Appiness Interactive


## Features

- By Clicking the phone icon, it should direct to the default dialer in the device the phone number.
- By Clicking the message icon, it should direct to the default messaging app with the phone number.
- Implement a local search function
- App should not crash with any scenario, even if the responses are not proper


## Screenshots

Any additional information goes here


## Development Environment

Now in Android uses the Gradle build system and can be imported directly into the latest stable version of Android Studio (available [here](https://developer.android.com/studio)). The debug build can be built and run using the default configuration.

Once you're up and running, you can refer to the learning journeys below to get a better understanding of which libraries and tools are being used, the reasoning behind the approaches to UI, testing, architecture and more, and how all of these different pieces of the project fit together to create a complete app.

NOTE: Building the app using an M1 Mac will require the use of Rosetta. See the following bug for more details.


## Architecture

The app follows the MVVM Architecture. Model—View—ViewModel (MVVM) is the industry-recognized software architecture pattern that suggests separating the data presentation logic(Views or UI) from the core business logic part of the application. 
The separate code layers of MVVM are:

    1. Model: This layer is responsible for the abstraction of the data sources. Model and ViewModel work together to get and save the data.
	2. View: The purpose of this layer is to inform the ViewModel about the user’s action. This layer observes the ViewModel and does not contain any kind of application logic.
    3. ViewModel: It exposes those data streams which are relevant to the View. Moreover, it servers as a link between the Model and the View.

The Appiness Android app follows the [official architecture guidance](https://developer.android.com/topic/architecture) and is described in detail in the [architecture learning journey](https://github.com/android/nowinandroid/blob/main/docs/ArchitectureLearningJourney.md).
## UI

UI components are designed according to [Material 3](https://m3.material.io/) guidelines and built in XML layouts.

The app has two themes:

Dynamic color - uses colors based on the [user's current color theme](https://material.io/blog/announcing-material-you) (if supported)
Default theme - uses predefined colors when dynamic color is not supported
Each theme also supports dark mode.

The app uses adaptive layouts to [support different screen sizes](https://developer.android.com/guide/topics/large-screens/support-different-screen-sizes).

Find out more about the [UI architecture here](https://github.com/android/nowinandroid/blob/main/docs/ArchitectureLearningJourney.md#ui-layer).

## Build

The app contains the usual debug and release build variants.


## License

Now in Android is distributed under the terms of the Apache License (Version 2.0). See the [license](https://github.com/android/nowinandroid/blob/main/LICENSE) for more information.

