package edu.uade.frontend.app.views;

import edu.uade.backend.app.model.enums.Sexo;

public class StringUtils {
    public static String buildString(int checkValid, String prefix, String suffix) {
        if (checkValid > 0) {
            return prefix + checkValid + suffix;
        }
        return "";
    }

    public static String buildString(Sexo checkValid, String prefix, String suffix) {
        if (checkValid != null) {
            return prefix + checkValid + suffix;
        }
        return "";
    }

    public static String buildString(float checkValid, String prefix, String suffix) {
        if (checkValid != 0.0f) {
            return prefix + checkValid + suffix;
        }
        return "";
    }

    public static String buildString(String checkNotNull, String prefix, String suffix) {
        if (validString(checkNotNull)) {
            return prefix + checkNotNull + suffix;
        }
        return "";
    }

    public static String buildString(String checkNotNull, String returnThis) {
        if (validString(checkNotNull)) {
            return returnThis;
        }
        return "";
    }

    public static String repeat(char character, int nTimes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nTimes; i++) {
            sb.append(character);
        }
        return sb.toString();
    }

    public static String obfuscate(String text) {
        if (validString(text)) {
            return repeat('*', text.length());
        }
        return "";
    }

    public static boolean validString(String text) {
        return text != null && text.length() > 0;
    }
}
