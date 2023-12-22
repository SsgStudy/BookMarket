package mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vo.Book;
import vo.CartElement;

public class BookMapper {
    private Map<String, Book> books = new HashMap<>();
    private Map<String, List<CartElement>> cart = new HashMap<>();

    public BookMapper() {
        books.put("ISBN1234", new Book("ISBN1234", "쉽게 배우는 JSP 웹 프로그래밍", 27000, "송미영", "단계별로 쇼핑몰을 구현하며 배우는 JSP 웹 프로그래밍", "IT전문서", "2018/10/08"));
        books.put("ISBN1235", new Book("ISBN1235", "안드로이드 프로그래밍", 33000, "우재남", "실습 단계별 명쾌한 멘토링!", "IT전문서", "2022/01/22"));
        books.put("ISBN1236", new Book("ISBN1236", "스크래치", 22000, "고광일", "컴퓨팅 사고력을 키우는 블록 코딩", "컴퓨터 입문", "2019/06/10"));
    }

    // 장바구니에 도서 담기
    public void save(String userId, String bookId) {
        List<CartElement> userCart = cart.get(userId);
        boolean flag = false;

        if (userCart == null) {
            userCart = new ArrayList<>();
            cart.put(userId, userCart);
        }
        for (int i = 0; i < userCart.size(); i++) {
            if(userCart.get(i).getBook().getBookId().equals(bookId))
            {
                flag = true;
                cart.get(userId).get(i).plusAmount();
                break;
            }
        }
        if(flag == false)
        {
            cart.get(userId).add(new CartElement(books.get(bookId)));
        }
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
    public List<CartElement> findCartByUserId(String userId) {
        return cart.get(userId);
    }

    public void clear(String userId)
    {
        List<CartElement> userCart = cart.get(userId);
        userCart.clear();
    }
}
