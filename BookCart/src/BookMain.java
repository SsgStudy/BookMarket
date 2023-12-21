import java.util.Scanner;
import service.AdminService;
import service.BookService;
import service.UserService;
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
                        bookService.getUserCart(user1.getId()).stream()
                                .forEach(book -> System.out.println(book));
                case 3 -> { //바구니에 항목 추가하기
                    bookService.getAllBooks();
                    bookService.addBook(user1.getId());
                }
                case 4 ->  // 관리자 로그인
                        adminService.menuAdminLogin();
                case 5 -> { // 종료
                    System.out.println("종료되었습니다.");
                    return;
                }
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
        System.out.println("3. 바구니에 항목 추가하기");
        System.out.println("4. 관리자 로그인");
        System.out.println("5. 종료");
        System.out.println("***********************************");
    }
}