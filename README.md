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
