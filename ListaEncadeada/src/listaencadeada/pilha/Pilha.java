package listaencadeada.pilha;

public class Pilha{
    private Object[] elementos;
    private int topo;

    public Pilha(int capacidade){
        this.topo = -1;
        this.elementos = new Object[capacidade];
    }
    public boolean push(Object elemento){
        if ((this.elementos.length-1) > this.topo){
            this.elementos[topo] = elemento;
            this.topo++;
            return true;
        };
        return false;
    }
    public Boolean isEmpty(){
        return topo<0;
    }
    public int size(){
        if(isEmpty()) return 0;
        return this.topo+1;
    }
    public Object popRT(){//Pop retorna
        if(isEmpty()) return 0;
        return this.elementos[topo--];
    }

    public Object top(){
        return this.elementos[topo];
    }

    //Atividade Sabado Letivo
    public void popRV(){//Pop remove
        this.topo--;   
    }
    public void PopPos(int pos){
        if((topo<pos)||(pos<0)) return;//Retorna sem tentar nada se pos for invalida
        topo = pos;//Simplesmente remove toda a pilha a partir de pos 
    }
}