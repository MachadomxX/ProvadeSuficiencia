import java.util.Scanner;

public class JogoDaVelha_Jogador {
    private char letra = 'X';
    private JogoDaVelhaMapa mapa;
    int linha;
    int coluna;
    public  JogoDaVelha_Jogador(JogoDaVelhaMapa mapa){
        this.mapa = mapa;
    }
    public boolean joga(Scanner teclado){
            // Entrada da linha e coluna do usuário
        while(true){
            System.out.println("Jogador .. ");
            System.out.println("linha: ");
            linha = teclado.nextInt();
            System.out.println("coluna: ");
            coluna = teclado.nextInt();
            if (0>linha || linha >2 || 0>coluna || coluna >2){
            }else if (mapa.jogar(linha, coluna, letra)){
                if (mapa.ganhou(letra)){
                    return true;
                }
                return false;
            }else{
                System.out.println("Coluna já ocupada");
            }

        }
    }
}
