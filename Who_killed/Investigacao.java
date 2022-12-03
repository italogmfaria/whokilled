/*
echo "# whokilled" >> README.md
git init
git add README.md
git commit -m "COLOCAR A VERSAO AQUI E OQUE FEZ NELA"
git branch -M main
git remote add origin https://github.com/italogmfaria/whokilled.git
git push -u origin main
 */
package Who_killed;

import java.io.*;
import java.util.Scanner;

public class Investigacao {
    public static final String RESET = "\u001B[0m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String GREEN = "\u001B[32m";

    public static final String RED = "\u001B[31m";
    static Scanner ler = new Scanner(System.in);
    static String CULPADO, CAMINHO, RESUMO1, RESUMO2, DIALOGO01, DIALOGO02, DIALOGO03;
    static String ESPACO = "\n------------------------------------------\n";
    static boolean SUCESSO = true;

    private static File arquivo = new File("Who_killed/jogador.txt");
    public static void main(String[] args) throws IOException, InterruptedException {
        CAMINHO = "Who_killed/Crime00.txt";
        registraJogador(); //Esse e o metodo que vai pegar o nome de o nick do jogador e salvar.
        pistasDoCrime(); //Esse e o metodo que vai imprimir as pistas do crime
        falaComLegista(); //Esse e o metdo que vai imprimir as gravaçoes do legista
        vereditoDoCaso(); //Esse e o metodo que vai fazer o chute de quem e o assasino
        epilogo(); //Esse e o metodo final que vai falar se voce acertou ou nao e imprimir o resumo, E Salvar sua pontuação
    }

    public static void registraJogador() throws IOException {
        System.out.print("Nome: ");
        String nome = ler.nextLine();
        System.out.print("Apelido: ");
        String apelido = ler.nextLine();
        writeFile(arquivo,nome,apelido);

    }

    public static void pistasDoCrime() throws FileNotFoundException {
        System.out.println(ESPACO);
        Scanner input = new Scanner(new File(CAMINHO));
        CULPADO = input.nextLine();
        RESUMO1 = input.nextLine();
        RESUMO2 = input.nextLine();
        DIALOGO01 = input.nextLine();
        DIALOGO02 = input.nextLine();
        DIALOGO03 = input.nextLine();
        while (input.hasNext()) {
            System.out.println(BLUE + input.nextLine() + RESET);
        }
    }

    public static void falaComLegista() throws InterruptedException {
        System.out.println(ESPACO);
        Thread.sleep(2000);
        System.out.println("-Depois de ler a ficha do crime, você decide ir ver o legista.\n" +
                "-Mas ao chegar você encontra apenas seu gravador que esta sob a ficha \ndo caso com 2 gravaçoes salvas." +
                YELLOW + "\n-Será que devo ouvir as gravações?" + RESET);

        while (true) {
            String resposta = ler.nextLine();
            if (resposta.equalsIgnoreCase("sim")) {
                System.out.println(BLUE + " Legista - FALA O DIALOGO 1" +
                        "\n Legista - FALA O DIALOGO 2" + RESET);

                return;
            } else if (resposta.equalsIgnoreCase("nao")) {
                System.out.println("-Acho melhor nao mecher nas coisas alheias");
                return;
            } else {
                System.out.println("-Será que devo verificar as gravacoes? 'sim' ou 'nao'");
            }
        }
    }

    public static void vereditoDoCaso() throws InterruptedException {
        System.out.println(ESPACO);
        //System.out.println(RESUMO1); RESUMO DENCESSASARIO
        Thread.sleep(2000);
        System.out.println("-Ao analizar a ficha por algum tempo você sente que está pronto para identificar o culpado," +
                "certo, consegui provas o suficente para indentificar o assasino." +
                "\n -O culpado esta entre essas pessoas\n" +
                PURPLE + " *Suspeito01\n *Suspeito02\n *Suspeito03\n *Suspeito04" + RESET + "\n E o culpado está entre esse homens");
        while (SUCESSO) {
            String chute = ler.nextLine();
            if (chute.equalsIgnoreCase("culpado")) {
                System.out.println("Sim, e ele mesmo");
                SUCESSO = true;
                return;
            } else if (chute.equalsIgnoreCase("suspeito02")) {
                System.out.println("Sim o culpado deve ser esse homem");
                SUCESSO = false;
            } else if (chute.equalsIgnoreCase("suspeito03")) {
                System.out.println("Sim o culpado deve ser esse homem");
                SUCESSO = false;
            } else if (chute.equalsIgnoreCase("suspeito04")) {
                System.out.println("Sim o culpado deve ser esse homem");
                SUCESSO = false;
            } else {
                System.out.println("O que? Esse nome nao esta na lista de suspeitos, melhor ler novamente.");
            }
        }
    }

    public static void epilogo() {
        System.out.println(ESPACO);
        if (SUCESSO) {
            System.out.println("Seu papite estava " + GREEN + "CERTO" + RESET);
        } else {
            System.out.println("Seu papite estava " + RED + "ERRADO" + RESET);
        }
        System.out.println(BLUE + RESUMO2 + RESET);
        System.out.println(ESPACO);
    }

    private static void writeFile(File arquivo,String nome, String apelido) throws IOException {
        FileWriter fw = new FileWriter(arquivo, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(String.format("nome = %s : apelido = %s", nome, apelido));
        bw.newLine();
        bw.close();
        fw.close();
    }
}