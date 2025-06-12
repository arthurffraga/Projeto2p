import java.io.*;
import java.util.ArrayList;

public class ArquivosAgenda {
    public static void salvarAg(ArrayList<Agenda> lista) {
        try {
            FileOutputStream arq = new FileOutputStream("agenda.ser");
            ObjectOutputStream grav = new ObjectOutputStream(arq);
            grav.writeObject(lista);
            grav.close();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar os pacientes.");
            e.printStackTrace();
        }
    }
    public static ArrayList<Agenda> lerAgenda() {
        ArrayList<Agenda> lista = new ArrayList<>();
        File arquivoAgenda = new File("agenda.ser");
        if (!arquivoAgenda.exists() || arquivoAgenda.length() == 0) {
            return lista;
        }

        try (FileInputStream fis = new FileInputStream(arquivoAgenda);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            lista = (ArrayList<Agenda>) ois.readObject();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");
        } catch (EOFException e) {
            System.out.println("Iniciando nova agenda.");
            return new ArrayList<>();
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println("Ocorreu um erro ao ler os agendamentos.");
            e.printStackTrace();
        }
        return lista;
    }
}

