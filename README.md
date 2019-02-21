# Movie
Discover Top rated movies and thier details.

# Screenshots
![screenshot_20190221-144708](https://user-images.githubusercontent.com/28901635/53182334-f8e2ef80-3601-11e9-868e-f07c68c41596.png)
![screenshot_20190221-144737](https://user-images.githubusercontent.com/28901635/53182332-f8e2ef80-3601-11e9-897a-5d62ddd2e0aa.png)
![screenshot_20190221-175735](https://user-images.githubusercontent.com/28901635/53182542-58d99600-3602-11e9-9fb9-fc68907a4400.png)

# Getting Started
App uses The Movie Database API. 

# Screen to App packages and structure
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
It's include the activities,adapters and ViewModels which handle rendering views.
There is no logic inside them other than UI logic, and this is where all the rendering stuff takes place.
```
# Domain layer
```
Domain package: Business rules here. all the logic happens in this layer.Contains:
Models (entites): these are your business models that uses to manipulate in business logic.
Interactors (use cases) implementations here as well, these are the classes which actually contain business logic.
All the external components use interfaces when connecting to the this layers.
```

 

