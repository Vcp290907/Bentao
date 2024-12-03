package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class consultaFuncionarios {
    public consultaFuncionarios() {
        // Criando o JFrame da tela de consulta
        JFrame frame = new JFrame("Consulta de Funcionários");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(null);

        // Título da página
        JLabel titulo = new JLabel("<html><div style='text-align: center; font-size:2em;'>Consulta de Funcionários</div></html>", SwingConstants.CENTER);
        titulo.setBounds(0, 10, 600, 30);
        frame.add(titulo);

        // Tabela para exibir os dados
        String[] colunas = {"Nome", "CPF", "CEP", "Função"};
        DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(30, 50, 540, 150);
        frame.add(scrollPane);

        // Campo para filtro
        JLabel LFiltro = new JLabel("Pesquisar por:");
        LFiltro.setBounds(30, 220, 100, 20);
        frame.add(LFiltro);

        JComboBox<String> comboFiltro = new JComboBox<>(new String[]{"Nome", "CPF", "CEP", "Função"});
        comboFiltro.setBounds(120, 220, 100, 20);
        frame.add(comboFiltro);

        JTextField campoFiltro = new JTextField();
        campoFiltro.setBounds(230, 220, 150, 20);
        frame.add(campoFiltro);

        JButton BTConsulta = new JButton("Consultar");
        BTConsulta.setBounds(400, 220, 100, 20);
        frame.add(BTConsulta);

        // Botões Alterar e Excluir
        JButton BTAlterar = new JButton("Alterar");
        BTAlterar.setBounds(150, 300, 100, 30);
        frame.add(BTAlterar);

        JButton BTExcluir = new JButton("Excluir");
        BTExcluir.setBounds(300, 300, 100, 30);
        frame.add(BTExcluir);

        // Botão Voltar
        JButton BTVoltar = new JButton("Voltar");
        BTVoltar.setBounds(450, 300, 100, 30);
        frame.add(BTVoltar);

        // Eventos dos botões
        BTConsulta.addActionListener(e -> {
            String filtro = (String) comboFiltro.getSelectedItem();
            String valor = campoFiltro.getText();

            // Simulação de busca no "banco de dados"
            modeloTabela.setRowCount(0); // Limpa os resultados anteriores
            if (valor.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Digite um valor para pesquisar!");
            } else {
                JOptionPane.showMessageDialog(frame, "Nenhum funcionário encontrado com " + filtro + " = " + valor);
            }
        });

        BTAlterar.addActionListener(e -> {
            int linhaSelecionada = tabela.getSelectedRow();
            if (linhaSelecionada >= 0) {
                String nomeSelecionado = (String) modeloTabela.getValueAt(linhaSelecionada, 0);
                JOptionPane.showMessageDialog(frame, "Alterar registro do funcionário: " + nomeSelecionado);
            } else {
                JOptionPane.showMessageDialog(frame, "Selecione uma linha para alterar!");
            }
        });

        BTExcluir.addActionListener(e -> {
            int linhaSelecionada = tabela.getSelectedRow();
            if (linhaSelecionada >= 0) {
                String nomeSelecionado = (String) modeloTabela.getValueAt(linhaSelecionada, 0);
                modeloTabela.removeRow(linhaSelecionada);
                JOptionPane.showMessageDialog(frame, "Registro do funcionário " + nomeSelecionado + " excluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(frame, "Selecione uma linha para excluir!");
            }
        });

        BTVoltar.addActionListener(e -> {
            frame.dispose(); // Fecha a tela de consulta
        });

        // Exibindo a janela
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new consultaFuncionarios();
    }
}
