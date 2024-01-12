package com.example.digitalcardapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class editDataScreen extends AppCompatActivity {
    FloatingActionButton editScreenBox,saveDocButton;
    RelativeLayout headerThemeBox, contentThemeBox,mainView;
    String fullName;
    TextView fullNameTextView,designationTextView, userCompanyTextView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data_screen);
        saveDocButton = findViewById(R.id.downloadIcon);
        getData();
        editScreenBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customEditBox();
            }
        });
        saveDocButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveImage();
            }
        });
    }
    String getFilePath()
    {
        File f = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        String path = f.getPath() + "/MyCard";
        File file =new  File(path);
        if (!file.exists())
        {
            file.mkdir();
        }
        return path;
    }

    void saveImage(){
        mainView.setDrawingCacheEnabled(true);
        Bitmap bitmap = mainView.getDrawingCache();

        String path = getFilePath();
        String finalPath = path+"/"+"card.jpg";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(finalPath));
            bitmap.compress(Bitmap.CompressFormat.PNG,100,fileOutputStream);
            fileOutputStream.close();
            mainView.invalidate();
        } catch (FileNotFoundException e){
            throw  new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            {
                mainView.setDrawingCacheEnabled(false);
            }
        }

    }

    void getData(){
        Intent intent = getIntent();
        if (intent != null) {
            // Retrieve byte array
            byte[] byteArray = intent.getByteArrayExtra("profilePicture");
            if (byteArray != null) {
                Bitmap profilePicture = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                CircleImageView profileImageView = findViewById(R.id.profile_pic);
                profileImageView.setImageBitmap(profilePicture);
            }else {
                Toast.makeText(editDataScreen.this, "yrctfy" , Toast.LENGTH_SHORT).show();
            }
            fullName = intent.getStringExtra("fullName");
            // Retrieve other data as needed
            String designation = intent.getStringExtra("designation");
            String company = intent.getStringExtra("company");
            String aboutMe = intent.getStringExtra("aboutMe");
            String contact = intent.getStringExtra("contactNumber");
            String whatsappNumber = intent.getStringExtra("selected");
            String email = intent.getStringExtra("email");
            String address = intent.getStringExtra("address");
            String services = intent.getStringExtra("service");

            editScreenBox = findViewById(R.id.editIcon);
            mainView = findViewById(R.id.mainRelative);
            saveDocButton = findViewById(R.id.downloadIcon);
            headerThemeBox = findViewById(R.id.cRelative);
            contentThemeBox = findViewById(R.id.contentRelative);
            fullNameTextView = findViewById(R.id.userName);
            designationTextView = findViewById(R.id.userDesignation);
            userCompanyTextView = findViewById(R.id.userCompany);
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
    void customEditBox() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_edit_dialoge);
        LinearLayout colorBlack = dialog.findViewById(R.id.black);
        LinearLayout colorWhite = dialog.findViewById(R.id.white);
        LinearLayout colorTeal700 = dialog.findViewById(R.id.teal);
        LinearLayout colorTeal200 = dialog.findViewById(R.id.teal_200);
        LinearLayout colorProgressColor = dialog.findViewById(R.id.progressColor);

        LinearLayout bg1 = dialog.findViewById(R.id.bg1);
        LinearLayout bg2 = dialog.findViewById(R.id.bg2);
        LinearLayout bg3 = dialog.findViewById(R.id.bg3);
        LinearLayout bg4 = dialog.findViewById(R.id.bg4);
        LinearLayout bg5 = dialog.findViewById(R.id.bg5);
        LinearLayout bg6 = dialog.findViewById(R.id.bg6);
        LinearLayout bg7 = dialog.findViewById(R.id.bg7);
        TextView text1 = dialog.findViewById(R.id.text1);
        TextView text2 = dialog.findViewById(R.id.text2);
        TextView text3 = dialog.findViewById(R.id.text3);
        TextView text4 = dialog.findViewById(R.id.text4);
        TextView text5 = dialog.findViewById(R.id.text5);
        TextView text6 = dialog.findViewById(R.id.text6);
        TextView text7 = dialog.findViewById(R.id.text7);
        TextView text8 = dialog.findViewById(R.id.text8);

        Button cancelButton = dialog.findViewById(R.id.cancelButton);
        Button resetButton = dialog.findViewById(R.id.resetButton);

        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText(R.font.textstyle1);
            }
        });
        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText(R.font.textstyle2);
            }
        });
        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText(R.font.textstyle3);
            }
        });
        text4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText(R.font.textstyle4);
            }
        });
        text5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText(R.font.textstyle5);
            }
        });
        text6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText(R.font.textstyle6);
            }
        });
        text7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText(R.font.textstyle7);
            }
        });
        text8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText(R.font.textstyle8);
            }
        });



        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText(R.font.defaultstyle);
                headerThemeBox.setBackgroundColor(getColor(R.color.teal_700));
                contentThemeBox.setBackground(getDrawable(R.color.white));
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        colorBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                headerThemeBox.setBackgroundColor(getColor(R.color.black));
            }
        });
        colorWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                headerThemeBox.setBackgroundColor(getColor(R.color.white));
            }
        });
        colorTeal700.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                headerThemeBox.setBackgroundColor(getColor(R.color.teal_700));
            }
        });
        colorTeal200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                headerThemeBox.setBackgroundColor(getColor(R.color.teal_200));
            }
        });
        colorProgressColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                headerThemeBox.setBackgroundColor(getColor(R.color.progressColor));
            }
        });

        bg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contentThemeBox.setBackground(getDrawable(R.drawable.bg1));
            }
        });

        bg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contentThemeBox.setBackground(getDrawable(R.drawable.bg2));
            }
        });
        bg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contentThemeBox.setBackground(getDrawable(R.drawable.bg3));
            }
        });
        bg4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contentThemeBox.setBackground(getDrawable(R.drawable.bg4));
            }
        });
        bg5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contentThemeBox.setBackground(getDrawable(R.drawable.bg5));
            }
        });
        bg6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contentThemeBox.setBackground(getDrawable(R.drawable.bg6));
            }
        });
        bg7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contentThemeBox.setBackground(getDrawable(R.drawable.bg7));
            }
        });
        dialog.show();
    }

    void setText(int font ){
        fullNameTextView.setTypeface(ResourcesCompat.getFont(editDataScreen.this,font));
        designationTextView.setTypeface(ResourcesCompat.getFont(editDataScreen.this,font));
        userCompanyTextView.setTypeface(ResourcesCompat.getFont(editDataScreen.this,font));

    }


}