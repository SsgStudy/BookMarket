package mapper;

import java.util.HashMap;
import java.util.Map;
import entity.Person;

public class PersonMapperImpl implements PersonMapper{
    private final Map<String, Person> store = new HashMap<>();

    // 회원가입
    public void save(Person person) {
        store.put(person.getId(), person);
    }

    // 사용자 조회
    public Person findById(String id) {
        return store.get(id);
    }
}
