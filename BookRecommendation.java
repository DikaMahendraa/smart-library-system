import java.util.ArrayList;

public class BookRecommendation implements Runnable {
    private Library library;

    public BookRecommendation(Library library) {
        this.library = library;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                // Set jeda waktu rekomendasi muncul (misal: setiap 25 detik)
                Thread.sleep(25000);

                // Ambil daftar buku yang tersedia di library
                ArrayList<Book> daftarBuku = library.getBooks();

                System.out.println("\n[REKOMENDASI] --- Buku Paling Laris Hari Ini ---");

                if (daftarBuku != null && !daftarBuku.isEmpty()) {
                    // Cari buku yang paling banyak dipinjam (borrowedCount tertinggi)
                    Book bukuTerpopuler = daftarBuku.get(0);

                    for (Book buku : daftarBuku) {
                        if (buku.getBorrowedCount() > bukuTerpopuler.getBorrowedCount()) {
                            bukuTerpopuler = buku; // Update jika ketemu yang lebih banyak dibaca
                        }
                    }

                    // Tampilkan hasilnya ke terminal
                    System.out.println("[REKOMENDASI] Paling banyak dibaca: \"" + bukuTerpopuler.getTitle() + "\"");
                    System.out.println("[REKOMENDASI] Total dibaca: " + bukuTerpopuler.getBorrowedCount()
                            + " kali | Sisa Stok: " + bukuTerpopuler.getStock());
                } else {
                    System.out.println("[REKOMENDASI] Belum ada data koleksi buku.");
                }

                System.out.print("Pilih opsi: "); // Prompt menu utama agar rapi
            }
        } catch (InterruptedException e) {
            System.out.println("[SYSTEM] Thread rekomendasi buku dihentikan.");
        }
    }
}