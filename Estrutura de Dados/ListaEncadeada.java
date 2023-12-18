package listaencadeada;

public class ListaEncadeada {
    private Posicao primeiro;
    private Posicao ultimo;
    private int numeroDeMembros;

    ListaEncadeada(){
        this(new Posicao());
    }
    ListaEncadeada(Posicao membro){// A lista precisa de pelo menos um membro pra existir
        this.primeiro = membro;
        this.ultimo = membro;
        this.numeroDeMembros = 1; 
    }
    public void Adicionar(Posicao novo){
        this.ultimo.proximo = novo;//Ja entrega o novo membro como sucessor do ultimo.
        this.ultimo = novo;//So aqui substitui o ultimo
        this.numeroDeMembros +=1;//Aumenta o tamanho da lista apos ter adicionado o membro
    }
    public void Adicionar(Object objeto){
        Posicao receptaculo = new Posicao(objeto);
        this.Adicionar(receptaculo);
    }
    public Posicao busca(Object objeto){
        Posicao atual = this.primeiro;
        while (atual.proximo!= null) {
            if(atual.ocupante.equals(objeto)){
                return atual;
            }
        }
        return null;
    }
    public void substituir(Object antigo, Object novo){
        Posicao alvo = this.busca(antigo);
        alvo.ocupante = novo;
    }
    public int tamanho(){
        return this.numeroDeMembros;
    }
    public Posicao getPosicao(int pos){
        Posicao atual = this.primeiro;
        for(int i = 0; i <=pos;i++){
            atual = atual.proximo;
        }
        return atual;
    }

}
class Posicao{
    protected Posicao proximo;
    public Object ocupante;
    Posicao(){
        this(null);
    }
    Posicao(Object generico){
        this.ocupante = generico;
        this.proximo = null;
    }
    public Object getOcupante(){
        return(this.ocupante);
    }
    public void setProximo(Posicao proximo){
        this.proximo = proximo;
    }
    public Posicao getProximo(){
        return this.proximo;
    }
    public String toString(){
        return "Objeto guardado : " + this.ocupante.getClass()+ "\n" + this.ocupante.toString();
    }
}
