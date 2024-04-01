**Project Name : BANK**

**Description**

This project implements a RESTful API for managing user accounts. It provides endpoints to create new accounts, connect them to existing users, and retrieve user information including name, surname, balance, and transactions.

**Features**

Exposes an endpoint to create a new account with user information (customerID, initialCredit).
Opens a new account connected to the specified user ID (customerID).
Sends a transaction to the new account if the initialCredit is not 0.
Provides an endpoint to retrieve user information, including Name, Surname, balance, and transactions of the accounts.

**Installation**

Clone the repository:

git clone <repository_url>

**IMPORTANT : CUSTOMERS ID :
123456 - 789012 -345678**

**API Endpoints**

Create Account

URL: /api/account

Method: POST

Request Body:
{
"customerId": "123456",
"initialCredit": 1000
}

**Description**: Creates a new account connected to the specified customer ID. If initialCredit is provided and not 0, a transaction will be sent to the new account.

**Get User Information**

URL: /api/account/{customerId}
Method: GET
Description: Retrieves user information including Name, Surname, balance, and transactions of the accounts associated with the specified customer ID.

Example :/api/account/123456

**Example response :**
`{
"name": "Youssef",
"surname": "surname1",
"balance": null,
"accountDTOS": [
{
"accountId": "e3ac6aba-4a97-4132-aa0f-25cacb53df0f",
"customerId": "123456",
"balance": 10,
"accountType": null,
"transactions": [
{
"transactionId": "76e3c68e-e709-409d-80d8-8c8d602fbaa2",
"accountId": "e3ac6aba-4a97-4132-aa0f-25cacb53df0f",
"amount": 10
}
]
},
{
"accountId": "24712afb-e99b-47e4-b11a-e0d9012f4eb6",
"customerId": "123456",
"balance": 0,
"accountType": null,
"transactions": null
}
]
}`


License
This project is licensed under the MIT License.
