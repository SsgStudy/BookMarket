package mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import entity.Book;
import vo.CartElement;

public class BookMapperImpl implements BookMapper{
    private Map<String, Book> books = new HashMap<>();
    private static final Map<String, Map<String, Integer>> cart = new HashMap<>();

    public BookMapperImpl() {
        books.put("ISBN1234", new Book("ISBN1234", "쉽게 배우는 JSP 웹 프로그래밍", 27000, "송미영", "단계별로 쇼핑몰을 구현하며 배우는 JSP 웹 프로그래밍", "IT전문서", "2018/10/08"));
        books.put("ISBN1235", new Book("ISBN1235", "안드로이드 프로그래밍", 33000, "우재남", "실습 단계별 명쾌한 멘토링!", "IT전문서", "2022/01/22"));
        books.put("ISBN1236", new Book("ISBN1236", "스크래치", 22000, "고광일", "컴퓨팅 사고력을 키우는 블록 코딩", "컴퓨터 입문", "2019/06/10"));
    }

    // 장바구니에 도서 담기
    public void save(String userId, CartElement element) {
        Map<String, Integer> userCart = cart.get(userId);
        userCart.put(element.getBookId(), element.getAmount());
    }

    // 모든 도서 조회
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }

    // bookId로 Book 객체 찾아서 반환
    public Book findByBookId(String bookId) {
        return books.get(bookId);
    }

    // userId로 User 장바구니 조회
    public Map<String, Integer> findCartByUserId(String userId) {
        return cart.get(userId);
    }

    // 장바구니 비우기
    public void clear(String userId) {
        cart.get(userId).clear();
    }

    public void insertCart(String userId) {
        Map<String, Integer> newCart = new HashMap<>();
        cart.put(userId, newCart);
    }
}
