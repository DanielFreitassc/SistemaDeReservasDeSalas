# **Spring Boot**
**Introdução ao Spring Boot**

O Spring Boot é um framework robusto e inovador para o desenvolvimento de aplicações Java que revoluciona a forma como as aplicações são construídas e configuradas. Criado com base no ecossistema do Spring Framework, o Spring Boot visa simplificar todo o processo de desenvolvimento, desde a configuração até a implementação, permitindo que os desenvolvedores foquem na lógica de negócios sem se preocupar com configurações detalhadas.

### **1. O que é o Spring Boot?**
O Spring Boot oferece uma abordagem "convenção sobre configuração", eliminando a necessidade de configurações extensas e permitindo que os desenvolvedores iniciem rapidamente. Ao integrar padrões de projeto e melhores práticas, o Spring Boot simplifica tarefas comuns, como o desenvolvimento de aplicações web, persistência de dados e implementação de microsserviços.

### **2. Benefícios do Spring Boot**
- **Produtividade Aprimorada:** Inicialização rápida de projetos com o Spring Initializr e redução da sobrecarga de configuração.
- **Configuração Conveniente:** Abordagem simplificada para configuração, utilizando anotações e arquivos de propriedades.
- **Ecossistema Poderoso:** Integração nativa com diversos projetos Spring e suporte a uma ampla gama de bibliotecas e frameworks.

### **3. Características Principais**
- **Embedded Containers:** Incorporação de servidores web como Tomcat e Jetty, eliminando a necessidade de configurações externas.
- **Starters:** Conjuntos de dependências pré-configuradas para facilitar o uso de tecnologias específicas.
- **Autoconfiguração:** Configurações automáticas baseadas nas dependências presentes no classpath, simplificando ainda mais o desenvolvimento.
- **Monitoramento e Gerenciamento:** Recursos integrados para monitorar e gerenciar aplicações em execução.

O Spring Boot não apenas acelera o desenvolvimento, mas também promove boas práticas, modularidade e escalabilidade.
# Configuração no Spring

A configuração no Spring é uma parte crucial para definir o comportamento e as relações entre os diferentes componentes de uma aplicação. O Spring oferece várias maneiras de configurar seus componentes, desde configurações baseadas em XML até configurações baseadas em anotações Java. A seguir, vamos explorar algumas abordagens comuns de configuração no Spring.

## Configuração por XML

No Spring, a configuração por XML é uma abordagem tradicional, onde as definições de beans e suas dependências são especificadas em um arquivo XML.

### Arquivo `applicationContext.xml`

```xml
<!-- Arquivo applicationContext.xml -->

<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Definição de Beans -->
    <bean id="minhaBean" class="com.example.MinhaClasse">
        <property name="propriedade1" value="Valor1"/>
    </bean>

    <!-- Outras definições de Beans e configurações -->
</beans>
```

### Uso do ApplicationContext

```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Aplicacao {

    public static void main(String[] args) {
        // Carrega o contexto do arquivo XML
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Obtém a instância do bean
        MinhaClasse minhaBean = (MinhaClasse) context.getBean("minhaBean");

        // Utiliza a instância do bean
        minhaBean.metodo();
    }
}
```

## Configuração por Anotações

O Spring também oferece uma abordagem baseada em anotações Java para configuração, o que muitas vezes é mais conciso e expressivo.

### Classe de Configuração

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuracao {

    @Bean
    public MinhaClasse minhaBean() {
        MinhaClasse minhaBean = new MinhaClasse();
        minhaBean.setPropriedade1("Valor1");
        return minhaBean;
    }

    // Outras definições de Beans e configurações
}
```

### Uso do ApplicationContext

```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Aplicacao {

    public static void main(String[] args) {
        // Carrega o contexto a partir de uma classe de configuração
        ApplicationContext context = new AnnotationConfigApplicationContext(Configuracao.class);

        // Obtém a instância do bean
        MinhaClasse minhaBean = context.getBean(MinhaClasse.class);

        // Utiliza a instância do bean
        minhaBean.metodo();
    }
}
```

## Benefícios da Configuração no Spring

1. **Flexibilidade:** As diferentes opções de configuração permitem que os desenvolvedores escolham a abordagem mais adequada para suas necessidades e preferências.

2. **Manutenibilidade:** A separação da configuração do código de negócios facilita a manutenção e a evolução da aplicação.

3. **Testabilidade:** A configuração via anotações muitas vezes simplifica a escrita de testes unitários, permitindo a configuração específica para os testes.

4. **Desacoplamento:** A configuração externa permite ajustar o comportamento da aplicação sem modificar o código-fonte.

O Spring fornece uma ampla variedade de opções para configuração, permitindo aos desenvolvedores escolher a abordagem que melhor se adapta às necessidades específicas de suas aplicações.

# Spring Core

O Spring Core é o componente fundamental do framework Spring, que fornece a infraestrutura básica para o desenvolvimento de aplicativos Java empresariais. Este módulo centraliza-se na inversão de controle (IoC) e na injeção de dependências (DI), conceitos-chave para criar aplicativos modularizados e de fácil manutenção.

# Inversão de Controle no Spring (IOC)

A Inversão de Controle (IoC) é um princípio de design de software em que a execução de um programa é invertida, e em vez de o programador controlar diretamente o fluxo do programa, o controle é passado para um framework ou contêiner. O Spring é um framework de IoC amplamente utilizado no desenvolvimento de aplicativos Java.

## Conceitos Básicos

### 1. **Contêiner Spring**
   O Contêiner Spring é a peça central do framework Spring e é responsável por gerenciar os objetos (beans) de uma aplicação. Ele controla a configuração, inicialização e destruição dos objetos.

### 2. **Bean**
   Um Bean é um objeto gerenciado pelo contêiner Spring. Esses objetos são criados, configurados e gerenciados pelo Spring IoC Container.

### 3. **ApplicationContext**
   O ApplicationContext é uma interface que estende o BeanFactory e fornece recursos adicionais, como suporte a eventos de aplicativo, internacionalização, entre outros.

## Implementando IoC com Spring

### 1. **Configuração por XML**

```xml
<!-- Arquivo applicationContext.xml -->

<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Definição de um Bean -->
    <bean id="minhaBean" class="com.example.MinhaClasse">
        <!-- Configuração de propriedades -->
        <property name="propriedade1" value="Valor1"/>
    </bean>

</beans>
```

### 2. **Configuração por Anotações**

```java
// Classe Java

import org.springframework.stereotype.Component;

@Component
public class MinhaClasse {
    private String propriedade1;

    // Métodos, construtores, etc.
}
```

### 3. **Uso do ApplicationContext**

```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Aplicacao {

    public static void main(String[] args) {
        // Carrega o contexto do arquivo XML
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Obtém a instância do bean
        MinhaClasse minhaBean = (MinhaClasse) context.getBean("minhaBean");

        // Utiliza a instância do bean
        minhaBean.metodo();
    }
}
```

## Benefícios da IoC no Spring

1. **Desacoplamento:** Reduz o acoplamento entre componentes, tornando o código mais modular e fácil de manter.
  
2. **Reusabilidade:** Os beans podem ser facilmente reutilizados em diferentes partes da aplicação.

3. **Testabilidade:** Facilita a realização de testes unitários, pois os objetos podem ser substituídos por mocks ou stubs.

4. **Configuração Externa:** Permite a configuração externa de objetos, facilitando a alteração de comportamentos sem a necessidade de modificar o código-fonte.

O Spring IoC oferece uma maneira poderosa e flexível de desenvolver aplicações Java, promovendo boas práticas de design e facilitando a manutenção do código.

# Injeção de Dependência no Spring

A Injeção de Dependência (DI) é um padrão de design em que as dependências de um objeto são injetadas por um componente externo, em vez de serem criadas dentro do próprio objeto. No contexto do Spring, a DI é amplamente utilizada para realizar a inversão de controle (IoC).

## Conceitos Básicos

### 1. **Dependência**
   Uma dependência é uma classe ou objeto do qual outro objeto depende para realizar suas operações.

### 2. **Injeção de Dependência**
   A Injeção de Dependência é o processo de fornecer as dependências necessárias a um objeto durante sua criação ou em tempo de execução.

### 3. **Tipos de Injeção de Dependência no Spring**
   - **Construtor:** As dependências são injetadas por meio do construtor da classe.
   - **Setter:** As dependências são injetadas por meio de métodos setter.
   - **Campo:** As dependências são injetadas diretamente em campos da classe.

## Implementando Injeção de Dependência com Spring

### 1. **Injeção via Construtor**

```java
// Classe que recebe a injeção de dependência via construtor
public class MinhaClasse {
    private OutraClasse outraClasse;

