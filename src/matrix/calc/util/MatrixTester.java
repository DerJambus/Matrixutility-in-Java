package matrix.calc.util;
import matrix.calc.util.ArrayMatrix;
import org.junit.Test;

public class MatrixTester {
    double[][] array = new double[][]{{1, 2, 3}, {3,2,1}};
    double[][] array1 = new double[][]{{1,2,3}, {4,5,6}, {7,8,9}};
    double[][] array2 = new double[][]{{5, -1, 9}, {-1, 6, -1}, {9, -1, 7}};
    ArrayMatrix test = new ArrayMatrix(array);
    ArrayMatrix test1 = new ArrayMatrix(array1);
    ArrayMatrix test2 = new ArrayMatrix(array2);

    @Test
    public void countRow1(){
        assert test.countRows() == 2;
        System.out.println("expected 2; actual "+test.countRows());
    }

    @Test
    public void countRow2(){
        assert test1.countRows() == 3;
        System.out.println("expected 3" + " actual " + test1.countRows());
    }

    @Test
    public void countColl1(){
        assert test.countColl() == 3;
        System.out.println("expected 3; actual " + test.countRows());
    }

    @Test
    public void countColl2(){
        assert test1.countColl() == 3;
        System.out.println("expected 3; actual "+test1.countColl());
    }

    @Test
    public void det1(){
        assert test1.det() == 0;
        System.out.println("expected 0; actual " + test1.det());
    }

    @Test
    public void det2(){
        assert test2.det() == -270;
        System.out.println("expected -270; actual " + test2.det());
    }

}
