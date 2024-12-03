package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class index {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("MC QUEEN");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        // Criação da tela principal de opções
        // Nota: java entende HTML pra texto
        JLabel titulo = new JLabel("MC QUEEN", SwingConstants.CENTER);
        JLabel cabecalho = new JLabel("<html><div style='text-align: center;'>Seja bem-vindo à fábrica<br>Escolha a opção</div></html>", SwingConstants.CENTER);
        JButton BTFuncionarios = new JButton("Funcionários");
        JButton BTOrdem = new JButton("Ord. de Serviço");

        titulo.setBounds(0, 10, 400, 30);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(titulo);

        cabecalho.setBounds(50, 50, 300, 50);
        cabecalho.setFont(new Font("Arial", Font.PLAIN, 16));
        frame.add(cabecalho);

        // Criando os botões
        BTFuncionarios.setBounds(20, 150, 150, 40);
        frame.add(BTFuncionarios);

        BTOrdem.setBounds(210, 150, 150, 40);
        frame.add(BTOrdem);

        // Adicionando eventos nos botões
        BTFuncionarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Fecha a janela atual
                new funcionarios(); // Abre a nova tela
            }
        });

        BTOrdem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Fecha a janela atual
                new ordem(); // Abre a nova tela
            }
        });

        // Deixando a janela visível
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
