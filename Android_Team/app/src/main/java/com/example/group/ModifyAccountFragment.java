package com.example.group;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ModifyAccountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ModifyAccountFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
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
    // TODO: Rename and change types and number of parameters
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

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                Toast.makeText(ModifyAccountFragment.this.getActivity(),"密碼修改成功", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent();
                intent.setClass(getActivity(),UserActivity.class);
                getActivity().startActivity(intent);


            }
        });

        return v;
    }

}
