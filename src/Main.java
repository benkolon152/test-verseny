import java.io.FileNotFoundException;

public class Main {
    private static Tesztversenyhandler handler;

    private static void debugger(){
        int i = 0;
    }

    public static void main(String[] args) throws FileNotFoundException {
        handler = new Tesztversenyhandler();


        System.out.println("1. feladat: Az adatok beolvasása");
        handler.readFile("scourcefiles/valaszok.txt");
        System.out.println();

        System.out.println("2.feladat: A vetélkedőn " + handler.getValaszokDb() + " versenyző indult.");
        System.out.println();

        debugger();
    }
}