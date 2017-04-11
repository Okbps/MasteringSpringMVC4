package masterSpringMvc.utils;

import java.util.Base64;

/**
 * Created by Aspire on 09.04.2017.
 */
public class AuthUtil {
    public static String basicAuth(String login, String password) {
        byte[] auth = (login + ":" + password).getBytes();
        return "Basic " + Base64.getEncoder().encodeToString(auth);
    }
}
