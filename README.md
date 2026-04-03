# FinanceApp - Gerenciador Financeiro Web

Uma aplicação web completa para gerenciamento de finanças pessoais, desenvolvida com **React** no frontend e **Spring Boot** no backend.

## 🚀 Características

- **Dashboard Interativo**: Visualize seu saldo total, receitas e despesas do mês
- **Gerenciamento de Transações**: Adicione, edite e delete transações facilmente
- **Categorias Personalizadas**: 15 categorias pré-configuradas para receitas e despesas
- **Relatórios Visuais**: Gráficos de barras e pizza para análise de gastos
- **Modo Escuro/Claro**: Alterne entre temas conforme sua preferência
- **Design Responsivo**: Funciona perfeitamente em desktop e mobile
- **Banco de Dados PostgreSQL**: Persistência segura de dados

## 🛠️ Stack Tecnológico

### Frontend
- **React 19** - Biblioteca UI
- **Vite** - Build tool
- **React Router** - Navegação
- **Zustand** - State management
- **Recharts** - Gráficos
- **Axios** - HTTP client
- **Lucide React** - Ícones
- **CSS3** - Styling

### Backend
- **Spring Boot 4.0** - Framework web
- **Spring Data JPA** - ORM
- **PostgreSQL** - Banco de dados
- **Lombok** - Redução de boilerplate
- **Jakarta Validation** - Validação de dados
- **Spring Security** - Segurança

## 📋 Pré-requisitos

- Node.js 18+
- Java 17+
- PostgreSQL 12+
- Git

## 🔧 Instalação

### 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/finance-app.git
cd finance-app
```

### 2. Configurar o Backend

```bash
cd backend

# Editar application.yml com suas credenciais PostgreSQL
# spring.datasource.username: seu_usuario
# spring.datasource.password: sua_senha
# spring.datasource.url: jdbc:postgresql://localhost:5432/financeapp

# Compilar e rodar
./gradlew bootRun
```

O backend estará disponível em `http://localhost:8080/api`

### 3. Configurar o Frontend

```bash
cd frontend

# Instalar dependências
npm install

# Rodar em modo desenvolvimento
npm run dev
```

O frontend estará disponível em `http://localhost:5173`

## 📁 Estrutura do Projeto

```
finance-app/
├── frontend/                 # Aplicação React
│   ├── src/
│   │   ├── components/      # Componentes reutilizáveis
│   │   ├── pages/           # Páginas da aplicação
│   │   ├── store/           # Zustand store
│   │   └── index.css        # Estilos globais
│   ├── package.json
│   └── vite.config.js
│
├── backend/                  # Aplicação Spring Boot
│   ├── src/main/java/com/financeapp/
│   │   ├── controller/      # REST Controllers
│   │   ├── service/         # Lógica de negócio
│   │   ├── repository/      # Acesso a dados
│   │   ├── entity/          # Modelos JPA
│   │   ├── dto/             # Data Transfer Objects
│   │   └── FinanceAppApplication.java
│   ├── src/main/resources/
│   │   └── application.yml  # Configurações
│   ├── build.gradle
│   └── gradlew
│
└── README.md
```

## 🗄️ Banco de Dados

### Criar banco de dados PostgreSQL

```sql
CREATE DATABASE financeapp;
```

### Tabelas (criadas automaticamente pelo Hibernate)

- **categories**: Categorias de transações
- **transactions**: Registro de transações

## 🔌 API Endpoints

### Transações

- `GET /api/transactions` - Listar todas as transações
- `GET /api/transactions/{id}` - Obter transação específica
- `GET /api/transactions/month/{year}/{month}` - Transações do mês
- `POST /api/transactions` - Criar nova transação
- `PUT /api/transactions/{id}` - Atualizar transação
- `DELETE /api/transactions/{id}` - Deletar transação

### Categorias

- `GET /api/categories` - Listar todas as categorias
- `GET /api/categories/{id}` - Obter categoria específica
- `GET /api/categories/type/{type}` - Categorias por tipo (INCOME/EXPENSE)
- `POST /api/categories` - Criar nova categoria
- `POST /api/categories/initialize` - Inicializar categorias padrão

## 📊 Exemplo de Requisição

```bash
# Criar transação
curl -X POST http://localhost:8080/api/transactions \
  -H "Content-Type: application/json" \
  -d '{
    "type": "EXPENSE",
    "amount": 150.00,
    "description": "Almoço no restaurante",
    "categoryId": 1,
    "date": "2024-03-28T12:00:00"
  }'
```

## 🎨 Paleta de Cores

| Cor | Uso |
|-----|-----|
| #16A34A | Primária (Verde) |
| #22C55E | Sucesso/Receita |
| #EF4444 | Erro/Despesa |
| #F59E0B | Aviso |

## 📝 Categorias Padrão

### Despesas (10)
- 🍔 Alimentação
- 🏠 Moradia
- 🚗 Transporte
- 💊 Saúde
- 🎮 Lazer
- 👗 Vestuário
- 📚 Educação
- 💡 Contas
- 🛒 Compras
- 💸 Outros

### Receitas (5)
- 💼 Salário
- 📈 Investimentos
- 🎁 Presente
- 🔧 Freelance
- 💰 Outros

## 🚀 Deploy

### Frontend (Vercel/Netlify)

```bash
cd frontend
npm run build
# Fazer upload da pasta dist
```

### Backend (Heroku/Railway)

```bash
cd backend
./gradlew build
# Fazer deploy do arquivo JAR
```

## 🤝 Contribuindo

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.

## 👨‍💻 Autor

Desenvolvido com ❤️ por você

## 📞 Suporte

Para suporte, abra uma issue no GitHub ou entre em contato através do email.

---

**Desenvolvido com React + Spring Boot** 🚀
