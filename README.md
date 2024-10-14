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


