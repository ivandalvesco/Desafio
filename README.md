# Desafio Texo
Implementação do desafio fornecido pela Texo It
# Especificação do Teste 
 
Desenvolva uma API RESTful para possibilitar a leitura da lista de indicados e vencedores da categoria Pior Filme do Golden Raspberry Awards. 

# Requisito do sistema: 
1. Ler o arquivo CSV dos filmes e inserir os dados em uma base de dados ao inciar a aplicação; 

# Requisito da API:  
1. Obter o produtor com maior intervalo entre dois prêmios, e o que obteve dois prêmios mais rápido

# Requisitos não funcionais: 
1. O web service RESTful deve ser implementado com base no nível 2 de maturidade de Richardson; 
2. Devem ser implementados somente testes de integração; 
3. A base de dados deve estar em memória, nenhuma instalação externa deve ser necessária; 
4. A aplicação deve conter um readme com instruções para rodar o projeto e os testes; 
5. O código-fonte deve ser disponibilizado em um repositório git público (Github, Gitlab, Bitbucket, etc)

# Instruções de uso

O arquivo .csv encontra-se no path /src/main/resources/files/movielist.csv;
A listagem dos produtores com maior e menor intervalo entre os prêmios é realizada por meio do método;
GET http://localhost:8080/piores-filmes/premiacoes

# Testes

1. O teste para verificar a execução do método que irá listar os produtores com maior e menor intervalo entre as premiações irá ocorrer com sucesso quando o retorno da chamada do método para listar os produtores retornar um status Http Ok (200);
2. O teste para verificar a leitura e inserção dos registros vindos do arquivo .csv irá retornar com sucesso quando o número de registros retornado pela classe FilmeRepository, utilizando o método count() for maior que zero;
