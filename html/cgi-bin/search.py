#!/Library/Frameworks/Python.framework/Versions/3.8/bin/python3

import cgi
import cgitb
import os
import FooDB as DB

cgitb.enable() #for debugging
form = cgi.FieldStorage()
# query = form.getfirst('query') #get value
# query = str(query)

dbRet = DB.closeMatch(form["query"].value) #returns tuple of tuples
topResultID = dbRet[0][1]; #first index food#, second selects the FDC_ID instead of the name
nutritionInfo = DB.fdcIDnutritionSearch(topResultID) #returns tuples with 2 tuples, first the values, then the units

# def divHead(name):
# 	return "<div class=""foodEntry"" id=" + str(name) + ">"

# def divFoot():
# 	return "</div>"

print("Content-type: text/html")
print("")
print(form["query"].value)
for ind in range(0,2):
	atag = "<a target=\"_self\" href=\"foodpage.html?id=\""
		+str(dbRet[ind][1])
		+"\">"
		+str(dbRet[ind][0])
		+"</a>"
	print(atag)
	#print("<a target=""_self"" href=""foodpage.html?id="""+ str(dbRet[ind][1]) +">" + str(dbRet[ind][0]) + "</a>");

	#if(ind == 50):
#		exit
	# print("<hr>")
	# print("</div>")


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
