# 🏢 Sistema de Reserva de Salas

O **Sistema de Reserva de Salas** é uma API simples e eficiente para gerenciar a reserva de espaços como salas de reunião, coworking, e outros ambientes. Essa API permite o cadastro de usuários e salas, além de gerenciar reservas de forma prática e calcular o valor total com base no preço da sala e no tempo de uso. 🚀

## Funcionalidades 🌟

1. **Cadastro de Usuários** 👤  
   Os usuários podem se cadastrar no sistema, criando uma conta com suas informações pessoais para poderem realizar reservas de salas.

2. **Cadastro de Salas** 🏫  
   Salas podem ser cadastradas com informações como nome, capacidade, disponibilidade, e preço por hora. Isso permite que os administradores configurem as opções de reserva.

3. **Realização de Reservas** 📅  
   Os usuários autenticados podem reservar salas disponíveis em um determinado período. O sistema verifica a disponibilidade e confirma a reserva.

4. **Cálculo do Valor da Reserva** 💰  
   Com base no tempo de uso da sala (duração da reserva) e o preço por hora definido, o sistema calcula automaticamente o valor total que o usuário precisa pagar pela reserva.

## Exemplo de Fluxo de Uso 🚦

1. **Cadastro de Usuário**: O usuário acessa a API e cria uma conta.
2. **Cadastro de Sala**: Um administrador cadastra as salas disponíveis, definindo o preço por hora.
3. **Reserva de Sala**: O usuário escolhe uma sala e faz uma reserva para o horário desejado.
4. **Cálculo do Valor**: O sistema calcula o valor da reserva com base no tempo de uso e o preço da sala.

## Benefícios 🎯

- **Praticidade**: Gerenciamento simples de salas e reservas.
- **Cálculo Automático**: O valor total da reserva é calculado automaticamente com base no preço da sala e no tempo de uso.
- **Controle de Disponibilidade**: O sistema garante que as salas só sejam reservadas se estiverem disponíveis no período solicitado.

## Tecnologias Utilizadas 💻

- **Spring Boot**: Framework principal para a construção da API.
- **Banco de Dados Relacional**: Para armazenar informações de usuários, salas, e reservas.
- **JWT (JSON Web Token)**: Para autenticação de usuários.

---

⚙️ O **Sistema de Reserva de Salas** é uma solução escalável e de fácil integração com outros sistemas, ideal para empresas ou coworkings que desejam oferecer uma plataforma de reserva automatizada e eficiente.


# Modelagem do banco de dados

