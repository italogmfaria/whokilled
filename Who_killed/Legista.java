package Who_killed;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;


public class Legista {
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        final Object[] optionsA = {
                "Ir até o legista",
                "Bisbilhotar a sala",
                "Sair da sala"
        };
        String textoLeituraA = """
                Ao entrar na sala você tem que tomar um decisão: 
                """;
        String tituloLeituraA = "Necrotério";
        //String consequenciaA = "";
        switch (Who_killed.ReprodutorAudio.leituraEscolhas("Audios/LeituraA.wav", optionsA, textoLeituraA, tituloLeituraA)) {
            case 0:
                /*consequenciaA = "Chegando até ele, você diz:
                        - Posso tomar um minuto do seu tempo?Acabei de ser transferido para esse caso. ";
                dialogoB(consequenciaA);*/

                String tituloLeituraA1 = "Ir até ele";
                String textoLeituraA1 = """
                        Chegando até ele, você diz: 
                         - Posso tomar um minuto do seu tempo? Acabei de ser transferido para esse caso.
                        """;
                Who_killed.ReprodutorAudio.leitura("Audios/LeituraA_1.wav", textoLeituraA1, tituloLeituraA1);
                dialogoB();
                break;
            case 1:
                /*consequenciaA = "Analisando tudo, você encontra uma ficha que está do lado de um corpo. Dentro dela tem uma ficha.";
                dialogoC(consequenciaA);*/

                String tituloLeituraA2 = "Bisbilhotar a sala";
                String textoLeituraA2 = """
                        Ao analisar tudo, você encontra uma ficha que está do lado de um corpo.
                        """;
                Who_killed.ReprodutorAudio.leitura("Audios/LeituraA_2.wav", textoLeituraA2, tituloLeituraA2);
                dialogoC();
                break;
            case 2:
                /*consequenciaA = "Você sai da sala do lesgista";
                dialogoD(consequenciaA);*/
                String tituloLeituraA3 = "Sair da sala";
                String textoLeituraA3 = """
                        Você sai da sala do legista.
                        """;
                Who_killed.ReprodutorAudio.leitura("Audios/LeituraA_3.wav", textoLeituraA3, tituloLeituraA3);
                break;

        }

    }

    public static void dialogoB() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        final Object[] optionsB = {
                "Gostaria de saber mais sobre o caso",
                "A vítima oque pode falar mais sobre ela",
                "Ah so gostaria de falar um oi"
        };
        String textoLeituraB = """
                Com tom irônico o legista diz: 
                - E ai novato, o que quer aqui?""";
        String tituloLeituraB = "Um minuto do seu tempo?";
        switch (Who_killed.ReprodutorAudio.leituraEscolhas("Audios/LeituraB.wav", optionsB, textoLeituraB, tituloLeituraB)) {
            case 0:
                String tituloLeituraB_1 = "Mais sobre o caso";
                String textoLeituraB_1 = """
                        O legista abre e pega de dentro de uma gaveta uma ficha sobre o caso.
                        E começa a falar com você:
                        """;
                Who_killed.ReprodutorAudio.leitura("Audios/LeituraB_1.wav", textoLeituraB_1, tituloLeituraB_1);
                dialogoB1();
                break;
            case 1:
                String tituloLeituraB_2 = "Mais sobre a vítima";
                String textoLeituraB_2 = """
                        O legista levanta e vai até uma mesa com o corpo da vítima, e pega uma ficha ao lado.
                        Olha para você e começa a falar:
                        """;
                Who_killed.ReprodutorAudio.leitura("Audios/LeituraB_2.wav", textoLeituraB_2, tituloLeituraB_2);
                dialogoB2();
                break;
            case 2:
                String tituloLeituraB_3 = "Sair da sala";
                String textoLeituraB_3 = """
                        O legista te olha estranho e fala:
                        - Oi. Tá você sabe onde e a porta, to ocupado.
                        Então ele vira e volta a fazer oque estava fazendo e você sai da sala.
                        """;
                Who_killed.ReprodutorAudio.leitura("Audios/LeituraB_3.wav", textoLeituraB_3, tituloLeituraB_3);
                break;

        }
    }

    public static void dialogoB1() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        final Object[] optionsB1 = {
                "Tem alguma dica de como seria o assasino?",
                "Algum detalhe te chama a ateção nesse caso?"
        };
        String textoLeituraB1 = Investigacao.DIALOGO04;
        String tituloLeituraB1 = "Uma ficha na gaveta";
        String consequenciaB1;
        switch (Who_killed.ReprodutorAudio.leituraEscolhas("Audios/LeituraCrime00_0.wav", optionsB1, textoLeituraB1, tituloLeituraB1)) {
            case 0:
                String tituloLeituraB_3a = "Como seria o assasino?";
                consequenciaB1 = Investigacao.DIALOGO05;
                Who_killed.ReprodutorAudio.leitura("Audios/LeituraCrime00_0.wav", consequenciaB1, tituloLeituraB_3a);
                System.out.println(Investigacao.GREEN + "\n" + tituloLeituraB_3a + "\n" +
                        consequenciaB1 + Investigacao.RESET);
                dialogoE();
                break;
            case 1:
                String tituloLeituraB_3b = "Algum detalhe te chama a ateção nesse caso?";
                consequenciaB1 = Investigacao.DIALOGO06;
                Who_killed.ReprodutorAudio.leitura("Audios/LeituraCrime00_0.wav", consequenciaB1, tituloLeituraB_3b);
                System.out.println(Investigacao.GREEN + "\n" + tituloLeituraB_3b + "\n" +
                        consequenciaB1 + Investigacao.RESET);
                dialogoE();
                break;

        }
    }

    public static void dialogoB2() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        final Object[] optionsB2 = {
                "Fala mais sobre a vítima em sí",
                "Conte mais sobre a morte dele(a)"
        };
        String textoLeituraB2 = Investigacao.DIALOGO01;
        String tituloLeituraB2 = "Necrotério";
        String consequenciaB2 = "";
        switch (Who_killed.ReprodutorAudio.leituraEscolhas("Audios/LeituraCrime00_0.wav", optionsB2, textoLeituraB2, tituloLeituraB2)) {
            case 0:
                String tituloLeituraB2a = "Fale mais sobre a vítima em sí";
                consequenciaB2 = Investigacao.DIALOGO02;
                Who_killed.ReprodutorAudio.leitura("Audios/LeituraCrime00_0.wav", consequenciaB2, tituloLeituraB2a);
                System.out.println(Investigacao.GREEN + "\n" + tituloLeituraB2a + "\n" +
                        consequenciaB2 + Investigacao.RESET);
                dialogoE();
                break;
            case 1:
                String tituloLeituraB2b = "Conte mais sobre a morte dele(a)";
                consequenciaB2 = Investigacao.DIALOGO03;
                Who_killed.ReprodutorAudio.leitura("Audios/LeituraCrime00_0.wav", consequenciaB2, tituloLeituraB2b);
                System.out.println(Investigacao.GREEN + "\n" + tituloLeituraB2b + "\n" +
                        consequenciaB2 + Investigacao.RESET);
                dialogoE();
                break;

        }
    }

    public static void dialogoC() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        final Object[] optionsC = {
                "Olhar o corpo",
                "Ver as fichas"
        };
        String textoLeituraC = "O corpo e a ficha batem com as informações recebidas anteriormente sobre a vítima do caso.";
        String tituloLeituraC = "Necrotério";


        String consequenciaC = "";
        switch (Who_killed.ReprodutorAudio.leituraEscolhas("Audios/LeituraC.wav", optionsC, textoLeituraC, tituloLeituraC)) {
            case 0:
                String tituloLeituraC_1 = "Necrotério";
                String textoLeituraC_1 = """
                        Antes de você conseguir olhar o corpo mais de perto, escuta uma voz dizendo: 
                        """;
                Who_killed.ReprodutorAudio.leitura("Audios/LeituraC_1.wav", textoLeituraC_1, tituloLeituraC_1);
                dialogoC3();
                break;
            case 1:
                consequenciaC = Investigacao.DIALOGO07;
                String tituloLeituraC_2 = "Necrotério";
                String textoLeituraC_2 = """
                        Ao olha mais de perto você encontra um pequeno bilhete em uma ficha do mesmo caso.
                                E nele esta escrito: 
                        """ + consequenciaC +
                        "\nMas então você escuta:";
                System.out.println(Investigacao.GREEN + "\nUm pequeno bilhete com anotações\n" +
                        consequenciaC + Investigacao.RESET);
                Who_killed.ReprodutorAudio.leitura("Audios/LeituraC_2.wav", textoLeituraC_2, tituloLeituraC_2);

                dialogoC3();
                break;


        }

    }


    public static void dialogoC3() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        String tituloLeituraC3 = "Necrotério";
        String textoLeituraC3 = """
                - Tá fazendo o que aqui? Pode ir saindo de perto.
                 O legista vem em sua direção e começa a falar agressivamente:
                - Você só pode ser o novato, ta querendo informações do seu caso?. Você não pode só chegar
                   e ir mexendo nas coisas assim!
                 """;
        Who_killed.ReprodutorAudio.leitura("Audios/LeituraC_3.wav", textoLeituraC3, tituloLeituraC3);
        dialogoE();
    }

    public static void dialogoE() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        String tituloLeituraE = "Necrotério";
        String textoLeituraE = """
                Toc Toc! Você escuta alguem batendo na porta, um jovem abre e fala:
                 - Legista, o capitão esta te chamando na sala dele, parece ser urgente!
                Você acompanha o legista até de fora da sala, ele olha para você e diz: 
                 - Tenho que ir ver oque ele quer, tudo que precisa está na sua mesa.
                 """;
        Who_killed.ReprodutorAudio.leitura("Audios/LeituraE.wav", textoLeituraE, tituloLeituraE);
    }
}
