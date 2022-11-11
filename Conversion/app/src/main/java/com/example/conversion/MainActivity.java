package com.example.conversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private Button buttonConversion;
    private EditText monnaie;
    private RadioGroup radioGp;
    private RadioButton radioButton01;
    private RadioButton radioButton02;
    private TextView resultat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.buttonConversion = (Button) this.findViewById(R.id.buttonConversion);

        this.radioButton01 = (RadioButton) this.findViewById(R.id.radioButton01) ;
        this.radioButton02 = (RadioButton) this.findViewById(R.id.radioButton02) ;


        this.resultat = (TextView) this.findViewById(R.id.resultat);

        this.monnaie = (EditText) this.findViewById(R.id.monnaie);


        buttonConversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertir(view);
            }
        });

        radioButton01.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                v.showContextMenu();
                System.out.println("radio clickedd") ;

                return true;

            }
        });
        radioButton01.setOnCreateContextMenuListener(this);


    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu");
        menu.add(0, 1, 0, "Conversion euro -> dinar");
        menu.add(0, 2, 0, "Conversion dinar -> euro");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == 1 ) {
            Toast.makeText(this, "1 euro = 3.24 dt ", Toast.LENGTH_SHORT).
                    show();
        }
        else {
            Toast.makeText(this, "1 tnd = 0.31 euro ", Toast.LENGTH_SHORT).
                    show();
        }
        return true;
    }




    public void convertir( View view)  {


        if (monnaie.getText().toString().equals("")) {
            Snackbar.make(view, "Veuillez saisir une somme", Snackbar.LENGTH_LONG)
                    .setAction("Retry", null).show();
        }
        else if (radioButton01.isChecked() ) {
            Double somme = Double.parseDouble(monnaie.getText().toString()) *  3.24;

            resultat.setText(somme.toString());

        }
        else if (radioButton02.isChecked() ) {
            Double somme = Double.parseDouble(monnaie.getText().toString()) *  0.31;

            resultat.setText(somme.toString());

        }
        else {
            Snackbar.make(view, "Veuillez Selectionnez une operation", Snackbar.LENGTH_LONG)
                    .setAction("Retry", null).show();
        }


    }
}