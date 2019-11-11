import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.prefs.Preferences;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Request;
import org.jsoup.Connection.Response;

public class TestLibraru02 {

	private static final String PREF_NAME = "TestLibraru02";
	private static final String USER_ID = "1105081";
	private static final String USER_PASSWORD = "baiustlib";

	private static final String LOGIN_FORM_URL = "http://opac.baiust.edu.bd/";
	private static final String LOGIN_ACTION_URL = "http://opac.baiust.edu.bd/cgi-bin/koha/opac-user.pl";
	private static final String USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64; rv:69.0) Gecko/20100101 Firefox/69.0";

	// PreferenceKeys
	private static final String COOKIES_KEY = "COOKIES_KEY";
	private static final String COOKIES_VALUE = "COOKIES_VALUE";

	private static Map<String, String> mapUserInfo = new HashMap<String, String>();
	private static Map<String, String> mapLoginCookies = new HashMap<String, String>();

	static Preferences preferences = Preferences.userRoot().node(PREF_NAME);

	static Document d = null;

	public static void main(String[] args) {

		Response response = null;

//		initALL();
		initALL("1105014", "lib456");

		preferences.remove(COOKIES_KEY);
		preferences.remove(COOKIES_VALUE);

		if (preferences.get(COOKIES_KEY, "").isEmpty() || preferences.get(COOKIES_VALUE, "").isEmpty()) {
			response = loginWithPass(response);

			if (response.statusMessage().equals("ok"))
				System.out.println("Logged with PassWord");
		} else {
			response = loginWithCookies(response);
			System.out.println("Logged without PassWord");
		}

		d = Jsoup.parse(response.body());
		Element ediv = d.getElementById("userdetails");

		try {
			int Size = ediv.childNodeSize();
			for (int i1 = 0; i1 < Size; i1++) {
				if (ediv.child(i1).hasText())
					System.out.println(ediv.child(i1).text());
			}
		} catch (Exception e) {
//			System.out.println(e.getMessage());
		}

	}

	private static Response loginWithCookies(Response response) {
		try {
			response = Jsoup.connect(LOGIN_ACTION_URL).cookies(mapLoginCookies).method(Method.POST).timeout(5000)
					.execute();
			d = response.parse();
			return response;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	private static Response loginWithPass(Response response) {

		try {
			response = Jsoup.connect(LOGIN_ACTION_URL).userAgent(USER_AGENT).data(mapUserInfo).method(Method.POST)
					.timeout(5000).execute();
			mapLoginCookies = response.cookies();

			for (Map.Entry<String, String> cookies : mapLoginCookies.entrySet()) {
				String key = cookies.getKey();
				String value = cookies.getValue();
				preferences.put(COOKIES_KEY, key);
				preferences.put(COOKIES_VALUE, value);
			}

			return response;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	private static void initALL() {

		mapUserInfo.put("koha_login_context", "opac");
		mapUserInfo.put("userid", USER_ID);
		mapUserInfo.put("password", USER_PASSWORD);
		mapUserInfo.put("btn", "Log in");

	}

	private static void initALL(String USER_ID, String USER_PASSWORD) {

		mapUserInfo.put("koha_login_context", "opac");
		mapUserInfo.put("userid", USER_ID);
		mapUserInfo.put("password", USER_PASSWORD);
		mapUserInfo.put("btn", "Log in");

	}

}

//Line 61
//System.out.println(d.select("h2").text());
//System.out.println(d.select(".span10 > userdetails.maincontent >opac-user-views.toptabs").text());
//System.out.println(d.select(".span10"));

//Line