package com.example.fundamentals;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

public class Main extends AppCompatActivity {
private WebView miVersionWeb;
private SwipeRefreshLayout swipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView mycontext = (WebView) findViewById(R.id.vistaweb);
        registerForContextMenu(mycontext);

        // DENTRO del Oncreate
        // cast al Layout SwipeRefresh con el que rodeamos la vista
        // en el xml y le colocamos un listener
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);

        //La vista dentro es un webview con permiso para zoom
        miVersionWeb = (WebView) findViewById(R.id.vistaweb);
        //  miVersionWeb.getSettings().setJavaScriptEnabled(true);
        miVersionWeb.getSettings().setBuiltInZoomControls(true);
        miVersionWeb.loadUrl("https://thispersondoesnotexist.com");
    }

    protected SwipeRefreshLayout.OnRefreshListener
            mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {


            Toast toast0 = Toast.makeText(Main.this, "Hi there! I don't exist :)", Toast.LENGTH_LONG);
            toast0.show();
            miVersionWeb.reload();
            swipeLayout.setRefreshing(false);
        }
    };

    public void showAlertDialogButtonClicked(Main mainActivity) {

        // setup the alert builder
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);

//        //el dialogo estandar tiene título/icono pero podemos sustituirlo por un XML a medida
        builder.setTitle("Achtung!");
        builder.setMessage("Where do you go?");
        builder.setIcon(R.drawable.ancla);
        builder.setCancelable(false);

//        // un XML a medida para el diálogo
//        builder.setView(getLayoutInflater().inflate(R.layout.alertdialog_view, null));

        // add the buttons
        builder.setPositiveButton("Signup", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something like...
                Intent intent = new Intent(Main.this, Activity_signup.class);
                startActivity(intent);
                dialog.dismiss();

            }
        });

        builder.setNegativeButton("Do nothing", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // do something like...

                dialog.dismiss();
            }
        });

        builder.setNeutralButton("Other", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // do something like...

                dialog.dismiss();
            }
        });

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    //implementing ActionBar/AppBar menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.item1) {
//            showAlertDialogButtonClicked(Main.this);

            Toast toast = Toast.makeText(this, "Infecting", Toast.LENGTH_LONG);
            toast.show();

        }
        if (id == R.id.item2) {
            Toast toast = Toast.makeText(this, "Fixing", Toast.LENGTH_LONG);
            toast.show();
        }

        if (id == R.id.item3) {
            Intent intent = new Intent(Main.this, Activity_login.class);
            startActivity(intent);
        }

        if (id == R.id.item4) {
            Intent intent = new Intent(this, Activity_login.class);
            startActivity(intent);
        }

        if (id == R.id.item5) {
            showAlertDialogButtonClicked(Main.this);
        }

        return super.onOptionsItemSelected(item);
    }


    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        getMenuInflater().inflate(R.menu.menu_context, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        final ConstraintLayout mLayout = findViewById(R.id.myMainConstraint);
        switch (item.getItemId()) {
            case R.id.item1:
               /* Toast toast = Toast.makeText(this, "Item copied",
                        Toast.LENGTH_LONG);
                toast.show();*/



               Snackbar snackbar = Snackbar
                       .make(mLayout, "fancy a Snack while you refresh?", Snackbar.LENGTH_LONG)
                       .setAction("UNDO", new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               Snackbar snackbar1 = Snackbar.make(mLayout, "Action is restored!", Snackbar.LENGTH_SHORT);
                               snackbar1.show();
                           }
                       });

               snackbar.show();

                return true;

            case R.id.item2:
                Toast toast2 = Toast.makeText(this, "Downloading item...",
                        Toast.LENGTH_LONG);
                toast2.show();

               /* Snackbar bar = Snackbar
                        .make(mLayout, "fancy do you now?", Snackbar.LENGTH_LONG)
                        .setAction("porque no mequieres", new View.OnClickListener() {
                    @Override
                            public void onClick(View view){
                        Snackbar bar2 = Snackbar.make(mLayout, "ahora si queimes mir??", Snackbar.LENGTH_SHORT);
                        bar2.show();
                    }

            });*/
                return true;

            default:
               // return super.onContextItemSelected(item);
                return false;
        }

    }
}