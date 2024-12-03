package controllers;

import javax.swing.*;
import java.util.List;

import models.Funcionarios;
import repository.funcionariosRepository;
import views.cadastroFuncionario;
import views.consultaFuncionarios;

public class FuncionariosController {
    private final funcionariosRepository repositorio;
    private final consultaFuncionarios tableView;

    public FuncionariosController() {
        repositorio = new funcionariosRepository();
        tableView = new consultaFuncionarios();
        inicializar();
    }

    public void inicializar() {
        atualizarTabela();
        tableView.setVisible(true);
    }

    public void atualizarTabela() {
        List<Funcionarios> func = repositorio.todosFuncionarios();
        tableView.atualizarTabela(func);
    }

    public void editarFuncionario() {
        int selectedCodigo = tableView.getSelectedFuncionarioCodigo(); 
        if (selectedCodigo != -1) {
            Funcionarios funcionario = repositorio.obterFuncionarioPorCodigo(selectedCodigo);
            if (funcionario != null) {
                cadastroFuncionario cadastro = new cadastroFuncionario(tableView, "Editar Funcionário", funcionario);
                cadastro.setVisible(true);
                Funcionarios funcionarioAtualizado = cadastro.getFuncionario();
                if (funcionarioAtualizado != null) {
                    funcionarioAtualizado.setCodigo(selectedCodigo);
                    repositorio.atualizarFuncionario(funcionarioAtualizado); // Corrigido para repositorio
                    atualizarTabela();
                }
            } else {
                JOptionPane.showMessageDialog(tableView, "Funcionário não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(tableView, "Selecione um funcionário para editar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void deletarFuncionario() {
        int selectedCodigo = tableView.getSelectedFuncionarioCodigo();
        if (selectedCodigo != -1) {
            int confirm = JOptionPane.showConfirmDialog(
                    tableView,
                    "Tem certeza que deseja deletar este funcionário?",
                    "Confirmar deletação",
                    JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                repositorio.deletarFuncionario(selectedCodigo); // Corrigido para repositorio
                atualizarTabela();
            }
        } else {
            JOptionPane.showMessageDialog(tableView, "Selecione um funcionário para deletar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void cadastrarFuncionario(Funcionarios novoFuncionario) {
        try {
            repositorio.cadastroFuncionario(novoFuncionario);
            atualizarTabela(); 
            JOptionPane.showMessageDialog(tableView, "Funcionário cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(tableView, "Erro ao cadastrar funcionário: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}