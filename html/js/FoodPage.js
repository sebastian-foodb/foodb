//Created by Sebastian for FooDB

//created 25/10/19
//updated 03/12/19

function getNutritionFromDatabase()
{
  var urlID = decodeURI(location.search.split("?id=").pop());
  $.ajax(
    {
      type: "GET",
      data: {"ID": urlID},
      dataType: "json",
      url: "cgi-bin/fp.py"
    })
    .done(function(foodData)
    {
      $("title").html("FooDB | "+foodData.foodname);
      $("#propername").html(foodData.foodname);

      for(var i = 0; i < foodData.quantities.length; i++)
      {
        $("#nutrinfo"+String(i)).html(
          foodData.units[i] < 0 ? "N/A" : foodData.quantities[i]+" "+foodData.units[i]);
      }
    })
    .fail(function(x,s,e)
    {
      $("title").html("FooDB | Error loading food page");
      $("#propername").html("Could not load food name.");
      // $("#nutritiongrid").html("Nutrition values could not displayed.<br>"+e+".<br>"+JSON.stringify(x));
      $("#nutritiongrid")
      .html("Sorry, nutrition info could not be loaded.")
      .attr("style","color:#005500; padding-left: 1%; padding-right: 1%;");
    });
}
