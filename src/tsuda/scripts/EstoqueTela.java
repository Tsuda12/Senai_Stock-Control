package tsuda.scripts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EstoqueTela extends JFrame
{
    //VARIÁVEIS
    public ArrayList<Produto> produtos_lista = new ArrayList<Produto>();

    private JLabel titulo = new JLabel("SELECIONE UMA OPÇÃO");
    private JButton adicionarProduto = new JButton("NOVO PRODUTO");
    private JButton lerProduto = new JButton("EXIBIR PRODUTOS");
    private JButton atualizarProduto = new JButton("ATUALIZAR PRODUTO");
    private JButton deletarProduto = new JButton("DELETAR PRODUTO");


    //CONSTRUTOR
    public EstoqueTela()
    {
        super("Controle de Estoque");

        setLayout(null);

        //--Icone
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/icone.png")));

        //--Titulo
        titulo.setBounds(95, 10, 290, 50);
        titulo.setFont(new Font("Montserrat Bold", Font.PLAIN, 20));
        titulo.setForeground(Color.WHITE);
        add(titulo);

        //--Botão adicionar
        adicionarProduto.setBounds(110, 70, 230, 40);
        adicionarProduto.setFocusPainted(false);
        adicionarProduto.setFont(new Font("Montserrat Bold", Font.PLAIN, 15));
        adicionarProduto.setBackground(Color.RED);
        adicionarProduto.setForeground(Color.WHITE);
        add(adicionarProduto);
        adicionarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //--Chama a tela de adicionar
                AdicionarTela adicionarTela = new AdicionarTela(produtos_lista);
                adicionarTela.setVisible(true);
            }
        });

        //--Botão ler
        lerProduto.setBounds(110, 140, 230, 40);
        lerProduto.setFocusPainted(false);
        lerProduto.setFont(new Font("Montserrat Bold", Font.PLAIN, 15));
        lerProduto.setBackground(Color.RED);
        lerProduto.setForeground(Color.WHITE);
        add(lerProduto);
        lerProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //--Checa se a lista está vazia para ler
                if(produtos_lista.isEmpty()==true){
                    JOptionPane.showMessageDialog(null, "Sem itens cadastrados!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    //--Chama a janela ler
                    LerTela lerTela = new LerTela(produtos_lista);
                    lerTela.setVisible(true);
                }
            }
        });

        //--Botão atualizar
        atualizarProduto.setBounds(110, 210, 230, 40);
        atualizarProduto.setFocusPainted(false);
        atualizarProduto.setFont(new Font("Montserrat Bold", Font.PLAIN, 15));
        atualizarProduto.setBackground(Color.RED);
        atualizarProduto.setForeground(Color.WHITE);
        add(atualizarProduto);
        atualizarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //--Checa se a lista está vazia
                if (produtos_lista.isEmpty()==true){
                    JOptionPane.showMessageDialog(null, "Sem itens cadastrados!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    //--Chamar a janela atualuzar
                    AtualizarTela atualizarTela = new AtualizarTela(produtos_lista);
                    atualizarTela.setVisible(true);
                }
            }
        });

        //--Botão deletar
        deletarProduto.setBounds(110, 280, 230, 40);
        deletarProduto.setFocusPainted(false);
        deletarProduto.setFont(new Font("Montserrat Bold", Font.PLAIN, 15));
        deletarProduto.setBackground(Color.RED);
        deletarProduto.setForeground(Color.WHITE);
        add(deletarProduto);
        deletarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //--Checa se a lista está vazia
                if(produtos_lista.isEmpty()==true)
                {
                    JOptionPane.showMessageDialog(null, "Sem itens cadastrados!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    //--Chama a janela deletar
                    DeletarTela deletarTela = new DeletarTela(produtos_lista);
                    deletarTela.setVisible(true);
                }
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 400);
        setResizable(false);
        getContentPane().setBackground(Color.BLACK);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
