import java.util.*;
import java.io.*;

public class USACO{

  public static String bronze(String filename) throws FileNotFoundException{
    File f = new File(filename);
    Scanner inf = new Scanner(f);
    //Parseint the output
    int inputR = Integer.parseInt(inf.next());
    int inputC = Integer.parseInt(inf.next());
    int inputE = Integer.parseInt(inf.next());
    int inputN = Integer.parseInt(inf.next());
    // 2D array
    int[][] lake = new int[inputR][inputC];
    for (int i = 0; i < inputR; i++){
      for (int j = 0; j < inputC; j++){
        lake[i][j] = Integer.parseInt(inf.next());
      }
    }
    String output = "";
    for (int a = 0; a < inputR; a++){
      for (int b = 0; b < inputC; b++){
        output += lake[a][b];
      }
      output += "\n";
    }

    ArrayList<Integer> cowsqaure = new ArrayList<Integer>();
    while(inf.hasNextLine()){
      int targetR = Integer.parseInt(inf.next());
      int targetC = Integer.parseInt(inf.next());
      int stomp = Integer.parseInt(inf.next());

      //get the highest value out of 3 by 3 sqaure
      // cowsqaure.add(lake[targetR][targetC]);
      // cowsqaure.add(lake[targetR + 1][targetC]);
      // cowsqaure.add(lake[targetR + 1][targetC + 1]);
      // cowsqaure.add(lake[targetR + 1][targetC - 1]);
      // cowsqaure.add(lake[targetR - 1][targetC]);
      // cowsqaure.add(lake[targetR - 1][targetC + 1]);
      // cowsqaure.add(lake[targetR - 1][targetC - 1]);
      // cowsqaure.add(lake[targetR][targetC + 1]);
      // cowsqaure.add(lake[targetR][targetC - 1]);
      //int highest

      int aim = highest - stomp;
      for (int i = 0; i < stomp; i++){
        for (int j = 0; j < 9; j++){
          int v1 = cowsqaure.get(j);
          if (v1 >=  aim){
            cowsqaure.set(i , v1 - 1);
            }
          }
        }
        return output;
      }
    }

    public static void main (String[] args){
      try{
        USACO u1 = new USACO();
        System.out.println(bronze("makelake.1.in"));
      //  System.out.println(USACO.board);
      }
      catch(FileNotFoundException e){
        System.out.println("yongtong");
      }
    }
}
