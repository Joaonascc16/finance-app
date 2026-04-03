# ⚡ Gerar ARM64 em 3 Passos

Executável nativo para seu notebook ARM64!

---

## 🚀 Passo 1: Preparar

```bash
cd electron
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

## 📦 Passo 3: Gerar ARM64

### Opção A: Executável Portátil (Mais Rápido)

```bash
cd ../electron
npm run build-portable-arm64
```

**Resultado**: `FinanceApp-1.0.0-arm64.exe`  
**Tempo**: 3 minutos  
**Uso**: Duplo clique para rodar

---

### Opção B: Instalador MSI (Profissional)

```bash
cd ../electron
npm run build-arm64
```

**Resultado**: `FinanceApp-1.0.0-arm64.msi`  
**Tempo**: 5 minutos  
**Uso**: Duplo clique para instalar

---

## ✅ Pronto!

Arquivo criado em:

```
electron/dist/FinanceApp-1.0.0-arm64.exe
```

ou

```
electron/dist/FinanceApp-1.0.0-arm64.msi
```

---

## 🎯 Usar

### Executável Portátil:
```bash
# Duplo clique em FinanceApp-1.0.0-arm64.exe
# App abre imediatamente
```

### Instalador:
```bash
# Duplo clique em FinanceApp-1.0.0-arm64.msi
# Seguir wizard
# App instalado
```

---

## 📊 Resumo

| Etapa | Tempo | Comando |
|-------|-------|---------|
| Preparar | 2 min | `npm install` |
| Compilar | 3 min | `npm run build` |
| Gerar ARM64 | 5 min | `npm run build-arm64` |
| **TOTAL** | **10 min** | - |

---

## 🎁 Resultado

✅ Executável ARM64 nativo  
✅ Otimizado para seu notebook  
✅ Melhor desempenho  
✅ Menos consumo de bateria  
✅ Pronto para usar  

---

**Seu FinanceApp está pronto para ARM64!** 🚀
