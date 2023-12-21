package service;

import mapper.PersonMapper;
import vo.Person;

public class UserService{
    private PersonMapper personMapper = new PersonMapper();

    // 회원가입 (성공시 1 반환)
    public int join(Person person) {
        if (checkPersonInfo(person)) {
            personMapper.save(person);
            return 1;
        } else {
            return 0;
        }
    }

    // 사용자 정보 유효성 검사
    public boolean checkPersonInfo(Person person) {
        if (personMapper.findById(person.getId()) == null) {
            System.out.println("유효한 아이디 입니다.");
            return true;
        } else {
            System.out.println("이미 존재하는 아이디 입니다.");
            return false;
        }
    }

    // 사용자 정보 출력
    public void menuGuestInfo(Person person) {
        System.out.println("현재 고객 정보 : ");
        System.out.println("이름 " + person.getName() + "연락처 " + person.getPhoneNumber());
    }
}
