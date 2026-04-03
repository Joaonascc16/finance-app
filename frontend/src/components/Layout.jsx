import React from 'react';
import { Link, useLocation } from 'react-router-dom';
import { useFinanceStore } from '../store/financeStore';
import { Home, List, BarChart3, Settings, Moon, Sun } from 'lucide-react';
import './Layout.css';

export function Layout({ children }) {
  const { darkMode, setDarkMode } = useFinanceStore();
  const location = useLocation();

  React.useEffect(() => {
    if (darkMode) {
      document.body.classList.add('dark-mode');
    } else {
      document.body.classList.remove('dark-mode');
    }
  }, [darkMode]);

  const isActive = (path) => location.pathname === path;

  return (
    <div className="layout">
      {/* Sidebar */}
      <aside className="sidebar">
        <div className="sidebar-header">
          <div className="logo">
            <span className="logo-icon">💰</span>
            <span className="logo-text">FinanceApp</span>
          </div>
        </div>

        <nav className="sidebar-nav">
          <Link to="/" className={`nav-item ${isActive('/') ? 'active' : ''}`}>
            <Home size={20} />
            <span>Início</span>
          </Link>
          <Link to="/transactions" className={`nav-item ${isActive('/transactions') ? 'active' : ''}`}>
            <List size={20} />
            <span>Transações</span>
          </Link>
          <Link to="/reports" className={`nav-item ${isActive('/reports') ? 'active' : ''}`}>
            <BarChart3 size={20} />
            <span>Relatórios</span>
          </Link>
          <Link to="/settings" className={`nav-item ${isActive('/settings') ? 'active' : ''}`}>
            <Settings size={20} />
            <span>Configurações</span>
          </Link>
        </nav>

        <div className="sidebar-footer">
          <button
            className="theme-toggle"
            onClick={() => setDarkMode(!darkMode)}
            title={darkMode ? 'Modo claro' : 'Modo escuro'}
          >
            {darkMode ? <Sun size={20} /> : <Moon size={20} />}
          </button>
        </div>
      </aside>

      {/* Main Content */}
      <main className="main-content">
        <div className="content-wrapper">
          {children}
        </div>
      </main>
    </div>
  );
}
