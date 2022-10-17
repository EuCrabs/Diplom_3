package site.nomoreparties.stellarburgers.constants;

import site.nomoreparties.stellarburgers.utils.ConfigFileReader;

public class BaseConstants {
    public final static String BASE_TEST_URL = new ConfigFileReader().getApplicationUrl();
}
