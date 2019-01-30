import java.util.*;

public class WordSet {
    private List<String> words;

    public WordSet() {
        words = new ArrayList<>();
    }

    public void add(String word) {
        words.add(word);
    }

    public Iterator<String> iterator() {
        return new WordSetIterator();
    }

    private class WordSetIterator implements Iterator<String> {
        private int position;

        public WordSetIterator() {
            position = 0;
        }

        @Override
        public boolean hasNext() {
            if(position < words.size()) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public String next() {
            if(position < words.size()) {
                return words.get(position++);
            }
            throw new NoSuchElementException();
        }
    }

}
