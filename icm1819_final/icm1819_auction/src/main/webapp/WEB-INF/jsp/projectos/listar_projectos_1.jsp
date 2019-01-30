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

                    <h:projetoToolbar />
                    <h2 class="sub-header">Lista de Projectos</h2>

                    <form class="form-inline">
                        <div class="input-group">
                            <span class="input-group-addon">@</span>
                            <input type="text" class="form-control" name="search" id="search" placeholder="pesquisa aqui...">
                        </div>
                        <button type="submit" class="btn btn-primary">Pesquisar</button>
                    </form>

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

                    <!-- SETUP PAGINATION ?page=2&size=9&sort=projectoNome,desc -->
                    <c:set var="baseUrl"    value="/projectos/listar1" />
                    <jsp:include page="../fragments/pagination.jsp"/>
                    
                </div>
            </div>
        </div>

        <h:pageFooter/>
    </body>
</html>
