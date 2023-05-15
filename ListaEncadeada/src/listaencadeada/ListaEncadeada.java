package listaencadeada;

public class ListaEncadeada {
    public No primeiro;
    public No ultimo;
    public int numeroDeMembros;

    ListaEncadeada(){
        this.primeiro = null;
        this.ultimo = null;
        this.numeroDeMembros=0;
    }
    ListaEncadeada(No membro){// A lista precisa de pelo menos um membro pra existir
        this.primeiro = membro;
        this.ultimo = membro;
        membro.setProximo(null);
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
        novo.setProximo(primeiro);
        primeiro = novo;
    }
     public void inserir(No antes,Object elemento){
        No novo = new No(elemento);
        No depois = alvo.getProximo();

        antes.setProximo(novo);
        novo.setAnterior(antes);

        depois.setAnterior(novo);
        novo.setProximo(depois);
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
   
    @Override
    public String toString(){

        StringBuilder s = new StringBuilder();
		s.append("[");
        No atual = this.primeiro;
		for(int nosLista = 0; atual.proximo != null; nosLista++) {
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

    //Questao 01 lista 11/05/23
    public No getNoMeio(){//Percorrendo a lista e voltando na metade
        No atual = this.primeiro;
        
        //Indo
        for(int nosLista = 0; atual.proximo != null; nosLista++){
            nosLista += 1;
            atual = atual.proximo;
        }
        //Voltando
        for(int m = nosLista; m> nosLista/2; m--){
            atual = atual.anterior;
        }
        return atual;
    }
    public No noDoMeio(){//contando o numero de membros e percorrendo metade dele
        No atual = this.primeiro;

        
        //Indo
        for(int nosLista = 0; atual.proximo != null; nosLista++){
            //nosLista += 1;
            atual = atual.getProximo();
        }

        noMeio = this.primeiro;
        for(int i= 0; i < nosLista/2; i++){
            noMeio = noMeio.getProximo();    
        }
    }

    //Questao 02
    public Lista ocorrencias(Object o){
        Lista L = new Lista(2);
        No atual = this.primeiro;
        
        for(int nosLista = 0; atual.proximo != null; nosLista++){
            if(atual.getElemento() == o){
                L.adiciona(nosLista);
            }
        }
        
    }
    //Questao 03
    public void adicionarDepois(Object local, Object novo){
        No alvo = busca(Object);
        if(alvo != null){
            inserir(alvo, novo);
        }else{
            System.out.Println();
        }

    }
    //Questao 04
    static void remover(ListaEncadeada L, Object X){
        No atual = L.primeiro;
        ListaEncadeada nova = new ListaEncadeada();
        while(atual.getProximo() != null){
            if(atual.getElemento() != X){
                nova.Adicionar(atual);
            }
            atual = atual.proximo;
        }
    }
    
}
//Questao 05
class ListaReversa extends ListaEncadeada{
    ListaReversa(No primeiro){
       this.primeiro = primeiro;
    }
    @Override
    public void Adicionar(No novo) {
        primeiro.setAnterior(novo);
        this.primeiro = novo;
    }
}