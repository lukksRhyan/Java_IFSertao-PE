package listaencadeada;
public class App {

    public static void main(String[] args) {
        ListaEncadeada classe = new ListaEncadeada();

        classe.Adicionar("1");
        classe.Adicionar(1);
        classe.Adicionar("um");

        System.out.println(classe.toString());
        
        
    }
    
}
