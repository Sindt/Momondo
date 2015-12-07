'use strict';
angular.module('myApp')
        .factory('dataFactory', ['$http', '$window', function ($http, $window) {

                var urlBase = 'api/link';
                var factory = {};
                var flightInfo = [];

                factory.addItem = function (item) {
                    flightInfo.push(item);
                    $window.location.href = '#/view6';
                };

                factory.getAllFlightinfo = function (info) {
                    return $http.get(urlBase + "/" + info);
                };

                factory.getFlight = function () {
                    console.log(flightInfo);
                    return flightInfo;
                };

                return factory;
            }]);