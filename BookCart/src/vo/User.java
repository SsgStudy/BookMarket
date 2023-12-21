package vo;

public class User extends Person {
    public User(String name, String phoneNumber) {
        super(name, phoneNumber);
    }

    public User(String username, String phoneNumber, String address) {
        super(username, phoneNumber, address);
    }
}
