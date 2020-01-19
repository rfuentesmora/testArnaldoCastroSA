var app = angular.module("CharacterManagement", []);
app.controller("CharacterController", function($scope, $http) {


    $scope.characters = [];
    $scope.characterForm = {
        id : ""
    };
    $scope.submitCharacterId = function(){
        if($scope.characterForm.id == ""){
            alert("Debe Ingresar un id de caracter")
        }
        else {
            $http({
                method : "GET",
                url : "/character/"+$scope.characterForm.id,
                headers : {
                    'Content-Type' : 'application/json'
                }
            }).then( function(data){
                $scope.characters = data.data.data.results;
            }, function (reason) {
                $scope.characters = []
                alert(reason.data.message);
            }
            );
        }
    }
});