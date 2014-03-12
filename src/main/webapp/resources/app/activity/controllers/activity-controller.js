'use strict';

/**
 * @constructor
 */
var ActivityController = function ($scope, $rootScope, $http) {

    var emptyActivity = {
        "name": null,
        "plannedActivity": 'true',
        "startTimestamp": null,
        "endTimestamp": null,
        "activityParticipants": {
            "participants": [
                {
                    "nickname": "marky"
                }
            ]
        },
        "activityFeeling": {
            "name": "positive"
        },
        "activityLocation": {
            "locationName": ""
        },
        "consuming": 'false',
        "notes": null
    };

    $scope.init = function () {
        $scope.params = {};
//        $scope.send();
    };

    $scope.initNewActivity = function () {
        $scope.model = emptyActivity;
        $scope.activityCompleted = 'false';
    };

    $scope.getActivities = function () {
        console.log('getting all activities..');
        $http({
            url: 'rest/activities',
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
    var postCallBack = function (success) {
        console.log('at callback');
        if (success) {
            console.log(success);
            $rootScope.setRoute('/showactivities');
        }
    };

    $scope.saveAndContinue = function (myform) {
        //console.log('saving activity...');
//        console.log($scope.model);
        $rootScope.saveAndContinue(myform, 'rest/activities', $scope.model, postCallBack);
    };
}
