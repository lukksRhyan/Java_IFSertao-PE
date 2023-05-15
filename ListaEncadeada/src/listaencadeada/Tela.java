package listaencadeada;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela extends JFrame {
    private JPanel panel;
    private JTextArea textArea;
    private JButton addButton;
    private JTextField textField;
    private JButton modifyButton;
    private JPanel botoes;

    private ListaEncadeada lista;
    public Tela() {
        lista = null;
        // Configurações básicas do JFrame
        setTitle("Lista Encadeada");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Criacao do JPanel principal
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Criacao da JTextArea para exibir a lista encadeada
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.PAGE_END);

        // Criacao do JButton para adicionar um novo membro à lista
        addButton = new JButton("Adicionar novo");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaAdd();
            }
        });
        
        // Criacao do JButton para modificar o membro selecionado na lista
        modifyButton = new JButton("Modificar");
        
        //panel.add(addButton, BorderLayout.PAGE_START);
        //panel.add(modifyButton, BorderLayout.PAGE_START);
        botoes =  new JPanel();
        botoes.add(modifyButton, BorderLayout.EAST);
        botoes.add(addButton, BorderLayout.WEST);
        
        panel.add(botoes, BorderLayout.NORTH);
        // Adiciona o JPanel principal ao JFrame
        add(panel);
        
        // Exibe o JFrame
        setVisible(true);
    }
    class TelaAdd extends JFrame{
        private JPanel panel;
        private JTextField textField;
        private JButton addButton;

        public TelaAdd(){
            setTitle("Adicionar novo membro");
            setSize(400, 200); 
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            panel = new JPanel();
            panel.setLayout(new BorderLayout());
            
            textField = new JTextField();
            panel.add(textField, BorderLayout.CENTER);
            
            add(panel);
            addButton = new JButton("Adicionar");
            addButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    String novoMembro = textField.getText();
                    System.out.println(novoMembro);
                    if(lista == null){
                        lista = new ListaEncadeada(new No(novoMembro));
                    }else{
                        lista.Adicionar(new No(novoMembro));
                    }
                    System.out.println(lista);
                    dispose();
                }
            });
            add(addButton, BorderLayout.PAGE_END);
            setVisible(true);



        }
    }
    public static void main(String[] args) {
        new Tela();
    }
}