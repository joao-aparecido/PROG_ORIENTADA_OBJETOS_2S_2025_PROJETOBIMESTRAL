# PROG_ORIENTADA_OBJETOS_2S_2025_PROJETOBIMESTRAL
📘 Sistema de Gerenciamento de Veículos

Projeto acadêmico — Programação Orientada a Objetos (Java + Maven + SQLite)

📌 Descrição do Projeto

Este projeto implementa um sistema de gerenciamento de veículos utilizando conceitos de Programação Orientada a Objetos, incluindo:

Encapsulamento

Herança

Polimorfismo

Camadas (DAO, Service, Model)

Banco SQLite integrado via JDBC

Execução utilizando Maven

A aplicação funciona totalmente em modo console.

▶️ Como Rodar o Projeto

Siga os passos abaixo para executar o programa no seu computador.

✅ 1. Pré-requisitos

Certifique-se de ter instalado:

🔹 Java JDK 21+

Para verificar:

java -version

🔹 Apache Maven 3.9+

Para verificar:

mvn -version


Se esses comandos funcionam, você está pronto.

✅ 2. Estrutura do Projeto

A estrutura principal do projeto é:

vehicles_project
 ├─ src
 │   └─ main
 │       └─ java
 │           └─ com
 │               └─ example
 │                   └─ vehicles
 │                       ├─ dao
 │                       ├─ db
 │                       ├─ model
 │                       ├─ service
 │                       └─ Main.java
 ├─ pom.xml
 └─ README.md


A classe principal está em:

com.example.vehicles.Main

✅ 3. Como Compilar

No diretório vehicles_project, execute:

mvn clean package exec:java


Isso irá:

Baixar dependências

Compilar o código

Gerar o arquivo .jar dentro do diretório target/

▶️ 4. Como Executar (forma recomendada)

O Maven já está configurado para rodar o programa automaticamente com o plugin exec.

Basta rodar:

mvn clean package exec:java



Se quiser compilar e executar de uma vez:

mvn clean package exec:java

▶️ 5. Como Executar Manualmente o .jar (opcional)

Após compilar, execute:

java -cp target/sistema-oop-maven-1.0-SNAPSHOT.jar com.example.vehicles.Main

❗ Problemas Comuns
🔸 Erro: “ClassNotFoundException: com.example.vehicles.Main”

Isso significa que o pom.xml está configurado com o mainClass errado.

Ele deve estar assim:

<mainClass>com.example.vehicles.Main</mainClass>

🔸 Erro: não consegue executar mvn

No Windows, instale o Maven e adicione ao PATH:

C:\apache-maven-3.9.11\bin
