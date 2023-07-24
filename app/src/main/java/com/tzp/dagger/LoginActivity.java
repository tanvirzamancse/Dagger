package com.tzp.dagger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.Toast;

import com.tzp.dagger.data.DivisionResponse;
import com.tzp.dagger.databinding.ActivityMainBinding;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity {
    ActivityMainBinding binding;
   @Inject
    public LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        viewModel.getDivision().observe(this, new Observer<DivisionResponse>() {
            @Override
            public void onChanged(DivisionResponse divisionResponse) {

                if (divisionResponse.getStatus()) {

                    Toast.makeText(LoginActivity.this, "" + divisionResponse.getData().get(0).getName(), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(LoginActivity.this, "error", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}