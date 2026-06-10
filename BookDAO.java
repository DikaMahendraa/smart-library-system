import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDAO {

    public boolean addBook(Book book) {

        String sql = "INSERT INTO books(title, author, category, rating, stock) VALUES(?,?,?,?,?)";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getCategory());
            ps.setDouble(4, book.getRating());
            ps.setInt(5, book.getStock());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public ArrayList<Book> getAllBooks() {

        ArrayList<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                books.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("category"),
                        rs.getDouble("rating"),
                        rs.getInt("stock")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }

    public Book findBookById(int id) {

        String sql = "SELECT * FROM books WHERE id = ?";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("category"),
                        rs.getDouble("rating"),
                        rs.getInt("stock"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // PINJAM: stock - 1
    public boolean reduceStock(int id) {

        String sql = "UPDATE books SET stock = stock - 1 WHERE id = ? AND stock > 0";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // RETURN: stock + 1
    public boolean increaseStock(int id) {

        String sql = "UPDATE books SET stock = stock + 1 WHERE id = ?";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // ⭐ RECOMMENDED BOOKS (TOP RATING)
    public ArrayList<Book> getRecommendedBooks() {

        ArrayList<Book> books = new ArrayList<>();

        String sql = "SELECT * FROM books ORDER BY rating DESC LIMIT 5";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                books.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("category"),
                        rs.getDouble("rating"),
                        rs.getInt("stock")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }

    public boolean updateBook(Book book) {

        String sql = "UPDATE books SET title=?, author=?, category=?, rating=?, stock=? WHERE id=?";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getCategory());
            ps.setDouble(4, book.getRating());
            ps.setInt(5, book.getStock());
            ps.setInt(6, book.getId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteBook(int id) {

        String sql = "DELETE FROM books WHERE id=?";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}