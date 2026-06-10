import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    // REGISTER
    public boolean registerUser(String nama,
            String username,
            String password,
            String role) {

        String sql = "INSERT INTO users (nama, username, password, role) VALUES (?, ?, ?, ?)";

        try {

            Connection conn = DatabaseConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nama);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4, role);

            int result = ps.executeUpdate();

            System.out.println("Rows inserted = " + result);

            return result > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // LOGIN
    public Customer loginUser(String username, String password) {

        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try {

            Connection conn = DatabaseConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Customer(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getString("username"),
                        rs.getString("password"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}