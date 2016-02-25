import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.regex.*;

public class SimpleParser {
	
	ArrayList <String> result = new ArrayList <String> ();

	public static void main (String [] args) throws IOException{
		
		/* regular expression */
		
		Pattern p = Pattern.compile("<{0,}?\\S[^><]+>{0,}");
		
		String text = xmlToString();
		
		Matcher m = p.matcher(text);
		
		SimpleParser simple = new SimpleParser();
		
		simple.result = toParse(m);
		
		printParserXml(simple.result);
	
			
	}
	
	/* to convert XML content to one String exemplar */ 
	
	public static String xmlToString() throws IOException {
		ArrayList<String> arr = (ArrayList<String>) Files.readAllLines(new File("src/Order.xml").toPath(), Charset.forName("UTF-8"));
		String a = "";
		for (String part : arr) {
			a = a + part;
		}
		return a;
	}
	
	/* to add all matches to collection*/ 
	
	public static ArrayList<String> toParse (Matcher m) {
	
		ArrayList <String> list = new ArrayList <String>(); 
		
		while (m.find()) {
			list.add(m.group());
		}
		return list;
	}
	
	/* to display all content of match's collection*/ 
	
	public static void printParserXml (ArrayList <String> list) {
		for (String text : list){
			System.out.println(text);
		}
	}

	
	
}
