import java.util.*;
import java.io.*;

public class USACO{
  private int[][] board;

  public static int bronze(String filename) throws FileNotFoundException{
    File f = new File(filename);
    Scanner inf = new Scanner(f);
    int inputR = Integer.parseInt(inf.next());
    int inputC = Integer.parseInt(inf.next());
    int inputE = Integer.parseInt(inf.next());
    int inputN = Integer.parseInt(inf.next());
    return inputN;
    }

    public static void main (String[] args){
      try{
        System.out.println(bronze("makelake.1.in"));
      }
      catch(FileNotFoundException e){
        System.out.println("yongtong");
      }
    }
  }
