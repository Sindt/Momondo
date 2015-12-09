'use strict';
angular.module('myApp.view6', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view6', {
                    templateUrl: 'app/view6/view6.html'
                });

            }])
        .controller("View6Ctrl", ["$scope", "dataFactory", function ($scope, dataFactory) {
                $scope.dataFactory = dataFactory;


                $scope.addRegistrationAsJSON = function () {

                    var res = $http.post('api/flightreservation', $scope.newregistration);
                    res.success(function (data, status, headers, config) {
                        $scope.message = data;
                        alert("Flight registered. Have a nice trip.");
                        $scope.newregistration.flight = "MH370";
                    });
                    res.error(function (data, status, headers, config) {
                        alert("failure message: " + JSON.stringify({data: data}));
                    });
                };

                $scope.resGetNumberOfPassengers = function (flight) {
                    return new Array(flight.numberOfSeats);
                };

                $scope.resIncreaseNumberOfPassengers = function (flight) {
                    flight.numberOfSeats++;
                };

                $scope.resDecreaseNumberOfPassengers = function (flight) {
                    if (flight.numberOfSeats !== 1) {
                        flight.numberOfSeats -= 1;
                    }
                };
//
//
//                //Repeating n number of first-/lastname registrations
//                $scope.getTimes = function (n) {
//                    return new Array(n);
//                };
            }]);

