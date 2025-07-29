# Advanced Java Core: Users Database

## Overview

This is a Java project which use CLI. You can do Create/Read/Delete functions and more operations with users.
Project was my learning project at SkillBox. In that project I used: OOP, Collections.

---

## Technology 

- OpenJDK24
- Library: Scanner
- IDE: IntelliJ IDEA 
- Collections: TreeMap, ArrayList
---

## Feature
- Add new user
- Delete user by value
- Count all users in the database
- Average age of all users
- Median age of all users
- Youngest/Oldest user
- Read all users

---

## Project architecture
```
src/
└── java_string_and_dates/
    ├── CollectionsAdvanced.java
    ├── model/
    │   └── User.java
    └── services/
        ├── FindUser.java
        └── MenuNavigator.java

```
### Description
```
- CollectionsAdvanced.java           #Entery point
- model/User.java                    # Record class
- services/FindUser.java 
  - optionIn()
  - optionDel()
  - optionCount()
  - optionAvg()                     # Show average age
  - optionMedian()                  # Show median age
  - optionYoung()
  - optionOld()
  - optionPrint()                   # Print all users sorted by age
  - optionHelp()
  - optionExit() 
- services/MenuNavigator.java                    
  - showMenu()                      # Using for input option
  - checkOption(FindUser findUser)              
```
---

## How to Run

To run the project locally:

```
git clone https://github.com/mihaidaniel-it/UsersDatabase.git

cd java_core_advanced     

javac UsersDatabase.java

java UsersDatabase
```
---

## Future Improvements
- Add unit tests with JUnit
- Optimization of data storage and processing (Hash, index)
- connecting an external database
---


## Author

- **Developed:** Mihai Daniel
- **Email:** [mihaidaniel.it@gmail.com](mailto:mihaidaniel.it@gmail.com)
