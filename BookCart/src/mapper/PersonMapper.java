package mapper;

import entity.Person;

public interface PersonMapper {
    void save(Person person);
    Person findById(String id);
}
