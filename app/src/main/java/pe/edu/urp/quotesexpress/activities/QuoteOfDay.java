package pe.edu.urp.quotesexpress.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.widget.ANImageView;

import org.json.JSONException;
import org.json.JSONObject;

import pe.edu.urp.quotesexpress.R;

public class QuoteOfDay extends AppCompatActivity {

    TextView categoryTextView, phraseTextView, authorTextView;
    ANImageView pictureImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_of_day);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        categoryTextView = (TextView) findViewById(R.id.categoryTextView);
        pictureImageView = (ANImageView) findViewById(R.id.pictureImageView);
        phraseTextView = (TextView) findViewById(R.id.phraseTextView);
        authorTextView = (TextView) findViewById(R.id.authorTextView);
        getQuoteOfDay();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),MainActivity.class));
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void getQuoteOfDay(){
        String url = "http://quotes.rest/qod.json";
        AndroidNetworking.get(url)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Process the response
                        try {
                            JSONObject jsonQuote = response
                                    .getJSONObject("contents")
                                    .getJSONArray("quotes")
                                    .getJSONObject(0);
                            phraseTextView.setText(jsonQuote.getString("quote"));
                            authorTextView.setText(jsonQuote.getString("author"));
                            categoryTextView.setText(jsonQuote.getString("category"));
                            pictureImageView.setDefaultImageResId(R.mipmap.ic_default);
                            pictureImageView.setErrorImageResId(R.mipmap.ic_default);
                            pictureImageView.setImageUrl(jsonQuote.getString("background"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }


}
