package pe.edu.urp.quotesexpress.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import pe.edu.urp.quotesexpress.QuotesExpressApp;
import pe.edu.urp.quotesexpress.R;
import pe.edu.urp.quotesexpress.models.Quote;

public class QuoteActivity extends AppCompatActivity {
    ImageView pictureImageView;
    TextView phraseTextView, authorTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pictureImageView = (ImageView) findViewById(R.id.pictureImageView);
        phraseTextView = (TextView) findViewById(R.id.phraseTextView);
        authorTextView = (TextView) findViewById(R.id.authorTextView);

        Bundle bundle = getIntent().getExtras();
        Quote quote = getQuoteById(bundle.getInt("id"));

        phraseTextView.setText(quote.getPhrase());
        authorTextView.setText(quote.getAuthor());
        pictureImageView.setImageResource(Integer.parseInt(quote.getPictureUri()));
        //phraseTextView.setText(bundle.getString("phrase"));
        //authorTextView.setText(bundle.getString("author"));
        //pictureImageView.setImageResource(Integer.parseInt(bundle.getString("pictureURI")));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private Quote getQuoteById(int id){
        return ((QuotesExpressApp) getApplication())
                .getService()
                .findQuoteById(id);
    }
}
