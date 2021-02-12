<!DOCTYPE html>
<%@page import="java.util.*" %>
<html lang="en">
  <%@page import="com.login.Dao.Dashboarddao"%>
  <head>
  <style>
* {
  box-sizing: border-box;
}

.row {
  display: flex;
}

.column {
  flex: 50%;
  padding: 10px;
  height: 300px; 
}

@media screen and (max-width: 600px) {
  .column {
    width: 100%;
  }
}

  #piechart{
  	position : auto;
  	left:auto;
  }
  
  #piechart1{
  	position : auto;
  	left:auto;
  }
  </style>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Primary Meta Tags -->
    <title>Outlay-Expenditure rises to income</title>
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1"
    />
    <meta name="title" content="Volt - Free Bootstrap 5 Dashboard" />
    <meta name="author" content="Themesberg" />
    <meta
      name="description"
      content="Volt is a free and open source Bootstrap 5 Admin Dashboard featuring 11 example pages, 100 components and 3 plugins with Vanilla JS."
    />
    <meta
      name="keywords"
      content="bootstrap 5, bootstrap, bootstrap 5 admin dashboard, free bootstrap 5 dashboard, bootstrap 5 dashboard, bootstrap 5 charts, bootstrap 5 calendar, bootstrap 5 datepicker, bootstrap 5 tables, bootstrap 5 datatable, vanilla js datatable, themesberg, themesberg dashboard, themesberg admin dashboard"
    />
    <link
      rel="canonical"
      href="https://themesberg.com/product/admin-dashboard/volt-bootstrap-5-dashboard"
    />

    <!-- Favicon -->
    <link
      rel="apple-touch-icon"
      sizes="120x120"
      href="assets/img/favicon/apple-touch-icon.png"
    />
    <link
      rel="icon"
      type="image/png"
      sizes="32x32"
      href="assets/img/favicon/favicon-32x32.png"
    />
    <link
      rel="icon"
      type="image/png"
      sizes="16x16"
      href="assets/img/favicon/favicon-16x16.png"
    />
    <link rel="manifest" href="assets/img/favicon/site.webmanifest" />
    <link
      rel="mask-icon"
      href="assets/img/favicon/safari-pinned-tab.svg"
      color="#ffffff"
    />
    <meta name="msapplication-TileColor" content="#ffffff" />
    <meta name="theme-color" content="#ffffff" />

    <!-- Fontawesome -->
    <link
      type="text/css"
      href="vendor/@fortawesome/fontawesome-free/css/all.min.css"
      rel="stylesheet"
    />

    <!-- Notyf -->
    <link type="text/css" href="vendor/notyf/notyf.min.css" rel="stylesheet" />

    <!-- Volt CSS -->
    <link type="text/css" href="css/volt.css" rel="stylesheet" />

    <!-- NOTICE: You can use the _analytics.html partial to include production code specific code & trackers -->
  </head>

  <body>
    <% response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
    String email=(String)session.getAttribute("email_id"); if(email==null) {
    response.sendRedirect("sign-in.jsp"); } %> <% Dashboarddao dao=new
    Dashboarddao(); String user_name=dao.username(email);
    session.setAttribute("username", user_name); %>
    <%
    	HashMap<String,Integer> map=dao.graph(email);
    	HashMap<String,Integer> map1=dao.graphincome(email);
    
    %>

    <nav class="navbar navbar-dark navbar-theme-primary px-4 col-12 d-md-none">
      <a class="navbar-brand mr-lg-5" href="index.html">
        <img
          class="navbar-brand-dark"
          src="assets/img/brand/light.svg"
          alt="Volt logo"
        />
        <img
          class="navbar-brand-light"
          src="assets/img/brand/dark.svg"
          alt="Volt logo"
        />
      </a>
      <div class="d-flex align-items-center">
        <button
          class="navbar-toggler d-md-none collapsed"
          type="button"
          data-toggle="collapse"
          data-target="#sidebarMenu"
          aria-controls="sidebarMenu"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
      </div>
    </nav>

    <div class="container-fluid bg-soft">
      <div class="row">
        <div class="col-12">
          <nav
            id="sidebarMenu"
            class="sidebar d-md-block bg-primary text-white collapse"
            data-simplebar
          >
            <div class="sidebar-inner px-4 pt-3">
              <div
                class="user-card d-flex d-md-none align-items-center justify-content-between justify-content-md-center pb-4"
              >
                <div class="d-flex align-items-center">
                  <div class="user-avatar lg-avatar mr-4">
                    <img
                      src="assets/img/team/profile-picture-3.jpg"
                      class="card-img-top rounded-circle border-white"
                      alt="Bonnie Green"
                    />
                  </div>
                  <div class="d-block">
                    <h2 class="h6">Hi, Jane</h2>
                    <a
                      href="pages/examples/sign-in.html"
                      class="btn btn-secondary text-dark btn-xs"
                      ><span class="mr-2"
                        ><span class="fas fa-sign-out-alt"></span></span
                      >Sign Out</a
                    >
                  </div>
                </div>
                <div class="collapse-close d-md-none">
                  <a
                    href="#sidebarMenu"
                    class="fas fa-times"
                    data-toggle="collapse"
                    data-target="#sidebarMenu"
                    aria-controls="sidebarMenu"
                    aria-expanded="true"
                    aria-label="Toggle navigation"
                  ></a>
                </div>
              </div>
              <ul class="nav flex-column">
                <li class="nav-item active">
                  <a href="dashboard.jsp" class="nav-link">
                    <span class="sidebar-icon"
                      ><span class="fas fa-chart-pie"></span
                    ></span>
                    <span>Records</span>
                  </a>
                </li>
                <li class="nav-item">
                  <a href="budget.jsp" class="nav-link">
                    <span class="sidebar-icon"
                      ><span class="fas fa-money-check-alt"></span
                    ></span>
                    <span>Budget</span>
                  </a>
                </li>
                <li class="nav-item">
                  <span
                    class="nav-link collapsed d-flex justify-content-between align-items-center"
                    data-toggle="collapse"
                    data-target="#submenu-app"
                  >
                    <span>
                      <span class="sidebar-icon"
                        ><span class="fas fa-receipt"></span
                      ></span>
                      Transactions
                    </span>
                    <span class="link-arrow"
                      ><span class="fas fa-chevron-right"></span
                    ></span>
                  </span>
                  <div
                    class="multi-level collapse"
                    role="list"
                    id="submenu-app"
                    aria-expanded="false"
                  >
                    <ul class="flex-column nav">
                      <li class="nav-item">
                        <a class="nav-link" href="Income.jsp"
                          ><span>Income</span></a
                        >
                      </li>
                    </ul>

                    <ul class="flex-column nav">
                      <li class="nav-item">
                        <a class="nav-link" href="Expenditure.jsp"
                          ><span>Expenditures</span></a
                        >
                      </li>
                    </ul>
                  </div>
                </li>

                <li class="nav-item">
                  <a href="wallet.jsp" class="nav-link">
                    <span class="sidebar-icon"
                      ><span class="fas fa-wallet"></span
                    ></span>
                    <span>Wallet</span>
                  </a>
                </li>
                <li class="nav-item">
                  <a href="loan.jsp" class="nav-link">
                    <span class="sidebar-icon"
                      ><span class="fas fa-coins"></span
                    ></span>
                    <span>Loan</span>
                  </a>
                </li>
                <li class="nav-item ">
                  <a href="credits.jsp" class="nav-link">
                    <span class="sidebar-icon"
                      ><span class="fas fa-gift"></span
                    ></span>
                    <span>Redeem Coupons</span>
                  </a>
                </li>
              </ul>
            </div>
          </nav>

          <main class="content">
            <nav
              class="navbar navbar-top navbar-expand navbar-dashboard navbar-dark pl-0 pr-2 pb-0"
            >
              <div class="container-fluid px-0">
                <div
                  class="d-flex justify-content-between w-100"
                  id="navbarSupportedContent"
                >
                  <div class="d-flex mt-4">
                    <h2>DASHBOARD</h2>
                  </div>
                  <!-- Navbar links -->
                  <ul class="navbar-nav align-items-center">
                    <li class="nav-item dropdown">
                      <a
                        class="nav-link pt-1 px-0"
                        href="#"
                        role="button"
                        data-toggle="dropdown"
                        aria-haspopup="true"
                        aria-expanded="false"
                      >
                        <div class="media d-flex align-items-center">
                
                          <div
                            class="media-body ml-2 text-dark align-items-center d-none d-lg-block"
                          >
                            <span class="mb-0 font-small font-weight-bold"
                              >${ username }</span
                            >
                          </div>
                        </div>
                      </a>
                      <div
                        class="dropdown-menu dashboard-dropdown dropdown-menu-right mt-2"
                      >
                        <a class="dropdown-item font-weight-bold" href="updateprofile.jsp"
                          ><span class="far fa-user-circle"></span>My Profile</a
                        >
                        <div role="separator" class="dropdown-divider"></div>
                        <a
                          class="dropdown-item font-weight-bold"
                          href="Logout.jsp"
                          ><span class="fas fa-sign-out-alt text-danger"></span
                          >Logout</a
                        >
                      </div>
                    </li>
                  </ul>
                </div>
              </div>
            </nav>

            <div
              class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center py-4"
            >
              <div class="btn-toolbar dropdown">
                
                
              </div>
              <div class="btn-group">
                <button type="button" class="btn btn-sm btn-outline-primary">
                  Share
                </button>
                <button type="button" class="btn btn-sm btn-outline-primary">
                  Export
                </button>
              </div>
            </div>
            
            
            <div class="container">
  <div class="row">
    <div class="col">
     <h2>Expenditure Chart</h2>
               <div id="piechart">
                 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

                 <script type="text/javascript">
