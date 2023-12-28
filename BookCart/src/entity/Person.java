package entity;

public class Person {
    private final String id;
    private final String password;
    private final String name;
    private final String phoneNumber;
    private final String address;

    public Person(Builder builder) {
        this.id = builder.id;
        this.password = builder.password;
        this.name = builder.name;
        this.phoneNumber = builder.phoneNumber;
        this.address = builder.address;
    }

    public static class Builder {
        private String id;
        private String password;
        private final String name;
        private final String phoneNumber;

        private String address;

        public Builder(String id, String password, String name, String phoneNumber) {
            this.id = id;
            this.password = password;
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        public Builder address(String val) {
            address=val;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
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
