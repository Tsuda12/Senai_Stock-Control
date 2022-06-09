package tsuda.scripts;

import javax.swing.*;
import java.util.ArrayList;

public class Ler extends JFrame {
    //VARIÁVEIS
    public ArrayList<Produto> produto_lista = new ArrayList<Produto>();
    private JTextArea txtArea = new JTextArea();


    //CONSTRUTOR
    public Ler(ArrayList<Produto> produto_lista)
    {
        super("Lista de Produtos");

        this.produto_lista = produto_lista;

        setLayout(null);

        txtArea.setBounds(10, 10, 410, 230);
        add(txtArea);

        try{
            for(Produto produto: produto_lista){
                Ler.this.txtArea.append(produto.toString());
                Ler.this.txtArea.append("\n");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(450, 300);
        setVisible(true);
    }
}
