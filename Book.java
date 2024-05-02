public class Book {
    private String title;
    private String code;
    private String genre;
    private String author;
    private int pages;

    public Book(String title, String code, String genre, String author, int pages) {
        this.title = title;
        this.code = code;
        this.genre = genre;
        this.author = author;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public void displayBookDetails() {
        System.out.println("   Judul           : " + title);
        System.out.println("   Kode            : " + code);
        System.out.println("   Genre           : " + genre);
        System.out.println("   Penulis         : " + author);
        System.out.println("   Jumlah Halaman  : " + pages);
        System.out.println("___________________________________________\n");
    }
}
