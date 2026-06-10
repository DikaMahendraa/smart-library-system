
import java.sql.Connection;

public class TestConnection {

    public static void main(String[] args) {

        Connection conn = DatabaseConnection.getConnection();

        if (conn != null) {
            System.out.println(
                    "Connected to MySQL successfully!");
        }
    }
}