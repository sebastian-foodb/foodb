//Created by Sebastian for FooDB

//created 25/10/19
//updated 25/10/19

function getNutritionFromDatabase()
{
  //get food name from the page's url
  var urlProperName = decodeURI(location.search.split("?food=").pop());
  document.title = "FooDB | "+urlProperName;
  document.getElementsByTag("h1") = urlProperName;

  //get nutrition from database
  var nutritionString;
  var getSQL = new XMLHTTPRequest();
  getSQL.onreadystatechange = function()
  {
    if(this.readyState == 4 && this.status == 200)
    {
      var stringsMatch = new Boolean(false);
      while(!stringsMatch)
      {
        //line has matching information
        if(/**/)
        {
          nutritionString = this.responseText;
          stringsMatch = !stringsMatch;
        }
        //go to next line
        else
        {
          //stop reading the database unless there are no entries left
          //
          stringsMatch = (/*no more entries to read*/) ? true : false;
        }
      }
    }
  };
  getSQL.open("GET",/*DATABASE+string*/,true).send();

  //parse the line for nutrition information
  var nutritionArray = nutritionString.split(",");

  //fill the td tags with the nutrition info from the database
  document.getElementById("Fat").innerHTML = /**/;
  document.getElementById("Cholesterol").innerHTML = /**/;
  document.getElementById("Sodium").innerHTML = /**/;
  document.getElementById("Carbohydrates").innerHTML = /**/;
  document.getElementById("Fiber").innerHTML = /**/;
  document.getElementById("Sugar").innerHTML = /**/;
  document.getElementById("Protein").innerHTML = /**/;
  document.getElementById("Potassium").innerHTML = /**/;
  document.getElementById("Iron").innerHTML = /**/;
  document.getElementById("Calcium").innerHTML = /**/;
  document.getElementById("VitaminA").innerHTML = /**/;
  document.getElementById("VitaminB6").innerHTML = /**/;
  document.getElementById("VitaminB12").innerHTML = /**/;
  document.getElementById("VitaminC").innerHTML = /**/;
  document.getElementById("VitaminD").innerHTML = /**/;
  document.getElementById("VitaminE").innerHTML = /**/;
}
