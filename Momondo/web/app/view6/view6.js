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

                $scope.cityNameConverter = function (cityCode) {

                    switch (cityCode) {
                        case "CPH":
                            cityCode = "Copenhagen";
                            break;
                        case "SXF":
                            cityCode = "Berlin";
                            break;
                        case "CDG":
                            cityCode = "Paris";
                            break;
                        case "BCN":
                            cityCode = "Barcelona";
                            break;
                        case "STN":
                            cityCode = "London";
                            break;
                    }
                    return cityCode;
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



                $scope.$watch(
                        "$scope.passengers", function () {
                            $scope.resGetNumberOfPassengers(dataFactory.getFlight());
                        });

                $scope.addReservation = function (flight) {

                    var info = flight.flightID + "/" + flight.numberOfSeats;
                    console.log(info)
                    dataFactory.addReservation(info)
                            .success(function (response) {
                                alert("Du har nu booket følgende: \n " + response.flightID + "\n" + response.Origin + " - " + response.Destination + "\n Antal passagere: " +  response.numberOfSeats);
                                console.log(response);
                                $scope.json = response;
                            })
                            .error(function (error) {
                                $scope.status = error + " - Error";
                                console.log("error = " + error)
                            });

                };
            }
        ]);