    public MinhaClasse(OutraClasse outraClasse) {
        this.outraClasse = outraClasse;
    }

    // Métodos, construtores, etc.
}
```

### 2. **Injeção via Setter**

```java
// Classe que recebe a injeção de dependência via setter
public class MinhaClasse {
    private OutraClasse outraClasse;

    public void setOutraClasse(OutraClasse outraClasse) {
        this.outraClasse = outraClasse;
    }

    // Métodos, construtores, etc.
}
```

### 3. **Injeção via Anotação em Campo**

```java
// Classe que recebe a injeção de dependência via anotação em campo
public class MinhaClasse {
    @Autowired
    private OutraClasse outraClasse;

    // Métodos, construtores, etc.
}
```

### 4. **Configuração no arquivo applicationContext.xml (XML Config)**

```xml
<!-- Arquivo applicationContext.xml -->

<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Definição de Beans -->
    <bean id="minhaBean" class="com.example.MinhaClasse">
        <!-- Injeção de Dependência via construtor -->
        <constructor-arg ref="outraClasse"/>
    </bean>

    <bean id="outraClasse" class="com.example.OutraClasse"/>
</beans>
```

### 5. **Uso do ApplicationContext**

```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Aplicacao {

    public static void main(String[] args) {
        // Carrega o contexto do arquivo XML
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Obtém a instância do bean
        MinhaClasse minhaBean = (MinhaClasse) context.getBean("minhaBean");

        // Utiliza a instância do bean
        minhaBean.metodo();
    }
}
```

## Benefícios da Injeção de Dependência

1. **Desacoplamento:** Reduz o acoplamento entre classes, facilitando a manutenção e extensão do código.
  
2. **Testabilidade:** Facilita a realização de testes unitários, pois as dependências podem ser facilmente substituídas por mocks ou stubs.

3. **Reusabilidade:** Os objetos podem ser reutilizados em diferentes contextos, pois as dependências podem ser alteradas externamente.

A Injeção de Dependência é uma prática fundamental no desenvolvimento de software moderno, e o Spring fornece um conjunto de recursos poderosos para implementá-la de maneira eficaz e eficiente.

# Aspect-Oriented Programming (AOP) no Spring

A Aspect-Oriented Programming (AOP) é uma abordagem de programação que permite separar preocupações transversais, como logging, tratamento de exceções, segurança, etc., do código principal de negócios. No Spring, o AOP é uma técnica poderosa que facilita a modularização de aspectos específicos da aplicação.

## Conceitos Básicos

### 1. **Aspecto (Aspect)**
   Um aspecto é um módulo que encapsula um comportamento que pode ser reutilizado em várias partes da aplicação. Ele consiste em conselhos e pontos de corte.

### 2. **Conselho (Advice)**
   Um conselho é um bloco de código que é executado em conjunto com a execução do programa. Existem diferentes tipos de conselhos, como "antes", "após" e "ao redor".

### 3. **Ponto de Corte (Pointcut)**
   Um ponto de corte define onde um conselho deve ser executado. Ele especifica os métodos ou locais no código onde o conselho deve ser aplicado.

## Implementando AOP no Spring

### 1. **Definindo um Aspecto**

```java
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MeuAspecto {

    @Before("execution(* com.example.MinhaClasse.*(..))")
    public void antesDaExecucao() {
        System.out.println("Antes da execução do método");
    }
}
```

### 2. **Configurando o Spring para Reconhecer Aspectos**

```xml
<!-- Arquivo applicationContext.xml -->

<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/aop
           http://www.springframework.org/schema/aop/spring-aop.xsd">

    <!-- Ativação do suporte a AOP -->
    <aop:aspectj-autoproxy/>

    <!-- Componente que contém o aspecto -->
    <bean id="meuAspecto" class="com.example.MeuAspecto"/>

    <!-- Configuração de outros beans e componentes -->
</beans>
```

### 3. **Uso do ApplicationContext**

```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Aplicacao {

    public static void main(String[] args) {
        // Carrega o contexto do arquivo XML
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Obtém a instância do bean
        MinhaClasse minhaBean = (MinhaClasse) context.getBean("minhaBean");

        // Chama o método
        minhaBean.metodo();
    }
}
```

### 4. **Classe de Negócios Afetada pelo Aspecto**

```java
public class MinhaClasse {

    public void metodo() {
        System.out.println("Executando o método principal");
    }
}
```

Neste exemplo, o conselho definido no aspecto será executado antes de cada chamada ao método `metodo` da classe `MinhaClasse`.

## Benefícios do AOP no Spring

1. **Desacoplamento:** Permite isolar preocupações transversais do código principal, facilitando a manutenção e a evolução do sistema.

2. **Reutilização:** Os aspectos podem ser reutilizados em diferentes partes da aplicação, proporcionando consistência e facilitando a manutenção.

3. **Legibilidade:** Melhora a legibilidade do código, pois as preocupações transversais são separadas do código de negócios.

4. **Configuração Centralizada:** A configuração de aspectos é centralizada, proporcionando maior controle sobre o comportamento da aplicação.

O AOP no Spring é uma ferramenta valiosa para modularizar e gerenciar preocupações transversais em uma aplicação, tornando-a mais modular e fácil de manter.

# Spring MVC (Model-View-Controller)

O Spring MVC é um framework para o desenvolvimento de aplicações web baseado no padrão de arquitetura Model-View-Controller (MVC). Ele fornece uma estrutura organizacional para construir aplicativos da web flexíveis e escaláveis.

## Conceitos Básicos

### 1. **Model (Modelo)**
   O modelo representa os dados e a lógica de negócios da aplicação. Ele é responsável por encapsular o estado da aplicação.

### 2. **View (Visualização)**
   A visualização é responsável por apresentar o modelo ao usuário. Ela exibe as informações e interage com o usuário por meio de formulários, páginas HTML, etc.

### 3. **Controller (Controlador)**
   O controlador manipula as solicitações do usuário, interage com o modelo e seleciona a visualização apropriada para renderizar. Ele atua como intermediário entre o modelo e a visualização.

### 4. **DispatcherServlet**
   O DispatcherServlet é um componente central que gerencia o ciclo de vida da solicitação HTTP e encaminha a solicitação para o controlador apropriado.

## Estrutura Básica de um Projeto Spring MVC

### 1. **Configuração do DispatcherServlet no arquivo web.xml**

```xml
<!-- web.xml -->

<web-app>
    <servlet>
        <servlet-name>dispatcher</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>/WEB-INF/spring-mvc.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>dispatcher</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
</web-app>
```

### 2. **Configuração do Spring MVC no arquivo spring-mvc.xml**

```xml
<!-- spring-mvc.xml -->

<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/mvc
           http://www.springframework.org/schema/mvc/spring-mvc.xsd">

    <!-- Configuração do componente escaneado -->
    <context:component-scan base-package="com.example.controller"/>

    <!-- Configuração do resolvedor de visualizações -->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/views/"/>
        <property name="suffix" value=".jsp"/>
    </bean>

    <!-- Habilita a configuração de anotações do Spring MVC -->
    <mvc:annotation-driven/>

</beans>
```

### 3. **Controlador (Controller)**

```java
// Exemplo de controlador
@Controller
@RequestMapping("/exemplo")
public class ExemploController {

    @GetMapping("/pagina")
    public String pagina(Model model) {
        model.addAttribute("mensagem", "Bem-vindo à página de exemplo!");
        return "pagina";
    }
}
```

### 4. **Arquivo de Visualização (pagina.jsp)**

```jsp
<!-- pagina.jsp -->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Página de Exemplo</title>
</head>
<body>
    <h1>${mensagem}</h1>
