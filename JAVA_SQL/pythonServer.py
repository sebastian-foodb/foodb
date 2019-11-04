# Flask portion of SQL server

from flask import Flask, escape, request
import pythontest

app = Flask(__name__)

@app.route('/', methods=['POST'])
def hello():

    req = pythontest.JS_Intake();

    return req

if __name__ == '__main__':
    app.debug = True;
    app.run(host = '0.0.0.0', port = 5000);
