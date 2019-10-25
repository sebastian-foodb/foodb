//Created by Sebastian for FooDB

//created 02/10/19
//updated 23/10/19

function formatFoodSearch()
{
  //reformat the submitted search term
  var searchTermFormatted = document.getElementById("foodsearch").value
    .toLowerCase()
    .replace(/\s/g,"")
    .replace(/[^\w]/g,"")
    .replace(/[_]/g,"");

  //open the search results page
  window.open("search.html?q="+document.getElementById("foodsearch").value);

  //AJAX VALUE PASSING TO SQL
  //use the reformatted query to search the database
  /*var foodQuery = new XMLHttpRequest();
  foodQuery.open("GET","JAVA_SQL/Manager.java",true);

  //ensure that the query can actually be sent
  fooQuery.onreadystatechange = function()
  {
    if(foodQuery.readyState == 4 && foodQuery.status == 200)
    {
      window.open("search.html").document.title = foodQuery.responseText;
    }
  };

  foodQuery.send();*/
}
