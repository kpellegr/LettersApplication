package be.bluebanana.lettersapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tvLetter;
    LetterViewModel viewModel;

    LettersFragment lettersFragment;
    NumbersFragment numbersFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(LetterViewModel.class);
        lettersFragment = new LettersFragment();
        numbersFragment = new NumbersFragment();

        tvLetter = findViewById(R.id.tv_letter);

        viewModel.getLetters().observe(this, character ->
                tvLetter.setText(character.toString()));

        viewModel.getNumbers().observe(this, number ->
                tvLetter.setText(number.toString()));

        viewModel.getCurrentRound().observe(this, round -> {
            if (round == LetterViewModel.NUMBERS_ROUND) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.layout_a, numbersFragment)
                        .commit();
            } else {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.layout_a, lettersFragment)
                        .commit();
            }
        });
    }

    public void nextRound(View v) {
        viewModel.nextRound();
    }
}
