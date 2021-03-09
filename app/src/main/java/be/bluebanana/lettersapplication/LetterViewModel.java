package be.bluebanana.lettersapplication;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Random;

public class LetterViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Character>> letters;
    private MutableLiveData<ArrayList<Integer>> numbers;

    private final Random random = new Random();
    private static final int MAX_SMALL_INT = 9;
    private static final int[] ALLOWED_NUMBERS = {10, 25, 50, 100};

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

    private char pickALetter() {
        int ascii = random.nextInt(26) + 97;; // lowercase 'a'
        return (char)ascii;
    }

    private boolean isVowel (char c) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        for (char v: vowels) {
            if (v == c) return true;
        }
        return false;
    }

    private boolean isConsonant (char c) {
        return !isVowel(c);
    }

}
