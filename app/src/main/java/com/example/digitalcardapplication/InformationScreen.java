package com.example.digitalcardapplication;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.ByteArrayOutputStream;

import de.hdodenhof.circleimageview.CircleImageView;

public class InformationScreen extends AppCompatActivity {
    CircleImageView circleImageView;
    TextInputLayout nameTextLayout,designationTextLayout,companyTextLayout,aboutMeTextLayout,contactNumberTextLayout,emailTextLayout,addressTextLayout,serviceInfoTextLayout;
    TextInputEditText nameText,designationText,companyText,aboutMeText,contactNumberText,emailText,addressText,serviceInfoText;
    RadioGroup radioGroup;
    RadioButton yesRadio,noRadio;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_screen);
        initBinding();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName = nameText.getText().toString();
                String designation = designationText.getText().toString();
                String company = companyText.getText().toString();
                String aboutMe = aboutMeText.getText().toString();
                String contactNumber = contactNumberText.getText().toString();
                String selected="";
                String email = emailText.getText().toString();
                String address = addressText.getText().toString();
                String service = serviceInfoText.getText().toString();

                int id = radioGroup.getCheckedRadioButtonId();
                if (id==R.id.yesWhatsAppNumber)
                {
                    selected = "Yes";
                } else if (id==R.id.noWhatsAppNumber) {
                    selected = "No";

                }

                if(fullName.isEmpty()){
                    nameText.setError("Please Enter Name");
                    nameTextLayout.setError("Please Enter Name");
                    nameText.requestFocus();
                } else if(designation.isEmpty()){
                    designationText.setError("Please Enter Designation");
                    designationTextLayout.setError("Please Enter Designation");
                    designationText.requestFocus();
                }
                else if(company.isEmpty()){
                    companyText.setError("Please Enter Company");
                    companyTextLayout.setError("Please Enter Company");
                    companyText.requestFocus();
                }
                else if(aboutMe.isEmpty()){
                    aboutMeText.setError("Please Enter About Me");
                    aboutMeTextLayout.setError("Please Enter About Me");
                    aboutMeText.requestFocus();
                }
                else if(contactNumber.isEmpty()){
                    contactNumberText.setError("Please Enter About Me");
                    contactNumberTextLayout.setError("Please Enter About Me");
                    contactNumberText.requestFocus();
                }
                else if(selected.isEmpty()){
                    Toast.makeText(InformationScreen.this, "please select yes or no", Toast.LENGTH_SHORT).show();
                }
                else if(email.isEmpty()){
                    emailText.setError("Please Enter Email");
                    emailTextLayout.setError("Please Enter Email");
                    emailText.requestFocus();
                }
                else if(address.isEmpty()){
                    addressText.setError("Please Enter Address");
                    addressTextLayout.setError("Please Enter Address");
                    addressText.requestFocus();
                }
                else if(service.isEmpty()){
                    serviceInfoText.setError("Please Enter Services");
                    serviceInfoTextLayout.setError("Please Enter Services");
                    serviceInfoText.requestFocus();
                }
                else {
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    Bitmap bitmap = ((BitmapDrawable) circleImageView.getDrawable()).getBitmap();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                    byte[] byteArray = stream.toByteArray();
                    Intent intent = new Intent(InformationScreen.this, editDataScreen.class);
                    intent.putExtra("profilePicture", byteArray);
                    intent.putExtra("fullName", fullName);
                    intent.putExtra("designation", designation);
                    intent.putExtra("company", company);
                    intent.putExtra("aboutMe", aboutMe);
                    intent.putExtra("contactNumber", contactNumber);
                    intent.putExtra("selected", selected);
                    intent.putExtra("email", email);
                    intent.putExtra("address", address);
                    intent.putExtra("service", service);

                    startActivity(intent);

//                    Toast.makeText(InformationScreen.this, fullName+""+designation+""
//                            +company+""+aboutMe+""+contactNumber+""+selected+""+email+""+address+""
//                            +service , Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void initBinding(){
        circleImageView = findViewById(R.id.profile_pic);
        nameTextLayout = findViewById(R.id.fullNameTextLayout);
        designationTextLayout = findViewById(R.id.designationTextLayout);
        companyTextLayout = findViewById(R.id.companyTextLayout);
        aboutMeTextLayout = findViewById(R.id.aboutMeTextLayout);
        contactNumberTextLayout = findViewById(R.id.contactNumberTextLayout);
        radioGroup = findViewById(R.id.radioGroup);
        yesRadio = findViewById(R.id.yesWhatsAppNumber);
        noRadio = findViewById(R.id.noWhatsAppNumber);
        emailTextLayout = findViewById(R.id.emailTextLayout);
        emailText = findViewById(R.id.emailText);
        addressTextLayout = findViewById(R.id.addressTextLayout);
        serviceInfoTextLayout = findViewById(R.id.serviceInfoTextLayout);

        addressText = findViewById(R.id.addressText);
        serviceInfoText = findViewById(R.id.serviceInfoText);
        nextButton = findViewById(R.id.nextButton);
        nameText = findViewById(R.id.fullNameText);
        aboutMeText = findViewById(R.id.aboutMeText);
        designationText = findViewById(R.id.designationText);
        companyText = findViewById(R.id.companyText);
        contactNumberText = findViewById(R.id.contactNumberText);


        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,100);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null)
        {
            Uri uri = data.getData();
            circleImageView.setImageURI(uri);
        } else if (requestCode == 101) {

            if(data!=null) {
                Bitmap b1 = (Bitmap) data.getExtras().get("data");
                circleImageView.setImageBitmap(b1);
            }
        }
    }
}