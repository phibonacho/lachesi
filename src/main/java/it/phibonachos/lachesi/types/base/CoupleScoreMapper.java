package it.phibonachos.lachesi.types.base;

import it.phibonachos.ponos.converters.MultiValueConverter;

/**
 * SingleValueConverter is a sample class that shows how fixed arity converter can be implemented starting from {@link MultiValueConverter}
 * @param <C> Is the return type of the converter
 * @param <F> Is the first input type of the converter
 * @param <S> Is the second input type of the converter
 */

public abstract class CoupleScoreMapper<F,S> extends MultiValueScoreMapper {

    @Override
    @SuppressWarnings("unchecked")
    protected Integer convertAll(Object... objects) throws Exception {
        return score((F) objects[0], (S)objects[1]);
    }

    public abstract Integer score(F guard, S boundGuard) throws Exception;
}
