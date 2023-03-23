package listaencadeada;

public class Aluno {
    private String nome;
    private int id;
    Aluno(){
        this("",-1);
    }
    Aluno(String nome, int id){
        this.nome = nome;
        this.id = id;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return(this.nome);
    }
    public void setId(int id){
        this.id =  id;
    }
    public int getId(){
        return(this.id);
    }
    public String toString(){
        return "Nome :" + this.getNome() + "\nId: " + this.getId(); 
    }
}
