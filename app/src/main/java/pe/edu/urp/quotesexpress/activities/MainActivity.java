package pe.edu.urp.quotesexpress.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import pe.edu.urp.quotesexpress.QuotesExpressApp;
import pe.edu.urp.quotesexpress.R;
import pe.edu.urp.quotesexpress.adapters.QuotesAdapter;
import pe.edu.urp.quotesexpress.models.QuoteService;

public class MainActivity extends AppCompatActivity {

    RecyclerView quotesRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        quotesRecyclerView = (RecyclerView)findViewById(R.id.quotesRecyclerView);
        quotesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        quotesRecyclerView.setAdapter(new QuotesAdapter(getService().getQuotes()));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),AddQuoteActivity.class));
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    private QuoteService getService(){
        return ((QuotesExpressApp) getApplication()).getService();
    }

    @Override
    protected void onResume(){
        ((QuotesAdapter)quotesRecyclerView.getAdapter()).setQuotes(getService().getQuotes());
        ((QuotesAdapter)quotesRecyclerView.getAdapter()).notifyDataSetChanged();
        super.onResume();
    }
}
