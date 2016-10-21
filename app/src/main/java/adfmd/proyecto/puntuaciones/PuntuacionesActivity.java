package adfmd.proyecto.puntuaciones;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import adfmd.proyecto.R;

public class PuntuacionesActivity extends AppCompatActivity {
    public static final String EXTRA_AMIGO_ID = "extra_amigo_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuaciones);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        PuntuacionesFragment fragment = (PuntuacionesFragment)getSupportFragmentManager().findFragmentById(R.id.content_puntuaciones);

        if(fragment == null){
            fragment = PuntuacionesFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.content_puntuaciones, fragment).commit();
        }
    }

}
