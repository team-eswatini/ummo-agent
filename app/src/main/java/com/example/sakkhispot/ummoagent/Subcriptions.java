package com.example.sakkhispot.ummoagent;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Subcriptions extends AppCompatActivity {

    EditText sms;
    final Context context = this;
    private RecyclerView brandRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcriptions);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        brandRecyclerView = (RecyclerView) findViewById(R.id.brands_lst);
        LinearLayoutManager recyclerLayoutManager = new LinearLayoutManager(this);
        brandRecyclerView.setLayoutManager(recyclerLayoutManager);


        SubscribersAdapter recyclerViewAdapter = new
                SubscribersAdapter(getSubscribers());
        brandRecyclerView.setAdapter(recyclerViewAdapter);

        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(brandRecyclerView.getContext(),
                        recyclerLayoutManager.getOrientation());
        brandRecyclerView.addItemDecoration(dividerItemDecoration);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSMSDialog();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_subcriptions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private List<Subscribers> getSubscribers(){
        List<Subscribers> modelList = new ArrayList<Subscribers>();
        modelList.add(new Subscribers("Adidas", true));
        modelList.add(new Subscribers("Boss", true));
        modelList.add(new Subscribers("Lee", true));
        modelList.add(new Subscribers("Levis", true));
        modelList.add(new Subscribers("Tommy Hil", true));
        modelList.add(new Subscribers("Jack Jones", true));
        modelList.add(new Subscribers("Pepe Jeans", true));
        modelList.add(new Subscribers("Adidas", true));
        modelList.add(new Subscribers("Adidas", true));
        modelList.add(new Subscribers("Adidas", true));
        modelList.add(new Subscribers("Adidas", true));
        modelList.add(new Subscribers("Adidas", true));

        return modelList;
    }

    public void smsSubscriber(){



    }
    public void showSMSDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Subcriptions.this);

        View viewInflated = LayoutInflater.from(Subcriptions.this).inflate(R.layout.sms_dialog, null);
// Set up the input
        sms = (EditText) viewInflated.findViewById(R.id.sms_edt);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        builder.setView(viewInflated);
        builder.setTitle("Add a SMS");

        // set dialog message
        builder.setPositiveButton("Send", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }

        });

        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        final AlertDialog alert = builder.create();
        alert.show();

        alert.setOnShowListener( new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface arg0) {
                alert.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.BLUE);
                alert.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLUE);
            }
        });
    }
}

