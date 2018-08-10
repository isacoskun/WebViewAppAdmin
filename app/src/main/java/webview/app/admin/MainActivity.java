package webview.app.admin;

import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toolbar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;
import com.transitionseverywhere.Slide;
import com.transitionseverywhere.TransitionManager;

public class MainActivity extends AppCompatActivity {

    CardView cardView01,cardView02,cardView03,cardView04,cardView05,cardView06,cardView07,cardView08;
    DatabaseReference mDatabase;
    ImageView AppLogo;
    RelativeLayout Rel_Lay_01,Rel_Lay_02;
    AppBarLayout AppBarLay;
    Toolbar AboutToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppLogo = (ImageView)findViewById(R.id.AppLogo);
        cardView01 = (CardView)findViewById(R.id.cardView01);
        cardView02 = (CardView)findViewById(R.id.cardView02);
        cardView03 = (CardView)findViewById(R.id.cardView03);
        cardView04 = (CardView)findViewById(R.id.cardView04);
        cardView05 = (CardView)findViewById(R.id.cardView05);
        cardView06 = (CardView)findViewById(R.id.cardView06);
        cardView07 = (CardView)findViewById(R.id.cardView07);
        cardView08 = (CardView)findViewById(R.id.cardView08);

        ShowAppLogoData();
        SplashScreenMenu();
    }

    private void SplashScreenMenu() {

    cardView01.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


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
