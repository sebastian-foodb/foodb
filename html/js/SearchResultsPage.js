//Created by Sebastian for FooDB

//created 19/10/19
//updated 23/10/19

function addSearchTerms()
{
  //OR .replace("?q=","") OR .slice(3)
  var urlSearch = decodeURI(location.search.split("?q=").pop());
  document.title = "FooDB | "+urlSearch+" search results";
  document.getElementById("foodsearch").value = urlSearch;
}

/*//might be unnecessary
function keepSearchBarAtTop()
{
  window.onscroll = function()
  {
    var banner = document.getElementById("banner");
    var stickybanner = banner.offsetTop;

    if (window.pageYOffset >= stickybanner)
    {
      banner.classList.add("stickybanner");
    }
    else
    {
      navbar.classList.remove("stickybanner");
    }
  }
}*/
