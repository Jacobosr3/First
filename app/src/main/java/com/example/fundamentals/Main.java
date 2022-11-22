package com.example.fundamentals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Main extends AppCompatActivity {
private WebView miVersionWeb;
private SwipeRefreshLayout swipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

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