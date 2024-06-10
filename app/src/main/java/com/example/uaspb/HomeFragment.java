package com.example.uaspb;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.uaspb.adapter.PostAdapter;
import com.example.uaspb.api.ApiConfig;
import com.example.uaspb.api.ApiService;
import com.example.uaspb.databinding.FragmentHomeBinding;
import com.example.uaspb.response.selectPost.Post;
import com.example.uaspb.response.selectPost.PostData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private ApiService apiService;

    private PostAdapter postAdapter;
    private FragmentHomeBinding binding;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        loadPost();  // Memanggil loadPost di sini untuk memuat data saat tampilan dibuat

        return view;
    }

    private void loadPost() {
        apiService = ApiConfig.getClient().create(ApiService.class);
        Call<Post> postCall = apiService.getPostData();
        postCall.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isStatus()) {
                    Post post = response.body();
                    List<PostData> dataList = post.getData();

                    postAdapter = new PostAdapter(getContext(), dataList);
                    binding.recyclerView.setAdapter(postAdapter);
                } else {
                    Toast.makeText(HomeFragment.this.getContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(HomeFragment.this.getContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
