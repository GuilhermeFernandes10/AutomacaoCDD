#language: pt

@FilaDeProfessorPorTurma
Funcionalidade: apresentar a fila de professores por turma cadastrada
	Como usuario
	Eu gostaria de realizar a busca de professores pelo nome da turma
	Para que eu possa visualizar os professor por turma
	
	Contexto:
		Dado que o usuario tenha acesso a pesquisa de filas por turma
	
	@FilaProfessorPorNomeDaTurma
	Esquema do Cenario: Validar a pesquisa de professores por nome da turma
		Quando buscar pelo nome da "<turma>" os professores na fila
		Entao o sistema apresentara os professores na lista da "<turma>" de acordo com os dados informados
	
		Exemplos:
		|			turma			|
		| 	FACOM39802	|