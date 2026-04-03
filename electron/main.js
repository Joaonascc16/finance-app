const { app, BrowserWindow, Menu, ipcMain } = require('electron');
const path = require('path');
const isDev = require('electron-is-dev');

let mainWindow;

function createWindow() {
  mainWindow = new BrowserWindow({
    width: 1400,
    height: 900,
    minWidth: 800,
    minHeight: 600,
    webPreferences: {
      preload: path.join(__dirname, 'preload.js'),
      nodeIntegration: false,
      contextIsolation: true,
      enableRemoteModule: false,
    },
    icon: path.join(__dirname, 'assets/icon.png'),
  });

  const startUrl = isDev
    ? 'http://localhost:3000'
    : `file://${path.join(__dirname, '../build/index.html')}`;

  mainWindow.loadURL(startUrl);

  if (isDev) {
    mainWindow.webContents.openDevTools();
  }

  mainWindow.on('closed', () => {
    mainWindow = null;
  });
}

app.on('ready', createWindow);

app.on('window-all-closed', () => {
  if (process.platform !== 'darwin') {
    app.quit();
  }
});

app.on('activate', () => {
  if (mainWindow === null) {
    createWindow();
  }
});

// Menu
const template = [
  {
    label: 'Arquivo',
    submenu: [
      {
        label: 'Sair',
        accelerator: 'CmdOrCtrl+Q',
        click: () => {
          app.quit();
        },
      },
    ],
  },
  {
    label: 'Editar',
    submenu: [
      { label: 'Desfazer', accelerator: 'CmdOrCtrl+Z', selector: 'undo:' },
      { label: 'Refazer', accelerator: 'Shift+CmdOrCtrl+Z', selector: 'redo:' },
      { type: 'separator' },
      { label: 'Cortar', accelerator: 'CmdOrCtrl+X', selector: 'cut:' },
      { label: 'Copiar', accelerator: 'CmdOrCtrl+C', selector: 'copy:' },
      { label: 'Colar', accelerator: 'CmdOrCtrl+V', selector: 'paste:' },
    ],
  },
  {
    label: 'Visualizar',
    submenu: [
      {
        label: 'Recarregar',
        accelerator: 'CmdOrCtrl+R',
        click: () => {
          if (mainWindow) mainWindow.reload();
        },
      },
      {
        label: 'Ferramentas do Desenvolvedor',
        accelerator: 'CmdOrCtrl+Shift+I',
        click: () => {
          if (mainWindow) mainWindow.webContents.toggleDevTools();
        },
      },
    ],
  },
  {
    label: 'Ajuda',
    submenu: [
      {
        label: 'Sobre FinanceApp',
        click: () => {
          // Implementar dialog de sobre
        },
      },
    ],
  },
];

const menu = Menu.buildFromTemplate(template);
Menu.setApplicationMenu(menu);

// IPC Handlers
ipcMain.handle('get-app-version', () => {
  return app.getVersion();
});

ipcMain.handle('get-app-path', () => {
  return app.getAppPath();
});
