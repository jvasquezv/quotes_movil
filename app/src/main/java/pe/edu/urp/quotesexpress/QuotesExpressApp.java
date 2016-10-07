package pe.edu.urp.quotesexpress;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

import pe.edu.urp.quotesexpress.models.QuoteService;

/**
 * Created by Administrador on 25/09/2016.
 */
public class QuotesExpressApp extends Application {
    private QuoteService service=new QuoteService();

    public QuoteService getService() {
        if (service==null) service=new QuoteService()
;        return service;
    }

    public void setService(QuoteService service) {
        this.service = service;
    }

    public void onCreate(){
        AndroidNetworking.initialize(getApplicationContext());
        super.onCreate();
    }
}
