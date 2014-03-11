'use strict';

/* Directives */


var app = angular.module('lifeplan');

app.directive('confirmOnExit', function () {
    return {
        link: function ($scope, elem, attrs, $rootScope) {
            var message = "You have unsaved changes on this page. Do you want to leave this page and discard your changes or stay on this page?";
            window.onbeforeunload = function () {
                if ($scope.myform.$dirty) {
                    return message;
                }
            };

            $scope.$on('$locationChangeStart', function (event, next, current) {
                var targ = getSourceTarget();
                if (targ != null
                    && targ.id != 'back'
                    && !(targ.status)
                    && $scope.myform.$dirty) {
                    if (!confirm(message)) {
                        event.preventDefault();
                    }
                }
            });
            var getSourceTarget = function () {
                var targ;
                if (!e) var e = window.event;
                if (e.target) targ = e.target;
                else if (e.srcElement) targ = e.srcElement;
                if (targ.nodeType == 3) // defeat Safari bug
                    targ = targ.parentNode;
                return targ;
            };
        }
    };
});
