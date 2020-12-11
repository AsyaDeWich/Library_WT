package dao;

import beans.Book;

import java.util.List;

public interface BookDAO {
    List<Book> getBooks() throws Exception;
    Book getBookByID(int id) throws Exception;
    Book getBookByPublishingYear(int publishingYear) throws Exception;
    Book getBookByAuthorLastName(String lastname) throws Exception;
}