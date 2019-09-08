package ir.shayandaneshvar.infoextractor.services;

public class TextInfo {

    private String text;
    private String numberOfWords;
    private String letters;
    private String mostUsedLetter;
    private String mostUsedWord;
    private String numberOfSentences;

    public TextInfo(String text, String numberOfWords, String letters,
                    String mostUsedLetter, String mostUsedWord,
                    String numberOfSentences) {
        this.numberOfWords = numberOfWords;
        this.letters = letters;
        this.mostUsedLetter = mostUsedLetter;
        this.mostUsedWord = mostUsedWord;
        this.numberOfSentences = numberOfSentences;
        this.text = text;
    }

    public String getNumberOfWords() {
        return numberOfWords;
    }

    public String getLetters() {
        return letters;
    }

    public String getMostUsedLetter() {
        return mostUsedLetter;
    }


    public String getMostUsedWord() {
        return mostUsedWord;
    }

    public String getText() {
        return text;
    }

    public String getNumberOfSentences() {
        return numberOfSentences;
    }
}
