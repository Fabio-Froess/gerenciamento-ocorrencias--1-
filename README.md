# Gerenciamento de Ocorrências de Trânsito 

Este é o backend do sistema simplificado de gerenciamento de ocorrências de trânsito. Ele fornece uma API REST para gerenciar as funcionalidades de criação, visualização, comentário e exclusão de ocorrências.

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java 17+
- **Framework:** Spring Boot 3
- **Banco de Dados:** PostgreSQL
- **Build Tool:** Maven

## 🚀 Funcionalidades

1. **Visualizar Ocorrências:** Qualquer pessoa pode visualizar todas as ocorrências, incluindo detalhes e comentários.
2. **Gerenciamento de Ocorrências:** Usuários autenticados podem:
   - Criar novas ocorrências.
   - Excluir ocorrências criadas por eles.
   - Comentar em ocorrências.
3. **Dashboard:** Exibe o número de ocorrências por tipo nos últimos 30 dias.
4. **Filtros de Pesquisa:** Permite buscar ocorrências por tipo, data, localização ou palavra-chave.

## ⚙️ Configuração do Ambiente

### Pré-requisitos

- [Java 17+](https://www.oracle.com/java/technologies/javase-downloads.html)
- [PostgreSQL](https://www.postgresql.org/)
- [Maven](https://maven.apache.org/)

### Configuração do Banco de Dados

1. Crie um banco de dados PostgreSQL com o nome `gerenciamento_ocorrencias`.
2. Atualize o arquivo `src/main/resources/application.properties` com as credenciais do banco:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/gerenciamento_ocorrencias
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update
Executando o Backend
Navegue até o diretório raiz do backend.

Compile e execute o projeto com os comandos abaixo:

bash
Copiar código
./mvnw clean package
./mvnw spring-boot:run
