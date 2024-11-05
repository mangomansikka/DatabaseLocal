import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddEmployees {
    // JDBC URL, username, and password of HeidiSQL database
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/database_localization";
    private static final String USERNAME = "newuser";
    private static final String PASSWORD = "password";

    private final String languageCode;
    private final String name;
    private final String lastname;
    private final String email;
    private String sql;

    public AddEmployees(String languageCode, String name, String lastname, String email) {
        this.lastname = lastname;
        this.email = email;
        this.languageCode = languageCode;
        this.name = name;
    }

    public void AddEmployee() {
        switch (languageCode) {
            case "en" -> sql = "INSERT INTO employee_en (first_name, last_name, email) VALUES (?, ?, ?)";
            case "fa" -> sql = "INSERT INTO employee_fa (first_name, last_name, email) VALUES (?, ?, ?)";
            case "ja" -> sql = "INSERT INTO employee_ja (first_name, last_name, email) VALUES (?, ?, ?)";
        }

        try {
            // Load and register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish a connection to the database
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                // SQL query to insert records into the employees table

                // Prepare the SQL statement
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    // Insert employee records
                    statement.setString(1, name);
                    statement.setString(2, lastname);
                    statement.setString(3, email);
                    statement.executeUpdate();

                    System.out.println("Records inserted successfully.");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}