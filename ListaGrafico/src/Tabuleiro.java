import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Tabuleiro extends JFrame{
    private JPanel painelTabuleiro;
    private JPanel[][] casasTabuleiro = new JPanel[8][8];
    //definicao da classe
    public Tabuleiro(){
        //Configuracao da janela
        setTitle("Tabuleiro de Xadrez");
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        
        //Criacao do tabuleiro na janela
        painelTabuleiro = new JPanel(new GridLayout(8, 8));
        contentPane.add(painelTabuleiro, BorderLayout.CENTER);

        //Criacao das casas do tabuleiro
        boolean cor = false;//Tipo boolean que é bnario igual as casas do tabuleiro
        for(int linha = 0; linha < 8; linha++){            
                for(int coluna = 0; coluna < 8; coluna++){
                casasTabuleiro[coluna][linha] = new JPanel(new BorderLayout());
                painelTabuleiro.add(casasTabuleiro[coluna][linha]);
                //JTextField coord  = new JTextField(coluna + "x" + linha);
                //coord.setOpaque(false);
                //casasTabuleiro[coluna][linha].add(coord);
                if (cor){
                    casasTabuleiro[coluna][linha].setBackground(Color.WHITE);
                }else{
                    casasTabuleiro[coluna][linha].setBackground(Color.GREEN);
                }
                cor = !cor;
            }
            cor = !cor;
        }
        //Insere as pecas vermelhas
        for(int linha = 0; linha < 2; linha++){
                for(int coluna = 0; coluna < 8; coluna++){
        casasTabuleiro[coluna][linha].add(new Peca(Color.RED, coluna,linha));             
            }
        }
        //Insere as pecas azuis
        for(int linha = 6; linha < 8; linha++){
                for(int coluna = 0; coluna < 8; coluna++){
            casasTabuleiro[coluna][linha].add(new Peca(Color.BLUE, coluna, linha));                
            }
        }
        setVisible(true);
        //casasTabuleiro[5][5].remove(getComponent(0));
        casasTabuleiro[5][5].add(casasTabuleiro[6][6].getComponent(0));
        casasTabuleiro[6][6].remove(getComponent(0));
    }
    private void possiveisDestinos(int x, int y, Color cor){
        if(cor == Color.RED){
            try{
                casasTabuleiro[x-1][y+1].add(new Selecionavel());
            }catch(Exception e){}
        }
    }
   
    public static void main(String[] args) {
        new Tabuleiro();
    }
    class Peca extends JButton{
        Color cor;
        int linhaAtual;
        int colunaAtual;
        int direcao;
        boolean time;
        public Peca(Color cor, int linhaAtual, int colunaAtual){
            this.cor = cor;
            this.linhaAtual = linhaAtual;
            this.colunaAtual = colunaAtual;
            addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("clique reconhecido");
                    possiveisDestinos(linhaAtual, colunaAtual, cor);
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
     private void moverPeca(Selecionavel destino){
        Container origem = this.getParent();
            if(origem.getComponentCount() == 0){
                destino.add(origem.getComponent(0));
                origem.remove(0);
            } 
        }
    }
    class Selecionavel extends JButton{
        Selecionavel(){
            setBackground(Color.BLACK);
        }
        public void paintComponent(Graphics g){
            System.out.println("Retangulo chamado");
            g.drawRect(0, 0, 50, 50);
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, 50, 50);
        }
    }
}