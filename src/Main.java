import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static boolean isRunningtest = false;

    private static final String testAzon = "AB123";
    private static final int testFeladatsorsz = 10;

    private static Tesztversenyhandler handler;

    private static void debugger(){
        int i = 0;
    }

    public static void main(String[] args) throws IOException {
        handler = new Tesztversenyhandler();


        System.out.println("1. feladat: Az adatok beolvasása");
        handler.readFile("scourcefiles/valaszok.txt");
        System.out.println();

        System.out.println("2.feladat: A vetélkedőn " + handler.getValaszokDb() + " versenyző indult.");
        System.out.println();

        Scanner in = new Scanner(System.in);
        System.out.print("3.feladat: A versenyző azonosítója = ");
        String id = isRunningtest ? testAzon : in.nextLine();
        String valaszai = handler.valaszai(id);
        System.out.println(valaszai + "   (a versenyző válaszai)");
        System.out.println();

        System.out.println("4.feladat:");
        System.out.println(handler.getHelyes() + "   (a helyes válaszok)");
        System.out.println(handler.eltalaltaStr(valaszai) + "   (a versenyző helyes válaszai)");
        System.out.println();

        System.out.print("5.feladat: A feladat sorszáma = ");
        int feladatSorszam = isRunningtest ? testFeladatsorsz : Integer.parseInt(in.nextLine());
        double[] helyesFeladatStat = handler.helyesFeladatStat(feladatSorszam);
        System.out.println("A feladatra " +(int)helyesFeladatStat[0]+ " fő, a versenyzők " +Math.round(helyesFeladatStat[1] * 100.0) / 100.0 +"%-a adott helyes választ.");
        System.out.println();

        System.out.println("6.feladat: A versenyzők pontszámának meghatározása.");
        handler.countPoints();
        handler.pointsToFile("pontok.txt");
        System.out.println();

        Set<Integer> pointSet = handler.pointSet();
        List<Integer> pointsList = new ArrayList<>(pointSet);
        pointsList.sort((e1, e2) -> e2 - e1);
        System.out.println("7.feladat: A verseny legjobjai: ");
        handler.printWinners(pointsList.get(0), pointsList.get(1), pointsList.get(2));
        System.out.println();

        debugger();
    }
}