import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

public class fromDB {

	public void fromdb() throws SQLException, IOException, InterruptedException {
		Connection connect = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\admin\\Documents\\Joke_DB.db");
		try {
		if(connect.isClosed()) {
			//System.out.println("Not Connected");
		}else {
			//System.out.println("Connected!!");
		}
		ArrayList<Integer> UID = new ArrayList();
		Statement uidCall = connect.createStatement();
		ResultSet rs = uidCall.executeQuery("SELECT UID FROM Jokes");
		int UIDs = 0;
		while(rs.next()) {
			UIDs = rs.getInt("UID");
			UID.add(UIDs);
			
		}
		Random rd = new Random();
		String rUID = "";
		 rUID = rUID.valueOf(rd.nextInt(UID.size()));
		 Statement stmt = connect.createStatement();
		  rs = stmt.executeQuery("SELECT Joke FROM Jokes WHERE UID = " + rUID);
		  parser ps = new parser();
		ps.parser(rs.getString("Joke")); 
		}catch(SQLException e) {
			System.out.println(e);
		}
	}

}
