package com.example.poketracker;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private TextView natNum;
    private EditText natNumA;

    private TextView name;
    private EditText nameA;

    private TextView species;
    private EditText speciesA;

    private TextView gender;
    private CheckBox gen1;
    private CheckBox gen2;
    private CheckBox gen3;

    private TextView height;
    private EditText heightA;

    private TextView weight;
    private EditText weightA;

    private TextView level;
    private Spinner levelS;

    LinkedList<Integer> levels = new LinkedList<>();

    private TextView base;

    private TextView hp;
    private EditText hpA;

    private TextView attack;
    private EditText attackA;

    private TextView defense;
    private EditText defenseA;


    private Button reset;
    private Button save;

    View.OnClickListener resetListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            natNumA.getText().clear();
            nameA.getText().clear();
            speciesA.getText().clear();
            heightA.getText().clear();
            weightA.getText().clear();
            hpA.getText().clear();
            attackA.getText().clear();
            defenseA.getText().clear();

            //Log.i("resetTest","button Clicked");
        }
    };

    View.OnClickListener saveListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.constraint);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        for(int i = 1; i <= 50; i++)
        {
            levels.add(i);
        }



       natNum = findViewById(R.id.Nat);
       natNumA = findViewById(R.id.NatNum);

       name = findViewById(R.id.Name);
       nameA = findViewById(R.id.NameA);

       species = findViewById(R.id.Species);
       speciesA = findViewById(R.id.SpeciesA);

       height = findViewById(R.id.Height);
       heightA = findViewById(R.id.HeightA);

       weight = findViewById(R.id.Weight);
       weightA = findViewById(R.id.WeightA);

       level = findViewById(R.id.Level);
       levelS = findViewById(R.id.levelSpinner);



       hp = findViewById(R.id.HP);
       hpA = findViewById(R.id.HPA);

       attack = findViewById(R.id.Attack);
       attackA = findViewById(R.id.AttackA);

       defense = findViewById(R.id.Defense);
       defenseA = findViewById(R.id.DefenseA);

       reset = findViewById(R.id.Reset);
       reset.setOnClickListener(resetListener);

       save = findViewById(R.id.Store);
       save.setOnClickListener(saveListener);








    }
}