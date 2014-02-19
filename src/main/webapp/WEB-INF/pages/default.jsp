<!doctype html>
<html lang="en" ng-app="lifeplan">
<head>
    <meta charset="utf-8">
    <title>Lifeplan</title>
    <!-- Always force latest IE rendering engine (even in intranet) & Chrome Frame -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href="resources/common/css/bootstrap/bootswatch-cosmo/bootstrap.css" rel="stylesheet">
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
</head>
<body>
<div id="wrap">

    <!-- Fixed navbar -->
    <div ng-include src="'resources/app/main/layout/topnav.html'"></div>

    <!-- Begin page content -->
    <div class="container-fluid">
        <div class="row">
            <!--main content-->
            <div class="col-lg-9">
                <%--<section id="mainSection" style="margin-top:0">--%>
                <section id="mainSection">
                    <ng-view>Loading...</ng-view>
                </section>
            </div>

            <!--right nav-->
            <div class="col-lg-3">
                <div ng-include src="'resources/app/main/layout/leftnav.html'"></div>
            </div>
        </div>
    </div>

</div>
<div ng-include src="'resources/app/main/layout/footer.html'"></div>

<!-- In production use:
<script src="//ajax.googleapis.com/ajax/libs/angularjs/x.x.x/angular.min.js"></script>
-->
<!--<script src="resources/lib/jquery/1.10.2/jquery.js"></script>-->

<script src="resources/common/js/angular/angular.js"></script>
<script src="resources/common/js/angular/angular-route.js"></script>

<script src="resources/app/main/app.js"></script>
<script src="resources/app/main/services.js"></script>
<script src="resources/app/main/controllers.js"></script>
<script src="resources/app/main/filters.js"></script>
<script src="resources/app/main/directives.js"></script>

<script src="resources/app/activity/controllers/activity-controller.js"></script>

</body>
</html>
