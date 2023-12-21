package mapper;

import java.util.HashMap;
import java.util.Map;
import vo.Person;

public class PersonMapper {
    private Map<String, Person> store = new HashMap<>();

    // 회원가입
    public void save(Person person) {
        store.put(person.getId(), person);
    }

    // 사용자 조회
    public Person findById(String id) {
        return store.get(id);
    }
}
