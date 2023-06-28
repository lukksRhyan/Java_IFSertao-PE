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
        public void preorder(){
            preorder(this.root);
        }
        public void preorder(No no){
            if(no != null){
                System.out.println(no.element);
                preorder(no.getLeft());
                preorder(no.getRight());
            }
        }
        public void inorder(){
            inorder(this.root);
        }
        public void inorder(No no){
            if(no != null){
                inorder(no.getLeft());
                System.out.println(no.element);
                inorder(no.getRight());
            }
        }
         public void posorder(){
            posorder(this.root);
        }
        public void posorder(No no){
            if(no != null){
                posorder(no.getLeft());
                posorder(no.getRight());
                System.out.println(no.element);
            }
        }
        
        


        public String NoType(No no){
            if (no == this.root) return "raiz";
            if (no.getRight()==null && no.getLeft()==null) return "folha";
            return "galho";
        }
        public int[] caminho(int valor){
            No ultimo = busca(valor);

            int[] caminho = new int[ultimo.level];
            for(int i = ultimo.level; i>0; i++){
                caminho[i] = ultimo.element;
                ultimo = ultimo.parent;
            }
            return caminho;
        }
        No busca(int valor){
            No atual = this.root;
            int elemento = atual.getElement();
            while(atual != null){
                if(elemento == atual.getElement()) return atual;
                if(elemento < atual.getElement())atual = atual.getLeft();
                if(elemento > atual.getElement())atual = atual.getRight();
            }
            return null;
        }
        No minimo(){
            No atual = this.root;
            while(atual.getLeft() != null){
                atual = atual.getLeft();
            }
            return atual;   
        }
         No maximo(){
            No atual = this.root;
            while(atual.getRight() != null){
                atual = atual.getRight();
            }
            return atual;   
        }

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
