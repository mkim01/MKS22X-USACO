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

    //getting the stomp field dimesension
    int[][] pasture = new int[inputN][3];
    for(int i = 0; i < inputN; i++){
      for(int j =0; j < 3; j++){
        pasture[i][j] = Integer.parseInt(inf.next());
      }
    }
    //digging stomp
    for (int i = 0; i < pasture.length; i++){
      int R_s = pasture[i][0];
      int C_s = pasture[i][1];
    //  int D_s = pasture[i][2];
        int max = 0;
        for (int r = R_s - 1; r < R_s + 2; r++){
          for (int c = C_s - 1; c < C_s + 2; c++){
            if (lake[r][c] > max){
              max = lake[r][c];
            }
          }
        }
        max = max - pasture[i][2];
        for (int r = R_s - 1; r < R_s + 2; r++){
          for (int c = C_s - 1; c < C_s + 2; c++){
            if (lake[r][c] > max){
              max = lake[r][c];
            }
          }
        }
      }
    //debug
    String output = "";
    for (int a = 0; a < lake.length; a++){
      for (int b = 0; b < lake[0].length; b++){
        output += lake[a][b] + " ";
      }
      output += "\n";
    }
    return output;
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
//      return 0;

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
