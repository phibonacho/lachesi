package it.phibonachos.lachesi.types.base;

import it.phibonachos.lachesi.types.ScoreMapper;
import it.phibonachos.ponos.converters.Converter;
import it.phibonachos.ponos.converters.MultiValueConverter;
import it.phibonachos.utils.FunctionalWrapper;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Defines a {@link Converter} which elaborate parametric verdicts, it can be used to convert a single or multiple properties.
 */
public abstract class MultiValueScoreMapper extends MultiValueConverter<Integer> implements ScoreMapper {
    private int scoreValue;

    /**
     * @return the string specifying why the validation failed.
     */
    public String message() {
        return "fails evaluating score defined in " + this.getClass().getSimpleName();
    }

    public int getScoreValue() {
        return scoreValue;
    }

    public void setScoreValue(int scoreValue) {
        this.scoreValue = scoreValue;
    }
}
