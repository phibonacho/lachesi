package it.phibonachos.lachesi;

import it.phibonachos.lachesi.types.ScoreMapper;
import it.phibonachos.lachesi.types.base.SingleScoreMapper;
import it.phibonachos.ponos.AbstractEvaluator;
import it.phibonachos.ponos.converters.Converter;
import it.phibonachos.utils.FunctionalWrapper;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ScoreEvaluator<Target> extends AbstractEvaluator<Target, Integer, Score, Exception> {

    public ScoreEvaluator(Target t) {
        super(t);
        this.annotationClass = Score.class;
    }

    @Override
    protected Integer evaluate(Stream<Integer> stream) {
        return stream.flatMapToInt(IntStream::of).sum();
    }

    @Override
    protected Function<Method, Boolean> sortPredicate() {
        return (i) -> true;
    }

    @Override
    protected Function<Method, Integer> evaluateAlgorithm() {
        return invokeOnNull(this::scoreMethod, this::scoreMalusMethod);
    }

    @Override
    protected Integer evaluateMethod(Score score, Method ...methods) throws Exception {
        ScoreMapper validator = Converter.create(score.with());

        validator.setScoreValue(score.value());

        if(validator instanceof SingleScoreMapper)
            return validator.evaluate(this.t, methods[0]);

        return validator.evaluate(this.t, methods);
    }

    @Override
    public Class<? extends Converter<Integer>> fetchConverter(Score annotation) {
        return annotation.with();
    }

    private Integer scoreMethod(Method method) throws Exception {
        List<Method> boundMethod = Arrays.stream(getMainAnnotation(method).boundTo())
                .map(FunctionalWrapper.tryCatch(name -> new PropertyDescriptor(name, this.t.getClass()).getReadMethod()))
                .collect(Collectors.toList());

        boundMethod.add(0, method);
        return evaluateMethod(getMainAnnotation(method), boundMethod.toArray(Method[]::new));
    }

    private Integer scoreMalusMethod(Method method) {
        Score score = getMainAnnotation(method);
        return score.malus() ? -score.value() : 0;
    }
}