// Load google charts
                 google.charts.load('current', {'packages':['corechart']});
                 google.charts.setOnLoadCallback(drawChart);

// Draw the chart and set the chart values
                 function drawChart() {
                    var data = google.visualization.arrayToDataTable([
                    ['Expenditure', 'Per Month'],
                    ['Electricity',<%=map.get("Electricity")%>],
                    ['Food', <%=map.get("Food")%>],
                    ['Medical', <%=map.get("Medical")%>],
                    ['Gas', <%=map.get("Gas")%>],
                    ['Grocery', <%=map.get("Grocery")%>],
                    ['Others',<%=map.get("Others")%>]
                ]);

  // Optional; add a title and set the width and height of the chart
                var options = { 'width':450, 'height':400};

  // Display the chart inside the <div> element with id="piechart"
                var chart = new google.visualization.PieChart(document.getElementById('piechart'));
                chart.draw(data, options);
              }
</script>
</div>
     
    </div>
    <div class="col">
      <h2>Income Chart</h2>
               <div id="piechart1">
                 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

                 <script type="text/javascript">
// Load google charts
                 google.charts.load('current', {'packages':['corechart']});
                 google.charts.setOnLoadCallback(drawChart);

// Draw the chart and set the chart values
                 function drawChart() {
                    var data = google.visualization.arrayToDataTable([
                    ['Income', 'Per Month'],
                    ['Salary',<%=map1.get("Salary")%>],
                    ['Business', <%=map1.get("Business")%>],
                    ['Award', <%=map1.get("Award")%>],
                    ['Gifts', <%=map1.get("Gifts")%>],
                    ['Selling', <%=map1.get("Selling")%>],
                    ['Others',<%=map1.get("Others")%>]
                ]);

  // Optional; add a title and set the width and height of the chart
                var options = { 'width':450, 'height':400};

  // Display the chart inside the <div> element with id="piechart"
                var chart = new google.visualization.PieChart(document.getElementById('piechart1'));
                chart.draw(data, options);
              }
