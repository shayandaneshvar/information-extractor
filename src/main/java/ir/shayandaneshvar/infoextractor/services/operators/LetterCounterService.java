package ir.shayandaneshvar.infoextractor.services.operators;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LetterCounterService implements Operator<Long> {
    @Override
    public Long apply(String string) {
        List<Character> list = new ArrayList<>();
        for (char c : string.toCharArray()) {
            list.add(c);
        }
        return list.stream().filter(x -> Character.isAlphabetic(x)).count();
    }
}
