package ir.shayandaneshvar.infoextractor.services;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class TextInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;
    private String numberOfWords;
    private String letters;
    private String mostUsedLetter;
    private String mostUsedWord;
    private String numberOfSentences;
    private String tag;

    public TextInfo(String tag, String text, String numberOfWords,
                    String letters,
                    String mostUsedLetter, String mostUsedWord,
                    String numberOfSentences) {
        this.numberOfWords = numberOfWords;
        this.letters = letters;
        this.mostUsedLetter = mostUsedLetter;
        this.mostUsedWord = mostUsedWord;
        this.numberOfSentences = numberOfSentences;
        this.text = text;
        this.tag = tag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNumberOfSentences() {
        return numberOfSentences;
    }

    public void setNumberOfSentences(String numberOfSentences) {
        this.numberOfSentences = numberOfSentences;
    }
}
