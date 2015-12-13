'use strict';
angular.module('myApp.view6', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view6', {
                    templateUrl: 'app/view6/view6.html'
                });

            }])
        .controller("View6Ctrl", ["$scope", "dataFactory", function ($scope, dataFactory) {
                $scope.dataFactory = dataFactory;

                $scope.flightIdFormat = function (flightID) {

                    var formatedId = flightID.split("x")[0];
                    return formatedId;

                };
                $scope.dateTimeFormat = function (flightDate) {

                    var formatedDateTime = [];

                    formatedDateTime[0] = flightDate.split("T")[0];
                    formatedDateTime[1] = flightDate.split("T")[1].substring(0, 5);

                    return formatedDateTime;

                };

                $scope.updateTotalPrice = function (flight) {
                    flight.totalPrice = dataFactory.getBasePrice() * flight.numberOfSeats;
                };

                $scope.resGetNumberOfPassengers = function (flight) {
                    $scope.passengers = [];

                    for (var i = 0; i < flight.numberOfSeats; i++) {
                        $scope.passengers.push({firstName: "", lastName: ""});
                    }
                    console.log($scope.passengers);
                };
                $scope.addReservation = function (flight) {

                    var reservationInfo = [];
                    reservationInfo.push = (
                            "flightID:" + flight.flightID);
//                            "numberOfSeats:" +flight.numberOfSeats,
//                            $scope.name,
//                            $scope.phone,
//                            $scope.email,
//                            "Passengers:"    +$scope.passengers
//                            );

                    dataFactory.createReservation(reservationInfo);

                    console.log(reservationInfo);
                };
                window.onload = function () {
                    $scope.passengers.push({firstName: "", lastName: ""});

                };

            }
        ]);


