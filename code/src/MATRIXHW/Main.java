package MATRIXHW;

import java.awt.event.MouseAdapter;
import java.io.*;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    public static void main(String[] args)
    {
        int count = 1;
        System.out.println("First, let`s generate a matrix:");
        System.out.println("Please enter the row of the matrix: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Please enter the column of the matrix: ");
        int m = scanner.nextInt();
        System.out.println("Please enter the data of this matrix");
        Matrix ex1 = new Matrix(n, m);
        ex1.Input();
        System.out.println("The matrix is as follow:");
        ex1.Output();
        try {
            String filename = "E:\\桌面\\编写\\java\\MatrixHW\\log.txt";
            File file =new File(filename);
            if(!file.exists())
            {
                try
                {
                    file.createNewFile();
                }
                catch (IOException e){};
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));
            int op = 0;
            do {
                bufferedWriter.write("\nOPERATION " + count++ + ": ");
                System.out.printf("\n\n----------------------------------------------------------\n");
                System.out.println("Now choose the operation you would like to perform:");
                System.out.println("1.update the matrix");
                System.out.println("2.Output the matrix");
                System.out.println("3.Transpose");
                System.out.println("4.Addition");
                System.out.println("5.Multiplication");
                System.out.println("6.Rank");
                System.out.println("7.Determinant");
                System.out.println("8.Inverse");
                System.out.println("9.Solving linear equations");
                System.out.println("0.Exit");
                op = scanner.nextInt();
                if (op == 1) {
                    bufferedWriter.write("UPDATE\n");
                    System.out.println("Please enter the new infomation of the new matrix:");
                    System.out.println("Row:");
                    n = scanner.nextInt();
                    System.out.println("Column");
                    m = scanner.nextInt();
                    ex1 = new Matrix(n, m);
                    System.out.println("enter data:");
                    ex1.Input();
                    System.out.println("Update successfully, now the matrix is as follow:");
                    ex1.Output();
                    StringBuilder data;
                    for(int i = 0; i < ex1.Row; i++){
                        data = new StringBuilder();
                        for(int j = 0; j < ex1.Column; j++)
                        {
                            data.append(ex1.matrix[i][j] + " ");
                        }
                        data.append("\n");
                        bufferedWriter.write(data.toString());
                    }
                } else if (op == 2) {
                    bufferedWriter.write("OUTPUT\n");
                    System.out.println("The matrix is as follow:");
                    ex1.Output();
                    StringBuilder data;
                    for(int i = 0; i < ex1.Row; i++){
                        data = new StringBuilder();
                        for(int j = 0; j < ex1.Column; j++)
                        {
                            data.append(ex1.matrix[i][j] + " ");
                        }
                        data.append("\n");
                        bufferedWriter.write(data.toString());
                    }
                } else if (op == 3) {
                    bufferedWriter.write("TRANSPOSE\n");
                    Matrix ex2 = ex1.Transpose();
                    System.out.println("Transpose matrix is as follow:");
                    ex2.Output();
                    StringBuilder data;
                    for(int i = 0; i < ex2.Row; i++){
                        data = new StringBuilder();
                        for(int j = 0; j < ex2.Column; j++)
                        {
                            data.append(ex2.matrix[i][j] + " ");
                        }
                        data.append("\n");
                        bufferedWriter.write(data.toString());
                    }
                } else if (op == 4) {
                    bufferedWriter.write("ADDITION\n");
                    System.out.println("Please enter another matrix");
                    System.out.println("Row:");
                    n = scanner.nextInt();
                    System.out.println("Column:");
                    m = scanner.nextInt();
                    System.out.println("enter data:");
                    Matrix ex2 = new Matrix(n, m);
                    ex2.Input();
                    System.out.println("Result");
                    Matrix ex3 = ex1.Addition(ex2);
                    if (ex3 != null) {
                        ex3.Output();
                    }
                    StringBuilder data;
                    for(int i = 0; i < ex1.Row; i++){
                        data = new StringBuilder();
                        for(int j = 0; j < ex1.Column; j++)
                        {
                            data.append(ex1.matrix[i][j] + " ");
                        }
                        data.append("\n");
                        bufferedWriter.write(data.toString());
                    }
                    bufferedWriter.write("+\n");
                    for(int i = 0; i < ex2.Row; i++){
                        data = new StringBuilder();
                        for(int j = 0; j < ex2.Column; j++)
                        {
                            data.append(ex2.matrix[i][j] + " ");
                        }
                        data.append("\n");
                        bufferedWriter.write(data.toString());
                    }
                    bufferedWriter.write("RESULT\n");
                    if(ex3 == null){
                        bufferedWriter.write("DATA ILLEGAL\n");
                    }
                    else{
                        for(int i = 0; i < ex3.Row; i++){
                            data = new StringBuilder();
                            for(int j = 0; j < ex3.Column; j++)
                            {
                                data.append(ex3.matrix[i][j] + " ");
                            }
                            data.append("\n");
                            bufferedWriter.write(data.toString());
                        }
                    }

                } else if (op == 5) {
                    bufferedWriter.write("MULTIPLICATION\n");
                    System.out.println("Please enter another matrix");
                    System.out.println("Row:");
                    n = scanner.nextInt();
                    System.out.println("Column:");
                    m = scanner.nextInt();
                    System.out.println("enter data:");
                    Matrix ex2 = new Matrix(n, m);
                    ex2.Input();
                    System.out.println("Result");
                    Matrix ex3 = ex1.Multiplication(ex2);
                    if (ex3 != null) {
                        ex3.Output();
                    }
                    StringBuilder data;
                    for(int i = 0; i < ex1.Row; i++){
                        data = new StringBuilder();
                        for(int j = 0; j < ex1.Column; j++)
                        {
                            data.append(ex1.matrix[i][j] + " ");
                        }
                        data.append("\n");
                        bufferedWriter.write(data.toString());
                    }
                    bufferedWriter.write("*\n");
                    for(int i = 0; i < ex2.Row; i++){
                        data = new StringBuilder();
                        for(int j = 0; j < ex2.Column; j++)
                        {
                            data.append(ex2.matrix[i][j] + " ");
                        }
                        data.append("\n");
                        bufferedWriter.write(data.toString());
                    }
                    bufferedWriter.write("RESULT\n");
                    if(ex3 == null){
                        bufferedWriter.write("DATA ILLEGAL\n");
                    }
                    else{
                        for(int i = 0; i < ex3.Row; i++){
                            data = new StringBuilder();
                            for(int j = 0; j < ex3.Column; j++)
                            {
                                data.append(ex3.matrix[i][j] + " ");
                            }
                            data.append("\n");
                            bufferedWriter.write(data.toString());
                        }
                    }
                } else if (op == 6) {
                    bufferedWriter.write("RANK\n");
                    System.out.println("The rank of matrix is :" + ex1.Rank());
                    bufferedWriter.write("RESULT :" + ex1.Rank() + "\n");
                } else if (op == 7) {
                    bufferedWriter.write("DETERMINANT\nRESULT\n");
                    if (ex1.Determinant() == -1) {
                        bufferedWriter.write("DATA ILLEGAL\n");
                        continue;
                    }
                    System.out.println("The Determinant value of the matrix is : " + ex1.Determinant());
                    StringBuilder data = new StringBuilder();
                    data.append(ex1.Determinant() + "\n");
                    bufferedWriter.write(data.toString());
                } else if (op == 8) {
                    bufferedWriter.write("INVERSE\nRESULT\n");
                    System.out.println("The inverse matrix is as follow");
                    Matrix ex2 = ex1.Inverse();
                    if (ex2 == null) {
                        bufferedWriter.write("DATA ILLEGAL\n");
                    } else {
                        StringBuilder data;
                        ex2.Output();
                        for(int i = 0; i < ex2.Row; i++){
                            data = new StringBuilder();
                            for(int j = 0; j < ex2.Column; j++)
                            {
                                data.append(ex2.matrix[i][j] + " ");
                            }
                            data.append("\n");
                            bufferedWriter.write(data.toString());
                        }
                    }
                } else if (op == 9) {
                    bufferedWriter.write("Solve equations\n");
                    System.out.println("Please enter the information of those equations");
                    System.out.println("The number of the equations");
                    n = scanner.nextInt();
                    System.out.println("The number of the unknown numbers");
                    m = scanner.nextInt();
                    System.out.println("Enter the coefficient of the unknown number. For example, enter\"2 3 1 2\" means \"2x1 + 3x2 + x3 = 2\"");
                    Matrix ex2 = new Matrix(n, m + 1);

                    ex2.Input();
                    StringBuilder data;
                    for(int i = 0; i < ex2.Row; i++){
                        data = new StringBuilder();
                        for(int j = 0; j < ex2.Column; j++)
                        {
                            if(j == 0) data.append(ex2.matrix[i][j] + "x" + (j+1));
                            else if(j < ex2.Column - 1) data.append("+" + ex2.matrix[i][j] + "x" + (j+1));
                            else data.append("=" + ex2.matrix[i][j]);
                        }
                        data.append("\n");
                        bufferedWriter.write(data.toString());
                    }
                    System.out.println("The result is as follow:");
                    double[] tmp = ex2.Solve();
                    if(tmp == null){
                        bufferedWriter.write("There is no solution to the equations\n");
                    }
                    else{
                        for(int i = 0; i < ex2.Column - 1; i++){
                            data = new StringBuilder();
                            data.append("x" + (i+1) + "=" + tmp[i] + " ");
                            data.append("\n");
                            bufferedWriter.write(data.toString());
                        }
                    }
                }else if(op == 0){
                    bufferedWriter.write("EXIT");
                    bufferedWriter.flush();
                    bufferedWriter.close();
                }
            } while (op != 0);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
