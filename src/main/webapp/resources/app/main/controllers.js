'use strict';

/* Controllers */

(function () {

    var lifeplan = angular.module('lifeplan');
    lifeplan.controller('MainCntl', function ($http, $scope, $rootScope, $route, $routeParams, $location, $log) {
        $rootScope.model = null;
        $rootScope.hasValidationMessages = false;

        $rootScope.showValidationMessages = function (form) {
            return $rootScope.hasValidationMessages && form.$invalid;
        };

        $rootScope.saveAndContinue = function (myform, postUrl, payload, callback) {
            //alert($("#myform")[0].checkValidity());
            console.log(payload);
            if (myform.$valid) {
                $log.debug('Posting data to service :' + postUrl);
                $log.debug('Post Payload: ' + JSON.stringify(payload));
                /*try {
                 $scope.model.dirty = myform.$dirty;
                 } catch (e) {
                 $log.debug('unable to set dirty form in model');
                 }*/
                $http({
                    url: postUrl,
                    method: 'POST',
                    data: payload,
                    headers: {'Content-Type': 'application/json'}
                }).success(
                    function (data, status, headers, config) {
                        $log.debug("Http Response code: " + status);
                        if (status <= 300) {
                            $log.debug('Response: ' + JSON.stringify(data));
                        } else {
                            $log.error('Error response:' + JSON.stringify(data));
                        }
                        $rootScope.hasValidationMessages = false;
                    }).error(function (data, status, headers, config) {
                        $log.error('Error response:' + JSON.stringify(data));
                        $rootScope.hasValidationMessages = true;
                    });
            } else {
                console.log(myform);
                $rootScope.hasValidationMessages = true;
                $log.error('Form Validation Failed');
            }
        };
    });

}());