import java.util.Arrays;

public class Lista {
	private String[] elementos;
	private int tamanho;
	public int tamanho(){return this.tamanho;}	
	
	public Lista(){
		this(0);
	}
	public Lista(int capacidade) {
		this.elementos = new String[capacidade];
		this.tamanho = 0;
	}
	public Lista(Lista a, Lista b){
		this(a.elementos.length + b.elementos.length);
		for(int i = 0; i < a.tamanho; i++){
			this.adiciona(a.elementos[i]);
		}
		System.out.println(this.tamanho);
		for(int j = 0; j < b.tamanho; j++){//Muito burro kkkk eu comecava do Tamanho da outro lista sendo que pulava os elementos da lista de onde tava sendo tirado
			this.adiciona(b.elementos[j]);
		}
		System.out.println(this.tamanho);
	}
	public boolean adiciona(String elemento){
		if((this.tamanho <= this.elementos.length)) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
			return true;
		}else{
			this.aumentarCapacidade();
			this.elementos[this.tamanho()] = elemento;
		}
		return false;
	}
	public boolean forcarAdiciona(String elemento){

		try {
			if(this.tamanho == this.elementos.length){//Se tiver extrapolado o tamanho, nem sei se vai funcionar na vdd
				Lista nova = new Lista(this.elementos.length * 2);
				nova.absorve(this);
				nova.adiciona(elemento);
				this.elementos = nova.elementos;
				this.tamanho = nova.tamanho();
				return true;
			}else{
				this.adiciona(elemento);
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	public void insercao(String elemento, int pos){
		if(elemento!= null){
			if(pos > this.tamanho){
				this.adiciona(elemento);
				return;
			}
			if(this.tamanho>= this.elementos.length){
				this.aumentarCapacidade();
				this.tamanho++;
			}
			for (int i = tamanho; i > pos; i--) {
				this.elementos[i] = busca(i-1);
			}
			this.elementos[pos] = elemento;
			this.tamanho++;
		}
	}
	public String busca(int pos) {
		if(!(pos >=0) && (pos <= tamanho)) {
			throw new IllegalArgumentException("Posicao invalida.");
		}else {
			return elementos[pos];
		}
	}
	public String toString(){
		return Arrays.toString(this.elementos);
		
	}
	public String imprime() {
		StringBuilder s = new StringBuilder();
		s.append("[");
		for(int i = 0; i<this.tamanho-1;i++) {
			s.append(this.elementos[i]);
			s.append(", ");
		}
		if(this.tamanho > 0) {
			s.append(this.elementos[this.tamanho-1]);
		}
		s.append("]");
		return s.toString();
		
	}
	public void remover(int pos) {
		for(int i = pos; i<tamanho; i++) {
			elementos[i] = busca(i+1); //usa o metodo busca pra aproveitar o tratamento de excessao dela
		}
		tamanho-=1;
	}
	public int encontrar(String elemento){
		for (int i = 0; i < this.elementos.length; i++) {
			if(elemento.equalsIgnoreCase(this.elementos[i])){
				return i;
			}
		}
		return-1;
	}
	public void absorve(Lista menor){
		boolean cabe = (this.tamanho + menor.elementos.length) < this.elementos.length;
		if(cabe){
			for (int i = 0; i < menor.tamanho; i++){
				System.out.println(this);
				this.adiciona(menor.elementos[i]);
			}
		this.tamanho += menor.tamanho;
		}	
	}
	public void aumentarCapacidade(){
		Lista nova = new Lista(this.elementos.length * 2);
				nova.absorve(this);
				this.elementos = nova.elementos;
				this.tamanho = nova.tamanho();
	}
	
}
