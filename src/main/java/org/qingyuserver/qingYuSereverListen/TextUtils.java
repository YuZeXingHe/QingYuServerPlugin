package org.qingyuserver.qingYuSereverListen;

public abstract class TextUtils {
    private TextUtils() {}

    public static String parseColor(String text) {
        return text.replace("&", "§").replace("§§", "&");
    }
}
