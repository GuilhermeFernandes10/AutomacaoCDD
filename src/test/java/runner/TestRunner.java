package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {
					
					"src/test/resources/login.feature",
					//"src/test/resources/fila_prof_sem_turma.feature",
					//"src/test/resources/FilaPorTurma.feature",
					//"src/test/resources/fila_prof_com_turma.feature",
					//"src/test/resources/lista_curso.feature",
					//"src/test/resources/cadastrar_curso.feature",
					//"src/test/resources/atribuir_turma_professor.feature",
					//"src/test/resources/cadastrar_professor.feature",
					
		},
		glue = "steps",
		plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
		monochrome = true, 
		snippets = SnippetType.CAMELCASE,
		strict = false)

public class TestRunner {


}