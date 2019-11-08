'''
    env FLASK_APP=script_file.py FLASK_ENV=development flask run
'''

from flask import Flask, escape, request

app = Flask(__name__)

@app.route("/")
def hello():
    return "hello world"
