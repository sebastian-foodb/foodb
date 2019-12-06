//SQLite javascript database TEST
//github.com/kripken/sql.js

var pythonResponse = '_NotSet_';

var URL;
var dbLoc = "Npgreader2.pythonanywhere.com"//'C:/Users/Nathan/Desktop/#ERAU/Sync/#ERAU/FA 2019/SE300/foodb/JAVA_SQL/pythontest.py';

URL = dbLoc + '?myData=' + encodeURIComponent('text'); // URI - uniform resource identifier







function callBackFunction(dbResponse){
    console.log(dbResponse);
}


function pingDataBase(DBurl, callBackFunction){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if(xhttp.readyState == 4 && xhttp.status == 200){
            callBackFunction(xhttp.responseText);
        }
    }
    xhttp.open('GET',DBurl, true);
    xhttp.send();
}
