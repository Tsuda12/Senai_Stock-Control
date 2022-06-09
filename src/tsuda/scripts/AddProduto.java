package tsuda.scripts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProduto implements ActionListener {
    //VARIÁVEIS
    Estoque estoque;


    //MÉTODOS
    @Override
    public void actionPerformed(ActionEvent e) {
        //--Chama a tela de adicionar
        Adicionar adicionarTela = new Adicionar(estoque.produtos_lista);
        adicionarTela.setVisible(true);
    }
}
