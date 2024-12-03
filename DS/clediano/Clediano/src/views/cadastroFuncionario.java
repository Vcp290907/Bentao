package views;

import javax.swing.*;

import controllers.FuncionariosController;
import models.Funcionarios;

public class cadastroFuncionario extends JFrame{

  public cadastroFuncionario() {
      JFrame frame = new JFrame("Cadastrar Funcionário");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(400, 400);
      frame.setLayout(null);

      // Título
      JLabel title = new JLabel("Cadastrar Func.", SwingConstants.CENTER);
      title.setBounds(0, 10, 400, 30);
      frame.add(title);

      // Nome
      JLabel nameLabel = new JLabel("Nome:");
      nameLabel.setBounds(20, 50, 100, 25);
      frame.add(nameLabel);

      JTextField nameField = new JTextField();
      nameField.setBounds(120, 50, 200, 25);
      frame.add(nameField);

      // CPF
      JLabel cpfLabel = new JLabel("CPF:");
      cpfLabel.setBounds(20, 90, 100, 25);
      frame.add(cpfLabel);

      JTextField cpfField = new JTextField();
      cpfField.setBounds(120, 90, 200, 25);
      frame.add(cpfField);

      // CEP
      JLabel cepLabel = new JLabel("CEP:");
      cepLabel.setBounds(20, 130, 100, 25);
      frame.add(cepLabel);

      JTextField cepField = new JTextField();
      cepField.setBounds(120, 130, 200, 25);
      frame.add(cepField);

      // Função
      JLabel funcaoLabel = new JLabel("Função:");
      funcaoLabel.setBounds(20, 170, 100, 25);
      frame.add(funcaoLabel);

      JTextField funcaoField = new JTextField();
      funcaoField.setBounds(120, 170, 200, 25);
      frame.add(funcaoField);

      // Salário
      JLabel salarioLabel = new JLabel("Salário:");
      salarioLabel.setBounds(20, 210, 100, 25);
      frame.add(salarioLabel);

      JRadioButton salario1 = new JRadioButton("1500");
      salario1.setBounds(120, 210, 60, 25);
      JRadioButton salario2 = new JRadioButton("2000");
      salario2.setBounds(190, 210, 60, 25);
      JRadioButton salario3 = new JRadioButton("2500");
      salario3.setBounds(260, 210, 60, 25);
      JRadioButton salario4 = new JRadioButton("3000");
      salario4.setBounds(330, 210, 60, 25);

      ButtonGroup salarioGroup = new ButtonGroup();
      salarioGroup.add(salario1);
      salarioGroup.add(salario2);
      salarioGroup.add(salario3);
      salarioGroup.add(salario4);

      frame.add(salario1);
      frame.add(salario2);
      frame.add(salario3);
      frame.add(salario4);

      // Status
      JLabel statusLabel = new JLabel("Status:");
      statusLabel.setBounds(20, 250, 100, 25);
      frame.add(statusLabel);

      String[] statuses = {"Ativado", "Desativado"};
      JComboBox<String> statusComboBox = new JComboBox<>(statuses);
      statusComboBox.setBounds(120, 250, 200, 25);
      frame.add(statusComboBox);

      // Botões
      JButton enviarButton = new JButton("Enviar");
      enviarButton.setBounds(80, 300, 100, 30);
      frame.add(enviarButton);

      JButton cancelarButton = new JButton("Cancelar");
      cancelarButton.setBounds(200, 300, 100, 30);
      frame.add(cancelarButton);

      // Ação dos botões
    enviarButton.addActionListener(e -> {
        try {
            // 1. Capturar os dados dos campos
            String nome = nameField.getText();
            String cpf = cpfField.getText();
            String cep = cepField.getText();
            String funcao = funcaoField.getText();

            // 2. Obter o salário selecionado
            int salario = 0; // Valor padrão caso nenhum seja selecionado
            if (salario1.isSelected()) {
                salario = 1500;
            } else if (salario2.isSelected()) {
                salario = 2000;
            } else if (salario3.isSelected()) {
                salario = 2500;
            } else if (salario4.isSelected()) {
                salario = 3000;
            }

            // 3. Obter o status selecionado
            String status = (String) statusComboBox.getSelectedItem();

            // 4. Criar o objeto Funcionarios
            Funcionarios novoFuncionario = new Funcionarios(nome, cpf, cep, funcao, salario, status);

            // 5. Chamar o método do controlador para salvar o funcionário (você precisará adicionar esse método no seu controlador)
            FuncionariosController controller = new FuncionariosController(); // Ou obter a instância do controlador de outra forma
            controller.cadastrarFuncionario(novoFuncionario);

            // 6. Fechar a janela
            frame.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Erro ao cadastrar funcionário: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    });
      

      cancelarButton.addActionListener(e -> {
          frame.dispose(); // Fecha a tela atual
      });

      // Exibir a janela
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
  }

  public static void main(String[] args) {
      new cadastroFuncionario();
  }
}
