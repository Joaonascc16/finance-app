# 📦 Migração de Gradle para Maven

Guia completo para migrar o projeto de Gradle para Maven.

## 🔄 O que mudou?

| Aspecto | Gradle | Maven |
|--------|--------|-------|
| Arquivo config | `build.gradle` | `pom.xml` |
| Diretório build | `build/` | `target/` |
| Executável | `gradlew` | `mvn` (instalado globalmente) |
| Estrutura | Groovy DSL | XML |
| Dependências | `dependencies {}` | `<dependencies>` |

## 🚀 Passo 1: Instalar Maven

### Linux/Mac
```bash
# Homebrew
brew install maven

# Ou download manual
wget https://archive.apache.org/dist/maven/maven-3/3.9.5/binaries/apache-maven-3.9.5-bin.tar.gz
tar -xzf apache-maven-3.9.5-bin.tar.gz
export PATH=$PATH:/path/to/apache-maven-3.9.5/bin
```

### Windows
```powershell
# Chocolatey
choco install maven

# Ou download manual
# https://maven.apache.org/download.cgi
```

### Verificar instalação
```bash
mvn --version
```

## 📁 Passo 2: Estrutura de Diretórios

O Maven espera esta estrutura:

```
backend/
├── pom.xml                          # Novo arquivo
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/financeapp/
│   │   │       ├── controller/
│   │   │       ├── service/
│   │   │       ├── repository/
│   │   │       ├── entity/
│   │   │       ├── dto/
│   │   │       └── FinanceAppApplication.java
│   │   └── resources/
│   │       ├── application.yml
│   │       └── application.properties
│   └── test/
│       ├── java/
│       │   └── com/financeapp/
│       │       └── FinanceAppApplicationTests.java
│       └── resources/
├── target/                          # Criado automaticamente
├── .mvnrc                           # Configurações Maven
├── MAVEN_MIGRATION.md               # Este arquivo
└── pom.xml                          # Configuração Maven
```

A estrutura já está correta! ✅

## 🔧 Passo 3: Usar Maven

### Compilar projeto
```bash
mvn clean compile
```

### Executar testes
```bash
mvn test
```

### Empacotar (criar JAR)
```bash
mvn clean package
```

### Rodar aplicação
```bash
mvn spring-boot:run
```

### Limpar build
```bash
mvn clean
```

### Instalar dependências
```bash
mvn dependency:resolve
```

## 📊 Comparação de Comandos

| Tarefa | Gradle | Maven |
|--------|--------|-------|
| Compilar | `./gradlew build` | `mvn clean package` |
| Rodar | `./gradlew bootRun` | `mvn spring-boot:run` |
| Testes | `./gradlew test` | `mvn test` |
| Limpar | `./gradlew clean` | `mvn clean` |
| Dependências | `./gradlew dependencies` | `mvn dependency:tree` |

## 🗑️ Passo 4: Remover Gradle (Opcional)

Se não vai mais usar Gradle:

```bash
cd backend

# Remover arquivos Gradle
rm -rf gradle/
rm gradlew
rm gradlew.bat
rm build.gradle
rm settings.gradle
rm HELP.md

# Remover diretório build
rm -rf build/
```

## 📝 Arquivo pom.xml Explicado

### Seção Parent
```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>4.0.5</version>
</parent>
```
Define que estamos usando Spring Boot 4.0.5

### Dependências Principais
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
Adiciona Spring Web (REST APIs)

### Plugins Build
```xml
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
</plugin>
```
Plugin para empacotar como JAR executável

## 🔍 Verificar Dependências

### Listar todas as dependências
```bash
mvn dependency:tree
```

### Verificar dependências desatualizadas
```bash
mvn versions:display-dependency-updates
```

### Atualizar versões
```bash
mvn versions:update-properties
```

## 🐛 Troubleshooting

### Erro: "Maven command not found"

```bash
# Verificar instalação
mvn --version

# Se não funcionar, adicionar ao PATH
export PATH=$PATH:/path/to/maven/bin
```

### Erro: "BUILD FAILURE"

```bash
# Limpar cache Maven
rm -rf ~/.m2/repository

# Tentar novamente
mvn clean package
```

### Erro: "Cannot find symbol"

```bash
# Recompilar tudo
mvn clean compile

# Ou com força
mvn clean compile -U
```

### Erro: "Port 8080 already in use"

```bash
# Matar processo na porta 8080
# Linux/Mac
lsof -ti:8080 | xargs kill -9

# Windows
netstat -ano | findstr :8080
taskkill /PID <PID> /F
```

## 📦 Criar JAR Executável

```bash
# Compilar e empacotar
mvn clean package

# JAR criado em: target/finance-app-1.0.0.jar

# Executar JAR
java -jar target/finance-app-1.0.0.jar
```

## 🚀 Deploy com Maven

### Gerar JAR para produção
```bash
mvn clean package -DskipTests
```

### Com perfil de produção
```bash
mvn clean package -Pprod
```

## 📚 Arquivos Importantes

| Arquivo | Função |
|---------|--------|
| `pom.xml` | Configuração do projeto e dependências |
| `.mvnrc` | Variáveis de ambiente Maven |
| `src/main/resources/application.yml` | Configurações da aplicação |
| `src/main/resources/application-prod.yml` | Configurações de produção |

## 🔗 Recursos Úteis

- [Maven Official Site](https://maven.apache.org/)
- [Maven Central Repository](https://mvnrepository.com/)
- [Spring Boot with Maven](https://spring.io/guides/gs/maven/)
- [Maven Cheat Sheet](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)

## ✅ Checklist de Migração

- [x] Maven instalado
- [x] pom.xml criado
- [x] Estrutura de diretórios correta
- [x] Dependências migradas
- [x] Testes funcionando
- [x] JAR compilado com sucesso
- [x] Aplicação rodando

---

**Migração concluída com sucesso! 🎉**