</body>
</html>
```

## Benefícios do Spring MVC

1. **Separação de Responsabilidades:** O padrão MVC facilita a organização do código, separando as responsabilidades de modelagem, visualização e controle.

2. **Extensibilidade:** O Spring MVC é altamente extensível, permitindo a integração com diferentes tecnologias e frameworks.

3. **Configuração Declarativa:** A configuração do Spring MVC pode ser feita de forma declarativa, facilitando a manutenção e evolução do projeto.

4. **Suporte a Anotações:** O Spring MVC oferece suporte a anotações, simplificando a configuração e tornando o código mais conciso.

O Spring MVC é amplamente utilizado na comunidade Java para o desenvolvimento de aplicações web robustas e escaláveis. Ele fornece uma arquitetura flexível e modular que facilita a criação de aplicativos web eficientes.

As anotações no contexto do Spring são marcadores que fornecem metadados adicionais sobre os elementos do código-fonte, como classes, métodos ou campos. Elas são usadas para configurar o comportamento do Spring Framework e simplificar o desenvolvimento. Abaixo estão algumas das anotações mais comuns no Spring.

### **1. `@Component`**

Anota uma classe como um componente gerenciado pelo Spring. Essa anotação permite que o Spring detecte automaticamente e registre a classe como um bean no contexto do aplicativo.

```java
@Component
public class MinhaClasse {
    // ...
}
```

### **2. `@Controller`**

Usada para marcar uma classe como um controlador no contexto do Spring MVC. Indica que a classe trata solicitações HTTP e é responsável por retornar a visualização apropriada.

```java
@Controller
public class MeuControlador {
    // ...
}
```

### **3. `@Service`**

Semelhante a `@Component`, essa anotação é usada para marcar uma classe como um serviço no contexto do Spring. Geralmente, é usada para indicar que a classe contém a lógica de negócios.

```java
@Service
public class MeuServico {
    // ...
}
```

### **4. `@Repository`**

Essa anotação é usada para marcar uma classe como um repositório no contexto do Spring. Indica que a classe é responsável por acessar e gerenciar dados persistentes.

```java
@Repository
public class MeuRepositorio {
    // ...
}
```

### **5. `@Autowired`**

Usada para injetar dependências automaticamente pelo Spring. Pode ser aplicada a construtores, métodos setter, campos ou até mesmo a parâmetros de métodos.

```java
@Service
public class ServicoA {

    private OutroServico outroServico;

    @Autowired
    public ServicoA(OutroServico outroServico) {
        this.outroServico = outroServico;
    }
}
```

### **6. `@RequestMapping`**

Usada no contexto do Spring MVC para mapear URLs a métodos específicos de um controlador. Especifica a URL que aciona o método e o método HTTP associado.

```java
@Controller
@RequestMapping("/exemplo")
public class ExemploController {

    @GetMapping("/pagina")
    public String pagina() {
        return "pagina";
    }
}
```

### **7. `@PathVariable`**

Usada para extrair valores de variáveis de modelo de caminho em URLs mapeadas. Permite que os valores do URI sejam passados como argumentos para métodos de controlador.

```java
@GetMapping("/usuario/{id}")
public String obterUsuarioPorId(@PathVariable Long id, Model model) {
    // Lógica para obter e processar o usuário com o ID fornecido
    return "paginaUsuario";
}
```

### **8. `@ResponseBody`**

Usada para indicar que o valor retornado por um método de controlador deve ser serializado diretamente na resposta HTTP, em vez de ser interpretado como uma visualização.

```java
@ResponseBody
@GetMapping("/api/usuario/{id}")
public Usuario obterUsuarioJson(@PathVariable Long id) {
    // Lógica para obter e retornar um usuário como JSON
    return usuarioService.obterUsuarioPorId(id);
}
```

### **9. `@Configuration`**

Usada para indicar que uma classe contém métodos de configuração para o contexto do Spring. Pode ser usada em conjunto com métodos anotados com `@Bean`.

```java
@Configuration
public class ConfiguracaoDoAplicativo {
    // Métodos de configuração e definição de beans
}
```

Essas são apenas algumas das muitas anotações disponíveis no Spring Framework. O uso adequado dessas anotações ajuda a simplificar o código, tornar a configuração mais declarativa e aproveitar os recursos do Spring de maneira eficaz.

No Spring, o escopo de um bean define a extensão da vida útil e o contexto de visibilidade desse bean em um aplicativo. O Spring Framework oferece vários escopos para beans, permitindo que os desenvolvedores controlem como e quando os objetos são criados e destruídos. Abaixo estão alguns dos escopos de bean mais comuns no Spring:

### **1. Singleton (Padrão):**

O escopo padrão. Um único bean é criado para cada contexto do Spring e é compartilhado por todos os componentes que o injetam. Se não for especificado um escopo, o Spring assume o escopo singleton.

```java
@Component
public class MinhaClasse {
    // ...
}
```

### **2. Prototype:**

Um novo bean é criado toda vez que é solicitado pelo contêiner Spring. Cada componente que o injeta obtém uma instância exclusiva do bean.

```java
@Component
@Scope("prototype")
public class MinhaClassePrototype {
    // ...
}
```

### **3. Request:**

Um novo bean é criado para cada solicitação HTTP. É relevante apenas em aplicativos da web usando o Spring MVC.

```java
@Component
@Scope("request")
public class MinhaClasseRequest {
    // ...
}
```

### **4. Session:**

Um novo bean é criado para cada sessão HTTP. Assim como o escopo de solicitação, é relevante principalmente em aplicativos da web.

```java
@Component
@Scope("session")
public class MinhaClasseSession {
    // ...
}
```

### **5. Global Session:**

Similar ao escopo de sessão, mas apenas para aplicativos de portlet. Um novo bean é criado para cada sessão de portlet.

```java
@Component
@Scope("globalSession")
public class MinhaClasseGlobalSession {
    // ...
}
```

### **6. Application:**

Um novo bean é criado para o ciclo de vida completo do aplicativo. Relevante principalmente em ambientes de portlet.

```java
@Component
@Scope("application")
public class MinhaClasseApplication {
    // ...
}
```

### **7. WebSocket:**

Um novo bean é criado para cada sessão WebSocket. Relevante em ambientes que suportam WebSocket.

```java
@Component
@Scope("websocket")
public class MinhaClasseWebSocket {
    // ...
}
```

### **8. Custom:**

Os desenvolvedores podem criar escopos personalizados implementando a interface `Scope` do Spring.

```java
@Component
@Scope("meuEscopoCustomizado")
public class MinhaClasseCustomScope {
    // ...
}
```

### **9. Thread:**

Um novo bean é criado para cada thread que solicita o bean. Cada thread obtém uma instância exclusiva do bean.

```java
@Component
@Scope("thread")
public class MinhaClasseThreadScope {
    // ...
}
```

O uso apropriado do escopo de bean é crucial para garantir que o ciclo de vida dos objetos seja gerenciado adequadamente, evitando problemas relacionados a concorrência e vazamento de recursos. A escolha do escopo depende dos requisitos específicos do aplicativo e do comportamento desejado para cada bean.

O Spring Security é um módulo do Spring Framework que oferece funcionalidades abrangentes de segurança para aplicações Java. Ele fornece uma estrutura poderosa e flexível para autenticação e autorização, proteção contra ataques de segurança, gerenciamento de sessões e muito mais. Abaixo estão os principais conceitos e recursos do Spring Security.

## Conceitos Básicos

### **1. Autenticação:**
Autenticação é o processo de verificar a identidade de um usuário. O Spring Security suporta vários mecanismos de autenticação, incluindo autenticação baseada em formulários, autenticação baseada em token (como JWT), autenticação baseada em certificado e outros.

### **2. Autorização:**
Autorização controla o acesso dos usuários a recursos específicos com base em suas identidades autenticadas. O Spring Security permite configurar regras de autorização usando anotações, expressões ou configuração baseada em código.

### **3. UserDetails e UserDetailsService:**
`UserDetails` é uma interface que representa os detalhes do usuário, como nome de usuário, senha e funções. `UserDetailsService` é uma interface que carrega os detalhes do usuário com base no nome de usuário.

### **4. GrantedAuthority:**
`GrantedAuthority` representa as permissões associadas a um `UserDetails`. Elas são usadas para verificar se um usuário tem acesso a uma determinada funcionalidade.

### **5. Filter Chain:**
O Spring Security usa uma cadeia de filtros (`Filter Chain`) para processar as solicitações HTTP. Cada filtro realiza uma tarefa específica, como autenticação, autorização, proteção contra CSRF, etc.

### **6. Principal e Authentication:**
`Principal` representa a identidade autenticada de um usuário. `Authentication` contém informações sobre a autenticação atual e, quando bem-sucedida, inclui o `Principal` e as `GrantedAuthorities`.

## Configuração Básica

### **1. Dependência Maven:**
Adicione a dependência do Spring Security ao seu arquivo `pom.xml`:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

### **2. Configuração Básica em Aplicações Spring Boot:**
Em uma aplicação Spring Boot, a configuração básica de segurança pode ser alcançada apenas com a inclusão da dependência. No entanto, você pode personalizar ainda mais a configuração, se necessário, criando uma classe que estenda `WebSecurityConfigurerAdapter`.

```java
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class ConfiguracaoSeguranca extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }
}
```

Este é um exemplo básico de configuração que permite acesso livre às páginas "/home" e "/" e exige autenticação para outras páginas. Além disso, ele configura uma página de login personalizada.

### **3. Configuração de Usuários em Memória:**
Você pode configurar usuários em memória para testes ou cenários simples. 

```java
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class ConfiguracaoSeguranca extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("usuario").password("{noop}senha").roles("USER")
                .and()
                .withUser("admin").password("{noop}senha").roles("USER", "ADMIN");
    }
}
```

Este exemplo configura dois usuários em memória: "usuario" com a senha "senha" e o papel "USER", e "admin" com a senha "senha" e os papéis "USER" e "ADMIN".

### **4. Anotações de Segurança em Controladores:**
Você pode usar anotações no nível de método ou classe para aplicar restrições de segurança aos seus controladores.

```java
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    @Secured("ROLE_USER")
    public String home() {
        return "home";
    }
}
```

Neste exemplo, o método `home()` só pode ser acessado por usuários com o papel "ROLE_USER".

Essas são apenas algumas das configurações básicas e conceitos do Spring Security. Dependendo dos requisitos específicos do seu aplicativo, você pode precisar configurar autenticação externa, configurar SSL, lidar com autorização baseada em expressões, entre outras funcionalidades avançadas que o Spring Security oferece.

OAuth 2.0 é um protocolo de autorização que permite que aplicativos acessem recursos em nome de um usuário. Ele é amplamente utilizado para autenticação e autorização em aplicativos web e serviços API. O Spring Security oferece suporte extensivo para OAuth 2.0 por meio do módulo Spring Security OAuth.

Abaixo, apresento uma visão geral de como configurar OAuth 2.0 usando o Spring Security. Esta é uma configuração básica e você pode precisar ajustá-la dependendo das necessidades específicas do seu aplicativo.

## Dependências Maven

Adicione as dependências necessárias ao seu arquivo `pom.xml`.

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-oauth2-client</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-oauth2-resource-server</artifactId>
</dependency>
```

