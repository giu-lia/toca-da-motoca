package modelos;

public class Cliente {

    private Integer id;
    private String nome;
    private Integer idade;
    private String telefone;
    private String cpf;

    public Cliente () {
    }
//
//    if(nome.equals("")){
//        temErro = true;
//        msgErro = msgErro + "Insira um nome válido.";
//    } else if (idade.equals("") || Integer.valueOf(idade) < 18){
//        temErro = true;
//        msgErro = msgErro + "Insira uma idade válida.";
//    } else if (telefone.equals("") || telefone.length() < 9){
//        temErro = true;
//        msgErro = msgErro + "Insira um telefone válido.";
//    } else if (login.equals("")) {
//        temErro = true;
//        msgErro = msgErro + "Insira um usuário válido.";
//    } else if (senha.equals("") || confirmaSenha.equals("")){
//        temErro = true;
//        msgErro = msgErro + "Insira senhas válidas.";
//    } else if (!senha.equals(confirmaSenha)){
//        temErro = true;
//        msgErro = msgErro + "As senhas não coincidem.";
//    }

    public Cliente (String nome, Integer idade, String telefone, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
