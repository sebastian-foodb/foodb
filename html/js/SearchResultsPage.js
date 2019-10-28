//Created by Sebastian for FooDB

//created 19/10/19
//updated 25/10/19

function addSearchTerms()
{
  //OR .replace("?q=","") OR .slice(3)
  var urlSearch = decodeURI(location.search.split("?q=").pop());
  document.title = "FooDB | "+urlSearch+" search results";
  document.getElementById("foodsearch").value = urlSearch;
}

function openSearchResult()
{
  window.open("foodpage.html?food="+document.getElementById(/**/).value);
}
