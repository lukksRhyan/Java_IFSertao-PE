
public class App {

	public static void main(String[] args) {
		
		Lista lista = new Lista(5);
		System.out.println(lista);
		
		
		lista.adiciona("10");
		System.out.println(lista.tamanho());
		
		lista.adiciona("20");
		System.out.println(lista.tamanho());
		
		lista.adiciona("30");
		System.out.println(lista.tamanho());
		
		System.out.println("Atualizada: "+lista.imprime());
		
		lista.insercao("40", 0);
		System.out.println(lista.tamanho());
		System.out.println(lista);
		lista.remover(0);
		lista.insercao("ddd", 500);
		System.out.println(lista.tamanho());
		System.out.println(lista.imprime());

	}

}
