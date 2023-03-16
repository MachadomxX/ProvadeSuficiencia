public class JogoDaVelha_PC {
    private char letra = 'O';
    private JogoDaVelhaMapa mapa;
    int linha;
    int coluna;
    public  JogoDaVelha_PC(JogoDaVelhaMapa mapa){
        this.mapa = mapa;
        
    }
    public boolean joga(){
            // usa o sortear para definir a jogada do PC, caso ja esteja ocupado o local ele joga novamente
        do{linha = mapa.sortear(0, 2);
            coluna = mapa.sortear(0, 2);
        }while(mapa.jogar(linha, coluna, letra) == false);
        System.out.printf("PC[%d,%d] \r\n", linha, coluna);
        if (mapa.ganhou(letra)){
            return true;     
        }
        return false;
    }
}