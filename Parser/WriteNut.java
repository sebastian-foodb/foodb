
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;

public class WriteNut {

	public static void main(String[] args) {

		ParseNut nut;

		File nutrients = new File("Nutrients.csv");
		File units = new File("Units.csv");
		String input = "parsedfood.csv";

		int testnum = 1500;
		String current;

		try {
			BufferedReader br = new BufferedReader(new FileReader(input));

			BufferedWriter writeNut = new BufferedWriter(new FileWriter(nutrients));
			BufferedWriter writeUnit = new BufferedWriter(new FileWriter(units));

			String head = "FDC_ID,Calories,Fat,Cholesterol,Sodium,Carb,Fiber,Sugar,Protein,Potassium,Iron,"
					+ "Calcium,Vitamin_A,Vitamin_B6,Vitamin_B12,Vitamin_C,Vitamin_D,Vitamin_E";
			writeNut.write(head);
			writeUnit.write(head);
			writeNut.newLine();
			writeUnit.newLine();

			int i = 0;
			br.readLine();
			while ((current = br.readLine()) != null ) {

				String[] line = current.split(",");
				if(Long.valueOf(line[0]) < 100000) {
					while (true) {
						System.out.println(line[0]);
					}
				}

				nut = new ParseNut(line[0]);
				System.out.println(line[0]);
				i++;

				String[][] parseNutOutput = nut.getNut();
				for(int j = 0; j < 18; j++) {

					writeNut.write(parseNutOutput[j][0]);
					writeUnit.write(parseNutOutput[j][1]);

					if(j != 17) {
						writeNut.write(",");
						writeUnit.write(",");
					}
				}
				writeNut.newLine();
				writeUnit.newLine();

				TimeUnit.SECONDS.sleep(1);

			}
			writeNut.close();
			writeUnit.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
