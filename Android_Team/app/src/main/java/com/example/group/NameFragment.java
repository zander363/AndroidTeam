package com.example.group;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;


/**
 * A simple {@link Fragment} subclass.
 */
public class NameFragment extends Fragment {


    private EditText editText;
    public NameFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_name, container, false);
        Button button = (Button) v.findViewById(R.id.button3);
         editText = (EditText)v.findViewById(R.id.editText3);
       button.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                if("".equals(editText.getText().toString()))
                    Toast.makeText(NameFragment.this.getActivity(),"未輸入新名字",Toast.LENGTH_SHORT).show();
                else {
                    try {
                        Intent intent = new Intent();
                        intent.putExtra("name", editText.getText().toString());
                        intent.setClass(getActivity(), UserActivity.class);
                        getActivity().startActivity(intent);
                    }catch (Exception e){
                        Toast.makeText(NameFragment.this.getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

           }
           });



        return v;
    }

}
