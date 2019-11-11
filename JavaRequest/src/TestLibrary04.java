import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.prefs.Preferences;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class TestLibrary04 {
	private static final String PREF_NAME = "TestLibraru04";
	private static final String USER_ID = "1105014";
	private static final String USER_PASSWORD = "lib456";

//	private static final String LOGIN_FORM_URL = "http://opac.baiust.edu.bd/";
	private static final String LOGIN_ACTION_URL = "http://opac.baiust.edu.bd/cgi-bin/koha/opac-user.pl";
	private static final String USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64; rv:69.0) Gecko/20100101 Firefox/69.0";

	// PreferenceKeys
	private static final String COOKIES_AUTH = "COOKIES_AUTH";
	private static final String COOKIES_TOKEN = "COOKIES_TOKEN";

	private static Map<String, String> mapedUserInfo = new HashMap<String, String>();
	private static Map<String, String> mapLoginCookies = new HashMap<String, String>();

	static Preferences preferences = Preferences.userRoot().node(PREF_NAME);

	static Document d;
	static Response response;
	static String stringLoginStatus = "";
	static boolean booleanLoginStatus = false;
	
	
	public static void main(String[] args) {
		
		if(isNullOrEmpty(preferences.get(COOKIES_AUTH, "")) ||
				isNullOrEmpty(preferences.get(COOKIES_TOKEN, "")) ) {
			System.out.println("NO_COOKIES");
			
			boolean okLogin = loginWithPassword();
			System.out.println("Login Status :" + okLogin);
			
		}else {
			System.out.println("COOKIES_FOUND");
			
			boolean okLogin = loginWithCookies();
			System.out.println("Login Status :" + okLogin);

		}	
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static boolean loginWithCookies() {
		// TODO Auto-generated method stub
		try {
			mapLoginCookies.put(preferences.get(COOKIES_AUTH, ""), preferences.get(COOKIES_TOKEN, ""));
			response = Jsoup.connect(LOGIN_ACTION_URL)
							.cookies(mapLoginCookies)
							.timeout(5000)
							.execute();
			
			booleanLoginStatus = checkLogin(response);
			
			if(booleanLoginStatus) {
				d = Jsoup.parse(response.body());
			}
						
		}
		catch(Exception e ) {
			System.out.println(e.getMessage());
		}
		
		return booleanLoginStatus;
		
	}

	private static boolean loginWithPassword() {
		// TODO Auto-generated method stub
		mappedLoginData();
		try {
			
			response = Jsoup.connect(LOGIN_ACTION_URL)
					.data(mapedUserInfo)
					.userAgent(USER_AGENT)
					.timeout(5000)
					.execute();
			
			booleanLoginStatus = checkLogin(response);
			
			if(booleanLoginStatus) {
				d = Jsoup.parse(response.body());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return booleanLoginStatus;
	}
	
	
	
	
	
	
	
	
	

	private static boolean checkLogin(Response response) {
		// TODO Auto-generated method stub
		
		stringLoginStatus = response.statusMessage();
		//if login happens successfully
		//body woun't contain "incorrect username or password"
		//so this will return false
		booleanLoginStatus = (response.body().contains("incorrect username or password"));
		if(stringLoginStatus.equalsIgnoreCase("ok") && !booleanLoginStatus) {
			savePreference(response);
			return true;
		}
	
		return false;
	}

	
	private static void savePreference(Response response) {
		mapLoginCookies = response.cookies();
		
		for (Map.Entry<String, String> cookies : mapLoginCookies.entrySet()) {
			String key = cookies.getKey();
			String value = cookies.getValue();
			preferences.put(COOKIES_AUTH, key);
			preferences.put(COOKIES_TOKEN, value);
		}
		
	}
	

	public static boolean isNullOrEmpty( String str) {
		if( str != null && !str.trim().isEmpty() )
			return false;
		return true;
	}
	
	private static void mappedLoginData() {

		mapedUserInfo.put("koha_login_context", "opac");
		mapedUserInfo.put("userid", USER_ID);
		mapedUserInfo.put("password", USER_PASSWORD);
		mapedUserInfo.put("btn", "Log in");

	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
