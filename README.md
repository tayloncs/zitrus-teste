
# Teste - Zitrus

Projeto desenvolvido por Taylon Castro Stefanello para avalição tecnica no processo de seleção.


## Stack utilizada

**Java 17:** Maven, TomCat7, JSP, Servlet

**Banco dados:** MySql, Docker, Liquibase


## Rodando localmente

Necessario Docker, Tomcat7 instalado

```bash
  git clone https://github.com/tayloncs/zitrus-teste.git
```

Entre no diretorio do projeto

```bash
  cd zitrus-teste
```

Na raiz do projeto executar Docker no arquivo docker-compose.yml para criar um banco de dados MySql

```bash
  docker-compose run
```
Usando o maven para instalar as dependencias e rodar o liqueBase para criar tabelas no banco. obs: pode ser usado pela IDE

```bash
  mvn install
  mvn liquibase:update
```  
Use o tomCat para subir a aplicação

```bash
  mvn tomcat7:run
``` 
Acesse http://localhost:8080/
## Funcionalidades

- Botões Cadastro e Autorização para navegar entre operações
- Cadastro deve indicar dados a ser inserido
- Se processo não existir ira criar um processo com os dados
- Caso ja exista uma Autorização com os dados (numero processo, idade, sexo) deve atualizar o campo PERMITIDO
- Resgistro ja existente no banco não são excluidos, tem o valor DATA_ATUALICAO inserido e um novo resgistro é criado para manter um historico
- Ao consultar uma Autorização retorna o registro com data mais atual


## Autores

- [@Tayloncs](https://github.com/tayloncs)

