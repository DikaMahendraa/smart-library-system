public class Borrowing {

    private int borrowingId;
    private int userId;
    private int bookId;

    private String borrowDate;
    private String returnDate;

    private String status;
    private int fine;

    public Borrowing(int borrowingId,
            int userId,
            int bookId,
            String borrowDate,
            String returnDate,
            String status,
            int fine) {

        this.borrowingId = borrowingId;
        this.userId = userId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.status = status;
        this.fine = fine;
    }

    // GETTER
    public int getBorrowingId() {
        return borrowingId;
    }

    public int getUserId() {
        return userId;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public String getStatus() {
        return status;
    }

    public int getFine() {
        return fine;
    }

    // SETTER
    public void setStatus(String status) {
        this.status = status;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public void displayBorrowingInfo() {

        System.out.println("\n===== BORROWING INFO =====");
        System.out.println("Borrowing ID : " + borrowingId);
        System.out.println("User ID      : " + userId);
        System.out.println("Book ID      : " + bookId);
        System.out.println("Borrow Date  : " + borrowDate);
        System.out.println("Return Date  : " + returnDate);
        System.out.println("Status       : " + status);
        System.out.println("Fine         : Rp " + fine);
    }
}