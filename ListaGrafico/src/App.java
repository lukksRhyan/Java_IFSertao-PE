import java.awt.*;
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
				frame.setExtendedState(Frame.MAXIMIZED_BOTH);//Tela cheia
				
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
		Image icone = kit.getImage("assets/icon.gif");
		this.setIconImage(icone);
		setTitle("Cunny");//UOGHHH 
		setSize(screenWidth/2, screenHeight/2);
		 
	}

	//public static final int DEFAULT_WIDTH = 300;
	//public static final int DEFAULT_HEIGHT = 200;
}
