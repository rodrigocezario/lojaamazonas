# Loja Amazonas

## Apresentação do projeto
Este projeto foi desenvolvido juntos aos alunos do cursos de Sistemas de Informação na disciplina de Programação III com o objetivo de praticas os conceitos estudados nas seguintes tecnologias da plataforma Java EE.
- JavaServer Pages (JSP)
- JavaServer Pages Standard Tag Library (JSTL)
- Expression Language (EL)
- Web Services RESTful
Por se tratar de um projeto desenvolvido para praticar os conceitos anteriormente apresentados, algumas práticas adequadas ao desenvolvimento profissional não foram incorporada ao projeto para não desviar do foco principal da aprendizagem, como as limitações descritas a seguir: 

## Limitações
Muitas das práticas realizadas podem ser consideradas como não adequada para o desenvolvimento profissional da plataforma, a citar: uso de ferramenta para automação e gestão de dependências (não utilizamos o Maven ou Ant); injeção de dependência (dependency injection); JavaServer Faces (JSF); Java Persistence API (JPA); e/ou uso de framework MVC. A maioria desses assuntos são tratados em momentos oportunos ao longo da disciplina.

## O Projeto
### Modelo de classes
O desenvolvimento do projeto considerou o seguinte modelo de classe:
![Modelo de classes do projeto](rlojaamazonas/documentos/classes.png?raw=true "Modelo de classes do projeto")
A primeira esta de desenvolvimento do projeto foram implementadas as classes necessárias para exibição dos produtos. A implementação das classes necessárias para a realização do fechamento de pedidos serão implementadas na segunda etapa do projeto (ainda não implementada).

### Modelo de Dados
Além do modelo de classes, utilizou-se o MER (Modelo Entidade Relacionamento) para representação conceitual para descrever as tabelas (entidades) para nosso modelo de negócio. A figura a seguir apresenta o modelo de dados utilizado neste projeto.
![Modelo Entidade Relacionamento](rlojaamazonas/documentos/mer.png?raw=true "Modelo Entidade Relacionamento")

### Arquivos de Dados
Além do modelo de dados o projeto conta com o arquivo de dados em SQLite e o Script para criação em MySQL. É sabido que SQLite é de longe a escolha adequada para o desenvolvimento de projeto web. No entanto, como se trata do desenvolvimento de um projeto de cunho acadêmico, a utilizando do SQLite é interessante pois não obriga a instalação de mais softwares no equipamento, pois se trata de uma biblioteca que implementa um banco de dados SQL embutido. O código implementado em sua utilização em nada difere (no caso deste projeto) da implementação utilizando quando optado em utilizar um gerenciador de banco de dados como MySQL ou Oracle. Você pode fazer o download do arquivo de dados [aqui](lojaamazonas/loja.db)

O script para criação da base de dados em MySQL pode ser obtivido [aqui](lojaamazonas/documentos/loja.sql). No entanto, esta versão ainda carece de revisão, pois ainda não foi alterado os tipo de campo de preço para DECIMAL como apresentado no MER. Tanto o script como o arquivo de dados em SQLite já estão populados com dados.

### Layout do projeto
Por questões relacionadas a copyright não será disponibilizado neste repositório os projetos de layout.
Foram utilizados para o desenvolvimento das interfaces (front-end) as seguintes tecnologias e/ou frameworks:
- Bootstrap 4
- JQuery
- fancyBox
- Font Awesome

## Observações
Em breve irei disponibilizar o passo-a-passo do desenvolvimento do projeto.

## Contribuições
Todos são bem-vindos a contribuir com este projeto. Sinta-se a vontade em enviar suas sugestões e críticas para o e-mail [rodrigocezario@msn.com](rodrigocezario@msn.com). :)
