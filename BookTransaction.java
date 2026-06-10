import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookTransaction {

    // PINJAM BUKU
    public boolean borrow(int userId, int bookId) {

        String sql = "INSERT INTO borrowings (user_id, book_id, borrow_date, status) VALUES (?, ?, NOW(), 'BORROWED')";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, userId);
            ps.setInt(2, bookId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // KEMBALIKAN BUKU
    public boolean returnBook(int borrowingId) {

        String sql = "UPDATE borrowings SET return_date = NOW(), status = 'RETURNED' WHERE borrowing_id = ?";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, borrowingId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}