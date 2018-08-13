package webview.app.admin;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.dd.morphingbutton.MorphingButton;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;
import com.transitionseverywhere.Slide;
import com.transitionseverywhere.TransitionManager;

public class MainActivity extends AppCompatActivity {

    DatabaseReference mDatabase,mDatabase2,mDatabase3;
    ImageView AppLogo,SplashLogoCard;
    RelativeLayout Rel_Splash_Menu,CardView01,CardView02,CardView03,CardView04,CardView05,CardView06,CardView07,CardView08,Rel_WebPage_Menu,Rel_News_Menu;

    TextView TitleSplashCard,TitleNewsCard01;
    EditText EditTextSplash01,EditTextSplash02,EditTextWebPage01,EditTextNews01,EditTextNews02;
    FloatingActionButton SplashLogoButton,SplashLogoButton02,SplashBackButton,WebPageBackButton,WebPageButton,NewsBackButton,IntroImage01Button,IntroTitle01Button;

    WebView WebPageCard;
    String WebPageMenuUrl;

    KenBurnsView IntroImage01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mDatabase = FirebaseDatabase.getInstance().getReference("My_Splash_Screen");
        mDatabase2 = FirebaseDatabase.getInstance().getReference("WebPage");
        mDatabase3 = FirebaseDatabase.getInstance().getReference("PromotionPage");


        AppLogo = (ImageView)findViewById(R.id.AppLogo);
        SplashLogoCard = (ImageView)findViewById(R.id.SplashLogoCard);

        IntroImage01 = (KenBurnsView)findViewById(R.id.IntroImage01);

        CardView01 = (RelativeLayout)findViewById(R.id.CardView01);
        CardView02 = (RelativeLayout)findViewById(R.id.CardView02);
        CardView03 = (RelativeLayout)findViewById(R.id.CardView03);
        CardView04 = (RelativeLayout)findViewById(R.id.CardView04);
        CardView05 = (RelativeLayout)findViewById(R.id.CardView05);
        CardView06 = (RelativeLayout)findViewById(R.id.CardView06);
        CardView07 = (RelativeLayout)findViewById(R.id.CardView07);
        CardView08 = (RelativeLayout)findViewById(R.id.CardView08);
        Rel_Splash_Menu  = (RelativeLayout)findViewById(R.id.Rel_Splash_Menu);
        Rel_WebPage_Menu  = (RelativeLayout)findViewById(R.id.Rel_WebPage_Menu);
        Rel_News_Menu  = (RelativeLayout)findViewById(R.id.Rel_News_Menu);


        TitleSplashCard = (TextView)findViewById(R.id.TitleSplashCard);
        TitleNewsCard01 = (TextView)findViewById(R.id.TitleNewsCard01);


        EditTextSplash01 = (EditText)findViewById(R.id.EditTextSplash01);
        EditTextSplash02 = (EditText)findViewById(R.id.EditTextSplash02);
        EditTextWebPage01 = (EditText)findViewById(R.id.EditTextWebPage01);
        EditTextNews01 = (EditText)findViewById(R.id.EditTextNews01);
        EditTextNews02 = (EditText)findViewById(R.id.EditTextNews02);


        SplashBackButton = (FloatingActionButton)findViewById(R.id.SplashBackButton);
        WebPageBackButton = (FloatingActionButton)findViewById(R.id.WebPageBackButton);
        NewsBackButton = (FloatingActionButton)findViewById(R.id.NewsBackButton);


        SplashLogoButton02 = (FloatingActionButton)findViewById(R.id.SplashLogoButton02);
        SplashLogoButton = (FloatingActionButton)findViewById(R.id.SplashLogoButton);
        WebPageButton = (FloatingActionButton)findViewById(R.id.WebPageButton);
        IntroImage01Button = (FloatingActionButton)findViewById(R.id.IntroImage01Button);
        IntroTitle01Button = (FloatingActionButton)findViewById(R.id.IntroTitle01Button);

