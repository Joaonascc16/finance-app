# Script PowerShell para gerar MSI do FinanceApp
# Uso: .\build-msi.ps1

Write-Host "🚀 FinanceApp MSI Builder" -ForegroundColor Green
Write-Host "=========================" -ForegroundColor Green
Write-Host ""

# Verificar Node.js
Write-Host "✓ Verificando Node.js..." -ForegroundColor Cyan
if (-not (Get-Command node -ErrorAction SilentlyContinue)) {
    Write-Host "❌ Node.js não encontrado! Instale em https://nodejs.org/" -ForegroundColor Red
    exit 1
}
Write-Host "✓ Node.js encontrado: $(node -v)" -ForegroundColor Green

# Verificar npm
Write-Host "✓ Verificando npm..." -ForegroundColor Cyan
if (-not (Get-Command npm -ErrorAction SilentlyContinue)) {
    Write-Host "❌ npm não encontrado!" -ForegroundColor Red
    exit 1
}
Write-Host "✓ npm encontrado: $(npm -v)" -ForegroundColor Green

# Verificar ícone
Write-Host "✓ Verificando ícone..." -ForegroundColor Cyan
if (-not (Test-Path "assets/icon.ico")) {
    Write-Host "❌ Ícone não encontrado em assets/icon.ico" -ForegroundColor Red
    Write-Host "   Crie um ícone .ico e coloque em assets/" -ForegroundColor Yellow
    exit 1
}
Write-Host "✓ Ícone encontrado" -ForegroundColor Green

# Instalar dependências
Write-Host ""
Write-Host "📦 Instalando dependências..." -ForegroundColor Cyan
npm install
if ($LASTEXITCODE -ne 0) {
    Write-Host "❌ Erro ao instalar dependências" -ForegroundColor Red
    exit 1
}

# Compilar frontend
Write-Host ""
Write-Host "🔨 Compilando frontend..." -ForegroundColor Cyan
cd ../frontend
npm run build
if ($LASTEXITCODE -ne 0) {
    Write-Host "❌ Erro ao compilar frontend" -ForegroundColor Red
    exit 1
}
cd ../electron

# Gerar MSI
Write-Host ""
Write-Host "📦 Gerando instalador MSI..." -ForegroundColor Cyan
npm run build-msi
if ($LASTEXITCODE -ne 0) {
    Write-Host "❌ Erro ao gerar MSI" -ForegroundColor Red
    exit 1
}

# Sucesso
Write-Host ""
Write-Host "✅ MSI Gerado com Sucesso!" -ForegroundColor Green
Write-Host ""
Write-Host "📁 Arquivo criado em:" -ForegroundColor Cyan
Write-Host "   dist/FinanceApp-1.0.0.msi" -ForegroundColor Yellow
Write-Host ""
Write-Host "🎯 Próximos passos:" -ForegroundColor Cyan
Write-Host "   1. Duplo clique no MSI para instalar" -ForegroundColor Yellow
Write-Host "   2. Ou compartilhe o arquivo com usuários" -ForegroundColor Yellow
Write-Host "   3. Ou faça upload no GitHub Releases" -ForegroundColor Yellow
Write-Host ""
Write-Host "✨ Pronto! Seu FinanceApp está instalável!" -ForegroundColor Green
