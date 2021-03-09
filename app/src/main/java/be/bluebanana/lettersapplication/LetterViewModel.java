package be.bluebanana.lettersapplication;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class LetterViewModel extends ViewModel {
    private MutableLiveData<Character> letter;
    private MutableLiveData<Integer> number;

    private Random random;
    private static int MAX_INT = 100;

    public MutableLiveData<Character> getLetter() {
        if (letter == null) {
            letter = new MutableLiveData<Character>(' ');
        }
        return letter;
    }

    public MutableLiveData<Integer> getNumber() {
        if (number == null) {
            number = new MutableLiveData<Integer>();
            random = new Random();
        }
        return number;
    }

    public void generateNumber() {
        number.setValue(random.nextInt(MAX_INT));
    }

    public void pickVowel() {
        char c;
        do {
            c = pickALetter();
        } while (!isVowel(c));
        letter.setValue(c);
    }

    public void pickConsonant() {
        char c;
        do {
            c = pickALetter();
        } while (!isConsonant(c));
        letter.setValue(c);
    }



    private char pickALetter() {
        Random random = new Random();
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
