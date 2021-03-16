package be.bluebanana.lettersapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class NumbersFragment extends Fragment {

    LetterViewModel viewModel;

    public NumbersFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = new ViewModelProvider(getActivity()).get(LetterViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_numbers, container, false);

        v.findViewById(R.id.btn_largeNumber).setOnClickListener(view ->  {
                    viewModel.pickLargeNumber();
                });

        v.findViewById(R.id.btn_smallNumber).setOnClickListener(view -> viewModel.pickSmallNumber());

        return v;

    }
}
