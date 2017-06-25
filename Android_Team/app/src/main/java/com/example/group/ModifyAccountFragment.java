package com.example.group;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ModifyAccountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ModifyAccountFragment extends Fragment {

    private EditText editText2;
    private EditText editText4;
    private EditText editText5;

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public ModifyAccountFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ModifyAccountFragment.
     */
    public static ModifyAccountFragment newInstance(String param1, String param2) {
        ModifyAccountFragment fragment = new ModifyAccountFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (getArguments() != null) {
                mParam1 = getArguments().getString(ARG_PARAM1);
                mParam2 = getArguments().getString(ARG_PARAM2);
            }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_modify_account, container, false);
        Button button = (Button) v.findViewById(R.id.button4);
         editText2 = (EditText)v.findViewById(R.id.editText2);
         editText5 = (EditText)v.findViewById(R.id.editText5);

         editText4 = (EditText)v.findViewById(R.id.editText4);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){


                Intent intent = new Intent();
                if(!editText4.getText().toString().equals(editText5.getText().toString()))
                    Toast.makeText(ModifyAccountFragment.this.getActivity(), "兩次輸入密碼不相同", Toast.LENGTH_SHORT).show();
                else {
                    intent.setClass(getActivity(), UserActivity.class);
                    Toast.makeText(ModifyAccountFragment.this.getActivity(), "密碼修改成功", Toast.LENGTH_SHORT).show();
                    getActivity().startActivity(intent);
                }



            }
        });

        return v;
    }

}
