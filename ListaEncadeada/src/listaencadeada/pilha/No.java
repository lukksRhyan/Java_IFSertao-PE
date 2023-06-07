package listaencadeada.pilha;

public class No {
    public No next;
    public Object element;
    
    public No(){
        this(null);
    }
    public No(Object element) {
        this.element = element;
        this.next = null;
    }
    public Object getElement() {
        return element;
    }
    public void setElement(Object element) {
        this.element = element;
    }
    public No getnext() {
        return next;
    }
    public void setnext(No next) {
        this.next = next;
    }
    @Override
    public String toString(){
        return this.element.toString();
    }
    public String info(){
        return ("No contendo o elemento "+ getElement()+ " O Proximo e "+ getnext());
    }
    public int ToInt(){
        if(this.getElement() instanceof Integer){
            return (int) this.getElement();
        }
        return 0;
    }
}
