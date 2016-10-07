package pe.edu.urp.quotesexpress.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import pe.edu.urp.quotesexpress.QuotesExpressApp;
import pe.edu.urp.quotesexpress.R;
import pe.edu.urp.quotesexpress.models.QuoteService;

public class AddQuoteActivity extends AppCompatActivity {
    TextInputEditText phraseTextInputEditText, authorTextInputEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_quote);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        phraseTextInputEditText =(TextInputEditText) findViewById(R.id.phraseTextInputEditText);
        authorTextInputEditText=(TextInputEditText) findViewById(R.id.authorTextInputEditText);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = getActionMessage();
                Snackbar.make(view, message, Snackbar.LENGTH_LONG)
                        .setAction("Clear",getOnClickListenerForClearAction() ).show();
                if(message=="Success") finish();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private String getActionMessage(){
        return ((getService().addQuote(
                phraseTextInputEditText.getText().toString(),
                authorTextInputEditText.getText().toString(),
                Integer.toString(R.mipmap.ic_default)))?"Success":"The phrase already exists");
    }

    private View.OnClickListener getOnClickListenerForClearAction(){
        return new View.OnClickListener(){
            @Override
            public void onClick(View view){
                authorTextInputEditText.setText("");
                phraseTextInputEditText.setText("");
                phraseTextInputEditText.requestFocus();
            }
        };
    }

    private QuoteService getService(){
        return ((QuotesExpressApp) getApplication()).getService();
    }

}
