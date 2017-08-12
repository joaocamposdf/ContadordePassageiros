/*
  Este app foi criado para ajudar os comissários a contar os passageiros antes do voo.
  This app was created to help flight attends counting the passengers before the flight.
  Desenvolvido por João Pedro Ferreira Campos. Última atualização 17-05-17.
  Developed by João Pedro Ferreira Campos. Last update 17-05-17.
 */

package com.example.android.contadordepassageiros;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    int pax = 0;
    int colo = 0;
    TextView tv;

    /**
     * Método que impede o reinício do app ao mudar a orientação, para não perder a contagem.
     * Method that prevents the app to restart when the orientation is changed, so the counting won't be lost.
     */

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.main);
            displayColos();
            displayContagem();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.main);
            displayColos();
            displayContagem();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        tv = (TextView) findViewById(R.id.pax_text_view);
        tv.setText(String.valueOf(pax));
    }


    /**
     * Soma ou subtrai à contagem de adultos, usando os botões físicos de Volume up e down.
     * Adds ou subs one adult to the counting using the volume up and down buttons.
     */

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            tv.setText(String.valueOf(--pax));
            return true;
        }
        if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            tv.setText(String.valueOf(++pax));
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }


    /**
     * Mostra contagem de adultos.
     * Displays the adults counting.
     */
    public void displayContagem() {
        TextView paxTextView = (TextView) findViewById(R.id.pax_text_view);
        paxTextView.setText(String.valueOf(pax));
    }

    /**
     * Mostra contagem de colos ate 26.
     * Displays the leap children counting till 26.
     */
    public void displayColos() {
        TextView colosTextView = (TextView) findViewById(R.id.colos_text_view);
        colosTextView.setText(String.valueOf(colosArray[colo]));
    }

    /**
     * Mostra contagem de colos acima de 26.
     * Displays the leap children counting from 26.
     */
    public void displayColos2() {
        TextView colosTextView = (TextView) findViewById(R.id.colos_text_view);
        colosTextView.setText(String.valueOf(colo));
    }

    /**
     * Soma 3 passageiros à contagem.
     * Adds 3 adults to the counting.
     */

    public void tres(View view) {
        pax = pax + 3;
        displayContagem();
    }

    /**
     * Soma 2 passageiros à contagem.
     * Adds 2 adults to the counting.
     */

    public void dois(View view) {
        pax = pax + 2;
        displayContagem();
    }

    /**
     * Soma 1 passageiro à contagem.
     * Adds 1 adult to the counting.
     */

    public void um(View view) {
        pax = pax + 1;
        displayContagem();
    }

    /**
     * Subtrai 1 passageiro à contagem.
     * Subtracts 1 adult to the counting.
     */

    public void menosUm(View view) {
        pax = pax - 1;
        displayContagem();
    }

    /**
     * Soma 1 passageiro de colo à contagem de colos.
     * Adds 1 leap child to the counting.
     */

    public void umColo(View view) {
        colo = colo + 1;
        if (colo > 26) {
            displayColos2();
        } else {
            displayColos();
        }
    }

    /**
     * Soma 1 passageiro de colo à contagem de colos.
     * Adds 1 leap child to the counting.
     */

    public void menosUmColo(View view) {
        colo = colo - 1;
        if (colo > 26) {
            displayColos2();
        } else {
            displayColos();
        }
    }


    /**
     * Transforma o número de colos no código utilizado pelos despachantes.
     * Transforms the leap children number into the code used by flght dispatcher staff
     */
    public char[] colosArray = {'0', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
            'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z'};


    /**
     * Reinicia contagem a 0.
     * Restart the counting to 0.
     */


    public void reiniciar(View view) {
        new AlertDialog.Builder(MainActivity.this, R.style.MyDialogTheme)
                .setTitle(R.string.reset_couting)
                .setMessage(R.string.confirm_reset)
                .setIcon(android.R.drawable.ic_menu_revert)
                .setPositiveButton(R.string.sim, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, R.string.reseting, Toast.LENGTH_SHORT).show();
                        pax = 0;
                        displayContagem();
                        colo = 0;
                        displayColos();
                    }
                })
                .setNegativeButton(R.string.nao, null).show();
    }

    /**
     * Verifica se o usuário realmente deseja encerrar o app.
     * Verify if the user indeed wants to close the app.
     */

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(MainActivity.this, R.style.MyDialogTheme)
                .setIcon(android.R.drawable.ic_lock_power_off)
                .setTitle(R.string.finish_counting)
                .setMessage(R.string.confirm_closing)
                .setPositiveButton(R.string.sim, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton(R.string.nao, null)
                .show();
    }


}

