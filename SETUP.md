# 🚀 Guia de Setup - FinanceApp

Instruções passo a passo para configurar e rodar o FinanceApp localmente.

## 📋 Pré-requisitos

Antes de começar, certifique-se de ter instalado:

- **Node.js 18+** - [Download](https://nodejs.org/)
- **Java 17+** - [Download](https://www.oracle.com/java/technologies/downloads/)
- **PostgreSQL 12+** - [Download](https://www.postgresql.org/download/)
- **Git** - [Download](https://git-scm.com/)

### Verificar instalações

```bash
node --version
java -version
psql --version
git --version
```

## 🗄️ Passo 1: Configurar Banco de Dados

### 1.1 Criar banco de dados PostgreSQL

```bash
# Abrir psql (terminal PostgreSQL)
psql -U postgres

# Criar banco de dados
CREATE DATABASE financeapp;

# Sair
\q
```

### 1.2 Verificar conexão

```bash
psql -U postgres -d financeapp -c "SELECT version();"
```

## 🔧 Passo 2: Configurar Backend (Spring Boot)

### 2.1 Navegar para pasta backend

```bash
cd backend
```

### 2.2 Atualizar arquivo de configuração

Edite `src/main/resources/application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/financeapp
    username: postgres          # Seu usuário PostgreSQL
    password: postgres          # Sua senha PostgreSQL
```

### 2.3 Compilar e rodar

```bash
# Linux/Mac
./gradlew bootRun

# Windows
gradlew.bat bootRun
```

**Esperado:** Backend rodando em `http://localhost:8080/api`

```
Started FinanceAppApplication in X.XXX seconds
```

## 🎨 Passo 3: Configurar Frontend (React)

### 3.1 Em outro terminal, navegar para pasta frontend

```bash
cd frontend
```

### 3.2 Instalar dependências

```bash
npm install
```

### 3.3 Rodar em modo desenvolvimento

```bash
npm run dev
```

**Esperado:** Frontend rodando em `http://localhost:5173`

```
  VITE v5.0.0  ready in XXX ms

  ➜  Local:   http://localhost:5173/
```

## ✅ Passo 4: Testar Aplicação

### 4.1 Acessar a aplicação

Abra seu navegador e vá para: **http://localhost:5173**

### 4.2 Testar funcionalidades

1. **Dashboard**: Deve mostrar saldo total (inicialmente R$ 0,00)
2. **Criar Transação**: Clique em "Nova Transação"
3. **Visualizar**: Veja a transação no dashboard

### 4.3 Testar API (opcional)

```bash
# Listar todas as categorias
curl http://localhost:8080/api/categories

# Criar transação
curl -X POST http://localhost:8080/api/transactions \
  -H "Content-Type: application/json" \
  -d '{
    "type": "EXPENSE",
    "amount": 50.00,
    "description": "Teste",
    "categoryId": 1,
    "date": "2024-03-28T12:00:00"
  }'
```

## 🐳 Alternativa: Usar Docker

### 4.1 Instalar Docker

[Download Docker Desktop](https://www.docker.com/products/docker-desktop)

### 4.2 Rodar com Docker Compose

```bash
# Na raiz do projeto
docker-compose up
```

Isso vai:
- Criar banco de dados PostgreSQL
- Rodar backend em `http://localhost:8080/api`
- Rodar frontend em `http://localhost:5173`

## 🔍 Troubleshooting

### Erro: "Connection refused" no backend

**Solução:** Verifique se PostgreSQL está rodando
```bash
# Linux/Mac
pg_isready -h localhost -p 5432

# Windows
netstat -an | findstr 5432
```

### Erro: "Port 5173 already in use"

**Solução:** Mude a porta no `frontend/vite.config.js`
```js
server: {
  port: 5174  // Mude para outra porta
}
```

### Erro: "Database does not exist"

**Solução:** Crie o banco de dados novamente
```bash
psql -U postgres -c "CREATE DATABASE financeapp;"
```

### Erro: "Cannot find module"

**Solução:** Reinstale dependências
```bash
# Frontend
cd frontend
rm -rf node_modules package-lock.json
npm install

# Backend
cd backend
./gradlew clean build
```

## 📦 Build para Produção

### Frontend

```bash
cd frontend
npm run build
# Arquivos em: frontend/dist/
```

### Backend

```bash
cd backend
./gradlew build
# JAR em: backend/build/libs/FinanceApp-0.0.1-SNAPSHOT.jar
```

## 🚀 Deploy

### Frontend (Vercel)

```bash
npm install -g vercel
cd frontend
vercel
```

### Backend (Railway/Heroku)

```bash
# Railway
railway link
railway up

# Heroku
heroku login
heroku create financeapp-api
git push heroku main
```

## 📚 Estrutura de Pastas

```
finance-app/
├── frontend/                 # React + Vite
│   ├── src/
│   │   ├── components/      # Componentes reutilizáveis
│   │   ├── pages/           # Páginas (Home, Transactions, etc)
│   │   ├── store/           # Zustand store
│   │   └── index.css        # Estilos globais
│   ├── package.json
│   └── vite.config.js
│
├── backend/                  # Spring Boot
│   ├── src/main/java/
│   │   └── com/financeapp/
│   │       ├── controller/  # REST Controllers
│   │       ├── service/     # Lógica de negócio
│   │       ├── repository/  # Acesso a dados
│   │       ├── entity/      # Modelos JPA
│   │       └── dto/         # DTOs
│   ├── build.gradle
│   └── gradlew
│
├── docker-compose.yml       # Configuração Docker
└── README.md
```

## 🤝 Próximos Passos

1. **Implementar autenticação** - Adicionar login/registro
2. **Adicionar mais telas** - Transações, Relatórios, Configurações
3. **Deploy** - Colocar em produção
4. **Melhorias** - Testes, documentação, otimizações

## 📞 Suporte

Se tiver problemas:

1. Verifique os logs do terminal
2. Consulte o README.md
3. Abra uma issue no GitHub
4. Procure por soluções online

---

**Boa sorte! 🚀**
