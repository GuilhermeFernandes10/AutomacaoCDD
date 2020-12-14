$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/login.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "# language: pt"
    }
  ],
  "line": 4,
  "name": "Validar Login no sistema",
  "description": "Como usuario\r\nEu gostaria de logar no Sistema de Distribuicao de Disciplinas\r\nPara que eu possa acessar o sistema",
  "id": "validar-login-no-sistema",
  "keyword": "Funcionalidade",
  "tags": [
    {
      "line": 3,
      "name": "@LoginStep"
    }
  ]
});
formatter.scenarioOutline({
  "line": 10,
  "name": "Login no sistema com sucesso",
  "description": "",
  "id": "validar-login-no-sistema;login-no-sistema-com-sucesso",
  "type": "scenario_outline",
  "keyword": "Esquema do Cenario",
  "tags": [
    {
      "line": 9,
      "name": "@login"
    }
  ]
});
formatter.step({
  "line": 11,
  "name": "que o usuario tenha acesso a pagina inicial do Sistema de Distribuicao de Disciplinas",
  "keyword": "Dado "
});
formatter.step({
  "line": 12,
  "name": "entrar com seu \"\u003csiape\u003e\"",
  "keyword": "Quando "
});
formatter.step({
  "line": 13,
  "name": "o usuario sera logado com sucesso",
  "keyword": "Entao "
});
formatter.examples({
  "line": 15,
  "name": "",
  "description": "",
  "id": "validar-login-no-sistema;login-no-sistema-com-sucesso;",
  "rows": [
    {
      "cells": [
        "siape"
      ],
      "line": 16,
      "id": "validar-login-no-sistema;login-no-sistema-com-sucesso;;1"
    },
    {
      "cells": [
        "1770125"
      ],
      "line": 17,
      "id": "validar-login-no-sistema;login-no-sistema-com-sucesso;;2"
    }
  ],
  "keyword": "Exemplos"
});
formatter.scenario({
  "line": 17,
  "name": "Login no sistema com sucesso",
  "description": "",
  "id": "validar-login-no-sistema;login-no-sistema-com-sucesso;;2",
  "type": "scenario",
  "keyword": "Esquema do Cenario",
  "tags": [
    {
      "line": 9,
      "name": "@login"
    },
    {
      "line": 3,
      "name": "@LoginStep"
    }
  ]
});
formatter.step({
  "line": 11,
  "name": "que o usuario tenha acesso a pagina inicial do Sistema de Distribuicao de Disciplinas",
  "keyword": "Dado "
});
formatter.step({
  "line": 12,
  "name": "entrar com seu \"1770125\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Quando "
});
formatter.step({
  "line": 13,
  "name": "o usuario sera logado com sucesso",
  "keyword": "Entao "
});
formatter.match({
  "location": "LoginStep.queOUsuarioTenhaAcessoAPaginaInicialDoSistemaDeDistribuicaoDeDisciplinas()"
});
formatter.result({
  "duration": 6768515300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1770125",
      "offset": 16
    }
  ],
  "location": "LoginStep.entrarComSeu(String)"
});
formatter.result({
  "duration": 235472500,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.oUsuarioSeraLogadoComSucesso()"
});
formatter.result({
  "duration": 710799100,
  "status": "passed"
});
formatter.after({
  "duration": 1014764500,
  "status": "passed"
});
});