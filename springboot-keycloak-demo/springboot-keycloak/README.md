Steps to Run the Application:

Ensure Docker is running.

Navigate to your project directory:
cd [Project Path]
Start the required services and run the Spring Boot application:
docker-compose up -d && mvn spring-boot:run

Once the Spring Boot application has started, open your browser and visit:
http://localhost:8081/
You will be redirected to the Keycloak login page.
Enter the following credentials:

Username: test
Password: test

After successful login, you will gain access to the protected resource.

