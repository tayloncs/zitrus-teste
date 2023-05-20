<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <body>
    <h2>TODO list</h2>

    <form action="" method="post">
      <label>
        Tarefa:
        <input type="text" name="nome" required="required" />
      </label>

      <input type="submit" value="Salvar" />
    </form>
    <ul>
      <c:forEach var="tarefa" items="${tarefas}">
        <li>${tarefa.nome}</li>
      </c:forEach>
    </ul>
  </body>
</html>
