package vo;

public class Person {
    private String id;
    private String password;
    private String name;
    private String phoneNumber;
    private String address;

    public Person() {}

    public Person(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Person(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getPassword() { return password; }
    public String getAddress() { return address; }
}
