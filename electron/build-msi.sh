#!/bin/bash

# Script Bash para gerar MSI do FinanceApp
# Uso: chmod +x build-msi.sh && ./build-msi.sh

echo "🚀 FinanceApp MSI Builder"
echo "========================="
echo ""

# Cores
RED='\033[0;31m'
GREEN='\033[0;32m'
CYAN='\033[0;36m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

# Verificar Node.js
echo -e "${CYAN}✓ Verificando Node.js...${NC}"
if ! command -v node &> /dev/null; then
    echo -e "${RED}❌ Node.js não encontrado! Instale em https://nodejs.org/${NC}"
    exit 1
fi
echo -e "${GREEN}✓ Node.js encontrado: $(node -v)${NC}"

# Verificar npm
echo -e "${CYAN}✓ Verificando npm...${NC}"
if ! command -v npm &> /dev/null; then
    echo -e "${RED}❌ npm não encontrado!${NC}"
    exit 1
fi
echo -e "${GREEN}✓ npm encontrado: $(npm -v)${NC}"

# Verificar ícone
echo -e "${CYAN}✓ Verificando ícone...${NC}"
if [ ! -f "assets/icon.ico" ]; then
    echo -e "${RED}❌ Ícone não encontrado em assets/icon.ico${NC}"
    echo -e "${YELLOW}   Crie um ícone .ico e coloque em assets/${NC}"
    exit 1
fi
echo -e "${GREEN}✓ Ícone encontrado${NC}"

# Instalar dependências
echo ""
echo -e "${CYAN}📦 Instalando dependências...${NC}"
npm install
if [ $? -ne 0 ]; then
    echo -e "${RED}❌ Erro ao instalar dependências${NC}"
    exit 1
fi

# Compilar frontend
echo ""
echo -e "${CYAN}🔨 Compilando frontend...${NC}"
cd ../frontend
npm run build
if [ $? -ne 0 ]; then
    echo -e "${RED}❌ Erro ao compilar frontend${NC}"
    exit 1
fi
cd ../electron

# Gerar MSI
echo ""
echo -e "${CYAN}📦 Gerando instalador MSI...${NC}"
npm run build-msi
if [ $? -ne 0 ]; then
    echo -e "${RED}❌ Erro ao gerar MSI${NC}"
    exit 1
fi

# Sucesso
echo ""
echo -e "${GREEN}✅ MSI Gerado com Sucesso!${NC}"
echo ""
echo -e "${CYAN}📁 Arquivo criado em:${NC}"
echo -e "${YELLOW}   dist/FinanceApp-1.0.0.msi${NC}"
echo ""
echo -e "${CYAN}🎯 Próximos passos:${NC}"
echo -e "${YELLOW}   1. Duplo clique no MSI para instalar${NC}"
echo -e "${YELLOW}   2. Ou compartilhe o arquivo com usuários${NC}"
echo -e "${YELLOW}   3. Ou faça upload no GitHub Releases${NC}"
echo ""
echo -e "${GREEN}✨ Pronto! Seu FinanceApp está instalável!${NC}"
