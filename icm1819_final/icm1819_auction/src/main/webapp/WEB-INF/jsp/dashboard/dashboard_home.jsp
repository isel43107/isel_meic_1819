<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="h" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <h:pageHeader />
    </head>

    <body>
        <h:pageTopMenu />

        <div class="container-fluid">
          <div class="row">

            <h:dashboardSideBar />

            <div class="col-sm-9 col-md-10 col-md-offset-2">
              <h1 class="page-header">Novos produtos</h1>

              <div class="row placeholders">
                <div class="col-xs-6 col-sm-3 placeholder">
                  <img src="images/carro_apple.jpg" width="200" height="200" class="img-responsive" alt="Carro Apple">
                  <h4>Carro Apple</h4>
                  <span class="text-muted">600€</span>
                </div>
                <div class="col-xs-6 col-sm-3 placeholder">
                  <img src="images/carro_audi.jpg" width="200" height="200" class="img-responsive" alt="Carro Audi">
                  <h4>Carro Audi</h4>
                  <span class="text-muted">60€</span>
                </div>
                <div class="col-xs-6 col-sm-3 placeholder">
                  <img src="images/carro_ferrari.jpg" width="200" height="200" class="img-responsive" alt="Carro Ferrari">
                  <h4>Carro Ferrari</h4>
                  <span class="text-muted">700€</span>
                </div>

                <div class="col-xs-6 col-sm-3 placeholder">
                  <img src="images/carro_golf.jpg" width="200" height="200" class="img-responsive" alt="Carro WW">
                  <h4>Carro WW</h4>
                  <span class="text-muted">100€</span>
                </div>
                <div class="col-xs-6 col-sm-3 placeholder">
                  <img src="images/carro_antigo.png" width="200" height="200" class="img-responsive" alt="Carro Antigo">
                  <h4>Carro Antigo</h4>
                  <span class="text-muted">60€</span>
                </div>
              </div>

            </div>
          </div>
        </div>

        <h:pageFooter />
    </body>
</html>