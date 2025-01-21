# 🏢 Sistema de Reserva de Salas

O **Sistema de Reserva de Salas** é uma API simples e eficiente para gerenciar a reserva de espaços como salas de reunião, coworking, e outros ambientes. Essa API permite o cadastro de usuários e salas, além de gerenciar reservas de forma prática e calcular o valor total com base no preço da sala e no tempo de uso. 🚀

## Funcionalidades 🌟

1. **Cadastro de Usuários** 👤  
   Os usuários podem se cadastrar no sistema, criando uma conta com suas informações pessoais para poderem realizar reservas de salas.

2. **Cadastro de Salas** 🏫  
   Salas podem ser cadastradas com informações como nome, capacidade, disponibilidade, e preço por hora. Isso permite que os administradores configurem as opções de reserva.

3. **Realização de Reservas** 📅  
   Os usuários autenticados podem reservar salas disponíveis.

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

![Modelagem do banco de dados](https://github.com/user-attachments/assets/41e7632e-f4bd-4823-8457-442be54dbc1d)


---

# Documentação para Executar o Banco de Dados e a API com Docker

## Pré-requisitos

Certifique-se de que você tem o Docker e o Docker Compose instalados em sua máquina. Se não estiverem instalados, você pode seguir as instruções de instalação:

- [Instalar Docker](https://docs.docker.com/get-docker/)
- [Instalar Docker Compose](https://docs.docker.com/compose/install/)

---

## 1. Subindo o Banco de Dados

O primeiro passo é subir o banco de dados usando o **Docker Compose**. Certifique-se de que você possui um arquivo `docker-compose.yml` configurado corretamente para o banco de dados.

### Passos:

1. Navegue até o diretório onde seu arquivo `docker-compose.yml` está localizado.
   
2. Execute o seguinte comando para subir o banco de dados em segundo plano:

   ```bash
   docker-compose up -d
   ```

   O `-d` significa "detached", que permite rodar o serviço em segundo plano.

3. Verifique se o banco de dados está rodando corretamente com o comando:

   ```bash
   docker ps
   ```

   Esse comando exibirá todos os contêineres ativos. O banco de dados deve estar listado aqui.

---

## 2. Build da Imagem da API

Agora, você deve buildar a imagem Docker da API. Certifique-se de que você tem um `Dockerfile` configurado corretamente no diretório raiz do seu projeto.

### Passos:

1. Navegue até o diretório onde o arquivo `Dockerfile` da sua API está localizado.

2. Execute o seguinte comando para construir a imagem Docker:

   ```bash
   docker build -t api .
   ```

   O `-t api` define o nome da imagem como `api`, e o `.` especifica que o contexto do build é o diretório atual.

---

## 3. Rodando a API

Após o build da imagem, você pode rodar o contêiner da API usando o Docker. Certifique-se de que o banco de dados já está rodando antes de subir a API.

### Passos:

1. Execute o seguinte comando para rodar a API:

   ```bash
   docker run -dti -p 8080:8080 api
   ```

   Aqui:
   - `-dti` significa que o contêiner será rodado em modo **detached** (`-d`), com terminal interativo (`-ti`).
   - `-p 8080:8080` mapeia a porta `8080` do contêiner para a porta `8080` da sua máquina local.
   - `api` é o nome da imagem que você buildou no passo anterior.

2. Verifique se o contêiner da API está rodando com o comando:

   ```bash
   docker ps
   ```

   O contêiner da API deve estar listado aqui, com a porta `8080` mapeada.

---

## 4. Acessando a API

Com a API rodando, você pode acessá-la via navegador ou uma ferramenta de requisições como o **Postman**. O endpoint da API estará disponível em:

```
http://localhost:8080
```

---

Pronto! Agora você tem sua API e banco de dados rodando via Docker.

## [Link Swagger para teste da api](http://localhost:8080/swagger-ui/index.html#/)

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

**POST /user**  
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

## Endpoints cadastro de reserva

### 1. Criar uma reserva

**POST /reservation/**  
Cadastra uma nova reserva de sala.

#### Request Body

```json
{
    "roomId": "db3b8a21-3820-4862-872f-392a16c1d768",
    "userId": "29a03082-796b-47ee-b8d5-241f33c913b7",
    "startTime": "03/12/2007 10:15:30",
    "endTime": "03/12/2008 10:15:30"
}
```

#### Response (201 - Created)

```json
{
    "id": "2a262e45-d439-496b-ad13-8101c80ab99b",
    "room": {
        "id": "db3b8a21-3820-4862-872f-392a16c1d768",
        "name": "Lab01",
        "roomNumber": "A1F3",
        "location": "Predio 10",
        "capacity": 40,
        "price": 20.00,
        "status": "RESERVADO"
    },
    "user": {
        "id": "29a03082-796b-47ee-b8d5-241f33c913b7",
        "name": "Fulano",
        "lastName": "De tal",
        "username": "fulanodetal"
    },
    "startTime": "03/12/2007 10:15:30",
    "endTime": "03/12/2008 10:15:30",
    "status": "RESERVADO",
    "totalCost": 175680.00
}
```

### 2. Listar todas as reservas (paginado)

**GET /reservation?page={page}&size={size}**  
Retorna uma lista paginada de reservas.

#### Parâmetros de Query
- `page`: Número da página (ex: `0`)
- `size`: Tamanho da página (ex: `10`)

#### Response (200 - OK)

```json
{
    "content": [
        {
            "id": "2a262e45-d439-496b-ad13-8101c80ab99b",
            "room": {
                "id": "db3b8a21-3820-4862-872f-392a16c1d768",
                "name": "Lab01",
                "roomNumber": "A1F3",
                "location": "Predio 10",
                "capacity": 40,
                "price": 20.00,
                "status": "RESERVADO"
            },
            "user": {
                "id": "29a03082-796b-47ee-b8d5-241f33c913b7",
                "name": "Fulano",
                "lastName": "De tal",
                "username": "fulanodetal"
            },
            "startTime": "03/12/2007 10:15:30",
            "endTime": "03/12/2008 10:15:30",
            "status": "RESERVADO",
            "totalCost": 175680.00
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
    "totalElements": 1,
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
    "numberOfElements": 1,
    "empty": false
}
```

### 3. Obter detalhes de uma reserva por ID

**GET /reservation/{id}**  
Retorna os detalhes de uma reserva específica pelo `id`.

#### Response (200 - OK)

```json
{
    "id": "2a262e45-d439-496b-ad13-8101c80ab99b",
    "room": {
        "id": "db3b8a21-3820-4862-872f-392a16c1d768",
        "name": "Lab01",
        "roomNumber": "A1F3",
        "location": "Predio 10",
        "capacity": 40,
        "price": 20.00,
        "status": "RESERVADO"
    },
    "user": {
        "id": "29a03082-796b-47ee-b8d5-241f33c913b7",
        "name": "Fulano",
        "lastName": "De tal",
        "username": "fulanodetal"
    },
    "startTime": "03/12/2007 10:15:30",
    "endTime": "03/12/2008 10:15:30",
    "status": "RESERVADO",
    "totalCost": 175680.00
}
```

### 4. Atualizar uma reserva

**PUT /reservation/{id}**  
Atualiza os dados de uma reserva específica pelo `id`.

#### Request Body

```json
{
    "roomId": "db3b8a21-3820-4862-872f-392a16c1d768",
    "userId": "29a03082-796b-47ee-b8d5-241f33c913b7",
    "startTime": "03/12/2007 10:15:30",
    "endTime": "03/12/2008 10:15:30"
}
```

#### Response (200 - OK)

```json
{
    "id": "2a262e45-d439-496b-ad13-8101c80ab99b",
    "room": {
        "id": "db3b8a21-3820-4862-872f-392a16c1d768",
        "name": "Lab01",
        "roomNumber": "A1F3",
        "location": "Predio 10",
        "capacity": 40,
        "price": 20.00,
        "status": "RESERVADO"
    },
    "user": {
        "id": "29a03082-796b-47ee-b8d5-241f33c913b7",
        "name": "Fulano",
        "lastName": "De tal",
        "username": "fulanodetal"
    },
    "startTime": "03/12/2007 10:15:30",
    "endTime": "03/12/2008 10:15:30",
    "status": "RESERVADO",
    "totalCost": 175680.00
}
```

### 5. Deletar uma reserva

**DELETE /reservation/{id}**  
Remove uma reserva específica pelo `id`.

#### Response (200 - OK)

```json
{
    "id": "2a262e45-d439-496b-ad13-8101c80ab99b",
    "room": {
        "id": "db3b8a21-3820-4862-872f-392a16c1d768",
        "name": "Lab01",
        "roomNumber": "A1F3",
        "location": "Predio 10",
        "capacity": 40,
        "price": 20.00,
        "status": "RESERVADO"
    },
    "user": {
        "id": "29a03082-796b-47ee-b8d5-241f33c913b7",
        "name": "Fulano",
        "lastName": "De tal",
        "username": "fulanodetal"
    },
    "startTime": "03/12/2007 10:15:30",
    "endTime": "03/12/2008 10:15:30",
    "status": "RESERVADO",
    "totalCost": 175680.00
}
```
