import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.*;

public class Crepusculo {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Adivinhe o Filme");
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(139, 0, 0));

        // Cena principal
        ImageIcon cenaIcon = new ImageIcon("crepusculo_cena.jpg");
        JLabel cenaLabel = new JLabel(redimensionarImagem(cenaIcon, 600, 300));
        cenaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel pergunta = new JLabel("De qual filme eh esta cena?");
        pergunta.setForeground(Color.WHITE);
        pergunta.setFont(new Font("Arial", Font.BOLD, 26));
        pergunta.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Painel com opções (capas dos filmes)
        JPanel opcoesPanel = new JPanel();
        opcoesPanel.setLayout(new FlowLayout());
        opcoesPanel.setBackground(new Color(139, 0, 0));

        // Botões com imagens
        adicionarBotaoImagem(opcoesPanel, "crepusculo_capa.jpg", false);
        adicionarBotaoImagem(opcoesPanel, "lua-nova.jpg", false);
        adicionarBotaoImagem(opcoesPanel, "eclipse.jpg", true);

        // Adicionando ao painel principal
        panel.add(Box.createVerticalStrut(15));
        panel.add(cenaLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(pergunta);
        panel.add(Box.createVerticalStrut(20));
        panel.add(opcoesPanel);

        frame.add(panel);
        frame.setVisible(true);
    }

    // Método para adicionar botão com imagem
    public static void adicionarBotaoImagem(JPanel painel, String imagemPath, boolean respostaCorreta) {
        ImageIcon icon = new ImageIcon(imagemPath);
        JButton botao = new JButton(redimensionarImagem(icon, 150, 200));
        botao.setBorder(BorderFactory.createEmptyBorder());
        botao.setContentAreaFilled(false);

        botao.addActionListener(e -> {
            if (respostaCorreta) {
                JOptionPane.showMessageDialog(null, "Acertou! Eh eclipse!");
            } else {
                JOptionPane.showMessageDialog(null, "Errado! Tente novamente.");
            }
        });

        painel.add(botao);
    }

    // Método para redimensionar imagem
    public static ImageIcon redimensionarImagem(ImageIcon icon, int largura, int altura) {
        Image img = icon.getImage().getScaledInstance(largura, altura, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

}
