import org.example.Solution;
import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void shortestPathBinaryMatrixTest1() {
        int[][] grid = {
                {0, 1},
                {1, 0}
        };
        int output = 2;
        Assert.assertEquals(output, new Solution().shortestPathBinaryMatrix(grid));
    }

    @Test
    public void shortestPathBinaryMatrixTest2() {
        int[][] grid = {
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };
        int output = 4;
        Assert.assertEquals(output, new Solution().shortestPathBinaryMatrix(grid));
    }

    @Test
    public void shortestPathBinaryMatrixTest3() {
        int[][] grid = {
                {1, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };
        int output = -1;
        Assert.assertEquals(output, new Solution().shortestPathBinaryMatrix(grid));
    }
}
