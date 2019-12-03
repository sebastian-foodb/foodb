#!C:\Users\Nathan\AppData\Local\Programs\Python\Python38-32\python.exe
print("Content-Type: application/json\n")    
print()                             
 
import cgi,cgitb
import os
import FooDB as DB
import json

#keys = ['fdcID','calories','fat','cholesterol','sodium','carb','fiber','sugar','protein','potassium','iron','calcium','VitA','VitB6','VitB12','VitC','VitD','VitE'];

cgitb.enable() #for debugging
form = cgi.FieldStorage();
ID = form.getfirst('ID'); #get value
ID = int(ID);

dbRet = DB.fdcIDnutritionSearch(ID); #returns tuple of tuples 
vals = dbRet[0];
units = dbRet[1];

#valDict =  {keys[i]: vals[i] for i in range(0, len(vals))}
#unitDict = {keys[i]: units[i] for i in range(0, len(units))}

dict = {'values': vals[2:len(vals)],'units': units[2:len(units)]};

ret = json.dumps(dict);

print(ret);
