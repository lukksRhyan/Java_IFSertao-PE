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
    public void Adicionar(Object novoElemento){
        No novo = new No(novoElemento);
        this.Adicionar(novo);
    }
    public void AdicionarNoInicio(Object novoElemento){
        No novo = new No(novoElemento);
        novo.setProximo(primeiro);
        primeiro = novo;
    }
     public void inserir(No alvo,Object novoElemento){
        No novo = new No(novoElemento);
        No depois = alvo.getProximo();

        alvo.setProximo(novo);
        novo.setAnterior(alvo);

        depois.setAnterior(novo);
        novo.setProximo(depois);
    }
    public No busca(Object novoElemento){
        No atual = this.primeiro;
        while (atual.proximo!= null) {
            if(atual.elemento.equals(novoElemento)){
                return atual;
            }
            atual = atual.proximo;
        }
        return null;
    }
    public void substituir(Object antigo, Object novo){
        No alvo = this.busca(antigo);
        alvo.elemento = novo;
    }
    public int tamanho(){
        int total = 0;
        No atual = this.primeiro;
        while(atual.getProximo()!= null){
            total++;
            atual = atual.getProximo();
        }
        return total;
    }
    public No getPosicao(int pos){
        No atual = this.primeiro;
        for(int i = 1; (i <pos) && (atual.getProximo()!= null);i++){
            atual = atual.getProximo();
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
			s.append(", ");
            atual = atual.proximo;
        }
		if(this.numeroDeMembros > 0) {
			s.append(this.ultimo);
		}
		s.append("]");
		return s.toString();
    }
    //Prova 17-05-2023
    public void questao01(Object elemento){

        int ocorrenciasElemento = 0;
        int valoresMaiores = 0;
        No atual = this.primeiro;
        
        for(int i =1; atual.getProximo()!=null;i++){
            if(atual.getElemento() == elemento){
                ocorrenciasElemento++;
                System.out.println("Elemento encontrado na posicao:"+ i);
            }else if((int) atual.getElemento() > (int) elemento){//converti para int porque o > nao existe para objeto generico
                valoresMaiores++;
            }
            atual=atual.getProximo();
        }
        System.out.println("Numero de nos na lista: " + this.tamanho());
        System.out.println("Numero de ocorrencias do elemento: "+ ocorrenciasElemento);
        System.out.println("Casas com valores maiores que o elemento: "+ valoresMaiores);
    }
    static void questao02(ListaEncadeada L){
        for(int i = L.tamanho(); i>=0;i--){
            No atual = L.primeiro;
            for(int j = 0; j<i; j++){
                atual=atual.getProximo();
            }
            System.out.print(atual.getElemento()+ " , ");
        }
    }
    static void questao03(ListaEncadeada L, ListaEncadeada M, int posicao){
        No alvo = L.getPosicao(posicao);
        No sequente = alvo.getProximo();
        
        alvo.setProximo(M.primeiro);
        M.ultimo.setProximo(sequente);
        sequente.setAnterior(M.ultimo);
    }
    static void questao04(ListaEncadeada L, Object antigo, Object novo){
        No indo = L.primeiro;
        No voltando = L.ultimo;
        int i = 0;
        while((indo.getProximo()!= null)){
            if((int)indo.getElemento() == (int)antigo) indo.setElemento(novo);
            indo = indo.getProximo();
            if((int)voltando.getElemento() == (int)antigo) voltando.setElemento(0);
            voltando= voltando.getAnterior();
        }
    }
    //Questao 01 lista 11/05/23
    public No getNoMeio(){//Percorrendo a lista e voltando na metade
        No atual = this.primeiro;
        int nosLista;
        //Indo
        for(nosLista= 0;atual.proximo != null; nosLista++){
            atual = atual.proximo;
        }
        //Voltando
        for(int m = nosLista; m> (nosLista/2); m--){
            atual = atual.getAnterior();
        }
        return atual;
    }

    //Questao 02
    public void ocorrencias(Object o){
        No atual = this.primeiro;
        
        for(int nosLista = 0; atual.proximo != null; nosLista++){
            if(atual.elemento.equals(o)){
                System.out.println("Objeto encontrado na posicao " + (nosLista+1));
            }
            atual= atual.proximo;
        }
        
    }
    //Questao 03
    public void adicionarDepois(Object local, Object novo){
        No alvo = busca(local);
        if(alvo != null){
            inserir(alvo, novo);
        }else{
            System.out.println();
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