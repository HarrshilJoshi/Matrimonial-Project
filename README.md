# Matrimonial Matchmaking System (Java OOP Project)

This is a console-based Matrimonial Matchmaking System developed using Java and Object-Oriented Programming (OOP) principles. It allows users to register, manage their profile, log in, and find compatible matches based on user preferences like age, religion, mother tongue, and caste. All user data is stored in a CSV file named `user5.csv`.

## Features

- User registration with personal and contact details.
- Secure login system using username and password.
- Profile management (update existing details).
- Matchmaking algorithm based on:
  - Age and acceptable age difference
  - Religion
  - Mother tongue
  - Optional caste filter
- Display of compatible users' basic details (name, age, occupation, residence, phone number).
- User data is stored and read from `user5.csv` using file handling in Java.

## Technologies Used

- Java (Core)
- Object-Oriented Programming (Encapsulation, Inheritance, Abstraction)
- File Handling (BufferedReader, BufferedWriter)
- CSV-based data storage

## How It Works

All the logic is written inside a single Java file named `oopproject.java`. When the program runs, the user is presented with options to register, log in, or exit. After logging in, users can view compatible profiles, edit their details, or exit the program.

The program uses classes such as:

- `personalDetails`: Stores user’s personal information. Some fields like salary, residence, and phone number are kept private and accessed using getters and setters.
- `User`: Handles username and password (kept private). Includes login checking and editing personal details.
- `Matchmaking`: Matches users based on age, religion, and mother tongue.
- `DisplayCompatibles`: Filters users based on preferences and displays compatible matches.
- `oopproject` (main class): Contains the `main` method and manages menu flow, user interactions, file reading/writing, and user search.

## File Structure

matrimonial-matchmaking-system/
├── oopproject.java # Java file containing the entire logic
├── user5.csv # CSV file storing all user data
├── README.md # Project documentation
## Sample CSV Format (user5.csv)

Each row in `user5.csv` represents one user in the following format:
username,password,name,fatherName,motherName,dob,gender,age,height,weight,occupation,salary,education,residence,motherTongue,religion,caste,phoneNumber



This file is automatically created/updated when users register or edit their profile.

## How to Run

1. Make sure you have Java installed.
2. Clone or download this repository.
3. Compile the Java file:javac oopproject.java
4. Run the program:java oopproject

5. Make sure the `user5.csv` file exists in the same folder. If not, it will be created after the first registration.

## Sample Flow

- **Register** → Enter all personal details → Saved in `user5.csv`
- **Login** → Enter username/password → Verified from file
- **Post-login Options**:
- Edit Personal Details
- View Compatible Users
- Exit

## Notes

- The application runs entirely in the console (terminal).
- All data is stored in plain CSV for simplicity. No database is used.
- Matchmaking is basic and meant for demonstration of logic, not for real-life use.


## Author

Developed by Harshil Joshi – B.Tech Student  
