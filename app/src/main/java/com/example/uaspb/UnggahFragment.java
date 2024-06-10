package com.example.uaspb;


import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class UnggahFragment extends Fragment {

    ImageView imageView;
    EditText etNama, etSpesies, etJenis, etUmur, etBio;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_unggah, container, false);

        etNama = rootView.findViewById(R.id.etUnggahNama);
        etSpesies = rootView.findViewById(R.id.etUnggahSpesies);
        etJenis = rootView.findViewById(R.id.etUnggahJenis);
        etUmur = rootView.findViewById(R.id.etUnggahUmur);
        etBio = rootView.findViewById(R.id.etUnggahBio);

        imageView = rootView.findViewById(R.id.ivUnggahImage);
        Button btnSelectImage = rootView.findViewById(R.id.btnUnggahKamera);
        Button btnSubmit = rootView.findViewById(R.id.btnUnggahKirim);

        btnSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 1);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get data from EditText fields
                String nama = etNama.getText().toString().trim();
                String spesies = etSpesies.getText().toString().trim();
                String jenis = etJenis.getText().toString().trim();
                String umur = etUmur.getText().toString().trim();
                String bio = etBio.getText().toString().trim();

                // Handle submission logic here
            }
        });

        return rootView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == getActivity().RESULT_OK) {
            if (requestCode == 1) {
                // Handle gallery result
                Uri selectedImage = data.getData();
                // Set the selected image to ImageView
                imageView.setImageURI(selectedImage);
            } else if (requestCode == 2) {
                // Handle camera result
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                // Set the photo bitmap to ImageView
                imageView.setImageBitmap(photo);
            }
        }
    }
}
