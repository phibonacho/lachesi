package evaluators;


import evaluators.classes.SimpleObject;
import it.phibonachos.lachesi.ScoreEvaluator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ScoreEvaluatorTest {
    @Test
    public void BaseTest() {
        SimpleObject so = new SimpleObject();

        so.setProp(1);
        so.setProp2(2);

        assert new ScoreEvaluator<>(so).evaluate() == 3;
    }

}