![image](https://github.com/user-attachments/assets/0c08e065-aea8-4051-b8bc-92d1d2e3579f)

## Endpoints cadastro de salas

### 1. Criar uma sala

**POST /room/**  
Cria uma nova sala no sistema.

#### Request Body

```json
{
    "name": "Lab01",
    "roomNumber": "A1F3",
    "location": "Predio 10",
    "capacity": 40,
    "price": 20,
    "status": "DISPONIVEL"
}
```

#### Response (201 - Created)

```json
{
    "id": "db3b8a21-3820-4862-872f-392a16c1d768",
    "name": "Lab01",
    "roomNumber": "A1F3",
    "location": "Predio 10",
    "capacity": 40,
    "price": 20,
    "status": "DISPONIVEL"
}
```

### 2. Listar todas as salas (paginado)

**GET /room?page={page}&size={size}&search={search}**  
Retorna uma lista paginada de todas as salas, com suporte a busca pelo nome.

#### Parâmetros de Query
- `page`: Número da página (ex: `0`)
- `size`: Tamanho da página (ex: `10`)
- `search`: Filtro opcional para buscar salas pelo nome (ex: `lab01`)

#### Response (200 - OK)

```json
{
    "content": [
        {
            "id": "db3b8a21-3820-4862-872f-392a16c1d768",
            "name": "Lab01",
            "roomNumber": "A1F3",
            "location": "Predio 10",
            "capacity": 40,
            "price": 20.00,
            "status": "DISPONIVEL"
        },
        {
            "id": "00f85a49-7ea9-4da3-9ace-434db7c27126",
            "name": "Lab01",
            "roomNumber": "A1F3",
            "location": "Predio 10",
            "capacity": 40,
            "price": 20.00,
            "status": "DISPONIVEL"
        }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 10,
        "sort": {
            "sorted": false,
            "unsorted": true,
            "empty": true
        },
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "totalElements": 2,
    "totalPages": 1,
    "last": true,
    "first": true,
    "size": 10,
    "number": 0,
    "sort": {
        "sorted": false,
        "unsorted": true,
        "empty": true
    },
    "numberOfElements": 2,
    "empty": false
}
```

### 3. Obter detalhes de uma sala por ID

**GET /room/{id}**  
Retorna os detalhes de uma sala específica pelo `id`.

#### Response (200 - OK)

```json
{
    "id": "db3b8a21-3820-4862-872f-392a16c1d768",
    "name": "Lab01",
    "roomNumber": "A1F3",
    "location": "Predio 10",
    "capacity": 40,
    "price": 20,
    "status": "DISPONIVEL"
}
```

### 4. Atualizar uma sala

**PUT /room/{id}**  
Atualiza os dados de uma sala específica pelo `id`.

#### Request Body

```json
{
    "name": "Lab01",
    "roomNumber": "A1F3",
    "location": "Predio 10",
    "capacity": 40,
    "price": 20,
    "status": "DISPONIVEL"
}
```

#### Response (200 - OK)

```json
{
    "id": "db3b8a21-3820-4862-872f-392a16c1d768",
    "name": "Lab01",
    "roomNumber": "A1F3",
    "location": "Predio 10",
    "capacity": 40,
    "price": 20,
    "status": "DISPONIVEL"
}
```

### 5. Deletar uma sala

**DELETE /room/{id}**  
Remove uma sala específica pelo `id`.

#### Response (200 - OK)

```json
{
    "id": "db3b8a21-3820-4862-872f-392a16c1d768",
    "name": "Lab01",
    "roomNumber": "A1F3",
    "location": "Predio 10",
    "capacity": 40,
    "price": 20,
    "status": "DISPONIVEL"
}
```

## Endpoints cadastro de usuário

### 1. Criar um usuário

**POST /user/**  
Cadastra um novo usuário no sistema.

#### Request Body

```json
{
    "name": "Fulano",
    "lastName": "De tal",
    "username": "fulanodetal",
    "password": "Senha12345",
    "role": "CUSTOMER"
}
```

#### Response (201 - Created)

```json
{
    "id": "29a03082-796b-47ee-b8d5-241f33c913b7",
    "name": "Fulano",
    "lastName": "De tal",
    "username": "fulanodetal"
}
```

### 2. Listar todos os usuários (paginado)

**GET /user?page={page}&size={size}&search={search}**  
Retorna uma lista paginada de usuários, com suporte a busca por nome ou username.

#### Parâmetros de Query
- `page`: Número da página (ex: `0`)
- `size`: Tamanho da página (ex: `10`)
- `search`: Filtro opcional para buscar usuários pelo nome ou username (ex: `fulanodetal`)

#### Response (200 - OK)

```json
{
    "content": [
        {
            "id": "29a03082-796b-47ee-b8d5-241f33c913b7",
            "name": "Fulano",
            "lastName": "De tal",
            "username": "fulanodetal"
        },
        {
            "id": "dc5af7d0-38af-458f-9850-d82a330c4a8d",
            "name": "admin",
            "lastName": "admin",
            "username": "admin"
        }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 10,
        "sort": {
            "sorted": false,
            "unsorted": true,
            "empty": true
        },
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "totalElements": 2,
    "totalPages": 1,
    "last": true,
    "first": true,
    "size": 10,
    "number": 0,
    "sort": {
        "sorted": false,
        "unsorted": true,
        "empty": true
    },
    "numberOfElements": 2,
    "empty": false
}
```

### 3. Obter detalhes de um usuário por ID

**GET /user/{id}**  
Retorna os detalhes de um usuário específico pelo `id`.

#### Response (200 - OK)

```json
{
    "id": "29a03082-796b-47ee-b8d5-241f33c913b7",
    "name": "Fulano",
    "lastName": "De tal",
    "username": "fulanodetal"
}
```

### 4. Atualizar um usuário

**PUT /user/{id}**  
Atualiza os dados de um usuário específico pelo `id`.

#### Request Body

```json
{
    "name": "Fulano",
    "lastName": "De tal",
    "username": "fulanodetal",
    "password": "NovaSenha123",
    "role": "CUSTOMER"
}
```

#### Response (200 - OK)

```json
{
    "id": "29a03082-796b-47ee-b8d5-241f33c913b7",
    "name": "Fulano",
    "lastName": "De tal",
    "username": "fulanodetal"
}
```

### 5. Deletar um usuário

**DELETE /user/{id}**  
Remove um usuário específico pelo `id`.

#### Response (200 - OK)

```json
{
    "id": "29a03082-796b-47ee-b8d5-241f33c913b7",
    "name": "Fulano",
    "lastName": "De tal",
    "username": "fulanodetal"
}
```
## Endpoint paralogin

### 1. Realizar login

**POST /auth/login**  
Autentica um usuário com base no `username` e `password` fornecidos.

#### Request Body

```json
{
    "username": "admin",
    "password": "admin"
}
```

#### Response (200 - OK)

```json
{
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3....."
}
```

O token JWT retornado deve ser utilizado nos cabeçalhos das próximas requisições para acessar rotas protegidas da API, no formato:

```
Authorization: Bearer {token}
```
