import java.util.*;
import java.io.*;

class DayTwo {

    public static void main(String[] args) {
        System.out.println("Total Number of Safe Reports: " + StarOne());
        System.out.println("Total Number of Safe Reports: " + StarTwo());
    }

    public static int StarOne(){
        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);

            ArrayList<Boolean> safetyCount = new ArrayList<Boolean>();
          
            int total = 0;

            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              if(data.length() > 0) {
                String[] parts = data.split(" ");
                boolean isIncreasing = false;
                boolean flag = true;
                int numb1 = Integer.valueOf(parts[0]);
                int numb2 = Integer.valueOf(parts[1]);
                int result = numb2 - numb1;

                if(result > 0){
                    isIncreasing  = true;
                }else{
                    isIncreasing = false;
                }

                for(int i = 1; i < parts.length; i++){
                    int num1 = Integer.valueOf(parts[i - 1]);
                    int num2 = Integer.valueOf(parts[i]);
                    int res = num2 - num1;
                    boolean check = false;

                    if(res > 0){
                        check = true;                        
                    }else{
                        check = false;
                    }

                    if(res > 3 || res < -3 || res == 0){
                        flag = false;
                        break;
                    }

                    if((isIncreasing != check)){
                        flag = false;
                        break;
                    }

                }

                safetyCount.add(flag);
              }
            }

            for(int i = 0; i < safetyCount.size(); i++){
                if(safetyCount.get(i)){
                    total++;
                }
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

            ArrayList<Boolean> safetyCount = new ArrayList<Boolean>();
          
            int total = 0;

            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              if(data.length() > 0) {
                System.out.println("Data: " + data);
                String[] parts = data.split(" ");
                boolean isIncreasing = false;
                boolean flag = true;
                int numb1 = Integer.valueOf(parts[0]);
                int numb2 = Integer.valueOf(parts[1]);
                int result = numb2 - numb1;

                if(result > 0){
                    isIncreasing  = true;
                }else{
                    isIncreasing = false;
                }

                for(int i = 1; i < parts.length; i++){
                    int num1 = Integer.valueOf(parts[i - 1]);
                    int num2 = Integer.valueOf(parts[i]);
                    int lowerboundary = i-2;
                    int upperboundary = i+1;
                    int res = num2 - num1;
                    boolean check = false;

                    
                    if(res > 0){
                        check = true;                        
                    }else{
                        check = false;
                    }

                    System.out.println("Num1: "+ num1);
                    System.out.println("Num2: "+ num2);
                    System.out.println("Res: "+ res);
                    System.out.println("Check: "+ check);
                    System.out.println("Is Increasing: "+ isIncreasing);

                    if(res > 3 || res < -3 || res == 0){
                        if(lowerboundary >= 0 || upperboundary >= 0){
                            if(lowerboundary >= 0){
                                int testnum = Integer.valueOf(parts[lowerboundary]);
                                res = num2 - testnum;
                                
                                if(res > 0){
                                    check = true;                        
                                }else{
                                    check = false;
                                }
    
                                if((res > 3 || res < -3 || res == 0)  || (isIncreasing != check) ){
                                    flag = false;
                                    break;
                                }else{
                                    continue;
                                }
                            }else if(upperboundary >= 0 && upperboundary < parts.length){
                                int testnum = Integer.valueOf(parts[upperboundary]);
                                res = testnum - num1;
                                
                                if(res > 0){
                                    check = true;                        
                                }else{
                                    check = false;
                                }
    
                                if((res > 3 || res < -3 || res == 0)  || (isIncreasing != check) ){
                                    flag = false;
                                    break;
                                }else{
                                    continue;
                                }
                            }

                        }else{
                            flag = false;
                            break;
                        }
                    }

                    if((isIncreasing != check)){
                        if(lowerboundary >= 0 || upperboundary >= 0){
                            if(lowerboundary >= 0){
                                int testnum = Integer.valueOf(parts[lowerboundary]);
                                res = num2 - testnum;
                                if(res > 0){
                                    check = true;                        
                                }else{
                                    check = false;
                                }
                                if((isIncreasing != check) || (res > 3 || res < -3 || res == 0)){
                                    flag = false;
                                    break;
                                }else{
                                    continue;
                                }
                            }else if(upperboundary>=0 && upperboundary < parts.length){
                                int testnum = Integer.valueOf(parts[upperboundary]);
                                res = testnum - num1;
                                if(res > 0){
                                    check = true;                        
                                }else{
                                    check = false;
                                }
                                if((isIncreasing != check) || (res > 3 || res < -3 || res == 0)){
                                    flag = false;
                                    break;
                                }else{
                                    continue;
                                }
                            }
                        }else{
                            flag = false;
                            break;
                        }
                    }
                    System.out.println(" ");
                }

                safetyCount.add(flag);
              }
            }

            for(int i = 0; i < safetyCount.size(); i++){
                if(safetyCount.get(i)){
                    total++;
                }
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