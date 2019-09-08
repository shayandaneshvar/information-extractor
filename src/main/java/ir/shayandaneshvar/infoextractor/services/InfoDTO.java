package ir.shayandaneshvar.infoextractor.services;

public class InfoDTO {
    private String numberOfWords;
    private String letters;
    private String mostUsedLetter;
    private String mostUsedWord;
    private String numberOfSentences;

    public InfoDTO(TextInfo textInfo) {
        numberOfSentences = textInfo.getNumberOfSentences();
        letters = textInfo.getLetters();
        mostUsedLetter = textInfo.getMostUsedLetter();
        mostUsedWord = textInfo.getMostUsedWord();
        numberOfWords = textInfo.getNumberOfWords();
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
