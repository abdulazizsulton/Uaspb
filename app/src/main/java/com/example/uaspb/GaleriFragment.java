package com.example.uaspb;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.uaspb.adapter.GalleryAdapter;
import com.example.uaspb.databinding.FragmentGaleriBinding;

import java.util.ArrayList;
import java.util.List;

public class GaleriFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private FragmentGaleriBinding binding;

    public GaleriFragment() {
        // Required empty public constructor
    }

    public static GaleriFragment newInstance(String param1, String param2) {
        GaleriFragment fragment = new GaleriFragment();
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
        binding = FragmentGaleriBinding.inflate(inflater, container, false);
        View view = binding.getRoot();


        binding.imageAnjing.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), DogiActivity.class);
            startActivity(intent);
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
