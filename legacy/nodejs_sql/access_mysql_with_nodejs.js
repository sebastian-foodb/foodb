//Created by Sebastian for FooDB

//created 18/10/19
//updated 19/10/19

//REQUIRED INSTALLATIONS
//  MySQL Community Server (add commands to your $PATH)
//  Node.js

//include mysql to the script
var includesql = require("mysql");

//define connection to database
var connection = includesql.createConnection(
  {
    host: "localhost",
    user: "root",
    password: "yummy2015"//varies with your database
  });

  //verify connection
  connection.connect(function(err)
  {
    if (err)
    {
      return console.error("NOPE...\t"+err.message);
    }
    console.log("mysql up & running");
  });

  //type
  // node access_mysql_with_nodejs.js
  //into console if you can't run node.js in atom
