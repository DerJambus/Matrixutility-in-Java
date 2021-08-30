package matrix.calc.util;

public interface Matrix {
    public boolean multiplyable(Matrix mat2);
    public Matrix multiply(Matrix mat2);
    public Matrix sclMultiply(double scalar);
    public Matrix add(Matrix mat2);
    public boolean addable(Matrix mat2);
    public Matrix sub(Matrix mat2);
    public double det();
}
