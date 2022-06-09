package tsuda.scripts;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReadProduto implements ActionListener {
    //VARIÁVEIS
    Estoque estoque;


    //MÉTODOS
    @Override
    public void actionPerformed(ActionEvent e) {
        //--Checa se a lista está vazia para ler
        if(estoque.produtos_lista.isEmpty()==true){
            JOptionPane.showMessageDialog(null, "Sem itens cadastrados!");
        }
        else{
            //--Chama a janela ler
            Ler lerTela = new Ler(estoque.produtos_lista);
            lerTela.setVisible(true);
        }
    }
}
