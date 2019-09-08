package ir.shayandaneshvar.infoextractor.services;

public class InfoDTO {
    private String tag;
    private String letters;
    private String numberOfWords;
    private String mostUsedLetter;
    private String mostUsedWord;
    private String numberOfSentences;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public InfoDTO(TextInfo textInfo) {
        tag = textInfo.getTag();
        letters = textInfo.getLetters();
        numberOfWords = textInfo.getNumberOfWords();
        numberOfSentences = textInfo.getNumberOfSentences();
        mostUsedLetter = textInfo.getMostUsedLetter();
        mostUsedWord = textInfo.getMostUsedWord();
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
