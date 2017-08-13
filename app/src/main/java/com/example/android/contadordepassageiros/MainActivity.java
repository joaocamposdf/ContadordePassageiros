/*
  Este app foi criado para ajudar os comissários a contar os passageiros antes do voo.
  This app was created to help flight attends counting the passengers before the flight.
  Desenvolvido por João Pedro Ferreira Campos. Última atualização 17-05-17.
  Developed by João Pedro Ferreira Campos. Last update 17-05-17.
 */

package com.example.android.contadordepassageiros;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

//The instructions in the MainActivity handle the interactions between FragmentAdapter, viewPager and TabLayout
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), this);

        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

    }
}
