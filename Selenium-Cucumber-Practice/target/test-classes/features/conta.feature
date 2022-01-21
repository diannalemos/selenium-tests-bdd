Feature: Gerenciando contas
  Descrição feature


  Background:
    Given que estou acessando a aplicação
    When informo o usuário "ditest@test"
    And a senha "12345"
    And seleciono entrar
    Then visualizo a página inicial
    When seleciono Contas
    And seleciono Adicionar

  Scenario: Deve inserir uma conta com sucesso
    And informo a conta "ditest2"
    And seleciono Salvar
    Then a conta é inserida com sucesso

  Scenario: Não deve inserir uma conta sem nome
    And seleciono Salvar
    Then sou notificado que o nome da conta é obrigatório

  Scenario: Não deve inserir uma conta com nome já existente
    And informo a conta "ditest2"
    And seleciono Salvar
    Then sou notificado que já existe uma conta com esse nome