<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

                <h:projetoSideBar />

                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">Projectos</h1>

                    <div class="btn-group" role="group" aria-label="...">
                        <a href="/projectos/registar" class="btn btn-default" role="button">
                            <span class="glyphicon glyphicon-new-window" aria-hidden="true"></span>
                            <span>Novo Projecto</span>
                        </a>
                        <a href="#" class="btn btn-default" role="button">
                            <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                            <span>Editar Projecto</span>
                        </a>
                        <a href="#" class="btn btn-default" role="button">
                            <span class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span>
                            <span>Apagar Projecto</span>
                        </a>
                    </div>
                    <h2 class="sub-header">Lista de Projectos</h2>

                    <form:form action="/projectos/listar" method="GET" modelAttribute="projecto" class="form-inline">
                        <div class="input-group">
                            <span class="input-group-addon">@</span>
                            <input type="text" class="form-control" name="search" id="search" placeholder="pesquisa aqui...">
                        </div>
                        <button type="submit" class="btn btn-primary">Pesquisar</button>
                    </form:form>

                    <div class="table-responsive">
                        <table class="table table-striped table-bordered">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Nome Projecto</th>
                                    <th>Valor</th>
                                    <th>Promotor</th>
                                    <th>Estado</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${projectos}" var="projecto">
                                    <tr>      
                                        <td>${projecto.projectoId}</td>
                                        <td>${projecto.projectoNome}</td>
                                        <td>${projecto.projectoValor}</td>
                                        <td>${projecto.projectoPromotorNome}</td>
                                        <td>${projecto.projectoStatus}</td>  
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    
                    <!-- SETUP PAGINATOR TAG ?page=2&size=9&sort=projectoNome,desc -->
                    <h:paginator baseUrl="/projectos/listar" paginCurrentIndex="1"
                         paginBeginIndex="2" paginEndIndex="5" paginTotalPages="10"/>
                </div>
            </div>
        </div>

        <h:pageFooter/>
    </body>
</html>
