package project.view;

import project.model.Jogo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Janela extends JFrame{
    private JButton butEnviar, butSort;
    private JTextField textPalavra;
    private JLabel labelPalavra, labelTexto1, labelTexto2;

    public Janela(){
        super("Acerte a Palavra");
        setLayout(new FlowLayout());

        Jogo jogo = new Jogo();

        labelPalavra = new JLabel(jogo.embaralhar());
        add(labelPalavra);

        labelTexto1 = new JLabel("Que palavra é essa?");
        add(labelTexto1);

        labelTexto2 = new JLabel("Digite seu palpite: ");
        add(labelTexto2);

        textPalavra = new JTextField(20);
        add(textPalavra);

        butEnviar = new JButton("Enviar");
        butEnviar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String palpite = textPalavra.getText();

                        if(!palpite.equalsIgnoreCase(jogo.busca(palpite))){
                            JOptionPane.showMessageDialog(null, "Você errou, tente novamente");
                        }else{
                            JOptionPane.showMessageDialog(null, "Parabéns, você acertou a palavra");
                        }
                    }
                }
        );
        add(butEnviar);

        butSort = new JButton("Sortear nova palavra");
        butSort.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        labelPalavra.setText(jogo.embaralhar());
                    }
                }
        );
        add(butSort);

        setSize(500,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }
}
