// Common interface for database connections
interface DatabaseConnection {
    void connect();
}

// Common interface for query execution
interface QueryExecutor {
    void executeQuery(String query);
}

// MySQL connection implementation
class MySQLConnection implements DatabaseConnection {

    @Override
    public void connect() {
        System.out.println("Connected to MySQL database");
    }
}

// MySQL query executor implementation
class MySQLQueryExecutor implements QueryExecutor {

    @Override
    public void executeQuery(String query) {
        System.out.println("Executing MySQL query: " + query);
    }
}

// PostgreSQL connection implementation
class PostgreSQLConnection implements DatabaseConnection {

    @Override
    public void connect() {
        System.out.println("Connected to PostgreSQL database");
    }
}

// PostgreSQL query executor implementation
class PostgreSQLQueryExecutor implements QueryExecutor {

    @Override
    public void executeQuery(String query) {
        System.out.println("Executing PostgreSQL query: " + query);
    }
}

// Abstract factory for creating related database objects
public interface DatabaseFactory {

    DatabaseConnection createConnection();

    QueryExecutor createQueryExecutor();

    // Driver code
    static void main(String[] args) {

        // Create MySQL-related objects
        DatabaseFactory mysqlFactory = new MySQLFactory();

        DatabaseConnection mysqlConnection =
                mysqlFactory.createConnection();

        QueryExecutor mysqlExecutor =
                mysqlFactory.createQueryExecutor();

        mysqlConnection.connect();
        mysqlExecutor.executeQuery("SELECT * FROM users");

        System.out.println();

        // Create PostgreSQL-related objects
        DatabaseFactory postgreSQLFactory =
                new PostgreSQLFactory();

        DatabaseConnection postgreSQLConnection =
                postgreSQLFactory.createConnection();

        QueryExecutor postgreSQLExecutor =
                postgreSQLFactory.createQueryExecutor();

        postgreSQLConnection.connect();
        postgreSQLExecutor.executeQuery(
                "SELECT * FROM employees"
        );
    }
}

// Factory for creating MySQL objects
class MySQLFactory implements DatabaseFactory {

    @Override
    public DatabaseConnection createConnection() {
        return new MySQLConnection();
    }

    @Override
    public QueryExecutor createQueryExecutor() {
        return new MySQLQueryExecutor();
    }
}

// Factory for creating PostgreSQL objects
class PostgreSQLFactory implements DatabaseFactory {

    @Override
    public DatabaseConnection createConnection() {
        return new PostgreSQLConnection();
    }

    @Override
    public QueryExecutor createQueryExecutor() {
        return new PostgreSQLQueryExecutor();
    }
}