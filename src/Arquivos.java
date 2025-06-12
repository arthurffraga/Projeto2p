import java.io.*;
import java.util.ArrayList;
public class Arquivos {
    public static void salvarTodos(ArrayList<Pacientes> lista) {
        try {
            FileOutputStream arq = new FileOutputStream("pacientes.ser");
            ObjectOutputStream grav = new ObjectOutputStream(arq);
            for (Pacientes p : lista) {
                grav.writeObject(p);
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar os pacientes.");
        }
    }

    public static ArrayList<Pacientes> ler(){
        ArrayList<Pacientes> lista = new ArrayList<>();
        try{
            FileInputStream arq = new FileInputStream("pacientes.ser");
            ObjectInputStream grav = new ObjectInputStream(arq);
            while (true) {
                try {
                    Pacientes paciente = (Pacientes) grav.readObject();
                    lista.add(paciente);
                } catch (EOFException e) {
                    break;
                }
            }
            grav.close();
        }
        catch (IOException | ClassNotFoundException e){
            System.out.println("");
        }
        return lista;
    }
}
