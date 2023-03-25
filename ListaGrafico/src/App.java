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
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		double limiteEsq = 100;
		double limiteTopo = 100;
		double largura = 200;
		double altura = 200;
		
		Rectangle2D retangulo = new Rectangle2D.Double(limiteEsq, limiteTopo, largura, altura);
		g2.draw(retangulo);


	}
}