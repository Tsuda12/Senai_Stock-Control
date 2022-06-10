package tsuda.scripts;

import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Notepad implements Log
{
    //VARIÁVEIS
    File arquivo = new File("txt");
    int ln;
    String Usuario, Senha;


    //CONSTRUTOR
    public Notepad(){}


    //MÉTODOS
    public void criarPasta(){
        if (!arquivo.exists()){
            arquivo.mkdirs();
        }
    }

    public void lerArquivo(){
        try{
            FileReader fr = new FileReader(arquivo + "\\Usuarios.txt");
            System.err.println("Arquivo existente");
        }
        catch (FileNotFoundException ex){
            try{
                FileWriter fw = new FileWriter(arquivo + "\\Usuarios.txt");
                System.out.println("Arquivo criado");
            }
            catch (IOException ex1){
                Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    public void addRegistro(String usuario, String senha){
        try{
            RandomAccessFile raf = new RandomAccessFile(arquivo + "\\Usuarios.txt", "rw");

            for (int i = 0; i < ln; i++) {
                raf.readLine();
            }

            if(ln > 0){
                raf.writeBytes("\r\n");
                raf.writeBytes("\r\n");
            }
            raf.writeBytes("Usuário:" + usuario + "\r\n");
            raf.writeBytes("Senha:" + senha + "\r\n");
            logC();
        }
        catch (FileNotFoundException ex){
            Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException io){
            Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, io);
        }
    }

    public void contarLinhas(){
        try {
            ln = 0;
            RandomAccessFile raf = new RandomAccessFile(arquivo + "\\Usuarios.txt", "rw");

            for (int i = 0; raf.readLine() != null; i++) {
                ln++;
            }

            System.out.println(ln);

        } catch (FileNotFoundException e) {
            Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void logica(String usuario, String senha){
        try {
            RandomAccessFile raf = new RandomAccessFile(arquivo + "\\Usuarios.txt", "rw");

            for (int i = 0; i < ln; i+=3) {
                String forUsuario = raf.readLine().substring(8);
                String forSenha = raf.readLine().substring(6);

                if(usuario.equals(forUsuario) & senha.equals(forSenha)){
                    JOptionPane.showMessageDialog(null, Avisos.SenhaAceita.getValue(), "Login", JOptionPane.INFORMATION_MESSAGE);
                    EstoqueTela estoqueTela = new EstoqueTela();
                    log();
                    break;
                }
                else if(i==ln-2){
                    JOptionPane.showMessageDialog(null, Avisos.ErroLogin.getValue(), "Login", JOptionPane.ERROR_MESSAGE);
                    break;
                }

                for (int k = 1; k <= 2 ; k++) {
                    raf.readLine();
                }
            }
            
        } catch (FileNotFoundException e) {
            Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException ex){
            Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    //INTERFACE
    @Override
    public void log() throws IOException {
        //--Formata data
        Date data = new Date();
        SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy -- hh:mm");
        String dataFormatada = formatar.format(data);

        //--Criar txt
        String conteudo = "Login efetuado -- " + dataFormatada;

        Path caminho = Paths.get("txt/Log");
        if(Files.exists(caminho)){
            Files.write(caminho, Collections.singleton(conteudo), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        }
        else{
            Files.write(caminho, Collections.singleton(conteudo), StandardCharsets.UTF_8);
        }
    }


    //INTERFACE
    @Override
    public void logC() throws IOException {
        //--Formata data
        Date data = new Date();
        SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy -- hh:mm");
        String dataFormatada = formatar.format(data);

        //--Criar txt
        String conteudo = "Cadastro efetivado -- " + dataFormatada;

        Path caminho = Paths.get("txt/Log");
        if(Files.exists(caminho)){
            Files.write(caminho, Collections.singleton(conteudo), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        }
        else{
            Files.write(caminho, Collections.singleton(conteudo), StandardCharsets.UTF_8);
        }
    }
}
