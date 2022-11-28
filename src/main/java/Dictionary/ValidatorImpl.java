package Dictionary;

public class ValidatorImpl implements Validator{
    private int wordCount;
    private WordType wordType;

    public ValidatorImpl(int wordCount, WordType wordType) {
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
