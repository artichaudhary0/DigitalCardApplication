package com.example.digitalcardapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class editDataScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data_screen);
        getData();
    }
    void getData(){
        Intent intent = getIntent();
        if (intent != null) {
            // Retrieve byte array
            byte[] byteArray = intent.getByteArrayExtra("profilePicture");
            if (byteArray != null) {
                // Convert byte array to Bitmap
                Bitmap profilePicture = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                // Set the Bitmap to your ImageView
                CircleImageView profileImageView = findViewById(R.id.profile_pic);
                profileImageView.setImageBitmap(profilePicture);
            }else {
                Toast.makeText(editDataScreen.this, "yrctfy" , Toast.LENGTH_SHORT).show();
            }
            String fullName = intent.getStringExtra("fullName");
            // Retrieve other data as needed
            String designation = intent.getStringExtra("designation");
            String company = intent.getStringExtra("company");
            String aboutMe = intent.getStringExtra("aboutMe");
            String contact = intent.getStringExtra("contactNumber");
            String whatsappNumber = intent.getStringExtra("selected");
            String email = intent.getStringExtra("email");
            String address = intent.getStringExtra("address");
            String services = intent.getStringExtra("service");

            TextView fullNameTextView = findViewById(R.id.userName);
            TextView designationTextView = findViewById(R.id.userDesignation);
            TextView userCompanyTextView = findViewById(R.id.userCompany);
            TextView userAboutMeTextTextView = findViewById(R.id.userAboutMeText);
            TextView userContactTextView = findViewById(R.id.userContactText);
            TextView userWhatsappTextView = findViewById(R.id.userWhatsAppText);
            TextView userEmailTextView = findViewById(R.id.userEmailText);
            TextView userAddressTextView = findViewById(R.id.userAddressText);
            TextView userServicesTextView = findViewById(R.id.userServices);

            fullNameTextView.setText(fullName);
            designationTextView.setText(designation);
            userAddressTextView.setText(address);
            userAboutMeTextTextView.setText(aboutMe);
            userCompanyTextView.setText(company);
            userContactTextView.setText(contact);
            userWhatsappTextView.setText(whatsappNumber);
            userEmailTextView.setText(email);
            userServicesTextView.setText(services);
            Toast.makeText(editDataScreen.this, fullName+""+designation+""+ ""+company , Toast.LENGTH_SHORT).show();
        }


    }



}