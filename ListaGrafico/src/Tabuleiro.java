import java.awt.*;

public class Tabuleiro(){
    public Casa[][] casas;

    Tabuleiro(){
        this(8,800);
    }
    Tabuleiro(int tamanho, int dimensao){
        setSize(dimensao,dimensao);
        this.preencher(tamanho, dimensao);
        setTitle("Tabuleiro Xadrez");
        this.setVisible(true);
    }
    private void preencher(int tamanho, int dimensao){
        boolean par = false;
        for(int i = 0; i<8; i++){
            for(int j = 0; j<8; j++){
                Object cor = (par)? Color.WHITE : Color.BLACK;
                this.casas[i][j] = new Casa(i+1,j+1, (dimensao/tamanho));
                atual.setColor(cor)
                atual = this.casas[i][j];
                
            }
        }
    }
}
class Casa extends Frame{
    private int latitude;
    private int longitude;
    private Object cor;

    Casa(int longitude, int latitude, int dimensao){
        this.longitude = longitude;
        this.latitude = latitude;

        setBounds();
    }
    public int longitude (){
        return this.longitude;
    } 
    public int latitude(){
        return this.latitude;
    }

}