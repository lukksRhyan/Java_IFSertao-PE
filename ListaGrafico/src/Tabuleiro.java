import java.awt.*;

public class Tabuleiro(){
    public Casa[][] casas;

    Tabuleiro(){
        this(8,800);
    }
    Tabuleiro(int tamanho, int dimensao){
        this.preencher(tamanho, dimensao);
        setTitle("Tabuleiro Xadrez");
        this.setVisible(true);
    }
    private void preencher(int tamanho, int dimensao){
        boolean par = false;
        for(int i = 0; i<8; i++){
            for(int j = 0; j<8; j++){
                Object cor = (par)? Color.WHITE : Color.BLACK;
                this.casas[i][j] = new Casa();
                atual = this.casas[i][j];
                
            }
        }
    }
}
class Casa extends Frame{
    private String latitude;
    private String longitude;
    private int dimensao;
    private Object cor;

    Casa(String longitude, String latitude, int dimensao){
        this.longitude = longitude;
        this.latitude = latitude;
        this.dimensao = dimensao;
    }
    public String longitude (){
        return this.longitude;
    } 
    public String latitude(){
        return this.latitude;
    }

}