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
    RelativeLayout Rel_Splash_Menu,CardView01,CardView02,CardView03,CardView04,CardView05,CardView06,CardView07,CardView08,
            Rel_WebPage_Menu,Rel_News_Menu,Rel_Navigation_Menu;

    TextView TitleSplashCard,TitleNewsCard01,TitleNewsCard02,TitleNewsCard03;
    EditText EditTextSplash01,EditTextSplash02,EditTextWebPage01,EditTextNews01,EditTextNews02,EditTextNews03,EditTextNews04,EditTextNews05,
            EditTextNews06,EditTextNews07,EditTextNews08,EditTextNews09;
    FloatingActionButton SplashLogoButton,SplashLogoButton02,SplashBackButton,WebPageBackButton,WebPageButton,NewsBackButton,
            IntroImage01Button,IntroTitle01Button,WebPage01Button,IntroImage02Button,IntroTitle02Button,WebPage02Button,
            IntroImage03Button,IntroTitle03Button,WebPage03Button,NavigationBackButton;

    WebView WebPageCard,WebPageNewsCard01,WebPageNewsCard02,WebPageNewsCard03;
    String WebPageMenuUrl,WebPageNewsCard01URL,WebPageNewsCard02URL,WebPageNewsCard03URL;

    KenBurnsView IntroImage01,IntroImage02,IntroImage03;

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
        IntroImage02 = (KenBurnsView)findViewById(R.id.IntroImage02);
        IntroImage03 = (KenBurnsView)findViewById(R.id.IntroImage03);

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
        Rel_Navigation_Menu  = (RelativeLayout)findViewById(R.id.Rel_Navigation_Menu);


        TitleSplashCard = (TextView)findViewById(R.id.TitleSplashCard);
        TitleNewsCard01 = (TextView)findViewById(R.id.TitleNewsCard01);
        TitleNewsCard02 = (TextView)findViewById(R.id.TitleNewsCard02);
        TitleNewsCard03 = (TextView)findViewById(R.id.TitleNewsCard03);


        EditTextSplash01 = (EditText)findViewById(R.id.EditTextSplash01);
        EditTextSplash02 = (EditText)findViewById(R.id.EditTextSplash02);
        EditTextWebPage01 = (EditText)findViewById(R.id.EditTextWebPage01);
        EditTextNews01 = (EditText)findViewById(R.id.EditTextNews01);
        EditTextNews02 = (EditText)findViewById(R.id.EditTextNews02);
        EditTextNews03 = (EditText)findViewById(R.id.EditTextNews03);
        EditTextNews04 = (EditText)findViewById(R.id.EditTextNews04);
        EditTextNews05 = (EditText)findViewById(R.id.EditTextNews05);
        EditTextNews06 = (EditText)findViewById(R.id.EditTextNews06);
        EditTextNews07 = (EditText)findViewById(R.id.EditTextNews07);
        EditTextNews08 = (EditText)findViewById(R.id.EditTextNews08);
        EditTextNews09 = (EditText)findViewById(R.id.EditTextNews09);


        SplashBackButton = (FloatingActionButton)findViewById(R.id.SplashBackButton);
        WebPageBackButton = (FloatingActionButton)findViewById(R.id.WebPageBackButton);
        NewsBackButton = (FloatingActionButton)findViewById(R.id.NewsBackButton);
        NavigationBackButton = (FloatingActionButton)findViewById(R.id.NavigationBackButton);


        SplashLogoButton02 = (FloatingActionButton)findViewById(R.id.SplashLogoButton02);
        SplashLogoButton = (FloatingActionButton)findViewById(R.id.SplashLogoButton);
        WebPageButton = (FloatingActionButton)findViewById(R.id.WebPageButton);
        IntroImage01Button = (FloatingActionButton)findViewById(R.id.IntroImage01Button);
        IntroTitle01Button = (FloatingActionButton)findViewById(R.id.IntroTitle01Button);
        WebPage01Button = (FloatingActionButton)findViewById(R.id.WebPage01Button);
        IntroImage02Button = (FloatingActionButton)findViewById(R.id.IntroImage02Button);
        IntroTitle02Button = (FloatingActionButton)findViewById(R.id.IntroTitle02Button);
        WebPage02Button = (FloatingActionButton)findViewById(R.id.WebPage02Button);
        IntroImage03Button = (FloatingActionButton)findViewById(R.id.IntroImage03Button);
        IntroTitle03Button = (FloatingActionButton)findViewById(R.id.IntroTitle03Button);
        WebPage03Button = (FloatingActionButton)findViewById(R.id.WebPage03Button);

        WebPageCard = (WebView)findViewById(R.id.WebPageCard);
        WebPageNewsCard01 = (WebView)findViewById(R.id.WebPageNewsCard01);
        WebPageNewsCard02 = (WebView)findViewById(R.id.WebPageNewsCard02);
        WebPageNewsCard03 = (WebView)findViewById(R.id.WebPageNewsCard03);

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
        NavigationMenu();

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

    @SuppressLint("SetJavaScriptEnabled")
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

                WebPageNewsCard01.loadUrl(WebPageNewsCard01URL);
                WebPageNewsCard02.loadUrl(WebPageNewsCard02URL);
                WebPageNewsCard03.loadUrl(WebPageNewsCard03URL);

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
                String string = dataSnapshot.getValue(String.class);

                TitleNewsCard01.setText(string);
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

        WebPageNewsCard01 .getSettings().setJavaScriptEnabled(true);
        WebPageNewsCard01 .setFocusable(true);
        WebPageNewsCard01 .setFocusableInTouchMode(true);
        WebPageNewsCard01 .getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        WebPageNewsCard01 .getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        WebPageNewsCard01 .getSettings().setDomStorageEnabled(true);
        WebPageNewsCard01 .getSettings().setDatabaseEnabled(true);
        WebPageNewsCard01 .getSettings().setAppCacheEnabled(true);
        WebPageNewsCard01 .setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        WebPageNewsCard01 .setWebViewClient(new WebViewClient());

        mDatabase3.child("PromotionWebPageURL01").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                WebPageNewsCard01URL = dataSnapshot.getValue(String.class);

                WebPageNewsCard01.loadUrl(WebPageNewsCard01URL);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        WebPage01Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String string = (String) EditTextNews03.getText().toString();
                mDatabase3.child("PromotionWebPageURL01").setValue(string);
            }
        });

        mDatabase3.child("IntroImage02").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String url = dataSnapshot.getValue(String.class);

                Picasso.get()
                        .load(url)
                        .resize(1080,400)
                        .into(IntroImage02);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        IntroImage02Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String string = (String) EditTextNews04.getText().toString();
                mDatabase3.child("IntroImage02").setValue(string);
            }
        });

        mDatabase3.child("IntroImageTitle02").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String string = dataSnapshot.getValue(String.class);

                TitleNewsCard02.setText(string);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        IntroTitle02Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String string = (String) EditTextNews05.getText().toString();
                mDatabase3.child("IntroImageTitle02").setValue(string);
            }
        });

        WebPageNewsCard02 .getSettings().setJavaScriptEnabled(true);
        WebPageNewsCard02 .setFocusable(true);
        WebPageNewsCard02 .setFocusableInTouchMode(true);
        WebPageNewsCard02 .getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        WebPageNewsCard02 .getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        WebPageNewsCard02 .getSettings().setDomStorageEnabled(true);
        WebPageNewsCard02 .getSettings().setDatabaseEnabled(true);
        WebPageNewsCard02 .getSettings().setAppCacheEnabled(true);
        WebPageNewsCard02 .setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        WebPageNewsCard02 .setWebViewClient(new WebViewClient());

        mDatabase3.child("PromotionWebPageURL02").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                WebPageNewsCard02URL = dataSnapshot.getValue(String.class);

                WebPageNewsCard02.loadUrl(WebPageNewsCard02URL);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        WebPage02Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String string = (String) EditTextNews06.getText().toString();
                mDatabase3.child("PromotionWebPageURL02").setValue(string);
            }
        });

        mDatabase3.child("IntroImage03").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String url = dataSnapshot.getValue(String.class);

                Picasso.get()
                        .load(url)
                        .resize(1080,400)
                        .into(IntroImage03);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        IntroImage03Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String string = (String) EditTextNews07.getText().toString();
                mDatabase3.child("IntroImage03").setValue(string);
            }
        });

        mDatabase3.child("IntroImageTitle03").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String string = dataSnapshot.getValue(String.class);

                TitleNewsCard03.setText(string);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        IntroTitle03Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String string = (String) EditTextNews08.getText().toString();
                mDatabase3.child("IntroImageTitle03").setValue(string);
            }
        });

        WebPageNewsCard03 .getSettings().setJavaScriptEnabled(true);
        WebPageNewsCard03 .setFocusable(true);
        WebPageNewsCard03 .setFocusableInTouchMode(true);
        WebPageNewsCard03 .getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        WebPageNewsCard03 .getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        WebPageNewsCard03 .getSettings().setDomStorageEnabled(true);
        WebPageNewsCard03 .getSettings().setDatabaseEnabled(true);
        WebPageNewsCard03 .getSettings().setAppCacheEnabled(true);
        WebPageNewsCard03 .setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        WebPageNewsCard03 .setWebViewClient(new WebViewClient());

        mDatabase3.child("PromotionWebPageURL03").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                WebPageNewsCard03URL = dataSnapshot.getValue(String.class);

                WebPageNewsCard03.loadUrl(WebPageNewsCard03URL);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        WebPage03Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String string = (String) EditTextNews09.getText().toString();
                mDatabase3.child("PromotionWebPageURL03").setValue(string);
            }
        });

    }

    private void NavigationMenu() {

        CardView04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ViewGroup transitionsContainer = (ViewGroup)findViewById(R.id.Rel_Navigation_Menu);
                TransitionManager.beginDelayedTransition(transitionsContainer, new Slide(Gravity.LEFT));
                Rel_Navigation_Menu.setVisibility(View.VISIBLE);
            }
        });

        NavigationBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ViewGroup transitionsContainer = (ViewGroup)findViewById(R.id.Rel_Navigation_Menu);
                TransitionManager.beginDelayedTransition(transitionsContainer, new Slide(Gravity.LEFT));
                Rel_Navigation_Menu.setVisibility(View.GONE);
            }
        });




    }

}
