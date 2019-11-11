import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.prefs.Preferences;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class TestLibrary {

	public static void main(String[] args) {
		final String USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64; rv:69.0) Gecko/20100101 Firefox/69.0";
		String loginFormUrl = "http://opac.baiust.edu.bd/";
		String loginActionUrl = "http://opac.baiust.edu.bd/cgi-bin/koha/opac-user.pl";

		String loginUsernamr = "1105081";
		String loginPassword = "baiustlib";
		
		Preferences preferences = Preferences.userNodeForPackage(TestLibrary.class);

		
		Map<String, String> mapLoginPageCookies = null;
		
		
//		try {
//			Response loginPageResopnse = 
//					Jsoup.connect(loginActionUrl)
//					.referrer(loginFormUrl)
//					.userAgent(USER_AGENT)
//					.timeout(50000)
//					.execute();
			
//			System.out.println("Fetched");
			
			
//			Map<String, String> mapLoginPageCookies = loginPageResopnse.cookies();
			
//			System.out.println(mapLoginPageCookies);
			
//			Map<String, String> mapParams = new HashMap<String, String>();
//			
//			mapParams.put("koha_login_context","opac");
//			mapParams.put("userid",loginUsernamr);
//			mapParams.put("password", loginPassword);
//			mapParams.put("btn","Log in");
//			
//			Response responsePostLogin = 
//					Jsoup.connect(loginActionUrl)
//					.referrer(loginActionUrl)
//					.userAgent(USER_AGENT)
//					.timeout(5000)
//					.data(mapParams)
////					.cookies(mapLoginPageCookies)
//					.execute();
//			mapLoginPageCookies = responsePostLogin.cookies();
			
			
//			for(Map.Entry<String, String> e: mapLoginPageCookies.entrySet()) {
//				System.out.println(e.getKey());
//				System.out.println(e.getValue());
//				preferences.put("KEY",e.getKey());
//				preferences.put("VALUE",e.getValue());
//
//			}
//			
			
//			System.out.println(responsePostLogin.statusCode());
			
//			Document doc = responsePostLogin.parse();
//			System.out.println(doc);
			
//			String op = doc.select(".table-striped.table-bordered.table").text();
//			String op = doc.select("tbody>tr>td").text();

//			System.out.println(op);
//			System.out.println();
			
//		}catch(IOException e) {
//			System.out.println(e.getMessage());
//		}
		
//		System.out.println(mapLoginPageCookies);
		
		try {
			
			Map<String, String> mp = new HashMap<String, String>();
			mp.put(preferences.get("KEY",null),preferences.get("VALUE", null));
			Document d = Jsoup.connect(loginActionUrl).
								cookies(mp)
								.timeout(5000)
								.get();
			String op = d.select("tbody>tr>td").text();
			System.out.println(op);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	
	
	
	
}
