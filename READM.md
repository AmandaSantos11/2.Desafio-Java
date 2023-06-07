# 2º Desafio - Java

*Nesse desafio o objetivo era desenvolver um sistema de vendas.*

<hr>

**A regra de negócio era:**

+ **Ter um sistema que:**
  + Registra a venda do vendedor;
  + Histórico de compra do cliente;
  + O sistema não permite emails e cpfs repetidos;
  + Para comprar e vender é necessário que o cliente/vendedor esteja cadastrado;
  + Emails só podem ser válidos se tiverem o ‘@’.

<hr>

+ Inicie o desafio desenvolvendo uma classe nomeada ‘MenuDaLoja’ nela instanciei um Scanner e duas classes nomeadas ‘Vendedor’ e ‘Cliente’ que foram criadas depois. Ainda na minha classe Menu desenvolvi mais quatro métodos sendo eles:

  + ‘menuPrincipal()’ - nesse método eu mostro para o usuario um menu com três opções 1-Fazer Login,2-Cadastrar-se , 3-Sair.

  + ‘opcaoCadastro’ - esse método só é chamado quando o usuario escolhe a opção cadastrar do menu principal.

  + ‘opcaoLogin’- ocorre o mesmo que o método anterior.

  + ‘menuCliente’ - é um método que mostra um menu específico para o cliente após ele logar, com duas opções de realizar uma compra ou visualizar o histórico de compra.

+ Além disso, a classe Menu conta também com mais dois métodos do tipo boolean que servem para validar a escolha do usuário.


+ Em seguida desenvolvi uma classe nomeada ‘Cadastro’ que tem como atributos um scanner, nome, cpf, email, sendo esse três do tipo ‘String’. Criei dois métodos vazios sendo eles ‘cadastrarNoSistema()’ e ‘login()’, além disso criei também mais seis métodos do tipo boolean que servem para verificação de informações do usuário.


+ Após isso, desenvolvi uma classe ‘Cliente’ que estende de ‘Cadastro’ e em seguida trabalhei nos métodos ‘cadastrarNoSistema()’ e ‘login()’ que são utilizados para interagir com o usuário. Foram criados mais três métodos novos nessa classe, sendo eles:

  + ‘adicionarClienteNaLista()’ - serve para adicionar todo cliente nova em uma lista já existente.

  + ‘comprar()’ - é um método que interage com o usuário e permite a ele escolher o produto que deseja comprar.

  + ‘historicoDeCompraDoCliente’ - que exibe para o cliente os itens que ele comprou.

+ Além disso, essa classe também conta com mais outros métodos que servem para validar as informações.


+ Por fim, desenvolvi uma classe nomeada ‘Vendedor’ que também estende de ‘Cadastro’ e conta com mais três atributos sendo eles dois do tipo ‘String’ nomeados de nomeDoProduto e codigoDoProduto e o outro do tipo ‘Double’ nomeado valorUnitarioDoProduto. Essa classe segue uma lógica parecida com a do ‘Cliente’ a única diferença é que nesta o único momento que o usuário interage é quando ele registra um vendedor novo.

<hr>

# Conclusão

Com este desafio pude utilizar todos os conhecimentos adquiridos ao longo das aulas e tive a oportunidade de estudar e revisar alguns conhecimentos que não estavam bem fixados. 
