# 📦 Criar Instalador MSI do FinanceApp

Guia completo para gerar um arquivo MSI profissional para Windows!

---

## 🎯 O que é MSI?

**MSI** (Microsoft Installer) é o formato padrão de instaladores Windows:
- ✅ Profissional
- ✅ Fácil de instalar
- ✅ Suporta desinstalação
- ✅ Cria atalhos automaticamente
- ✅ Integra com Windows Update

---

## 📋 Pré-requisitos

- Node.js 14+ instalado
- npm ou yarn
- Git
- Projeto FinanceApp
- Ícone em formato .ico (já temos!)

---

## 🚀 Passo 1: Preparar Ambiente

### 1.1 Clonar/Abrir o projeto

```bash
cd /caminho/do/finance-app
```

### 1.2 Verificar estrutura

```bash
# Deve ter estas pastas:
# - frontend/
# - electron/
# - electron/assets/
```

### 1.3 Verificar ícone

```bash
# Verificar se existe:
ls -la electron/assets/icon.ico

# Se não existir, criar um (veja seção "Criar Ícone")
```

---

## 🎨 Passo 2: Criar/Verificar Ícone

### Opção A: Usar ícone padrão

Se você já tem um arquivo `icon.png`:

```bash
# Converter PNG para ICO
# Usar site: https://icoconvert.com/
# 1. Upload do PNG
# 2. Download do ICO
# 3. Salvar em: electron/assets/icon.ico
```

### Opção B: Gerar ícone com ImageMagick

```bash
# Instalar (se não tiver)
# Windows: https://imagemagick.org/script/download.php
# Mac: brew install imagemagick
# Linux: sudo apt-get install imagemagick

# Converter
convert electron/assets/icon.png -define icon:auto-resize=256,128,96,64,48,32,16 electron/assets/icon.ico
```

### Opção C: Usar ícone online

```
https://icoconvert.com/
1. Upload de qualquer imagem
2. Download do .ico
3. Salvar em electron/assets/
```

---

## 🔧 Passo 3: Instalar Dependências

### 3.1 Instalar no electron/

```bash
cd electron
npm install
```

### 3.2 Instalar no frontend/

```bash
cd ../frontend
npm install
```

### 3.3 Verificar versões

```bash
npm list electron
npm list electron-builder
```

---

## 🏗️ Passo 4: Compilar Frontend

### 4.1 Build de produção

```bash
cd frontend
npm run build
```

Isso cria a pasta `frontend/build/` com o app otimizado.

### 4.2 Verificar resultado

```bash
ls -la build/
# Deve ter: index.html, static/, etc
```

---

## 📦 Passo 5: Gerar Arquivo MSI

### 5.1 Comando para MSI

```bash
cd ../electron
npm run build-msi
```

### 5.2 Aguardar conclusão

O processo pode levar 2-5 minutos:

```
✔ Electron Builder iniciado
✔ Empacotando app
✔ Gerando MSI
✔ Assinando (se configurado)
✔ Concluído!
```

### 5.3 Arquivo gerado

O MSI será criado em:

```
electron/dist/FinanceApp-1.0.0.msi
```

---

## ✅ Passo 6: Testar Instalador

### 6.1 Duplo clique no MSI

```bash
# Abrir:
electron/dist/FinanceApp-1.0.0.msi
```

### 6.2 Seguir o wizard

1. Aceitar licença
2. Escolher pasta de instalação
3. Criar atalhos
4. Instalar
5. Concluir

### 6.3 Testar app

- Procurar "FinanceApp" no menu Iniciar
- Ou clicar no atalho do desktop
- Verificar se funciona

### 6.4 Desinstalar (teste)

- Painel de Controle > Programas > Desinstalar
- Procurar "FinanceApp"
- Clicar "Desinstalar"
- Verificar se remove corretamente

---

## 📊 Arquivos Gerados

Na pasta `electron/dist/` você terá:

```
dist/
├── FinanceApp-1.0.0.msi          ← Instalador MSI (use este!)
├── FinanceApp-1.0.0-nsis.exe     ← Instalador NSIS
├── FinanceApp-1.0.0.exe          ← Executável portátil
└── builder-effective-config.yaml  ← Configuração usada
```

---

## 🎁 Distribuir MSI

### Opção 1: GitHub Releases

