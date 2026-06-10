import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private ArrayList<Borrowing> borrowings;

    public Library() {
        books = new ArrayList<>();
        borrowings = new ArrayList<>();
    }

    // ADD BOOK
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    // SHOW CATALOG
    public void showCatalog() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\n===== BOOK CATALOG =====");

        for (Book book : books) {
            book.displayBookInfo();
        }
    }

    // FIND BOOK BY ID
    public Book findBookById(int id) {

        for (Book book : books) {

            if (book.getId() == id) {
                return book;
            }
        }

        return null;
    }

    // REMOVE BOOK
    public void removeBook(int id) {

        Book book = findBookById(id);

        if (book != null) {
            books.remove(book);
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    // RECOMMENDATION
    public void showRecommendedBooks() {

        System.out.println("\n===== RECOMMENDED BOOKS =====");

        boolean found = false;

        for (Book book : books) {

            if (book.getRating() >= 4.0) {

                found = true;

                System.out.println("-------------------------");
                System.out.println("Title  : " + book.getTitle());
                System.out.println("Author : " + book.getAuthor());
                System.out.println("Rating : " + book.getRating());
            }
        }

        if (!found) {
            System.out.println("No recommended books available.");
        }
    }

    // BORROWING

    public void addBorrowing(Borrowing borrowing) {
        borrowings.add(borrowing);
    }

    public ArrayList<Borrowing> getBorrowings() {
        return borrowings;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}