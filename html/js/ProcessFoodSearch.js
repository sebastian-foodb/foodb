//Created by Sebastian for FooDB

//created 02/10/19
//updated 30/10/19

function addSearchToURL()
{
  //dont bother opening a search page for a blank query
  if(document.getElementById("foodsearch").value.replace(/\s/g,"") != "")
  {
    window.open("search.html?q="+document.getElementById("foodsearch").value);
  }
}
