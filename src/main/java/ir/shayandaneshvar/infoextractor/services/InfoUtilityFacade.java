package ir.shayandaneshvar.infoextractor.services;

import ir.shayandaneshvar.infoextractor.services.operators.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class InfoUtilityFacade implements Operator<InfoDTO> {
    private WordCounterService wordCounter;
    private LetterCounterService letterCounter;
    private SentenceCounterService sentenceCounter;
    private MostUsedLetterFinderService mostUsedLetter;
    private MostUsedWordFinderService mostUsedWord;
    private InfoDTO infoDTO;

    @Autowired
    public InfoUtilityFacade(InfoDTO infoDTO, WordCounterService wordCounter,
                             LetterCounterService letterCounter,
                             SentenceCounterService sentenceCounter,
                             MostUsedLetterFinderService mostUsedLetter,
                             MostUsedWordFinderService mostUsedWord) {
        this.wordCounter = wordCounter;
        this.letterCounter = letterCounter;
        this.sentenceCounter = sentenceCounter;
        this.mostUsedLetter = mostUsedLetter;
        this.mostUsedWord = mostUsedWord;
        this.infoDTO = infoDTO;
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
    public InfoDTO apply(String string) {
        infoDTO.fillData(String.valueOf(countWords(string)),
                String.valueOf(countLetters(string)),
                String.valueOf(getMostUsedLetter(string)),
                getMostUsedWord(string),
                String.valueOf(countSentences(string)));
        return infoDTO;
    }
}
