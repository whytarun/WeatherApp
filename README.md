# Weather App

## Overview
The **Weather App** is a simple yet elegant application designed to display weather information for a single **saved city**. The app provides the following features:

- **City Name**: Displays the name of the saved city.
- **Temperature**: Shows the current temperature in the city.
- **Weather Condition**: Includes a corresponding weather icon fetched from the API.
- **Humidity (%)**: Displays the current humidity percentage.
- **UV Index**: Provides the UV index for the city.
- **Feels Like Temperature**: Displays the temperature adjusted to how it actually feels.

---

## Technologies Used

This project is built using modern Android development practices and tools:

- **MVVM with Clean Architecture**: For robust, scalable, and maintainable design patterns.
- **Hilt**: Dependency injection framework to manage object creation and lifecycle.
- **Jetpack Compose**: Modern UI toolkit for building native Android UIs.
- **Retrofit & OkHttp**: For making network requests and handling API communication.
- **DataStore**: To save and persist the user's selected city data.
- **Room Database**: Integrated for future storage and offline support.
- **Moshi**: Used for efficient JSON parsing, ensuring seamless communication with the weather API.

---

## API
This project fetches weather data from [WeatherAPI](https://www.weatherapi.com/). You’ll need an API key from WeatherAPI to run the application.

---

## Setup Instructions

### Running the Project Locally
To set up and run the project locally, ensure you have the following dependencies:

1. **Android Studio**: The IDE for Android development.
2. **Android SDK**: Installed via Android Studio.

Follow these steps:

1. Clone the repository:
   ```bash
   git clone https://github.com/whytarun/WeatherApp.git
2. Open the project in Android Studio by pointing to the root folder containing the build.gradle file.

3. Build the project successfully in Android Studio.
4. Obtain an API key from WeatherAPI and add it to the app's configuration file (local.properties or equivalent).

## ScreenShot
![image alt](https://github.com/whytarun/WeatherApp/blob/fe407e5d0722a6ae7b9991e91d080bb9d73a8902/NoCity_SelectedScreen.png)
![image alt](https://github.com/whytarun/WeatherApp/blob/fe407e5d0722a6ae7b9991e91d080bb9d73a8902/SearchScreen_weather.png)
![image alt](https://github.com/whytarun/WeatherApp/blob/fe407e5d0722a6ae7b9991e91d080bb9d73a8902/SearchResutScreen.png)
![image alt](https://github.com/whytarun/WeatherApp/blob/fe407e5d0722a6ae7b9991e91d080bb9d73a8902/homeScreen_weather.png)