</script>
</div>

    </div>
  </div>  
             
           </div>
              	<div id="chart_div" style="width: 1020px; height: 500px; margin-left:60px;margin-top:50px"></div>
           
         </div>
         
      </div>
    </div>

           
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawVisualization);

      function drawVisualization() {
        // Some raw data (not necessarily accurate)
        var data = google.visualization.arrayToDataTable([
          ['Days', 'Expenditure', 'Income'],
          ['08/02',  400,      1200,  ],
          ['09/02',  250,      50, ],
          ['10/02',  350,      300, ],
          ['11/02',  330,      10, ],
          ['12/02',  430,      400,  ]
        ]);

        var options = {
          title : 'Monthly details',
          vAxis: {title: 'Amount'},
          hAxis: {title: 'Days'},
          seriesType: 'bars',
          series: {5: {type: 'line'}}
        };

        var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>



	
    <!-- Core -->
    <script src="vendor/popper.js/dist/umd/popper.min.js"></script>
    <script src="vendor/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Vendor JS -->
    <script src="vendor/onscreen/dist/on-screen.umd.min.js"></script>

    <!-- Slider -->
    <script src="vendor/nouislider/distribute/nouislider.min.js"></script>

    <!-- Jarallax -->
    <script src="vendor/jarallax/dist/jarallax.min.js"></script>

    <!-- Smooth scroll -->
    <script src="vendor/smooth-scroll/dist/smooth-scroll.polyfills.min.js"></script>

    <!-- Count up -->
    <script src="vendor/countup.js/dist/countUp.umd.js"></script>

    <!-- Notyf -->
    <script src="vendor/notyf/notyf.min.js"></script>

    <!-- Charts -->
    <script src="vendor/chartist/dist/chartist.min.js"></script>
    <script src="vendor/chartist-plugin-tooltips/dist/chartist-plugin-tooltip.min.js"></script>

    <!-- Datepicker -->
    <script src="vendor/vanillajs-datepicker/dist/js/datepicker.min.js"></script>

    <!-- Simplebar -->
    <script src="vendor/simplebar/dist/simplebar.min.js"></script>

    <!-- Github buttons -->
    <script async defer src="https://buttons.github.io/buttons.js"></script>

    <!-- Volt JS -->
    <script src="assets/js/volt.js"></script>
  </body>
</html>
