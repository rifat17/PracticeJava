import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class TesrJsoup01 {

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
				"http://routine.baiust.edu.bd/?department_id=1&semester=12";
		try {
			Document doc = Jsoup.connect(url).get();
			
//			Elements table = doc.select("table");
//			System.out.println(table);
//			Elements tbody = table.select("tbody");
//			System.out.println(tbody);
			
			LinkedHashMap<String,String > trClass = new LinkedHashMap<String, String>();
			
			trClass = mapEntry(trClass);
//			System.out.println(trClass);
//			
//			for( Object key : trClass.keySet() ) {
//				Object value = trClass.get(key);
//				System.out.println(value);
//			}
//			
			
//			Elements adaytr = doc.select("tr." + trClass.get("Monday"));
//			System.out.println(adaytr);
//			System.out.println("tr." + trClass.get("Sunday"));
			
//			Elements divinsideTR = adaytr.select("div");
//			System.out.println(divinsideTR);
			

//			Elements p = divinsideTR.select("p");
//			System.out.println(p.get(0).text());
//			System.out.println(p.get(1).text());
//			System.out.println(p.get(2).text());
			
		
			for( Object key : trClass.keySet() ) {
			Object value = trClass.get(key);
			System.out.println(value);
			System.out.println(key);
			Elements adaytr = doc.select("tr." + trClass.get(key));
//			Elements divinsideTR = adaytr.select("div");
//			Elements allP = divinsideTR.select("p");
			
//			System.out.println(p.get(0).text());
//			System.out.println(p.get(1).text());
//			System.out.println(p.get(2).text());
//			System.out.println(p);
//			p.stream().forEach(x -> System.out.println(x.text()));
//			System.out.println(allP);
			
			String courseId = "";
			String teacherAndRoom = "";
			String section = "";
			
			for(Element divinsideTR : adaytr.select("div")) {
//				System.out.println(divinsideTR.getElementsByTag("p").text());
//				System.out.println(divinsideTR.getElementsByTag("p").get(0).text());
//				System.out.println(divinsideTR.getElementsByTag("p").get(1).text());
//				System.out.println(divinsideTR.getElementsByTag("p").get(2).text());
				
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

//			
		}
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	
}
