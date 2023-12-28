package service;


import java.util.*;

import mapper.BookMapper;
import entity.Book;
import mapper.BookMapperImpl;
import vo.CartElement;

public class BookService {
    private BookMapperImpl bookMapper = new BookMapperImpl();

    // 장바구니에 도서 추가
    public void addBook(String userId) {
        Scanner sc = new Scanner(System.in);

        System.out.println("장바구니에 추가할 도서의 ID를 입력하세요 :");
        String bookId = sc.next();

        if (findByBookId(bookId) == null) {
            System.out.println(bookId + "는 도서 목록에 없습니다.");
            return;
        }

        System.out.println("장바구니에 추가하시겠습니까? Y | N");
        String confirm = sc.next();

        if (confirm.equals("Y") || confirm.equals("y")) {
            int amount = findBookInCart(userId, bookId);
            CartElement element = new CartElement(bookId, amount+1);
            bookMapper.save(userId, element);
            System.out.printf("%s 도서가 장바구니에 추가되었습니다.\n", bookId);

        } else {
            System.out.println("장바구니 추가를 취소하였습니다.");
        }
    }

    // user의 장바구니에 특정 책이 담겨있는지 확인
    private int findBookInCart(String userId, String bookId) {
        Map<String, Integer> element = bookMapper.findCartByUserId(userId);

        if (element.containsKey(bookId))
            return element.get(bookId);
        else
            return 0;
    }

    // book이 마켓에 존재하는지 확인
//    private void verifyBookInList(String bookId) {
//        if (findByBookId(bookId) == null) {
//            System.out.println(bookId + "는 도서 목록에 없습니다.");
//            return;
//        }
//    }

    // book을 찾아서 객체 반환
    public Book findByBookId(String bookId) {
        return bookMapper.findByBookId(bookId);
    }

    // 모든 도서 조회
    public List<Book> getAllBooks() {
        bookMapper.findAll().stream().forEach(i-> System.out.println(i));
        return bookMapper.findAll();
    }

    // User 장바구니 조회
    public void getUserCart(String userId) {
        Map<String, Integer> userCart = bookMapper.findCartByUserId(userId);

        try {
            userCart.entrySet()
                    .stream()
                    .forEach(i-> System.out.println(findByBookId(i.getKey()) + " " + i.getValue()));
        } catch (NullPointerException e) {
            throw new NullPointerException("장바구니가 비어있습니다.");
        }
    }

    public void clearAll(String userId)
    {
        bookMapper.clear(userId);
        System.out.println("장바구니를 비웠습니다.");
    }

    public void createUserBookCart(String userId) {
        bookMapper.insertCart(userId);
    }
}