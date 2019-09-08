package ir.shayandaneshvar.infoextractor.services;

import ir.shayandaneshvar.infoextractor.services.operators.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.BiFunction;

@Service
public final class CompositeInfoFacade implements BiFunction<String, String,
        TextInfo> {
    private WordCounterService wordCounter;
    private LetterCounterService letterCounter;
    private SentenceCounterService sentenceCounter;
    private MostUsedLetterFinderService mostUsedLetter;
    private MostUsedWordFinderService mostUsedWord;

    @Autowired
    public CompositeInfoFacade(WordCounterService wordCounter,
                               LetterCounterService letterCounter,
                               SentenceCounterService sentenceCounter,
                               MostUsedLetterFinderService mostUsedLetter,
                               MostUsedWordFinderService mostUsedWord) {
        this.wordCounter = wordCounter;
        this.letterCounter = letterCounter;
        this.sentenceCounter = sentenceCounter;
        this.mostUsedLetter = mostUsedLetter;
        this.mostUsedWord = mostUsedWord;
    }

    public Integer countWords(String string) {
        return wordCounter.apply(string);
    }

    public Long countLetters(String string) {
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

    @Override
    public TextInfo apply(String tag, String text) {
        TextInfo textInfo = new TextInfo(tag,text, String.valueOf(countWords(
                text)), String.valueOf(countLetters(text)),
                String.valueOf(getMostUsedLetter(text)), getMostUsedWord(
                text), String.valueOf(countSentences(text)));
        return textInfo;
    }
}
