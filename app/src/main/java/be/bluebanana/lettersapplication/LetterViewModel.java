package be.bluebanana.lettersapplication;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Random;

public class LetterViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Character>> letters;
    private MutableLiveData<ArrayList<Integer>> numbers;
    private MutableLiveData<Integer> currentRound;

    private final Random random = new Random();
    private static final int MAX_SMALL_INT = 9;
    private static final int[] ALLOWED_NUMBERS = {10, 25, 50, 100};
    public static final int NUMBERS_ROUND = 0;
    public static final int LETTERS_ROUND = 1;

    public MutableLiveData<ArrayList<Character>> getLetters() {
        if (letters == null) {
            letters = new MutableLiveData<ArrayList<Character>>();
            letters.setValue(new ArrayList<Character>());
        }
        return letters;
    }

    public MutableLiveData<ArrayList<Integer>> getNumbers() {
        if (numbers == null) {
            numbers = new MutableLiveData<ArrayList<Integer>>();
            numbers.setValue(new ArrayList<Integer>());
        }
        return numbers;
    }

    public MutableLiveData<Integer> getCurrentRound() {
        if (currentRound == null) {
            currentRound = new MutableLiveData<Integer>(NUMBERS_ROUND);
        }
        return currentRound;
    }

    public void nextRound() {
        clearLetters();
        clearNumbers();

//        currentRound.setValue(1 - currentRound.getValue());

        if (currentRound.getValue() == NUMBERS_ROUND)
            currentRound.setValue(LETTERS_ROUND);
        else
            currentRound.setValue(NUMBERS_ROUND);
    }

    public void pickSmallNumber() {
        ArrayList<Integer> list = getNumbers().getValue();
        list.add(random.nextInt(MAX_SMALL_INT) + 1);
        numbers.setValue(list);
    }

    public void pickLargeNumber() {
        ArrayList<Integer> list = getNumbers().getValue();
        int number = ALLOWED_NUMBERS[random.nextInt(ALLOWED_NUMBERS.length - 1)];
        list.add(number);
        numbers.setValue(list);
    }

    public void pickVowel() {
        ArrayList<Character> list = getLetters().getValue();
        char c;
        do {
            c = pickALetter();
        } while (!isVowel(c));
        list.add(c);
        letters.setValue(list);
    }

    public void pickConsonant() {
        ArrayList<Character> list = getLetters().getValue();
        char c;
        do {
            c = pickALetter();
        } while (!isConsonant(c));
        list.add(c);
        letters.setValue(list);
    }

    public void clearLetters() {
        ArrayList<Character> list = getLetters().getValue();
        list.clear();
        letters.setValue(list);
    }

    public void clearNumbers() {
        ArrayList<Integer> list = getNumbers().getValue();
        list.clear();
        numbers.setValue(list);
    }


    private char pickALetter() {
        int ascii = random.nextInt(26) + 65;; // lowercase 'a'
        return (char)ascii;
    }

    private boolean isVowel (char c) {
        char[] vowels = {'A', 'E', 'I', 'O', 'U'};

        for (char v: vowels) {
            if (v == c) return true;
        }
        return false;
    }

    private boolean isConsonant (char c) {
        return !isVowel(c);
    }

}
