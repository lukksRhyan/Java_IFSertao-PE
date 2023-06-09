package listaencadeada.pilha;

import java.util.function.ToIntFunction;

public class PilhaEncadeada {
    public int size;
    public No top;
    
    public PilhaEncadeada(){
        this.size = 0;
        this.top = null;
    }

    public int getSize() {
        return size;
    }
    public No getTop() {
        return top;
    }
    public void push(No top) {
        if(!this.isEmpty())top.setnext(this.top);
        this.top = top;
        this.size++;
    }
    public void push(Object element){
        No no = new No(element);
        this.push(no);
    }
    public No pop(){
        if(!this.isEmpty()){
            No popped = this.top;
            this.top= popped.getnext();
            this.size--;
            return popped;
        }
        return null;
    }
    public boolean isEmpty(){
        return this.size == 0;
    }
    public PilhaEncadeada inverse(){//Questao 01
        PilhaEncadeada inverse = new PilhaEncadeada();
        No out;
            while(this.getTop()!=null){
                out = this.getTop();
                this.pop().setnext(inverse.getTop());    
                inverse.push(out);
            }
            return inverse;
        }
    public void transfer(PilhaEncadeada sec){//Questao 02
        PilhaEncadeada temp = sec.inverse();
        No formerTop = this.getTop();
        while (temp.getTop() !=null) {
            this.push(temp.pop());
        }
            temp.getTop().setnext(formerTop);
            this.push(temp.pop());
    }
    public int uneven(){//Questao 03
        PilhaEncadeada temp = this.inverse();
        int uneven = 0;
        while (!temp.isEmpty()) {
            if(temp.getTop().ToInt() %2==0)uneven++;
            this.push(temp.pop());
        }
        return uneven;
    }
    public void toEmpty(){
        while(!isEmpty()){
            System.out.println(this.pop());
        }
    }
    public String toString(){
        return null;
    }
}
