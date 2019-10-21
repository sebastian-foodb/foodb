//Created by Sebastian for FooDB

//created 02/10/19
//updated 18/10/19

//attributes
var searchTerm, formattedSearchTerm, foodQuery;

//find database results for the user's query
function formatFoodSearch()
{
  //get the search term and store it locally
  searchTerm = document.getElementById("foodsearch").value;
  //localStorage.setItem("search",searchTerm);
  localStorage.searchterm = searchTerm;

  //duplicate search term before reformatting it
  formattedSearchTerm = searchTerm;

  //reformat the query for the database
  formattedSearchTerm = formattedSearchTerm.toLowerCase();
  formattedSearchTerm = formattedSearchTerm.replace(/\s/g,"");
  formattedSearchTerm = formattedSearchTerm.replace(/[^\w]/g,"");
  formattedSearchTerm = formattedSearchTerm.replace(/[_]/g,"");

  //AJAX VALUE PASSING TO SQL
  //use the reformatted query to search the database
  /*foodQuery = new XMLHttpRequest();
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

  //for future array use:
  //https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array

  //open the search results page (might remove values after html)
  window.open("search.html?search="+localStorage.searchterm);
}
