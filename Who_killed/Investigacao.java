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
    public static String CULPADO, CAMINHO, RESUMO1, RESUMO2, DIALOGO01, DIALOGO02, DIALOGO03, NOME, NICK, DIALOGO04, DIALOGO05, DIALOGO06, DIALOGO07;
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
        String tituloLeitura01 = "Boas Vindas";
        String textoLeitura01 = """
                Bem Vindo ao Who Killed, o melhor e mais bem feito jogo de investigação.
                O jogo funciona da seguinte maneira:
                   -Dados e informações importantes serão impresos no console para facilitar a consulta.
                   -Você deve interagir com as caixas de diálogos ou de opções para avançar no jogo.
                   -Cada escolha sua tem consequêcias. Escolha com cuidado!
                   -Acerte o culpado para continuar para outro caso.
                                
                                                                               Boa Sorte!!!
                """;
        Who_killed.ReprodutorAudio.leitura("Audios/Leitura01.wav", textoLeitura01, tituloLeitura01);

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
        if (CONTROLADOR == 1) {
            String tituloLeitura02 = "1º Dia";
            String textoLeitura02 = """
                     Você é um jovem investigador que acabou de ser transferido de sua cidade para trabalhar em alguns casos mais
                     importantes. No seu primeiro dia a caminho do trabalho, você recebe uma mensagem:
                         Capitão
                       Bom dia novato, deixei vários casos em sua mesa. De uma olhada neles e para mais informações
                       vá até o legista. Conside esse seu presente de boas vindas.                             
                    """;
            Who_killed.ReprodutorAudio.leitura("Audios/Leitura02a.wav", textoLeitura02, tituloLeitura02);
        } else {
            String tituloLeitura02 = "Próximo crime";
            String textoLeitura02 = """
                     Ótimo, agora podemos ir para o próximo crime.
                     A cada fase o jogo ficará mais difícil.                            
                    """;
            Who_killed.ReprodutorAudio.leitura("Audios/Leitura02b.wav", textoLeitura02, tituloLeitura02);
        }
        System.out.print(ESPACO + "                 CASO " + CONTROLADOR + "º" + ESPACO);
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
        if (CONTROLADOR == 1) {
            System.out.println(GREEN + "\nO capitão deixou esses casos para me testar?" +
                    "\nAhh, ele só deve precisar de uma opinião diferente. Né?" + RESET);
        } else {
            System.out.println(GREEN + "\n\tHum esse caso parece " +
                    "\n\tser mais desafiador" + RESET);
        }
        System.out.println(ESPACO);
        if (CONTROLADOR == 1) {
            String tituloLeitura03 = "Dica - Anotações";
            String textoLeitura03 = """
                    Conforme o avanço do caso, você recebera algumas anotações, dicas e informações que serão de grande importância 
                    para solução dos casos. (Serão impressas no console) 
                                    
                    Cada informação é separada por uma cor:
                    Azul - Informações conseguidas sobre o caso.
                    Verde - Observações que foram feitas por 'você'.
                    Roxo - Nomes dos possíveis suspeitos. 
                    """;
            Who_killed.ReprodutorAudio.leitura("Audios/Leitura03.wav", textoLeitura03, tituloLeitura03);
        }

    }

    public static void falaComLegista() throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        if (CONTROLADOR > 1) {
            String tituloLeitura12 = "Proximo Caso";
            String textoLeitura12 = """
                    Você conseguiu acertar o caso anterior, agora você pega outra das fichas de sua 
                    mesa e se encontra em uma situação que precisa de mais informação, como antes.
                     """;
            Who_killed.ReprodutorAudio.leitura("Audios/Leitura12.wav", textoLeitura12, tituloLeitura12);
        }
        String tituloLeitura04 = "Mais Informações";
        String textoLeitura04 = """
                Como as informações que foram fornecidas até agora são limitadas,
                 você decide ir atrás do legista em busca de informações mais técnicas.
                 """;
        Who_killed.ReprodutorAudio.leitura("Audios/Leitura04.wav", textoLeitura04, tituloLeitura04);
        if (CONTROLADOR == 1) {
            System.out.println(GREEN + "Necrotério fica a esquerda da sala\n do capitão no final do corredor." + RESET);
            String tituloLeitura05 = "Necrotério";
            String textoLeitura05 = """
                    Ao chegar ao local, você procura pelo legista que de acordo com informações está no necrotério.
                    Andando pelos corredores você encontra o seu destino.
                                            
                    Silenciosamente você abre a porta e se depara com um senhor mexendo em um cadáver. 
                     """;
            Who_killed.ReprodutorAudio.leitura("Audios/Leitura05a.wav", textoLeitura05, tituloLeitura05);
        } else {
            String tituloLeitura05 = "Necrotério";
            String textoLeitura05 = """
                    Você novamente vai até a sala do legista, dessa vez ele está mexendo em um corpo,
                    é ele parece está muito distraído.
                    Você olha mais pela sala e vê outros corpos e mais fichas.                                             
                        """;
            Who_killed.ReprodutorAudio.leitura("Audios/Leitura05b.wav", textoLeitura05, tituloLeitura05);
        }
        String[] stg = new String[0];
        Who_killed.Legista.main(stg);
    }

    public static void vereditoDoCaso() throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        System.out.println(ESPACO);
        if (CONTROLADOR == 1) {
            String tituloLeitura06 = "Minha mesa";
            String textoLeitura06 = """
                    Você vai até sua mesa e analisa todas as informações e anotações .
                    A partir disso, você têm uma ideia do que pode ter acontecido, porém não tem nomes de um possível suspeito.
                                            
                    Mas ao abrir uma de suas gavetas encontra várias fichas criminais de possíveis suspeitos.   
                     """;
            Who_killed.ReprodutorAudio.leitura("Audios/Leitura06a.wav", textoLeitura06, tituloLeitura06);
        } else {
            String tituloLeitura06 = "Minha mesa";
            String textoLeitura06 = """
                    Você vai até sua mesa e analisa todas as informações e anotações.
                    A partir disso, você tem uma ideia do que pode ter acontecido, então 
                    você abre a gaveta com as fichas criminais de possíveis suspeitos.
                    Mas estão todas bagunçadas e juntas.
                             """;
            Who_killed.ReprodutorAudio.leitura("Audios/Leitura06b.wav", textoLeitura06, tituloLeitura06);
        }
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
        if (CONTROLADOR == 1) {
            String tituloLeitura07 = "Dica - Suspeitos";
            String textoLeitura07 = """
                    Os nomes dos possíveis suspeitos serão impressos em cor roxa no console.
                    Você poderá ter uma ideia de quem foi o culpado do crime.
                    Todas as informações anteriores estão presentes no console, caso precisem ser analisadas novamente.                          
                     """;
            Who_killed.ReprodutorAudio.leitura("Audios/Leitura07.wav", textoLeitura07, tituloLeitura07);
        }
        while (SUCESSO) {
            String chute = JOptionPane.showInputDialog("Quem é o culpado?");
            if (chute.equalsIgnoreCase(CULPADO)) {
                System.out.println("Sim, é ele mesmo");
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
                String tituloLeitura08 = "Que?";
                String textoLeitura08 = """
                        O que? Esse nome não está na lista de suspeitos, melhor ler novamente.                         
                         """;
                Who_killed.ReprodutorAudio.leitura("Audios/Leitura08.wav", textoLeitura08, tituloLeitura08);

            }
        }
    }

    public static void epilogo() throws IOException, InterruptedException, UnsupportedAudioFileException, LineUnavailableException {
        System.out.println(ESPACO);
        if (SUCESSO) {
            PONTOS++;
            String tituloLeitura09 = "Resultado";
            String textoLeitura09 = """
                    Você descobriu o autor do crime!                         
                     """;
            Who_killed.ReprodutorAudio.leitura("Audios/Leitura09.wav", textoLeitura09, tituloLeitura09);
            imprimirResumoDoCaso();
            System.out.println(GREEN + "Consegui ACERTAR o meu " + CONTROLADOR + "º caso" + RESET);
            System.out.println(BLUE + RESUMO1 + RESET);
            System.out.println("Pontuação --- " + PONTOS);
            CONTROLADOR++;

            if (CONTROLADOR < 4) {
                jogo();
            } else {
                CONTROLADOR--;
                String tituloLeitura10 = "Epilogo";
                String textoLeitura10 = """
                        Parabéns Você Acertou Todos os Casos!                       
                         """;
                Who_killed.ReprodutorAudio.leitura("Audios/Leitura10.wav", textoLeitura10, tituloLeitura10);
                imprimirResumoFinal();
            }
        } else {
            String tituloLeitura11 = "Fim de jogo";
            String textoLeitura11 = """
                    Seu palpite estava ERRADO. Fim de Jogo.                 
                     """;
            Who_killed.ReprodutorAudio.leitura("Audios/Leitura11.wav", textoLeitura11, tituloLeitura11);
            imprimirResumoDoCaso();
            System.out.println(GREEN + "Eu ERREI o meu " + CONTROLADOR + "º caso" + RESET);
            System.out.println(BLUE + RESUMO1 + RESET);
            PONTOCADACASO[CONTROLADOR] = 0;
            imprimirResumoFinal();
        }
    }

    public static void imprimirResumoFinal() throws IOException {
        System.out.println(ESPACO);
        System.out.println("\t========== Resumo final ==========");
        System.out.println("\t Jogador ---> " + NOME);
        System.out.println("\t Nick  --->  " + NICK);
        System.out.println("\t Pontuação Final ---> " + PONTOS);
        System.out.println("\t========== ============ ==========");
        System.out.println(ESPACO);
        writeFile();
        imprimirTodasPontuacoes();
    }

    public static void writeFile() throws IOException {
        FileWriter fw = new FileWriter(arquivo, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(String.format("-Nome = %s \t-Nick = %s \t -Pontuação = %d/3", NOME, NICK, PONTOS));
        bw.newLine();
        bw.close();
        fw.close();
    }

    public static void imprimirTodasPontuacoes() throws FileNotFoundException {
        Scanner input = new Scanner(new File("Who_killed/jogador.txt"));
        System.out.println(RED + "Registro de Jogadores:" + RESET);
        System.out.println(ESPACO);
        while (input.hasNext()) {
            System.out.println(input.nextLine());
            System.out.println(ESPACO);
        }
    }

    public static void imprimirResumoDoCaso() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        if (CONTROLADOR == 1) {
            String tituloLeitura13 = "Conclusão Caso 1º";
            String textoLeitura13 = """
                    Marcela Fernandes era aluna de Miguel, foi assim que se conheceram. Marcela estava com dificuldades em suas 
                    aulas (química) e acabou se aproveitando de seu professor solteiro para conseguir uma nota extra. Marcela o 
                    convidou para sua casa e os dois se encontraram, ela comprou um belo vinho tinto para eles tomarem. Mas 
                    durante o "encontro" dos dois, Miguel percebe que a intenção de Marcela era mínima e que ele estava perdendo
                     seu tempo. Com isso Miguel, que já tinha problemas de controle de raiva e ainda agora afetado pelo álcool, 
                     se descontrolou e aproveitou a primeira chance em que a jovem moça foi ao toalhete e envenenou a sua bebida.
                        """;
            Who_killed.ReprodutorAudio.leitura("Audios/Leitura13.wav", textoLeitura13, tituloLeitura13);
        } else if (CONTROLADOR == 2) {
            String tituloLeitura14 = "Conclusão Caso 2º";
            String textoLeitura14 = """
                    Elisa e Fernando se conheceram no local de trabalho de Elisa (Floricultura). Fernando acabou se "interessando"
                    pela jovem e começou a ir frequentemente na sua loja, sempre comprando uma flor. Começaram a criar uma amizade,
                    porém sempre deixaram claro que não teriam nenhum tipo de relacionamento. Um dia Elisa ficou até tarde da noite
                    na loja e no momento que saía se depara com Fernando, na porta da loja. Ele pergunta se ela aceita uma carona 
                    e ela diz que sim. Nesse momento que o plano de Fernando entra em ação, ao entrarem no carro, Fernando apaga 
                    Elisa e leva ela até o antigo Teatro da cidade, onde os seus desejos serão saciados.
                        """;
            Who_killed.ReprodutorAudio.leitura("Audios/Leitura14.wav", textoLeitura14, tituloLeitura14);
        } else if (CONTROLADOR == 3) {
            String tituloLeitura15 = "Conclusão Caso 3º";
            String textoLeitura15 = """
                    Natasha e Carlos conheceram-se em uma boate. Os dois haviam saído para curtir a noite e enquanto estavam se 
                    divertindo, Natasha se depara com Carlos a observando enquanto ela dança. Um tempo depois ela vai ao bar pegar 
                    um drink e ele vem atrás para conversar com ela. Os dois batem um papo e Carlos a chama para ir "para um lugar
                    mais privado" e Natasha nesse momento quase não consegue esconder o esboço de raiva no seu rosto. Ela já havia 
                    percebido a aliança no seu dedo. Nesse momento ela pensou em tudo, levar ele até um beco. Aproveitando a 
                    oportunidade, enquanto Carlos ia ao banheiro uma última vez, ela jogou um boa noite cinderela no seu copo, o 
                    qual o homem bebeu ao retornar até ela. O dois foram até o carro e dirigiram para um local próximo, porém deserto,
                    e ao chegar lá Carlos já estava apagado. Visto que ele desmaiou, Natasha prosseguiu em jogá-lo no chão e executar
                    ali mesmo a "operação".                
                    """;
            Who_killed.ReprodutorAudio.leitura("Audios/Leitura15.wav", textoLeitura15, tituloLeitura15);
        }

    }
}