import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

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
            valaszok[getValaszokDb()] = split;

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

    }

    public void pointsToFile(String fileName){

    }
}