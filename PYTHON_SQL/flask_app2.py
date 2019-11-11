# Flask portion of SQL server for FooDB Hosted on pythonanywhere.com
#
#   Currently hosted at http://Npgreader2.pythonanywhere.com
#
#   Debugging statements can be printed to the server error log in the following
#   format: print("Debug message here", file=sys.stderr)
#
#   If anything goes wrong please contact Nathan to review the server error log
#
#
# Version 1.1 by Nathan Graves

import os
import sys
import json

from urllib.parse import urlencode
from urllib.request import Request, urlopen
from flask import Flask, escape, request, jsonify
import FooDB

app = Flask(__name__)

@app.route('/', methods=['POST']) #may or may not want to add GET, OPTIONS, etc. requests here, they could be used for different functionality
def webhook():
    #extract JSON
    reqJSON = request.get_json(force = True)  ## FAILING 'ERE

    #analyze JSON
    result = processRequest(reqJSON);

    # Acutally submit response
    resp = jsonify(sanity = "check", dbReturn = result);
    resp.headers['Access-Control-Allow-Origin'] = '*'; #Cannot access from browser without
    print(resp, file=sys.stderr)

    return resp
#end webhook

def processRequest(reqJSON):
    """ Function analyzes the input JSON and makes the appropriate call to pythontest.py"""
    switcherDict = {"Exact":FooDB.exactMatch,
                    "FDC":FooDB.fdcIDbasicSearch,
                    "Close":FooDB.closeMatch,
                    "Custom":FooDB.customQuery,
                    "Nutrition":FooDB.fdcIDnutritionSearch
                    };

    #lookup function name
    func = switcherDict.get(reqJSON['queryType'], lambda:"Invalid Query Type");
    #execute function
    result = func(reqJSON['parameters']);

    return result
#end processRequest



#if __name__ == '__main__':
#    app.debug = True;
#    app.run(host = '0.0.0.0', port = 5000);

#end flask_app2.py
