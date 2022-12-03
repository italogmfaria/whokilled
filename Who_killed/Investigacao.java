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
import java.util.Random;
import java.util.Scanner;

public class Investigacao {
    public static final String RESET = "\u001B[0m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static String CULPADO, CAMINHO, RESUMO1, RESUMO2, DIALOGO01, DIALOGO02, DIALOGO03;
    public static String[] INOCENTES = new String[3];
    public static String ESPACO = "\n------------------------------------------\n";
    public static boolean SUCESSO = true;
    public static int PONTOS = 0, CONTROLADOR = 1;

    public static Scanner ler = new Scanner(System.in);

    public static Random gerador = new Random();
    public static File arquivo = new File("Who_killed/jogador.txt");

    public static void main(String[] args) throws IOException, InterruptedException {

        registraJogador(); //Esse e o metodo que vai pegar o nome de o nick do jogador e salvar.
        jogo();//Esse metodo e o corpo do jogo
    }

    public static void jogo() throws IOException, InterruptedException {
        CAMINHO = "Who_killed/Crimes/Crime0" + CONTROLADOR + ".txt";
        pistasDoCrime(); //Esse e o metodo que vai imprimir as pistas do crime
        falaComLegista(); //Esse e o metdo que vai imprimir as gravaçoes do legista
        vereditoDoCaso(); //Esse e o metodo que vai fazer o chute de quem e o assasino
        epilogo(); //Esse e o metodo final que vai falar se voce acertou ou nao e imprimir o resumo e salva a pontuação

    }

    public static void registraJogador() throws IOException {
        System.out.print("Nome: ");
        String nome = ler.nextLine();
        System.out.print("Apelido: ");
        String apelido = ler.nextLine();
        writeFile(arquivo, nome, apelido);
    }

    public static void writeFile(File arquivo, String nome, String apelido) throws IOException {
        FileWriter fw = new FileWriter(arquivo, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(String.format("nome = %s : apelido = %s", nome, apelido));
        bw.newLine();
        bw.close();
        fw.close();
    }

    public static void pistasDoCrime() throws FileNotFoundException {
        System.out.println(ESPACO + "                 CASO " + CONTROLADOR + "º" + ESPACO);
        Scanner input = new Scanner(new File(CAMINHO));
        CULPADO = input.nextLine();
        INOCENTES[0] = input.nextLine();
        INOCENTES[1] = input.nextLine();
        INOCENTES[2] = input.nextLine();
        RESUMO1 = input.nextLine();
        RESUMO2 = input.nextLine();
        DIALOGO01 = input.nextLine();
        DIALOGO02 = input.nextLine();
        DIALOGO03 = input.nextLine();
        while (input.hasNext()) {
            System.out.println(input.nextLine());
        }
    }

    public static void falaComLegista() throws InterruptedException {
        System.out.println(ESPACO);
        //Thread.sleep(2000);
        System.out.println("-Depois de ler a ficha do crime, você decide ir ver o legista.\n" +
                "-Mas ao chegar você encontra apenas seu gravador que esta sob a ficha \ndo caso com 2 gravaçoes salvas." +
                YELLOW + "\n-Será que devo ouvir as gravações?" + RESET);

        while (true) {
            String resposta = ler.nextLine();
            if (resposta.equalsIgnoreCase("sim")) {
                System.out.println(BLUE + DIALOGO01 +
                        "\n" + DIALOGO02 + RESET);

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
        //Thread.sleep(2000);
        System.out.println("-Ao analizar a ficha por algum tempo você sente que está pronto para identificar o culpado," +
                "certo, consegui provas o suficente para indentificar o assasino." +
                "\nO culpado esta entre essas pessoas\n");

        System.out.println("=================");
        int random = gerador.nextInt(3) + 1;
        int cont = 0;
        for (int i = 0; i < 4; i++) {
            if (i == random) {
                System.out.println(PURPLE + CULPADO + RESET);
            } else {
                System.out.println(PURPLE + INOCENTES[cont] + RESET);
                cont++;
            }
        }
        System.out.println("=================");
        System.out.println("Está na hora da decisão");
        while (SUCESSO) {
            String chute = ler.nextLine();
            if (chute.equalsIgnoreCase(CULPADO)) {
                System.out.println("Sim, e ele mesmo");
                SUCESSO = true;
                return;
            } else if (chute.equalsIgnoreCase(INOCENTES[0])) {
                System.out.println("Sim o culpado deve ser esse homem");
                SUCESSO = false;
            } else if (chute.equalsIgnoreCase(INOCENTES[1])) {
                System.out.println("Sim o culpado deve ser esse homem");
                SUCESSO = false;
            } else if (chute.equalsIgnoreCase(INOCENTES[2])) {
                System.out.println("Sim o culpado deve ser esse homem");
                SUCESSO = false;
            } else {
                System.out.println("O que? Esse nome nao esta na lista de suspeitos, melhor ler novamente.");
            }
        }
    }

    public static void epilogo() throws IOException, InterruptedException {
        System.out.println(ESPACO);
        if (SUCESSO) {
            System.out.println("Seu papite estava " + GREEN + "CERTO" + RESET);
            PONTOS++;
            System.out.println("Pontuação" + PONTOS);
            CONTROLADOR++;
            System.out.println(BLUE + RESUMO2 + RESET);
            if (CONTROLADOR < 7) {
                jogo();
            }
        } else {
            System.out.println("Seu papite estava " + RED + "ERRADO" + RESET);
            System.out.println(BLUE + RESUMO2 + RESET);
        }
        System.out.println("Sua pontuação final é " + PONTOS);
        System.out.println(ESPACO);
    }


}