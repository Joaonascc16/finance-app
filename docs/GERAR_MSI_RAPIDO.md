# ⚡ Gerar MSI em 3 Passos

Guia super rápido para criar o instalador MSI!

---

## 🚀 Passo 1: Preparar

```bash
cd /caminho/do/finance-app/electron
npm install
```

**Tempo**: 2 minutos

---

## 🔨 Passo 2: Compilar Frontend

```bash
cd ../frontend
npm run build
```

**Tempo**: 3 minutos

---

## 📦 Passo 3: Gerar MSI

### Opção A: Windows (PowerShell)

```bash
cd ../electron
.\build-msi.ps1
```

### Opção B: Mac/Linux (Bash)

```bash
cd ../electron
chmod +x build-msi.sh
./build-msi.sh
```

### Opção C: Qualquer SO (npm)

```bash
cd ../electron
npm run build-msi
```

**Tempo**: 3-5 minutos

---

## ✅ Pronto!

Seu arquivo MSI está em:

```
electron/dist/FinanceApp-1.0.0.msi
```

---

## 🎯 Usar o MSI

### No seu PC:
```bash
# Duplo clique em FinanceApp-1.0.0.msi
# Seguir o wizard
# Pronto! App instalado
```

### Compartilhar:
```bash
# Enviar arquivo para amigos
# Eles duplo clicam e instalam
# Sem precisar de Node.js ou npm!
```

---

## 📊 Resumo

| Etapa | Tempo | Comando |
|-------|-------|---------|
| Preparar | 2 min | `npm install` |
| Compilar | 3 min | `npm run build` |
| Gerar MSI | 5 min | `npm run build-msi` |
| **TOTAL** | **10 min** | - |

---

## 🎁 Resultado

✅ Arquivo MSI profissional  
✅ Instalador com wizard  
✅ Atalhos automáticos  
✅ Desinstalação fácil  
✅ Pronto para distribuir  

---

**Seu FinanceApp está instalável!** 🚀
