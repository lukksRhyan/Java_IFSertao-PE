package listaencadeada;
public class App {

    public static void main(String[] args) {
        ListaEncadeada meses = new ListaEncadeada();

        meses.Adicionar(1);
        meses.Adicionar(2);
        meses.Adicionar(3);
        meses.Adicionar(4);
        meses.Adicionar(5);
        meses.Adicionar(6);
        meses.Adicionar(7);
        meses.Adicionar(8);
        meses.Adicionar(9);
        meses.Adicionar(10);
        meses.Adicionar(11);
        meses.Adicionar(12);

        //Metodos a partir da linha 99 de ListaEncadeada.java
        System.out.println("Lista completa: "+meses+ "\n");
        System.out.println("Questao 01: ");
        meses.questao01(3);

        System.out.println("\nQuestao 02: ");
        ListaEncadeada.questao02(meses);

        System.out.println("\n\nQuestao 03:");
        ListaEncadeada anosCopa = new ListaEncadeada();
        anosCopa.Adicionar(2010);
        anosCopa.Adicionar(2014);
        anosCopa.Adicionar(2018);
        anosCopa.Adicionar(2022);
        anosCopa.Adicionar(2026);
        System.out.println("Lista a ser inserida: " + anosCopa);

        ListaEncadeada.questao03(meses,anosCopa, 4);
        System.out.println(meses);
        
        System.out.println("\nQuestao 04: ");
        ListaEncadeada.questao04(meses, 2010, 0);
        ListaEncadeada.questao04(meses, 2014, 0);
        ListaEncadeada.questao04(meses, 2018, 0);
        ListaEncadeada.questao04(meses, 2022, 0);
        ListaEncadeada.questao04(meses,2026 , 0);
        System.out.println(meses);

        System.out.println("Atividade");
        System.out.println("Questao 01 - Membro do meio:");
        System.out.println(meses.getNoMeio());
        
        String Inicial = "JAN";
        
        System.out.println("Questao 03 - Inserir depois");
        meses.adicionarDepois("MAI", Inicial);
        System.out.println("Lista apos insercao" +  meses);

        System.out.println("Questao 02 - Encontrar elemento");
        meses.ocorrencias(Inicial);
    }
    
}
