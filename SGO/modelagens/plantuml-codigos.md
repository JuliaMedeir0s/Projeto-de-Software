# 💻 Códigos PlantUML - Sistema de Gestão das Olimpíadas (SGO)

Este arquivo contém os códigos-fonte em PlantUML utilizados para gerar os diagramas UML do sistema SGO.

---

## 📌 Diagrama de Casos de Uso
```
@startuml
left to right direction
skinparam packageStyle rectangle

actor "Usuário" as Usuario
actor "Administrador do Sistema" as Admin
actor "Atleta" as Atleta

Admin --|> Usuario
Atleta --|> Usuario

rectangle "Sistema de Gestão das Olimpíadas (SGO)" {
    usecase "Cadastrar Competição" as UC1
    usecase "Inscrever-se em Competição" as UC2
    usecase "Alocar Local" as UC3
    usecase "Registrar Resultados" as UC4
    usecase "Visualizar Relatório de Medalhas" as UC5
}

Admin --> UC1
Admin --> UC3
Admin --> UC4
Atleta --> UC2
Usuario --> UC5
@enduml
```
---

## 📌 Diagrama de Classes com Pacotes
```
@startuml
skinparam packageStyle rectangle
skinparam classAttributeIconSize 0

package "model" {
    class Atleta {
        - nome: String
        - idade: int
        - sexo: String
        + inscrever(comp: Competição): void
    }
    class País {
        - nome: String
        - sigla: String
        + adicionarAtleta(atleta: Atleta): void
    }
    class Competição {
        - modalidade: String
        - data: Date
        - horario: String
        + adicionarAtleta(atleta: Atleta): void
        + definirResultado(resultado: Resultado): void
    }
    class Local {
        - nome: String
        - endereco: String
        - capacidade: int
        + verificarDisponibilidade(data: Date, horario: String): boolean
    }
}

package "resultado" {
    class Resultado {
        - ouro: Atleta
        - prata: Atleta
        - bronze: Atleta
        + gerarRelatorio(): String
    }
}

Atleta --> "1" País : representa
Atleta --> "0..*" Competição : participa
Competição --> "1" Local : ocorre em
Competição --> "1" Resultado : gera
Resultado --> Atleta : ouro
Resultado --> Atleta : prata
Resultado --> Atleta : bronze
País --> "0..*" Atleta : possui
Competição --> "0..*" Atleta : inscreve

@enduml
```
---

## 📌 Diagrama de Componentes
```
@startuml
skinparam componentStyle rectangle

component "Interface de Usuário" as UI
component "Módulo de Inscrições" as Inscricao
component "Módulo de Alocação" as Alocacao
component "Módulo de Resultados" as Resultados
component "Módulo de Relatórios" as Relatorios

UI --> Inscricao : inscrever atleta
UI --> Alocacao : alocar local
UI --> Resultados : registrar resultados
UI --> Relatorios : visualizar relatórios

Inscricao --> Resultados : gera resultado base
Resultados --> Relatorios : fornece dados

@enduml
```
---

## 📌 Diagrama de Implantação
```
@startuml
skinparam componentStyle rectangle

node "Usuário" {
    component "Navegador Web\n(Google Chrome)"
}

node "Servidor Web" {
    component "Interface de Usuário\n(React.js)"
}

node "Servidor de Aplicação\n(Node.js)" {
    component "Módulo de Inscrições"
    component "Módulo de Alocação"
    component "Módulo de Resultados"
    component "Módulo de Relatórios"
}

node "Banco de Dados\n(PostgreSQL)" {
    database "SGO_DB"
}

"Navegador Web\n(Google Chrome)" --> "Interface de Usuário\n(React.js)" : HTTP/HTTPS
"Interface de Usuário\n(React.js)" --> "Módulo de Inscrições"
"Interface de Usuário\n(React.js)" --> "Módulo de Alocação"
"Interface de Usuário\n(React.js)" --> "Módulo de Resultados"
"Interface de Usuário\n(React.js)" --> "Módulo de Relatórios"

"Módulo de Inscrições" --> "SGO_DB"
"Módulo de Alocação" --> "SGO_DB"
"Módulo de Resultados" --> "SGO_DB"
"Módulo de Relatórios" --> "SGO_DB"
@enduml
```
