package entity;

public class Admin extends Person{
    private String id = "Admin";
    private String password = "Admin1234";


    public Admin(Builder builder) {
        super(builder);
    }
}
