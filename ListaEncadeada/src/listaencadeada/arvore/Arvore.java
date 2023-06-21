package listaencadeada.arvore;
public class Arvore {
        public No root;

        public Arvore(){
            this.root =  null;
        }
        public boolean isEmpty(){
            return this.root==null;
        }
        public void add(int elemento){
            if(isEmpty()){
                this.root = new No(elemento);
                return;
            }
            No atual = this.root;
            while(atual != null){
                if(elemento < atual.getElement()){
                    if(atual.getLeft()==null){
                        No novo = new No(elemento);
                        atual.setLeft(novo);
                        novo.setParent(atual);
                        return;
                    }
                    atual = atual.getLeft();
                }else{
                    if(elemento > atual.getElement()){
                        if(atual.getRight()!= null){
                            No novo =  new No(elemento);
                            atual.setRight(novo);
                            novo.setParent(atual);
                        }
                    }
                }
            }

        }

    class No{
        private int element;
        private No parent;
        private No left;
        private No right;

        public No(int element){
            this.element = element;
        }

        public int getElement() {
            return element;
        }
        public void setElement(int element) {
            this.element = element;
        }
        public No getParent() {
            return parent;
        }
        public void setParent(No parent) {
            this.parent = parent;
        }
        public No getLeft() {
            return left;
        }
        public void setLeft(No left) {
            this.left = left;
        }
        public No getRight() {
            return right;
        }
        public void setRight(No right) {
            this.right = right;
        }
       
        
    }
}
