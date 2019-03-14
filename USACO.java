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
    int depth = 0;
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
      int max = 0;
        for (int r = R_s - 1; r < R_s + 2; r++){
          for (int c = C_s - 1; c < C_s + 2; c++){
            //in the cow-stomping instruction the row and column doesn't start from 0
            if (lake[r][c] > max){
              max = lake[r][c];
            }
          }
        }
        max = max - pasture[i][2];
        for (int r = R_s - 1; r < R_s + 2; r++){
          for (int c = C_s - 1; c < C_s + 2; c++){
            if (lake[r][c] > max){
              lake[r][c] = max;
            }
          }
        }
      }

    for (int i = 0; i < lake.length; i++){
      for(int j = 0; j < lake[0].length; j++){
        int remain = inputE - lake[i][j];
        if(remain > 0){
          lake[i][j] = remain;
        }
        else{
          lake[i][j] = 0;
        }
        depth += lake[i][j];
      }
    }
    return 72 * 72 * depth;
    //debug
    // String output = "";
    // for (int a = 0; a < lake.length; a++){
    //   for (int b = 0; b < lake[0].length; b++){
    //     output += lake[a][b] + " ";
    //   }
    //   output += "\n";
    // }
    // return output;
    }

    public static int silver(String filename) throws FileNotFoundException{
      File f = new File(filename);
      Scanner inf = new Scanner(f);
      int N = Integer.parseInt(inf.next());
      int M = Integer.parseInt(inf.next());
      int T = Integer.parseInt(inf.next());
      // int[][] moves = {{1,0} , {-1,0}, {0,1}, {0,-1}};
      // System.out.println(N);
      // System.out.println(M);
      // System.out.println(T);
      //initalize the pasture
      // for (int i =0; i < N; i++){
      //   String line = inf.nextLine();
      //   for (int j =0; j < line.length(); j++){
      //     pasture[i][j] = line.substring(j, j + 1);
      //     System.out.println(pasture[i][j]);
      //   }
      // }

      //initialize the state of pasture
      // pasture[i][j] < 0--> occupied
      int[][] state = new int[N][M];
      for(int i = 0; i < N; i++){
        String word = inf.next();
        for(int j = 0; j < M; j++){
          if (word.charAt(j) != '*'){
            state[i][j] = -1;
          }
        }
      }

      int[][] outstate = new int[N][M];
      int R1 = Integer.parseInt(inf.next()) - 1;
      int C1 = Integer.parseInt(inf.next()) - 1;
      int R2 = Integer.parseInt(inf.next()) - 1;
      int C2 = Integer.parseInt(inf.next()) - 1;
      // System.out.println(R1);
      // System.out.println(C1);
      // System.out.println(R2);
      // System.out.println(C2);
    //     while(T > 0){
    //     int[][] newstate = state;
    //     state = new int[N][M];
    //     for (int b = 0; b < state.length; b++){
    //       for(int c =0; c < state[0].length; c++){
    //         if(newstate[b][c] == -1){
    //           state[b][c] = -1;
    //         }
    //         else{
    //           for (int k = 0; k < moves.length; k++){
    //             try{
    //               if (newstate[b + moves[k][0]][c + moves[k][1]] > 0){
    //                 state[b][c] += newstate[b + moves[k][0]][c + moves[k][0]];
    //                 //System.out.println(state[b][c]);
    //               }
    //             }
    //             catch(ArrayIndexOutOfBoundsException e){}
    //             }
    outstate[R1][C1] = 1;
    int g = (R1 + C1) % 2;
    for(int t = 0; t < T; t++){
      for (int a = 0; a < N; a++){
        for (int b = (a+g) % 2; b < M; b += 2){
          if (state[a][b] == -1){
            try{
            if (a > 0){
              outstate[a-1][b] += outstate[a][b];
            }
            if (b > 0){
              outstate[a][b -1] += outstate[a][b];
            }
            if (b < M- 1){
              outstate[a][b+1] += outstate[a][b];
            }
            if (a < N - 1){
              outstate[a+1][b] += outstate[a][b];
            }
          }
          catch(ArrayIndexOutOfBoundsException e){}
          }
          outstate[a][b] = 0;
        }
      }
      g = (g + 1) % 2;
    }
      return outstate[R2][C2];
    }

      private static boolean checkbound(int r, int c, int[][] state){
        if (r < 0 || r >= state.length || c < 0 || c >= state[0].length){
          return false;
        }
        return true;
      }

    public static void main (String[] args){
      try{
      //   System.out.println(bronze(args[0]));
        System.out.println(silver(args[0]));
      }
      catch(FileNotFoundException e){
        System.out.println("caught");
      }
    }
}
