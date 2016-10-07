package pe.edu.urp.quotesexpress.models;

/**
 * Created by Administrador on 18/09/2016.
 */
public class Quote {
    private String phrase;
    private String author;
    private String pictureUri;

    public Quote(String phrase, String author, String pictureUri) {
        this.setPhrase(phrase);
        this.setAuthor(author);
        this.setPictureUri(pictureUri);
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPictureUri() {
        return pictureUri;
    }

    public void setPictureUri(String pictureUri) {
        this.pictureUri = pictureUri;
    }
}
