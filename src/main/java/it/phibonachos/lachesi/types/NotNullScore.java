package it.phibonachos.lachesi.types;

import it.phibonachos.lachesi.types.base.SingleScoreMapper;

import java.util.Objects;

public class NotNullScore<T extends Number> extends SingleScoreMapper<T> {
    @Override
    public Integer score(T guard) throws Exception {
        if(Objects.isNull(guard))
            throw new NullPointerException();
        return this.getScoreValue();
    }
}
