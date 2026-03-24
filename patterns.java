import java.util.*;

public class patterns {

    // public static void hollow_rectangle(int rows, int cols){
    // for(int i = 1; i <= rows; i++){
    // for(int j = 1; j <= cols; j++){
    // if(i == 1 || i == rows || j == 1 || j == cols){
    // System.out.print("* ");
    // } else {
    // System.out.print(" ");
    // }
    // }
    // System.out.println();
    // }
    // }
    // public static void main(String args[]){
    // Scanner sc = new Scanner(System.in);
    // System.out.print("Enter number of rows: ");
    // int rows = sc.nextInt();
    // System.out.print("Enter number of columns: ");
    // int cols = sc.nextInt();
    // hollow_rectangle(rows, cols);
    // sc.close();
    // }

    // public static void zeroOnePattern(int n){
    // for(int i = 1; i <= n; i++){
    // for(int j = 1; j <= i; j++){
    // if((i + j) % 2 == 0){
    // System.out.print("1 ");
    // } else {
    // System.out.print("0 ");
    // }
    // }
    // System.out.println();
    // }
    // }
    // public static void main(String[] args) {
    // Scanner sc = new Scanner(System.in);
    // System.out.print("Enter the number of rows for the 0-1 pattern: ");
    // int n = sc.nextInt();
    // zeroOnePattern(n);
    // sc.close();
    // }

    // public static void butterflyPattern(int n){
    // for(int i = 1; i <= n; i++){
    // for(int j = 1; j <= i; j++){
    // System.out.print("*");
    // }
    // for(int j = 1; j <= 2 * (n - i); j++){
    // System.out.print(" ");
    // }
    // for(int j = 1; j <= i; j++){
    // System.out.print("*");
    // }
    // System.out.println();
    // }
    // for(int i = n; i >= 1; i--){
    // for(int j = 1; j <= i; j++){
    // System.out.print("*");
    // }
    // for(int j = 1; j <= 2 * (n - i); j++){
    // System.out.print(" ");
    // }
    // for(int j = 1; j <= i; j++){
    // System.out.print("*");
    // }
    // System.out.println();
    // }
    // }
    // public static void main(String[] args) {
    // Scanner sc = new Scanner(System.in);
    // System.out.print("Enter the number of rows for the butterfly pattern: ");
    // int n = sc.nextInt();
    // butterflyPattern(n);
    // sc.close();
    // }

    // public static void solidRhombus(int n) {
    // for (int i = 1; i <= n; i++) {
    // for (int j = 1; j <= n - i; j++) {
    // System.out.print(" ");
    // }
    // for (int j = 1; j <= n; j++) {
    // System.out.print("*");
    // }
    // System.out.println();
    // }
    // }
    // public static void main(String[] args) {
    // Scanner sc = new Scanner(System.in);
    // System.out.print("Enter the number of rows for the solid rhombus: ");
    // int n = sc.nextInt();
    // solidRhombus(n);
    // sc.close();
    // }

    // public static void hollowRhombus(int n) {
    // for (int i = 1; i <= n; i++) {
    // for (int j = 1; j <= n - i; j++) {
    // System.out.print(" ");
    // }
    // for (int j = 1; j <= n; j++) {
    // if (j == 1 || j == n || i == 1 || i == n) {
    // System.out.print("*");
    // } else {
    // System.out.print(" ");
    // }
    // }
    // System.out.println();
    // }
    // }
    // public static void main(String[] args) {
    // Scanner sc = new Scanner(System.in);
    // System.out.print("Enter the number of rows for the hollow rhombus: ");
    // int n = sc.nextInt();
    // hollowRhombus(n);
    // sc.close();
    // }

    public static void daimondPattern(int n) {
        // Upper part of the diamond
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // Lower part of the diamond
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows for the diamond pattern: ");
        int n = sc.nextInt();
        daimondPattern(n);
        sc.close();
    }
}
