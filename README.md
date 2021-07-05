# simple-movie-app-mvvm-kotlin
For the development of this mobile app I’ve used MVVM as design architecture, Retrofit for handling API calls and coroutines to simplify code that executes asynchronously. 

# Create account on themoviedb.org
<img src="https://github.com/stef1codes/simple-movie-app-mvvm-kotlin/blob/master/app/src/main/res/drawable-hdpi/moviedb.PNG" width=300>


In order to make the mobile app work, you have to create an account on https://www.themoviedb.org/ . Go to the settings page  of your account  and search for API. Copy the API-key and pasted it the class called UrlCredentials.kt 
   
   "const val API_KEY  = "YOUR API KEY HERE"


<img src="https://github.com/stef1codes/simple-movie-app-mvvm-kotlin/blob/master/app/src/main/res/drawable-hdpi/screenshot_1624560168.png" width=250> <img src="https://github.com/stef1codes/simple-movie-app-mvvm-kotlin/blob/master/app/src/main/res/drawable-hdpi/screenshot_1624560175.png" width=250>  <img src="https://github.com/stef1codes/simple-movie-app-mvvm-kotlin/blob/master/app/src/main/res/drawable-hdpi/screenshot_1624560186.png" width=250>


# Design architecture
- MVVM(Model, View, ViewModel)

# Technologies
- Android, Kotlin
- The Movie Database
- Retrofit 
- OkHttp - Interceptor
- Coroutines
- Glide
