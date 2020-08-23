package it.phibonachos.lachesi.types;

import it.phibonachos.ponos.converters.Converter;

public interface ScoreMapper extends Converter<Integer> {
    void setScoreValue(int scoreValue);
    int getScoreValue();
}
