package tsuda.scripts;

public class Produto
{
    //VARIÁVEIS
    private String nome;
    private String quantidade;


    //CONSTRUTOR
    public Produto(String nome, String quantidade)
    {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public Produto(String nome)
    {
        this.nome = nome;
    }


    //GETTERS E SETTERS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }


    //MÉTODOS
    public String toString()
    {
        return "Nome: " + nome + " | " + "Quantidade: " + quantidade;
    }
}
