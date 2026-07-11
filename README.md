# 📔 API Agenda de Contatos

API REST criada para treinar e aplicar boas práticas de desenvolvimento com Java moderno e Spring Boot. 

O foco principal do projeto foi usar padrões de mercado, separando as responsabilidades do código em camadas e protegendo o banco de dados.

## 🚀 Tecnologias
- Java 17 / 21 (usando Records para DTOs)
- Spring Boot 3
- Spring Data JPA
- Banco H2 (em memória)
- Lombok
- Bean Validation (validação de e-mail, campos obrigatórios, etc.)
- Tratamento de Erros Global: Uso de `@RestControllerAdvice` e `@ExceptionHandler` para capturar exceções da aplicação e devolver JSONs padronizados com os status HTTP corretos.

## 🛠️ O que foi aplicado (Padrão Mercado)
- **Camadas bem definidas:** Controller, Service, Repository e Model.
- **Isolamento com DTOs:** Uso de `RequestDTO` para validar a entrada de dados e `ResponseDTO` para customizar o retorno com o ID do banco.
- **Tratamento seguro:** Busca por ID feita com `Optional` e `.orElseThrow()`.
- **Transações seguras:** Métodos de escrita protegidos com `@Transactional` e buscas otimizadas com `readOnly = true`.

## 🛣️ Endpoints (Rotas)
- `POST /api/contatos` - Cadastra um contato (valida e-mail e nome).
- `GET /api/contatos` - Lista todos os contatos (usando Java Streams).
- `GET /api/contatos/{id}` - Busca contato específico por ID.
- `PUT /api/contatos/{id}` - Atualiza um contato existente de forma segura.
- `DELETE /api/contatos/{id}` - Deleta um contato (retorna status 204 No Content).

### Exemplo de JSON para Cadastro:
```json
{
  "nome": "Douglas",
  "email": "teste@email.com",
  "telefone": "11999999999",
  "dataNascimento": "2000-01-01"
}
```

## 💻 Como rodar
1. Clone o repositório: `git clone https://github.com`
2. Abra na sua IDE e espere o Maven baixar as dependências.
3. Rode o projeto através da classe `ApiAgendaApplication.java`.
4. O console do banco H2 fica disponível em `http://localhost:8080/h2-console`.
