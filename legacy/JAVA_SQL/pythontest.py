#!/usr/bin/env python3

# Testing for python database server
#
#
#

import sqlite3 as sql
import cgi
import sys
import json

def JS_Intake():
    fs = cgi.FieldStorage();

    sys.stdout.write("Content-Type: application/json");

    sys.stdout.write("\n");
    sys.stdout.write("\n");

    result = {};
    result['success'] = True;
    result['message'] = "The command Completed Successfully";
    result['keys'] = ",".join(fs.keys());

    d = {};
    for k in fs.keys():
        d[k] = fs.getvalue(k);

    result['data'] = d;

    sys.stdout.write(json.dumps(result,indent=1));
    sys.stdout.write("\n");

    sys.stdout.close();
    
    return result
    ##JS_data = str(form['myData'].value);
    ##sys.stdout.write(JS_data);
#end JS_Intake


#JS_Intake();

#raise SystemExit
