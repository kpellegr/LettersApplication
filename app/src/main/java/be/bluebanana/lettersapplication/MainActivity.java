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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(LetterViewModel.class);

        tvLetter = findViewById(R.id.tv_letter);

        viewModel.getLetter().observe(this, character ->
                tvLetter.setText(character.toString()));

        viewModel.getNumber().observe(this, number ->
                tvLetter.setText(number.toString()));
    }

    public void pickVowel(View v) {
        viewModel.pickVowel();
    }

    public void pickConsonant(View v) {
        viewModel.pickConsonant();
    }

    public void pickNumber(View v) {
        viewModel.generateNumber();
    }















}