import { create } from 'zustand';
import axios from 'axios';

const API_URL = '/api';

export const useFinanceStore = create((set, get) => ({
  // Estado
  transactions: [],
  categories: [],
  loading: false,
  error: null,
  darkMode: localStorage.getItem('darkMode') === 'true',
  selectedMonth: new Date().getMonth(),
  selectedYear: new Date().getFullYear(),

  // Ações
  setDarkMode: (isDark) => {
    set({ darkMode: isDark });
    localStorage.setItem('darkMode', isDark);
    if (isDark) {
      document.body.classList.add('dark-mode');
    } else {
      document.body.classList.remove('dark-mode');
    }
  },

  setSelectedMonth: (month) => set({ selectedMonth: month }),
  setSelectedYear: (year) => set({ selectedYear: year }),

  // Transações
  fetchTransactions: async () => {
    set({ loading: true, error: null });
    try {
      const response = await axios.get(`${API_URL}/transactions`);
      set({ transactions: response.data, loading: false });
    } catch (error) {
      set({ error: error.message, loading: false });
    }
  },

  addTransaction: async (transaction) => {
    set({ loading: true, error: null });
    try {
      const response = await axios.post(`${API_URL}/transactions`, transaction);
      set((state) => ({
        transactions: [response.data, ...state.transactions],
        loading: false,
      }));
      return response.data;
    } catch (error) {
      set({ error: error.message, loading: false });
      throw error;
    }
  },

  updateTransaction: async (id, transaction) => {
    set({ loading: true, error: null });
    try {
      const response = await axios.put(`${API_URL}/transactions/${id}`, transaction);
      set((state) => ({
        transactions: state.transactions.map((t) => (t.id === id ? response.data : t)),
        loading: false,
      }));
      return response.data;
    } catch (error) {
      set({ error: error.message, loading: false });
      throw error;
    }
  },

  deleteTransaction: async (id) => {
    set({ loading: true, error: null });
    try {
      await axios.delete(`${API_URL}/transactions/${id}`);
      set((state) => ({
        transactions: state.transactions.filter((t) => t.id !== id),
        loading: false,
      }));
    } catch (error) {
      set({ error: error.message, loading: false });
      throw error;
    }
  },

  // Categorias
  fetchCategories: async () => {
    set({ loading: true, error: null });
    try {
      const response = await axios.get(`${API_URL}/categories`);
      set({ categories: response.data, loading: false });
    } catch (error) {
      set({ error: error.message, loading: false });
    }
  },

  // Helpers
  getTransactionsByMonth: (month, year, type = null) => {
    const { transactions } = get();
    return transactions.filter((tx) => {
      const d = new Date(tx.date);
      const matchMonth = d.getMonth() === month && d.getFullYear() === year;
      const matchType = type ? tx.type === type : true;
      return matchMonth && matchType;
    });
  },

  getMonthSummary: (month, year) => {
    const txs = get().getTransactionsByMonth(month, year);
    const totalIncome = txs
      .filter((t) => t.type === 'income')
      .reduce((s, t) => s + t.amount, 0);
    const totalExpense = txs
      .filter((t) => t.type === 'expense')
      .reduce((s, t) => s + t.amount, 0);
    return {
      month,
      year,
      totalIncome,
      totalExpense,
      balance: totalIncome - totalExpense,
    };
  },

  getTotalBalance: () => {
    const { transactions } = get();
    return transactions.reduce((sum, tx) => {
      return tx.type === 'income' ? sum + tx.amount : sum - tx.amount;
    }, 0);
  },

  getCategoryById: (id) => {
    const { categories } = get();
    return categories.find((c) => c.id === id);
  },
}));
