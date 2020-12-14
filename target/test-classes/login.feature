# language: pt

@LoginStep
Funcionalidade: Validar Login no sistema
	Como usuario
	Eu gostaria de logar no Sistema de Distribuicao de Disciplinas
	Para que eu possa acessar o sistema
	
	@login
	Esquema do Cenario: Login no sistema com sucesso
	Dado que o usuario tenha acesso a pagina inicial do Sistema de Distribuicao de Disciplinas
		Quando entrar com seu "<siape>"
		Entao o usuario sera logado com sucesso
	
		Exemplos:
		|		siape		|
		| 	1770125	|