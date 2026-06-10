public class OverdueChecker implements Runnable {

    private Library library;

    public OverdueChecker(Library library) {
        this.library = library;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {

                Thread.sleep(15000);

                System.out.println("\n[SYSTEM] --- Melakukan pengecekan otomatis pengembalian buku... ---");

                boolean adaPeminjaman = false;

                for (Borrowing b : library.getBorrowings()) {

                    if ("Borrowed".equalsIgnoreCase(b.getStatus())) {

                        System.out.println("[NOTIFIKASI] Peminjaman ID: " + b.getBorrowingId() +
                                " | User ID: " + b.getUserId() +
                                " | Book ID: " + b.getBookId() +
                                " | harap segera dikembalikan sebelum tanggal: " + b.getReturnDate());

                        adaPeminjaman = true;
                    }
                }

                if (!adaPeminjaman) {
                    System.out.println("[SYSTEM] Tidak ada buku yang sedang dipinjam saat ini.");
                }

                System.out.print("Pilih opsi: ");
            }

        } catch (InterruptedException e) {
            System.out.println("[SYSTEM] Pengecek otomatis dihentikan.");
        }
    }
}