
import java.io.File;

import java.io.IOException;
import java.util.*;
public class File_reader {
public void file_reader() throws InterruptedException, IOException {
	File f_reader = new File("C:\\My jokes\\" + "joke.txt");
	String joke = "";
		String[] frameData	= new String[2];
	String ans = "";
	Scanner sc = new Scanner(f_reader);
	//NOTE : EXISTING FILE WILL ALREADY HAVE PARSED DATA 
	//This variable will store img address which will further use for img processing for img_viewer class file
	
	while(sc.hasNext()) {//this loop will read all the data from file to get important data like name,description and img address
		String temp = sc.nextLine();
	
		if(temp.contains("setup")) {
		for(int i = 0;i<temp.length();i++) {
			if(temp.charAt(i) == ':') {
				//System.out.println("Getting data from server......");
				//Thread.sleep(2000);
				
				joke = temp.substring(i+3, temp.length()-2);
				frameData[0] = joke;
				//System.out.println("JOKE: " + temp.substring(i+3, temp.length()-2)+".............");
				break;
			}
		}
		}if(temp.contains("delivery")) {
			for(int i = 0;i<temp.length();i++) {
				if(temp.charAt(i) == ':') {
					 
					
					ans = temp.substring(i+3, temp.length()-2);
					frameData[1] = ans;
					//System.out.println("      " + temp.substring(i+3, temp.length()-1));
					break;
				}
			}
	
		
		}
		
			
		}

//return frameData;
	Main_Frame mf = new Main_Frame();
	//mf.toshow(frameData);
mf.main(frameData);


		}

}
