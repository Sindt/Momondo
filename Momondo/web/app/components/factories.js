'use strict';
/* Place your global Factory-service in this file */

angular.module('myApp.factories', [])
        .factory('dataFactory', ['$http', '$window', function ($http, $window) {

                var resUrl = 'http://angularairline-plaul.rhcloud.com/api/flightreservation';
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
                
                dataFactory.addReservation = function () {
                    return $http.post(urlBase,[]);
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
                dataFactory.createReservation = function (reservationRequest){
                    
                    var res = $http.post(urlBase, reservationRequest);
                    res.success(function (data, status, headers, config) {
                        var message = data;
                        alert("You have now purchased your ticket. Have a great trip.");
                    });
                    res.error(function (data, status, headers, config) {
                        alert("failure message: " + JSON.stringify({data: data}));
                    });
                };
                
                return dataFactory;
            }]);

        