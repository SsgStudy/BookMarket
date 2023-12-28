package vo;

public class CartElement {
    private String bookId;
    private int amount;

    public CartElement(String bookId, int amount) {
        this.bookId = bookId;
        this.amount = amount;
    }

    public String getBookId() {
        return bookId;
    }
    public int getAmount() {
        return amount;
    }
}
