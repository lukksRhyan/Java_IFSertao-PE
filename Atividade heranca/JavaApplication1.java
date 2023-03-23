/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Aluno
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Testes classse Pessoa");

        //Classe Pessoa
        System.out.println("\n\nPrimeira Pessoa");
        Pessoa kaname = new Pessoa();

        //Nome
        System.out.println("Nome antes da mudanca (padrao): " + kaname.obterNome());
        kaname.mudarNome("Madoka");
        System.out.println("Nome atribuido: " + kaname.obterNome());

        //Telefone
        System.out.println("\nTelefone padrao: " + kaname.telefone);
        kaname.mudarTel(42022122);
        System.out.println("Novo telefone: " + kaname.obterTel());

        //Endereco
        System.out.println("\nEndereco padrao: " + kaname.obterEnd());
        kaname.mudarEnd("Mitakihara");
        System.out.println("Novo endereco: " + kaname.obterEnd());

        // Nao colocarei o outro construtor de Pessoa porque se o primeiro funcionar e
        // porque qualquer um depois dele funcionou

        //Subclasse Fornecedor
        System.out.println("\n\nTeste Fornecedor");
        
        //Criei de uma forma que todas usem os atributos padrao da classe Pessoa, mas aqui eu quis passar os atributos 
        Fornecedor mami = new Fornecedor(
            new Pessoa(
                "Tomoe Mami", "Mitakihara", 00000234
                ),
                600,
                400
            );

        //Atributos herdados de Pessoa
        System.out.println("\nDados iniciais:");
        System.out.println("Nome: " + mami.obterNome());
        System.out.println("Endereco: " + mami.obterEnd());
        System.out.println("Telefone: " + mami.obterTel());

        //Saldo, Nao usei o metodo pra checar o padrao porque ele sempre depende de credito e divida
        System.out.println("\nSaldo: " + mami.obterSaldo());


        //Subclasse Empregado
        System.out.println("\n\nTeste Empregado");

        Empregado akemi = new Empregado(
            new Pessoa(
                "Homura", "Kamihama", 400028922
                ),
                1200,
                0.04
            );

        System.out.println("\nDados iniciais:");
        System.out.println("\nNome: " + akemi.obterNome());
        System.out.println("Endereco: " + akemi.obterEnd());
        System.out.println("Telefone: " + akemi.obterTel());

        //Salario
        System.out.println("Salario final: " + akemi.calcSal());


        //Subclasse Administrador
        System.out.println("\n\nTeste Administrador");
        Administrador miki = new Administrador(
            new Empregado(
                new Pessoa(
                    "Sayaka", "Kamihama", 98888
                        ),
                        03, 800.0, 0.05
                    )
                );

        System.out.println("\nAtributos herdados de Pessoa:");
        System.out.println("Nome: " + miki.obterNome());
        System.out.println("Endereco: " + miki.obterEnd());
        System.out.println("Telefone: " + miki.obterTel());

        System.out.println("\nAtributos herdados de Empregado:");
        System.out.println("Setor: " +  miki.obterSetor());
        System.out.println("Salario base: " + miki.obterSal());
        System.out.println("Imposto: " + miki.obterImposto());

        System.out.println("\n\nAtributos especificos:");

        //Ajuda de Custo
        System.out.println("\n Ajuda de Custo padrao: " + miki.obterAjuCus());
        miki.alterAjuCus(300);
        System.out.println(" Ajuda de Custo padrao: " + miki.obterAjuCus());
        
        System.out.println("\nSalario: " + miki.calcSal());

        //Subclasse Operario
        System.out.println("\n\nTeste Operario");

        Operario sakura = new Operario(
            new Empregado(
                new Pessoa("Kyouko", "Kazamino", 666666),
                05,
                400,
                0.0
            )
            );
        
        System.out.println("\nAtributos herdados de Pessoa:");
        System.out.println("Nome: " + sakura.obterNome());
        System.out.println("Endereco:" + sakura.obterEnd());
        System.out.println("Telefone: " + sakura.obterTel());

        System.out.println("\nAtributos herdados de Empregado:");
        System.out.println("Setor: " +  sakura.obterSetor());
        System.out.println("Salario base: " + sakura.obterSal());
        System.out.println("Imposto: " + sakura.obterImposto());

        System.out.println("\n Atributos especificos:");

        System.out.println("\nValor de Producao padrao: " + sakura.obterValPro());
        sakura.alterValPro(250);
        System.out.println("Novo valor de producao: " + sakura.obterValPro());

        System.out.println("\nComissao padrao: " + sakura.obterComis());
        sakura.alterComis(0.5);
        System.out.println("Nova comissao: " + sakura.obterComis());

        //Vendedor
        System.out.println("\n\nTeste Vendedor");
        

        Vendedor nagisa = new Vendedor(
            new Empregado(
                new Pessoa("Momoe", "Kanto", 12364508),
                07,
                650.0,
                0.7
            ),
            300,
            0.5
        );

        System.out.println("Salario final: " + nagisa.calcSal());
    }
}
