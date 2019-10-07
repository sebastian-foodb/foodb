import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class Parser {
	
	private static File bigFile = new File("food.csv"); 
	private static File parsedFile = new File("parsedfood.csv");
	
	
	
	
	public static void main(String[] args) {
		
		try {
			FileReader fileReader = new FileReader(bigFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			FileWriter fileWriter = new FileWriter(parsedFile);
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
			
		}
		System.out.println("yo");
		
		
		
	}
	
	
	
}