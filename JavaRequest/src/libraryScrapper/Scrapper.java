package libraryScrapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scrapper {

	private static final String PREF_NAME = "TestLibraru04";
	private static final String USER_ID = "1105014";
	private static final String USER_PASSWORD = "lib456";

	private static final String LOGIN_FORM_URL = "http://opac.baiust.edu.bd/";
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

	static ArrayList<JsoupBookClass> jsoupBooks = new ArrayList<JsoupBookClass>();
	static ArrayList<BookClass> mBooks = new ArrayList<BookClass>();

	public static void main(String[] args) {

		try {
			preferences.clear();
		} catch (BackingStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myScrapper();
		myParser();
		

	}

	private static void myParser() {
		try {

			Element userdetails = d.getElementById("userdetails");
			String nameHtml = "h2";

			
			String userName = userdetails.getElementsByTag(nameHtml).text().replaceFirst("Hello,", "");
			System.out.println(userName.trim());

			String checkedStatus = userdetails.getElementById("opac-user-views").child(0).child(0).child(0).text();

//			System.out.println(checkedStatus);

			int checkedBook = Character.getNumericValue(checkedStatus.charAt(checkedStatus.length() - 2));

			if (checkedBook > 0) {

				userdetails = userdetails.getElementById("checkoutst");

				String checkedBookString = userdetails.child(0).text();
//				System.out.println(checkedBookString);

				Element tbody = userdetails.child(2);

				for (int i = 0; i < 3; i++) {
					Elements td = tbody.child(i).getElementsByTag("td");

					Element image = td.get(0);
					Element title = td.get(1);
					Element author = td.get(2);
					Element due_date = td.get(3);
					Element bar_code = td.get(4);
					Element cell_no = td.get(5);
					Element renew = td.get(6);
					Element fines = td.get(7);

					jsoupBooks.add(new JsoupBookClass(image, title, author, due_date, bar_code, cell_no, renew, fines));

				}
//
//				System.out.println(jsoupBooks);
//				System.out.println();

				for (int index = 0; index < checkedBook; index++) {

					String baseUrl = jsoupBooks.get(index).getTitle().baseUri();
//					System.out.println(baseUrl);

					String bookTitle = jsoupBooks.get(index).getTitle().text().trim();
//					System.out.println(bookTitle);

					String bookDetailUrl = baseUrl
							+ jsoupBooks.get(index).getTitle().getElementsByTag("a").attr("href");
//					System.out.println(" URL : "+ bookDetailUrl);
					
					
					String bookImageUrl = jsoupBooks.get(index).getImage().getElementsByTag("img").attr("src");
//					System.out.println(bookImageUrl);
					boolean isBookImageExists = true;

					String bookAuthor = jsoupBooks.get(index).getAuthor().text();
//					System.out.println(bookAuthor);

					String bookDueDate = jsoupBooks.get(index).getDue_date().text();
//					System.out.println(bookDueDate);

					String bookBarCode = jsoupBooks.get(index).getBar_code().text();
//					System.out.println(bookBarCode);

					String bookCellNo = jsoupBooks.get(index).getCell_no().text();
//					System.out.println(bookCellNo);

					String bookReniewStatus = "";
					boolean isBookReniewAvl = false;

					if (jsoupBooks.get(index).getRenew().childNodeSize() > 1) {
						bookReniewStatus = jsoupBooks.get(index).getRenew().getElementsByClass("renewals").text();
						isBookReniewAvl = true;
//						System.out.println(bookReniewStatus + isBookReniewAvl);

					} else {
						bookReniewStatus = jsoupBooks.get(index).getRenew().text();
//						System.out.println(bookReniewStatus);

					}

					String bookReniewLink = "NotDesignedYet";

					String bookFines = jsoupBooks.get(index).getFines().text();
//					System.out.println(bookFines);

					mBooks.add(new BookClass(bookTitle, bookDetailUrl, bookImageUrl, isBookImageExists, bookAuthor,
							bookDueDate, bookBarCode, bookCellNo, bookReniewStatus, isBookReniewAvl, bookReniewLink,
							bookFines));
					
					System.out.println();

				}

				System.out.println(mBooks);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	
	
	
	
	
	
	
	

	private static void myScrapper() {

		if (isNullOrEmpty(preferences.get(COOKIES_AUTH, "")) || isNullOrEmpty(preferences.get(COOKIES_TOKEN, ""))) {
			System.out.println("NO_COOKIES");

			boolean okLogin = loginWithPassword();
			System.out.println("Login Status :" + okLogin);

		} else {
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

			if (booleanLoginStatus) {
				d = Jsoup.parse(response.body(),LOGIN_FORM_URL);
			}

		} catch (Exception e) {
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

			if (booleanLoginStatus) {
				d = Jsoup.parse(response.body(),LOGIN_FORM_URL);
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
		// if login happens successfully
		// body woun't contain "incorrect username or password"
		// so this will return false
		booleanLoginStatus = (response.body().contains("incorrect username or password"));
		if (stringLoginStatus.equalsIgnoreCase("ok") && !booleanLoginStatus) {
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

	public static boolean isNullOrEmpty(String str) {
		if (str != null && !str.trim().isEmpty())
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
