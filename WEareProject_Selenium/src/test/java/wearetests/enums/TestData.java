package wearetests.enums;

public enum TestData {
    USER_USERNAME("teamthree"),
    USER_PASSWORD("test123"),
    USER_EMAIL("test@gmail.com"),
    ADMIN_USERNAME("testadmin"),
    ADMIN_PASSWORD("admin123"),
    ADMIN_EMAIL("admin@gmail.com"),
    REGISTER_USERNAME("newuserthree"),
    REGISTER_PASSWORD("test123"),
    REGISTER_EMAIL("test@gmail.com"),
    USER_ACCEPT_CONNECTION_USER("newuserthree"),
    USER_ACCEPT_CONNECTION_PASSWORD("test123"),
    UPDATE_FIRSTNAME("Daniel"),
    UPDATE_LASTNAME("Petrov"),
    UPDATE_BIRTHDAY("1111\t1986"),
    UPDATE_EMAIL("daniel@gmail.com"),
    UPDATE_ABOUT_ME("Hello, my name is Daniel and I updated my info.");





    TestData(String propName) {
        value = propName;
    }

    public String getValue() {
        return value;
    }

    final String value;
}
