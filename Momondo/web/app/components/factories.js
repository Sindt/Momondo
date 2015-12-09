'use strict';
/* Place your global Factory-service in this file */

angular.module('myApp.factories', [])
        .factory('dataFactory', ['$http', '$window', function ($http, $window) {

                var urlBase = 'api/link';
                var dataFactory = {};
                var flightInfo = [];
                var basePrice = 0;

                dataFactory.addItem = function (item) {
                    basePrice = (item.totalPrice / item.numberOfSeats);
                    flightInfo.push(item);
                    $window.location.href = '#/view6';
                };

                dataFactory.getAllFlightinfo = function (info) {

                    return $http.get(urlBase + "/" + info);
                };

                dataFactory.getFlight = function () {
                    console.log(flightInfo);
                    return flightInfo;
                };

                dataFactory.getBasePrice = function () {
                    return basePrice;
                };
                return dataFactory;
            }]);

        