package service;

import entity.Person;
import mapper.PersonMapperImpl;

import java.util.Scanner;

public class UserService{
    private PersonMapperImpl personMapper = new PersonMapperImpl();
    private BookService bookService = new BookService();

    static Scanner sc = new Scanner(System.in);

    // 회원가입 (성공시 1 반환)
    public String join() {
        Person user = inputSignInForm();

        if (checkPersonInfo(user)) {
            personMapper.save(user);
            bookService.createUserBookCart(user.getId());
            System.out.println("회원가입 성공");
            return user.getId();
        } else {
            System.out.println("회원가입 실패");
            return null;
        }
    }

    private Person inputSignInForm() {
        //고객 정보 입력
        System.out.print("당신의 이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("연락처를 입력하세요 : ");
        String phoneNumber = sc.nextLine();
        System.out.print("아이디를 입력하세요 : ");
        String id = sc.nextLine();
        System.out.print("비밀번호를 입력하세요 : ");
        String password = sc.nextLine();

        return new Person.Builder(id, password, name, phoneNumber).build();
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
    public void menuGuestInfo(String userId) {
        Person person = personMapper.findById(userId);
        System.out.println("현재 고객 정보 : ");
        System.out.println("이름 " + person.getName() +
                            " 연락처 " + person.getPhoneNumber() +
                            " 아이디 " + person.getId());
    }
}
