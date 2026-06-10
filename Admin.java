public class Admin extends User {

    public Admin(int id, String nama, String username, String password) {
        super(id, nama, username, password, "ADMIN");
    }

    @Override
    public void showMenu() {
        System.out.println("\n===== ADMIN MENU =====");
    }

    public void addBook() {
        System.out.println("Adding book...");
    }

    public void updateBook() {
        System.out.println("Updating book...");
    }

    public void deleteBook() {
        System.out.println("Deleting book...");
    }
}