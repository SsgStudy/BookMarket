package service;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import mapper.BookMapper;
import vo.Book;

public class BookService {
    private BookMapper bookMapper = new BookMapper();

    // 장바구니에 도서 추가
    public void addBook(String userId) {
        Scanner sc = new Scanner(System.in);

        System.out.println("장바구니에 추가할 도서의 ID를 입력하세요 :");
        String bookId = sc.next();

        if (!findBookById(bookId)) {
            System.out.printf("%s는 도서 목록에 없습니다.\n", bookId);
            return;
        }

        System.out.println("장바구니에 추가하시겠습니까? Y | N");
        String confirm = sc.next();

        if (confirm.equals("Y") || confirm.equals("y")) {
            bookMapper.save(userId, bookId);
            System.out.printf("%s 도서가 장바구니에 추가되었습니다.\n", bookId);
        } else {
            System.out.println("장바구니 추가를 취소하였습니다.");
        }
    }

    // bookId가 도서 리스트에 존재하는지 확인
    public boolean findBookById(String bookId) {
        return bookMapper.findByBookId(bookId) != null;
    }

    // 모든 도서 조회
    public List<Book> getAllBooks() {
        bookMapper.findAll().stream().forEach(i-> System.out.println(i));
        return bookMapper.findAll();
    }

    // User 장바구니 조회
    public List<Book> getUserCart(String userId) {
        List<String> bookIdList = bookMapper.findCartByUserId(userId);

        if (bookIdList == null) {
            System.out.println("장바구니가 비어있습니다.");
            return new ArrayList<>();
        }

        List<Book> returnBookList = new ArrayList<>();
        for (String bookId: bookIdList)
            returnBookList.add(bookMapper.findByBookId(bookId));

        return returnBookList;
    }
}