var personModule = angular.module("personApp", []);

var controller = personModule.controller("personController", function($scope, $http) {

    var res = $http.get("person");

    $scope.persons = [];
    $scope.toggle = true;

    res.success(function (data, status, headers, config) {
        $scope.persons = data;
    });
    res.error(function (data, status, headers, config) {
        alert("Error AJAX!!!");
    });

    $scope.addPerson = function() {

        if ($scope.personName == "" || $scope.personStatus == "" || $scope.personSex == "") {
            alert("Field can not be empty!!!");
        } else {
            var res = $http.post("person/" + $scope.personName + "/" + $scope.personStatus + "/" + $scope.personSex);
            res.success(function(data, status, headers, config) {
                $scope.persons = data;
                $scope.personName = "";
                $scope.personStatus = "";
                $scope.personSex = "";
            });
            res.error(function(data, status, headers, config) {
                alert("Error addPerson!!!");
            });
        }
    };

    $scope.updatePerson = function() {

        var res = $http.put("person/" + $scope.id + "/" + $scope.personName + "/" + $scope.personStatus + "/" + $scope.personSex);
        res.success(function(data, status, headers, config) {
            $scope.persons = data;
            $scope.personName = "";
            $scope.personStatus = "";
            $scope.personSex = "";
            $scope.toggle = true;
        });
        res.error(function(data, status, headers, config) {
            alert("Error updatePerson!!!");
        });
    };

    $scope.deletePerson = function(id) {

        var res = $http.delete("person/" + id);
        res.success(function (data, status, headers, config) {
            $scope.persons = data;
        });
        res.error(function (data, status, headers, config) {
            alert("Error deletePerson!!!");
        });
    };

    $scope.toggle = function(toggle, id) {
        $scope.toggle = toggle;
        $scope.id = id;
    };

    $scope.searchById = function() {
        var res = $http.get("person/" + $scope.id);
        res.success(function (data, status, headers, config) {
            $scope.persons = [data];
            console.log($scope.persons);
        });
        res.error(function (data, status, headers, config) {
            alert("Error searchPersonById!!!");
        });
    };

});