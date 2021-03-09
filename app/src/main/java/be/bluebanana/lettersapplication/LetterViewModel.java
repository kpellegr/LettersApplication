package be.bluebanana.lettersapplication;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LetterViewModel extends ViewModel {
    private MutableLiveData<Character> letter;

    MutableLiveData<Character> getLetter() {
        if (letter == null) {
            letter = new MutableLiveData<Character>(' ');
        }
        return letter;
    }

    void setLetter(char c) {
        letter.setValue(c);
    }
}
