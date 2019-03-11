import java.util.*;
import java.io.*;

public class USACO{

  public static int bronze(String filename) throws FileNotFoundException{
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

    //getting the stomp field dimesension
    int[][] pasture = new int[inputN][3];
    for(int i = 0; i < inputN; i++){
      for(int j =0; j < 3; j++){
        pasture[i][j] = Integer.parseInt(inf.next());

      }
    }
    //debug
    String output = "";
    for (int a = 0; a < pasture.length; a++){
      for (int b = 0; b < pasture[0].length; b++){
        output += pasture[a][b] + ".";
      }
      output += "\n";
    }

    //digging stomp
    for (int i = 0; i < pasture.length; i++){
      int R_s = pasture[i][0];
      int C_s = pasture[i][1];
      int D_s = pasture[i][2];
      int max = 0;
      for (int r = inputR; r <= inputR + 2; r++){
        for (int c = inputC; c <= inputC + 2; c++){
          if (pasture[r - 1][c - 1] > max){
            max = pasture[r - 1][c - 1];
          }
        }
      }
    }

      // for (int i = 0; i < stomp; i++){
      //   for (int j = 0; j < 9; j++){
      //     int v1 = cowsqaure.get(j);
      //     if (v1 >=  aim){
      //       cowsqaure.set(i , v1 - 1);
      //       }
      //     }
      //   }
      // }
    //after the stomp
      return 0;
    }

    public static void main (String[] args){
      try{
        USACO u1 = new USACO();
        System.out.println(bronze("makelake.1.in"));
      //  System.out.println(USACO.board);
      }
      catch(FileNotFoundException e){
        System.out.println("caught");
      }
    }
}
