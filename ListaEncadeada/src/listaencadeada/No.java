package listaencadeada;

class No{
    private No anterior;
    protected No proximo;
    public Object elemento;
    No(){
        this(null);
    }
    No(Object elemento){
        this.elemento = elemento;
        this.proximo = null;
    }
    No(No anterior,Object elemento,No proximo){
        this(elemento);
        this.anterior = anterior;
        this.proximo = proximo;
    }
    public No getAnterior() {
        return anterior;
    }
    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }
    public Object getElemento() {
        return elemento;
    }
    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }
    public void setProximo(No proximo){
        this.proximo = proximo;
    }
    public No getProximo(){
        return this.proximo;
    }
    public String toString(){
        return this.elemento.toString();
    }
}

