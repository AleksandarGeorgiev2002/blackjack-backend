# Blackjack Card Game - Backend

## Overview
This project provides the backend logic for a Blackjack card game built with **Java**, **Spring Boot**, and **Gradle**. It handles the core game mechanics, user management, and game history tracking. The backend exposes RESTful APIs to enable players to interact with the game, manage accounts, and view their game history.

---

## Features
### User Management
- User registration and login functionality.
- Each user is uniquely identified and linked to their game history.

### Game Logic
- Implements the rules of Blackjack, including card dealing, scoring, and determining winners.
- Supports player actions like "Hit", "Stand", and "Double Down".
- Includes dealer logic (e.g., dealer must draw cards until reaching a score of 17 or higher).

### Game History
- Tracks details of each game, such as the game name, duration, end time, and the user who played.

### Persistence
- Stores user data and game history in a relational database.
- Uses **JPA** and **Hibernate** for database interactions.

### RESTful APIs
- Endpoints for user management, game actions, and retrieving game history.

---

## Key Components

### Game Logic
The backend implements the core rules of Blackjack:
- A shuffled deck of 52 cards is used.
- Players aim to get a hand value as close to 21 as possible without exceeding it.
- The dealer follows predefined rules for drawing cards.
- The game determines the winner based on hand values.

### Entities
#### `User`
Represents a player in the game. Each user has:
- A unique ID.
- Username and password for authentication.
- A relationship with their game history.

#### `GameHistory`
Tracks details of each game played:
- `gameId`: Unique identifier for the game.
- `user`: The user who played the game.
- `gameName`: Name of the game (e.g., "Blackjack").
- `gameEndTime`: Timestamp when the game ended.
- `duration`: Duration of the game.

### Database
The backend uses a relational database to persist data. Key tables include:
- `users`: Stores user information.
- `game_history`: Stores game history details.

### APIs
#### User Management
- `POST /users/register`: Register a new user.
- `POST /users/login`: Authenticate a user.

#### Game Actions
- `POST /game/start`: Start a new game.
- `POST /game/action`: Perform an action (e.g., "Hit", "Stand").
- `GET /game/status`: Retrieve the current game state.

#### Game History
- `GET /history`: Retrieve a user's game history.

---

## Technologies Used
- **Java**: Core programming language.
- **Spring Boot**: Framework for building the backend.
- **Gradle**: Build and dependency management tool.
- **JPA/Hibernate**: ORM for database interactions.
- **H2/MySQL**: Database for storing user and game data.

---

## How to Run
1. Clone the repository:
   ```bash
   git clone <repository-url>