//Created by Sebastian for FooDB

//created 02/10/19
//updated 25/10/19

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
}
