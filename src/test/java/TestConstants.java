import java.util.regex.Pattern;


public class TestConstants {
	public static final Pattern URL_PATT = Pattern.compile("<input name=\"url\" id=\"url\" type=\"text\" class=\"input\" readonly=\"readonly\" value=\"([^\"]+)\"");
	public static final Pattern SINA_URL_PATT = Pattern.compile("\\[\\{\"url_short\":\"([^\"]+)");
	public static final int size = 100;
}
