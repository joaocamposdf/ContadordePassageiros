package com.example.android.contadordepassageiros;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class InicialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);

        // Find the View that shows contador textview
        TextView contador = (TextView) findViewById(R.id.contador);

        // Set a click listener on that View
        contador.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the contador textview is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ContadorActivity}
                Intent contadorIntent = new Intent(InicialActivity.this, ContadorActivity.class);

                // Start the new activity
                startActivity(contadorIntent);
            }
        });

        // Find the View that shows detalhes textview
        TextView detalhes = (TextView) findViewById(R.id.detalhes);

        // Set a click listener on that View
        detalhes.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the detalhes textview is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link DetalhesActivity}
                Intent detalhesIntent = new Intent(InicialActivity.this, DetalhesActivity.class);

                // Start the new activity
                startActivity(detalhesIntent);
            }
        });

        // Find the View that shows download_link textview
        TextView downloadLink = (TextView) findViewById(R.id.download_link);

        // Set a click listener on that View
        downloadLink.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when downlaod_link is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link download_link}
                Intent downloadLinkIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.voegol.com.br"));
                ;
                // Start the new activity
                if (downloadLinkIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(downloadLinkIntent);
                }
            }
        });

        // Find the View that shows email_link textview
        TextView emailLink = (TextView) findViewById(R.id.email_link);

        // Set a click listener on that View
        emailLink.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when email_link is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link email_link}
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:econtador@voegol.com.br")); // only email apps should handle this
                if (emailIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(emailIntent);
                }    }
        });


    }
}


