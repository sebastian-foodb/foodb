//Created by Sebastian for FooDB

//created 02/10/19
//updated 10/10/19

//test function
function testSubmission()
{
  var x = document.getElementById("foodsearch").value;
  x = x.toLowerCase().replace(/[^\w\s]/gi,"").replace(/[_]/gi,"");
  alert("You entered \""+x+"\" into the search bar.\nProud of yourself, big man?");
}

//attributes
var searchTerm, formattedSearchTerm, foodQuery;

//find database results for the user's query
function formatFoodSearch()
{
  //get the search term then duplicate it
  searchTerm = document.getElementById("foodsearch").value;
  formattedSearchTerm = searchTerm;

  //reformat the query for the database
  formattedSearchTerm = formattedSearchTerm.toLowerCase();
  formattedSearchTerm = formattedSearchTerm.replace(/\s/g,"");
  formattedSearchTerm = formattedSearchTerm.replace(/[^\w]/g,"");
  formattedSearchTerm = formattedSearchTerm.replace(/[_]/g,"");

  //use the reformatted query to search the database
  foodQuery = new XMLHttpRequest();
  fooQuery.onreadystatechange = submitSearchToDatabase();
}

//ensure that the query can actually be sent
function submitSearchToDatabase()
{
  if(foodQuery.readyState == 4 && foodQuery.status == 200)
  {
    foodQuery.open("GET","JAVA_SQL/Manager.java",true);
    foodQuery.send();
  }
}
