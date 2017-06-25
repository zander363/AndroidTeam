package com.example.group;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class NameFragment extends Fragment {


    public NameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
/*
        View v = inflater.inflate(R.layout.fragment_name, container, false);
        Button button = (Button) v.findViewById(R.id.button3);

       button.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){

                Toast.makeText(NameFragment.this.getActivity(),"cc", Toast.LENGTH_SHORT).show();

           }
           });
*/


        return inflater.inflate(R.layout.fragment_name, container, false);
    }

}
