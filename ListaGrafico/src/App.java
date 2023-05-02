import java.awt.*;
import java.awt.geom.Rectangle2D;

import javax.swing.*;
public class App {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				SimpleFrame frame = new SimpleFrame();//Cria o objeto, ver classe SimpleFrame
				ImageIcon img = new ImageIcon("assets/icon.gif");//Deveria Setar o icon
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Faz com que o programa encerre quando fechar a janela
				frame.setVisible(true);
				frame.setIconImage(img.getImage());
				//frame.setExtendedState(Frame.MAXIMIZED_BOTH);//Tela cheia
				
			}
		});
		
	}

}
class SimpleFrame extends JFrame{
	public SimpleFrame(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = (int)screenSize.getWidth();
		int screenHeight =(int) screenSize.getHeight();
		setSize(screenWidth/2, screenHeight/2);

		Image icone = kit.getImage("assets/icon.gif");
		this.setIconImage(icone);
		
		setTitle("Cunny");//UOGHHH 
		
		SimpleComponent componente  = new SimpleComponent();
		add(componente);
		
		Forma desenho = new Forma();
		add(desenho);
		
		
	}

	//public static final int DEFAULT_WIDTH = 300;
	//public static final int DEFAULT_HEIGHT = 200;
}
class SimpleComponent extends JComponent{
	public void paintComponent(Graphics g){
		g.drawString("Bites the Dust", 	MENSAGEM_X, MENSAGEM_Y);
	}
	public static final int MENSAGEM_X = 25;
	public static final int MENSAGEM_Y = 25;
}
class Forma extends JComponent{
	double altura = 800;
	double largura = 800;
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		double limiteEsq = 0;
		double limiteTopo = 0;
		
		Rectangle2D retangulo = new Rectangle2D.Double(limiteEsq, limiteTopo, largura, altura);
		
		g2.draw(retangulo);
		Quadrado quadrado = new Quadrado(100.0, 100.0);
		double espacamento = 0;
		boolean cor = true;

		for(int alturaAtual = 0; alturaAtual< this.altura; alturaAtual+= (quadrado.altura+espacamento)){
			for(int larguraAtual = 0; larguraAtual< this.largura;larguraAtual+=(quadrado.largura+espacamento)){
				Rectangle2D gQuadrado = quadrado.gerar(alturaAtual, larguraAtual);
				cor = !cor;
				g2.draw(gQuadrado);
				g2.setColor(Color.BLACK);
				if(cor) g2.setColor(Color.WHITE);
				g2.fill(gQuadrado);
				//limiteEsq +=quadrado.largura;
			}
		cor = !cor;
		//limiteTopo +=quadrado.altura;
		limiteEsq -= this.largura;
		}


	}
}
class Quadrado{
	double altura;
	double largura;
	Quadrado(){
		this(1.0,1.0);
	}
	Quadrado(double altura, double largura){
		this.altura = altura;
		this.largura = largura;
	}
	Rectangle2D gerar(double x, double y){
		return new Rectangle2D.Double(x, y, this.largura, this.altura);
	}
	
}