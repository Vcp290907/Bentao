package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ordem {
  public ordem(){
    JFrame frame = new JFrame("Ordem de Serviço");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setLayout(null);

    // Adicionando o título
    JLabel titulo = new JLabel("<html><div style='text-align: center; font-size:2em;'>Ordem de Serviço</div></html>", SwingConstants.CENTER);
    titulo.setBounds(0, 10, 400, 30);
    frame.add(titulo);

    // Botões
    JButton BTConsulatar = new JButton("Consultar");
    BTConsulatar.setBounds(80, 150, 110, 40);
    frame.add(BTConsulatar);

    JButton BTCadastrar = new JButton("Cadastrar");
    BTCadastrar.setBounds(210, 150, 110, 40);
    frame.add(BTCadastrar);

    // Evento para voltar à tela principal
    JButton BTVoltar = new JButton("Voltar");
    BTVoltar.setBounds(150, 220, 100, 30);
    frame.add(BTVoltar);

    BTVoltar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose(); // Fecha a janela atual
            index.main(null); // Volta para a tela principal
        }
    });

    // Exibindo a janela
    frame.setLocationRelativeTo(null); // Centralizar a janela
    frame.setVisible(true);
  }
}
