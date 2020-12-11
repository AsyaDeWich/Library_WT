package dao.sql;

import dao.BookOrderDAO;
import beans.BookOrder;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookOrderDAOSQL implements BookOrderDAO{
    @Override
    public List<BookOrder> getBookOrders() throws Exception {
        Connection connection = DBConnection.connect();

        try {
            List<BookOrder> bookOrders = new ArrayList<>();

            PreparedStatement query = connection.prepareStatement("SELECT * FROM book_order");

            ResultSet result = query.executeQuery();
            while (result.next()) {
                int _id = result.getInt(1);
                String _orderDate = result.getString(2);
                int _idBook= result.getInt(3);
                int _idUser= result.getInt(4);
                BookOrder.OrderType _orderType = BookOrder.OrderType.valueOf(result.getString(5).toUpperCase());
                BookOrder.State _state = BookOrder.State.valueOf(result.getString(6).toUpperCase());
                bookOrders.add(new BookOrder(_id,_orderDate,_idBook,_idUser,_orderType,_state));
            }
            return bookOrders;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BookOrder getBookOrderByID(int id) throws Exception {
        Connection connection = DBConnection.connect();

        try{
            PreparedStatement query = connection.prepareStatement("SELECT * FROM book_order WHERE id_book_order LIKE ?");
            query.setString(1,Integer.toString(id));

            ResultSet result = query.executeQuery();
            if (result.next()) {
                int _id = result.getInt(1);
                String _orderDate = result.getString(2);
                int _idBook= result.getInt(3);
                int _idUser= result.getInt(4);
                BookOrder.OrderType _orderType = BookOrder.OrderType.valueOf(result.getString(5).toUpperCase());
                BookOrder.State _state = BookOrder.State.valueOf(result.getString(6).toUpperCase());
                return new BookOrder(_id,_orderDate,_idBook,_idUser,_orderType,_state);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BookOrder getBookOrderByState(BookOrder.State state) throws Exception {
        Connection connection = DBConnection.connect();

        try{
            PreparedStatement query = connection.prepareStatement("SELECT * FROM book_order WHERE state LIKE ?");
            query.setString(1,state.name().toLowerCase());

            ResultSet result = query.executeQuery();
            if (result.next()) {
                int _id = result.getInt(1);
                String _orderDate = result.getString(2);
                int _idBook= result.getInt(3);
                int _idUser= result.getInt(4);
                BookOrder.OrderType _orderType = BookOrder.OrderType.valueOf(result.getString(5).toUpperCase());
                BookOrder.State _state = BookOrder.State.valueOf(result.getString(6).toUpperCase());
                return new BookOrder(_id,_orderDate,_idBook,_idUser,_orderType,_state);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BookOrder getBookOrderByOrderType(BookOrder.OrderType orderType) throws Exception {
        Connection connection = DBConnection.connect();

        try{
            PreparedStatement query = connection.prepareStatement("SELECT * FROM book_order WHERE order_type LIKE ?");
            query.setString(1,orderType.name().toLowerCase());

            ResultSet result = query.executeQuery();
            if (result.next()) {
                int _id = result.getInt(1);
                String _orderDate = result.getString(2);
                int _idBook= result.getInt(3);
                int _idUser= result.getInt(4);
                BookOrder.OrderType _orderType = BookOrder.OrderType.valueOf(result.getString(5).toUpperCase());
                BookOrder.State _state = BookOrder.State.valueOf(result.getString(6).toUpperCase());
                return new BookOrder(_id,_orderDate,_idBook,_idUser,_orderType,_state);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}