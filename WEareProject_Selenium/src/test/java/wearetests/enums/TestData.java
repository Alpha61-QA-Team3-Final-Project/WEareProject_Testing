package wearetests.enums;

import static wearetests.core.RandomDataGenerator.*;

public enum TestData {
    USER_USERNAME("teamthree"),
    USER_PASSWORD("test123"),
    USER_EMAIL("test@gmail.com"),
    ADMIN_USERNAME("testadmin"),
    ADMIN_PASSWORD("admin123"),
    ADMIN_EMAIL("admin@gmail.com"),
    REGISTER_USERNAME(generateUsername()),
    REGISTER_PASSWORD("test123"),
    REGISTER_EMAIL(generateEmail()),
    USER_ACCEPT_CONNECTION_USER("newuserthree"),
    USER_ACCEPT_CONNECTION_PASSWORD("test123"),
    UPDATE_FIRSTNAME("Daniel"),
    UPDATE_LASTNAME("Petrov"),
    UPDATE_BIRTHDAY("11111986"),
    UPDATE_EMAIL("daniel@gmail.com"),
    UPDATE_ABOUT_ME("Hello, my name is Daniel and I updated my info.");

    private final String value;


    TestData(String propName) {
        value = propName;
    }

    public String getValue() {
        return value;
    }
}
