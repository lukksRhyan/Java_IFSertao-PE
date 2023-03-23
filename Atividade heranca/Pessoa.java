//Antes de tudo perdoe a falta de acentuacao nos comentarios, pode ser que o encoding seja diferente e o arquivo corrompa. Ja me ocorreu.

package javaapplication1;

public class Pessoa {
    protected String nome;
    protected String endereco;
    protected int telefone;

    Pessoa() {
        this(null, null, 00);
    }

    Pessoa(String nm, String end, int tel) {
        nome = nm;
        endereco = end;
        telefone = tel;
    };

    public String obterNome() {
        return nome;
    }

    public void mudarNome(String novoNome) {
        nome = novoNome;
    }

    public String obterEnd() {
        return endereco;
    }

    public void mudarEnd(String novoEnd) {
        endereco = novoEnd;
    }

    public int obterTel() {
        return telefone;
    }

    public void mudarTel(int novoTel) {
        telefone = novoTel;
    }
    public void ficha(){
        System.out.println("Nome: " + obterNome());
        System.out.println("Endereco:" + obterEnd());
        System.out.println("Telefone: " + obterTel());
    }
}

class Fornecedor extends Pessoa {
    private double credito;
    private double divida;
    private double saldo = credito - divida;

    // Repetirei esse padrao nas proximas subclasses, onde o construtor acima sempre
    // usa o abaixo;
    Fornecedor() {
        // Cria um objeto pessoa que é masi generalizado
        this(new Pessoa());
    }

    Fornecedor(Pessoa humano) {
        // Copia as caracteristicas da pessoa passada pra ele e define valores iniciais
        // para os parametros
        this(humano, 0.0, 0.0);
    }

    Fornecedor(Pessoa humano, double cred, double div) {
        // Copia as caracteristicas da pessoas passada para ele e usa os valores
        // passados como parametros
        nome = humano.nome;
        endereco = humano.endereco;
        telefone = humano.telefone;
        credito = cred;
        divida = div;
    }

    public double obterSaldo() {
        return saldo;
    }

    public double obterCred() {
        return credito;
    }

    public void alterCred(double cred) {
        credito = cred;
    }

    public double obterDiv() {
        return divida;
    }

    public void alterDiv(double div) {
        divida = div;
    }
}

class Empregado extends Pessoa {

    protected int codigoSetor;
    protected double salarioBase;
    protected double imposto;

    Empregado() {
        this(new Pessoa());
    }

    Empregado(Pessoa humano) {
        this(humano, 0, 0.0, 0.0);
    }

    Empregado(Pessoa humano, int setor, double sal, double imp) {
        nome = humano.nome;
        endereco = humano.endereco;
        telefone = humano.telefone;
        codigoSetor = setor;
        salarioBase = sal;
        imposto = imp;
    }

    public double calcSal() {
        return (salarioBase * (1 + imposto));
    }

    public double obterSal() {
        return salarioBase;
    }

    public void alterSal(double novoSal) {
        salarioBase = novoSal;
    }

    public double obterImposto() {
        return imposto;
    }

    public void alterImposto(double novoImposto) {
        imposto = novoImposto;
    }
    public int obterSetor(){
        return codigoSetor;
    }
    public void alterSetor(int idSetor){
        codigoSetor = idSetor;
    }

}

class Administrador extends Empregado {
    double ajudaCusto;

    Administrador() {
        this(new Empregado());
    }

    Administrador(Empregado trabalhador) {
        this(trabalhador, 0.0);
    }

    Administrador(Empregado trabalhador, double ajuda) {
        nome = trabalhador.nome;
        endereco = trabalhador.endereco;
        telefone = trabalhador.telefone;
        codigoSetor = trabalhador.codigoSetor;
        salarioBase = trabalhador.salarioBase;
        imposto = trabalhador.imposto;
        ajudaCusto = ajuda;
    }

    public double calcSal() {
        return (salarioBase * imposto + ajudaCusto);
    }
    public double obterAjuCus(){
        return ajudaCusto;
    }
    public void alterAjuCus(double ajuda){
        ajudaCusto = ajuda;
    }
}

class Operario extends Empregado {
    private double valorProducao;
    private double porcComis;
    private double comissao = valorProducao * porcComis;

    Operario() {
        this(new Empregado());
    }

    Operario(Empregado trabalhador) {
        this(trabalhador, 0.0, 0.0);
    }

    Operario(Empregado trabalhador, double valPro, double comiss) {
        nome = trabalhador.nome;
        endereco = trabalhador.endereco;
        telefone = trabalhador.telefone;
        codigoSetor = trabalhador.codigoSetor;
        salarioBase = trabalhador.salarioBase;
        imposto = trabalhador.imposto;
        valorProducao = valPro;
        comissao = (valorProducao * (1 + porcComis));
    }

    public double calcSal() {
        return (salarioBase + comissao);
    }
    public double obterValPro(){
        return valorProducao;
    }
    public void alterValPro(double novoValPro){
        valorProducao = novoValPro;
    }
    public double obterComis(){
        return comissao;
    }
    public void alterComis(double novaComis){
        comissao = novaComis;
    }
}

class Vendedor extends Empregado {
    private double valorVendas;
    private double comissao;
    private double porcComis;

    Vendedor() {
        this(new Empregado());
    }

    Vendedor(Empregado trabalhador) {
        this(trabalhador, 0.0, 0.0);
    }

    Vendedor(Empregado trabalhador, double valor, double prcComiss) {
        nome = trabalhador.nome;
        endereco = trabalhador.endereco;
        telefone = trabalhador.telefone;
        codigoSetor = trabalhador.codigoSetor;
        salarioBase = trabalhador.salarioBase;
        imposto = trabalhador.imposto;
        valorVendas = valor;
        comissao = (valorVendas * porcComis);
    }

    public double calcSal() {
        return (salarioBase + comissao);
    }
}