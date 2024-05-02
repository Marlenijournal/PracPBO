import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class LibrarySystem {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Book> books = new ArrayList<>();
    private static List<Member> members = new ArrayList<>();

    public static void main(String[] args) {
        books.add(new Book("Harry Potter dan Reliku Kematian", "CB001", "Fantasi", "J.K. Rowling", 999));
        books.add(new Book("The Chronicles of Narnia : Pertempuran Terakhir", "CB002", "Fantasi", "C.S. Lewis", 288));
        books.add(new Book("Fire & Blood","CB003", "Fantasy", "R.R Martin", 766));
        books.add(new Book("Filosofi Teras","CB004", "Self-Help", "Henry Manampiring", 346));
        books.add(new Book("Seni Hidup Minimalis","CB005", "Self-Help", "Francine Jay", 278));
        books.add(new Book("How to Think Like Leonardo da Vinci","CB006", "Self-Help", "Michael J.Gelb", 336));
        books.add(new Book("Anatomic Habit","CB007", "Self-Help", "James Clear", 352));

        mainMenu();
    }

    public static void mainMenu() {
        clearScreen();
        System.out.println("==============================================");
        System.out.println("        Selamat Datang di Mars Library");
        System.out.println("==============================================");
        System.out.println("1. Daftar Member");
        System.out.println("2. Daftar Buku");
        System.out.println("3. Cari Buku");
        System.out.println("4. Pinjam Buku");
        System.out.println("5. Mengembalikan Buku");
        System.out.print("==> Silahkan pilih: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                registerMember();
                break;
            case 2:
                displayBooks();
                break;
            case 3:
                searchBook();
                break;
            case 4:
                borrowBook();
                break;
            case 5:
                returnBook();
                break;
            default:
                System.out.println("Pilihan tidak valid. Silakan pilih kembali.");
                backToMainMenu();
        }
    }

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Clearing screen failed: " + e.getMessage());
        }
    }
    

    public static void registerMember() {
        clearScreen();
        System.out.println("==================================");
        System.out.println("        Pendaftaran Member");
        System.out.println("==================================");
        System.out.print("Nama Lengkap    : ");
        String name = scanner.nextLine();
        System.out.print("Usia            : ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Alamat          : ");
        String address = scanner.nextLine();
        System.out.print("Jenis (1. Umum / 2. Pelajar): ");
        String type = scanner.nextLine();
        if (type.equals("1")) {
            type = "Umum";
        } else if (type.equals("2")) {
            type = "Pelajar";
        } else {
            System.out.println("Pilihan tidak valid. Pembuatan member dibatalkan.");
            backToMainMenu();
            return;
        }
        Member newMember = Registration.registerMember(name, age, address, type);
        members.add(newMember);
        System.out.println("\n=== Pendaftaran member berhasil ===\n\n");
        newMember.displayMemberDetails();
        backToMainMenu();
    }

    public static void displayBooks() {
        clearScreen();
        System.out.println("===========================================");
        System.out.println("             Daftar Buku");
        System.out.println("===========================================");
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            System.out.println((i + 1) + ". " + book.getTitle());
            book.displayBookDetails();
        }
        backToMainMenu();
    }

    public static void searchBook() {
        clearScreen();
        System.out.println("=====================================");
        System.out.println("        Cari Buku Berdasarkan");
        System.out.println("=====================================");
        System.out.println("1. Judul");
        System.out.println("2. Genre");
        System.out.println("3. Penulis");
        System.out.print("===> Pilihan : ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                searchBookByTitle();
                break;
            case 2:
                searchBookByGenre();
                break;
            case 3:
                searchBookByAuthor();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                backToMainMenu();
        }
    }

    public static void searchBookByTitle() {
        System.out.print("==> Masukkan judul buku: ");
        String title = scanner.nextLine();
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                found = true;
                book.displayBookDetails();
            }
        }
        if (!found) {
            System.out.println("Buku tidak ditemukan.");
        }
        backToMainMenu();
    }

    public static void searchBookByGenre() {
        System.out.print("==> Masukkan genre buku: ");
        String genre = scanner.nextLine();
        boolean found = false;
        for (Book book : books) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                found = true;
                book.displayBookDetails();
            }
        }
        if (!found) {
            System.out.println("Buku tidak ditemukan.");
        }
        backToMainMenu();
    }

    public static void searchBookByAuthor() {
        System.out.print("==> Masukkan nama penulis: ");
        String author = scanner.nextLine();
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                found = true;
                book.displayBookDetails();
            }
        }
        if (!found) {
            System.out.println("Buku tidak ditemukan.");
        }
        backToMainMenu();
    }

    public static void borrowBook() {
        clearScreen();
        System.out.println("===================================");
        System.out.println("            Pinjam Buku");
        System.out.println("===================================");
        System.out.print("Kode buku yang ingin dipinjam :  ");
        String bookCode = scanner.nextLine();
        Book bookToBorrow = null;
        for (Book book : books) {
            if (book.getCode().equalsIgnoreCase(bookCode)) {
                bookToBorrow = book;
                break;
            }
        }
        if (bookToBorrow == null) {
            System.out.println("Buku tidak ditemukan.");
            backToMainMenu();
            return;
        }

        System.out.print("Masukkan nama peminjam        : ");
        String memberName = scanner.nextLine();
        Member borrower = null;
        for (Member member : members) {
            if (member.getName().equalsIgnoreCase(memberName)) {
                borrower = member;
                break;
            }
        }
        if (borrower == null) {
            System.out.println("== Anda harus menjadi member terlebih dahulu. == ");
            backToMainMenu();
            return;
        }

        System.out.println("=\n\n === Status: Berhasil dipinjamkan ====");
        System.out.println("Nama peminjam     : " + borrower.getName());
        System.out.println("Kode peminjaman   : CP001");
        System.out.println("Tanggal peminjaman: " + new Date());
        System.out.println("Batas pengembalian: 7 hari setelah peminjaman");
        System.out.println("_______________________________________________\n");
        backToMainMenu();
    }

    public static void returnBook() {
        clearScreen();
        System.out.println("=================================");
        System.out.println("        Pengembalian Buku");
        System.out.println("=================================");
        System.out.print("Nama pengembali   : ");
        String memberName = scanner.nextLine();
        Member returningMember = null;
        for (Member member : members) {
            if (member.getName().equalsIgnoreCase(memberName)) {
                returningMember = member;
                break;
            }
        }
        if (returningMember == null) {
            System.out.println("Anggota tidak ditemukan.");
            backToMainMenu();
            return;
        }

        System.out.println("Status  : Selesai");
        System.out.println("Terima kasih sudah mengembalikan.");
        backToMainMenu();
    }

    public static void backToMainMenu() {
        System.out.print("\nKembali ke menu? (1. ya / 2. tidak): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            mainMenu();
        } else if (choice == 2) {
            System.out.println("Terima kasih. Sampai jumpa!");
        } else {
            System.out.println("Pilihan tidak valid. Keluar dari program.");
        }
    }
}
