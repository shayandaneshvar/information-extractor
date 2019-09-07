package ir.shayandaneshvar.infoextractor.services;

import org.springframework.stereotype.Service;

@Service
public class InfoDTO {
    private String numberOfWords;
    private String letters;
    private String mostUsedLetter;
    private String mostUsedWord;
    private String numberOfSentences;

    public void fillData(String numberOfWords, String letters,
                         String mostUsedLetter, String mostUsedWord,
                         String numberOfSentences) {
        this.numberOfWords = numberOfWords;
        this.letters = letters;
        this.mostUsedLetter = mostUsedLetter;
        this.mostUsedWord = mostUsedWord;
        this.numberOfSentences = numberOfSentences;
    }

    public String getNumberOfWords() {
        return numberOfWords;
    }

    public void setNumberOfWords(String numberOfWords) {
        this.numberOfWords = numberOfWords;
    }

    public String getLetters() {
        return letters;
    }

    public void setLetters(String letters) {
        this.letters = letters;
    }

    public String getMostUsedLetter() {
        return mostUsedLetter;
    }

    public void setMostUsedLetter(String mostUsedLetter) {
        this.mostUsedLetter = mostUsedLetter;
    }

    public String getMostUsedWord() {
        return mostUsedWord;
    }

    public void setMostUsedWord(String mostUsedWord) {
        this.mostUsedWord = mostUsedWord;
    }

    public String getNumberOfSentences() {
        return numberOfSentences;
    }

    public void setNumberOfSentences(String numberOfSentences) {
        this.numberOfSentences = numberOfSentences;
    }
}
