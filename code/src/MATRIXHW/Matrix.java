package MATRIXHW;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Scanner;


class Matrix implements Calculate{
    int Row, Column;
    double[][] matrix = null;
    Matrix(){}

    Matrix(int Row, int Colummn) {
        matrix = null;
        this.Row = Row;
        this.Column = Colummn;
        matrix = new double[Row][Colummn];
    }

    Matrix(Matrix p) {
        this(p.Row, p.Column);
        for(int i = 0; i < Row; i++) {
            for(int j = 0; j < Column; j++) {
                this.matrix[i][j] = p.matrix[i][j];
            }
        }
    }

    void Input() {
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < Row; i++) {
            for(int j = 0; j < Column; j++) {
                matrix[i][j] = scan.nextDouble();
            }
        }
    }

    void Output() {
        for (int i = 0; i < Row; i++) {
            for (int j = 0; j < Column; j++) {
                System.out.printf("%5.2f ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    Matrix Transpose() {
        Matrix New = new Matrix(this.Column, this.Row);
        for(int i = 0; i < Row; i++) {
            for(int j = 0; j < Column; j++) {
                New.matrix[j][i] = this.matrix[i][j];
            }
        }
        return New;
    }

    @Override
    public Matrix Addition(Matrix p) {
        if(Row == p.Row && Column == p.Column) {
            Matrix New = new Matrix(Row, Column);
            for (int i = 0; i < Row; i++) {
                for (int j = 0; j < Column; j++) {
                    New.matrix[i][j] = matrix[i][j] + p.matrix[i][j];
                }
            }
            return New;
        }
        else{
            System.out.println("Cannot perform addition, please try again");
            return null;
        }
    }

    @Override
    public Matrix Multiplication(Matrix p) {
        if(Column == p.Row) {
            Matrix New;
            try{
                New = new Matrix(Row, p.Column);
            }
            catch (NullPointerException e){
                System.out.println("Data illegal, please try again");
                return null;
            }
            for(int i = 0; i < Row; i++){
                for(int j = 0; j < p.Column; j++){
                    double sum = 0;
                    for(int k = 0; k < Column; k++) {
                        sum = sum + matrix[i][k] * p.matrix[k][j];
                    }
                    New.matrix[i][j] = sum;
                }
            }
            return New;
        }
        else{
            System.out.println("Cannot perform multiplication, please try again");
            return null;
        }
    }

    @Override
    public Matrix Inverse() {
        if(Row == Column)
        {
            SquareMatrix a = new SquareMatrix(this);
            return a.Inverse();
        }
        else{
            System.out.println("Cannot perform this operation");
            return null;
        }
    }
    

    @Override
    public double Determinant() {
        if(Row == Column){
            SquareMatrix a = new SquareMatrix(this);
            return a.Determinant();
        }
        else{
            System.out.println("Can not preform this operation, please try again");
            return -1;
        }
    }

    int Rank(){
        double[][] tmp = this.matrix;
        int n = this.Column - 1;
        for(int r = 0, c = 0; r < this.Row && c < n; r++, c++){
            int t = r;
            for(int i = r + 1; i < this.Row; i++) {
                if(Math.abs(tmp[i][c]) > Math.abs(tmp[t][c])) t = i;
            }
            for(int i = c; i <= n; i++){
                double temp = tmp[r][i];
                tmp[r][i] = tmp[t][i];
                tmp[t][i] = temp;
            }
            for(int i = n; i >= c; i--){
                if(tmp[r][i] == 0 || tmp[r][c] == 0.0){
                    tmp[r][i] = 0;
                    continue;
                }
                tmp[r][i] /= tmp[r][c];


            }
            for(int i = r+1; i < this.Row; i++){
                for(int j = n; j >= c; j--){
                    tmp[i][j] -= tmp[i][c] * tmp[r][j];
                }
            }
        }
        for(int i = 0; i < this.Row; i++) {
            for(int j = 0; j < i; j++) {
                tmp[i][j] = 0;
            }
        }
        int ret = 0, flg = 0;
        for(int i = 0; i < Row; i++){
            for(int j = 0; j < Column; j++){
                if(tmp[i][j] != 0){
                    flg = 1;
                    break;
                }
            }
            if(flg == 1) ret++;
            flg = 0;
        }
        return ret;
    }

    double[] Solve() {
        int equ = Row, var = Column - 1;
        int i, j, k, col, max_r;
        double eps = 0.000000001;
        double[][] a = new double[equ][var];
        for(i = 0; i < Row; i++){
            for(j = 0; j < var; j++){
                a[i][j] = matrix[i][j];
            }
        }
        double x[] = new double[var];
        for(i = 0; i < Row; i++){
            x[i] = matrix[i][var];
        }
        for(k = 0, col = 0; k < equ && col <var; k++, col++){
            max_r = k;
            for(i = k +1; i < equ; i++){
                if(Math.abs(a[i][col]) > Math.abs(a[max_r][col])){
                    max_r = i;
                }
            }
            if(Math.abs(a[max_r][col]) <eps){
                System.out.println("There is no solution to the equations");
                return null;
            }
            if(k != max_r){
                for(j = col; j < var; j++){
                    double tmp = a[max_r][j];
                    a[max_r][j] = a[k][j];
                    a[k][j] = tmp;
                }
                double tmp = x[max_r];
                x[max_r] = x[k];
                x[k] = tmp;
            }
            x[k] /= a[k][col];
            for(j = col + 1; j < var; j++){
                a[k][j] /= a[k][col];
            }
            a[k][col] = 1;
            for(i = 0; i < equ; i++){
                if(i != k){
                    x[i] -= x[k] * a[i][col];
                    for(j = col + 1; j <var; j++){
                        a[i][j] -= a[k][j] * a[i][col];
                    }
                    a[i][col] = 0;
                }
            }
        }
        System.out.println("The solutions of the equations are as follows");
        for(i = 0; i < var; i++)
        {
            System.out.println("x" + (i+1) + " = " + x[i]);
        }
        System.out.println();
        return x;
    }
}

class SquareMatrix extends Matrix{
    SquareMatrix(){
        super();
    }

    SquareMatrix(int Row){
        super(Row, Row);
    }

    SquareMatrix(Matrix a) {
        this.matrix = a.matrix;
        this.Row = a.Row;
    }

    boolean CheckDiagonalMatrix(){
        for(int i = 0; i < Row; i++){
            for(int j = 0; j < Row; j++){
                if(i != j && matrix[i][j] != 0){
                    return false;
                }
            }
        }
        return true;
    }

    int CheckTriangleMatrix(){
        int flg_up = 1, flg_low = 0;
        for(int i = 0; i < Row; i++){
            for(int j = 0; j < i; j++){
                if(matrix[i][j] != 0){
                    flg_up = 0;
                    break;
                }
            }
        }
        for(int i = 0; i < Row; i++){
            for(int j = Row - 1; j > i; j--){
                if(matrix[i][j] != 0){
                    flg_low = 0;
                    break;
                }
            }
        }
        return flg_low | flg_up;
    }

    SquareMatrix Create(int i, int j, SquareMatrix M){
        if(M.Row <= 1) {
            return M;
        }
        else {
            SquareMatrix New = new SquareMatrix(M.Row - 1);
            int curx = 0, cury = 0;
            for (int ii = 0; ii < M.Row; ii++) {
                if(ii == i) continue;
                for (int jj = 0; jj < M.Row; jj++) {
                    if (jj == j) {
                        continue;
                    }
                    New.matrix[curx][cury++] = M.matrix[ii][jj];
                }
                curx++;
                cury = 0;
            }
            return New;
        }
    }

    @Override
    public double Determinant() {
        if(CheckDiagonalMatrix()){
            DiagonalMatrix a = new DiagonalMatrix(this);
            return a.Determinant();
        }
        if(CheckTriangleMatrix() == 1){
            TrianglarMatrix a = new TrianglarMatrix(this);
            return a.Determinant();
        }
        if(Row == 1) return matrix[0][0];
        else{
            double sum = 0;
            for(int i = 0; i < Row; i++){
                SquareMatrix tmp = Create(0, i, this);
                sum += Math.pow(-1, i) * matrix[0][i] * tmp.Determinant();
            }
            return sum;
        }
    }

    @Override
    public Matrix Inverse() {
        double[][] tmp = new double[Row][2 * Row];
        for(int i = 0; i < Row; i++) {
            for(int j = 0; j < Row; j++){
                tmp[i][j] = matrix[i][j];
            }
        }
        for(int i = 0; i < Row; i++){
            for(int j = Row; j < 2 * Row; j++){
                if(i + Row == j){
                    tmp[i][j] = 1;
                }
                else{
                    tmp[i][j] = 0;
                }
            }
        }

        int n = 2 * Row - 1;
        for(int r = 0, c = 0; r < this.Row && c < n; r++, c++){
            int t = r;
            for(int i = r + 1; i < this.Row; i++) {
                if(Math.abs(tmp[i][c]) > Math.abs(tmp[t][c])) t = i;
            }
            for(int i = c; i <= n; i++){
                double temp = tmp[r][i];
                tmp[r][i] = tmp[t][i];
                tmp[t][i] = temp;
            }
            for(int i = n; i >= c; i--){
                if(tmp[r][i] == 0 || tmp[r][c] == 0.0){
                    tmp[r][i] = 0;
                    continue;
                }
                tmp[r][i] /= tmp[r][c];
            }

            for(int i = r+1; i < this.Row; i++){
                for(int j = n; j >= c; j--){
                    tmp[i][j] -= tmp[i][c] * tmp[r][j];
                }
            }
        }

        for(int j = Row - 1; j >= 0; j--){
            for(int i = j - 1; i >= 0; i--){
                double time = tmp[i][j] / tmp[j][j];
                for(int k = j; k < 2 * Row; k++){
                    tmp[i][k] -= tmp[j][k] * time;
                }
            }
        }
        Matrix ans = new Matrix(Row, Row);
        for(int i = 0; i < Row; i++){
            for(int j = Row; j < 2 * Row; j++) {
                ans.matrix[i][j - Row] = tmp[i][j];
            }
        }
        return ans;
    }


}

class IdentityMatrix extends SquareMatrix{
    IdentityMatrix(){
        super();
    }

    IdentityMatrix(int Row){
        super(Row);
    }

    IdentityMatrix(Matrix a){
        super(a);
    }

    @Override
    public double Determinant() {
        System.out.println("This is an IdentityMatrix");
        return 1.0;
    }
}

class DiagonalMatrix extends SquareMatrix{
    DiagonalMatrix(){
        super();
    }

    DiagonalMatrix(int Row){
        super(Row);
    }

    DiagonalMatrix(Matrix a){
        super(a);
    }

    boolean CheckIdentityMatrix(){
        for(int i = 0; i < Row; i++){
            if(matrix[i][i] != 1.0){
                return false;
            }
        }
        return true;
    }

    @Override
    public double Determinant() {
        if(CheckIdentityMatrix()){
            IdentityMatrix a = new IdentityMatrix(this);
            return a.Determinant();
        }
        System.out.println("This is a DiagonalMatrix");
        double mul = 1.0;
        for(int i = 0; i < Row; i++) {
            mul *= this.matrix[i][i];
        }
        return mul;
    }
}

class TrianglarMatrix extends SquareMatrix{
    TrianglarMatrix(){
        super();
    }

    TrianglarMatrix(int Row){
        super(Row);
    }

    TrianglarMatrix(Matrix a){
        super(a);
    }

    @Override
    public double Determinant() {
        System.out.println("This is a TriangleMatrix");
        double mul = 1.0;
        for(int i = 0; i < Row; i++) {
            mul *= this.matrix[i][i];
        }
        return mul;
    }

}
