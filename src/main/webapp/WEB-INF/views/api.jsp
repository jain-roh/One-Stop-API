<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SB Admin 2 - Add Api</title>

  <!-- Custom fonts for this template-->
  <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="resources/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">

    <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/controller">
        <div class="sidebar-brand-icon rotate-n-15">
          <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">One Stop API</sup></div>
      </a>

      <!-- Divider -->
      <hr class="sidebar-divider my-0">

      <!-- Nav Item - Dashboard -->
      <li class="nav-item active">
        <a class="nav-link" href="apilist.htm">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>API</span></a>
      </li>


      <!-- Heading -->
    
    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Topbar -->
        <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

          <!-- Sidebar Toggle (Topbar) -->
          <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
            <i class="fa fa-bars"></i>
          </button>

          <!-- Topbar Search -->
          <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search" method="get" action="search.htm">
            <div class="input-group">
              <input type="text" name="q" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
              <div class="input-group-append">
                <input class="btn btn-primary" type="submit" value="submit">
                
              </div>
            </div>
            </form>


        </nav>
    
          <!-- End of Topbar -->
 <div class="container">

        <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">${api.getApiName()}</h1>
<c:if test="${viewPurchase==true}">
 <input type="button"  onclick="myFunction(${api.getAPIId()})" id="purchase" class="btn btn-large btn-primary" data-toggle="confirmation" 
  value="Purchase"/>          
  </c:if>
  
  </div>
          
           
          <div  class="d-sm-flex align-items-left justify-content-between mb-4">
            <p class="p mb-0 text-gray-800">API Cost : ${api.getApiCost()}</p>
          </div>
           
           <div style="background-color: #e6e6ff;padding:12px;" class="d-sm-flex align-items-left justify-content-between mb-4">
            <p class="p mb-0 text-gray-800">${api.getApiDesc()}</p>
          </div>
                  
          <div style="background-color: #e6e6e6;padding:12px;" class="d-sm-flex align-items-left justify-content-between mb-4">
           <span  class="border-bottom">
           
            <p class="p mb-0 text-gray-800">${api.getApiCode()}</p>
            </span>
          </div>
          <input type="hidden" id="apiID" name="apiID" value="${api.getAPIId()}"/>
  </div>      <!-- End of Main Content -->

      <!-- Footer -->
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright &copy; Your Website 2019</span>
          </div>
        </div>
      </footer>
      <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="login.html">Logout</a>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="resources/vendor/jquery/jquery.min.js"></script>
  <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="resources/js/sb-admin-2.min.js"></script>

  <!-- Page level plugins -->
  <script src="resources/vendor/chart.js/Chart.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="resources/js/demo/chart-area-demo.js"></script>
  <script src="resources/js/demo/chart-pie-demo.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  
<script>
$(document).ready(function() {
	  $(document).on("click","#purchasea",function(){
		  var r = confirm("Are you sure to purchase?");
		  if (r == true) {
	    var apiID=$("#apiID").val();
	    alert(apiID);
	    if (apiID.trim()) {
	    // is empty or whitespace
	   var response="";
	   var qurl="http://localhost:8080/controller/addapitobill.do";
	   alert(qurl);

	   $.ajax({

	            type: "POST",
	            cache: false,
	            data:{'apiid':apiID},
	            url: qurl,
	            dataType: "json",
	            success: function(response) { 
	            alert(response);
	            	var res=response.Result;  
	            if (res=='1')
	            {
				alert("Added to Billing");
				
				}
	            else 
	            {
	            	alert("Error while adding");
	            }
	            },
	            error: function(jqXHR) {
	                alert("error: " + jqXHR.status);
	            }
	        })
	}
	else{
	alert("Song is empty")
	}
	}
	  }	  
	  );
	  
	  
	  });
function myFunction(apiid) {
  var txt;
  var r = confirm("Are you sure to purchase?");
  if (r == true) {
	  
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	     alert("Added To Bill");
	     document.getElementById("purchase").parentNode.removeChild(document.getElementById("purchase"));;
	    }
	  };
	  xhttp.open("POST", "http://localhost:8080/controller/addapitobill.do", true);
	  xhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');

	  xhttp.send("apiid="+apiid);
  } else {

  }
  document.getElementById("demo").innerHTML = txt;
}
</script>
</body>

</html>
