import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/* The purpose of this class is to parse the food.csv and get rid of any duplicates. */


public class SimilarFoodParser {

	private File bigFile;
	private int index = 0;


	public static void main(String[] args) {

		SimilarFoodParser parser = new SimilarFoodParser();

	}

	public SimilarFoodParser() {
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
			String[] prevSplit = {""};
			String[] spltLine = {""};
			int endIndex = 0;
			int prevEndIndex = 0;
			int iMax;
			int same;
			bufferedWriter.write(line);
			line = bufferedReader.readLine();

			while((line = bufferedReader.readLine()) != null) {
				same = 0;
				if (previous != "") {
					spltLine = line.split(",");
					prevSplit = previous.split(",");
					endIndex = findEnd(spltLine);
					prevEndIndex = findEnd(prevSplit);
				}

				if (endIndex < prevEndIndex) {
					iMax = endIndex;
				}
				else {
					iMax = prevEndIndex;
				}

				for(int i = 2; i < iMax; i++) {
					if(spltLine[i].compareTo(prevSplit[i]) == 0) {
						same++;
					}
				}

				if(same < 2) {
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
					if(Character.isDigit(cmp.charAt(1)) || cmp.equals("")) {
						if(i < end) {
							end = i;
						}
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