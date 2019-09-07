package ir.shayandaneshvar.infoextractor.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public final class InfoUtilityFacade {
    private Operator<Integer> wordCounter;
    private Operator<Integer> letterCounter;
    private Operator<Integer> sentenceCounter;
    private Operator<Character> mostUsedLetter;
    private Operator<String> mostUsedWord;
    private InfoDTO infoDTO;

    public InfoUtilityFacade(InfoDTO infoDTO) {
        this.infoDTO = infoDTO;
        initOperators();
    }

    private void initOperators() {
        wordCounter = sentence -> sentence.replace(".", " ").split(" ").length;
        letterCounter = s -> s.replace(" ", "").replace(".", "").length();
        sentenceCounter = s -> s.split("\\.").length - 1;
        mostUsedLetter = sentence -> {
            sentence = sentence.replace(".", "").replace(" ", "");
            char result = ' ';
            long maxRepetition = 0;
            List<Character> chars = new ArrayList<>();
            for (char c : sentence.toCharArray()) {
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
        };
        mostUsedWord = sentence -> {
            var words = sentence.replace(".", " ").split(" ");
            String result = " ";
            long maxRepetition = 0;
            for (String string : words) {
                long rep = Arrays.stream(words).filter(x -> x.equals(string)).count();
                if (rep > maxRepetition) {
                    maxRepetition = rep;
                    result = string;
                }
            }
            return result;
        };
    }

    public Integer countWords(String string) {
        return wordCounter.apply(string);
    }

    public Integer countLetters(String string) {
        return letterCounter.apply(string);
    }

    public Integer countSentences(String string) {
        return sentenceCounter.apply(string);
    }

    public Character getMostUsedLetter(String string) {
        return mostUsedLetter.apply(string);
    }

    public String getMostUsedWord(String string) {
        return mostUsedWord.apply(string);
    }

    public InfoDTO getDTO(String string) {
        infoDTO.fillData(String.valueOf(countWords(string)),
                String.valueOf(countLetters(string)),
                String.valueOf(getMostUsedLetter(string)),
                getMostUsedWord(string),
                String.valueOf(countSentences(string)));
        return infoDTO;
    }
}
