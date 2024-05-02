import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private int age;
    private String address;
    private String type;
    private String memberId;
    private List<Book> borrowedBooks;

    public Member(String name, int age, String address, String type, String memberId) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.type = type;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public void displayMemberDetails() {
        System.out.println("    ===== Identitas Member =====");
        System.out.println("Nama         : " + name);
        System.out.println("Umur         : " + age);
        System.out.println("Alamat       : " + address);
        System.out.println("Jenis        : " + type);
        System.out.println("Nomor Member : " + memberId);
        System.out.println("==================================");
    }
}
