# used-wilderness-8557

# Car Management System


This project is a car management system implemented in Java using the DAO pattern and Hibernate. It provides functionality for administrators to add, view, update, and delete cars, as well as manage customer accounts.

## Table of Contents

- [Description](#description)
- [Features](#features)
- [Installation](#Installation)
- [Usage](#usage)

## Description

This project is a car management system implemented in Java using the DAO pattern and Hibernate. It provides functionality for administrators to add, view, update, and delete cars, as well as manage customer accounts.

## Features
- Admin functionalities:
  - Add a new car
  - View all cars
  - Update car details
  - Delete a car
  - View a list of all customers
-  Customer functionalities:
    - User registration
    - User login
    - View available cars
    - Purchase a car
    - View purchased cars
    - Change password
    - Delete account

## Installation

- Clone the repository:
bash
Copy code

- Navigate to the project directory:

- Build the project using Maven:
mvn clean install

- Create a MySQL database and configure the database connection in the hibernate.cfg.xml file located in the src/main/resources directory:
xml
- Copy code
<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/SB101_Project</property>
<property name="hibernate.connection.username">your-username</property>
<property name="hibernate.connection.password">your-password</property>
- Run the project:
bash
Copy code
mvn exec:java -Dexec.mainClass="UI.MainUI"

### Usage

Upon running the project, you will be presented with a menu where you can choose to log in as an admin or a customer. Follow the on-screen prompts to perform the desired actions.
