import React, { useEffect, useState } from 'react';
import { useFinanceStore } from '../store/financeStore';
import { Plus, TrendingUp, TrendingDown, DollarSign } from 'lucide-react';
import { useNavigate } from 'react-router-dom';
import './Home.css';

export function Home() {
  const navigate = useNavigate();
  const {
    transactions,
    selectedMonth,
    selectedYear,
    getMonthSummary,
    getTotalBalance,
    getCategoryById,
    fetchTransactions,
  } = useFinanceStore();

  useEffect(() => {
    fetchTransactions();
  }, []);

  const summary = getMonthSummary(selectedMonth, selectedYear);
  const totalBalance = getTotalBalance();
  const recentTxs = transactions.slice(0, 10);

  const monthNames = [
    'Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho',
    'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'
  ];

  const formatCurrency = (value) => {
    return new Intl.NumberFormat('pt-BR', {
      style: 'currency',
      currency: 'BRL',
    }).format(value);
  };

  const formatDate = (dateStr) => {
    return new Date(dateStr).toLocaleDateString('pt-BR');
  };

  return (
    <div className="home">
      <div className="home-header">
        <div>
          <h1>Bem-vindo de volta! 👋</h1>
          <p>{monthNames[selectedMonth]} {selectedYear}</p>
        </div>
        <button className="btn-primary" onClick={() => navigate('/transactions/new')}>
          <Plus size={20} />
          Nova Transação
        </button>
      </div>

      {/* Balance Card */}
      <div className="balance-card">
        <div className="balance-content">
          <h2>Saldo Total</h2>
          <div className="balance-amount" style={{
            color: totalBalance >= 0 ? 'var(--success)' : 'var(--error)'
          }}>
            {formatCurrency(totalBalance)}
          </div>
        </div>
        <div className="balance-icon">
          <DollarSign size={48} />
        </div>
      </div>

      {/* Summary Cards */}
      <div className="summary-grid">
        <div className="summary-card income">
          <div className="summary-icon">
            <TrendingUp size={24} />
          </div>
          <div className="summary-content">
            <h3>Receitas</h3>
            <p>{formatCurrency(summary.totalIncome)}</p>
          </div>
        </div>
        <div className="summary-card expense">
          <div className="summary-icon">
            <TrendingDown size={24} />
          </div>
          <div className="summary-content">
            <h3>Despesas</h3>
            <p>{formatCurrency(summary.totalExpense)}</p>
          </div>
        </div>
        <div className="summary-card balance">
          <div className="summary-icon">
            <DollarSign size={24} />
          </div>
          <div className="summary-content">
            <h3>Saldo do Mês</h3>
            <p style={{
              color: summary.balance >= 0 ? 'var(--success)' : 'var(--error)'
            }}>
              {formatCurrency(summary.balance)}
            </p>
          </div>
        </div>
      </div>

      {/* Recent Transactions */}
      <div className="recent-transactions">
        <div className="section-header">
          <h2>Últimas Transações</h2>
          <button className="link-btn" onClick={() => navigate('/transactions')}>
            Ver todas →
          </button>
        </div>

        {recentTxs.length === 0 ? (
          <div className="empty-state">
            <p>Nenhuma transação registrada</p>
            <button className="btn-secondary" onClick={() => navigate('/transactions/new')}>
              Adicionar primeira transação
            </button>
          </div>
        ) : (
          <div className="transactions-table">
            <table>
              <thead>
                <tr>
                  <th>Descrição</th>
                  <th>Categoria</th>
                  <th>Data</th>
                  <th>Valor</th>
                </tr>
              </thead>
              <tbody>
                {recentTxs.map((tx) => {
                  const category = getCategoryById(tx.categoryId);
                  return (
                    <tr key={tx.id} onClick={() => navigate(`/transactions/${tx.id}`)}>
                      <td>{tx.description || 'Sem descrição'}</td>
                      <td>
                        <span className="category-badge">
                          {category?.icon} {category?.name}
                        </span>
                      </td>
                      <td>{formatDate(tx.date)}</td>
                      <td className={tx.type === 'income' ? 'income-text' : 'expense-text'}>
                        {tx.type === 'income' ? '+' : '-'}{formatCurrency(tx.amount)}
                      </td>
                    </tr>
                  );
                })}
              </tbody>
            </table>
          </div>
        )}
      </div>
    </div>
  );
}
