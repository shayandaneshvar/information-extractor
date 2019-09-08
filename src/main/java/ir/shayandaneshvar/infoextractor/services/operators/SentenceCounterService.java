package ir.shayandaneshvar.infoextractor.services.operators;

import org.springframework.stereotype.Component;

@Component
public class SentenceCounterService implements Operator<Integer> {
    @Override
    public Integer apply(String string) {
        return string.split("\\.").length - 1;
    }
}