## Configuração do Cliente OAuth 2.0 (OAuth 2.0 Client)

```java
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

@EnableWebSecurity
public class OAuth2LoginSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(authorizeRequests ->
                authorizeRequests
                    .antMatchers("/", "/login**", "/error**").permitAll()
                    .anyRequest().authenticated()
            )
            .oauth2Login()
                .userInfoEndpoint()
                    .oidcUserService(this.oidcUserService())
                    .and()
                .successHandler(this.savedRequestAwareAuthenticationSuccessHandler());
    }

    private OAuth2UserService<OAuth2UserRequest, OAuth2User> oidcUserService() {
        final OidcUserService delegate = new OidcUserService();
        return (userRequest) -> {
            // Delegate to the default implementation for loading a user
            OAuth2User oAuth2User = delegate.loadUser(userRequest);

            // Extract the ID token
            OidcIdToken idToken = OidcIdToken.class.cast(userRequest.getIdToken());

            // Create a copy of the default user
            Set<GrantedAuthority> mappedAuthorities = new HashSet<>();
            // Add custom claims from ID token claims
            oAuth2User.getAuthorities().addAll(mappedAuthorities);

            return new DefaultOidcUser(mappedAuthorities, idToken, oAuth2User);
        };
    }

    private AuthenticationSuccessHandler savedRequestAwareAuthenticationSuccessHandler() {
        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setTargetUrlParameter("targetUrl");
        return successHandler;
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(this.googleClientRegistration());
    }

    private ClientRegistration googleClientRegistration() {
        return ClientRegistration.withRegistrationId("google")
            .clientId("your-client-id")
            .clientSecret("your-client-secret")
            .redirectUriTemplate("{baseUrl}/login/oauth2/code/{registrationId}")
            .authorizationUri("https://accounts.google.com/o/oauth2/auth")
            .tokenUri("https://accounts.google.com/o/oauth2/token")
            .userInfoUri("https://www.googleapis.com/oauth2/v3/userinfo")
            .userNameAttributeName(IdTokenClaimNames.SUB)
            .jwkSetUri("https://www.googleapis.com/oauth2/v3/certs")
            .clientName("Google")
            .build();
    }
}
```

Certifique-se de substituir `"your-client-id"` e `"your-client-secret"` pelos valores fornecidos pelo provedor de OAuth (por exemplo, Google).

Este exemplo usa OAuth 2.0 para autenticação por meio do provedor Google. Você pode adaptar a configuração para outros provedores OAuth 2.0.

Esse é apenas um exemplo básico de como configurar o Spring Security com OAuth 2.0. A implementação real pode variar dependendo dos requisitos específicos do seu aplicativo e do provedor OAuth 2.0 que você está utilizando. Certifique-se de ajustar a configuração conforme necessário.

JSON Web Token (JWT) é um padrão aberto (RFC 7519) que define uma maneira compacta e autossuficiente para representar informações entre duas partes. Os tokens JWT são frequentemente usados para autenticação e autorização em aplicações web modernas. No contexto do Spring Security, você pode implementar a autenticação usando JWT para proteger seus recursos.

Aqui está um exemplo básico de como configurar a autenticação usando JWT no Spring Security:

## Dependências Maven

Adicione as dependências necessárias ao seu arquivo `pom.xml`.

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt</artifactId>
    <version>0.11.2</version>
</dependency>
```

## Configuração do Spring Security com JWT

```java
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Date;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${jwt.secret}")
    private String secret;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .addFilterBefore(new JwtTokenFilter(secret), UsernamePasswordAuthenticationFilter.class)
            .authorizeRequests()
                .antMatchers("/api/public").permitAll()
                .antMatchers("/api/private").authenticated();
    }

    @Bean
    public JwtTokenProvider jwtTokenProvider() {
        return new JwtTokenProvider(secret);
    }

    @WebFilter
    public class JwtTokenFilter implements javax.servlet.Filter {

        private final String secret;

        public JwtTokenFilter(String secret) {
            this.secret = secret;
        }

        @Override
        public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
                throws IOException, ServletException {
            try {
                Authentication authentication = getAuthentication((HttpServletRequest) req);
                SecurityContextHolder.getContext().setAuthentication(authentication);
                chain.doFilter(req, res);
            } catch (ExpiredJwtException e) {
                ((HttpServletResponse) res).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        }

        private Authentication getAuthentication(HttpServletRequest request) {
            String token = request.getHeader("Authorization");
            if (token != null && token.startsWith("Bearer ")) {
                String user = Jwts.parser()
                        .setSigningKey(secret)
                        .parseClaimsJws(token.replace("Bearer ", ""))
                        .getBody()
                        .getSubject();
                if (user != null) {
                    return new UsernamePasswordAuthenticationToken(user, null, emptyList());
                }
            }
            return null;
        }

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
            // Initialization code
        }

        @Override
        public void destroy() {
            // Cleanup code
        }
    }

    @RestController
    public class ApiController {

        @GetMapping("/api/public")
        public String publicEndpoint() {
            return "Public Content";
        }

        @GetMapping("/api/private")
        public String privateEndpoint() {
            return "Private Content";
        }
    }

    @RestController
    public class AuthController {

        @Autowired
        private JwtTokenProvider jwtTokenProvider;

        @PostMapping("/api/authenticate")
        public String generateToken(@RequestBody AuthRequest authRequest) {
            if (isValidUser(authRequest)) {
                return jwtTokenProvider.generateToken(authRequest.getUsername());
            } else {
                throw new UnauthorizedException("Invalid credentials");
            }
        }

        private boolean isValidUser(AuthRequest authRequest) {
            // Check if the user is valid (e.g., from a database)
            // Return true for demonstration purposes
            return true;
        }

        private static class AuthRequest {
            private String username;
            private String password;

            // Getters and setters
        }
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public class UnauthorizedException extends RuntimeException {
        public UnauthorizedException(String message) {
            super(message);
        }
    }

    public class JwtTokenProvider {

        private final String secret;

        public JwtTokenProvider(String secret) {
            this.secret = secret;
        }

        public String generateToken(String username) {
            Date now = new Date();
            Date expiration = new Date(now.getTime() + 3600000); // 1 hour
            return Jwts.builder()
                    .setSubject(username)
                    .setIssuedAt(now)
                    .setExpiration(expiration)
                    .signWith(SignatureAlgorithm.HS256, secret)
                    .compact();
        }
    }
}
```

Este exemplo usa um filtro JWT para validar o token recebido em cada solicitação. Se o token for válido, ele autentica o usuário e permite o acesso à rota protegida. Certifique-se de ajustar o código conforme necessário para suas necessidades específicas.

Os starters do Spring Boot são conjuntos de dependências Maven pré-configuradas que facilitam o desenvolvimento de aplicativos Spring Boot. Eles são projetados para fornecer conjuntos coesos de dependências para tarefas específicas, permitindo que os desenvolvedores iniciem rapidamente com a construção de aplicativos sem precisar gerenciar manualmente todas as dependências.

Aqui estão alguns dos starters mais comuns no ecossistema Spring Boot:

1. **spring-boot-starter-web:**
   - Fornece as dependências necessárias para construir aplicativos da web usando o Spring MVC.

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

2. **spring-boot-starter-data-jpa:**
   - Adiciona suporte para acesso a dados usando o Spring Data JPA e Hibernate.

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

3. **spring-boot-starter-data-rest:**
   - Permite a criação rápida de APIs RESTful baseadas em repositórios Spring Data.

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-rest</artifactId>
</dependency>
```

