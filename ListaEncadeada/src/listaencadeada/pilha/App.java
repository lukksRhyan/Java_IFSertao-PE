package listaencadeada.pilha;

public class App {
    public static void main(String[] args) {
        PilhaEncadeada serieA = new PilhaEncadeada();

        serieA.push("FLA");
        serieA.push("FLU");
        serieA.push("COR");    
        serieA.push("SAO");
        System.out.println(serieA.getSize());
        
        System.out.println(serieA.getTop());

        PilhaEncadeada reversa = serieA.inverse();
        
        PilhaEncadeada serieB = new PilhaEncadeada();
        serieB.push("VIT");
        serieB.push("ABC");
        serieB.push("AVA");

        serieA.transfer(serieB);
        System.out.println(serieA.getTop());

        serieA.toEmpty();

        PilhaEncadeada numeros = new PilhaEncadeada();
        numeros.push(0);
        numeros.push(1);
        numeros.push(2);
        numeros.push(3);
        numeros.push(4);
        numeros.push(5);
        numeros.push(6);
        numeros.push(7);
        numeros.push(8);
        numeros.push(9);
        numeros.push(10);
        System.out.println("Numeros impares de 0 a 10: " + numeros.uneven());

    }
    
}
