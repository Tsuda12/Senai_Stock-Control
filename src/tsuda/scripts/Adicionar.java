package tsuda.scripts;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.PrimitiveIterator;

public class Adicionar extends JFrame implements ActionListener {
    //VARIÁVEIS
    public ArrayList<Produto> produto_lista = new ArrayList<Produto>();

    private JLabel nome = new JLabel("Nome: ");
    private JLabel quantidade = new JLabel("Quantidade: ");
    private JTextField nomeProduto = new JTextField(100);
    private JTextField quantidadeProduto = new JTextField(100);
    private JButton addBotao = new JButton("ADICIONAR");


    //MÉTODOS
    public Adicionar(ArrayList<Produto> produto_lista)
    {
        super("Adicionar Produto");

        this.produto_lista = produto_lista;

        setLayout(null);

        //--Label e JText nome produto
        nome.setBounds(10, 10, 180, 100);
        add(nome);
        nomeProduto.setBounds(200, 50, 200, 20);
        add(nomeProduto);

        //--Label quantidade produto
        quantidade.setBounds(10, 80, 250, 100);
        add(quantidade);
        quantidadeProduto.setBounds(270, 120, 130, 20);
        add(quantidadeProduto);

        //--Botão adicionar
        addBotao.setBounds(160, 270, 100, 40);
        add(addBotao);
        addBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeP, quantidadeP;
                int ok = 1;
                boolean quantidadeTrue = true;

                nomeP = nomeProduto.getText();
                quantidadeP = quantidadeProduto.getText();

                try{
                    Double num = Double.parseDouble(quantidadeP);
                }
                catch(NumberFormatException et){
                    quantidadeTrue = false;
                }

                if(quantidadeTrue == false)
                {
                    JOptionPane.showMessageDialog(null, "Digite apenas números!");
                }

                if (quantidadeTrue == true){
                    for (int i = 0; i < produto_lista.size(); i++) {
                        if(produto_lista.get(i).getNome().equals(nomeP))
                        {
                            JOptionPane.showMessageDialog(null, "Este produto já existe!");
                            ok=0;
                        }
                    }
                }

                if(ok==1){
                    produto_lista.add(new Produto(nomeP, quantidadeP));
                }
            }
        });

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(450, 400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
