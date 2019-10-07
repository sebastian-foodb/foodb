import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/* Test code for parsing the food.csv file */

 /* HOW TO USE: for now change the pathname string to whatever file
 * path leads to the food.csv. This may be useful to update to work
 * without the need for modification in the future.*/

public class Parser {
	
	private File bigFile;
	private String filepath = "Users/f16cd/eclipse-workspace/FoodbParser/src/food.csv";
	
	
	public static void main(String[] args) {
		
		Parser parser = new Parser();
		
	}
	
	public Parser() {
		System.out.println(new File(".").getAbsolutePath());
		//create();
		//parse();
	}

	private void create() {
		 
		bigFile = new File(filepath);
	}
	private void parse() {
		try {
			FileReader fileReader = new FileReader(bigFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			FileWriter fileWriter = new FileWriter("parsedfood.csv");
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			line = bufferedReader.readLine();
			bufferedWriter.write(line);
			
			String previous = "";
			String[] prevsplit = {""};
			String[] spltline = {""};
			String[] namesplit = {""};
			String[] prevnamesplit = {""};
			
			while((line = bufferedReader.readLine()) != null) {
				int same = 0;
				spltline = line.split(",");
				prevsplit = previous.split(",");
				namesplit = spltline[2].split(",");
				prevnamesplit = prevsplit[2].split(",");
				
				for(int i = 0; i < namesplit.length; i++) {
					if(namesplit[i].compareTo(prevnamesplit[i]) == 0) {
						same++;
					}
				}
				
				if(same < 3) {
					bufferedWriter.write(line);
				}
				
				previous = line;
				
			}
			
			bufferedReader.close();
			bufferedWriter.close();
			

			
		}catch(Exception e) {
			System.out.println("Exception");
			e.printStackTrace();
		}
		
	}
	
	
	
}