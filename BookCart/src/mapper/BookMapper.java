package mapper;

import entity.Book;
import vo.CartElement;

import java.util.List;
import java.util.Map;

public interface BookMapper {

    // C
    void save(String userId, CartElement element);

    // R
    List<Book> findAll();
    Book findByBookId(String bookId);
    Map<String, Integer> findCartByUserId(String userId);

    // U

    // D
    void clear(String userId);

}
