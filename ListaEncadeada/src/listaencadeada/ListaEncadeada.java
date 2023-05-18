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
        System.out.println("Metodo adicionar chamado");
        if(this.primeiro == null){
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
		for(int nosLista = 0;atual.getProximo()!= null; nosLista++) {
			s.append(atual.toString());
			s.append(", ");
            atual = atual.getProximo();
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

    static ListaEncadeada questaoExtra(ListaEncadeada L, ListaEncadeada M ){
        ListaEncadeada nova = new ListaEncadeada();
        
        No atualL = L.primeiro;
        No atualM = M.primeiro;
        System.out.println(L);
        System.out.println(M);
        while((atualL!= null)||(atualM!=null)){
            int elementoL = -1;
            int elementoM = -1;
            
            try {
                elementoM =(int) atualM.elemento;
                elementoL =(int) atualL.elemento;
                System.out.println("M: " + elementoM);
                System.out.println("L: " + elementoL);
                if(elementoL == elementoM){
                    nova.Adicionar(elementoM);
                    nova.Adicionar(elementoL);
                    System.out.println("igual");
                }
                if(elementoL< elementoM){
                    System.out.println("Comparacao");
                    nova.Adicionar(elementoM);
                    atualM = atualM.getProximo();
                }else{
                    nova.Adicionar(elementoL);
                    atualL= atualL.getProximo().getProximo();
                }
            } catch (Exception e) {
                System.out.println("erro!");
                if(atualL == null){
                    nova.Adicionar(elementoM);
                    atualM = atualM.getProximo();
                }
                if(atualM == null){
                    nova.Adicionar(elementoL);
                    atualL = atualL.getProximo();
                }
            }
            return nova;
        }
        
        
        
        
        
        return null;
    }
    }