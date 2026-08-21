# ✈️ Airline Reservation System

A Java-based console application that allows users to view flights, book tickets, cancel tickets, and maintain passenger travel information.

The project also includes additional features such as passenger behavior scoring, trip-purpose-based pricing, preferred route tracking, and risk-based booking.

## 🚀 Features:

- ✈️ View available flights
- 🎫 Book airline tickets
- ❌ Cancel tickets
- 👤 Passenger profile management
- 📊 Passenger Behavior Score
- 🧳 Trip Purpose selection
- 💰 Dynamic ticket pricing
- ⚠️ 
- 🪑 Automatic seat assignment
- 💾 Persistent user data using files
- 🛫 Preferred route tracking

## 🧠 Special Features

### Passenger Behavior Score

A passenger's score is calculated based on their previous trips and cancellations.

```text
Score = (Trips × 10) - (Cancellations × 15)
```

Passengers with a negative score are marked as risky.

## Trip Purpose Pricing

The ticket price changes depending on the purpose of the trip:

Vacation → ₹500 additional charge
Business → Normal price
Emergency → ₹1000 discount
Risk Mode

Passengers can choose a risk-based booking option.

The system randomly determines whether the passenger receives an upgrade or the last available seat.

Preferred Route

The passenger's most recently booked route is stored as their preferred route.

## 🛠️ Technologies Used
Java
Object-Oriented Programming
File Handling
ArrayList
Random
Scanner

## 📂 Project Structure
```
AirlineReservation/
│
├── AirlineReservation.java
├── users.txt
└── README.md
```
## ▶️ How to Run

Compile the program:
```
javac AirlineReservation.java
```
## Run the program:
```
java AirlineReservation
```

## 📋 Main Menu
--- Airline System ---
1. View Flights
2. Book Ticket
3. Cancel Ticket
4. Exit
💾 Data Storage

Passenger information is stored in a users.txt file using Java file handling.

The stored information includes:
```
Passenger name
Behavior score
Number of trips
Number of cancellations
Preferred route
```
## 🎯 Learning Objectives

This project demonstrates:
```
Java classes and objects
Constructors
ArrayList
File input/output
Exception handling
User input using Scanner
Conditional logic
Random number generation
Basic data persistence
```

## 🔮 Future Improvements
```
Database integration using MySQL
Graphical User Interface
Interactive seat selection
Flight search and filtering
Login and authentication
Payment integration
Real-time flight availability
Weather-based flight information
```
