package service;

import dao.sql.BookOrderDAOSQL;
import beans.BookOrder;

import java.util.List;

public class BookOrderService {
    public static List<BookOrder> getAll() {
        try {
            return new BookOrderDAOSQL().getBookOrders();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static BookOrder byID(int id) {
        try {
            return new BookOrderDAOSQL().getBookOrderByID(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static BookOrder byState(BookOrder.State state) {
        try {
            return new BookOrderDAOSQL().getBookOrderByState(state);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static BookOrder byOrderType(BookOrder.OrderType orderType) {
        try {
            return new BookOrderDAOSQL().getBookOrderByOrderType(orderType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}