# Hibernate quickstart template
This is a simple plain Hibernate Maven project, which can be handy to quickly try out some Hibernate code.

## Specs
* Maven project structure
* Hibernate Core 5.6.7
* Java Persistence API 2.2
* MariaDB database driver
* Local H2 database

## Usage
If you want to use the local H2 database:
1. Run the Main class.
2. Start the StartH2DatabaseManagerUI class to view the database in your browser.

If you want to configure your own database:
1. Add your database driver dependencies to /pom.xml.
2. Add your database driver class, jdbc url, username, password to /src/resources/META-INF/persistence.xml
3. Start the Main class. Database tables will be generated.
