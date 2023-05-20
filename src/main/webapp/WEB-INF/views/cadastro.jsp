<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <style><%@include file="/WEB-INF/css/style.css"%></style>
    <title>Cadastro de Procedimento</title>
</head>
<body>
<div class='btn-container paper'>
    <a href="/cadastro">
        <button type="button">Cadastro</button>
    </a>
    <a href="/">
        <button type="button">Autorização</button>
    </a>
    <form action="" method="post">
      <h3> Cadastro de Procedimento </h3>
      <div class='input-container'>
        <label for="idProcedimento">ID Procedimento</label>
        <input type="number" id="idProcedimento" name="idProcedimento" maxlength="3" required>
      </div>
      <div class='input-container'>
              <label for="descricao">Descrição</label>
              <input type="text" id="descricao" name="descricao" maxlength="100">
            </div>
      <div class='input-container'>
        <label for="idade">Idade</label>
        <input type="number" id="idade" name="idade" min="0" max="120" required>
      </div>
      <div class='input-container'>
        <label for="sexo">Sexo</label>
        <select id="sexo" name="sexo" required>
          <option value="">Selecione</option>
          <option value="M">Masculino</option>
          <option value="F">Feminino</option>
        </select>
      </div>
      <div class='input-container'>
        <label for="isAutorizado">Permitir</label>
        <select id="isAutorizado" name="isAutorizado" required>
          <option value="">Selecione</option>
          <option value="TRUE">Sim</option>
          <option value="FALSE">Não</option>
        </select>
      </div>
      <div class='btn-container'>
        <button type="submit">Cadastrar</button>
      </div>
      <div class='btn-container'>
      <c:if test="${cadastrado != null}">
        <h2>${cadastrado}</h2>
        </c:if>
      </div>
    </form>
    </div>
</body>
</html>
