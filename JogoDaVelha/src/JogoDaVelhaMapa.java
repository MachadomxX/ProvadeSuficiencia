public class JogoDaVelhaMapa {
    private char[][] mapa = new char[3][3];
    
    public int sortear(int inicio, int fim){
        //sorteia um número dentro dos parámetros passados
        // Utilizando o Math.random
        return (int)(Math.random()*(fim-inicio+1)+inicio);
    }
    public void limpaMapa(){
        // limpa o mapa
        for(int x = 0; x<=2; x++){
            for(int y = 0; y<=2; y++){
                mapa[x][y] = ' ';
            }
        } 

    }
    public void desenha(int jogada){
        // desenha o jogo
        System.out.println("-------------  ..  jogada: "+ jogada);
        for(int x = 0; x<=2; x++){
            System.out.printf("| %c | %c  | %c  | \r\n", mapa[x][0], mapa[x][1], mapa[x][2]);
        }
        System.out.println("----------------------------");
    }
    public boolean jogar(int l, int c, char jogador){
        // faz a jogada
        if (mapa[l][c]== ' '){
            this.mapa[l][c] = jogador;
            return true;
        }
        return false;
    }
    public boolean ganhou(char jogador){
        for(int x = 0; x<=2; x++){
            // verificar se alguém ganhou 
            if( (mapa[x][0] == mapa[x][1] && mapa[x][1] == mapa[x][2] && mapa[x][0]==jogador) ||(mapa[0][x] == mapa[1][x] && mapa[1][x] == mapa[2][x] && mapa[0][x]== jogador)){
                return true;
            }
        }
        if( (mapa[0][0] == mapa[1][1] && mapa[1][1] == mapa[2][2] && mapa[0][0]== jogador) || (mapa[2][0] == mapa[1][1] && mapa[1][1] == mapa[0][2] && mapa[1][1]== jogador)){
            return true;
        }
        return false;
    }

}