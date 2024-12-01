import java.util.*;
import java.io.*;

class DayOne {

    public static void main(String[] args) {
        System.out.println("Total Distance: " + StarOne());
        System.out.println("Similarity Score: " + StarTwo());
    }

    public static int StarOne(){
        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);

            ArrayList<Integer> left = new ArrayList<Integer>();
            ArrayList<Integer> right = new ArrayList<Integer>();

            int total = 0;

            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              if(data.length() > 0) {
                String[] parts = data.split("   ");
                int num1 = Integer.parseInt(parts[0]);
                int num2 = Integer.parseInt(parts[1]);
                left.add(num1);
                right.add(num2);
              }
            }

            left.sort(null);
            right.sort(null);

            for(int i = 0; i < left.size(); i++){
                int diff = right.get(i) - left.get(i);
                if(diff < 0){
                    diff = diff * -1;
                }
                total += diff;
            }

            myReader.close();

            return total;

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return 0;
        }
    }

    public static int StarTwo(){
        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);

            ArrayList<Integer> left = new ArrayList<Integer>();
            HashMap<Integer, Integer> ApperenceCounter = new HashMap<Integer, Integer>();

            int total = 0;

            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              if(data.length() > 0) {
                String[] parts = data.split("   ");
                int num1 = Integer.parseInt(parts[0]);
                int num2 = Integer.parseInt(parts[1]);

                if(ApperenceCounter.containsKey(num2)) {
                    ApperenceCounter.put(num2, ApperenceCounter.get(num2) + 1);
                }else{
                    ApperenceCounter.put(num2, 1);
                }

                left.add(num1);
              }
            }

            for(int i = 0; i < left.size(); i++){
                int num = left.get(i);
                int apperences = 0;

                if(ApperenceCounter.containsKey(num)){
                    apperences = ApperenceCounter.get(num);
                }

                total += num * apperences;

            }

            myReader.close();

            return total;

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return 0;
        }
    }
}