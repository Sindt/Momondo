'use strict';
angular.module('myApp.view6', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view6', {
                    templateUrl: 'app/view6/view6.html'
                });

            }])
        .controller("View6Ctrl", ["$scope", "dataFactory", function ($scope, dataFactory) {
                $scope.dataFactory = dataFactory;

                $scope.updateTotalPrice = function (flight) {
                    flight.totalPrice = dataFactory.getBasePrice() * flight.numberOfSeats;
                }

//                $scope.addRegistrationAsJSON = function () {
//
//                    var res = $http.post('api/flightreservation', $scope.newregistration);
//                    res.success(function (data, status, headers, config) {
//                        $scope.message = data;
//                        alert("Flight registered. Have a nice trip.");
//                        $scope.newregistration.flight = "MH370";
//                    });
//                    res.error(function (data, status, headers, config) {
//                        alert("failure message: " + JSON.stringify({data: data}));
//                    });
//                };
                $scope.resGetNumberOfPassengers = function (flight) {
                    return new Array(flight.numberOfSeats);
                };
                $scope.addRegistration = function (info) {
                    console.log(info);
//                    angular.forEach($scope.newregistration.firstName, function (value, key) {
//
//                        Passengers.push($scope.newregistration.firstName,
//                                $scope.newregistration.lastName);
//                    });
//                    console.log(Passengers);
//                    reservationInfo.push = (
//                            $scope.flightInfo.flightID,
//                            $scope.flightInfo.getNumberOfSeats,
//                            $scope.newregistration.name,
//                            $scope.newregistration.phone,
//                            $scope.newregistration.email,
//                            Passengers
//                            );
//
//                    console.log(reservationInfo);
                };
            }
        ]);


