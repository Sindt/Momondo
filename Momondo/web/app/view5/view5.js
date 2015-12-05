'use strict';
angular.module('myApp.view5', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view5', {
                    templateUrl: 'app/view5/view5.html'
                });
            }])
        .controller("View5Ctrl", ["$http", "$scope", function ($http, $scope) {
                $scope.getFlightinfo = function () {
                    var date;
                    try {
                        date = $scope.parameter.date;
                        var dateUTCDummy = date.getTime() - (date.getTimezoneOffset() * 60000); //Quick hack that does not consider daylight savings
                        var adjustedDateStr = new Date(dateUTCDummy).toISOString();

                    }
                    catch (error) {
                        $scope.status = "Please provide all inputs";
                    }
                    if ($scope.parameter.destination === undefined) {
                        $scope.url = "api/link/" + $scope.parameter.origin + "/" + adjustedDateStr + "/" + $scope.parameter.seats;
                        console.log($scope.url);
                    } else {
                        $scope.url = "api/link/" + $scope.parameter.origin + "/" + $scope.parameter.destination + "/" + adjustedDateStr + "/" + $scope.parameter.seats;
                        console.log($scope.url);
                    }
                    $http({
                        method: 'GET',
                        url: $scope.url
                    }).then(function success(response) {
                        $scope.status = response.status;
                        $scope.json = response.data;
                    }, function error(response) {
                        $scope.status = response.status + " - Error";
                    });
                }
            }]);