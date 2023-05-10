package listaencadeada;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class Tela extends JFrame{
    public Tela(){

        setTitle("Lista encadeada");
        setSize(600, 600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    
        CaixaTexto texto = new CaixaTexto();
        add(texto);
    }
}

class CaixaTexto extends JComponent{
    public void paintComponent(graphics g){
        Graphics2D g2 = (Graphics2D) g;
        String texto = "Lista encadeada";
        Font f = new  Font("Serif", Font.BOLD, 36);
        g2.setFont(f);

        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D limites = f.getStringBounds(texto, context);

        double x = (getWidth()- limites.getWidth()) /2;
        double y = (getHeight() - limites.getHeight()/2);

        double ascent =  -limites.getY();
        double YBase = ascent + y;

        g2.drawString(texto, (int) x, (int) YBase);
        g2.setPaint(Color.BLACK);

        g2.draw(new Line2D.Double(x,YBase,x+limites.getWidth(),YBase));
        
        Rectangle2D rect = new Rectangle2D.Double(x, y, limites.getWidth(), limites.getHeight());
        g2.draw(rect);
    }
}