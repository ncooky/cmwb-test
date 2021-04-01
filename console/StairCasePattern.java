package console;

import java.util.*;

class StairCasePattern {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter the height of Staircase: ");
    int height = scan.nextInt();
    int c = height - 1;

    if (height > 100 || height == 0  ){
      System.out.println("please enter more then 0 and less equal to 100");
    }else{
      for (int i = 0; i < height; i++) {
        for (int j = 0; j < height; j++) {
          if (j < c) {
            System.out.print("  ");
          } else {
            System.out.print(" #");
          }
        }
        System.out.println();
        c = c - 1;
      }
    }
  }
}
