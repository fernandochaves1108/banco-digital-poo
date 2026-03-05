package persistencia;

import model.Banco;

import java.io.*;

public class BancoArquivo {

    private static final String ARQUIVO = "banco.dat";

    public static void salvar(Banco banco) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO))) {
            oos.writeObject(banco);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Banco carregar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO))) {
            return (Banco) ois.readObject();
        } catch (Exception e) {
            return new Banco();
        }
    }
}