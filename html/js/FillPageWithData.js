//Created by Sebastian for FooDB

//created 25/10/19
//updated 11/11/19

function getNutritionFromDatabase()
{
  //get food name from the page's url
  var urlProperName = decodeURI(location.search.split("?food=").pop());
  document.title = "FooDB | "+urlProperName;
  document.getElementsByTag("h1") = urlProperName;

  //get relevant nutrition data
  $.ajax(
    {
      type: "GET",
      data: urlProperName,
      url: "cgi-bin/GetFoodData.py"
    }).done(function(foodData)
    {
      //reformat json results to an array
      var nutrition = JSON.parse(foodData);

      //fill the td elements with their respective values
      for(var i = 0; i < foodData.length; i++)
      {
        $("#nutrinfo"+i).html(nutrition[i]);
      }
    });
}
