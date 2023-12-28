import java.util.List;
import java.util.Scanner;
import service.AdminService;
import service.BookService;
import service.UserService;
import vo.CartElement;
import vo.User;

public class BookMain {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        UserService userService = new UserService();
        BookService bookService = new BookService();
        AdminService adminService = new AdminService();

        //고객 정보 입력
        System.out.print("당신의 이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("연락처를 입력하세요 : ");
        String phoneNumber = sc.nextLine();

        //customer1 고객 객체 생성 & 기입
        User user1 = new User(name, phoneNumber);
        userService.join(user1);

        // 실행 문구
        printWelcome();

        while (true) {
            //메뉴 선택
            printMenu();
            //선택 번호 입력
            int chNumber = sc.nextInt();
            //번호별 메뉴 실행
            switch (chNumber) {
                case 1 -> //고객 정보 확인하기
                        userService.menuGuestInfo(user1);
                case 2 ->  //장바구니 상품 목록 보기
                {
                    List<CartElement> list1 = bookService.getUserCart(user1.getId());
                    for (CartElement cartElement : list1) {
                        System.out.println(cartElement);
                    }

                }
                case 3 -> // 장바구니 항목 비우기
                        bookService.clearAll(user1.getId());
                case 4 -> { //바구니에 항목 추가하기
                    bookService.getAllBooks();
                    bookService.addBook(user1.getId());
                }
                case 5 -> System.out.println("장바구니 수량 줄이기");
                case 6 -> System.out.println("장바구니 항목 삭제하기");
                case 7 -> System.out.println("영수증 표시하기");
                case 8 -> { // 종료
                    System.out.println("종료되었습니다.");
                    return;
                }
                case 9 ->  // 관리자 로그인
                        adminService.menuAdminLogin();
                default -> System.out.println("다시 입력해주세요.");
            }
        }
    }

    public static void printWelcome() {
        System.out.println("***********************************");
        System.out.println("        Welcome to Shopping Mall");
        System.out.println("        Welcome to Book Market!");
    }

    public static void printMenu() {
        System.out.println("***********************************");
        System.out.println("1. 고객 정보 확인하기");
        System.out.println("2. 장바구니 상품 목록 보기");
        System.out.println("3. 장바구니 항목 비우기");
        System.out.println("4. 바구니에 항목 추가하기");
        System.out.println("5. 장바구니 수량 줄이기");
        System.out.println("6. 장바구니 항목 삭제하기");
        System.out.println("7. 영수증 표시하기");
        System.out.println("8. 종료");
        System.out.println("***********************************");
    }
}