<?php
//Created by Sebastian for FooDB

//created 30/10/19
//updated 30/10/19

//MIGHT GET SCRAPPED FOR PYTHON SCRIPT

//get the search term from the url (after ?q=)
$userSearch = $_REQUEST["q"];

//connect to the database
$dbConnection = new sqlite3(/*TODO*/);

?>
