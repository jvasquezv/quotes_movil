package pe.edu.urp.quotesexpress.models;

import java.util.ArrayList;
import java.util.List;

import pe.edu.urp.quotesexpress.R;

/**
 * Created by Administrador on 18/09/2016.
 */
public class QuoteService {

    private List<Quote> quotes;

    public List<Quote> getQuotes() {
        if(quotes ==null){
            quotes=new ArrayList<>();
            initializeData();
        }
        return quotes;
    }

    private void initializeData() {
        quotes.add(new Quote("orem ipsum dolor sit amet, consectetur adipiscing elit. Nullam non eros vel nisl egestas dictum. .","Bill Gates",Integer.toString(R.mipmap.ic_default)));
        quotes.add(new Quote("Duis efficitur dictum felis, vitae consectetur est sagittis egestas. ","Michael Jordan",Integer.toString(R.mipmap.ic_default)));
        quotes.add(new Quote("egestas sodales quis in risus. Sed nec pulvinar massa, vitae aliquet est.  .","Tesla",Integer.toString(R.mipmap.ic_default)));
        quotes.add(new Quote("faucibus. Nullam aliquet commodo faucibus. Proin ut auctor justo, ut pharetra dui.","Wozniack",Integer.toString(R.mipmap.ic_default)));
        quotes.add(new Quote("Sed lectus nisl, aliquet ut tortor et, aliquet mattis dolor. ","Anonimus",Integer.toString(R.mipmap.ic_default)));
    }

    public Quote findQuoteByPhrase(String phrase){

        for (Quote quote : getQuotes()){
            if(quote.getPhrase().equalsIgnoreCase(phrase)) return quote;
        }
        return null;
    }

    public Quote findQuoteById(int id){
        return quotes.get(id);
    }

    public boolean addQuote(String phrase, String author, String pictureUri){
        if((phrase.isEmpty() || (findQuoteByPhrase(phrase)!=null))) return false;
        getQuotes().add(new Quote(phrase, author, pictureUri));
        return true;
    }


}
