//Created by Sebastian for FooDB

//created 15/10/19
//updated 17/10/19

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class PageGenerator
{
	//CONSTANTS
	private final static int NUTRIENTS = 32;//TODO does not include spice, food group, etc.
	
	public static void main(String[] args)
	{	
		File database = new File("JAVA_SQL/database.db");//TODO sql file
		File foodEntryPage;
		Scanner sqlScan;
		PrintWriter htmlWrite;

		try
		{
			sqlScan = new Scanner(database);
			
			while(sqlScan.hasNextLine())
			{
				foodEntryPage = new File(database.getName()+".html");//TODO shortname out of sql
				htmlWrite = new PrintWriter(foodEntryPage);
				
				//opening tags
				htmlWrite.println("<!DOCTYPE html>\n\n<html lang=\"en\" dir=\"ltr\">");
				htmlWrite.println("<head>");
				htmlWrite.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
				htmlWrite.println("<title>FooDB | "+database.getName()+"</title>");//TODO title from sql
				htmlWrite.println("<link rel=\"stylesheet\" href=\"css/foodpage.css\"/>");
				htmlWrite.println("</head>\n");

				//open body
				htmlWrite.println("<body>");
				
				//open background and centerbox
				htmlWrite.println("<div class=\"background\">");
				htmlWrite.println("<div id=\"centerbox\">");
				
				//TODO getName header <h1></h1>
				htmlWrite.println("<h1>"+database.getName()+"</h1>");

				//write nutritiongrid div
				htmlWrite.println("<div id=\"nutritiongrid\">");
				
				//TODO recursive nutrient table creation
				for(int i = 0; i < NUTRIENTS; i++)
				{
					String[] dbInfo = (sqlScan.next()).split(",");
					htmlWrite.println("<table><tr><th>"
							+dbInfo[i]+"</th></tr><tr><td>"
							+dbInfo[i]+"</td></tr></table>");
					//
				}
				
				//close nutritiongrid, centergrid, and background
				htmlWrite.println("</div>\n</div>\n</div>");

				//close body and html tags
				htmlWrite.print("</body>\n</html>");
				htmlWrite.close();
			}
			
			sqlScan.close();
		}
		catch(Exception uhoh)
		{
			System.out.print("COULD NOT GENERATE WEB PAGE FOR WHATEVER REASON\n"
					+"ACTUALLY HERE'S THE REASON:\n");
			uhoh.printStackTrace();
		}
	}
}
