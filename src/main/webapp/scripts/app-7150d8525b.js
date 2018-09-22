function homeApi(e,t){var o=t+"/rest/pompe";return{getAll:function(){return e.get(o+"/all")},getAllRecette:function(){return e.get(o+"/calculate")},getOne:function(t){return e.get(o+t+"/")},addOne:function(t){return e.post(o,t)},connecter:function(t){return e.put(o+"/connection/",t)},saveOne:function(t){return e.put(o+"/updateIndex/",t)},deleteOne:function(t){return e["delete"](o+t+"/")},getAllHistory:function(){return e.get(o+"/allHistory")}}}function cuveApi(e,t){var o=t+"/rest/cuve";return{getAll:function(){return e.get(o+"/all")},getOne:function(t){return e.get(o+t+"/")},addOne:function(t){return e.post(o,t)},saveOne:function(t){return e.put(o+t.id+"/",t)},deleteOne:function(t){return e["delete"](o+t+"/")},deposer:function(t){return e.put(o+"/depotage",t)}}}!function(){"use strict";angular.module("station-ui",["ngAnimate","ngMaterial","ngResource","ui.router","api","ui.bootstrap"])}(),function(){"use strict";function e(){function e(e,t,o){e.headerName="Head of App"}e.$inject=["$scope","$state","seasonService"];var t={restrict:"E",templateUrl:"app/components/header/header.html",controller:["$scope","$state",e],controllerAs:"vm",bindToController:!0};return t}angular.module("station-ui").directive("appHeader",e)}(),function(){"use strict";function e(){function e(e){}e.$inject=["$scope"];var t={restrict:"E",templateUrl:"app/components/footer/footer.html",controller:e,controllerAs:"vm",bindToController:!0};return t}angular.module("station-ui").directive("appFooter",e)}(),angular.module("station-ui").factory("HomeService",["HomeApi",function(e){return{getAll:function(t){e.getAll().then(function(e){t(e.data)})["catch"](function(e){})},getAllRecette:function(t){e.getAllRecette().then(function(e){t(e.data)})["catch"](function(e){})},getOne:function(t,o){e.getOne(t).success(function(e){var t=e&&""!=e?angular.fromJson(e):null;console.log(t),o(t)}).error(function(e,t){console.log("Error with response: "+e+", status :"+t)})},add:function(t,o){e.addOne(t).then(function(e){o(e)})["catch"](function(e){console.debug(">> catch"),console.debug(e)})},save:function(t,o){e.saveOne(t).then(function(e){o(e)})["catch"](function(e){console.debug(e)})},connecter:function(t,o){e.connecter(t).then(function(e){o(e)})["catch"](function(e){console.debug(e)})},"delete":function(t,o){e.deleteOne(t).success(function(e){var t=e&&""!=e?angular.fromJson(e):null;o(t)}).error(function(e,t){console.log("Error with response: "+e+", status :"+t)})},getAllHistory:function(t){e.getAllHistory().then(function(e){t(e.data)})["catch"](function(e){})}}}]),function(){"use strict";function e(e,t,o){e.pompeForm={},e.added=!1,e.IsVisibleConnection=!1,e.selectedPompe={},e.selectedCuve={},t.getAll(function(t){e.pompes=t,e.IsVisible=!0}),e.calculeClose=function(){e.pompesRecette=null},e.loadAll=function(){t.getAll(function(t){e.pompes=t})},e.submitPompe=function(){t.add(e.pompeForm,function(t){e.added=!0})},e.updateIndex=function(){t.save(e.selectedPompe,function(t){alert("Index pompe "+e.selectedPompe.id+" modifié"),e.selectedPompe={},e.loadAll()})},e.calculeResset=function(){t.getAllRecette(function(t){e.pompesRecette=t})},e.getTotal=function(){for(var t=0,o=0;o<e.pompesRecette.length;o++){var n=e.pompesRecette[o];t+=n.recette}return t},e.getAllCuves=function(){o.getAll(function(t){e.cuves=t,t&&(e.IsVisibleConnection=!0)})},e.connecter=function(){var o={idPompe:e.selectedPompe.id,idCuve:e.selectedCuve.id};t.connecter(o,function(t){alert(" pompe "+e.selectedPompe.id+" connecter à la cuve "+e.selectedCuve.id),e.selectedPompe={},e.selectedCuve={}})}}e.$inject=["$scope","homeService","cuveService"],angular.module("station-ui").controller("HomeController",["$scope","HomeService","CuveService",e])}(),angular.module("station-ui").factory("HomeApi",["$http","BASE_URL",homeApi]),function(){"use strict";function e(e,t){t.getAllHistory(function(t){e.pompes=t,e.IsVisible=!0})}e.$inject=["$scope","homeService"],angular.module("station-ui").controller("HistoriquePompeController",["$scope","HomeService",e])}(),function(){"use strict";function e(e,t){t.getAll(function(t){e.cuves=t}),e.depot={},e.deposer=function(){t.deposer(e.depot,function(t){alert(e.depot.quantite+" Litres a été mis dans la cuve numéro "+e.depot.idCuve)})}}e.$inject=["$scope","cuveService"],angular.module("station-ui").controller("DepotageController",["$scope","CuveService",e])}(),angular.module("station-ui").factory("CuveService",["CuveApi",function(e){return{getAll:function(t){e.getAll().then(function(e){t(e.data)})["catch"](function(e){})},getOne:function(t,o){e.getOne(t).success(function(e){var t=e&&""!=e?angular.fromJson(e):null;console.log(t),o(t)}).error(function(e,t){console.log("Error with response: "+e+", status :"+t)})},add:function(t,o){e.addOne(t).then(function(e){o(e)})["catch"](function(e){console.debug(">> catch"),console.debug(e)})},save:function(t,o){e.saveOne(t).success(function(e){var t=e&&""!=e?angular.fromJson(e):null;o(t)}).error(function(e,t){console.log("Error with response: "+e+", status :"+t)})},deposer:function(t,o){e.deposer(t).then(function(e){o(e)})["catch"](function(e){})},"delete":function(t,o){e.deleteOne(t).success(function(e){var t=e&&""!=e?angular.fromJson(e):null;o(t)}).error(function(e,t){console.log("Error with response: "+e+", status :"+t)})}}}]),function(){"use strict";function e(e,t,o,n){e.cuveForm={},e.added=!1,n.getAll(function(t){e.isVisiblesVisible=!1,e.cuves=t,t&&(e.isVisible=!0)}),e.submitCuve=function(){n.add(e.cuveForm,function(t){e.added=!0})}}e.$inject=["$scope","$state","$stateParams","cuveService"],angular.module("station-ui").controller("CuveController",["$scope","$state","$stateParams","CuveService",e])}(),angular.module("station-ui").factory("CuveApi",["$http","BASE_URL",cuveApi]),function(){"use strict";function e(e,t){t.getAllRecette(function(t){e.pompesRecette=t}),e.getTotal=function(){for(var t=0,o=0;o<e.pompesRecette.length;o++){var n=e.pompesRecette[o];t+=n.recette}return t}}e.$inject=["$scope","homeService"],angular.module("station-ui").controller("ComptabiliteController",["$scope","HomeService",e])}(),angular.module("api",[]).value("BASE_URL","http://localhost:8080"),function(){"use strict";function e(e){e.debug("station-ui run block end")}e.$inject=["$log"],angular.module("station-ui").run(e)}(),function(){"use strict";function e(e,t){e.state("home",{url:"/",templateUrl:"app/home/home.html",controller:"HomeController",controllerAs:"home"}).state("updatePompe",{url:"/",templateUrl:"app/home/updatePompe.html",controller:"HomeController",controllerAs:"home"}).state("home-base",{url:"",templateUrl:"app/home/home.html",controller:"HomeController",controllerAs:"home"}).state("cuve",{url:"/cuve",templateUrl:"app/cuve/cuve.html",controller:"CuveController",controllerAs:"cuve"}).state("comptabilite",{url:"/comptabilite",templateUrl:"app/comptabilite/comptabilite.html",controller:"ComptabiliteController",controllerAs:"comptabilite"}).state("depotage",{url:"/depotage",templateUrl:"app/cuve/depotage.html",controller:"DepotageController",controllerAs:"depotage"}).state("historiquePompe",{url:"/historiquePompe",templateUrl:"app/home/historiqueIndex.html",controller:"HistoriquePompeController",controllerAs:"HistoriquePompeController"}).state("404",{url:"/404",template:"<h1 style='text-align: center'>Page not found !</h1>"}),t.otherwise("/404")}e.$inject=["$stateProvider","$urlRouterProvider"],angular.module("station-ui").config(e)}(),function(){"use strict";function e(e){}e.$inject=["$scope"],angular.module("station-ui").controller("AppController",["$scope",e])}(),function(){"use strict";angular.module("station-ui").constant("LOCALES",{locales:{zh_CN:"中国",fr_FR:"Français",en_GB:"English"},preferredLocale:"en_GB"})}(),function(){"use strict";function e(e){e.debugEnabled(!0)}e.$inject=["$logProvider"],angular.module("station-ui").config(e).config(["$httpProvider",function(e){}]).config(["$httpProvider",function(e){}])}(),angular.module("station-ui").run(["$templateCache",function(e){e.put("app/comptabilite/comptabilite.html",'<!DOCTYPE html><html lang=en><head><meta charset=UTF-8><title>Title</title></head><body ng-app=station-ui ng-controller=ComptabiliteController><div><h4 class=text-center>Le compte est fait à la base des Index des Pompes</h4></div><div class="well well-sm" ng-if=pompesRecette><h3 class=text-center>Recette</h3><table class="table table-bordered"><thead><tr style="background-color: #d58512"><th>Numéro de la pompe</th><th>Recette</th></tr></thead><tbody ng-repeat="pompe in pompesRecette"><tr><td>{{pompe.id}}</td><td>{{pompe.recette}}</td></tr></tbody><tfoot><tr style="background-color: slategrey"><td><b>TOTALE</b></td><td><b>{{ getTotal() }}</b></td></tr></tfoot></table></div></body></html>'),e.put("app/cuve/cuve.html",'<html><head><title>cuve</title><head><body ng-app=station-ui ng-controller=cuveController><!--<a ui-sref="home">Back to home page</a>--><div class=container><div class="well well-sm"><h2 class=text-center>Ajouter une Cuve</h2><form ng-submit=submitCuve() class=form-horizontal><pre>\r\n			Numéro :  <input type=text ng-model=cuveForm.id>\r\n\r\n			Capacité: <input type=text ng-model=cuveForm.capacite>\r\n        </pre><input type=submit class="btn btn-primary center-block" value=Sauvgarder><div class="alert alert-success" ng-if="added===true"><strong></strong> Cuve ajouté avec succes</div></form></div><div class="well well-sm"><h3 class=text-center>Liste des Cuves</h3><table class="table table-bordered" ng-show="cuves.length >0"><tr style="background-color: #d58512"><th>Numéro</th><th>Capacité</th><th>Contenu</th><th>derniers depot</th></tr><tbody ng-repeat="cuve in cuves"><tr><td>{{cuve.id}}</td><td>{{cuve.capacite}}</td><td>{{cuve.contenu}}</td><td>{{cuve.lastdepot | date: \'dd-MM-yyyy HH:mm\'}}</td></tr></tbody></table></div></div></body></head></head></html>'),e.put("app/cuve/depotage.html",'<!DOCTYPE html><html lang=en><head><meta charset=UTF-8><title>Title</title></head><body><html><head><title>AngularJS $http Rest example</title><head><body ng-app=station-ui ng-controller=DepotageController><div class=container><div class="well well-sm"><h3 class=text-center>Dépot dans une Cuve</h3><h4>Selectionnez la Cuve</h4><pre>\r\n       Numéro : <select class=selectpicker ng-model=depot.idCuve ng-options="cuve.id as cuve.id for cuve in cuves"></select>\r\n\r\n       Quantité:  <input type=text ng-model=depot.quantite>\r\n        </pre><div><button ng-click=deposer() class="btn btn-primary">Sauvgarder</button></div></div></div></body></head></head></html></body></html>'),e.put("app/home/historiqueIndex.html",'<!DOCTYPE html><html lang=en><head><meta charset=UTF-8><title>Hitorique Pompe</title></head><body><div class="well well-sm"><h3 class=text-center>Historique des pompes</h3><table class="table table-bordered" ng-show=IsVisible><tr style="background-color: #d58512"><th>Numéro de la Pompe</th><th>Index Actuel</th><th>Ancien Index</th><th>date de dernière mise à jour</th></tr><tbody ng-repeat="pompe in pompes"><tr><td>{{pompe.id}}</td><td>{{pompe.index}}</td><td>{{pompe.lastIndex}}</td><td>{{pompe.lasteUpdate |date: \'dd-MM-yyyy HH:mm\'}}</td></tr></tbody></table></div></body></html>'),e.put("app/home/home.html",'<html><head><title>AngularJS $http Rest example</title><head><body ng-app=station-ui ng-controller=HomeController><div class=container><div class="well well-sm"><h3 class=text-center>Ajouter une pompe</h3><form ng-submit=submitPompe()><pre>\r\n        Numéro: <input type=text required ng-model=pompeForm.id>\r\n\r\n        Index : <input type=text required pattern=[0-9]* ng-model=pompeForm.index>\r\n        </pre><input type=submit class="btn btn-primary center-block" value=Sauvgarder><div class="alert alert-success" ng-if="added===true"><strong></strong> Pompe ajouté avec succes</div></form></div><button ng-click=getAllCuves() class="btn btn-primary" ng-show=!IsVisibleConnection>Connexion</button><div class="well well-sm" ng-show=IsVisibleConnection><h4 class=text-center>Connecter une Pompe à une Cuve</h4>Selectionez la pompe:<select class=selectpicker ng-model=selectedPompe.id ng-options="item.id as item.id for item in pompes"></select>Selectionez la Cuve :<select ng-model=selectedCuve.id ng-options="cuve.id as cuve.id for cuve in cuves"></select><div><button ng-click=connecter() class="btn btn-primary">Connecter</button></div></div></div></body></head></head></html>'),e.put("app/home/updatePompe.html",'<html><head><title>AngularJS $http Rest example</title><head><body ng-app=station-ui ng-controller=HomeController><div class=container><div class="well well-sm"><h3 class=text-center>Modifier L\'index d\'une pompe</h3><h4>Selectionnez la pompe</h4><pre>\r\n       Numéro : <select class=selectpicker ng-model=selectedPompe.id required ng-options="item.id as item.id for item in pompes"></select>\r\n\r\n       Index:  <input type=number required ng-model=selectedPompe.index>\r\n        </pre><div><button type=submit ng-click=updateIndex() class="btn btn-primary">Modifier</button></div></div><div class="well well-sm"><h3 class=text-center>Liste des pompes</h3><table class="table table-bordered" ng-show=IsVisible><tr style="background-color: #d58512"><th>Pompe</th><th>Index Actuel</th><th>Ancien Index</th><th>date de prelevement</th></tr><tbody ng-repeat="pompe in pompes"><tr><td>{{pompe.id}}</td><td>{{pompe.index}}</td><td>{{pompe.lastIndex}}</td><td>{{pompe.lasteUpdate |date: \'dd-MM-yyyy HH:mm\'}}</td></tr></tbody></table></div></div></body></head></head></html>'),e.put("app/components/footer/footer.html",'<nav class="navbar navbar-default" style="background-color: #5bc0de"><h5 class=text-center>Cheikh Bay CHEIKH MOHAMEDOU 2018</h5></nav>'),e.put("app/components/header/header.html",'<html><head><meta charset=utf-8><meta http-equiv=X-UA-Compatible content="IE=edge"><meta name=viewport content="width=device-width,initial-scale=1"><title></title></head><body><div class=bs-example><nav class="navbar navbar-default" style="background-color: #5bc0de"><div class=navbar-header><ul class="nav navbar-nav"><div id=gestionCuve class="collapse navbar-collapse"><ul class="nav navbar-nav"><li class=dropdown><a data-toggle=dropdown class=dropdown-toggle href="">Gestion des Cuves <b class=caret></b></a><ul class=dropdown-menu><li><a ui-sref=cuve>Ajouter une Cuve</a></li><li><a ui-sref=depotage>Dépotage</a></li></ul></li><li class=dropdown><a data-toggle=dropdown class=dropdown-toggle href="">Gestion des Pompes <b class=caret></b></a><ul class=dropdown-menu><li><a ui-sref=home>Ajouter une Pompe</a></li><li><a ui-sref=updatePompe>Modification d\'Index</a></li><li><a ui-sref=historiquePompe>Historique Pompe</a></li></ul></li><li><a ui-sref=comptabilite>Comptabilité</a></li></ul></div></ul></div></nav></div></body></html>')}]);
//# sourceMappingURL=../maps/scripts/app-7150d8525b.js.map
