//Created by Sebastian for FooDB

//created 19/10/19
//updated 11/11/19

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

  //connect to the database through a jquery ajax call to python
  var entriesParsed;
  var entries=[];
  $.ajax(
    {
      type: "GET",
      data: searchTermFormatted,
      url: "cgi-bin/GetRelevantEntries.py"//cgi-bin --> Library/WebServer/CGI-Executables
    }).done(function(entriesJSON)
    {
      //reformat json results to an array
      entriesParsed = JSON.parse(entriesJSON);

      //fill the search page with relevant entries to search pages
      for(var i = 0; i < entriesParsed.length; i++)//might be entriesParsed.arrname.length
      {
        //make an html element that will link to
        entries[i] = document.createElement("div").setAttribute("id","searchresult"+i);
        $("searchresult"+i).html('<a href="foodpage.html?food='+entriesParsed[i]+'" target="_self">'+entriesParsed[i]+'</a>');

        //add a horizontal bar after every search result except the last one
        $("#searchresult"+i).append((i < entriesParsed.length-1) ? "<hr>" : "");
      }
    });
}
