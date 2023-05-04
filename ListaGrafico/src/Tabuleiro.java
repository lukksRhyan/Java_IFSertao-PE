import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Tabuleiro extends JFrame{
    private JPanel painelTabuleiro;
    private JPanel[][] casasTabuleiro = new JPanel[8][8];

    public Tabuleiro(){
        setTitle("Tabuleiro de Xadrez");
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        
        painelTabuleiro = new JPanel(new GridLayout(8, 8));
        contentPane.add(painelTabuleiro, BorderLayout.CENTER);
        boolean cor = false;
        for(int y = 0; y < 8; y++){
                for(int x = 0; x < 8; x++){
                casasTabuleiro[x][y] = new JPanel(new BorderLayout());
                painelTabuleiro.add(casasTabuleiro[x][y]);
                if (cor){
                    casasTabuleiro[x][y].setBackground(Color.WHITE);
                }else{
                    casasTabuleiro[x][y].setBackground(Color.BLACK);
                }
                cor = !cor;
            }
            cor = !cor;
        }
        for(int y = 0; y < 2; y++){
                for(int x = 0; x < 8; x++){
        casasTabuleiro[x][y].add(new Peca(Color.RED));             
            }
        }
        for(int y = 6; y < 8; y++){
                for(int x = 0; x < 8; x++){
       casasTabuleiro[x][y].add(new Peca(Color.BLUE));                
            }
        }
        setVisible(true);
    }
    private void possiveisDestinos(int x, int y, Color cor){
        if(cor == Color.RED){
            try{casasTabuleiro[x-1][y+1].add(new Peca(Color.BLACK));
}
        }
    }
    private void moverPeca(JPanel origem, JPanel destino){
        if(origem.getComponentCount() == 0){
            destino.add(origem.getComponent(0));
            origem.remove(0);
        } 
    }
    public static void main(String[] args) {
        new Tabuleiro();
    }
}
class Peca extends JButton{
    Color cor;
    public Peca(Color cor){
        this.cor = cor;
        Peca propria = this;
        this.addActionListener(new ActionListener(){
            public void actionPerformed(){
                propria.setBackground(Color.BLACK);
            }
        });
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(this.cor);
        g.drawOval(5,5,35,35);
        g.fillOval(5,5,35,35);
        setOpaque(false);
        setBackground(this.cor);
    }
}