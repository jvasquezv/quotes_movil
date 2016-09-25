package pe.edu.urp.quotesexpress.models;

import java.util.ArrayList;
import java.util.List;

import pe.edu.urp.quotesexpress.R;

/**
 * Created by Administrador on 18/09/2016.
 */
public class QuotesService {
    private List<Quote> quotes;

    public List<Quote> getQuotes() {
        if(quotes == null){
            quotes = new ArrayList<>();
            initializeData();
        }
        return quotes;
    }

    private void initializeData(){
        quotes.add(new Quote(
                "Aliquam tincidunt tortor quis sagittis lobortis. Nullam purus lorem, ullamcorper eu cursus sed, laoreet eget libero.",
                "O Villalobos",
                Integer.toString(R.mipmap.ic_default)));

        quotes.add(new Quote(
                "Vivamus finibus sodales libero, eget pretium ligula lacinia quis. ",
                "Fiorella O",
                Integer.toString(R.mipmap.ic_default)));

        quotes.add(new Quote(
                "Quisque mollis bibendum sapien, sit amet maximus lectus aliquam non. ",
                "Silvia F",
                Integer.toString(R.mipmap.ic_default)));

        quotes.add(new Quote(
                "Cras convallis convallis arcu eu consequat. Maecenas dignissim pellentesque lorem vel mollis.",
                "Olaya Cristy",
                Integer.toString(R.mipmap.ic_default)));

        quotes.add(new Quote(
                "Sed ullamcorper tincidunt aliquet. Morbi id porttitor turpis. Maecenas nec fermentum nisi, sed hendrerit neque.",
                "Diana C",
                Integer.toString(R.mipmap.ic_default)));

        quotes.add(new Quote(
                "Curabitur semper luctus eleifend. Maecenas in ipsum varius, consectetur libero sed, venenatis lorem. Curabitur faucibus vehicula ultrices. ",
                "K Ramos",
                Integer.toString(R.mipmap.ic_default)));

    }
}
