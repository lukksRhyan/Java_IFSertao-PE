package listaencadeada.arvore;
public class Arvore {
        public No root;
        public int altura;
        public Arvore(){
            this.root =  null;
        }
        public boolean isEmpty(){
            return this.root==null;
        }
        public void add(int elemento){
            if(isEmpty()){
                this.root = new No(elemento);
                this.root.level = 0;
                this.altura = 1;
                return;
            }
            No atual = this.root;
            while(atual != null){
                if(elemento == atual.getElement()) return;
                if(elemento < atual.getElement()){
                    if(atual.getLeft()==null){
                        No novo = new No(elemento);
                        atual.setLeft(novo);
                        novo.setParent(atual);
                        this.altura = novo.level+1;
                        return;
                    }
                    atual = atual.getLeft();
                }else{
                    if(elemento > atual.getElement()){
                        if(atual.getRight()!= null){
                            No novo =  new No(elemento);
                            atual.setRight(novo);
                            novo.setParent(atual);
                            this.altura = novo.level+1;
                            return;
                        }
                        atual = atual.getRight();
                    }
                }
            }

            }
            public String NoType(No no){
                if (no == this.root) return "raiz";
                if (no.getRight()==null && no.getLeft()==null) return "folha";
                return "galho";
        }

        public 

    class No{
        private int element;
        private int level;
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
            this.level = parent.level+1;
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
