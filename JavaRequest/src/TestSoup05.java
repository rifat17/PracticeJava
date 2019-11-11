import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class TestSoup05   {

	public ArrayList<aSinglePeriod> ap;
	
 	
	public static void main(String[] args){
		
		
		LinkedHashMap<Integer, String> dayTime = new LinkedHashMap<Integer, String>();
		LinkedHashMap<Integer, String> dayList = new LinkedHashMap<Integer, String>();
		dayList.put(1,"SUN");
		dayList.put(2,"MON");
		dayList.put(3,"TUE");
		dayList.put(4,"WED");
		dayList.put(5,"THU");
		
		LinkedHashMap<String, String> dayColor = new LinkedHashMap<String, String>();
		
		dayColor.put("SUN","bg-danger.text-light");
		dayColor.put("MON" , "bg-info.text-light" );
		dayColor.put("TUE","bg-success.text-light");
		dayColor.put("WED" , "bg-dark.text-light");
		dayColor.put("THU", "bg-primary.text-light");
		
//		for( Integer i = 1; i < 10; i++) {
//			dayList.put(i, (Integer.valueOf( i + 1)).toString());
//		}

//		for(Integer e : dayList.keySet()) {
//			System.out.println(e);
//			System.out.println(dayList.get(e));
//		}
		
		
		final String url = 
				"http://routine.baiust.edu.bd/?department_id=1&semester=12";
		try {
			Document doc = Jsoup.connect(url)
					.userAgent("Mozilla/5.0 (X11; Linux x86_64; rv:69.0) Gecko/20100101 Firefox/69.0")
					.method(Method.GET)
					.timeout(5000)
					.get();
			
			for(int i = 1; i <= 10; i++ ) {
				
//				System.out.println(doc.select("th:nth-of-type("+ i + ")").text());
				Integer keyInteger = new Integer(i);
				String value = doc.select("th:nth-of-type("+ i + ")").text();
				dayTime.put(keyInteger, value);
			}
//			System.out.println(dayTime);
			
			//scraping start here
			
			for(String key : dayColor.keySet()) {
				
				String aDayColorValue = dayColor.get(key);
				System.out.println(key);
			
				for(int i = 1; i <= 10; i++) {
					
					if( i == 1) {
						//it must be a day value
					}
					
					else {
						//check if any field is empty
						if(doc.select("." + aDayColorValue +" > td:nth-of-type("+ i +")").text().equals("") || 
								doc.select("." + aDayColorValue +" > td:nth-of-type("+ i +")").text().equals("Launch")) {
							
							//check why empty,is it  OFFclass or Lunch time
							
							if( i != 5 || i != 9) { //5th and 9th period is lunch time
									//field is empty and not lunch time,that means classOff in this period :) 
							}
							else {
									// Lunch Time
							}
						}
						
						
						else {
							String courseCode = doc.select("." + aDayColorValue +" > td:nth-of-type("+ i +") > div > p:nth-of-type(1)").text();
							String teachersName = doc.select("." + aDayColorValue +" > td:nth-of-type("+ i +") > div > p:nth-of-type(2) > span:nth-of-type(1)").text();
							String classRoomNo = doc.select("." + aDayColorValue +" > td:nth-of-type("+ i +") > div > p:nth-of-type(2) > span:nth-of-type(2)").text();
							String sectionValue = doc.select("." + aDayColorValue +" > td:nth-of-type("+ i +") > div > p:nth-of-type(3)").text();
//																		td:nth-of-type(4) > div > p:nth-of-type(3)
							String classTime = dayTime.get(i);
//							System.out.println(sectionValue);
							aSinglePeriod asp = new aSinglePeriod(courseCode, teachersName, classRoomNo, classTime, sectionValue,true);
							System.out.println(asp);
							
							
						}
					}
				}
				
//				
		}

						
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error");
			System.out.println(e.getMessage());
		}
	}
	
	
}
