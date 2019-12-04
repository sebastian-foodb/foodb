#!/Library/Frameworks/Python.framework/Versions/3.8/bin/python3

#Created by Sebastian for FooDB
#created 11/11/2019
#updated 01/12/2019

import cgi
import cgitb
import sqlite3
import FooDB as DB

cgitb.enable()

foodCode = cgi.FieldStorage()
foodID = int(foodcode["foodid"].value)

#get the food entry with the matching nutrition data
entryData = DB.fdcIDbasicSearch(foodID)
