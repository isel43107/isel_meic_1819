<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="h" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <h:pageHeader />
    </head>

    <body>
        <h:pageTopMenu />

        <div class="container-fluid">
            <div class="row">

                <h:produtoSideBar />

                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">Produtos</h1>

                    <h:produtoToolbar />
                    <!--
                    <h2 class="sub-header">Lista de Produtos</h2>
                    -->
                    <div class="clearfix"></div>

<c:if test="${!empty produtos}">

                    <form:form action="/produtos" method="GET" modelAttribute="produto" class="form-inline">
                        <div class="input-group">
                            <span class="input-group-addon">@</span>
                            <input type="text" class="form-control" name="search" id="search" placeholder="pesquisa aqui...">
                        </div>
                        <button type="submit" class="btn btn-primary">Pesquisar</button>
                    </form:form>
                    <div class="clear"></div>

                    <div class="table-responsive">
                        <table class="table table-striped table-bordered">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Nome</th>
                                    <th>Valor</th>
                                    <th>Data</th>
                                    <th>Estado</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${produtos}" var="produto">
                                    <tr>      
                                        <td>${produto.id}</td>
                                        <td>${produto.title}</td>
                                        <td>${produto.minimunValue}</td>
                                        <td>${produto.finishDate}</td>
                                        <td>${produto.status}</td>  
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    
                    <!-- SETUP PAGINATOR TAG ?page=2&size=9&sort=projectoNome,desc -->
                    <h:paginator baseUrl="/projectos/listar" paginCurrentIndex="1"
                         paginBeginIndex="2" paginEndIndex="5" paginTotalPages="10"/>
</c:if>

<c:if test="${empty produtos}">
                    <p>Não existem produtos registados</p>
</c:if>

                </div>
            </div>
        </div>

        <h:pageFooter/>
    </body>
</html>
