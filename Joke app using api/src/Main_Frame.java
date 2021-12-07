import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main_Frame {

	public static void main(String args[]) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		JFrame f=new JFrame("Joke");
//		File_reader fr = new File_reader();
//		fr.file_reader();
		
		
		 
	    JLabel l1,l2;  
	     l1 = new JLabel(args[0] + ".......");
	  f.add(l1);
	
	  l1.setBounds(50,50, 1000000,30);  
	    f.setSize(500,200);
	    
	    l2 = new JLabel(args[1]);
	    l2.setBounds(50,90, 1000000,30);
	    f.add(l2);
	    f.setLayout(null);  
	    f.setVisible(true); 
	}

}
