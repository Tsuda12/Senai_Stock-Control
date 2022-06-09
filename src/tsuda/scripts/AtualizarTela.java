package tsuda.scripts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AtualizarTela extends JFrame{
    //VARIÁVEIS
    public ArrayList<Produto> produto_lista = new ArrayList<Produto>();

    private JLabel nome = new JLabel("Nome do produto: ");
    private JTextField nomeProduto = new JTextField(100);
    private JLabel quantidade = new JLabel("Quantidade: ");
    private JTextField quantidadeProduto = new JTextField(100);
    private JButton botaoAtualizar = new JButton("ATUALIZAR");


    //CONSTRUTOR
    public AtualizarTela(ArrayList<Produto> produto_lista){
        super("Atualizar Produto");

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

        quantidade.setBounds(40, 80, 250, 100);
        quantidade.setFont(new Font("Montserrat", Font.PLAIN, 15));
        quantidade.setForeground(Color.WHITE);
        add(quantidade);
        quantidadeProduto.setBounds(200, 120, 130, 20);
        add(quantidadeProduto);

        botaoAtualizar.setBounds(145, 190, 150, 40);
        botaoAtualizar.setFont(new Font("Montserrat Bold", Font.PLAIN, 15));
        botaoAtualizar.setBackground(Color.RED);
        botaoAtualizar.setForeground(Color.WHITE);
        botaoAtualizar.setFocusPainted(false);
        add(botaoAtualizar);
        botaoAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeP, quantidadeP;
                int controle = -1;
                boolean quantidade = true;

                nomeP = nomeProduto.getText();
                quantidadeP = quantidadeProduto.getText();

                try{
                    Double num = Double.parseDouble(quantidadeP);
                }
                catch (NumberFormatException et) {
                    quantidade = false;
                }

                if (quantidade==false){
                    JOptionPane.showMessageDialog(null, "Digite um número!", "Erro", JOptionPane.ERROR_MESSAGE);
                }

                if (quantidade==true){
                    for (int i = 0; i < produto_lista.size(); i++) {
                        if (produto_lista.get(i).getNome().equals(nomeP)){
                            produto_lista.get(i).setQuantidade(quantidadeP);
                            controle = 1;
                            JOptionPane.showMessageDialog(null, "Produto alterado!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                            dispose();
                        }
                    }
                    if (controle==-1){
                        JOptionPane.showMessageDialog(null, "Nenhum produto encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(450, 300);
        setResizable(false);
        getContentPane().setBackground(Color.BLACK);
        setVisible(true);
    }
}
