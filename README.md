<div align="center">

<br/>

# 💰 Finance App

**Gerencie suas finanças pessoais com clareza e controle total.**

<br/>

[![React Native](https://img.shields.io/badge/React_Native-20232A?style=for-the-badge&logo=react&logoColor=61DAFB)](https://reactnative.dev/)
[![TypeScript](https://img.shields.io/badge/TypeScript-3178C6?style=for-the-badge&logo=typescript&logoColor=white)](https://www.typescriptlang.org/)
[![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)](https://developer.mozilla.org/pt-BR/docs/Web/HTML)
[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com/)

[![License: MIT](https://img.shields.io/badge/License-MIT-green?style=flat-square)](LICENSE)
[![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow?style=flat-square)]()
[![Author](https://img.shields.io/badge/Author-Joaonascc-blue?style=flat-square)](https://github.com/Joaonascc)

<br/>

</div>

---

## 📌 Índice

- [Sobre o Projeto](#-sobre-o-projeto)
- [Funcionalidades](#-funcionalidades)
- [Tecnologias](#-tecnologias)
- [Arquitetura](#-arquitetura)
- [Estrutura de Pastas](#-estrutura-de-pastas)
- [Contribuindo](#-contribuindo)
- [Licença](#-licença)

---

## 📖 Sobre o Projeto

O **Finance App** é uma aplicação mobile desenvolvida com foco em **controle financeiro pessoal**. A proposta é oferecer ao usuário uma visão clara e objetiva de sua vida financeira — sem complexidade desnecessária.

O app se conecta a uma **API REST desenvolvida em Java**, garantindo persistência de dados, segurança e escalabilidade no backend.

> Ideal para quem quer começar a organizar as finanças com uma ferramenta simples, rápida e funcional.

---

## ✨ Funcionalidades

| Funcionalidade | Descrição |
|---|---|
| 📋 Cadastro de transações | Registre receitas e despesas com categoria, valor e data |
| 💸 Controle de gastos | Monitore seus gastos por categoria e período |
| 📊 Gráficos e relatórios | Visualize seu histórico financeiro em gráficos intuitivos |

---

## 🛠️ Tecnologias

### 📱 Frontend — Mobile

| Tecnologia | Finalidade |
|---|---|
| [React Native](https://reactnative.dev/) | Framework principal para desenvolvimento mobile multiplataforma |
| [TypeScript](https://www.typescriptlang.org/) | Tipagem estática para maior segurança e manutenibilidade do código |
| [HTML5](https://developer.mozilla.org/pt-BR/docs/Web/HTML) | Estruturação de interfaces e componentes web embarcados |

### ⚙️ Backend — API REST

| Tecnologia | Finalidade |
|---|---|
| [Java](https://www.java.com/) | Linguagem principal para construção da API REST robusta e escalável |

---

## 🏗️ Arquitetura

O projeto segue uma arquitetura **cliente-servidor desacoplada**:

```
┌─────────────────────┐        HTTP/REST        ┌──────────────────────┐
│   Mobile (Frontend) │  ──────────────────────▶ │   API Java (Backend) │
│   React Native      │  ◀──────────────────────  │   REST Endpoints     │
│   TypeScript        │        JSON              │   Persistência       │
└─────────────────────┘                          └──────────────────────┘
```

---

## 📁 Estrutura de Pastas

```
finance-app/
│
├── 📱 mobile/                  # Aplicação React Native
│   ├── src/
│   │   ├── components/         # Componentes reutilizáveis
│   │   ├── screens/            # Telas da aplicação
│   │   ├── services/           # Integração com a API
│   │   ├── types/              # Interfaces e tipos TypeScript
│   │   ├── hooks/              # Custom hooks
│   │   └── utils/              # Funções auxiliares
│   ├── App.tsx
│   └── package.json
│
└── ⚙️ backend/                 # API REST em Java
    └── src/
        └── main/
            └── java/
                ├── controllers/    # Endpoints da API
                ├── services/       # Regras de negócio
                ├── models/         # Entidades / DTOs
                └── repositories/   # Acesso ao banco de dados
```

---

## 🤝 Contribuindo

Contribuições são muito bem-vindas! Para contribuir:

1. Faça um **fork** do repositório
2. Crie uma branch para sua feature
```bash
git checkout -b feature/nome-da-feature
```
3. Faça o commit seguindo [Conventional Commits](https://www.conventionalcommits.org/)
```bash
git commit -m "feat: descrição da feature"
```
4. Envie para o repositório remoto
```bash
git push origin feature/nome-da-feature
```
5. Abra um **Pull Request** detalhando as mudanças

---

## 📄 Licença

Este projeto está sob a licença **MIT**. Consulte o arquivo [LICENSE](LICENSE) para mais informações.

---

<div align="center">

<br/>

Desenvolvido por **[Joaonascc](https://github.com/Joaonascc)**

[![GitHub](https://img.shields.io/badge/GitHub-Joaonascc-181717?style=flat-square&logo=github)](https://github.com/Joaonascc)

<br/>

</div>
