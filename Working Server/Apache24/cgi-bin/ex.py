#!C:\Users\Nathan\AppData\Local\Programs\Python\Python38-32\python.exe
print("Content-type: application/json")
print("")

import cgi
import cgitb
import json
import os
import FooDB as DB

cgitb.enable() #for debugging
form = cgi.FieldStorage()

dbRet = DB.rand3();										#returns tuple of tuples
topResultID = dbRet[0][1];								#first index food#, second selects the FDC_ID instead of the name
# nutritionInfo = DB.fdcIDnutritionSearch(topResultID);	#returns tuples with 2 tuples, first the values, then the units

foodNames = []
for i in range(0,3):
	foodNames.append(dbRet[i][0])

foodIDs = []
for i in range(0,3):
	foodIDs.append(dbRet[i][1])

randomPages = {"foodname":foodNames, "foodid":foodIDs}

print(json.dumps(randomPages))
