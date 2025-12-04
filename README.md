Menu

- Deve possuir uma imagem para cada link e não deve ser a do exemplo do primefaces.
- Deve possuir dois itens: Home e Venda. Os itens devem fazer o redirecionamento para as respectivas páginas.

Mensagem

- Utilizar o componente para exibir as mensagens do sistema na forma de ‘balão”.

Página de Venda

- Todos os campos (código, curso e valor) são obrigatórios.
- Validar os campos de entrada de dados (código e valor), devem ser maior do que zero.
- Os componentes de entrada de dados devem receber o focus quando o label é clicado.
- Após adicionar um curso, ele deve aparecer na Lista de Cursos. Esta ação simula a escolha de cursos que serão comprados.
- O botão “Pagamento” encaminha o usuário para a página de pagamento, somente se tiver pelo menos um curso adicionado na lista.
- Adicionar a propriedade **immediate="true”** no botão “Pagamento”.

Página de pagamento

- Deve listar os cursos adicionados na página de venda.
- Ao selecionar um desconto, o valor (total) deve ser atualizado.
- O botão finalizar deve encaminhar o usuário para a página inicial, apresentar uma mensagem que a venda foi finalizada e o valor pago, e permitir realizar um nova venda.
