# Movie
Discover Top rated movies and thier details.

# Screenshots
![screenshot_20190221-144708](https://user-images.githubusercontent.com/28901635/53182334-f8e2ef80-3601-11e9-868e-f07c68c41596.png)
![screenshot_20190221-144737](https://user-images.githubusercontent.com/28901635/53182332-f8e2ef80-3601-11e9-897a-5d62ddd2e0aa.png)
![screenshot_20190221-175735](https://user-images.githubusercontent.com/28901635/53182542-58d99600-3602-11e9-9fb9-fc68907a4400.png)

# Getting Started
App uses The Movie Database API. 

### Application packages and structure
![capture](https://user-images.githubusercontent.com/28901635/53181497-524a1f00-3600-11e9-9002-84a40a4ec113.PNG)


# Project Overview
This project using  **Kotlin** demonstrate the applying for:
```
    1- Clean Architecture.
    2- MVVM architectural pattern.
    3- Dependency Injection using Dagger2.
    4- REST services using Retrofit2.
    5- Async / Observables using RxJava/ RxAndroid.
    6- Loading web images with Glide
    7- LiveData to hold data.
    8- Realm to create the database
    9- Parse Json data with Gson
```
# Presentation layer
```
Presentation package is responsible for everything related to showing Movies on the screen.
It's include the activities,adapters and ViewModels which exposes livedata that view observes it. Whenever livedata changes view gets notified and it re-render itself.
There is no logic inside them other than UI logic, and this is where all the rendering stuff takes place.
```
# Domain layer
```
Domain package: Business rules here. all the logic happens in this layer:
Models (entites): these are your business models that uses to manipulate in business logic.Like Movie, Genre, Trailer objects
Interactors (use cases) implementations here as well, these are the classes which actually contain business logic.
Repositories:This package only contains interfaces that the outer layer implements.These interfaces are used by Interactors to access and store data.
```
# Data layer
```
Data package: all data needed for the application comes from this layer through a repository implementation (the interface is in the domain layer) that uses a Repository to pick movies data.
```
### Dependency injection packages 
```
It's contain all the components and moduals to create Retrofit instance tied to the application lifecycle and available to all our activities  and room database object as well.
```
 

