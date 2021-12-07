

		import java.io.FileWriter;
		import java.io.IOException;

		public class parser {
		public void  parser(String API_response) throws IOException, InterruptedException {
			/*
			 * below is the location of folder where our file is stored for offline use
			 * in text file format
			 */
			FileWriter txt_Writer = new FileWriter("C:\\My jokes\\" + "joke.txt");
			//below folder will be used to arrange data in appropiate manner for reading and for file_reader
			//file for getting important data from file 
			for(int i = 0;i<API_response.length();i++) {
				/*
				 * if a line contain any colon,opening or a closing bracket then it will jump on next start from 
				 * there if does not then it will contiunue on that line only. 
				 */
				
				//NOTE : THIS METHOD WILL BE CALLED FROM WIKIPEDIA_API  CLASS FILE
				
				if(API_response.charAt(i) == ',' | API_response.charAt(i) == '{' | API_response.charAt(i) == '}' | API_response.charAt(i) == '[' | API_response.charAt(i) == ']') {
					if(API_response.charAt(i) == ',') {
				txt_Writer.write(API_response.charAt(i));
				txt_Writer.write("\n");
				}else {
					txt_Writer.write("\n");
					txt_Writer.write(API_response.charAt(i));
					txt_Writer.write("\n");
				}
				}else {
					
					txt_Writer.write(API_response.charAt(i));
				}
			}
			/*
			 * this wil further continue to file_reader file for reading and getting a important data
			 * from file
			 */
			txt_Writer.close();
			File_reader fr = new File_reader();
			fr.file_reader();//this will take String as a parameter for calling important method from File_Reader class file
		}
		}
	
