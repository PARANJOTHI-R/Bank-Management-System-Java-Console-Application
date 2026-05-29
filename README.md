# Bank-Management-System-Java-Console-Application
This project is a console-based Bank Management System developed using Java with a role-based design approach. The system simulates basic banking operations while maintaining separation between administrative and customer authorities.

## The project was built primarily 
as a learning-oriented application to understand Java programming concepts, Object-Oriented Programming principles, data structures, file handling, and system design rather than to create a production-level banking application.

The system allows two types of users:

# Admin (Bank Staff)

Admin represents the bank management or cashier side and has authority to manage banking operations.

## Admin features include:

Create customer accounts
View all accounts
Search accounts
Deposit money
Withdraw money
Transfer money between accounts
Delete accounts
Save and load account data
Customer (Account Holder)

# Customer represents the account owner and has limited authority restricted to their own account.

## Customer features include:

Login using account number
View account details
Check balance
Deposit money
Withdraw money
Transfer money
Logout

The system automatically generates a unique random 16-digit account number during account creation and initializes every newly created account with zero balance.

Account information is stored using Java serialization and persists through file handling.

# Technologies Used
Java
Java Collections Framework
Java File Handling
Java Serialization
Console-Based User Interface
