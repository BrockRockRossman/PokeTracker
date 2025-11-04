package com.example.poketracker;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

import java.util.List;

public class dataViewActivity extends AppCompatActivity {

    MyContentProvider contentProvider;
    MyContentProvider.MainDatabaseHelper databaseHelper;

    Button returnB;
    ListView databaseView;

    Uri uri = MyContentProvider.CONTENT_URI;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_data_view);

        returnB = this.findViewById(R.id.Return);
        returnB.setOnClickListener(returnListener);




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        databaseView = findViewById(R.id.dataViewLV);
        Context context = this;

        String[] mProjection = new String[] { MyContentProvider.COL_NAME, MyContentProvider.COL_NATNUM};

        Cursor data = getContentResolver().query(uri, null, null, null, null, null);


        if (data != null) {
            String[] columns = data.getColumnNames();
            for (String col : columns) {
                android.util.Log.i("DB", "Column: " + col);
            }


            String[] mListColumns = new String[] { MyContentProvider.COL_NAME };
            int[] mListItems = new int[] { R.id.contact_name };

            SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                    this,
                    R.layout.query1,
                    data,
                    mProjection,
                    mListItems);

            databaseView.setAdapter(adapter);
        }


    }


    View.OnClickListener returnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(dataViewActivity.this, MainActivity.class);
            startActivity(intent);
        }
    };


}