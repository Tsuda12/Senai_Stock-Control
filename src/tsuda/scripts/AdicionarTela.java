package tsuda.scripts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class AdicionarTela extends JFrame implements ActionListener, Log {
    //VARIÁVEIS
    public ArrayList<Produto> produto_lista = new ArrayList<Produto>();

    private JLabel nome = new JLabel("Nome: ");
    private JLabel quantidade = new JLabel("Quantidade: ");
    private JTextField nomeProduto = new JTextField(100);
    private JTextField quantidadeProduto = new JTextField(100);
    private JButton addBotao = new JButton("ADICIONAR");


    //MÉTODOS
    public AdicionarTela(ArrayList<Produto> produto_lista)
    {
        super("Adicionar Produto");

        this.produto_lista = produto_lista;

        setLayout(null);

        //--Icone
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/icone.png")));

        //--Label e JText nome produto
        nome.setBounds(40, 10, 180, 100);
        nome.setFont(new Font("Montserrat", Font.PLAIN, 15));
        nome.setForeground(Color.WHITE);
        add(nome);
        nomeProduto.setBounds(200, 50, 200, 20);
        add(nomeProduto);

        //--Label quantidade produto
        quantidade.setBounds(40, 80, 250, 100);
        quantidade.setFont(new Font("Montserrat", Font.PLAIN, 15));
        quantidade.setForeground(Color.WHITE);
        add(quantidade);
        quantidadeProduto.setBounds(200, 120, 130, 20);
        add(quantidadeProduto);

        //--Botão adicionar
        addBotao.setBounds(145, 190, 150, 40);
        addBotao.setFont(new Font("Montserrat Bold", Font.PLAIN, 15));
        addBotao.setBackground(Color.RED);
        addBotao.setForeground(Color.WHITE);
        addBotao.setFocusPainted(false);
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
                    JOptionPane.showMessageDialog(null, Avisos.ProdutoCadastrado.getValue(), "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    log();
                    dispose();
                }
                catch(NumberFormatException et){
                    quantidadeTrue = false;
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                if(quantidadeTrue == false)
                {
                    JOptionPane.showMessageDialog(null, Avisos.ErroNumero.getValue(), "Erro", JOptionPane.ERROR_MESSAGE);
                    ok=0;
                }

                if (quantidadeTrue == true){
                    for (int i = 0; i < produto_lista.size(); i++) {
                        if(produto_lista.get(i).getNome().equals(nomeP))
                        {
                            JOptionPane.showMessageDialog(null, Avisos.ProdutoExistente.getValue(), "Erro", JOptionPane.ERROR_MESSAGE);
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
        setSize(450, 300);
        setResizable(false);
        getContentPane().setBackground(Color.BLACK);
        setVisible(true);
    }

    //INTERFACE
    @Override
    public void log() throws IOException {
        //--Formata data
        Date data = new Date();
        SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy -- hh:mm");
        String dataFormatada = formatar.format(data);

        //--Criar txt
        String conteudo = "Item adicionado -- " + dataFormatada;

        Path caminho = Paths.get("txt/Log");
        if(Files.exists(caminho)){
            Files.write(caminho, Collections.singleton(conteudo), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        }
        else{
            Files.write(caminho, Collections.singleton(conteudo), StandardCharsets.UTF_8);
        }
    }

    @Override
    public void logC() throws IOException {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
