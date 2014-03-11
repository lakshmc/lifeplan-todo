'use strict';


// Declare app level module which depends on filters, and services
var app = angular.module('lifeplan', [
    'ngRoute',
        'lifeplan.filters',
    'lifeplan.services'
]);

app.config(function ($locationProvider, $routeProvider) {
    $routeProvider
        .when('/home', {
            templateUrl: 'resources/app/main/partials/home.html'
        })
        .when('/about', {
            templateUrl: 'resources/app/main/partials/about.html'
        })
        .when('/showactivities', {
            templateUrl: 'resources/app/activity/partials/activities-list.html'
        })
        .when('/createactivity', {
            templateUrl: 'resources/app/activity/partials/create-activity.html'
        })
        .when('/unknownpath', {
            templateUrl: 'resources/app/main/partials/error.html'
        })
        /*.when('/servicecatalog', {
         templateUrl: 'resources/appc/modules/admin/servicecatalog/partials/servicecatalog.html',
         controller: 'ServiceCatalogController'
         })*/;

    $routeProvider.otherwise({redirectTo: '/home'});
});