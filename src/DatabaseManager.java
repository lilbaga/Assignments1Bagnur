import java.sql.*;

public class DatabaseManager {

    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "baxa2007aitu";

    public void saveParticipant(Participant p) throws SQLException {

        String createTableSql = "CREATE TABLE IF NOT EXISTS participants (" +
                "id SERIAL PRIMARY KEY, " +
                "first_name VARCHAR(50), " +
                "last_name VARCHAR(50), " +
                "email VARCHAR(100) UNIQUE)";

        String insertSql = "INSERT INTO participants (first_name, last_name, email) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             PreparedStatement pstmt = conn.prepareStatement(insertSql)) {


            stmt.execute(createTableSql);


            pstmt.setString(1, p.getFirstName());
            pstmt.setString(2, p.getLastName());
            pstmt.setString(3, p.getEmail());
            pstmt.executeUpdate();

            System.out.println("Success: Participant " + p.getFirstName() + " saved to DB.");
        }
    }

    public void readParticipants() throws SQLException {
        String sql = "SELECT * FROM participants";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("From DB: " + rs.getString("first_name") + " " + rs.getString("last_name"));
            }
        }
    }

    public void updateParticipantEmail(String lastName, String newEmail) throws SQLException {
        String sql = "UPDATE participants SET email = ? WHERE last_name = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newEmail);
            pstmt.setString(2, lastName);
            pstmt.executeUpdate();
        }
    }

    public void deleteParticipant(String lastName) throws SQLException {
        String sql = "DELETE FROM participants WHERE last_name = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, lastName);
            pstmt.executeUpdate();
        }
    }
}