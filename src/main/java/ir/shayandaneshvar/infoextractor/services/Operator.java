package ir.shayandaneshvar.infoextractor.services;

import java.util.function.Function;

@FunctionalInterface
public interface Operator<T> extends Function<String, T> {
}
