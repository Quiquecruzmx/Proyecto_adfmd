package adfmd.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import adfmd.proyecto.puntuaciones.PuntuacionesActivity;

public class MainActivity extends AppCompatActivity {

    private Button btn1, btn2, btn3, btn4;//Las 4 funcionalidades principales

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button)findViewById(R.id.button1);//Recuperando el botón "Ver puntuaciones"
        btn2 = (Button)findViewById(R.id.button2);//Calendario
        btn3 = (Button)findViewById(R.id.button3);//Bloquear

        /* Estableciendo un listener para el botón 1*/
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, PuntuacionesActivity.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, CalendarioActivity.class);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, BloquearActivity.class);
                startActivity(intent);
            }
        });
    }
}
