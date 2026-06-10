import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n=================================");
            System.out.println(" SMART LIBRARY INFORMATION SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Choose Menu: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    login();
                    break;

                case 2:
                    register();
                    break;

                case 3:
                    System.out.println("Thank you for using the system.");
                    break;

                default:
                    System.out.println("Invalid menu!");
            }

        } while (choice != 3);

        input.close();
    }

    // REGISTER
    public static void register() {

        System.out.println("\n===== REGISTER =====");

        System.out.print("Name     : ");
        String name = input.nextLine();

        System.out.print("Username : ");
        String username = input.nextLine();

        System.out.print("Password : ");
        String password = input.nextLine();

        UserDAO userDAO = new UserDAO();

        boolean success = userDAO.registerUser(name, username, password, "CUSTOMER");

        System.out.println(success ? "Registration successful!" : "Registration failed!");
    }

    // LOGIN
    public static void login() {

        System.out.println("\n===== LOGIN =====");

        System.out.print("Username : ");
        String username = input.nextLine();

        System.out.print("Password : ");
        String password = input.nextLine();

        // ADMIN LOGIN
        if (username.equals("admin") && password.equals("admin")) {

            Admin admin = new Admin(1, "Administrator", "admin", "admin");

            admin.showMenu();
            adminMenu();
            return;
        }

        // CUSTOMER LOGIN
        UserDAO userDAO = new UserDAO();

        Customer customer = userDAO.loginUser(username, password);

        if (customer != null) {
            customer.showMenu();
            customerMenu(customer);
            return;
        }

        System.out.println("Username or password is incorrect.");
    }

    // ADMIN MENU
    public static void adminMenu() {

        int choice;

        do {
            System.out.println("\n===== ADMIN MENU =====");
            System.out.println("1. View Catalog");
            System.out.println("2. Add Book");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Logout");
            System.out.print("Choose Menu: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    showCatalog();
                    break;

                case 2:

                    System.out.print("Title : ");
                    String title = input.nextLine();

                    System.out.print("Author : ");
                    String author = input.nextLine();

                    System.out.print("Category : ");
                    String category = input.nextLine();

                    System.out.print("Rating : ");
                    double rating = input.nextDouble();

                    System.out.print("Stock : ");
                    int stock = input.nextInt();
                    input.nextLine();

                    Book book = new Book(0, title, author, category, rating, stock);

                    BookDAO bookDAO = new BookDAO();

                    System.out.println(
                            bookDAO.addBook(book)
                                    ? "Book added successfully!"
                                    : "Failed to add book!");
                    break;

                // UPDATE BOOK
                case 3:

                    System.out.print("Enter Book ID to update: ");
                    int idUpdate = input.nextInt();
                    input.nextLine();

                    System.out.print("Title : ");
                    String titleU = input.nextLine();

                    System.out.print("Author : ");
                    String authorU = input.nextLine();

                    System.out.print("Category : ");
                    String categoryU = input.nextLine();

                    System.out.print("Rating : ");
                    double ratingU = input.nextDouble();

                    System.out.print("Stock : ");
                    int stockU = input.nextInt();
                    input.nextLine();

                    Book updatedBook = new Book(idUpdate, titleU, authorU, categoryU, ratingU, stockU);

                    BookDAO daoUpdate = new BookDAO();

                    System.out.println(
                            daoUpdate.updateBook(updatedBook)
                                    ? "Book updated successfully!"
                                    : "Update failed!");
                    break;

                //  DELETE BOOK
                case 4:

                    System.out.print("Enter Book ID to delete: ");
                    int deleteId = input.nextInt();
                    input.nextLine();

                    BookDAO daoDelete = new BookDAO();

                    System.out.println(
                            daoDelete.deleteBook(deleteId)
                                    ? "Book deleted successfully!"
                                    : "Delete failed!");
                    break;

                case 5:
                    System.out.println("Logout successful.");
                    break;
            }

        } while (choice != 5);
    }

    // CUSTOMER MENU
    public static void customerMenu(Customer customer) {

        int choice;

        do {
            System.out.println("\n===== CUSTOMER MENU =====");
            System.out.println("1. View Catalog");
            System.out.println("2. Recommended Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Logout");
            System.out.print("Choose Menu: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    showCatalog();
                    break;

                case 2:

                    BookDAO bookDAO = new BookDAO();
                    ArrayList<Book> books = bookDAO.getRecommendedBooks();

                    System.out.println("\n===== RECOMMENDED BOOKS =====");

                    for (Book book : books) {
                        System.out.println("----------------------");
                        System.out.println("ID : " + book.getId());
                        System.out.println("Title : " + book.getTitle());
                        System.out.println("Author : " + book.getAuthor());
                        System.out.println("Category : " + book.getCategory());
                        System.out.println("Rating : " + book.getRating());
                        System.out.println("Stock : " + book.getStock());
                    }
                    break;

                case 3:

                    System.out.print("Enter Book ID: ");
                    int bookId = input.nextInt();
                    input.nextLine();

                    int userId = customer.getId();

                    BookDAO bookDAO2 = new BookDAO();
                    BookTransaction bt = new BookTransaction();

                    boolean stockOk = bookDAO2.reduceStock(bookId);

                    if (!stockOk) {
                        System.out.println("Book not available!");
                        break;
                    }

                    boolean saved = bt.borrow(userId, bookId);

                    System.out.println(saved ? "Book borrowed successfully!" : "Failed transaction!");
                    break;

                case 4:

                    System.out.print("Enter Borrowing ID: ");
                    int borrowId = input.nextInt();

                    System.out.print("Enter Book ID: ");
                    int returnBookId = input.nextInt();
                    input.nextLine();

                    BookDAO bookDAO3 = new BookDAO();
                    BookTransaction bt2 = new BookTransaction();

                    boolean returned = bt2.returnBook(borrowId);
                    boolean stockBack = bookDAO3.increaseStock(returnBookId);

                    System.out.println(
                            (returned && stockBack)
                                    ? "Book returned successfully!"
                                    : "Return failed!");
                    break;

                case 5:
                    System.out.println("Logout successful.");
                    break;
            }

        } while (choice != 5);
    }

    // SHOW CATALOG
    public static void showCatalog() {

        BookDAO bookDAO = new BookDAO();

        ArrayList<Book> books = bookDAO.getAllBooks();

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\n===== BOOK CATALOG =====");

        for (Book book : books) {
            System.out.println("----------------------");
            System.out.println("ID : " + book.getId());
            System.out.println("Title : " + book.getTitle());
            System.out.println("Author : " + book.getAuthor());
            System.out.println("Category : " + book.getCategory());
            System.out.println("Rating : " + book.getRating());
            System.out.println("Stock : " + book.getStock());
        }
    }
}