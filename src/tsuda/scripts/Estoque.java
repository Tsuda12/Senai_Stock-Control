package tsuda.scripts;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        adicionarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //--Chama a tela de adicionar
                Adicionar adicionarTela = new Adicionar(produtos_lista);
                adicionarTela.setVisible(true);
            }
        });

        //--Botão ler
        lerProduto.setBounds(150, 70, 230, 40);
        add(lerProduto);
        lerProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //--Checa se a lista está vazia para ler
                if(produtos_lista.isEmpty()==true){
                    JOptionPane.showMessageDialog(null, "Sem itens cadastrados!");
                }
                else{
                    //--Chama a janela ler
                    Ler lerTela = new Ler(produtos_lista);
                    lerTela.setVisible(true);
                }
            }
        });

        //--Botão atualizar
        atualizarProduto.setBounds(150, 70, 230, 40);
        add(atualizarProduto);
        atualizarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //--Checa se a lista está vazia
                if (produtos_lista.isEmpty()==true){
                    JOptionPane.showMessageDialog(null, "Sem itens cadastrados!");
                }
                else{
                    //--Chamar a janela atualuzar
                    Atualizar atualizarTela = new Atualizar(produtos_lista);
                    atualizarTela.setVisible(true);
                }
            }
        });

        //--Botão deletar
        deletarProduto.setBounds(150, 70, 230, 40);
        add(deletarProduto);
        deletarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //--Checa se a lista está vazia
                if(produtos_lista.isEmpty()==true)
                {
                    JOptionPane.showMessageDialog(null, "Sem itens cadastrados!");
                }
                else {
                    //--Chama a janela deletar
                    Deletar deletarTela = new Deletar(produtos_lista);
                    deletarTela.setVisible(true);
                }
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 400);
        setVisible(true);
    }
}
