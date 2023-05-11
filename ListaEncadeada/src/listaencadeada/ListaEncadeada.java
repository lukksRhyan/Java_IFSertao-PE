package listaencadeada;

public class ListaEncadeada {
    private No primeiro;
    private No ultimo;
    private int numeroDeMembros;

    ListaEncadeada(){
        this.primeiro = null;
        this.ultimo = null;
        this.numeroDeMembros=0;
    }
    ListaEncadeada(No membro){// A lista precisa de pelo menos um membro pra existir
        this.primeiro = membro;
        this.ultimo = membro;
        membro.setProximo() = null;
        membro.setAnterior(null);
        this.numeroDeMembros = 1; 
    }
    public void Adicionar(No novo){
        if(this.ultimo == null){
            this.primeiro = novo;
            this.ultimo = novo;
            this.numeroDeMembros = 1; 
        }
        this.ultimo.proximo = novo;//Ja entrega o novo membro como sucessor do ultimo.
        novo.setAnterior(this.ultimo);
        this.ultimo = novo;//So aqui substitui o ultimo
        this.numeroDeMembros +=1;//Aumenta o tamanho da lista apos ter adicionado o membro
    }
    public void Adicionar(Object elemento){
        No novo = new No(elemento);
        this.Adicionar(novo);
    }
    public void AdicionarNoInicio(Object elemento){
        No novo = new No(elemento);
        novo.setProximo() = primeiro;
        primeiro = novo;
    }
    public No busca(Object elemento){
        No atual = this.primeiro;
        while (atual.proximo!= null) {
            if(atual.ocupante.equals(elemento)){
                return atual;
            }
        }
        return null;
    }
    public void substituir(Object antigo, Object novo){
        No alvo = this.busca(antigo);
        alvo.ocupante = novo;
    }
    public int tamanho(){
        return this.numeroDeMembros;
    }
    public No getPosicao(int pos){
        No atual = this.primeiro;
        for(int i = 0; i <=pos;i++){
            atual = atual.proximo;
        }
        return atual;
    }
    public void inserir(Object elemento, int posicao){
        No antigo = getPosicao(posicao-1);
        No novo = new No(antigo, elemento, antigo.proximo);
        antigo.proximo.setAnterior(novo);
        antigo.setProximo(novo);
    }
    @Override
    public String toString(){

        StringBuilder s = new StringBuilder();
		s.append("[");
        No atual = this.primeiro;
		while(atual.proximo != null) {
			s.append(atual.toString());
			s.append(", \n");
            atual = atual.proximo;
        }
		if(this.numeroDeMembros > 0) {
			s.append(this.ultimo);
		}
		s.append("]");
		return s.toString();
    }
}