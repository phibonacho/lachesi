package it.phibonachos.lachesi.types.base;

import it.phibonachos.ponos.converters.MultiValueConverter;

/**
 * SingleValueConverter is a sample class that shows how fixed arity converter can be implemented starting from {@link MultiValueConverter}
 * @param <T> Is the input type of the converter
 */
public abstract class SingleScoreMapper<T> extends MultiValueScoreMapper {

    @Override
    @SuppressWarnings("unchecked")
    protected Integer convertAll(Object... objects) throws Exception {
        return score((T) objects[0]);
    }

    public abstract Integer score(T guard) throws Exception;

}
