#gotta ensure that python can get data in a useful way

'''
    NOTE
    This cannot be run in Atom with the usual script package.
    Instead, open your terminal, navigate to this folder, then type in
        python3 testconnect.py
    (but you probably knew how to do that).
'''

#!/usr/bin/env python3.8

#import json
'''
    json->.loads(var)->python
    OR
    python->.dumps(var)->json
'''
import cgi#needed to process data from a web page
import cgitb
cgitb.enable()#cgi exception handling
import os
import sqlite3
from sqlite3 import Error
import sys

# def tupleToString(tuple):
#     return "".join(tuple)

#def main():
print("what're my responses?\n")

#initialize
dbConnect = None

#connect to database
dbConnect = sqlite3.connect("testdb.db")#in the same directory as this script

#give connection a cursor to read and write with
dbCursor = dbConnect.cursor()

#run sql code
#dbCursor.execute("INSERT INTO tableOfResponses(neutral) VALUES ('maybe so')")
dbCursor.execute("SELECT neutral FROM tableOfResponses")
responses = dbCursor.fetchall()

#save changes
#dbConnect.commit()

#close the connection
dbConnect.close()

#fetched selection is a tuple, which is read-only
#print(responses[0],responses[1],sep=" ")

#return values
#return responses[0]
print("Content-Type: text/html\n\n")
print(responses[0])

#for python scripts with multiple functions, force main to run
#if __name__=="__main__":
#    main()
