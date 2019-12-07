# FooDB

# Basic Server Setup

To run the server in the most basic configuration there are three steps:

1. In WorkingServer/Apache24/conf/ file httpd.conf

On line 37 modify the SVROOT path from "c:/Apache24 to the path of the /Apache24/ directory on your system. 
It need not be in the c:/ directory.

2. In WorkingServer/Apache24/cgi-bin/ files ex.py, st.py, and fp.py

Change what comes after #! on the first line of each file to the path of your python.exe 
(it should be fairly similar to the one provided, aside from the /user/ folder name)

3. Open the command prompt and navigate to the WorkingServer/Apache24/bin folder

Type httpd.exe and hit ENTER, and the server will start. To stop the server, press ctrl-c. 
If any error messages appear, please contact a member of the team.

To view the webpages, open up your browser of choice and type in localhost:85.

Enjoy!

# Required Tech
Apache 2.4
  https://httpd.apache.org/download.cgi

  Configure local server on macOS
    https://www.dyclassroom.com/howto-mac/how-to-install-apache-mysql-php-on-macos-mojave-10-14

  Enable server to run Python scripts as CGI
    https://httpd.apache.org/docs/2.4/howto/cgi.html

jQuery
  https://jquery.com/download/

Python
  https://www.python.org/downloads/

SQLite
  https://www.sqlite.org/download.html

# Python Interpreter Paths
For the Python scripts, use the correct shebang line at the top of each script

  Windows 10
    #!C:\Users\Nathan\AppData\Local\Programs\Python\Python38-32\python.exe
      Modify \Nathan\ to your user name (and verify)

  macOS
    Open Terminal and type
      which python (if you want to use the built-in version)

      which python3 (if you want to use an installed Python 3.x version)

    On the first line of each Python script, type "#!" followed by the path with no space in between
