package com.example.healeats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class AdminHomeActivity extends AppCompatActivity {
    private TextView text;
    private ImageView pfp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        text=findViewById(R.id.textView);
        pfp=findViewById(R.id.imageView);
        User user = UserDataSingleton.getInstance().getUser();
        if (user != null) {
            text.setText("Hello Admin" + user.getFirstName());
        } else {
            Log.e("HomeActivity", "User object is null"); // Log an error for debugging
            text.setText("Hello null");
        }
    }

    public void onProfilePictureClick(View view) {
        // Navigate to the EditProfileActivity
        Intent intent = new Intent(this, AdminProfile.class);
        startActivity(intent);

    }

    public void onAllDiseaseButtonClick(View view) {
        Intent intent = new Intent(this, AdminDiseasesListActivity.class);
        startActivity(intent);
    }

}