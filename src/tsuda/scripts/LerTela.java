package tsuda.scripts;

import javax.swing.*;
import java.awt.*;
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

public class LerTela extends JFrame implements Log {
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


    //INTERFACE
    @Override
    public void log() throws IOException {
        //--Formata data
        Date data = new Date();
        SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy -- hh:mm");
        String dataFormatada = formatar.format(data);

        //--Criar txt
        String conteudo = "Lista exibida -- " + dataFormatada;

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
}
