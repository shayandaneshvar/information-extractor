package ir.shayandaneshvar.infoextractor.services.operators;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@FunctionalInterface
@Service
public interface Operator<T> extends Function<String, T> {
}
