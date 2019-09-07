package ir.shayandaneshvar.infoextractor.services.operators;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MostUsedWordFinderService implements Operator<String> {
    @Override
    public String apply(String string) {
        var words = string.replace(".", " ").split(" ");
        String result = " ";
        long maxRepetition = 0;
        for (String str : words) {
            long rep = Arrays.stream(words).filter(x -> x.equals(str)).count();
            if (rep > maxRepetition) {
                maxRepetition = rep;
                result = str;
            }
        }
        return result;
    }
}
