package com.hw.bousman.exercises;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExampleFragment extends Fragment {


    public ExampleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.example_fragment, container, false);

        Button okButton = (Button)view.findViewById(R.id.button);
        okButton.setOnClickListener(new View.OnClickListener() {
                                        public void onClick(View view) {
                                            Toast.makeText(getActivity(), "OK", Toast.LENGTH_LONG).show();
                                        }
                                    }
        );

        return view;
    }


}