```bash
# 1. Fazer commit
git add .
git commit -m "Add MSI installer"
git push origin main

# 2. Criar release no GitHub
# https://github.com/seu-usuario/finance-app/releases
# 3. Upload do arquivo: FinanceApp-1.0.0.msi
# 4. Publicar
```

### Opção 2: Google Drive

```bash
# 1. Fazer upload do MSI
# 2. Compartilhar link
# 3. Enviar para usuários
```

### Opção 3: Site próprio

```bash
# 1. Fazer upload em seu servidor
# 2. Criar página de download
# 3. Usuários baixam e instalam
```

---

## 🔄 Gerar Novamente

Sempre que fizer mudanças:

```bash
# 1. Atualizar código
# 2. Compilar frontend
cd frontend && npm run build

# 3. Gerar novo MSI
cd ../electron && npm run build-msi

# 4. Novo arquivo em dist/
```

---

## 🐛 Troubleshooting

### Erro: "Cannot find module 'electron'"

```bash
cd electron
npm install
```

### Erro: "icon.ico not found"

```bash
# Verificar se existe:
ls electron/assets/icon.ico

# Se não existir, criar (veja "Criar Ícone")
```

### Erro: "Build failed"

```bash
# Verificar logs
npm run build-msi 2>&1 | tee build.log

# Corrigir erros
# Tentar novamente
```

### MSI muito grande

```bash
# Remover node_modules
rm -rf node_modules

# Limpar cache
rm -rf dist/

# Tentar novamente
npm run build-msi
```

### Instalador não funciona

```bash
# Verificar se é arquivo correto
file electron/dist/FinanceApp-1.0.0.msi

# Deve mostrar: Microsoft Installer
```

---

## 📊 Comparação de Instaladores

| Tipo | Tamanho | Facilidade | Profissional |
|------|---------|-----------|-------------|
| **MSI** | ~150MB | ⭐⭐⭐⭐⭐ | ⭐⭐⭐⭐⭐ |
| **NSIS** | ~150MB | ⭐⭐⭐⭐ | ⭐⭐⭐⭐ |
| **Portable** | ~150MB | ⭐⭐⭐⭐⭐ | ⭐⭐⭐ |

---

## 💡 Dicas Profissionais

### 1. Assinatura Digital

Para assinar o MSI (opcional):

```bash
# Gerar certificado (Windows)
New-SelfSignedCertificate -DnsName "FinanceApp"

# Configurar em package.json:
"certificateFile": "cert.pfx",
"certificatePassword": "sua-senha"
```

### 2. Versão Automática

Atualizar versão automaticamente:

```bash
# package.json
"version": "1.0.1"

# Gerar novo MSI
npm run build-msi
```

### 3. Customizar Instalador

Editar `package.json` seção `msi`:

```json
"msi": {
  "oneClick": false,
  "allowToChangeInstallationDirectory": true,
  "createDesktopShortcut": true,
  "shortcutName": "FinanceApp"
}
```

---

## 🎯 Checklist

- [ ] Node.js instalado
- [ ] Projeto clonado
- [ ] Ícone em `electron/assets/icon.ico`
- [ ] Frontend compilado (`npm run build`)
- [ ] Dependências instaladas (`npm install`)
- [ ] MSI gerado (`npm run build-msi`)
- [ ] Arquivo em `electron/dist/FinanceApp-1.0.0.msi`
- [ ] Testado em Windows
- [ ] Desinstalação testada
- [ ] Publicado em GitHub/Drive/Site

---

## 📞 Próximas Etapas

1. **Publicar no GitHub Releases** - Usuários podem baixar
2. **Criar página de download** - Site com instruções
3. **Adicionar auto-update** - Atualizar automaticamente
4. **Assinatura digital** - Certificado de confiança
5. **Microsoft Store** - Publicar na loja oficial

---

## 🚀 Pronto!

Seu instalador MSI está pronto para distribuir! 🎉

**Compartilhe com seus usuários:**
```
Baixe e instale: FinanceApp-1.0.0.msi
```

---

## 📚 Recursos Úteis

- Electron Builder Docs: https://www.electron.build/
- MSI Documentation: https://docs.microsoft.com/en-us/windows/win32/msi/about-windows-installer
- Icon Converter: https://icoconvert.com/

---

**Seu FinanceApp está pronto para Windows!** 💻
