package com.example.poketracker;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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

    LinkedList<String> levels = new LinkedList<>();

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

            reset();

            //Log.i("resetTest","button Clicked");
        }
    };

    public void reset()
    {
        // Set to default values
        natNumA.setText("896");
        nameA.setText("Glastrier");
        speciesA.setText("Wild Horse Pokemon");

        gen1.setChecked(false);
        gen2.setChecked(false);
        gen3.setChecked(false);



        heightA.setText("2.2");
        weightA.setText("800.0");

        // figure out how to get a unselected level
        levelS.setSelection(0);
        hpA.setText("0");
        attackA.setText("0");
        defenseA.setText("0");

        // Set to normal color
        natNum.setTextColor(getResources().getColor(R.color.light_grey));
        natNumA.setTextColor(getResources().getColor(R.color.black));

        name.setTextColor(getResources().getColor(R.color.light_grey));
        nameA.setTextColor(getResources().getColor(R.color.black));

        species.setTextColor(getResources().getColor(R.color.light_grey));
        speciesA.setTextColor(getResources().getColor(R.color.black));

        height.setTextColor(getResources().getColor(R.color.light_grey));
        heightA.setTextColor(getResources().getColor(R.color.black));

        weight.setTextColor(getResources().getColor(R.color.light_grey));
        weightA.setTextColor(getResources().getColor(R.color.black));

        hp.setTextColor(getResources().getColor(R.color.light_grey));
        hpA.setTextColor(getResources().getColor(R.color.black));

        attack.setTextColor(getResources().getColor(R.color.light_grey));
        attackA.setTextColor(getResources().getColor(R.color.black));

        defense.setTextColor(getResources().getColor(R.color.light_grey));
        defenseA.setTextColor(getResources().getColor(R.color.black));
    }

    // Calls each of the checks and if one is false, will run toast that notifies error
    // if all pass, runs toast saying that info is stored
    View.OnClickListener saveListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            checkNatNum();
            checkAttack();
            checkDefense();
            checkHeight();
            checkHP();
            checkWeight();
            checkName();
            checkSpecies();
            //checkGender();
            if(!checkAttack() ||
            !checkDefense() || !checkNatNum() || !checkAttack() ||
                    !checkDefense() || !checkHeight() || !checkHP() ||
                    !checkWeight())
            {
                Toast.makeText(MainActivity.this, "There was an error in your submission. Please try again.", Toast.LENGTH_SHORT).show();
            }
            else {
                // run success toast
                Toast.makeText(MainActivity.this, "Pokemon registered!", Toast.LENGTH_SHORT).show();
                reset();
            }

        }
    };

    // OnClickListener for checkBoxes, when one is check the others are not. uncheck one when new is selected
    View.OnClickListener gen1Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            gen2.setChecked(false);
            gen3.setChecked(false);
        }
    };
    View.OnClickListener gen2Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            gen1.setChecked(false);
            gen3.setChecked(false);
        }
    };
    View.OnClickListener gen3Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            gen2.setChecked(false);
            gen1.setChecked(false);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.linear);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        for(int i = 1; i <= 50; i++)
        {
            levels.add("" + i);
        }



       natNum = findViewById(R.id.Nat);
       natNumA = findViewById(R.id.NatNum);

       name = findViewById(R.id.Name);
       nameA = findViewById(R.id.NameA);

       species = findViewById(R.id.Species);
       speciesA = findViewById(R.id.SpeciesA);

       gen1 = findViewById(R.id.Gen1);
       gen1.setOnClickListener(gen1Listener);

       gen2 = findViewById(R.id.Gen2);
       gen2.setOnClickListener(gen2Listener);

       gen3 = findViewById(R.id.Gen3);
       gen3.setOnClickListener(gen3Listener);

       height = findViewById(R.id.Height);
       heightA = findViewById(R.id.HeightA);

       weight = findViewById(R.id.Weight);
       weightA = findViewById(R.id.WeightA);

       level = findViewById(R.id.Level);
       levelS = (Spinner) findViewById(R.id.levelSpinner);


       ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, levels);
       levelS.setAdapter(adapter);


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


    // Series of if statements to check if each field is filled out properly, returns boolean
    public boolean checkNatNum(){
        if(natNumA.getText().toString().isEmpty())
        {
            natNum.setTextColor(getResources().getColor(R.color.red));
            natNumA.setTextColor(getResources().getColor(R.color.red));
            return false;
        }
        if((Integer.parseInt(natNumA.getText().toString()) > 1010 || Integer.parseInt(natNumA.getText().toString()) < 0)){
            // Sets text to red if error
            natNum.setTextColor(getResources().getColor(R.color.red));
            natNumA.setTextColor(getResources().getColor(R.color.red));

            return false;
        }
        return true;
    }
    public boolean checkName(){
        if(nameA.getText().toString().isEmpty())
        {
            name.setTextColor(getResources().getColor(R.color.red));
            nameA.setTextColor(getResources().getColor(R.color.red));
            return false;
        }
        if((nameA.length() > 12 || nameA.length() < 3)){
            // Sets text to red if error
            name.setTextColor(getResources().getColor(R.color.red));
            nameA.setTextColor(getResources().getColor(R.color.red));

            return false;
        }
        return true;
    }
    public boolean checkSpecies(){
        if(speciesA.getText().toString().isEmpty())
        {
            species.setTextColor(getResources().getColor(R.color.red));
            speciesA.setTextColor(getResources().getColor(R.color.red));
            return false;
        }

        return true;
    }
    public boolean checkGender(){
        if(gen1.isChecked())
        {
            gender.setTextColor(getResources().getColor(R.color.red));
            return false;
        }


        return true;
    }
    public boolean checkHeight(){
        if(heightA.getText().toString().isEmpty())
        {
            height.setTextColor(getResources().getColor(R.color.red));
            heightA.setTextColor(getResources().getColor(R.color.red));
            return false;
        }
        if((Double.parseDouble(heightA.getText().toString()) > 169.99 || Double.parseDouble(heightA.getText().toString()) < 0.2)){
            // Sets text to red if error
            height.setTextColor(getResources().getColor(R.color.red));
            heightA.setTextColor(getResources().getColor(R.color.red));

            return false;
        }
        return true;
    }
    public boolean checkWeight(){
        if(weightA.getText().toString().isEmpty())
        {
            weight.setTextColor(getResources().getColor(R.color.red));
            weightA.setTextColor(getResources().getColor(R.color.red));
            return false;
        }
        if((Double.parseDouble(weightA.getText().toString()) > 992.7 || Double.parseDouble(weightA.getText().toString()) < 0.1)){
            // Sets text to red if error
            weight.setTextColor(getResources().getColor(R.color.red));
            weightA.setTextColor(getResources().getColor(R.color.red));

            return false;
        }
        return true;
    }
    public boolean checkHP(){
        if(hpA.getText().toString().isEmpty())
        {
            hp.setTextColor(getResources().getColor(R.color.red));
            hpA.setTextColor(getResources().getColor(R.color.red));
            return false;
        }
        if((Integer.parseInt(hpA.getText().toString()) > 362 || Integer.parseInt(hpA.getText().toString()) < 1)){
            // Sets text to red if error
            hp.setTextColor(getResources().getColor(R.color.red));
            hpA.setTextColor(getResources().getColor(R.color.red));

            return false;
        }
        return true;
    }
    public boolean checkAttack(){
        if(attackA.getText().toString().isEmpty())
        {
            attack.setTextColor(getResources().getColor(R.color.red));
            attackA.setTextColor(getResources().getColor(R.color.red));
            return false;
        }
        if((Integer.parseInt(attackA.getText().toString()) > 526 || Integer.parseInt(attackA.getText().toString()) < 0)){
            // Sets text to red if error
            attack.setTextColor(getResources().getColor(R.color.red));
            attackA.setTextColor(getResources().getColor(R.color.red));

            return false;
        }

        return true;
    }
    public boolean checkDefense(){
        if(defenseA.getText().toString().isEmpty())
        {
            defense.setTextColor(getResources().getColor(R.color.red));
            defenseA.setTextColor(getResources().getColor(R.color.red));
            return false;
        }
        if((Integer.parseInt(defenseA.getText().toString()) > 614 || Integer.parseInt(defenseA.getText().toString()) < 10)){
            // Sets text to red if error
            defense.setTextColor(getResources().getColor(R.color.red));
            defenseA.setTextColor(getResources().getColor(R.color.red));

            return false;
        }

        return true;
    }
}