#!/Library/Frameworks/Python.framework/Versions/3.8/bin/python3

#Created by Sebastian for FooDB
#created 11/11/2019
#updated 20/11/2019

import cgi
import cgitb
import FooDB#nathan's search algorithm
import json
import sqlite3

cgitb.enable()

userSearch = cgi.FieldStorage()

#find entries that closely match the user search
resultList = FooDB.closeMatch(userSearch)

# #connect to the database
# try:
#     dbConn = sqlite3.connect("FooDBv3.db3")
# except:
#     print("Could not connect to the database.")
#
# dbCursor = dbConn.cursor()
#
# #search the database for relevant entries
# dbCursor.execute("SELECT * FROM parsedFood WHERE searchString=?",userSearch)
# dbResults = dbCursor.fetchall()
