#!C:\Users\Nathan\AppData\Local\Programs\Python\Python38-32\python.exe
print("Content-Type: text/html")    
print()                             
 
import cgi,cgitb
import os
import FooDB as DB

cgitb.enable() #for debugging
form = cgi.FieldStorage()
query = form.getvalue('query')
query = str(query);

dbRet = DB.closeMatch(query); #returns tuple of tuples 
topResultID = dbRet[0][1]; #first index food#, second selects the FDC_ID instead of the name
nutritionInfo = DB.fdcIDnutritionSearch(topResultID); #returns tuples with 2 tuples, first the values, then the units

print("Query Submitted:",query);
print("<br/>");
print("<br/>");
print("Database Returns:",dbRet);
print("<br/>");
print("<br/>");
print("TopResult Nutrition Values:",nutritionInfo[0]);
print("<br/>");
print("<br/>");
print("TopResult Nutrition Units:",nutritionInfo[1]);