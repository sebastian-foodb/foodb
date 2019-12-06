//Created by Sebastian for FooDB

//created 28/10/19
//updated 03/12/19

function randomThreePages()
{
  $.ajax(
    {
      type: "GET",
      dataType: "json",
      url: "cgi-bin/ex.py"
    })
    .done(function(randomPages)
    {
      for(var i = 0; i < randomPages.foodname.length; i++)
      {
        $("#title"+(i+1).toString())
        .html(randomPages.foodname[i])
        .attr("href","foodpage.html?id="+randomPages.foodid[i]);
      }
    })
    .fail(function(x,s,e)
    {
      alert(JSON.stringify(x));
      $(".explorebox").html("Random pages could not be diplayed.<br><br>"+x);
    });
}
