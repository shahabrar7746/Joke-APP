import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;

public class Main_body {

	public static void main(String[] args) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		String response = "";
		String url = "https://v2.jokeapi.dev/joke/Any?blacklistFlags=political,racist,sexist&type=singl";
		URL obj = new URL(url);
		try {
			HttpURLConnection hu = (HttpURLConnection) obj.openConnection();
			hu.setRequestMethod("GET");//This is an method that API will use.
			BufferedReader in = new BufferedReader(new InputStreamReader(hu.getInputStream()));
			String inputlines;
			StringBuffer sb = new StringBuffer();
			while((inputlines = in.readLine()) != null){
				sb.append(inputlines);
			}
	 response = sb.toString();//This variable will store API response in String format 
	 parser p = new parser();
		p.parser(response);
DB_storage DBS = new DB_storage();
DBS.intoDB(response);
	//This method will a function from parser class for 
			//approperiate arrangement of data that we got from API response
			//tosearch variable is to be used to make file with that name which will be used while offline search
		} catch (Exception e) {
			
		if(response.isEmpty()) {
			fromDB FDB = new fromDB();
			FDB.fromdb();
		//	System.out.println("No response from server\n try agin in some time");
		}else {
			
			System.out.println( response + "No Internet Available");
		}
			
		}
	}

}
