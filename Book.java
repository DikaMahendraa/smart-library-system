public class Book {

    private int id;
    private String title;
    private String author;
    private String category;
    private double rating;
    private int stock;
    private int borrowedCount;

    public Book(int id, String title, String author,
            String category, double rating, int stock) {

        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.rating = rating;
        this.stock = stock;
        this.borrowedCount = 0;
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public double getRating() {
        return rating;
    }

    public int getStock() {
        return stock;
    }

    public int getBorrowedCount() {
        return borrowedCount;
    }

    // Setter
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setBorrowedCount(int borrowedCount) {
        this.borrowedCount = borrowedCount;
    }

    // Menambah jumlah peminjaman
    public void increaseBorrowedCount() {
        borrowedCount++;
    }

    // Menampilkan informasi buku
    public void displayBookInfo() {

        System.out.println("-------------------------");
        System.out.println("ID             : " + id);
        System.out.println("Title          : " + title);
        System.out.println("Author         : " + author);
        System.out.println("Category       : " + category);
        System.out.println("Rating         : " + rating);
        System.out.println("Stock          : " + stock);
        System.out.println("Borrowed Count : " + borrowedCount);
    }
}