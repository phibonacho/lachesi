package evaluators.classes;

import it.phibonachos.lachesi.Score;

public class SimpleObject {
    private Integer prop;
    private Integer prop2;

    @Score(1)
    public Integer getProp() {
        return prop;
    }

    public void setProp(Integer prop) {
        this.prop = prop;
    }

    @Score(value = 2, malus = true)
    public Integer getProp2() {
        return prop2;
    }

    public void setProp2(Integer prop2) {
        this.prop2 = prop2;
    }
}
