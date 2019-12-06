//Created by Sebastian for FooDB

//created 19/10/19
//updated 03/12/19

function formatSearchAndAccessDatabase()
{
  //alternative syntax: .replace("?q=","") OR .slice(3)
  var urlSearch = decodeURI(location.search.split("?query=").pop());
  // document.title = "FooDB | "+urlSearch+" search results";
  $("title").html("FooDB | "+urlSearch+" search results");
  document.getElementById("foodsearch").value = urlSearch;

  //reformat the submitted search term
  var searchTermFormatted = urlSearch
  .toLowerCase()
  .replace(/[0-9]/g,"")
  .replace(/\s/g,"")
  .replace(/[^\w]/g,"")
  .replace(/[_]/g,"");

  //connect to the database through a jquery ajax call to python
  $.ajax(
    {
      type: "GET",
      data: {"query": searchTermFormatted},
      url: "cgi-bin/st.py"
    })
    .done(function(resultElements)
    {
      $("#resultlist").html(resultElements);
      $("#background").height($("#resultlist").outerHeight(true));
    })
    .fail(function(x,s,e)
    {
      $("#resultlist").html("Sorry, something went wrong.<br>"+e+".");
    });
}
