/* import java.util.*;
    * class RandomDemo {
    *     static int[] losuj1(int a, int b, int n) {
    *         int[] wynik = new int[n];
    *         Random los = new Random();
    *         for (int i = 0; i < wynik.length; i++) {
    *             wynik[i] = a + los.nextInt(b - a + 1);
    *         }
    *         return wynik;
    *     }
    *     public static void main(String args[]) {
    *         Scanner reader = new Scanner(System.in);
    *         System.out.println("Losowanie N liczb całkowitych z przedziału <a, b>");
    *         System.out.print("Podaj a: ");
    *         int a = reader.nextInt();
    *         System.out.print("Podaj b: ");
    *         int b = reader.nextInt();
    *         System.out.print("Podaj N: ");
    *         int n = reader.nextInt();
    *         reader.close();
    *         int[] tab = losuj1(a, b, n);
    *         for (int i = 0; i < tab.length; i++) {
    *             System.out.println(tab[i]);
    *         }
    *     }
    *   }
*/
import javax.swing.*;

class Main {
    public static void main(String args[]) {
        JFrame f = new JFrame("Moje pierwsze Okno");
        f.setSize(500,500);
        f.setVisible(true);
    
    }
}