import javax.swing.*;
import java.awt.*;

public class Crepusculo {

    static String nomeJogador = ""; // Armazena o nome do jogador

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> mostrarTelaInicial());
    }

    // Tela inicial para pedir o nome
    public static void mostrarTelaInicial() {
        JFrame inicioFrame = new JFrame("Bem-vindo!");
        inicioFrame.setSize(400, 200);
        inicioFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicioFrame.setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        painel.setBackground(new Color(139, 0, 0));

        JLabel label = new JLabel("Digite seu nome:");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 18));

        JTextField campoNome = new JTextField(20);
        campoNome.setMaximumSize(new Dimension(250, 30));
        campoNome.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton botaoComecar = new JButton("Start");
        botaoComecar.setAlignmentX(Component.CENTER_ALIGNMENT);

        botaoComecar.addActionListener(e -> {
            nomeJogador = campoNome.getText().trim();
            if (!nomeJogador.isEmpty()) {
                inicioFrame.dispose();
                mostrarTelaQuiz();
            } else {
                JOptionPane.showMessageDialog(inicioFrame, "Digite um nome para continuar.");
            }
        });

        painel.add(Box.createVerticalStrut(20));
        painel.add(label);
        painel.add(Box.createVerticalStrut(10));
        painel.add(campoNome);
        painel.add(Box.createVerticalStrut(20));
        painel.add(botaoComecar);

        inicioFrame.add(painel);
        inicioFrame.setVisible(true);
    }

    // Tela do quiz principal
    public static void mostrarTelaQuiz() {
        JFrame frame = new JFrame("Adivinhe o Filme");
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(139, 0, 0));

        ImageIcon cenaIcon = new ImageIcon("crepusculo_cena.jpg");
        JLabel cenaLabel = new JLabel(redimensionarImagem(cenaIcon, 600, 300));
        cenaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel pergunta = new JLabel("De qual filme eh esta cena?");
        pergunta.setForeground(Color.WHITE);
        pergunta.setFont(new Font("Arial", Font.BOLD, 26));
        pergunta.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel opcoesPanel = new JPanel();
        opcoesPanel.setLayout(new FlowLayout());
        opcoesPanel.setBackground(new Color(139, 0, 0));

        adicionarBotaoImagem(opcoesPanel, "crepusculo_capa.jpg", false);
        adicionarBotaoImagem(opcoesPanel, "lua-nova.jpg", false);
        adicionarBotaoImagem(opcoesPanel, "eclipse.jpg", true);

        panel.add(Box.createVerticalStrut(15));
        panel.add(cenaLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(pergunta);
        panel.add(Box.createVerticalStrut(20));
        panel.add(opcoesPanel);

        frame.add(panel);
        frame.setVisible(true);
    }

    // Adiciona botão com imagem
    public static void adicionarBotaoImagem(JPanel painel, String imagemPath, boolean respostaCorreta) {
        ImageIcon icon = new ImageIcon(imagemPath);
        JButton botao = new JButton(redimensionarImagem(icon, 150, 200));
        botao.setBorder(BorderFactory.createEmptyBorder());
        botao.setContentAreaFilled(false);

        botao.addActionListener(e -> {
            if (respostaCorreta) {
                JOptionPane.showMessageDialog(null, "Parabens, " + nomeJogador + "! Voce acertou!");
                mostrarTelaAssassino();
            } else {
                JOptionPane.showMessageDialog(null, "Ops, " + nomeJogador + "! Tente novamente!.");
            }
        });

        painel.add(botao);
    }

    // Redimensiona imagem
    public static ImageIcon redimensionarImagem(ImageIcon icon, int largura, int altura) {
        Image img = icon.getImage().getScaledInstance(largura, altura, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    // Nova tela após acerto
    public static void mostrarTelaAssassino() {
        JFrame frame = new JFrame("Voce foi pega");
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(139, 0, 0));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        ImageIcon icon = new ImageIcon("assassino.jpg");
        JLabel labelImagem = new JLabel(redimensionarImagem(icon, 400, 250));
        labelImagem.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel texto = new JLabel("essa eh a pele de um assassinown "+nomeJogador);
        texto.setForeground(Color.WHITE);
        texto.setFont(new Font("Arial", Font.BOLD, 20));
        texto.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(20));
        panel.add(labelImagem);
        panel.add(Box.createVerticalStrut(20));
        panel.add(texto);

        frame.add(panel);
        frame.setVisible(true);
    }
}
