package dao.sql;

import dao.BookDAO;
import beans.Book;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAOSQL implements BookDAO {
    @Override
    public List<Book> getBooks() throws Exception {
        Connection connection = DBConnection.connect();

        try {
            List<Book> books = new ArrayList<>();

            PreparedStatement query = connection.prepareStatement("SELECT * FROM book");

            ResultSet result = query.executeQuery();
            while (result.next()) {
                int _id = result.getInt(1);
                String _name = result.getString(2);
                String _authorFirstName = result.getString(3);
                int _pages = result.getInt(4);
                int _booksCount = result.getInt(5);
                int _booksLeftoverCount = result.getInt(6);
                int _publishingYear = result.getInt(7);
                String _authorLastName = result.getString(3);
                books.add(new Book(_id,_name,_authorFirstName,_authorLastName,_pages,_booksCount,_booksLeftoverCount,_publishingYear));
            }
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Book getBookByID(int id) throws Exception {
        Connection connection = DBConnection.connect();

        try{
            PreparedStatement query = connection.prepareStatement("SELECT * FROM book WHERE id_book LIKE ?");
            query.setString(1,Integer.toString(id));

            ResultSet result = query.executeQuery();
            if (result.next()) {
                int _id = result.getInt(1);
                String _name = result.getString(2);
                String _authorFirstName = result.getString(3);
                int _pages = result.getInt(4);
                int _booksCount = result.getInt(5);
                int _booksLeftoverCount = result.getInt(6);
                int _publishingYear = result.getInt(7);
                String _authorLastName = result.getString(3);
                return new Book(_id,_name,_authorFirstName,_authorLastName,_pages,_booksCount,_booksLeftoverCount,_publishingYear);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Book getBookByPublishingYear(int publishingYear) throws Exception {
        Connection connection = DBConnection.connect();

        try{
            PreparedStatement query = connection.prepareStatement("SELECT * FROM book WHERE publishing_year LIKE ?");
            query.setString(1,Integer.toString(publishingYear));

            ResultSet result = query.executeQuery();
            if (result.next()) {
                int _id = result.getInt(1);
                String _name = result.getString(2);
                String _authorFirstName = result.getString(3);
                int _pages = result.getInt(4);
                int _booksCount = result.getInt(5);
                int _booksLeftoverCount = result.getInt(6);
                int _publishingYear = result.getInt(7);
                String _authorLastName = result.getString(3);
                return new Book(_id,_name,_authorFirstName,_authorLastName,_pages,_booksCount,_booksLeftoverCount,_publishingYear);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Book getBookByAuthorLastName(String lastname) throws Exception {
        Connection connection = DBConnection.connect();

        try{
            PreparedStatement query = connection.prepareStatement("SELECT * FROM book WHERE author_last_name LIKE ?");
            query.setString(1,lastname);

            ResultSet result = query.executeQuery();
            if (result.next()) {
                int _id = result.getInt(1);
                String _name = result.getString(2);
                String _authorFirstName = result.getString(3);
                int _pages = result.getInt(4);
                int _booksCount = result.getInt(5);
                int _booksLeftoverCount = result.getInt(6);
                int _publishingYear = result.getInt(7);
                String _authorLastName = result.getString(3);
                return new Book(_id,_name,_authorFirstName,_authorLastName,_pages,_booksCount,_booksLeftoverCount,_publishingYear);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}