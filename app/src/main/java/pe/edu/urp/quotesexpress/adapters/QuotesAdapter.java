package pe.edu.urp.quotesexpress.adapters;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.edu.urp.quotesexpress.R;
import pe.edu.urp.quotesexpress.activities.QuoteActivity;
import pe.edu.urp.quotesexpress.models.Quote;

/**
 * Created by Administrador on 18/09/2016.
 */
public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.ViewHolder> {


    private List<Quote> quotes;

    public QuotesAdapter(List<Quote> quotes) {
        this.setQuotes(quotes);
    }

    @Override
    public QuotesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_quote, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(QuotesAdapter.ViewHolder holder,final int position) {
        holder.phrasesTextView.setText(getQuotes().get(position).getPhrase());
        holder.authorTextView.setText(getQuotes().get(position).getAuthor());
        holder.pictureImageView.setImageResource(Integer.parseInt(
                getQuotes().get(position).getPictureUri()));
        holder.quoteCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                //bundle.putString("phrase",quotes.get(position).getPhrase());
                //bundle.putString("author",quotes.get(position).getAuthor());
                //bundle.putString("pictureURI",quotes.get(position).getPictureUri());
                bundle.putInt("id",position);
                Intent itemIntent = new Intent(v.getContext(), QuoteActivity.class);
                itemIntent.putExtras(bundle);
                v.getContext().startActivity(itemIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getQuotes().size();
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView quoteCardView;
        TextView phrasesTextView, authorTextView;
        ImageView pictureImageView;
        public ViewHolder(View itemView) {
            super(itemView);
            quoteCardView = (CardView) itemView.findViewById(R.id.quoteCardView);
            phrasesTextView = (TextView) itemView.findViewById(R.id.phraseTextView);
            authorTextView = (TextView) itemView.findViewById(R.id.authorTextView);
            pictureImageView = (ImageView) itemView.findViewById(R.id.pictureImageView);
        }
    }
}
