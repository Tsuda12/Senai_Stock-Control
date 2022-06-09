package tsuda.scripts;

import java.io.File;

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
}
