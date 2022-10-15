package site.nomoreparties.stellarburgers.testData;

import org.apache.commons.lang3.RandomStringUtils;

public class TestData {
    private final String NAME_REAL = "Evgenii";
    private final String EMAIL_REAL = "eucrabs@yandex.ru";
    private final String PASSWORD_REAL = "Qwerty123";
    private final String EMAIL_FAKE = String.format("%s@yandex.ru", RandomStringUtils.randomAlphanumeric(10));
    private final String PASSWORD_FAKE = RandomStringUtils.randomAlphanumeric(9);
    private final String BUNS = "Булки";
    private final String SOUSE = "Соусы";
    private final String FILLING = "Начинки";

    public String getNAME_REAL() {
        return NAME_REAL;
    }

    public String getEMAIL_REAL() {
        return EMAIL_REAL;
    }

    public String getPASSWORD_REAL() {
        return PASSWORD_REAL;
    }

    public String getEMAIL_FAKE() {
        return EMAIL_FAKE;
    }

    public String getPASSWORD_FAKE() {
        return PASSWORD_FAKE;
    }

    public String generateRandomLengthString(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    public String getBUNS() {
        return BUNS;
    }

    public String getSOUSE() {
        return SOUSE;
    }

    public String getFILLING() {
        return FILLING;
    }
}
