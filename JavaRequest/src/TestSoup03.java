import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class TestSoup03  {

	public ArrayList<aSinglePeriod> ap;
	
 	
	public static void main(String[] args){
		
		ArrayList<aDayRoutine> dayRoutine = new ArrayList<aDayRoutine>(6);
		System.out.println(dayRoutine.size());
		
		final String url = 
				"http://routine.baiust.edu.bd/?department_id=1&semester=15";
		try {
			Document doc = Jsoup.connect(url).get();
			for(int i = 2; i <= 10; i++ ) {
				
				String time = doc.select("thead > tr > th:nth-of-type("+i+")").text();
				System.out.println(time);
				String day = "";
				for(Element row : doc.select(
						"table.table-bordered tr")) {
					
					if(row.select("td:nth-of-type("+i+")").text().isEmpty()) {
//						continue;
//						day = "No Class";
						System.out.println("No");
						day = "";
					}
					
					else {
						
						day = row.select("td:nth-of-type("+ i +") > div > p:nth-of-type(1)").text();
						System.out.println(day);
						day = "";
					}
					
					
				}
				
				
				
			}
						
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	
}