        WebPageCard = (WebView)findViewById(R.id.WebPageCard);

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

        MainMenuData();
        SplashScreenMenu();
        WebPageMenu();
        NewsMenu();

    }

    private void MainMenuData() {

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

    private void SplashScreenMenu() {

        CardView01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ViewGroup transitionsContainer = (ViewGroup)findViewById(R.id.Rel_Splash_Menu);
                TransitionManager.beginDelayedTransition(transitionsContainer, new Slide(Gravity.TOP));
                Rel_Splash_Menu.setVisibility(View.VISIBLE);

            }
        });

        SplashBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ViewGroup transitionsContainer = (ViewGroup)findViewById(R.id.Rel_Splash_Menu);
                TransitionManager.beginDelayedTransition(transitionsContainer, new Slide(Gravity.TOP));
                Rel_Splash_Menu.setVisibility(View.GONE);
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


    @SuppressLint("SetJavaScriptEnabled")
    private void WebPageMenu() {

        CardView02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ViewGroup transitionsContainer = (ViewGroup)findViewById(R.id.Rel_WebPage_Menu);
                TransitionManager.beginDelayedTransition(transitionsContainer, new Slide(Gravity.BOTTOM));
                Rel_WebPage_Menu.setVisibility(View.VISIBLE);
            }
        });

        WebPageBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ViewGroup transitionsContainer = (ViewGroup)findViewById(R.id.Rel_WebPage_Menu);
                TransitionManager.beginDelayedTransition(transitionsContainer, new Slide(Gravity.BOTTOM));
                Rel_WebPage_Menu.setVisibility(View.GONE);

                WebPageCard.loadUrl(WebPageMenuUrl);
            }
        });

        WebPageCard .getSettings().setJavaScriptEnabled(true);
        WebPageCard .setFocusable(true);
        WebPageCard .setFocusableInTouchMode(true);
        WebPageCard .getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        WebPageCard .getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        WebPageCard .getSettings().setDomStorageEnabled(true);
        WebPageCard .getSettings().setDatabaseEnabled(true);
        WebPageCard .getSettings().setAppCacheEnabled(true);
        WebPageCard .setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        WebPageCard .setWebViewClient(new WebViewClient());

        mDatabase2.child("WebPageURL").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                WebPageMenuUrl = dataSnapshot.getValue(String.class);

                WebPageCard.loadUrl(WebPageMenuUrl);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        WebPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String string = (String) EditTextWebPage01.getText().toString();
                mDatabase2.child("WebPageURL").setValue(string);
            }
        });
    }

    private void NewsMenu() {

        CardView03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ViewGroup transitionsContainer = (ViewGroup)findViewById(R.id.Rel_News_Menu);
                TransitionManager.beginDelayedTransition(transitionsContainer, new Slide(Gravity.RIGHT));
                Rel_News_Menu.setVisibility(View.VISIBLE);
            }
        });

        NewsBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ViewGroup transitionsContainer = (ViewGroup)findViewById(R.id.Rel_News_Menu);
                TransitionManager.beginDelayedTransition(transitionsContainer, new Slide(Gravity.RIGHT));
                Rel_News_Menu.setVisibility(View.GONE);
            }
        });

        mDatabase3.child("IntroImage01").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String url = dataSnapshot.getValue(String.class);

                Picasso.get()
                        .load(url)
                        .resize(1080,400)
                        .into(IntroImage01);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mDatabase3.child("IntroImageTitle01").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String url = dataSnapshot.getValue(String.class);

                TitleNewsCard01.setText(url);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        IntroImage01Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String string = (String) EditTextNews01.getText().toString();
                mDatabase3.child("IntroImage01").setValue(string);
            }
        });

        IntroTitle01Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String string = (String) EditTextNews02.getText().toString();
                mDatabase3.child("IntroImageTitle01").setValue(string);
            }
        });
    }

}
