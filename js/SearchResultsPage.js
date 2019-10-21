//Created by Sebastian for FooDB

//created 19/10/19
//updated 20/10/19

//this js might be unnecessary

window.onscroll = keepSearchBarAtTop();

function keepSearchBarAtTop()
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
