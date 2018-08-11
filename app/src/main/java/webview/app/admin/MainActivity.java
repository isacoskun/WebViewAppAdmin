package webview.app.admin;

import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.dd.morphingbutton.MorphingButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;
import com.transitionseverywhere.Slide;
import com.transitionseverywhere.TransitionManager;

public class MainActivity extends AppCompatActivity {

    DatabaseReference mDatabase;
    ImageView AppLogo,SplashLogoCard;
    RelativeLayout Rel_Splash_Menu,CardView01,CardView02,CardView03,CardView04,CardView05,CardView06,CardView07,CardView08;

    TextView TitleSplashCard;
    EditText EditTextSplash01,EditTextSplash02;
    FloatingActionButton SplashLogoButton,SplashBackButton,SplashLogoButton02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AppLogo = (ImageView)findViewById(R.id.AppLogo);
        SplashLogoCard = (ImageView)findViewById(R.id.SplashLogoCard);


        CardView01 = (RelativeLayout)findViewById(R.id.CardView01);
        CardView02 = (RelativeLayout)findViewById(R.id.CardView02);
        CardView03 = (RelativeLayout)findViewById(R.id.CardView03);
        CardView04 = (RelativeLayout)findViewById(R.id.CardView04);
        CardView05 = (RelativeLayout)findViewById(R.id.CardView05);
        CardView06 = (RelativeLayout)findViewById(R.id.CardView06);
        CardView07 = (RelativeLayout)findViewById(R.id.CardView07);
        CardView08 = (RelativeLayout)findViewById(R.id.CardView08);
        Rel_Splash_Menu  = (RelativeLayout)findViewById(R.id.Rel_Splash_Menu);

        TitleSplashCard = (TextView)findViewById(R.id.TitleSplashCard);
        EditTextSplash01 = (EditText)findViewById(R.id.EditTextSplash01);
        EditTextSplash02 = (EditText)findViewById(R.id.EditTextSplash02);

        SplashLogoButton02 = (FloatingActionButton)findViewById(R.id.SplashLogoButton02);
        SplashBackButton = (FloatingActionButton)findViewById(R.id.SplashBackButton);
        SplashLogoButton = (FloatingActionButton)findViewById(R.id.SplashLogoButton);

        CardView02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        CardView03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        CardView04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        CardView05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        CardView06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        CardView07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        CardView08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        ShowAppLogoData();
        SplashScreenMenu();
    }

    private boolean hasContent(EditText et) {
        /** Always assume false until proven otherwise */
        boolean bHasContent = false;

        if (et.getText().toString().trim().length() > 0) {
            /** Got content */
            bHasContent = true;
        }
        return bHasContent;
    }

    private void SplashScreenMenu() {

        Rel_Splash_Menu.setVisibility(View.GONE);

        CardView01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ViewGroup transitionsContainer = (ViewGroup)findViewById(R.id.Rel_Splash_Menu);
                TransitionManager.beginDelayedTransition(transitionsContainer, new Slide(Gravity.TOP));
                transitionsContainer.setVisibility(View.VISIBLE);

            }
        });

        SplashLogoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String string = (String) EditTextSplash01.getText().toString();
                mDatabase.child("Splash_Logo").setValue(string);
            }
        });

        SplashLogoButton02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String string = (String) EditTextSplash02.getText().toString();
                mDatabase.child("Splash_Title").setValue(string);
            }
        });

        SplashBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ViewGroup transitionsContainer = (ViewGroup)findViewById(R.id.Rel_Splash_Menu);
                TransitionManager.beginDelayedTransition(transitionsContainer, new Slide(Gravity.TOP));
                transitionsContainer.setVisibility(View.GONE);
            }
        });

        if (hasContent(EditTextSplash02)) {

            SplashLogoButton02.setEnabled(true);
        } else {

            SplashLogoButton02.setEnabled(false);
        }

        mDatabase = FirebaseDatabase.getInstance().getReference("My_Splash_Screen");

        mDatabase.child("Splash_Logo").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String url = dataSnapshot.getValue(String.class);

                Picasso.get()
                        .load(url)
                        .resize(600,600)
                        .into(SplashLogoCard);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        mDatabase.child("Splash_Title").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String url = dataSnapshot.getValue(String.class);

                TitleSplashCard.setText(url);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

    }


    private void ShowAppLogoData() {

        mDatabase = FirebaseDatabase.getInstance().getReference("My_Splash_Screen");

        mDatabase.child("Splash_Logo").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String url = dataSnapshot.getValue(String.class);

                Picasso.get()
                        .load(url)
                        .resize(600,600)
                        .into(AppLogo);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

    }

}
