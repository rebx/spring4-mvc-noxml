# spring4-mvc-noxml
My base Spring 4 MVC application with no xml configuration.

### Dependencies
* Java 7
* Maven
* A container that supports the servlet 3 spec (needed for spring 4 annotation config)

### Building the application

1. Initially run mvn clean dependency:sources to ensure you have all the dependency jars.
2. Run mvn clean package to build the war file

### Running the app

    Copy the war file to your container's specified location and start the container.

