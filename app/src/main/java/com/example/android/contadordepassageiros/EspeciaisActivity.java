package com.example.android.contadordepassageiros;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class EspeciaisActivity extends AppCompatActivity {

    public static int maximas;
    public static int deficientes;
    public static int menores;
    public static int gestantes;
    public static int carrinhos;
    public static int cadeirasGol;
    public static int cadeirasProprias;
    public static boolean escadas;

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_especiais);
            displayMaximas();
            displayDeficientes();
            displayMenores();
            displayGestantes();
            displayCarrinhos();
            displayCadeirasGol();
            displayCadeirasProprias();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_especiais);
            displayMaximas();
            displayDeficientes();
            displayMenores();
            displayGestantes();
            displayCarrinhos();
            displayCadeirasGol();
            displayCadeirasProprias();
        }
    }


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especiais);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        displayMaximas();
        displayDeficientes();
        displayMenores();
        displayGestantes();
        displayCarrinhos();
        displayCadeirasGol();
        displayCadeirasProprias();
    }

    public void displayMaximas() {
        TextView maximasTextView = (TextView) findViewById(R.id.contagem_maximas);
        maximasTextView.setText(String.valueOf(maximas));
    }

    public void displayDeficientes() {
        TextView deficientesTextView = (TextView) findViewById(R.id.contagem_deficientes);
        deficientesTextView.setText(String.valueOf(deficientes));
    }

    public void displayMenores() {
        TextView menoresTextView = (TextView) findViewById(R.id.contagem_menores);
        menoresTextView.setText(String.valueOf(menores));
    }

    public void displayGestantes() {
        TextView gestantesTextView = (TextView) findViewById(R.id.contagem_gestantes);
        gestantesTextView.setText(String.valueOf(gestantes));
    }

    public void displayCarrinhos() {
        TextView carrinhosTextView = (TextView) findViewById(R.id.contagem_carrinhos);
        carrinhosTextView.setText(String.valueOf(carrinhos));
    }

    public void displayCadeirasGol() {
        TextView cadeirasGolTextView = (TextView) findViewById(R.id.contagem_gol);
        cadeirasGolTextView.setText(String.valueOf(cadeirasGol));

    }

    public void displayCadeirasProprias() {
        TextView cadeirasPropriasTextView = (TextView) findViewById(R.id.contagem_proprias);
        cadeirasPropriasTextView.setText(String.valueOf(cadeirasProprias));

    }

    public void menosMaximas(View view) {
        maximas -= 1;
        displayMaximas();
    }

    public void maisMaximas(View view) {
        maximas += 1;
        displayMaximas();
    }
    public void menosDeficientes(View view) {
        deficientes -= 1;
        displayDeficientes();
    }

    public void maisDeficientes(View view) {
        deficientes += 1;
        displayDeficientes();
    }

    public void menosMenores(View view) {
        menores -= 1;
        displayMenores();
    }

    public void maisMenores(View view) {
        menores += 1;
        displayMenores();
    }

    public void menosGestantes(View view) {
        gestantes -= 1;
        displayGestantes();
    }

    public void maisGestantes(View view) {
        gestantes += 1;
        displayGestantes();
    }

    public void menosCarrinhos(View view) {
        carrinhos -= 1;
        displayCarrinhos();
    }

    public void maisCarrinhos(View view) {
        carrinhos += 1;
        displayCarrinhos();
    }

    public void menosGol(View view) {
        cadeirasGol -= 1;
        displayCadeirasGol();
    }

    public void maisGol(View view) {
        cadeirasGol += 1;
        displayCadeirasGol();
    }

    public void menosProprias(View view) {
        cadeirasProprias -= 1;
        displayCadeirasProprias();
    }

    public void maisProprias(View view) {
        cadeirasProprias += 1;
        displayCadeirasProprias();
    }

    public void descemEscadas(View view) {
        // Is the button now checked?
        escadas = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.sim_descem:
                if (escadas)
                    //
                    break;
            case R.id.nao_descem:
                if (escadas)
                    //
                    break;
        }
    }
}


