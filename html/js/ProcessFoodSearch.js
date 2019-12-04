//Created by Sebastian for FooDB

//created 02/10/19
//updated 03/12/19

function addSearchToURL()
{
  //dont bother opening a search page for a blank query
  if(document.getElementById("foodsearch").value.replace(/\s/g,"") != "")
  {
    window.open("search.html?query="+encodeURI(document.getElementById("foodsearch").value));
  }
}
