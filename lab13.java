import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream; 

public class lab13{

    private ArrayList<Integer> a;

    public lab13(){
        this.a = new ArrayList<>();
    }

    public void readData(String filename){
        try{
            BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
            String line;
            while ((line = file.readLine()) != null){
                this.a.add(Integer.parseInt(line));
            }
            file.close();
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }

    public long getTotalCount(){
        return this.a.stream().count();
    }

    public long getOddCount(){
        return this.a.stream().filter(x -> x % 2 == 1).count();
    }

    public long getEvenCount(){
        return this.a.stream().filter(x -> x % 2 == 0).count();
    }

    public long getDistinctGreaterThanFiveCount(){
        return this.a.stream().filter(x -> x > 5).distinct().count();
    }

    public Integer[] getResult1(){
        return this.a.stream().filter(x -> x % 2 == 0).filter(x -> x > 5 && x < 50).sorted().toArray(Integer[]::new);
    }

    public Integer[] getResult2(){
        return this.a.stream().map(x -> x * x * 3).limit(50).toArray(Integer[]::new);
    }

    public Integer[] getResult3(){
        return this.a.stream().filter(x -> x % 2 == 1).map(x -> x * 2).sorted().skip(20).distinct().toArray(Integer[]::new);
    }

}