'use strict';

/**
 * @constructor
 */
var ActivityController = function ($scope, $http) {

    $scope.init = function () {
        $scope.params = {};
//        $scope.send();
    };

    $scope.getActivities = function () {
        console.log('called..');
        $http({
            url: '/lifeplan/activities',
            method: "GET",
            data: $scope.params,
            headers: {'Content-Type': 'application/json'}
        }).success(function (data, status, headers, config) {
                $scope.activities = data;
                /*$scope.responseHeaders = data.headers;
                 $scope.generatedResponse = {};*/
            }).error(function (data, status, headers, config) {
                $scope.errorResponse = data;
            });

    };

}
