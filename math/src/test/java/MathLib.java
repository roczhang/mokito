import static  myMath.MyMath.*;

import org.junit.Assert;
import org.junit.Test;

import static myMath.MyMath.InnerMath.PI_2;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by I076057 on 8/30/2018.
 */
public class MathLib {


    @Test
    public void test_ADD() throws Exception {


        Assert.assertTrue(  Math.abs(3.14 - PI) < 1e-6 );
        Assert.assertTrue(  Math.abs(3.14 - PI_2) < 1e-6 );


    }
}
