package matrix.calc.util;


public class ArrayMatrix implements Matrix{
    private double[][] arr;

    public ArrayMatrix(double[][] array){
        this.arr = array;
    }
    @Override
    public boolean multiplyable(Matrix mat2) { // checking if two matrix can be multiplied
        assert mat2 instanceof ArrayMatrix;
        return this.countColl() == ((ArrayMatrix) mat2).countRows();
    }

    @Override
    public Matrix multiply(Matrix mat2) {
        assert this.multiplyable(mat2) == true;
        double[][] result = new double[this.countColl()][((ArrayMatrix) mat2).countRows()];
        for(int i = 0; i < result.length; i++){
            for(int k = 0; k < result[0].length; k++){
                result[i][k] = sclproduct(((ArrayMatrix) mat2).getColl(k), this.arr[i][k]);
            }
        }
        return new ArrayMatrix(result);
    }

    public double sclproduct(double[] array, double scalar){ // implements a scalarproduct of a vector and a scalar
        double result = 0;
        for(int i = 0; i < array.length; i++){
            result += (scalar * array[i]);
        }
        return result;
    }


    @Override
    public Matrix sclMultiply(double scalar) {
        int rows = this.countRows();
        int colls = this.countColl();
        double[][] result = new double[rows][colls];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < colls; j++){
                result[i][j] = (this.arr[i][j] * scalar);
            }
        }
        return new ArrayMatrix(result);
    }

    @Override
    public Matrix add(Matrix mat2) {
        assert mat2 instanceof ArrayMatrix;
        int rows = this.countRows();
        int colls = this.countColl();
        double[][] result = new double[rows][colls];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < colls; j++){
                result[i][j] = (this.arr[i][j] + ((ArrayMatrix) mat2).arr[i][j]);
            }
        }
        return new ArrayMatrix(result);
    }

    @Override
    public boolean addable(Matrix mat2) {
        assert mat2 instanceof ArrayMatrix;
        return this.countRows() == ((ArrayMatrix) mat2).countRows() &&
                this.countColl() == ((ArrayMatrix) mat2).countColl();
    }

    @Override
    public Matrix sub(Matrix mat2) {
        assert mat2 instanceof ArrayMatrix;
        assert this.addable(mat2) == true;
        double[][] result = new double[this.countRows()][this.countColl()];
        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[0].length; j++){
                result[i][j] = (this.arr[i][j] - ((ArrayMatrix) mat2).arr[i][j]);
            }
        }
        return new ArrayMatrix(result);
    }

    @Override
    public double det() {
       double result = 0; // Line 86 - 98 implements the rule of Sarrus
        if(this.countColl() == 2 && this.countRows() == 2){
            result = (this.arr[0][0]*this.arr[1][1])-(this.arr[0][1]*this.arr[1][0]);
            return result;
        }else{
            if(this.countRows() == 3 && this.countColl() == 3){
                result = (this.arr[0][0] * this.arr[1][1] * this.arr[2][2])
                        + (this.arr[0][1] * this.arr[1][2] * this.arr[2][0])
                        + (this.arr[0][2] * this.arr[1][0] * this.arr[2][1])
                        - (this.arr[2][0] * this.arr[1][1] * this.arr[0][2])
                        - (this.arr[2][1] * this.arr[1][2] * this.arr[0][0])
                        - (this.arr[2][2] * this.arr[1][0] * this.arr[0][2]);
                return result;
            }
        }

        // needs a logic that can calculate dets of a matrix greater than 3x3
        return result;
    }

    public int countColl(){
        return this.arr[0].length;
    }

    public int countRows(){
        return this.arr.length;
    }

    public double[] getColl(int i){ // Writes a collum specified by index in an Array.
        double[] result = new double[this.countRows()];
        for(int k = 0; k < result.length; k++){
            result[k] = this.arr[k][i];
        }
        return result;
    }

    public double[] getRow(int i){
        return this.arr[i];
    }

    public static void main(String[] args) {
        double[][] array1 = new double[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        ArrayMatrix test = new ArrayMatrix(array1);
        System.out.println(test.det());
    }
}
