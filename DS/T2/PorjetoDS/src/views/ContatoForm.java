package views;

import models.Contato;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContatoForm extends JDialog {
    private JTextField nomeField;
    private JTextField emailField;
    private JTextField telefoneField;
    private JButton salvarButton;
    private JButton cancelarButton;

    private Contato contato;
    private boolean isEditMode;

  public ContatoForm(Frame parent, String title) {
    super(parent, title, true);
    this.isEditMode = false;
    initializeComponents();
  }

  public ContatoForm(Frame parent, String title, Contato contato) {
    super(parent, title, true);
    this.contato = contato;
    this.isEditMode = true;
    initializeComponents();
    preencherCampos();
  }
  private void preencherCampos() {
    if (contato != null) {
        nomeField.setText(contato.getNome());
        emailField.setText(contato.getEmail());
        telefoneField.setText(contato.getTelefone());
    }
  }
  
  private boolean validarCampos() {
    if (nomeField.getText().trim().isEmpty() || emailField.getText().trim().isEmpty()) {
      JOptionPane.showMessageDialog(
        this,
        "Nome e Email são obrigatórios.",
        "Erro", JOptionPane.ERROR_MESSAGE
      );
      return false;
    }
    return true;
  }
  
  private void adicionarContato() {
    contato = new Contato(
      nomeField.getText().trim(),
      emailField.getText().trim(),
      telefoneField.getText().trim()
    );
  }
  
  private void atualizarContato() {
    if (contato != null) {
      contato.setNome(nomeField.getText().trim());
      contato.setEmail(emailField.getText().trim());
      contato.setTelefone(telefoneField.getText().trim());
    }
  }
  
  public Contato getContato() {
    return contato;
  }
  
}
