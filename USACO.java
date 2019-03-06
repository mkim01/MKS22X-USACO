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
    //
    String output = "";
    for (int i = 0; i < inputR; i++){
      for (int j = 0; j < inputC; j++){
        output += lake[i][j] + " ";
      }
      output += "\n";
    }
    return output;
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
