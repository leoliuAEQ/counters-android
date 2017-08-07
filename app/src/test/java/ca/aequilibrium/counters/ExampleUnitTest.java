package ca.aequilibrium.counters;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void test_modelIncrementsValue() {
        Model m1 = new Model();
        Model m2 = new Model();

        assertTrue(m1.getValue() + 1 == m2.getValue());
    }

    @Test
    public void test_modelTimestampsAreIncremental() {
        Model m1 = new Model();
        Model m2 = new Model();

        assertTrue(m1.getCreated().compareTo(m2.getCreated()) <= 0);
    }
}