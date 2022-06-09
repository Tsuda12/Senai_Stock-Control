package tsuda.scripts;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateProduto implements ActionListener {
    //VARIÁVEIS
    Estoque estoque;


    //MÉTODOS
    @Override
    public void actionPerformed(ActionEvent e) {
        //--Checa se a lista está vazia
        if (estoque.produtos_lista.isEmpty()==true){
            JOptionPane.showMessageDialog(null, "Sem itens cadastrados!");
        }
        else{
            //--Chamar a janela atualuzar
            Update atualizarTela = new Update(estoque.produtos_lista);
            atualizarTela.setVisible(true);
        }
    }
}
