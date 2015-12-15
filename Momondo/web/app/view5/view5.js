'use strict';
angular.module('myApp.view5', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view5', {
                    templateUrl: 'app/view5/view5.html'
                });
            }])
        .controller("View5Ctrl", ["$scope", "dataFactory", function ($scope, dataFactory) {
                $scope.dataFactory = dataFactory;
                $scope.showResultText = false;

                $scope.options = [
                    {name: 'Copenhagen', value: 'CPH'},
                    {name: 'Berlin', value: 'SXF'},
                    {name: 'Paris', value: 'CDG'},
                    {name: 'Barcelona', value: 'BCN'},
                    {name: 'London', value: 'STN'}
                ];

                $scope.origin = $scope.options[0];
                $scope.basePrice = dataFactory.getBasePrice();

                $scope.swapLocations = function () {
                    var temp;
                    temp = $scope.origin;
                    $scope.origin = $scope.destination;
                    $scope.destination = temp;

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

                $scope.flightIdFormat = function (flightID) {

                    var formatedId = flightID.split("x")[0];
                    return formatedId;
                    console.log(formatedId);
                };
                $scope.dateTimeFormat = function (flightDate) {

                    var formatedDateTime = [];

                    formatedDateTime[0] = flightDate.split("T")[0];
                    formatedDateTime[1] = flightDate.split("T")[1].substring(0, 5);
                    console.log(formatedDateTime);

                    return formatedDateTime;

                };


                $scope.getFlightinfo = function () {
                    $scope.showResultText = true;
                    var date;
                    var info;
                    try {
                        date = $scope.parameter.date;
                        var dateUTCDummy = date.getTime() - (date.getTimezoneOffset() * 60000); //Quick hack that does not consider daylight savings
                        var adjustedDateStr = new Date(dateUTCDummy).toISOString();
                    }
                    catch (error) {
                        $scope.status = "Please provide all inputs";
                    }
                    if ($scope.destination === undefined || $scope.destination === null) {
                        info = $scope.origin + "/" + adjustedDateStr + "/" + $scope.parameter.seats;
                        console.log(info);
                    } else {
                        info = $scope.origin + "/" + $scope.destination + "/" + adjustedDateStr + "/" + $scope.parameter.seats;
                        console.log(info);
                    }

                    dataFactory.getAllFlightinfo(info)
                            .success(function (response) {
                                console.log(response);
                                $scope.json = response;
                            })
                            .error(function (error) {
                                $scope.status = error + " - Error";
                            });
                };

                $scope.addFlight = function (flight) {
                    var data = flight;
                    console.log(flight);
                    dataFactory.addItem(data);
                };

                $scope.createResObject = function (flight) {
                    dataFactory.createResObject(flight.flightID);
                };

            }]);
