public class Customer extends User {

    public Customer(int id, String nama,
            String username, String password) {

        super(id, nama, username, password, "CUSTOMER");
    }

    @Override
    public void showMenu() {
        System.out.println("\n===== CUSTOMER MENU =====");
    }

    public void borrowBook() {
        System.out.println("Borrowing book...");
    }

    public void returnBook() {
        System.out.println("Returning book...");
    }

    public void viewRecommendations() {
        System.out.println("Showing recommended books...");
    }
}