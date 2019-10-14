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
	private int index = 0;


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
			bufferedWriter.newLine();


			// I changed the init of the previous to reflect the first line of food.csv
			// since the first line of content will never be a duplicate -A
			line = bufferedReader.readLine();
			String previous = line;
			String[] prevsplit = {""};
			String[] spltline = {""};
			int endIndex = 0;
			int prevEndIndex = 0;
			int imax;
			bufferedWriter.write(line);
			line = bufferedReader.readLine();

			while((line = bufferedReader.readLine()) != null) {
				int same = 0;
				if (previous != "") {
					spltline = line.split(",");
					prevsplit = previous.split(",");
					endIndex = findEnd(spltline);
					prevEndIndex = findEnd(prevsplit);
				}

				if (endIndex < prevEndIndex) {
					imax = endIndex;
				}
				else {
					imax = prevEndIndex;
				}
				if(index == 106) {
					//System.out.println("100!");
				}

				for(int i = 2; i < imax; i++) {
					if(spltline[i].compareTo(prevsplit[i]) == 0) {
						same++;
					}
				}

				if(same < 3) {
					bufferedWriter.write(line);
					bufferedWriter.newLine();;
				}

				previous = line;
				index++;

			}

			bufferedReader.close();
			bufferedWriter.close();



		}catch(Exception e) {
			System.out.println(index);
			e.printStackTrace();
		}

	}

	private int findEnd(String[] line) {
		int end = 99;
		String cmp;
		for(int i = 2; i < line.length; i++) {
			cmp = line[i];
			try {
				if(cmp.charAt(0) == '\"') {
					if(Character.isDigit(cmp.charAt(1))) {
						if(i < end) {
							end = i;
						}
					}
					else if(cmp.equals("")) {
						if(i < end) end = i;
					}

				}
			}
			catch(Exception e) {
				end = i;
			}
		}
		return end;
	}



}