package it.phibonachos.lachesi;

import it.phibonachos.lachesi.types.NotNullScore;
import it.phibonachos.lachesi.types.ScoreMapper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Score {
    int value();

    Class<? extends ScoreMapper> with() default NotNullScore.class;

    boolean malus() default false;

    String[] boundTo() default {};
}
