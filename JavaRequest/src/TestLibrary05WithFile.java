import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestLibrary05WithFile {

	static Document d = null;

	public static void main(String[] args) {
		File file = new File("/home/hasib/MarziaTurna.html");
		ArrayList<jsoupBook> jsoupBooks = new ArrayList<jsoupBook>();
		ArrayList<book> mBooks = new ArrayList<book>();

//		System.out.println(file.exists());

		try {
			d = Jsoup.parse(file, "UTF-8", "http://example.com/");

			Element userdetails = d.getElementById("userdetails");
			String nameHtml = "h2";

			String userName = userdetails.getElementsByTag(nameHtml).text().replaceFirst("Hello,", "");
			System.out.println(userName.trim());

			String checkedStatus = userdetails.getElementById("opac-user-views").child(0).child(0).child(0).text();

			System.out.println(checkedStatus);
			
			int checkedBook = Character.getNumericValue(checkedStatus.charAt(checkedStatus.length()-2));

			
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

					jsoupBooks.add(new jsoupBook(image, title, author, due_date, bar_code, cell_no, renew, fines));

				}
//
//				System.out.println(jsoupBooks);
//				System.out.println();

				for (int index = 0; index < checkedBook; index++) {

					String baseUrl = jsoupBooks.get(0).getTitle().baseUri();
//					System.out.println(baseUrl);

					String bookTitle = jsoupBooks.get(index).getTitle().text().trim();
//					System.out.println(bookTitle);

					String bookDetailUrl = baseUrl
							+ jsoupBooks.get(index).getTitle().getElementsByTag("a").attr("href");
//					System.out.println(bookDetailUrl);

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

					mBooks.add(new book(bookTitle, bookDetailUrl, bookImageUrl, isBookImageExists, bookAuthor,
							bookDueDate, bookBarCode, bookCellNo, bookReniewStatus, isBookReniewAvl, bookReniewLink,
							bookFines));

				}

				System.out.println(mBooks);

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

//System.out.println(userdetails.getElementById("checkoutst"));

//System.out.println(userdetails
//.getElementsByTag(nameHtml)
//.text().replaceFirst("Hello,", ""));

//System.out.println(userdetails
//.getElementById("opac-user-views")
//.child(0)
//.child(0)
//.child(0)
//.text().charAt(13));

//System.out.println(userdetails);

//tableHeader
//Element theader = userdetails.child(1).child(0);
//System.out.println(theader);
//System.out.println();
//
//System.out.println(theader.child(0).text());
//System.out.println(theader.child(1).text());
//System.out.println(theader.child(2).text());
//System.out.println(theader.child(3).text());

//System.out.println(tbody.child(2).getElementsByTag("td").get(0));

//SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//String dateString = books.get(index).getDue_date().text().split(" ")[2]; 
//try {
//	Date date1 = dateFormat.parse(dateString);
//	
//	System.out.println();
//	System.out.println(dateFormat.format(date1));
//	
//	Date date2 = dateFormat.parse(dateString);
//
//	System.out.println();
//	System.out.println(dateFormat.format(date2));
//	
//	long diff = Math.abs(date1.getTime() - date2.getTime());
//	long diffDays = diff / (24 * 60 * 60 * 1000);
//	System.out.println(diffDays);
//} catch (ParseException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
//
//System.out.println();

//System.out.println(books.get(index).getRenew().getElementsByClass("renewals"));
//System.out.println(books.get(index).getRenew().text());
//System.out.println(books.get(2).getRenew().text().equalsIgnoreCase("Not renewable"));
