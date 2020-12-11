package dao;

import beans.BookOrder;

import java.util.List;

public interface BookOrderDAO {
    List<BookOrder> getBookOrders() throws Exception;
    BookOrder getBookOrderByID(int id) throws Exception;
    BookOrder getBookOrderByState(BookOrder.State state) throws Exception;
    BookOrder getBookOrderByOrderType(BookOrder.OrderType orderType) throws Exception;
}