4. **spring-boot-starter-security:**
   - Fornece suporte para segurança, incluindo autenticação e autorização, usando o Spring Security.

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

5. **spring-boot-starter-test:**
   - Contém dependências necessárias para escrever testes de unidade e integração usando o framework Spring Boot Test.

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
```

6. **spring-boot-starter-data-mongodb:**
   - Fornece suporte para integração com o MongoDB usando o Spring Data MongoDB.

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>
```

7. **spring-boot-starter-thymeleaf:**
   - Adiciona suporte para o Thymeleaf, um mecanismo de template para a construção de interfaces web.

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

8. **spring-boot-starter-logging:**
   - Configura o logging para aplicativos Spring Boot, incluindo o uso do Logback.

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-logging</artifactId>
</dependency>
```

9. **spring-boot-starter-parent:**
   - Fornece configurações de projeto padrão para aplicativos Spring Boot. Pode ser usado como pai no seu arquivo `pom.xml`.

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.6.0</version> <!-- Versão mais recente no momento -->
</parent>
```

Esses são apenas alguns dos muitos starters disponíveis. Eles são projetados para simplificar o processo de configuração do seu aplicativo Spring Boot, permitindo que você se concentre mais na lógica de negócios em vez de gerenciar manualmente as dependências e configurações.

A autoconfiguração (autoconfiguration) no Spring Boot é um recurso que permite ao framework configurar automaticamente componentes e funcionalidades com base nas dependências presentes no classpath da aplicação. Isso é alcançado por meio do uso extensivo de anotações `@ConditionalOnClass`, `@ConditionalOnMissingBean`, `@ConditionalOnProperty` e outras, que condicionalmente ativam ou desativam configurações com base na presença de classes, beans ou propriedades.

### Como Funciona a Autoconfiguração:

1. **Análise de Classpath:**
   - O Spring Boot examina o classpath da aplicação em busca de bibliotecas e dependências.
   
2. **Anotações Condicionalmente Ativadas:**
   - As configurações automáticas são ativadas por meio de anotações condicionais como `@ConditionalOnClass`, `@ConditionalOnMissingBean`, etc.

3. **Configuração Condicional:**
   - As classes de configuração são carregadas condicionalmente com base nas condições definidas pelas anotações.

4. **Beans e Configurações são Registrados:**
   - Os beans e configurações necessários são registrados no contexto da aplicação.

### Exemplo de Autoconfiguração:

Por exemplo, considere a autoconfiguração para um banco de dados H2. Se o H2 estiver no classpath, o Spring Boot automaticamente configura um DataSource e outras propriedades relacionadas ao H2.

```java
@Configuration
@ConditionalOnClass({ H2ConsoleProperties.class, H2ConsoleAutoConfiguration.class })
@EnableConfigurationProperties(H2ConsoleProperties.class)
public class H2ConsoleAutoConfiguration {

    private final H2ConsoleProperties properties;

    public H2ConsoleAutoConfiguration(H2ConsoleProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnMissingBean(H2ConsoleProperties.ConfigProvider.class)
    public H2ConsoleProperties.ConfigProvider h2ConsoleConfigProvider() {
        return new H2ConsoleProperties.ConfigProvider(this.properties);
    }

    // Mais configurações e beans relacionados ao H2Console...
}
```

Neste exemplo simplificado, o `@ConditionalOnClass` garante que a configuração seja ativada apenas se a classe `H2ConsoleProperties` e `H2ConsoleAutoConfiguration` estiverem presentes no classpath. `@ConditionalOnMissingBean` indica que o bean só será registrado se não houver uma implementação já presente no contexto.

### Desativação de Autoconfiguração:

Se você deseja desativar uma autoconfiguração específica, você pode usar a propriedade `spring.autoconfigure.exclude` no arquivo `application.properties` ou `application.yml`:

```properties
spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
```

Neste exemplo, a autoconfiguração padrão para `DataSource` será desativada.

A autoconfiguração é uma característica poderosa que simplifica muito o desenvolvimento de aplicativos Spring Boot, permitindo que os desenvolvedores iniciem rapidamente sem a necessidade de configurações extensivas. Ela é altamente modular e baseada em convenções, tornando-a fácil de entender e personalizar quando necessário.

Os **Spring Boot Actuators** são um conjunto de recursos prontos para uso que ajudam a monitorar e gerenciar um aplicativo Spring Boot em tempo de execução. Eles fornecem endpoints HTTP ou JMX que expõem informações detalhadas sobre o estado interno, métricas, auditoria, ambiente e outros aspectos do aplicativo. Esses recursos são úteis para operações, monitoramento e solução de problemas em ambientes de produção.

Aqui estão alguns dos recursos principais fornecidos pelos Spring Boot Actuators:

1. **Endpoint de Informações (`/info`):**
   - Fornece informações personalizáveis sobre o aplicativo. Pode ser útil para expor detalhes sobre a versão, descrição, etc.

2. **Endpoint de Saúde (`/health`):**
   - Indica o status geral da saúde do aplicativo. Pode ser configurado para fornecer informações específicas sobre componentes do aplicativo.

3. **Endpoint de Métricas (`/metrics`):**
   - Expõe métricas detalhadas sobre o desempenho e o estado do aplicativo, incluindo contadores, temporizadores, histogramas, etc.

4. **Endpoint de Audição de Aplicativo (`/auditevents`):**
   - Fornece informações sobre eventos de auditoria que ocorreram no aplicativo.

5. **Endpoint de Ambiente (`/env`):**
   - Exibe detalhes sobre o ambiente do aplicativo, incluindo propriedades de sistema, variáveis de ambiente, propriedades de configuração, etc.

6. **Endpoint de Configuração (`/configprops`):**
   - Exibe detalhes sobre todas as propriedades de configuração disponíveis no aplicativo.

7. **Endpoint de Mapeamento de URL (`/mappings`):**
   - Fornece informações sobre os mapeamentos de URL no aplicativo, mostrando quais métodos de controlador correspondem a quais URLs.

8. **Endpoint de Reinicialização (`/restart`):**
   - Permite reiniciar dinamicamente o aplicativo. Isso pode ser útil em ambientes de produção para aplicar alterações de configuração sem reiniciar todo o aplicativo.

9. **Endpoint de Destino do Thread Dump (`/dump`):**
   - Gera e exibe um despejo de thread do aplicativo. Útil para diagnóstico de problemas de thread.

10. **Endpoint de Cache (`/caches`):**
    - Fornece informações sobre os caches disponíveis no aplicativo e permite limpar caches específicos.

11. **Endpoint de Shell (`/shell`):**
    - Oferece um shell remoto para interação com o aplicativo, permitindo a execução de comandos do Spring Boot CLI.

Para habilitar os Spring Boot Actuators em seu aplicativo, basta adicionar a dependência `spring-boot-starter-actuator` ao seu arquivo `pom.xml` (ou `build.gradle`):

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

Com essa dependência adicionada, os endpoints padrão estarão disponíveis em seu aplicativo. Você pode personalizar as configurações e endpoints adicionando propriedades específicas ao arquivo `application.properties` ou `application.yml`.

```properties
# Exemplo de personalização de endpoint de métricas
management.endpoints.web.exposure.include=health,info,metrics
management.endpoint.metrics.enabled=true
```

Este exemplo configura o aplicativo para expor apenas os endpoints de `/health`, `/info` e `/metrics`. Você pode ajustar as configurações conforme necessário para atender aos requisitos específicos do seu aplicativo.

No contexto do Spring Boot, um servidor incorporado (embedded server) refere-se a um servidor web que é incorporado diretamente na aplicação, eliminando a necessidade de implantar o aplicativo em um contêiner de servlet externo, como Tomcat ou Jetty. O Spring Boot oferece suporte a uma variedade de servidores incorporados, permitindo que os desenvolvedores escolham aquele que melhor se adapta às necessidades de seus aplicativos.

