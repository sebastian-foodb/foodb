#!/Library/Frameworks/Python.framework/Versions/3.8/bin/python3

import cgi
import cgitb

cgitb.enable()

thestuff = cgi.FieldStorage()

print("Content-type: text/html")
print("")
# # print("""
# #     <html>
# #         <head><title>We good?</title></head>
# #         <body>
# #             <h6>this ought to be the only thing on the page</h6>
# #             <p><b>THIS IS ALSO HERE!</b></p>
# #             <p><u>THIS TOO!</u></p>
# #         </body>
# #     </html>
# # """)
# # print("amending through cgi is pretty convenient :-)")
# # print("<h1>it's not a total disaster after all</h1>")
# # print(theform["thesearch"].value)
#print("<h4><u><i>"+thestuff["keyname"].value+"</i></u></h4>")
print("<h4><u><i>"+thestuff["keyname"].value+"</i></u></h4>")
#"keyname" is the serialized key name of the data sent here in help.html
