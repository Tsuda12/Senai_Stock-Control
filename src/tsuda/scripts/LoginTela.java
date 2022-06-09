package tsuda.scripts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginTela extends JFrame
{
    //VARIÁVEIS
    private JLabel titulo = new JLabel("LOGIN | CADASTRO");
    private JLabel usuario = new JLabel("Usuário");
    private JTextField nomeUsuario = new JTextField(100);
    private JLabel senha = new JLabel("Senha");
    private JTextField senhaUsuaro = new JTextField(100);
    private JButton botaoLogar = new JButton("ENTRAR");
    private JButton botaoCadastrar = new JButton("CADASTRAR");

    public LoginTela(){
        super("Login ou Cadastro");

        setLayout(null);

        //--Icone
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/icone.png")));

        titulo.setBounds(120, 10, 250, 40);
        titulo.setFont(new Font("Montserrat Bold", Font.PLAIN, 20));
        titulo.setForeground(Color.WHITE);
        add(titulo);

        usuario.setBounds(40, 80, 200, 40);
        usuario.setFont(new Font("Montserrat Bold", Font.PLAIN, 18));
        usuario.setForeground(Color.WHITE);
        add(usuario);

        nomeUsuario.setBounds(160, 85, 240, 30);
        add(nomeUsuario);

        senha.setBounds(40, 155, 200, 40);
        senha.setFont(new Font("Montserrat Bold", Font.PLAIN, 18));
        senha.setForeground(Color.WHITE);
        add(senha);

        senhaUsuaro.setBounds(160, 160, 240, 30);
        add(senhaUsuaro);

        botaoLogar.setBounds(40, 230, 150, 40);
        botaoLogar.setFont(new Font("Montserrat Bold", Font.PLAIN, 15));
        botaoLogar.setBackground(Color.RED);
        botaoLogar.setForeground(Color.WHITE);
        botaoLogar.setFocusPainted(false);
        add(botaoLogar);

        botaoCadastrar.setBounds(250, 230, 150, 40);
        botaoCadastrar.setFont(new Font("Montserrat Bold", Font.PLAIN, 15));
        botaoCadastrar.setBackground(Color.RED);
        botaoCadastrar.setForeground(Color.WHITE);
        botaoCadastrar.setFocusPainted(false);
        add(botaoCadastrar);
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Notepad notepad = new Notepad();
                notepad.criarPasta();
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 350);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);
        setVisible(true);
    }
}
