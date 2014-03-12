'use strict';

/* Services */

(function () {
    var lpServices = angular.module('lifeplan');

    /*
     lpServices.factory('httpCallout', function ($http) {
     return {
     getHttpData:function (url) {
     return $http.get(url, { cache:true }).then(function (result) {
     return result.data;
     });
     }
     };
     });

     lpServices.factory('EnumerationService', function (httpCallout) {
     return {
     getEnumerationByType:function (enumType, queryString) {
     var url = 'enumeration/' + enumType;
     if (queryString) {
     url = url + '?' + queryString;
     }
     return httpCallout.getHttpData(url).then(function(result){
     return result.enumeration;
     });
     },
     getMilitaryServiceCategoryEnum:function () {
     return this.getEnumerationByType('MilitaryServiceCategory');
     }
     };
     });

     lpServices.factory('myApplyHttpInterceptor', function ($q, $window) {
     return function (promise) {
     return promise.then(function (response) {
     $('#loading').hide();
     return response;

     }, function (response) {
     $('#loading').hide();
     return $q.reject(response);
     });
     };
     });
     */

    lpServices.factory('StringUtil', function () {
        var trueValues = ['true', 'yes'];
        var falseValues = ['false', 'no'];
        return {
            isNotNullOrUndefined: function (field) {
                return !_.isUndefined(field) && !_.isNull(field);
            },
            isValidString: function (field) {
                return !_.isUndefined(field) && !_.isNull(field) && _.isString(field);
            },
            isTrueValue: function (field) {
                return this.isValidString(field) && _.contains(trueValues, field.toLowerCase());
            },
            isFalseValue: function (field) {
                return this.isValidString(field) && _.contains(falseValues, field.toLowerCase());
            },
            getTrueString: function () {
                return 'Yes';
            },
            getFalseString: function () {
                return 'No';
            },
            sanitizeForServiceInput: function (str) {
                return this.replaceWhiteSpacesWith(str, '+'); // replace spaces with + sign to include in service param
            },
            replaceWhiteSpacesWith: function (str, replacementStr) {
                return str.replace(/ /g, replacementStr);
            },
            equalsIgnoreCase: function (inputStr, targetStr) {
                var ret = this.isValidString(inputStr) && _.isEqual(inputStr.toLowerCase(), targetStr.toLowerCase());
                return ret;
            }
        };
    });


}());
