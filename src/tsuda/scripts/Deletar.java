package tsuda.scripts;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Deletar extends JFrame {
    //VARIÁVEIS
    public ArrayList<Produto> produto_lista = new ArrayList<Produto>();

    private JLabel nome = new JLabel("Nome do produto: ");
    private JTextField nomeProduto = new JTextField(100);
    private JButton botaoDeletar = new JButton("DELETAR");


    //CONSTRUTOR
    public Deletar(ArrayList<Produto> produto_lista)
    {
        super("Deletar Produto");

        this.produto_lista = produto_lista;

        setLayout(null);

        nome.setBounds(10, 10, 180, 100);
        add(nome);

        nomeProduto.setBounds(200, 50, 200, 20);
        add(nomeProduto);

        botaoDeletar.setBounds(160, 270, 100, 40);
        add(botaoDeletar);
        botaoDeletar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeP;
                int controle = -1;

                nomeP = nomeProduto.getText();

                for (int i = 0; i < produto_lista.size(); i++) {
                    if (produto_lista.get(i).getNome().equals(nomeP)){
                        produto_lista.remove(i);
                        controle = 1;
                        JOptionPane.showMessageDialog(null, "Produto deletado!");
                    }
                }

                if (controle==-1)
                {
                    JOptionPane.showMessageDialog(null, "Produto não encontrado!");
                }
            }
        });

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(450, 400);
        setVisible(true);
    }
}
