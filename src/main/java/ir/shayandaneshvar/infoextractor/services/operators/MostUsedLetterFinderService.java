package ir.shayandaneshvar.infoextractor.services.operators;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MostUsedLetterFinderService implements Operator<Character> {

    @Override
    public Character apply(String string) {
        string = string.replace(".", "").replace(" ", "");
        char result = ' ';
        long maxRepetition = 0;
        List<Character> chars = new ArrayList<>();
        for (char c : string.toCharArray()) {
            chars.add(c);
        }
        for (int i = 0; i < chars.size(); i++) {
            char temp = chars.get(i);
            long repetition = chars.stream().filter(x -> x == temp).count();
            if (repetition > maxRepetition) {
                maxRepetition = repetition;
                result = temp;
            }
        }
        return result;
    }
}
