import java.io.Serializable;

public class Pessoa implements Serializable {
    protected String nome;
    protected int idade;
    protected String cpf;
    protected String numero;

    public Pessoa (String nome, int idade, String cpf, String numero) {
        this.nome = nome;
        this.idade = idade;
        this.numero = numero;
        this.cpf = cpf;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}