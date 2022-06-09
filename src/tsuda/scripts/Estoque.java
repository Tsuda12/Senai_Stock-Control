package tsuda.scripts;

import javax.swing.*;
import java.util.ArrayList;

public class Estoque extends JFrame
{
    //VARIÁVEIS
    public ArrayList<Produto> produtos_lista = new ArrayList<Produto>();

    private JLabel titulo = new JLabel("SELECIONE UMA OPÇÃO");
    private JButton adicionarProduto = new JButton("NOVO PRODUTO");
    private JButton lerProduto = new JButton("EXIBIR PRODUTOS");
    private JButton atualizarProduto = new JButton("ATUALIZAR PRODUTO");
    private JButton deletarProduto = new JButton("DELETAR PRODUTO");


    //CONSTRUTOR
    public Estoque()
    {
        super("Controle de Estoque");

        setLayout(null);

        //--Titulo
        titulo.setBounds(160, 15, 250, 50);
        add(titulo);

        //--Botão adicionar
        adicionarProduto.setBounds(150, 70, 230, 40);
        add(adicionarProduto);
        adicionarProduto.addActionListener(new AddProduto());

        //--Botão ler
        lerProduto.setBounds(150, 70, 230, 40);
        add(lerProduto);
        lerProduto.addActionListener(new ReadProduto());

        //--Botão atualizar
        atualizarProduto.setBounds(150, 70, 230, 40);
        add(atualizarProduto);
        atualizarProduto.addActionListener(new UpdateProduto());

        //--Botão deletar
        deletarProduto.setBounds(150, 70, 230, 40);
        add(deletarProduto);
        deletarProduto.addActionListener(new DeleteProduto());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 400);
        setVisible(true);
    }
}
