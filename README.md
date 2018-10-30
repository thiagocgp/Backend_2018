# Backend_2018
Repositório do trabalho final da matéria "Programação Back-End Avançada" do curso de Especialização em Desenvolvimento Web e Mobile - full stack.

Alunos:
- Thiago de Castro G. Pereira
- Ítalo Tavares
- Axel Miguez

# SAPATARIA - Vendas e Controle de Estoque

Descrição do trabalho:





## API de Controle do Estoque

__Descrição__

API responsável por fornecer e guardar dados relativos ao estoque da Sapataria. Esta API foi feita usando a linguagem JAVA na Eclipse IDE. Foi utilizado o Maven para o gerenciamento de repositórios e a biblioteca Jersey para os serviços REST. O banco de dados utilizado foi o MySql e fazendo a conexão com mesmo através do JDBC.

O projeto desta API está na pasta (Estoque).

O arquivo (MySql_Criar_Popular_BD.txt) contém queries para a criação do banco, da tabela e também adiciona algúns dados na tabela afim de facilitar os testes. A tabela contém 5 colunas (id, nome, quantidade, preco, numero) os quais contém os dados para cada modelo de sapato no estoque.

Esta API retorna os dados através de JSON.

_Exemplo:_
   
   ```json
   {
      "id":6,
      "nome":"Tenis de Corrida",
      "quantidade":2,
      "preco":345.90,
      "numero":40
   }
   ```

__Obter dados do estoque__

- Todo estoque

  GET - http://localhost/Estoque
  
- Por ID

  GET - http://localhost/Estoque/id/[id]
  
- Por Nome

  GET - http://localhost/Estoque/nome/[nome]
  
 __Adicionar produto no estoque__
  
  - POST - http://localhost/Estoque
   
   _Exemplo:_
   
   ```json
   {
      "nome":"Sapato Social",
      "quantidade":3,
      "preco":169.90,
      "numero":41
   }  
   ```

__Editar um produto no estoque__

   - PUT - http://localhost/Estoque/id/[id]
  
   _Exemplo:_
   
   http://localhost/Estoque/id/6
   
  ```json
   {
      "nome":"Tenis de Corrida",
      "quantidade":1,
      "preco":129.80,
      "numero":40
   }
   ```
   
__Deletar um produto no estoque__

  - DELETE - http://localhost/Estoque/id/[id]
  
  
  ## API de Vendas
  
  
  
