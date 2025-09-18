import java.io.FileNotFoundException;
import java.util.Scanner;

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

        Scanner in = new Scanner(System.in);
        System.out.print("3.feladat: A versenyző azonosítója = ");
        String id = in.nextLine();
        String valaszai = handler.valaszai(id);
        System.out.println(valaszai + "   (a versenyző válaszai)");
        System.out.println();

        debugger();
    }
}