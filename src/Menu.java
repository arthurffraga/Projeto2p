import java.util.Scanner;
import java.util.ArrayList;
public class Menu {
    public static void menuPrincipal() {
        Scanner input = new Scanner(System.in);
        String opcao = "";
        while(!opcao.equals("5")) {
            System.out.println("===Menu===");
            System.out.println("Digite uma das opções abaixo:");
            System.out.println("1- Cadastrar");
            System.out.println("2- Listar");
            System.out.println("3- Atualizar");
            System.out.println("4- Excluir");
            System.out.println("5- Sair");
            opcao = input.next();
            if(opcao.equals("1")) {
                menuCadastro();
                break;
            }
            else if(opcao.equals("2")) {
                menuListar();
                break;
            }
            else if(opcao.equals("3")) {
                menuAtualizar();
                break;
            }
            else if(opcao.equals("4")) {
                menuExcluir();
                break;
            }
            else if(opcao.equals("5")) {
                System.out.println("você saiu!");
                break;
            }
            else {
                System.out.println("Digite uma das opções \n");
            }
        }

    }

    public static void menuCadastro() {
        Scanner input = new Scanner(System.in);
        String opcao = "";
        while(!opcao.equals("4")) {
            System.out.println("Digite uma das opções abaixo:");
            System.out.println("1- Cadastrar paciente");
            System.out.println("2- Cadastrar consulta");
            System.out.println("3- Voltar");
            System.out.println("4- Sair");
            opcao = input.next();
            if(opcao.equals("1")) {
                Pacientes novoPaciente = Pacientes.cadastrar();
                ArrayList<Pacientes> lista = Arquivos.ler();
                lista.add(novoPaciente);
                Arquivos.salvarTodos(lista);
            }
            else if(opcao.equals("2")) {
                Agenda agenda = Agenda.cadastrar();
                ArrayList<Agenda> lista2 = ArquivosAgenda.lerAgenda();
                lista2.add(agenda);
                ArquivosAgenda.salvarAg(lista2);
            }
            else if(opcao.equals("3")) {
                menuPrincipal();
                break;
            }
            else if(opcao.equals("4")) {
                break;
            }
            else {
                System.out.println("");
            }
        }
    }
    public static void menuListar() {
        Scanner input = new Scanner(System.in);
        String opcao = "";
        while(!opcao.equals("4")) {
            System.out.println("Digite uma das opções abaixo:");
            System.out.println("1- Listar paciente");
            System.out.println("2- Listar consultas");
            System.out.println("3- Listar Faturamento");
            System.out.println("4- Voltar");
            System.out.println("5- Sair");
            opcao = input.next();
            if(opcao.equals("1")) {
                Pacientes.listarPacientes();
            }
            else if(opcao.equals("2")) {
                Agenda.listarAgenda();
            }
            else if(opcao.equals("3")) {
                Agenda.listarFaturamento();
            }
            else if(opcao.equals("4")) {
                menuPrincipal();
                break;
            }
            else if(opcao.equals("5")) {
                break;
            }
            else {
                System.out.println("");
            }
        }
    }
    public static void menuAtualizar() {
        Scanner input = new Scanner(System.in);
        String opcao = "";
        while(!opcao.equals("4")) {
            System.out.println("Digite uma das opções abaixo:");
            System.out.println("1- Atualizar paciente");
            System.out.println("2- Atualizar consulta");
            System.out.println("3- Voltar");
            System.out.println("4- Sair");
            opcao = input.next();
            if(opcao.equals("1")) {
                Pacientes.atualizarPacientes();
            }
            else if(opcao.equals("2")) {
                Agenda.atualizarAgenda();
            }
            else if(opcao.equals("3")) {
                menuPrincipal();
                break;
            }
            else if(opcao.equals("4")) {
                break;
            }
            else {
                System.out.println("");
            }
        }
    }
    public static void menuExcluir() {
        Scanner input = new Scanner(System.in);
        String opcao = "";
        while(!opcao.equals("4")) {
            System.out.println("Digite uma das opções abaixo:");
            System.out.println("1- Excluir paciente");
            System.out.println("2- Excluir consulta");
            System.out.println("3- Voltar");
            System.out.println("4- Sair");
            opcao = input.next();
            if(opcao.equals("1")) {
                Pacientes.excluirPaciente();
            }
            else if(opcao.equals("2")) {
                Agenda.excluirAgenda();
            }
            else if(opcao.equals("3")) {
                menuPrincipal();
                break;
            }
            else if(opcao.equals("4")) {
                break;
            }
            else {
                System.out.println("");
            }
        }
    }

}