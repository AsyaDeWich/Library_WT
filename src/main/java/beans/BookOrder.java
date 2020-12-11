package beans;

public class BookOrder {

    public enum OrderType {
        ABONEMENT,
        READING_ROOM
    }

    public enum State {
        TRUE,
        FALSE
    }

    public final Integer id;
    public final String orderDate;
    public final Integer idBook;
    public final Integer idUser;
    public final OrderType orderType;
    public final State state;

    public BookOrder(Integer id, String orderDate, Integer idBook, Integer idUser, OrderType orderType, State state) {
        this.id = id;
        this.orderDate = orderDate;
        this.idBook = idBook;
        this.idUser = idUser;
        this.orderType = orderType;
        this.state = state;
    }
}