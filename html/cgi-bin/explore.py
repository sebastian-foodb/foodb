#!C:\Users\Nathan\AppData\Local\Programs\Python\Python38-32\python.exe
print("Content-type: text/html")    
print("")

import cgi,cgitb
import os
import FooDB as DB

cgitb.enable() #for debugging
form = cgi.FieldStorage()

dbRet = DB.rand3(); #returns tuple of tuples
topResultID = dbRet[0][1]; #first index food#, second selects the FDC_ID instead of the name
nutritionInfo = DB.fdcIDnutritionSearch(topResultID); #returns tuples with 2 tuples, first the values, then the units

def divHead(name):
	return "<div class=""foodEntry"" id=" + str(name) + ">"

def divFoot():
	return "</div>"

for ind in range(0,3):
	print(divHead(dbRet[ind][1]));
	print("<a target=""_self"" href=""foodpage.html?id="""+ str(dbRet[ind][1]) +">" + str(dbRet[ind][0]) + "</a>");
	print(divFoot());
	#if(ind == 50):
#		exit
	print("<hr>");


#print(form);
#print("<br/>");
#print("Query Submitted:",query);
#print("<br/>");
#print("<br/>");
#print("Database Returns:",dbRet);
#print("<br/>");
#print("<br/>");
#print("TopResult Nutrition Values:",nutritionInfo[0]);
#print("<br/>");
#print("<br/>");
#print("TopResult Nutrition Units:",nutritionInfo[1]);