Aqui estão alguns dos servidores incorporados comumente usados no ecossistema Spring Boot:

1. **Tomcat:**
   - O Apache Tomcat é um contêiner de servlet e servidor web amplamente utilizado. O Spring Boot oferece suporte à incorporação do Tomcat por padrão.

   ```xml
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-tomcat</artifactId>
   </dependency>
   ```

2. **Jetty:**
   - O Eclipse Jetty é outro servidor web e contêiner de servlet popular. Você pode optar por usar o Jetty como seu servidor incorporado no Spring Boot.

   ```xml
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-jetty</artifactId>
   </dependency>
   ```

3. **Undertow:**
   - Undertow é um servidor web leve e de alto desempenho. O Spring Boot oferece suporte à incorporação do Undertow.

   ```xml
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-undertow</artifactId>
   </dependency>
   ```

### Configuração do Servidor Incorporado:

A escolha do servidor incorporado pode ser feita adicionando a dependência apropriada ao arquivo `pom.xml` (ou `build.gradle`). Aqui está um exemplo para o Tomcat:

```xml
<dependencies>
    <!-- Outras dependências do Spring Boot -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-tomcat</artifactId>
    </dependency>
</dependencies>
```

Se você deseja usar o Jetty, substitua a dependência pelo `spring-boot-starter-jetty`. Da mesma forma, se preferir o Undertow, use `spring-boot-starter-undertow`.

Além disso, você pode personalizar a configuração do servidor incorporado adicionando propriedades ao arquivo `application.properties` ou `application.yml`:

```properties
# Exemplo de configuração do Tomcat
server.port=8080
server.tomcat.uri-encoding=UTF-8
server.tomcat.max-threads=200
```

Essas configurações específicas do Tomcat controlam o número máximo de threads e a codificação URI.

### Inicialização Personalizada do Servidor:

Às vezes, é necessário realizar configurações adicionais no servidor incorporado. O Spring Boot permite a inicialização personalizada por meio de uma classe Java anotada com `@Configuration` e `@EnableAutoConfiguration`. Aqui está um exemplo para o Tomcat:

```java
import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.embedded.TomcatWebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass({ Tomcat.class, Http11NioProtocol.class })
public class TomcatCustomizationConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public TomcatWebServerFactoryCustomizer tomcatWebServerFactoryCustomizer(
            ServerProperties serverProperties) {
        return new TomcatWebServerFactoryCustomizer(serverProperties);
    }

    @Bean
    public EmbeddedWebServerFactoryCustomizerAutoConfiguration embeddedWebServerFactoryCustomizerAutoConfiguration() {
        return new EmbeddedWebServerFactoryCustomizerAutoConfiguration();
    }

    @Bean
    public EmbeddedWebServerFactoryCustomizerAutoConfiguration embeddedWebServerFactoryCustomizerAutoConfiguration(
            ServerProperties serverProperties) {
        return new EmbeddedWebServerFactoryCustomizerAutoConfiguration(serverProperties);
    }

    @Bean
    public Connector connector() {
        return new Connector();
    }
}
```

Essa classe de configuração personalizada do Tomcat permite realizar configurações específicas do Tomcat antes que o servidor seja iniciado.

Escolher o servidor incorporado apropriado depende das características e requisitos específicos do seu aplicativo. Cada servidor tem suas próprias vantagens e características, e a escolha geralmente se baseia em preferências, desempenho e requisitos do ambiente de produção.

O Hibernate é um framework de mapeamento objeto-relacional (ORM) para Java que facilita o armazenamento e a recuperação de objetos Java em um banco de dados relacional. Ele fornece uma maneira eficiente e elegante de trabalhar com bancos de dados relacionais, permitindo que os desenvolvedores interajam com o banco de dados usando objetos Java.

Aqui estão os conceitos e recursos-chave do Hibernate:

### 1. **Mapeamento Objeto-Relacional (ORM):**
   - O Hibernate mapeia classes Java para tabelas no banco de dados e propriedades de objetos Java para colunas de tabelas. Isso permite que os desenvolvedores trabalhem com objetos Java em vez de escrever consultas SQL diretamente.

### 2. **Entidades e Anotações:**
   - No Hibernate, uma classe Java que é mapeada para uma tabela no banco de dados é chamada de entidade. As anotações, como `@Entity`, `@Table`, `@Id`, são usadas para configurar o mapeamento entre a classe e a tabela.

   ```java
   @Entity
   @Table(name = "employees")
   public class Employee {

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;

       private String firstName;
       private String lastName;

       // Getters and setters
   }
   ```

### 3. **SessionFactory e Session:**
   - O Hibernate usa um objeto `SessionFactory` para criar e gerenciar objetos `Session`. A `Session` é responsável por realizar operações de CRUD (Criar, Ler, Atualizar, Excluir) no banco de dados.

   ```java
   SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

   Session session = sessionFactory.openSession();
   Transaction transaction = session.beginTransaction();

   // Operações CRUD usando a Session

   transaction.commit();
   session.close();
   ```

### 4. **HQL (Hibernate Query Language):**
   - O Hibernate fornece uma linguagem de consulta chamada HQL, semelhante ao SQL, mas trabalhando com entidades e propriedades Java em vez de tabelas e colunas do banco de dados.

   ```java
   Query query = session.createQuery("FROM Employee WHERE lastName = :lastName");
   query.setParameter("lastName", "Doe");

   List<Employee> employees = query.list();
   ```

### 5. **Relacionamentos entre Entidades:**
   - O Hibernate suporta vários tipos de relacionamentos entre entidades, como `@OneToOne`, `@OneToMany`, `@ManyToOne`, `@ManyToMany`. Esses relacionamentos são definidos nas classes de entidade.

   ```java
   @Entity
   public class Department {

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;

       private String name;

       @OneToMany(mappedBy = "department")
       private List<Employee> employees;

       // Getters and setters
   }
   ```

### 6. **Configuração via Arquivo XML ou Anotações:**
   - A configuração do Hibernate pode ser feita por meio de arquivos XML (`hibernate.cfg.xml`) ou usando anotações diretamente nas classes Java.

### 7. **Caching:**
   - O Hibernate suporta caching para melhorar o desempenho. Ele oferece caching de primeiro e segundo nível para armazenar em cache dados na camada da aplicação e na camada do servidor.

### 8. **Listeners e Interceptors:**
   - O Hibernate permite que os desenvolvedores adicionem listeners e interceptors para ouvir eventos e personalizar o comportamento do framework.

### 9. **Validação de Dados:**
   - O Hibernate Validator é uma extensão que adiciona suporte à validação de dados usando anotações, permitindo que você defina regras de validação diretamente nas entidades.

Esses são apenas alguns dos conceitos fundamentais do Hibernate. Ao usar o Hibernate, os desenvolvedores podem se beneficiar de um mapeamento objeto-relacional eficiente, reduzindo a quantidade de código SQL manual que precisa ser escrito e facilitando o desenvolvimento de aplicativos Java que interagem com bancos de dados relacionais.

As transações no contexto do Hibernate e de bancos de dados em geral referem-se a um conjunto de operações que devem ser executadas como uma única unidade atômica. Ou seja, todas as operações dentro de uma transação devem ser concluídas com êxito, ou todas elas devem ser revertidas (rollback) se ocorrer algum erro.

No Hibernate, as transações são gerenciadas por meio do objeto `Transaction` e da interface `javax.persistence.EntityManager`. Aqui está uma visão geral de como você pode usar transações no Hibernate:

### 1. **Iniciando uma Transação:**
   - Antes de realizar operações de leitura ou gravação no banco de dados, é necessário iniciar uma transação.

   ```java
   EntityManager entityManager = // Obtenha o EntityManager adequado

   // Inicia uma transação
   EntityTransaction transaction = entityManager.getTransaction();
   transaction.begin();
   ```

### 2. **Realizando Operações dentro de uma Transação:**
   - Todas as operações de leitura e gravação no banco de dados devem ser realizadas dentro do contexto da transação.

   ```java
   // Operações de leitura e gravação aqui
   ```

### 3. **Commit e Rollback da Transação:**
   - Após realizar as operações desejadas, você pode confirmar a transação usando o método `commit()`. Se ocorrer algum erro, você pode reverter a transação usando o método `rollback()`.

   ```java
   try {
       // Commit da transação
       transaction.commit();
   } catch (Exception e) {
       // Rollback em caso de exceção
       transaction.rollback();
       e.printStackTrace();
   }
   ```

### Exemplo Completo:

