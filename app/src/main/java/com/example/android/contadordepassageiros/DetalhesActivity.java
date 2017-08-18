package com.example.android.contadordepassageiros;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import static com.example.android.contadordepassageiros.ContadorActivity.getColo;
import static com.example.android.contadordepassageiros.ContadorActivity.getPax;

public class DetalhesActivity extends AppCompatActivity {
    int adultos = getPax();
    int colos = getColo();
    public static int cmte;
    public static int cop;
    public static int cms;
    public static int trip;
    public static int total;

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_detalhes);
            displayAdultos();
            displayColos();
            displayCmte();
            displayCop();
            displayCms();
            displayTripulantes();
            displayTotal();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_detalhes);
            displayAdultos();
            displayColos();
            displayCmte();
            displayCop();
            displayCms();
            displayTripulantes();
            displayTotal();
        }
    }


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        displayAdultos();
        displayColos();
        displayCmte();
        displayCop();
        displayCms();
        displayTripulantes();
        displayTotal();

    }

    public void displayAdultos() {
        TextView adultosTextView = (TextView) findViewById(R.id.contagem_adultos);
        adultosTextView.setText(String.valueOf(adultos));
    }

    public void displayColos() {
        TextView colosTextView = (TextView) findViewById(R.id.contagem_colos);
        colosTextView.setText(String.valueOf(colos));
    }

    public void displayCmte() {
        TextView cmteTextView = (TextView) findViewById(R.id.contagem_cmte);
        cmteTextView.setText(String.valueOf(cmte));
    }

    public void displayCop() {
        TextView copTextView = (TextView) findViewById(R.id.contagem_cop);
        copTextView.setText(String.valueOf(cop));
    }

    public void displayCms() {
        TextView cmsTextView = (TextView) findViewById(R.id.contagem_cms);
        cmsTextView.setText(String.valueOf(cms));
    }

    public void displayTripulantes() {
        TextView tripulantesTextView = (TextView) findViewById(R.id.contagem_trip);
        tripulantesTextView.setText(String.valueOf(trip));

    }

    public void menosCmte(View view) {
        cmte = cmte - 1;
        displayCmte();
    }

    public void maisCmte(View view) {
        cmte = cmte + 1;
        displayCmte();
    }

    public void menosCop(View view) {
        cop = cop - 1;
        displayCop();
    }

    public void maisCop(View view) {
        cop = cop + 1;
        displayCop();
    }

    public void menosCms(View view) {
        cms = cms - 1;
        displayCms();
    }

    public void maisCms(View view) {
        cms = cms + 1;
        displayCms();
    }

    public void menosTrip(View view) {
        trip = trip - 1;
        displayTripulantes();
        displayTotal();
    }

    public void maisTrip(View view) {
        trip = trip + 1;
        displayTripulantes();
        displayTotal();
    }

    public void displayTotal() {
        TextView totalTextView = (TextView) findViewById(R.id.contagem_total);
        total = adultos + colos + trip;
        totalTextView.setText(String.valueOf(total));
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}

