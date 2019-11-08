#!/usr/bin/python

import cgi
import cgitb

cgitb.enable()

print("Content-Type: text/html")
print()

print('<!DOCTYPE html>')

print('<html>')

print('<head>')
print('<title>We good?</title>')
print('</head>')

print('<body>')

print('<h1>this ought to be the only thing on the page</h1>')
print('<p>THIS IS ALSO HERE!</p>')
print('<p>THIS TOO!</p>')

print('</body>')

print('</html>')
