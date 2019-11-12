//Created by Sebastian for FooDB

//created 28/10/19
//updated 11/11/19

function randomThreePages()
{
  $.ajax(
    {
      type: "GET",
      url: "cgi-bin/GetRandomFoodData.py"
    }).done(function(foodData)
    {
      //TODO
    });
}

//DEFUNCT (but might be good to hold on to)
//access the sql database with node.js
//var db = require("sqlite3");
