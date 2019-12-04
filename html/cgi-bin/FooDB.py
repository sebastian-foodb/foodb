# Testing for python database server
#
#   This file wil eventually contain all functions relating to accessing the DB
#   This makes it easier to test offline without working on the server at all times
#
#   Current Functions:
#
#   create_connection(db) - Creates connection to SQLlite3 database stored in the same folder
#
#   Version 1.1 by Nathan Graves

import sqlite3 as sql
import cgi
import sys
import json

#
# BASIC SETUP FUNCTIONS
#

def JS_Intake():


    return "result"
#end JS_Intake


def DB_NAME(): #Clean? no, but it works. Allows for easy modification of accessed DB
    return "FooDBv3.db3"
#end DB_NAME()

def create_connection(db):

    """Creates a connection to the specified database
        Returns conn, a connection object, or nothing if connection fails
    """

    try:
        conn = sql.connect(db)
        return conn
        print(sql.version)
    except Error as e:
        print(e)

    return
#end create_connection

#
# BASIC QUERYING FUNCTIONS
#

def exactMatch(item):
    """Function queries database for an exact match of the item and returns all data"""
    #create connection and cursor
    conn = create_connection(DB_NAME());
    cur = conn.cursor();

    #make statement string
    sqlStatement = "SELECT * FROM parsedFood WHERE searchString=?";

    #execute query
    cur.execute(sqlStatement, (item,));
    match = cur.fetchall()

    #close connection and return result
    conn.close();
    return match
#end exactMatch()

def customQuery(queryString):
    """ Function submits custom query to databse and returns whatever results from that"""
    #create connection and cursor
    conn = create_connection(DB_NAME());
    cur = conn.cursor();

    #execute query
    cur.execute(queryString);
    queryResult = cur.fetchall();

    #close connection and return result
    conn.close();
    return queryResult
#end customQuery

def fdcIDbasicSearch(id):
    """ Function submits a search to the database based on FDC_ID, an integer"""
    #create connection and cursor
    conn = create_connection(DB_NAME());
    cur = conn.cursor();

    #create SQL Statement
    sqlStatement = "SELECT * FROM parsedFood WHERE fdcID=?";

    #execute query
    cur.execute(sqlStatement,(id,));
    idSearchResult = cur.fetchall();

    #close connection and return result
    conn.close();
    return idSearchResult
#end fdcIDbasicSearch

def fdcIDnutritionSearch(id):
    """ Function submits a search to the database based on FDC_ID, an integer"""
    #create connection and cursor
    conn = create_connection(DB_NAME());
    cur = conn.cursor();

    #create SQL Statement
    sqlStatement = '''SELECT * FROM nutValues WHERE FDC_ID=? 
		    UNION
		    SELECT * FROM nutUnits WHERE FDC_ID=?''';

    #execute query
    cur.execute(sqlStatement,(id,id));
    idSearchResult = cur.fetchall();

    #close connection and return result
    conn.close();
    return idSearchResult
#end fdcIDnutritionSearch

#
# SPECIALIZED QUERYING FUNCTIONS
#

def closeMatch(searchString):
    """ Function submits a search to the database based on searchString"""
    #create connection and cursor
    conn = create_connection(DB_NAME());
    cur = conn.cursor();

    #create SQL Statement
    sqlStatement = """SELECT foodDescription,fdcID FROM parsedFood WHERE searchString LIKE ?
                    ORDER BY (CASE WHEN searchString = ? THEN 1 WHEN searchString LIKE ? THEN 2 ELSE 3 END)
                    """;

    #execute query
    cur.execute(sqlStatement,('%'+searchString+'%',searchString,searchString+'%'));
    table = cur.fetchmany(50);

    #close connection and return result
    conn.close();
    return table
#end closeMatch

def rand3():
    """ Selects Three Random Rows"""
    #create connection and cursor
    conn = create_connection(DB_NAME());
    cur = conn.cursor();

    #create SQL Statement
    sqlStatement = "SELECT foodDescription,fdcID FROM parsedFood ORDER BY random() LIMIT 3";

    #execute query
    cur.execute(sqlStatement);
    table = cur.fetchall();

    #close connection and return result
    conn.close();
    return table
#end rand3

#end PythonTest
