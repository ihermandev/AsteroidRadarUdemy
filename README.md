# Project Title

Asteroid Radar

## Getting Started

Asteroid Radar is an app to view the asteroids detected by NASA that pass near Earth, you can view all the detected asteroids in a period of time, their data (Size, velocity, distance to Earth) and if they are potentially hazardous.

The app is consists of two screens: A Main screen with a list of all the detected asteroids and a Details screen that is going to display the data of that asteroid once it´s selected in the Main screen list. The main screen will also show the NASA image of the day to make the app more striking.

This kind of app is one of the most usual in the real world, what you will learn by doing this are some of the most fundamental skills you need to know to work as a professional Android developer, as fetching data from the internet, saving data to a database, and display the data in a clear, clear, compelling UI.

### Screenshots

![Screenshot 1](screenshots/screen_1.png)
![Screenshot 2](screenshots/screen_2.png)
![Screenshot 3](screenshots/screen_3.png)
![Screenshot 4](screenshots/screen_4.png)

### Dependencies

```
    // Kotlin
    implementation"org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"

    // Android
    implementation "androidx.appcompat:appcompat:$appcompat_version"
    implementation "androidx.core:core-ktx:$core_version"
    implementation "androidx.constraintlayout:constraintlayout:$constraint_layout_version"

    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_extensions_version"
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_extensions_version"

    implementation "androidx.fragment:fragment-ktx:$fragment_ktx_version"

    implementation "androidx.recyclerview:recyclerview:$recyclerview_version"

    // Navigation
    implementation "androidx.navigation:navigation-fragment-ktx:$navigation_version"
    implementation "androidx.navigation:navigation-ui-ktx:$navigation_version"

    //Moshi
    implementation "com.squareup.moshi:moshi:$moshi_version"
    implementation "com.squareup.moshi:moshi-kotlin:$moshi_version"

    // Retrofit
    implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
    implementation "com.squareup.retrofit2:converter-moshi:$retrofit_converter_version"
    implementation "com.squareup.retrofit2:converter-scalars:$retrofit_converter_version"

    //    Coroutines - Deprecated - No more required
    //    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinx_coroutines_version"
    //    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:$kotlinx_coroutines_version"
    //    implementation "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:$kotlinx_coroutines_adapter_version"

    // Picasso
    implementation "com.squareup.picasso:picasso:$picasso_version"

    //Room
    implementation "androidx.room:room-runtime:$room_version"
    implementation "androidx.room:room-ktx:$room_version"
    kapt "androidx.room:room-compiler:$room_version"

    //WorkManager
    implementation "androidx.work:work-runtime-ktx:$work_manager_version"

    //Logger
    implementation "com.jakewharton.timber:timber:$timber_version"

    //Testing
    testImplementation "junit:junit:$junit_version"
    androidTestImplementation "androidx.test.ext:junit:$androidx_ext_junit_version"
    androidTestImplementation "androidx.test.espresso:espresso-core:$androidx_espresso_core_version"
```

### Installation

To get the project running on your local machine, you need to follow these steps:

**Step 1: Clone the repo**

Use this to clone it to your local machine:
```bash
git clone https://github.com/udacity/REPOSITORY_NAME.git
```

**Step 2: Check out the ‘master’ branch**

This branch is going to let you start working with it. The command to check out a branch would be:

```bash
git checkout master
```

**Step 3: Run the project and check that it compiles correctly**

Open the project in Android Studio and click the Run ‘app’ button, check that it runs correctly and you can see the app in your device or emulator.

```
Examples here
```
## Project Instructions

You will be provided with a starter code, which includes the necessary dependencies and plugins that you have been using along the courses and that you are going to need to complete this project.

The most important dependencies we are using are:
- Retrofit to download the data from the Internet.
- Moshi to convert the JSON data we are downloading to usable data in form of custom classes.
- Glide to download and cache images.
- RecyclerView to display the asteroids in a list.

We recommend you following the guidelines seen in the courses, as well as using the components from the Jetpack library:
- ViewModel
- Room
- LiveData
- Data Binding
- Navigation

Android Studio could display a message to update Gradle plugin, or another thing like Kotlin, although it is recommended to have the last versions, it could be you have to do other things in order to make it work.

The application you will build must:
- Include Main screen with a list of clickable asteroids as seen in the provided design.
- Include a Details screen that displays the selected asteroid data once it’s clicked in the Main screen as seen in the provided design. The images in the details screen are going to be provided here, an image for a potentially hazardous asteroids and another one for the non potentially hazardous ones.
- Download and parse data from the NASA NeoWS (Near Earth Object Web Service) API.
- Save the selected asteroid data in the database using a button in details screen.
- Once you save an asteroid in the database, you should be able to display the list of asteroids from web or the database in the main screen top menu.
- Be able to cache the asteroids data by using a worker, so it downloads and saves week asteroids in background when device is charging and wifi is enabled.
- App works in multiple screen sizes and orientations, also it provides talk back and push button navigation.


## Built With

To build this project you are going to use the NASA NeoWS (Near Earth Object Web Service) API, which you can find here.
https://api.nasa.gov/

You will need an API Key which is provided for you in that same link, just fill the fields in the form and click Signup.

## Important

In order to run project properly you need to create "keystore" folder in project root directory, after this step put "project.properties" file which store "nasa api_key=YOUR_API_KEY" variable inside "keystore" folder.

![Directory example](screenshots/important_notice.png)

or as an alternative option

Remove this piece of implementation in app:build.gradle

```
def keystorePropertiesFile = rootProject.file("keystore/project.properties")
def keystoreProperties = new Properties()
keystoreProperties.load(new FileInputStream(keystorePropertiesFile))
```

and modify NASA_API_KEY build config variable with your nasa api key

```
buildConfigField "String", "NASA_API_KEY", "YOUR_API_KEY"
```


## License


