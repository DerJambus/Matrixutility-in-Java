package matrix.calc.util;
import matrix.calc.util.ArrayMatrix;
import org.junit.Test;

public class MatrixTester {
    double[][] array = new double[][]{{1, 2, 3}, {3,2,1}};
    ArrayMatrix test = new ArrayMatrix(array);
    @Test
    public void countRow1(){
        assert test.countRows() == 2;
    }
    @Test
    public void countColl1(){
        assert test.countColl() == 3;
    }

    

}
