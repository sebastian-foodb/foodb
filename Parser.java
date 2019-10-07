import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/* The purpose of this class is to parse the food.csv and get rid of any duplicates. */


public class Parser {

	private File bigFile;


	public static void main(String[] args) {

		Parser parser = new Parser();

	}

	public Parser() {
		create();
		parse();
	}

	private void create() {

		bigFile = new File("food.csv");
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

			
			// I changed the init of the previous to reflect the first line of food.csv
			// since the first line of content will never be a duplicate -A
			line = bufferedReader.readLine();
			String previous = line;
			String[] prevsplit = {""};
			String[] spltline = {""};
			String[] namesplit = {""};
			String[] prevnamesplit = {""};
			bufferedWriter.write(line);
			line = bufferedReader.readLine();

			while((line = bufferedReader.readLine()) != null) {
				int same = 0;
				if (previous != "") {
					spltline = line.split(",");
					prevsplit = previous.split(",");
					namesplit = spltline[2].split(",");
					prevnamesplit = prevsplit[2].split(",");
				}
				else {
					
				}

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