<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="../fragments/headTag.jsp"/>
    </head>

    <body>
        <jsp:include page="../fragments/bodyHeader.jsp"/>

        <div class="container-fluid">
          <div class="row">

            <jsp:include page="../fragments/bodyDashboardSideBar.jsp"/>

            <div class="col-sm-9 col-md-10 col-md-offset-2">
              <h1 class="page-header">Novos produtos</h1>

              <div class="row placeholders">
                <div class="col-xs-6 col-sm-3 placeholder">
                  <img src="images/carro_apple.jpg" width="200" height="200" class="img-responsive" alt="Carro Antigo">
                  <h4>Carro Apple</h4>
                  <span class="text-muted">600€</span>
                </div>
                <div class="col-xs-6 col-sm-3 placeholder">
                  <img src="images/carro_audi.jpg" width="200" height="200" class="img-responsive" alt="Carro Antigo">
                  <h4>Carro Audi</h4>
                  <span class="text-muted">60€</span>
                </div>
                <div class="col-xs-6 col-sm-3 placeholder">
                  <img src="images/carro_ferrari.jpg" width="200" height="200" class="img-responsive" alt="Carro Antigo">
                  <h4>Carro Ferrai</h4>
                  <span class="text-muted">700€</span>carro_golf
                </div>

                <div class="col-xs-6 col-sm-3 placeholder">
                  <img src="images/carro_golf.jpg" width="200" height="200" class="img-responsive" alt="Carro Antigo">
                  <h4>Carro WWW</h4>
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

        <jsp:include page="../fragments/bodyFooter.jsp"/>
    </body>
</html>