import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Agenda implements Serializable {
    private Pacientes pacientes;
    private String data;
    private String hora;
    final static String  medica = "Dra. Debora";
    final static double  valor = 200;

    public Agenda (Pacientes pacientes, String data, String hora){
        this.pacientes = pacientes;
        this.data = data;
        this.hora = hora;
    }
    public Pessoa getPacientes() {
        return pacientes;
    }
    public void setPessoa(Pacientes pacientes) {
        this.pacientes = pacientes;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    @Override
    public String toString() {
       return String.format("Paciente - %s | data: %s | hora: %s | Médica: %s | Valor da consulta: %.2f",
               pacientes.toString(),
               getData(), getHora(),medica, valor);
    }

    public static Agenda cadastrar(){
        Scanner input = new Scanner(System.in);
        System.out.println("Qual paciente vai ser agendado? Digite pelo id");
        ArrayList<Pacientes> lista1 = Arquivos.ler();
        int i = 0;
        if (lista1.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
        }
        else {
            for (Pacientes p : lista1) {
                System.out.printf("ID: %d || %s %n", i+=1 , p);
            }
        }
        int id = input.nextInt();
        Pacientes paciente = lista1.get(id - 1);
        System.out.println("Digite a data formatada (xx/xx/xxxx):");
        String data = "";
        boolean dataV = false;
        while (!dataV) {
            try {
                data = input.next();
                if(data.matches("\\d{2}/\\d{2}/\\d{4}")){
                    dataV = true;
                }
                else{
                    System.out.println("Digite a data corretamente");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro");
                input.nextLine();
            }
        }
        System.out.println("Digite a hora no formato (xx:xx):");
        String hora = "";
        boolean horaV = false;
        while (!horaV) {
            try {
                hora = input.next();
                if(hora.matches("\\d{2}:\\d{2}")){
                    horaV = true;
                }
                else{
                    System.out.println("Digite a hora corretamente");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro");
                input.nextLine();
            }
        }
        System.out.println("Tem certeza que deseja marcar esta consulta?");
        System.out.printf("%s| data: %s | hora: %s | Médica: %s %n", paciente.toString(), data, hora, medica);
        System.out.println("1- Sim\n2- Não");
        String resposta = "";
        boolean respostaC = false;
        while (!respostaC) {
            resposta = input.next();
            if (resposta.equals("1")) {
                System.out.println("consulta marcada");
                respostaC = true;
            } else if (resposta.equals("2")) {
                Menu.menuCadastro();
            }
            else {
                System.out.println("digite uma das opções");
            }
        }
        Agenda agendado = new Agenda(paciente, data, hora);
        return agendado;
    }
    public static void listarAgenda() {
        ArrayList<Agenda> lista = ArquivosAgenda.lerAgenda();
        if (lista.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
        }
        else {
            for (Agenda p : lista) {
                System.out.println(p);
            }
        }
    }

    public static void atualizarAgenda(){
        Scanner input = new Scanner(System.in);
        System.out.println("Qual agendamento vai ser atualizado? Digite pelo id");
        ArrayList<Agenda> lista1 = ArquivosAgenda.lerAgenda();
        int i = 0;
        if (lista1.isEmpty()) {
            System.out.println("Nenhuma consulta cadastrada");
        }
        else {
            for (Agenda a : lista1) {
                System.out.printf("ID: %d || %s %n", i+=1 , a);
            }
        }
        int id = input.nextInt();
        Agenda agendamento = lista1.get(id - 1);
        System.out.println("O que vc deseja alterar?");
        System.out.println("1- Paciente\n2- data\n3- hora\n");
        String opcao = "";
        while (true){
            opcao = input.next();
            if(opcao.equals("1")){
                Pacientes.listarPacientes();
                ArrayList<Pacientes> lista3 = Arquivos.ler();
                System.out.println("Qual ID do paciente que você deseja trocar?");
                int id1 = input.nextInt();
                Pacientes p2 = lista3.get(id1 - 1);
                agendamento.setPessoa(p2);
                ArquivosAgenda.salvarAg(lista1);
                System.out.println("Paciete atualizado!");
                break;
            }
            else if (opcao.equals("2")) {
                System.out.println("Digite a nova data:");
                String dataNova = "";
                boolean dataV = false;
                while (!dataV) {
                    try {
                        dataNova = input.next();
                        if(dataNova.matches("\\d{2}/\\d{2}/\\d{4}")){
                            dataV = true;
                        }
                        else{
                            System.out.println("Digite a data corretamente");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Erro");
                        input.nextLine();
                    }
                }
                agendamento.setData(dataNova);
                ArquivosAgenda.salvarAg(lista1);
                System.out.println("Data atualizada!");
                break;
            }
            else if (opcao.equals("3")) {
                System.out.println("Digite a nova hora:");
                String horaNova = "";
                boolean horaV = false;
                while (!horaV) {
                    try {
                        horaNova = input.next();
                        if(horaNova.matches("\\d{2}:\\d{2}")){
                            horaV = true;
                        }
                        else{
                            System.out.println("Digite a hora corretamente");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Erro");
                        input.nextLine();
                    }
                }
                agendamento.setHora(horaNova);
                ArquivosAgenda.salvarAg(lista1);
                System.out.println("Hora atualizada!");
                break;
            }
            else{
                System.out.println("Digite uma das opções");
                System.out.println("1- Paciente\n2- data\n3- hora\n");
            }
        }
    }
    public static void excluirAgenda(){
        Scanner input = new Scanner(System.in);
        System.out.println("Qual agendamento vai ser excluido? Digite pelo id");
        ArrayList<Agenda> lista4 = ArquivosAgenda.lerAgenda();
        int i = 0;
        if (lista4.isEmpty()) {
            System.out.println("Nenhuma consulta cadastrada");
            return;
        }
        else {
            for (Agenda a : lista4) {
                System.out.printf("ID: %d || %s %n", i+=1 , a);
            }
        }
        int id3 = input.nextInt();
        lista4.remove(id3 - 1);
        ArquivosAgenda.salvarAg(lista4);
    }

    public static void listarFaturamento(){
        ArrayList<Agenda> lista4 = ArquivosAgenda.lerAgenda();
        int i = 0;
        if (lista4.isEmpty()) {
            System.out.println("Nenhuma consulta cadastrada");
        }
        else {
            for (Agenda a : lista4) {
                System.out.printf("ID: %d || %s %n", i += 1, a);
            }
        }
        System.out.printf("Faturamento total: %.2f%n", (i * valor));
    }

}
