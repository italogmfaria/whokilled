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

import javax.sound.sampled.*;
import javax.swing.*;
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
    public static String CULPADO, CAMINHO, RESUMO1, RESUMO2, DIALOGO01, DIALOGO02, DIALOGO03, NOME, NICK,DIALOGO04,DIALOGO05,DIALOGO06,DIALOGO07 ;
    public static String[] INOCENTES = new String[3];
    public static String ESPACO = "\n-------------------------------------------\n";
    public static boolean SUCESSO = true;
    public static int PONTOS = 0, CONTROLADOR = 1;
    public static int[] PONTOCADACASO = new int[7];

    public static Scanner ler = new Scanner(System.in);

    public static Random gerador = new Random();
    public static File arquivo = new File("Who_killed/jogador.txt");

    public static void main(String[] args) throws IOException, InterruptedException, UnsupportedAudioFileException, LineUnavailableException {
        regras();
        registraJogador(); //Esse e o metodo que vai pegar o nome de o nick do jogador e salvar.
        jogo();//Esse metodo e o corpo do jogo
    }

    public static void regras() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        String tituloRegra = "Boas Vindas";
        String textoRegra = """
                Bem Vindo ao Who Killed, o melhor e mais bem feito jogo de investigação
                O jogo funciona da seguinte maneira:
                   -Dados e informações importantes serão impressos no console para facilitar a consulta.
                   -Você deve interagir com as caixa de diálogos ou de opções para avançar no jogo.
                   -Cada escolha sua tem consequências escolha com cuidado.
                   -Acerte o culpado para continuar para outro caso.
                
                                                                            Boa Sorte!!!
                """;
        Who_killed.ReprodutorAudio.leitura("Audios/Leitura01.wav", textoRegra, tituloRegra);

    }

    public static void registraJogador() throws IOException {
        NOME = JOptionPane.showInputDialog("Digite Seu Nome");
        NICK = JOptionPane.showInputDialog("Digite Seu Nick");
    }


    public static void jogo() throws IOException, InterruptedException, UnsupportedAudioFileException, LineUnavailableException {
        CAMINHO = "Who_killed/Crimes/Crime0" + CONTROLADOR + ".txt";
        pistasDoCrime(); //Esse e o metodo que vai imprimir as pistas do crime
        falaComLegista(); //Esse e o metdo que vai imprimir as gravaçoes do legista
        vereditoDoCaso(); //Esse e o metodo que vai fazer o chute de quem e o assasino
        epilogo(); //Esse e o metodo final que vai falar se voce acertou ou nao e imprimir o resumo e salva a pontuação

    }

    public static void pistasDoCrime() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        if(CONTROLADOR==1){
            String titulo1Dia = "1º Dia";
            String texto1Dia = """
                Você é um jovem investigador que acabou de ser transferido de sua cidade para trabalha em caso mais
                importante e relevante. Logo em seu primeiro dia você está indo para o seu trabalho e recebe uma messagem:
                     Capitão Novo
                   Bom dia novato, deixei vários casos em sua mesa dê uma olhada neles e para mais informações
                   vá até o legista. Considere esse seu presente de boas vindas                                                                                               
                """;
            Who_killed.ReprodutorAudio.leitura("Audios/Leitura02.wav", texto1Dia, titulo1Dia);
        }else{
            JOptionPane.showMessageDialog(
                    null,
                    """
                     Você acaba de conseguir passar de frase
                     A cada frase o jogo vai ficando mais dificil e desafiador                           
                    """,
                    "Proxima Frase",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        System.out.print(ESPACO+"                 CASO " + CONTROLADOR + "º" + ESPACO);
        Scanner input = new Scanner(new File(CAMINHO));
        CULPADO = input.nextLine();
        INOCENTES[0] = input.nextLine();
        INOCENTES[1] = input.nextLine();
        INOCENTES[2] = input.nextLine();
        RESUMO1 = input.nextLine();
        DIALOGO01 = input.nextLine();
        DIALOGO02 = input.nextLine();
        DIALOGO03 = input.nextLine();
        DIALOGO04 = input.nextLine();
        DIALOGO05 = input.nextLine();
        DIALOGO06 = input.nextLine();
        DIALOGO07 = input.nextLine();
        while (input.hasNext()) {
            System.out.println(input.nextLine());
        }
        if(CONTROLADOR ==1) {
            System.out.println(GREEN + "\nO capitão deixou esses casos para me testar?" +
                    "\nAhh, ele só deve precisar de uma opinião diferente. Né?" + RESET);
        }else{
            System.out.println(GREEN + "\nHum esse caso parece " +
                    "\n\tser mais desafiador" + RESET);
        }
        System.out.println(ESPACO);
        if(CONTROLADOR==1){
            String titulo1Dica = "Dica - Anotações";
            String texto1Dica = """
                Assim que você vai avançado no caso, terão algumas anotações, dicas e informações importantes no console.
                As informações são separadas em cores:
                    Azul - São informações que te forneceram sobre o caso
                    Verde - São obesevações que 'você' fez.
                    Roxo - São possiveis suspeitos                                                                                              
                """;
            Who_killed.ReprodutorAudio.leitura("Audios/Leitura03.wav", texto1Dica, titulo1Dica);
        }

    }

    public static void falaComLegista() throws InterruptedException {
        JOptionPane.showMessageDialog(
                null,
                """
                Após ler um pouco das informações sobre o caso você decide
                levantar e ir atrás do legista para saber um pouco mais.
                """,
                "Consequencia",
                JOptionPane.INFORMATION_MESSAGE
        );
        System.out.println(GREEN+"Necrotério fica a esquerda da sala\n do capitão no final do corredor."+RESET);
        JOptionPane.showMessageDialog(
                null,
                """
                Depois de andar um pouco você achar o necrotério e uma placa:
                   !FAÇA SILENCIO!
                Então você abre a porta cuidadosamente e entra.
                """,
                "necrotério Silecioso",
                JOptionPane.INFORMATION_MESSAGE
        );
        String[] stg = new String[0];
        Who_killed.Legista.main(stg);
    }

    public static void vereditoDoCaso() throws InterruptedException {
        System.out.println(ESPACO);
        JOptionPane.showMessageDialog(
                null,
                """
                Você volta para sua mesa e da uma olhada final nas informações e em suas anotações.
                Mas mesmo tendo alguma ideia do que pode ter acontecido, você não tem nenhum nome
                de suspeito.
                Mas ao examinar melhor sua mesa você encontra dentro da graveta várias ficha de suspeitos.
                """,
                "Consequencia",
                JOptionPane.INFORMATION_MESSAGE
        );
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
        if(CONTROLADOR==1){
            JOptionPane.showMessageDialog(
                    null,
                    """
                    Esse nomes em roxos no console são os pricipais suspeito de uma olha nas ficha dele
                    para ter uma ideia de quem e o culpado.
                    Caso queria ver alguma informação novamente basta olha no console.
                    """,
                    "Dica - Suspeitos",
                    JOptionPane.INFORMATION_MESSAGE
            );}
        while (SUCESSO) {
            String chute = JOptionPane.showInputDialog("Quem é o culpado?");
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
                JOptionPane.showMessageDialog(null,"O que? Esse nome não está na lista de suspeitos, melhor ler novamente.",
                        "Que?",JOptionPane.INFORMATION_MESSAGE,null);

            }
        }
    }

    public static void epilogo() throws IOException, InterruptedException, UnsupportedAudioFileException, LineUnavailableException {
        System.out.println(ESPACO);
        if (SUCESSO) {
            JOptionPane.showMessageDialog(null,"Seu papite estava CERTO" ,
                    "Resultado",JOptionPane.INFORMATION_MESSAGE,null);
            System.out.println(GREEN + "Consegui ACERTAR o meu "+ CONTROLADOR +"º caso" + RESET);
            System.out.println(BLUE + RESUMO2 + RESET);
            System.out.println("Pontuação --- " + PONTOS);
            PONTOCADACASO[CONTROLADOR] = 1;
            CONTROLADOR++;
            if (CONTROLADOR < 4) {
                jogo();
            } else {
                CONTROLADOR--;
                JOptionPane.showMessageDialog(null,"Parabéns Você Acertou Todos os Casos",
                        "Epilogo",JOptionPane.INFORMATION_MESSAGE,null);
                imprimirResumoFinal();
            }
        } else {
            JOptionPane.showMessageDialog(null,"Seu papite estava ERRADO" ,
                    "Fim de Jogo",JOptionPane.INFORMATION_MESSAGE,null);
            System.out.println(GREEN + "Eu ERREI o meu "+ CONTROLADOR +"º caso" + RESET);
            System.out.println(BLUE + RESUMO2 + RESET);
            PONTOCADACASO[CONTROLADOR] = 0;
            imprimirResumoFinal();
        }
    }

    public static void imprimirResumoFinal() throws IOException {
        System.out.println(ESPACO);
        System.out.println("\t========== Resumo final ==========");
        System.out.println("\t Jogador ---> " + NOME);
        System.out.println("\t Nick  --->  " + NICK);
        System.out.println("\t Pontuação:");
        for (int i = 1; i <= CONTROLADOR; i++) {
            System.out.println("\t\t Caso " + i + "º ---> " + PONTOCADACASO[i] + " Pontos");
            PONTOS += PONTOCADACASO[i];
        }
        System.out.println("\t Pontuação Final ---> " + PONTOS);
        System.out.println(ESPACO);
        writeFile();
    }

    public static void writeFile() throws IOException {
        FileWriter fw = new FileWriter(arquivo, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(String.format("*Nome = %s \t*Nick = %s \t *Pontuação = %d", NOME, NICK, PONTOS));
        bw.newLine();
        bw.close();
        fw.close();
    }
}