<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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


                        <form:form action="/projectos/save" method="post" modelAttribute="projecto">
                        <div class="btn-group" role="group" aria-label="...">
                            <button type="submit" class="btn btn-primary">
                                <span class="glyphicon glyphicon-save" aria-hidden="true"></span>
                                <span>Gravar</span>
                            </button>
                            <button type="button" class="btn btn-default">Gravar & Registar novo</button>
                            <button type="button" class="btn btn-default">Cancelar</button>               
                        </div>
                        <h2 class="sub-header">Registar projecto</h2>
                        <!--
                        <div class="form-group">
                            <label for="projectoCodigo">Codigo do Projecto</label>
                            <form:input type="text" class="form-control" id="projectoCodigo" name="projectoCodigo" path="projectoCodigo"  placeholder="Codigo do projecto sera gerado automaticamente" readonly="true" />
                        </div>
                        -->
                        <div class="form-group">
                            <label for="projectoNome">Nome do Projecto</label>
                            <input type="text" class="form-control" id="projectoNome" name="projectoNome" path="projectoNome" placeholder="Nome do projecto" required="true"/>
                        </div>

                        <div class="form-group">
                            <label for="projectoValor">Valor do Projecto</label>
                            <input type="number" class="form-control" id="projectoValor" name="projectoValor" path="projectoValor" placeholder="Valor do projecto" required="true"/>
                        </div>
                        <div class="form-group">
                            <label for="projectoPromotorNome">Nome do Promotor</label>
                            <input type="text" class="form-control" id="projectoPromotorNome" name="projectoPromotorNome" path="projectoPromotorNome" placeholder="Nome do promotor" required="true"/>
                        </div>
                        <div class="form-group">
                            <label for="projectoPromotorEmail">Email do promotor</label>
                            <input type="email" class="form-control" id="projectoPromotorEmail" name="projectoPromotorEmail"  path="projectoPromotorEmail" placeholder="Email do promotor" required="true"/>
                        </div>
                        <!-- 
                        ESTA CAMPO FICA ESCONDIDO POR AGORA
                        <div class="form-group">
                            <label for="projectFileAtach">Anexo</label>
                            <input type="file" id="projectFileAtach" name="projectFileAtach">
                            <p class="help-block">Anexo do projecto.</p>
                        </div>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" id="projectoAnexoCheck" name="projectoAnexoCheck"> Tem anexo ?
                            </label>
                        </div>
                        -->
                    </form:form>
                </div>
            </div>
        </div>

        <h:pageFooter/>
    </body>
</html>
