package site.nomoreparties.stellarburgers.utils;

import org.apache.commons.lang3.RandomStringUtils;
import site.nomoreparties.stellarburgers.pojos.UserRequest;

public class UsersUtils {
    public static UserRequest getUniqueUser() {
        return new UserRequest(
                RandomStringUtils.randomAlphanumeric(10) + "@yandex.ru",
                RandomStringUtils.randomAlphanumeric(10),
                RandomStringUtils.randomAlphanumeric(10)
        );
    }
}
