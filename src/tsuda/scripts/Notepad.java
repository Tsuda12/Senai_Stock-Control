package tsuda.scripts;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Notepad
{
    //VARIÁVEIS
    File arquivo = new File("txt");


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
}
