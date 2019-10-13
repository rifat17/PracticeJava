import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class TestJsoup02 {

	public static LinkedHashMap<String, String> mapEntry(LinkedHashMap<String, String> mp) {
		mp.put("Sunday","bg-danger.text-light");
		mp.put("Monday" , "bg-info.text-light" );
		mp.put("Thuesday","bg-success.text-light");
		mp.put("Wednesday" , "bg-dark.text-light");
		mp.put("Thursday", "bg-primary.text-light");
		
		
		return mp;
		
	}
	public ArrayList<aSinglePeriod> ap;
	
 	
	public static void main(String[] args){
		
		
		final String url = 
				"http://routine.baiust.edu.bd/?department_id=1&semester=5";
		try {
			Document doc = Jsoup.connect(url).get();
					
			LinkedHashMap<String,String > trClass = new LinkedHashMap<String, String>();
			
			trClass = mapEntry(trClass);
		
		
			for( Object key : trClass.keySet() ) {
			Object value = trClass.get(key);
			System.out.println(value);
			System.out.println(key);
			Elements adaytr = doc.select("tr." + trClass.get(key));
			
			String courseId = "";
			String teacherAndRoom = "";
			String section = "";
			
			for(Element divinsideTR : adaytr.select("div")) {
				System.out.println(divinsideTR.getElementsByTag("p").get(2).text());
				
				courseId = divinsideTR.getElementsByTag("p").get(0).text();
				teacherAndRoom = divinsideTR.getElementsByTag("p").get(1).text();
				section = divinsideTR.getElementsByTag("p").get(2).text();
			}
			
			System.out.println(courseId);
			String[] x = teacherAndRoom.split(",");
			System.out.println(x[0]);
			System.out.println(x[1].trim());
			System.out.println(section);
			
			System.out.println();
			System.out.println();
		
		}
						
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	
}
