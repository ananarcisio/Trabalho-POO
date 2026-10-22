# 🎓 Sistema de Gerenciamento Acadêmico - Faculdade

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com/)
[![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/)
[![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)](https://git-scm.com/)

> **Trabalho Prático - Programação Orientada a Objetos (POO)**  
> **Professor:** Lucas Schmidt  
> **Valor:** 10,0 pontos  

---

## 📌 Sobre o Projeto

Este projeto consiste em um sistema em Java voltado para a gestão de uma Faculdade. O sistema permite o gerenciamento completo (CRUD) de **Alunos**, **Disciplinas** e **Cursos**, garantindo a persistência dos dados em banco de dados e a devida navegação via interface de terminal interativa (Menus e Submenus).

---

## 🏛️ Arquitetura do Sistema

O projeto foi estruturado seguindo o padrão de arquitetura em camadas (**MVC / DAO**):

```text
src/
├── model/        # Classes de Domínio (Aluno, Curso, Disciplina)
├── dao/          # Persistência de Dados e Conexão JDBC
├── controller/   # Regras de Negócio e Associação de Objetos
└── view/         # Interface de Terminal (Menus, Submenus e Entradas de Dados)
```

---

## 📋 Premissas & Regras de Negócio

* **Curso:** Possui código, nome e turno. Contém uma lista de 1 ou mais disciplinas associadas.
* **Disciplina:** Possui código, nome e carga horária. Pertence obrigatoriamente a um **Curso**.
* **Aluno:** Possui matrícula, nome e idade. Pertence obrigatoriamente a um **Curso**.
  * *Consulta de Aluno:* Ao consultar os dados do aluno, o sistema exibe o seu curso e todas as disciplinas vinculadas a ele.
* **Persistência:** Utilização do padrão DAO com **Banco de Dados** e **Listas em memória (`List`)** para manipulação dos objetos.

---

## ⚙️ Funcionalidades e Estrutura de Menus

### Menu Principal
1. Gerenciar ALUNOS
2. Gerenciar DISCIPLINAS
3. Gerenciar CURSOS
4. SAIR

### Submenus (Alunos, Disciplinas e Cursos)
1. Cadastrar
2. Consultar
3. Remover
4. Atualizar
5. Voltar ao MENU INICIAL

---

## 👥 Divisão de Tarefas do Grupo

| Integrante | Papel | Responsabilidades Principais |
| :--- | :--- | :--- |
| **Integrante 1** | *Banco de Dados & DAO* | Criação do script SQL, classe de conexão JDBC e classes DAO (`AlunoDAO`, `CursoDAO`, `DisciplinaDAO`). |
| **Integrante 2** | *Model & UML* | Atividade 1 (Diagrama de Classes UML), implementação das classes `Model` (`Aluno`, `Curso`, `Disciplina`) e relacionamentos. |
| **Integrante 3** | *Controllers* | Regras de negócio (`AlunoController`, `CursoController`, `DisciplinaController`), validações e gestão de listas. |
| **Integrante 4** | *View & CLI* | Estrutura de menus/submenus (`Main`, `Menu`), navegação, leituras via `Scanner` e tratamento de exceções na tela. |

---

## 🛠️ Como Executar o Projeto

1. **Clonar o repositório:**
   ```bash
   git clone https://github.com/ananarcisio/Trabalho-POO.git
   ```
2. **Configurar o Banco de Dados:**
   * Importar e rodar o script SQL disponível em `src/dao/script.sql` no seu SGBD (MySQL (gerenciado via phpMyAdmin / MySQLAdmin)).
   * Atualizar as credenciais (usuário e senha) no arquivo `ConexaoBanco.java`.
3. **Executar a aplicação:**
   * Abrir o projeto em sua IDE (IntelliJ, Eclipse ou VS Code).
   * Executar a classe principal `src/view/Main.java`.

---

## 🎓 Conceitos de POO Aplicados

Para a etapa de apresentação e arguição com o professor, a equipe dominará os seguintes conceitos:
* **Encapsulamento:** Uso de modificadores de acesso e encapsulamento com Getters/Setters.
* **Abstração:** Modelagem do mundo real para classes Java.
* **Associação e Composição:** Relacionamento entre `Aluno ➔ Curso ➔ Disciplina`.
* **Padrão DAO (Data Access Object):** Separação entre a camada de apresentação/negócio e a camada de acesso aos dados.
