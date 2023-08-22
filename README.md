# MovieCache

The goal of this project was to create a cache microservice that searches the cache for a resource and if it is not present, calls an external API for that resource and saves it in the cache for better performance. This project was an exercise for me in Java, Spring, Object-Oriented Programming, and Microservice Architecture.

Features/improvements I would like to add:
- The ability to save and return Ratings as a child class to the parent class Movie.
- If the user does not need an id returned, I could reduce the number of calls in the service.

### Technologies Used
1. Java
2. Spring
3. MySQL/JPA/Hibernate
4. Docker

### Install/Run Instructions
1. Once cloned, install Java/Spring dependencies needed on your local machine.
2. Install Docker if needed, clone MySQL Docker Image from Hub, run `docker-compose up` from project root.
3. Create movies table in database with `create-cache-table.sql`.
4. Run with `./gradlew bootRun` from root.
