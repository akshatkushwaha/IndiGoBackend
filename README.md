# IndiGo Flight Status and Notifications Service

## Description

This service provides the status of IndiGo flights and sends notifications to the user about the status of the flight.

## Database

PostgreSQL is used as the database for this service. The database schema is as follows:

### Flight

| Column Name      | Data Type   | Description                      |
|------------------|-------------|----------------------------------|
| flight_id        | Long        | Unique identifier for the flight |
| flightNumber     | VARCHAR(10) | Flight number                    |
| airline          | VARCHAR(10) | Airline name                     |
| departureAirport | Long        | Departure airport code           |
| arrivalAirport   | Long        | Arrival airport code             |
| departureTime    | TIMESTAMP   | Departure time                   |
| arrivalTime      | TIMESTAMP   | Arrival time                     |
| status           | VARCHAR(20) | Status of the flight             |
| gate             | VARCHAR(10) | Gate number                      |
| terminal         | VARCHAR(10) | Terminal number                  |

### Airport

| Column Name | Data Type   | Description                       |
|-------------|-------------|-----------------------------------|
| airport_id  | Long        | Unique identifier for the airport |
| airportCode | VARCHAR(10) | Airport code                      |
| airportName | VARCHAR(50) | Airport name                      |
| city        | VARCHAR(50) | City name                         |
| country     | VARCHAR(50) | Country name                      |

### User

| Column Name | Data Type   | Description                    |
|-------------|-------------|--------------------------------|
| user_id     | Long        | Unique identifier for the user |
| email       | VARCHAR(50) | Email address of the user      |
| phone       | VARCHAR(15) | Phone number of the user       |
| name        | VARCHAR(50) | Name of the user               |
| password    | VARCHAR(50) | Password of the user           |
| role        | VARCHAR(20) | Role of the user               |

### Subscription

| Column Name     | Data Type | Description                            |
|-----------------|-----------|----------------------------------------|
| subscription_id | Long      | Unique identifier for the subscription |
| user_id         | Long      | User identifier                        |
| flight_id       | Long      | Flight identifier                      |

## API

The service provides the following APIs:

### Flight

| Method | Path                 | Description      | Request Body | Response        |
|--------|----------------------|------------------|--------------|-----------------|
| GET    | /flights             | Get all flights  | None         | List of flights |
| GET    | /flights/{flight_id} | Get flight by id | None         | Flight          |
| POST   | /flights             | Add a new flight | Flight       | Flight          |
| PUT    | /flights/{flight_id} | Update flight    | Flight       | Flight          |
| DELETE | /flights/{flight_id} | Delete flight    | None         | None            |

### Airport

| Method | Path                   | Description       | Request Body | Response         |
|--------|------------------------|-------------------|--------------|------------------|
| GET    | /airports              | Get all airports  | None         | List of airports |
| GET    | /airports/{airport_id} | Get airport by id | None         | Airport          |
| POST   | /airports              | Add a new airport | Airport      | Airport          |
| PUT    | /airports/{airport_id} | Update airport    | Airport      | Airport          |
| DELETE | /airports/{airport_id} | Delete airport    | None         | None             |

### User

| Method | Path             | Description    | Request Body | Response      |
|--------|------------------|----------------|--------------|---------------|
| GET    | /users           | Get all users  | None         | List of users |
| GET    | /users/{user_id} | Get user by id | None         | User          |
| POST   | /users           | Add a new user | User         | User          |
| PUT    | /users/{user_id} | Update user    | User         | User          |
| DELETE | /users/{user_id} | Delete user    | None         | None          |

### Subscription

| Method | Path                              | Description                          | Request Body | Response     |
|--------|-----------------------------------|--------------------------------------|--------------|--------------|
| POST   | /subscriptions                    | Add a new subscription               | Subscription | Subscription |
| DELETE | /subscriptions/{subscription_id}  | Delete subscription                  | None         | None         |
| DELETE | /subscriptions/user/{user_id}     | Delete all subscriptions of a user   | None         | None         |
| DELETE | /subscriptions/flight/{flight_id} | Delete all subscriptions of a flight | None         | None         |

## Notifications

The service sends notifications to the user about the status of the flight. The notifications are sent via email and SMS.

## How to Run

1. Clone the repository:

```bash
git clone
```

2. Go to the project directory:

```bash
cd IndiGoBackend
```

3. Run Docker Compose:

```bash
docker-compose up
```

4. Run the application:

```bash
./mvnw spring-boot:run
```



