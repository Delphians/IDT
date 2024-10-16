# Description:
The app downloads USA states and displays 2 columns: full list and filtered list. 
Click on a state to check the details about a state. 
Use "Search a state" to filter out the states by letters.
"Open in a second screen" button isn't supported 

# The app supports Android Tablets only (Portrait or Landscape) 

# Tech stack of the base project:   
    `Clean Architecture, Single Activity, MVVM, Hilt/Dagger, Coroutines, 
     Jetpack Compose, Material3, Mockk`

# The structure of the project:

* `app`               - Main module
* `data`              - Remote data sources and the repository 
* `domain`            - Business logic and fake data 

# What the app allows you to do? 

* The project supports `Loading` and `Exception handling`
* The project supports `Light` and `Dark` mode, `rotation of a screen`
* Start the static code analysis using Detekt - `./gradlew detekt`  
* Tests - `Data module: RemoteDatasourceTest, UsaStateRepositoryImplTest; 
           Domain module: UsaStateUseCaseImplTest`
* Analyzing dependencies for vulnerabilities - `./gradlew dependencyCheckAnalyze`

# Future plans

* It's necessary to add a convention plugin for unification Gradle logic 

# If you have any questions

    https://www.linkedin.com/in/igor-chebotarev 
  