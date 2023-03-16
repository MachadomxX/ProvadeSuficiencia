import java.util.Scanner;

public class JogoDaVelha {
    private static JogoDaVelhaMapa jogoMapa;
    private static JogoDaVelha_PC jogoPC;
    private static JogoDaVelha_Jogador jogoJogador;
    static int jogadas = 0;
    
    public static void main(String[] args) throws Exception {
        boolean jogando = true;
        Scanner teclado = new Scanner(System.in);
        jogoMapa = new JogoDaVelhaMapa();
        jogoPC = new JogoDaVelha_PC(jogoMapa);
        jogoJogador = new JogoDaVelha_Jogador(jogoMapa);
        // loop do jogar novamente
        while(jogando){
            jogar(teclado);
            System.out.println("________________________ \r\n Deseja jogar novamente (s/n)?");
            switch(teclado.next()){
                case "s":
                    jogadas = 0;
                    break;
                case "n":
                    jogando = false;
                    break;
            }
        }
    }

    public static void jogar(Scanner teclado){
        //o jogo em si
        if(jogadas==0){
            jogoMapa.limpaMapa();
            int inicio = jogoMapa.sortear(0, 1);
            while (true){
                jogoMapa.desenha(jogadas);
                if((inicio%2)== 0 ){
                    //verifica se o PC ganhou
                    if (jogoPC.joga()){
                        jogadas++;
                        jogoMapa.desenha(jogadas);
                        System.out.println(" ... PC GANHOU! \r\n");
                        break;  
                    };
                }else{
                    //verifica se o jogador ganhou
                    if (jogoJogador.joga(teclado)){
                        jogadas++;
                        jogoMapa.desenha(jogadas);
                        System.out.println(" ... Jogador GANHOU! \r\n");
                        break;
                    };
                }
                //verifica se empatou
                if(jogadas==8 && jogoMapa.ganhou('X') == jogoMapa.ganhou('O')){
                    jogadas++;
                    jogoMapa.desenha(jogadas);
                    System.out.println("... EMPATOU!\r\n");
                    break;
                }
                inicio++;
                jogadas++;
            }            
        }            
    }
}
