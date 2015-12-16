'use strict';
/* Place your global Factory-service in this file */

angular.module('myApp.factories', [])
        .factory('dataFactory', ['$http', '$window', function ($http, $window) {

                var urlBase = 'api/link';
                var dataFactory = {};
                var flightInfo = [];
                var ResObj = [];
                var basePrice = 0;

                dataFactory.addItem = function (item) {
                    basePrice = (item.totalPrice / item.numberOfSeats);
                    flightInfo.push(item);
                    $window.location.href = '#/view6';
                };

                dataFactory.getAllFlightinfo = function (info) {
                    return $http.get(urlBase + "/" + info);
                };

                dataFactory.addReservation = function (info) {
                    return $http.post(urlBase + "/" + info, []);
                };

                dataFactory.getFlight = function () {
                    return flightInfo;
                };

                dataFactory.getBasePrice = function () {
                    return basePrice;
                };

                dataFactory.createResObject = function (info) {
                    ResObj.push(info);
                };

                return dataFactory;
            }]);

        