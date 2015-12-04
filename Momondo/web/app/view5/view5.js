'use strict';
angular.module('myApp.view5', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view5', {
                    templateUrl: 'app/view5/view5.html'
                });
            }])
        .controller("View5Ctrl", ["$http", "$scope", function ($http, $scope) {
                $scope.getAllFlightinfo = function () {
                    var date;
                    try {
                        date = $scope.parameter.date;
                        var dateUTCDummy = date.getTime() - (date.getTimezoneOffset() * 60000); //Quick hack that does not consider daylight savings
                        var adjustedDateStr = new Date(dateUTCDummy).toISOString();
                        $scope.url = "api/link/" + $scope.parameter.origin + "/" + adjustedDateStr + "/" + $scope.parameter.seats;
                        console.log($scope.url);
                        console.log($scope.parameter.seats);
                    }
                    catch (error) {
                        $scope.status = "Please provide all inputs";
                    }
                    $http({
                        method: 'GET',
                        url: $scope.url
                    }).then(function success(response) {
                        $scope.status = response.status;
                        $scope.json = response.data;
                    }, function error(response) {
                        $scope.status = response.status;
                        $scope.json = JSON.stringify(response.data, null, 2);
                    });
                };
//                $scope.getAllFlightinfo();
            }]);
//                $scope.deleteUser = function (users) {
//                    $http({
//                        method: "DELETE",
//                        url: "api/admin/user/" + users.id
//                    }).then(function succesCallback(response) {
//                        $scope.getUsers();
//
//                    });
//
//
//                };
       