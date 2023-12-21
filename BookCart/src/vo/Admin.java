package vo;

public class Admin extends Person{
    private String id = "Admin";
    private String password = "Admin1234";

    public Admin(String name, String phoneNumber) {
        super(name, phoneNumber);
    }
}
