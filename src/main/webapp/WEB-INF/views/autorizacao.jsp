<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <style><%@include file="/WEB-INF/css/style.css"%></style>
    <title>Consulta Autorização</title>
</head>
<body>
<div class='btn-container paper'>
    <a href="/cadastro">
        <button type="button">Cadastro</button>
    </a>
    <a href="/">
        <button type="button">Autorização</button>
    </a>
    <form action="" method="get">
      <h3> Consulta Autorização </h3>
      <div class='input-container'>
        <label for="idProcedimento">ID Procedimento</label>
        <input value="<%= request.getParameter("idProcedimento") %>" type="number" id="idProcedimento" name="idProcedimento" maxlength="3" required>
      </div>
      <div class='input-container'>
        <label for="idade">Idade</label>
        <input value="<%= request.getParameter("idade") %>" type="number" id="idade" name="idade" min="0" max="120" required>
      </div>
      <div class='input-container'>
        <label for="sexo">Sexo</label>
        <select id="sexo" name="sexo" required>
          <option value="">Selecione</option>
          <option value="M" ${sexo eq 'M' ? 'selected' : ''}>Masculino</option>
          <option value="F" ${sexo eq 'F' ? 'selected' : ''}>Feminino</option>
        </select>
      </div>
      <div class='btn-container'>
        <button type="submit">Enviar</button>
      </div>
      <div class='btn-container'>
      <c:if test="${not empty autorizacao}">
        <h2>${autorizacao}</h2>
        </c:if>
      </div>
    </form>
    </div>
</body>
</html>
