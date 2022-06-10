package tsuda.scripts;

public enum Avisos {
    //MENSAGENS
    ProdutoCadastrado("Produto cadastrado!"),
    ErroNumero("Digite apenas números"),
    ProdutoExistente("Este produto já existe"),
    ProdutoAlterado("Produto alterado!"),
    SemProdutos("Nenhum produto encontrado!"),
    ProdutoDeletado("Produto deletado!"),
    SenhaAceita("Senha aceita!"),
    ErroLogin("Usuário ou senha incorretos!");


    //VARIÁVEL
    private String msg;


    //GETTER MENSAGEM
    public String getValue(){
        return msg;
    }


    //CONSTRUTOR
    Avisos(String msg) {
        this.msg = msg;
    }
}
