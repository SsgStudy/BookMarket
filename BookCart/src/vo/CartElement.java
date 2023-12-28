package vo;

public class CartElement {
    private Book book;
    private int amount;

    public CartElement(Book book) {
        this.book = book;
        this.amount++;
    }

    public Book getBook() {
        return book;
    }

    public int getAmount() {
        return amount;
    }

    public void plusAmount()
    {
        this.amount++;
    }

    public String toString() {
        return (getBook() + "" + getAmount() + "권");
    }
}
