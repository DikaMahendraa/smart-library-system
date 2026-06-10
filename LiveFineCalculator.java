import java.util.ArrayList;

public class LiveFineCalculator implements Runnable {

    private Library library;

    public LiveFineCalculator(Library library) {
        this.library = library;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {

                Thread.sleep(10000);

                System.out.println("\n[SYSTEM] --- Memulai Sinkronisasi & Kalkulasi Denda Berjalan... ---");

                ArrayList<Borrowing> daftarPeminjaman = library.getBorrowings();

                if (daftarPeminjaman != null && !daftarPeminjaman.isEmpty()) {

                    boolean adaDendaBaru = false;

                    for (Borrowing b : daftarPeminjaman) {

                        if ("Borrowed".equalsIgnoreCase(b.getStatus())) {

                            int dendaLama = b.getFine();
                            int dendaBaru = dendaLama + 2000;

                            b.setFine(dendaBaru);

                            System.out.println("[DENDA UPDATE] ID Transaksi: " + b.getBorrowingId() +
                                    " | User ID: " + b.getUserId() +
                                    " | Book ID: " + b.getBookId());

                            System.out.println("               Denda bertambah: Rp" +
                                    dendaLama + " -> Rp" + dendaBaru);

                            adaDendaBaru = true;
                        }
                    }

                    if (!adaDendaBaru) {
                        System.out.println("[SYSTEM] Tidak ada denda baru. Semua transaksi aman.");
                    }

                } else {
                    System.out.println("[SYSTEM] Belum ada data transaksi peminjaman untuk dihitung.");
                }

                System.out.print("Pilih opsi: ");
            }

        } catch (InterruptedException e) {
            System.out.println("[SYSTEM] Thread kalkulator denda dihentikan.");
        }
    }
}