package ir.shayandaneshvar.infoextractor.services.operators;

import org.springframework.stereotype.Service;

@Service
public class WordCounterService implements Operator<Integer> {
    @Override
    public Integer apply(String string) {
        return string.replace(".", " ").split(" ").length;
    }
}
