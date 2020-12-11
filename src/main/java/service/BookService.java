package service;

import dao.sql.BookDAOSQL;
import beans.Book;

import java.util.List;

public class BookService {
    public static List<Book> getAll() {
        try {
            return new BookDAOSQL().getBooks();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Book byID(int id) {
        try {
            return new BookDAOSQL().getBookByID(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Book byYear(int year) {
        try {
            return new BookDAOSQL().getBookByPublishingYear(year);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Book byLastName(String lastname) {
        try {
            return new BookDAOSQL().getBookByAuthorLastName(lastname);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}