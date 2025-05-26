import java.io.Serializable;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;
public class Pacientes extends Pessoa{
    public Pacientes(String nome, int idade) {
        this(nome, idade, "", "");
    }
    public Pacientes(String nome, int idade, String cpf, String numero) {
        super(nome, idade, cpf, numero);
    }
    @Override
    public String toString() {
        return String.format("Nome: %s || Idade: %d || CPF: %s || Número: %s", getNome(), getIdade(), getCpf(), getNumero());
    }

    public static Pacientes cadastrar() {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome:");
        String nome = "";
        boolean nomeV = false;
        while (!nomeV){
            nome = input.next();
            if (nome.matches("[a-zA-Z]+")){
                nomeV = true;
                break;
            }
            else{
                System.out.println("Digite um nome com apenas letras");
            }
        }
        System.out.println("Digite a idade:");
        int idade = 0;
        boolean idadeV = false;
        while (!idadeV) {
            try {
                idade = input.nextInt();
                idadeV = true;

            } catch (InputMismatchException e) {
                System.out.println("Digite um número inteiro:");
                input.nextLine();
            }
        }
        System.out.println("Digite o cpf:");
        String cpf = "";
        boolean cpfV = false;
        while (!cpfV) {
            cpf = input.next();
            if(cpf.matches("\\d{11}")){
                cpfV = true;
            }
            else {
                System.out.println("Digite um cpf valido");
            }
        }
        System.out.println("Digite o número para contato:");
        String numero = "";
        boolean numV = false;
        while (!numV) {
            numero = input.next();
            if(numero.matches("\\d{11}")){
                numV = true;
            }
            else {
                System.out.println("Digite um número valido");
            }
        }
        System.out.println("Deseja cadastrar esse paciente mesmo?");
        Pessoa pessoaCadastrada = new Pacientes (nome, idade, cpf, numero);
        System.out.printf("Cliente:\n%s%n%s%n%s%n%s%n",
                pessoaCadastrada.getNome(),
                pessoaCadastrada.getIdade(),
                pessoaCadastrada.getCpf(),
                pessoaCadastrada.getNumero());
        System.out.println("\n1- Sim\n2- Não");
        String resposta = "";
        boolean respostaC = false;
        while (!respostaC) {
            resposta = input.next();
            if (resposta.equals("1")) {
                System.out.println("Paciente cadastrado");
                respostaC = true;
            } else if (resposta.equals("2")) {
                Menu.menuCadastro();
            }
            else {
                System.out.println("digite uma das opções");
            }
        }
        Pacientes c1 = new Pacientes (nome, idade, cpf, numero);
        return c1;
    }

    public static void listarPacientes() {
        ArrayList<Pacientes> lista = Arquivos.ler();
        int i = 0;
        if (lista.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
        }
        else {
            for (Pacientes p : lista) {
                System.out.printf("ID: %d || %s %n", i += 1,p);
                }
            }
        }
    public static void atualizarPacientes(){
        Scanner input = new Scanner(System.in);
        System.out.println("Qual paciente vai ser atualizado? Digite pelo id");
        ArrayList<Pacientes> listaP = Arquivos.ler();
        int i = 0;
        if (listaP.isEmpty()) {
            System.out.println("Nenhuma consulta cadastrada");
        }
        else {
            for (Pacientes p : listaP) {
                System.out.printf("ID: %d || %s %n", i+=1 , p);
            }
        }
        int id = input.nextInt();
        Pacientes paciente = listaP.get(id - 1);
        System.out.println("O que vc deseja alterar?");
        System.out.println("1- Nome\n2- Idade\n3- CPF\n4- Número\n");
        String opcao = "";
        while (true) {
            opcao = input.next();
            if (opcao.equals("1")) {
                System.out.println("Digite o novo nome:");
                String nome = "";
                boolean nomeV = false;
                while (!nomeV){
                    nome = input.next();
                    if (nome.matches("[a-zA-Z]+")){
                        nomeV = true;
                    }
                    else{
                        System.out.println("Digite um nome com apenas letras");
                    }
                }
                paciente.setNome(nome);
                Arquivos.salvarTodos(listaP);
                System.out.println("Nome atualizado!");
                break;
            }
            else if (opcao.equals("2")){
                System.out.println("Digite a nova idade:");
                int idade = 0;
                boolean idadeV = false;
                while (!idadeV) {
                    try {
                        idade = input.nextInt();
                        idadeV = true;

                    } catch (InputMismatchException e) {
                        System.out.println("Digite um número inteiro:");
                        input.nextLine();
                    }
                }
                paciente.setIdade(idade);
                Arquivos.salvarTodos(listaP);
                System.out.println("Idade atualizada!");
                break;
            }
            else if (opcao.equals("3")) {
                System.out.println("Digite o novo CPF:");
                String cpf = "";
                boolean cpfV = false;
                while (!cpfV) {
                    if(cpf.matches("\\d{11}")){
                        cpfV = true;
                    }
                    else{
                        System.out.println("Digite um cpf valido");
                    }
                }
                paciente.setCpf(cpf);
                Arquivos.salvarTodos(listaP);
                System.out.println("CPF atualizado!");
                break;
            }
            else if (opcao.equals("4")) {
                System.out.println("Digite o novo número:");
                String numero = "";
                boolean numV = false;
                while (!numV) {
                    numero = input.next();
                    if(numero.matches("\\d{11}")){
                        numV = true;
                    }
                    else{
                        System.out.println("Digite um número valido");
                    }
                }
                paciente.setNumero(numero);
                Arquivos.salvarTodos(listaP);
                System.out.println("Número atualizado!");
                break;
            }
            else {
                System.out.println("Digite uma das opções");
                System.out.println("1- Nome\n2- Idade\n3- CPF\n4- Número\n");
            }
        }
    }
    public static void excluirPaciente(){
        Scanner input = new Scanner(System.in);
        System.out.println("Qual paciente vai ser excluido? Digite pelo id");
        ArrayList<Pacientes> listap2 = Arquivos.ler();
        int i = 0;
        if (listap2.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado");
            return;
        }
        else {
            for (Pacientes a : listap2) {
                System.out.printf("ID: %d || %s %n", i+=1 , a);
            }
        }
        int id3 = input.nextInt();
        listap2.remove(id3 - 1);
        Arquivos.salvarTodos(listap2);
    }
}