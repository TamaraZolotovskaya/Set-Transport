package transport;

public class StringUtils {
    public StringUtils() {
    }

    public static boolean IsNullOrBlank(String s)
    {
        return s == null || s.isBlank();
    }
}
