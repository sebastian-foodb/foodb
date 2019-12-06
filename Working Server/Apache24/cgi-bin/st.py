#!C:\Users\Nathan\AppData\Local\Programs\Python\Python38-32\python.exe

import cgi
import cgitb
import FooDB as DB

cgitb.enable()

theform = cgi.FieldStorage()

dbRet = DB.closeMatch(theform["query"].value)           #returns tuple of tuples
topResultID = dbRet[0][1];                              #[food][selects the FDC_ID instead of the name]
nutritionInfo = DB.fdcIDnutritionSearch(topResultID)    #returns tuples with 2 tuples, first the values, then the units

#content header
print("Content-type: text/html")
print("")

#contents
for ind in range(0,len(dbRet)):
   print('<br><a target="_self" href="foodpage.html?id='
   +str(dbRet[ind][1])
   +'">'
   +str(dbRet[ind][0])
   +" "
   +theform["query"].value
   +'</a>')
   if ind != len(dbRet)-1:
       print("<hr>")

#TEST CODE FROM DEBUGGING
# print('''
#     <br>
#     <u>so, what? youre telling me i can only have ONE print statement per for loop? but i can have more than</u>
# ''')
#
# if 9000>1:
#     for x in range(0,3):
#         print('<br><i>ONE</i>')
#         print('<br>BLUH')
#
#     print('<br>')
#
#     for y in range(0,3):
#         print('BLUH ')
#
# print("<br><u>statements in an <i>if</i> loop? or for loops nested in one for that matter???</u>")
