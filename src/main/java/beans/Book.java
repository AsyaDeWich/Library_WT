package beans;

public class Book {

    public final Integer id;
    public final String name;
    public final String authorFirstName;
    public final String authorLastName;
    public final Integer pages;
    public final Integer bookCount;
    public final Integer booksLeftoverCount;
    public final Integer publishingYear;

    public Book(Integer id, String name, String authorFirstName, String authorLastName, Integer pages, Integer bookCount, Integer booksLeftoverCount, Integer publishingYear) {
        this.id = id;
        this.name = name;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.pages = pages;
        this.bookCount = bookCount;
        this.booksLeftoverCount = booksLeftoverCount;
        this.publishingYear = publishingYear;
    }
}