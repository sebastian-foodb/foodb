#Created by Sebastian for FooDB

#created 30/10/19
#updated 30/10/19

#!/usr/bin/env python3

import json
import os
import sqlite3
from sqlite3 import Error
import sys

def searchDatabase():
    #connect to database
    try:
        dbConnection = sqlite3.connect("parsedFood.db3");
    except Error:
        print("Not happening!");

    #try-except is sensitive to white space
    #select relative database entries TODO use dbCursor.execute("SELECT")
    dbCursor = dbConnection.cursor();
    #dbCursor.execute();
searchDatabase()#end of function