```java
EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
EntityManager entityManager = entityManagerFactory.createEntityManager();

try {
    // Inicia uma transação
    EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin();

    // Operações de leitura e gravação no banco de dados

    // Commit da transação se tudo ocorrer bem
    transaction.commit();
} catch (Exception e) {
    // Rollback em caso de exceção
    if (entityManager.getTransaction().isActive()) {
        entityManager.getTransaction().rollback();
    }
    e.printStackTrace();
} finally {
    // Fecha o EntityManager
    entityManager.close();
}

// Fecha o EntityManagerFactory
entityManagerFactory.close();
```

Lembre-se de que, em uma aplicação Spring, você pode delegar a gerência de transações ao Spring usando anotações `@Transactional` ou programaticamente usando o `TransactionTemplate`.

### Anotação `@Transactional` (Spring):

```java
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyService {

    @Autowired
    private MyRepository repository;

    @Transactional
    public void performTransactionalOperation() {
        // Operações de leitura e gravação no banco de dados
    }
}
```

Essas abordagens garantem que as transações sejam gerenciadas corretamente, evitando problemas como inconsistências de dados no banco de dados e permitindo a reversão segura em caso de erros.

No contexto do Hibernate e ORM (Object-Relational Mapping), os relacionamentos referem-se à associação entre entidades, onde as entidades podem ter ligações uns com os outros. Existem vários tipos de relacionamentos suportados pelo Hibernate, incluindo relacionamentos de um para um, de um para muitos, de muitos para um e de muitos para muitos. Vamos abordar cada um desses tipos:

### 1. Relacionamento de Um para Um (`@OneToOne`):

No relacionamento de um para um, uma entidade está associada a apenas uma instância de outra entidade, e vice-versa. Por exemplo, considere uma entidade `Person` e uma entidade `Passport`. Cada pessoa tem um único passaporte, e cada passaporte pertence a uma única pessoa.

```java
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private Passport passport;

    // Getters and setters
}

@Entity
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    // Getters and setters
}
```

### 2. Relacionamento de Um para Muitos (`@OneToMany`):

No relacionamento de um para muitos, uma entidade está associada a várias instâncias de outra entidade. Por exemplo, considere uma entidade `Department` e uma entidade `Employee`. Cada departamento pode ter vários funcionários.

```java
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

    // Getters and setters
}

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // Getters and setters
}
```

### 3. Relacionamento de Muitos para Um (`@ManyToOne`):

No relacionamento de muitos para um, várias instâncias de uma entidade estão associadas a uma única instância de outra entidade. Usando o exemplo acima, o relacionamento `@ManyToOne` na classe `Employee` representa que vários funcionários pertencem a um único departamento.

### 4. Relacionamento de Muitos para Muitos (`@ManyToMany`):

No relacionamento de muitos para muitos, várias instâncias de uma entidade podem estar associadas a várias instâncias de outra entidade. Por exemplo, considere uma entidade `Student` e uma entidade `Course`. Vários alunos podem estar matriculados em vários cursos, e vice-versa.

```java
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
        name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;

    // Getters and setters
}

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    // Getters and setters
}
```

### 5. Cascading (`cascade`):

A anotação `cascade` é usada para especificar operações que devem ser propagadas para objetos associados. Por exemplo, ao excluir uma pessoa, também pode ser desejável excluir automaticamente o passaporte associado. O uso de `cascade = CascadeType.ALL` na associação `@OneToOne` ou `@OneToMany` pode automatizar essas operações.

```java
@OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
private Passport passport;
```

Esses são alguns dos tipos de relacionamentos comumente usados no Hibernate. A escolha do tipo de relacionamento depende da lógica de negócios específica e dos requisitos do aplicativo. Certifique-se de entender os conceitos de mapeamento de relacionamento do Hibernate e ajustá-los conforme necessário para atender às necessidades de sua aplicação.

O ciclo de vida de uma entidade no contexto do Hibernate refere-se às diferentes fases pelas quais uma entidade passa desde a sua criação até a sua remoção do banco de dados. O ciclo de vida é representado pelos estados da entidade e é gerenciado pelo `EntityManager` (ou `Session` em algumas versões do Hibernate). Vamos explorar os estados e as transições no ciclo de vida de uma entidade:

### 1. **Transient (Transitório):**
   - Uma entidade é transitória quando foi criada, mas ainda não está associada a uma unidade de persistência (EntityManager ou Session). Nesse estado, qualquer alteração no objeto não será refletida no banco de dados.

   ```java
   Person person = new Person();
   person.setName("John Doe");
   // person está no estado transitório
   ```

### 2. **Managed (Gerenciado):**
   - Uma entidade torna-se gerenciada quando é associada a uma unidade de persistência usando `persist()`, `merge()`, `find()`, ou através de operações de consulta. No estado gerenciado, as alterações no objeto são monitoradas e podem ser sincronizadas com o banco de dados.

   ```java
   EntityManager entityManager = // Obtenha o EntityManager adequado

   Person person = new Person();
   person.setName("John Doe");

   entityManager.getTransaction().begin();
   entityManager.persist(person);
   // person está no estado gerenciado
   entityManager.getTransaction().commit();
   ```

### 3. **Detached (Desanexado):**
   - Uma entidade torna-se desanexada quando ela estava previamente gerenciada, mas a sessão ou o EntityManager foi fechado, ou a entidade foi explicitamente desanexada usando `detach()` ou `clear()`. No estado desanexado, as alterações no objeto não são monitoradas.

   ```java
   EntityManager entityManager = // Obtenha o EntityManager adequado

   entityManager.getTransaction().begin();
   Person person = entityManager.find(Person.class, 1L);
   entityManager.detach(person);
   // person está no estado desanexado
   entityManager.getTransaction().commit();
   ```

### 4. **Removed (Removido):**
   - Uma entidade torna-se removida quando `remove()` é chamado no EntityManager para a entidade gerenciada. A entidade será removida do banco de dados na próxima sincronização de transação.

   ```java
   EntityManager entityManager = // Obtenha o EntityManager adequado

   entityManager.getTransaction().begin();
   Person person = entityManager.find(Person.class, 1L);
   entityManager.remove(person);
   // person está no estado removido
   entityManager.getTransaction().commit();
   ```

### 5. **Refreshed (Atualizado):**
   - O método `refresh()` é usado para recarregar o estado de uma entidade gerenciada a partir do banco de dados. Qualquer alteração não persistida será perdida.

   ```java
   EntityManager entityManager = // Obtenha o EntityManager adequado

   entityManager.getTransaction().begin();
   Person person = entityManager.find(Person.class, 1L);
   person.setName("New Name");

   entityManager.refresh(person);
   // O nome de person é recarregado do banco de dados
   entityManager.getTransaction().commit();
   ```

### Eventos do Ciclo de Vida:

O Hibernate oferece hooks ou eventos que você pode usar para realizar ações específicas em diferentes pontos do ciclo de vida de uma entidade. Alguns desses eventos incluem `@PrePersist`, `@PostPersist`, `@PreUpdate`, `@PostUpdate`, `@PreRemove`, `@PostRemove`, entre outros.

```java
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @PrePersist
    public void prePersist() {
        // Executa antes da persistência (inserção no banco de dados)
    }

    @PostPersist
    public void postPersist() {
        // Executa após a persistência (inserção no banco de dados)
    }

    // Outros eventos do ciclo de vida
}
```

Estes são conceitos essenciais no ciclo de vida de uma entidade Hibernate. O entendimento desses estados e transições é crucial para um uso eficiente e eficaz do framework ORM.

O **Spring Data** é um projeto dentro do ecossistema Spring que simplifica o acesso a dados em aplicativos Java, especialmente quando se trata de operações com bancos de dados relacionais ou NoSQL. Ele fornece abstrações e implementações prontas para uso que reduzem a quantidade de código boilerplate necessário para realizar operações de persistência.

Vamos explorar alguns conceitos e recursos principais do Spring Data:

### Repositórios:

Os repositórios Spring Data são interfaces especiais que estendem `Repository` ou suas variações, como `CrudRepository` ou `PagingAndSortingRepository`. Essas interfaces fornecem métodos CRUD (Create, Read, Update, Delete) prontos para uso e também suportam consultas personalizadas.

Exemplo de uma interface de repositório:

```java
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findByLastName(String lastName);

    // Métodos CRUD padrão já estão disponíveis
}
```

### Consultas Derivadas:

O Spring Data permite que você crie consultas personalizadas com base nos nomes dos métodos em suas interfaces de repositório. O mecanismo de consulta derivada analisa o nome do método e gera automaticamente a consulta correspondente.

