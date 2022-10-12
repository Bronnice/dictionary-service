package Dictionary;

public class Validator {
    private int wordCount;
    private WordType wordType;

    public Validator(int wordCount, WordType wordType) {
        this.wordCount = wordCount;
        this.wordType = wordType;
    }

    public int getWordCount() {
        return wordCount;
    }

    public WordType getWordType() {
        return wordType;
    }
}
