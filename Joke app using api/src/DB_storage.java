import java.sql.*;
import java.util.*;
public class DB_storage {

	public   void intoDB(String response) throws SQLException  {
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
		
		
		PreparedStatement intoDB = connect.prepareStatement("INSERT INTO Jokes(UID,Joke) VALUES(?,?)");
		intoDB.setInt(1, UID.size()+1);
		intoDB.setString(2, response);
		intoDB.execute();
		}catch(SQLException e) {
			String exception = e.toString();
			e.printStackTrace();
			if(exception.equals("\r\n"
					+ "org.sqlite.SQLiteException: [SQLITE_ERROR] SQL error or missing database (no such table: Jokes)")) {
				System.out.println("DataBase Missing!!!\ntry again");
				PreparedStatement stmt = connect.prepareStatement("CREATE TABLE \"Jokes\" (\r\n"
						+ "	\"UID\"	INTEGER NOT NULL,\r\n"
						+ "	\"Joke\"	TEXT NOT NULL\r\n"
						+ ");");
				stmt.execute();
				PreparedStatement intoDB = connect.prepareStatement("INSERT INTO Jokes(UID,Joke) VALUES(?,?)");
				intoDB.setInt(1, 1);
				intoDB.setString(2, "test");
				intoDB.execute();
			}else {
				PreparedStatement stmt = connect.prepareStatement("CREATE TABLE \"Jokes\" (\r\n"
						+ "	\"UID\"	INTEGER NOT NULL,\r\n"
						+ "	\"Joke\"	TEXT NOT NULL\r\n"
						+ ");");
				stmt.execute();
				String query = "INSERT INTO Jokes(UID,Joke) VALUES(?,?)";
				PreparedStatement intoDB = connect.prepareStatement(query);
				intoDB.setInt(1, 2);
				intoDB.setString(2, "test");
				intoDB.executeQuery();
				e.printStackTrace();
			}
		}
	}
}
