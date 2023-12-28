package vo;

public class Book {
    private String bookId;
    private String bookName;
    private int bookPrice;
    private String bookAuthor;
    private String bookInfo;
    private String bookCategory;
    private String bookPublishingDate;

    public Book(String bookId, String bookName, int bookPrice, String bookAuthor, String bookInfo, String bookCategory, String bookPublishingDate) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookAuthor = bookAuthor;
        this.bookInfo = bookInfo;
        this.bookCategory = bookCategory;
        this.bookPublishingDate = bookPublishingDate;
    }

    public String getBookId() {
        return bookId;
    }

    @Override
    public String toString() {
        return (bookId + " | " + bookName + " | " + bookPrice + " | " + bookAuthor + " | "
                + bookInfo + " | " + bookCategory + " | " + bookPublishingDate + " | ");
    }
}
