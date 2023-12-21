package service;

import java.util.Scanner;
import vo.Admin;

public class AdminService{

    public void menuAdminLogin() {
        System.out.println("관리자 정보를 입력하세요.");

        Scanner sc = new Scanner(System.in);
        System.out.print("아이디 : ");
        String adminId = sc.next();

        System.out.print("비밀번호 : ");
        String adminPw = sc.next();

        Admin admin = new Admin("jang", "01012346578");

        if (adminId.equals(admin.getId()) && adminPw.equals(admin.getPassword())) {
            System.out.println("\n로그인 성공");
            System.out.println("이름 " + admin.getName() + " 연락처 " + admin.getPhoneNumber());
            System.out.println("아이디 " + admin.getId() + " 비밀번호 " + admin.getPassword());
        } else {
            System.out.println("관리자 정보가 일치하지 않습니다.");
        }
    }
}
