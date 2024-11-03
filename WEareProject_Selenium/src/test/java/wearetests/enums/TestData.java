package wearetests.enums;

public enum TestData {
    USER_USERNAME("teamthree"),
    USER_PASSWORD("test123"),
    USER_EMAIL("test@gmail.com"),
    ADMIN_USERNAME("testadmin"),
    ADMIN_PASSWORD("admin123"),
    ADMIN_EMAIL("admin@gmail.com"),
    REGISTER_USERNAME("newuser"),
    REGISTER_PASSWORD("test123"),
    REGISTER_EMAIL("test@gmail.com"),
    UPDATE_FIRSTNAME("Ivan"),
    UPDATE_LASTNAME("Ivanov"),
    UPDATE_BIRTHDAY("1111\t1990"),
    UPDATE_EMAIL("ivan@gmail.com"),
    UPDATE_ABOUT_ME("Hello, me name is Ivan and I'm testing this social network.");





    TestData(String propName) {
        value = propName;
    }

    public String getValue() {
        return value;
    }

    final String value;
}