```java
// Método da interface de repositório
List<Person> findByLastName(String lastName);
```

### Consultas JPQL (Java Persistence Query Language):

Você também pode definir consultas JPQL dentro dos métodos da interface de repositório usando a anotação `@Query`.

```java
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query("SELECT p FROM Person p WHERE p.lastName = ?1")
    List<Person> findByLastName(String lastName);
}
```

### Suporte a Paginação e Ordenação:

O Spring Data fornece suporte integrado para paginação e ordenação de resultados.

```java
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonRepository extends CrudRepository<Person, Long> {

    Page<Person> findByLastName(String lastName, Pageable pageable);
}
```

### Auditing (Auditoria):

O Spring Data também oferece recursos de auditoria para rastrear automaticamente quem criou ou modificou uma entidade e quando isso aconteceu.

```java
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@EntityListeners(AuditingEntityListener.class)
public class Person {

    // Outros campos da entidade

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    // Getters e setters
}
```

### Spring Data JPA:

No contexto de bancos de dados relacionais, o Spring Data JPA é uma implementação específica que simplifica ainda mais o acesso a dados usando o JPA (Java Persistence API).

Para usar o Spring Data JPA, você precisará incluir a dependência adequada em seu projeto e configurar seu aplicativo para usar JPA, geralmente fornecendo detalhes de conexão em um arquivo `application.properties` ou `application.yml`.

Exemplo de dependência Maven:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

Esses são apenas alguns dos conceitos e recursos oferecidos pelo Spring Data. Dependendo do banco de dados e dos requisitos específicos do aplicativo, você pode escolher a variante apropriada do Spring Data (por exemplo, Spring Data JPA, Spring Data MongoDB, Spring Data Redis, etc.) e aproveitar seus recursos para facilitar o desenvolvimento de operações de persistência de dados.

Spring Data JPA

O **Spring Data MongoDB** é uma parte do projeto Spring Data que simplifica o acesso a dados em aplicativos Java que usam o MongoDB como armazenamento de dados. O MongoDB é um banco de dados NoSQL orientado a documentos, e o Spring Data MongoDB fornece uma camada de abstração sobre a interação com o MongoDB, facilitando o desenvolvimento de operações de persistência.

Aqui estão alguns conceitos e recursos importantes do Spring Data MongoDB:

### Repositórios MongoDB:

No Spring Data MongoDB, os repositórios são interfaces especiais que estendem `MongoRepository`. Essas interfaces fornecem métodos CRUD prontos para uso e também suportam consultas personalizadas.

Exemplo de uma interface de repositório Spring Data MongoDB:

```java
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {

    List<Person> findByLastName(String lastName);

    // Métodos CRUD padrão já estão disponíveis
}
```

### Consultas Derivadas:

O Spring Data MongoDB permite criar consultas personalizadas com base nos nomes dos métodos em suas interfaces de repositório. O mecanismo de consulta derivada analisa o nome do método e gera automaticamente a consulta correspondente.

```java
// Método da interface de repositório
List<Person> findByLastName(String lastName);
```

### Consultas com @Query:

Você pode definir consultas MongoDB dentro dos métodos da interface de repositório usando a anotação `@Query`.

```java
import org.springframework.data.mongodb.repository.Query;
import java.util.List;

public interface PersonRepository extends MongoRepository<Person, String> {

    @Query("{ 'lastName' : ?0 }")
    List<Person> findByLastName(String lastName);
}
```

### Projeções:

Assim como no Spring Data JPA, o Spring Data MongoDB permite projetar resultados diretamente em classes DTO (Data Transfer Object) ou interfaces.

```java
public interface PersonProjection {

    String getFirstName();
    String getLastName();
}
```

### @Document e @Id:

Entidades MongoDB são classes Java com a anotação `@Document`. Elas mapeiam diretamente para documentos no MongoDB.

```java
@Document(collection = "persons")
public class Person {

    @Id
    private String id;

    private String firstName;
    private String lastName;

    // Getters and setters
}
```

### Consultas Geoespaciais:

O Spring Data MongoDB oferece suporte a consultas geoespaciais para interagir com dados que contêm informações espaciais.

```java
public interface LocationRepository extends MongoRepository<Location, String> {

    List<Location> findByPositionNear(Point point, Distance distance);
}
```

### Text Search:

O Spring Data MongoDB suporta consultas de texto completo para realizar pesquisas em campos de texto em documentos MongoDB.

```java
public interface ArticleRepository extends MongoRepository<Article, String> {

    List<Article> findByContentContaining(String keyword);
}
```

### GridFS:

O Spring Data MongoDB oferece suporte ao GridFS, que é um sistema de arquivos no MongoDB projetado para armazenar e recuperar arquivos grandes.

```java
public interface FileRepository extends GridFsRepository<File, String> {
}
```

Esses são apenas alguns dos conceitos e recursos oferecidos pelo Spring Data MongoDB. Dependendo dos requisitos específicos do projeto e do banco de dados MongoDB, o Spring Data MongoDB fornece uma maneira fácil e eficaz de interagir com o MongoDB a partir de aplicativos Spring.

O **Spring Data JDBC** é uma parte do projeto Spring Data que oferece uma solução de acesso a dados baseada em JDBC (Java Database Connectivity). Ao contrário do Hibernate ou JPA, o Spring Data JDBC fornece uma abordagem mais leve e direta para mapear objetos Java para tabelas de banco de dados relacionais usando JDBC puro.

Aqui estão alguns conceitos e recursos importantes do Spring Data JDBC:

### Entidades e Repositórios:

- **Entidades:** São classes Java anotadas com `@Table` e `@Id` que representam as tabelas do banco de dados.

    ```java
    @Table("persons")
    public class Person {

        @Id
        private Long id;

        private String firstName;
        private String lastName;

        // Getters and setters
    }
    ```

- **Repositórios:** Interfaces que estendem `JdbcRepository` e fornecem métodos CRUD prontos para uso.

    ```java
    public interface PersonRepository extends JdbcRepository<Person, Long> {

        List<Person> findByLastName(String lastName);
    }
    ```

### Consultas Derivadas:

O Spring Data JDBC permite criar consultas personalizadas com base nos nomes dos métodos em suas interfaces de repositório, de forma semelhante ao Spring Data JPA.

```java
// Método da interface de repositório
List<Person> findByLastName(String lastName);
```

### Consultas Manuais:

Você também pode criar consultas manuais usando `@Query`.

```java
public interface PersonRepository extends JdbcRepository<Person, Long> {

    @Query("SELECT * FROM persons WHERE last_name = :lastName")
    List<Person> findByLastName(@Param("lastName") String lastName);
}
```

### Relacionamentos:

O Spring Data JDBC suporta mapeamento de relacionamentos entre entidades, como `@OneToOne`, `@OneToMany`, `@ManyToOne`, e `@ManyToMany`.

```java
@Table("departments")
public class Department {

    @Id
    private Long id;

    private String name;

    @MappedCollection(idColumn = "department_id")
    private List<Employee> employees;

    // Getters and setters
}

@Table("employees")
public class Employee {

    @Id
    private Long id;

    private String name;

    @MappedCollection(idColumn = "department_id")
    private Department department;

    // Getters and setters
}
```

### Projeções:

Assim como em outros módulos do Spring Data, o Spring Data JDBC suporta projeções para recuperar apenas os dados necessários.

```java
public interface PersonProjection {

    String getFirstName();
    String getLastName();
}
```

### Custom Row Mappers:

Você pode criar Row Mappers personalizados para controlar como as entidades são mapeadas de e para o banco de dados.

```java
public class CustomPersonRowMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(SqlRowSet rowSet) {
        // Lógica de mapeamento personalizado
    }
}
```

### Eventos do Ciclo de Vida:

O Spring Data JDBC oferece eventos do ciclo de vida, semelhantes aos eventos do ciclo de vida do Hibernate, para executar lógica antes ou depois de certas operações.

```java
@Table("persons")
public class Person {

    @Id
    private Long id;

    private String firstName;
    private String lastName;

    @Transient
    private boolean modified = false;

    @BeforeSave
    void beforeSave() {
        // Lógica a ser executada antes da operação de salvamento
    }

    @AfterSave
    void afterSave() {
        // Lógica a ser executada após a operação de salvamento
    }

    // Getters and setters
}
```

Esses são alguns dos conceitos e recursos oferecidos pelo Spring Data JDBC. O Spring Data JDBC é uma opção leve e direta para acesso a dados usando JDBC, sendo adequado para casos em que a simplicidade e o controle direto sobre as consultas e mapeamento são preferidos.
