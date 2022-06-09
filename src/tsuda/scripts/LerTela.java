package tsuda.scripts;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LerTela extends JFrame {
    //VARIÁVEIS
    public ArrayList<Produto> produto_lista = new ArrayList<Produto>();
    private JTextArea txtArea = new JTextArea();


    //CONSTRUTOR
    public LerTela(ArrayList<Produto> produto_lista)
    {
        super("Lista de Produtos");

        this.produto_lista = produto_lista;

        setLayout(null);

        //--Icone
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/icone.png")));

        txtArea.setBounds(10, 10, 410, 230);
        txtArea.setBackground(Color.WHITE);
        txtArea.setFont(new Font("Arial", Font.PLAIN, 12));
        add(txtArea);

        try{
            for(Produto produto: produto_lista){
                LerTela.this.txtArea.append(produto.toString());
                LerTela.this.txtArea.append("\n--------------------------------------------------------------------\n");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(450, 300);
        setResizable(false);
        getContentPane().setBackground(Color.BLACK);
        setVisible(true);
    }
}
