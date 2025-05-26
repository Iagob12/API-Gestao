# 🎉📅 Api - Gestão de Eventos Simplificada 🚀👥

> *Organize, divulgue e gerencie eventos com facilidade e controle total!*

---

## 📌 Sobre o Projeto

É uma API **RESTful** desenvolvida com **Java** + **Spring Boot**, focada na criação e gerenciamento de eventos e participantes. Com ela, é possível **criar** eventos, **gerenciar** inscrições, **controlar** vagas disponíveis e **acompanhar** participantes de forma eficiente. A solução perfeita para empresas, organizações e grupos que precisam de uma gestão ágil e confiável de **eventos**!

---

## 🚀 Funcionalidades Chave

### Eventos
* **Criar Evento**: Defina nome, descrição, data, local e o número de vagas.
* **Listar Eventos**: Visualize todos os eventos disponíveis.
* **Atualizar Evento**: Edite os detalhes de eventos existentes.
* **Excluir Evento**: Remova eventos da sua lista.

### Participantes
* **Cadastrar Participante**: Registre novos participantes com nome, e-mail e telefone.
* **Inscrever em Evento**: Permita a inscrição em eventos, com **verificação automática de vagas**.
* **Cancelar Inscrição**: Cancele a participação de um inscrito em um evento.
* **Listar Participantes de Evento**: Veja quem está inscrito em cada evento.

### Relacionamentos
* Um evento pode ter **vários participantes**.
* Um participante pode se inscrever em **vários eventos**.

---

## ⚙️ Tecnologias Utilizadas

Este projeto foi construído utilizando as seguintes tecnologias e boas práticas:

* **Linguagem de Programação**: **Java**
* **Framework**: **Spring Boot**
* **Banco de Dados**: **MySQL**
* **Controle de Versão**: **Git & GitHub**
* **Documentação da API**: **Swagger**
* **Testes de API**: **Postman**

---

## 💻 Estrutura e Divisão de Tarefas

O desenvolvimento deste projeto foi colaborativo e seguiu uma organização clara:

* **Felipe**:
    * Configuração inicial do projeto.
    * Criação das entidades `Evento` e `Participante`.
    * Definição e implementação dos relacionamentos (ManyToMany ou com tabela intermediária).
* **Arthur**:
    * Implementação das camadas de `Repository`, `DTO` e `Service` para as entidades.
    * Desenvolvimento da **lógica de inscrição com limite de vagas**.
* **Ruan**:
    * Criação dos `Controllers` e seus respectivos *endpoints* RESTful.
    * Realização de testes completos da API utilizando **Postman**.
* **Iago**:
    * Organização e manutenção do repositório GitHub.
    * Criação deste `README.md` detalhado.
    * Acompanhamento de *commits* e coordenação da divisão das tarefas.
    * Integração e configuração do **Swagger** para documentação da API.

---

## 🚀 Como Executar o Projeto Localmente

1. Clone o repositório:
   ```bash
   git clone https://github.com/Iagob12/API-Gestao.git
   cd nome-do-repositorio
   ```

2. Configure o `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/GestaoEvento
   spring.datasource.username=(nome do banco)
   spring.datasource.password=(senha do banco)
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Rode o servidor:
   ```bash
   ./mvnw spring-boot:run
   ```

A API estará disponível em: `http://localhost:8080`

---

# 👨‍💻 Colaboradores

Este projeto foi desenvolvido com a valiosa contribuição de:

* **Iago Bondesan**: (https://github.com/Iagob12)
* **Arthur Cena**: (https://github.com/ASsena)
* **Felipe Araújo**: (https://github.com/fearaujo293)
* **Ruan Rodrigues**: (https://github.com/ruanzinDoCorte)
