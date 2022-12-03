package Who_killed;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class teste {
    private static Scanner ler = new Scanner(System.in);
    private static File arquivo = new File("Who_killed/jogador.txt");
    public static void main(String[] args) throws IOException {
        registraJogador();
    }

    public static void registraJogador() throws IOException {
        System.out.print("Nome: ");
        String nome = ler.nextLine();
        System.out.print("Apelido: ");
        String apelido = ler.nextLine();
        writeFile(arquivo,nome,apelido);

    }
    private static void writeFile(File arquivo, String nome, String apelido) throws IOException {
        FileWriter fw = new FileWriter(arquivo, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(String.format("nome = %s | apelido = %s", nome, apelido));
        bw.newLine();
        bw.close();
        fw.close();
    }
}
