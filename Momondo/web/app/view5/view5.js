'use strict';
angular.module('myApp.view5', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view5', {
                    templateUrl: 'app/view5/view5.html'
                });
            }])
        .controller("View5Ctrl", ["$scope", "dataFactory", function ($scope, dataFactory) {
                $scope.dataFactory = dataFactory;

                $scope.options = [
                    {name: 'Copenhagen', value: 'CPH'},
                    {name: 'Berlin', value: 'SXF'},
                    {name: 'Paris', value: 'CDG'},
                    {name: 'Barcelona', value: 'BCN'},
                    {name: 'London', value: 'STN'}
                ];

                $scope.origin = $scope.options[0];

                $scope.getFlightinfo = function () {
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