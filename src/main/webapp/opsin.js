 $(document).ready(function() {
	$("#chemicalNameForm").submit(function(e) {
    document.getElementById("results").style.display="";
    $("#cml").text("");
    $("#inchi").text("");
    $("#smiles").text("");
    $("#depiction").attr("src", "");
    var chemicalName = $("#chemicalName").val();
		$.ajax({
      beforeSend: function(req) {
        req.setRequestHeader("Accept", "chemical/x-no2d-cml");
      },
      dataType: "text",
      type: "GET",
      url: "/opsin/" +chemicalName,
      success: function(cml){
        $("#cml").text(cml);
      },
      error: function(XMLHttpRequest, textStatus, errorThrown){
        $("#cml").text(extractResponseText(XMLHttpRequest.responseText));
      }
		} );
		$.ajax({
      beforeSend: function(req) {
        req.setRequestHeader("Accept", "chemical/x-inchi");
      },
      dataType: "text",
      type: "GET",
      url: "/opsin/" +chemicalName,
      success: function(inchi){
        $("#inchi").text(inchi);
      },
      error: function(XMLHttpRequest, textStatus, errorThrown){
        $("#inchi").text(extractResponseText(XMLHttpRequest.responseText));
      }
		} );
		$.ajax({
      beforeSend: function(req) {
        req.setRequestHeader("Accept", "chemical/x-daylight-smiles");
      },
      dataType: "text",
      type: "GET",
      url: "/opsin/" +chemicalName,
      success: function(smiles){
        $("#smiles").text(smiles);
      },
      error: function(XMLHttpRequest, textStatus, errorThrown){
        $("#smiles").text(extractResponseText(XMLHttpRequest.responseText));
      }
		} );
    $("#depiction").attr("src", "/opsin/" +chemicalName +".png");
    return false;
	})
 });

	var re = new RegExp('<h3>(.*)</h3>');

	function extractResponseText(responseHTML) {
			var matcher = re.exec(responseHTML);
			if (matcher !=null){
					return matcher[1];
			}
			else{
					return "Problem retrieving server error message! Is this server running?";
			}
	}