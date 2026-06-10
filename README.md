# smart-library-system
Sistem perpustakaan sederhana berbasis Java dan MySQL untuk mengelola data buku, user, peminjaman, dan pengembalian buku menggunakan konsep OOP dan JDBC.
# Smart Library Information System

Ini adalah project sistem perpustakaan sederhana yang dibuat menggunakan Java dan MySQL. Aplikasi ini berbasis console (CLI), sehingga semua proses dilakukan melalui terminal.

## Tentang Project

Project ini dibuat untuk latihan konsep Object Oriented Programming (OOP) dan database menggunakan JDBC MySQL. Sistem ini digunakan untuk mengelola data buku, user, serta proses peminjaman dan pengembalian buku.

## Fitur yang tersedia

Admin:
- Login sebagai admin
- Menambah data buku
- Melihat daftar buku
- Update data buku
- Menghapus data buku

User / Customer:
- Register akun
- Login user
- Melihat katalog buku
- Meminjam buku
- Mengembalikan buku
- Melihat rekomendasi buku

## Teknologi yang digunakan

- Java (OOP + JDBC)
- MySQL (XAMPP)
- JDBC Driver MySQL Connector
- IDE: NetBeans / IntelliJ / VS Code

## Database

Nama database: smart_library

Tabel yang digunakan:
- users
- books
- borrowings

## Cara menjalankan project

1. Import database ke phpMyAdmin (XAMPP)
2. Pastikan MySQL sudah berjalan
3. Tambahkan MySQL Connector/J ke project
4. Sesuaikan konfigurasi koneksi di DatabaseConnection.java
5. Jalankan file Main.java

## Catatan

Project ini masih bisa dikembangkan lebih lanjut, seperti:
- menambahkan GUI
- keamanan login (hash password)
- sistem denda yang lebih lengkap
- laporan peminjaman

## Pembuat

Mahasiswa 1: I Gede Mahea Adinata (42530041)  
Mahasiswa 2: I Gede Dika Mahendra Putra (42530027)
Mahasiswa 3: Abdullah Sami (42530018)
