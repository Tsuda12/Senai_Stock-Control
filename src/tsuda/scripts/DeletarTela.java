package tsuda.scripts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeletarTela extends JFrame {
    //VARIÁVEIS
    public ArrayList<Produto> produto_lista = new ArrayList<Produto>();

    private JLabel nome = new JLabel("Nome do produto: ");
    private JTextField nomeProduto = new JTextField(100);
    private JButton botaoDeletar = new JButton("DELETAR");


    //CONSTRUTOR
    public DeletarTela(ArrayList<Produto> produto_lista)
    {
        super("Deletar Produto");

        this.produto_lista = produto_lista;

        setLayout(null);

        //--Icone
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/icone.png")));

        nome.setBounds(40, 10, 180, 100);
        nome.setFont(new Font("Montserrat", Font.PLAIN, 15));
        nome.setForeground(Color.WHITE);
        add(nome);

        nomeProduto.setBounds(200, 50, 200, 20);
        add(nomeProduto);

        botaoDeletar.setBounds(160, 120, 120, 40);
        botaoDeletar.setFont(new Font("Montserrat Bold", Font.PLAIN, 15));
        botaoDeletar.setBackground(Color.RED);
        botaoDeletar.setForeground(Color.WHITE);
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
                        JOptionPane.showMessageDialog(null, "Produto deletado!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    }
                }

                if (controle==-1)
                {
                    JOptionPane.showMessageDialog(null, "Produto não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(450, 250);
        setResizable(false);
        getContentPane().setBackground(Color.BLACK);
        setVisible(true);
    }
}
