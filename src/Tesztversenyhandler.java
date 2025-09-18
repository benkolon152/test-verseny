import java.io.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Tesztversenyhandler {
    private String helyes;
    private String [][] valaszok;
    private int valaszokDb;

    public String getHelyes() {
        return helyes;
    }

    public void setHelyes(String helyes) {
        this.helyes = helyes;
    }

    public String[][] getValaszok() {
        return valaszok;
    }

    public void setValaszok(String[][] valaszok) {
        this.valaszok = valaszok;
    }

    public int getValaszokDb() {
        return valaszokDb;
    }

    public void setValaszokDb(int valaszokDb) {
        this.valaszokDb = valaszokDb;
    }

    private void debugger(){
        int i = 0;
    }

    public Tesztversenyhandler(){
        valaszok = new String[500][];
    }

    public Tesztversenyhandler readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        setHelyes(scanner.nextLine());
        setValaszokDb(0);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] split = line.split(" ");

            valaszok[getValaszokDb()] = new String[3];
            valaszok[getValaszokDb()][0] = split[0];
            valaszok[getValaszokDb()][1] = split[1];

            setValaszokDb(getValaszokDb()+1);
        }
        debugger();

        return this;
    }

    public String valaszai(String azon){
        for (int i = 0; i < getValaszokDb(); i++) {
            if (Objects.equals(valaszok[i][0], azon)){
                return valaszok[i][1];
            }
        }

        return null;
    }

    public String eltalaltaStr (String tippek){

        String result = "";
        for (int i = 0; i < tippek.length(); i++) {
            if (tippek.charAt(i) == getHelyes().charAt(i)){
                result += "+";
            } else {
                result += " ";
            }
        }
        return result;
    }

    public double[] helyesFeladatStat(int feladatSorszam){
        double[] result = new double[2];
        for (int i = 0; i < getValaszokDb(); i++) {
            if (eltalaltaStr(valaszok[i][1]).charAt(feladatSorszam - 1) == '+'){
                result[0]++;
            }
        }
        result[1] = result[0] / getValaszokDb() * 100.0;
        return result;
    }

    public void countPoints(){
        for (int i = 0; i < getValaszokDb(); i++){
            String eltalaltaStr = eltalaltaStr(valaszok[i][1]);
            Integer sum = 0;
            for (int j = 0; j < eltalaltaStr.length(); j++){
                if (eltalaltaStr.charAt(j) == '+'){
                    switch (j){
                        case 0, 1, 2, 3, 4:{ sum += 3; break; }
                        case 5, 6, 7, 8, 9:{ sum += 4; break; }
                        case 10, 11, 12:{ sum += 5; break; }
                        case 13, 14:{ sum += 6; break; }
                    }
                }
            }
            valaszok[i][2] = sum.toString();
            debugger();
        }
    }

    public void pointsToFile(String fileName) throws IOException {
        File fki = new File(fileName);
        FileWriter fwki = new FileWriter(fki);
        for (int i = 0; i < getValaszokDb(); i++){
            fwki.write(valaszok[i][0] + ";"+ valaszok[i][2]+"\n");
        }
        fwki.close();
    }

    public Set<Integer> pointSet (){
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < getValaszokDb(); i++){
            result.add(Integer.parseInt(valaszok[i][2]));
        }
        return result;
    }

    public void printWinners(int points1, int points2, int points3){
        for (int i = 0; i < getValaszokDb(); i++){
            if (Integer.parseInt(valaszok[i][2]) == points1){
                System.out.println("1.díj (" + points1+" pont): " + valaszok[i][0]);
            }
        }
        for (int i = 0; i < getValaszokDb(); i++){
            if (Integer.parseInt(valaszok[i][2]) == points2){
                System.out.println("2.díj (" + points2+" pont): " + valaszok[i][0]);
            }
        }
        for (int i = 0; i < getValaszokDb(); i++){
            if (Integer.parseInt(valaszok[i][2]) == points3){
                System.out.println("3.díj (" + points3+" pont): " + valaszok[i][0]);
            }
        }
    }
}