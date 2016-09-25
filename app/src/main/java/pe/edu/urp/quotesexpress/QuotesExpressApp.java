package pe.edu.urp.quotesexpress;

import android.app.Application;

import pe.edu.urp.quotesexpress.models.QuotesService;

/**
 * Created by Administrador on 25/09/2016.
 */
public class QuotesExpressApp extends Application {
    private QuotesService service = new QuotesService();


    public QuotesService getService() {
        if (service == null) service = new QuotesService();
        return service;
    }

    public void setService(QuotesService service) {
        this.service = service;
    }
}

