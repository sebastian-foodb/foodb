//Created by Sebastian for FooDB

//created 19/10/19
//updated 02/11/19

function addSearchTerms()
{
  //OR .replace("?q=","") OR .slice(3)
  var urlSearch = decodeURI(location.search.split("?q=").pop());
  document.title = "FooDB | "+urlSearch+" search results";
  document.getElementById("foodsearch").value = urlSearch;
  formatSearchAndAccessDatabase();
}

function formatSearchAndAccessDatabase()
{
  //reformat the submitted search term
  var searchTermFormatted = document.getElementById("foodsearch").value
  .toLowerCase()
  .replace(/\s/g,"")
  .replace(/[^\w]/g,"")
  .replace(/[_]/g,"");

  //connect to the database through jquery with ajax
  $.get
  (                                //shorthand for a get request
    "../sqlite/pytest/testconnect.py",  //url of script
    searchTermFormatted,                //data to send with the request
    function(requestData,requestStatus) //what to do on a successful connection
    {
      //
    }
  );
}
