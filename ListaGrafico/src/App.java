import java.awt.*;
import javax.swing.*;
public class App {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				SimpleFrame frame = new SimpleFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});

	}

}
class SimpleFrame extends JFrame{
	public SimpleFrame(){
		 setSize(screenWidth/2, screenHeight/2);
		 setTitle("Cunny");
	}
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize = kit.getScreenSize();
	int screenWidth = (int)screenSize.getWidth();
	int screenHeight =(int) screenSize.getHeight();
	Image icon = kit.getImage("assets/icon.png");
	@Override
	public void setIconImage(Image arg0) {
		super.setIconImage(icon);
	}
	//public static final int DEFAULT_WIDTH = 300;
	//public static final int DEFAULT_HEIGHT = 200;
}
