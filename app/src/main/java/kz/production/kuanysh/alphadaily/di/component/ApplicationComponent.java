package kz.production.kuanysh.alphadaily.di.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import kz.production.kuanysh.alphadaily.AlphaDaily;
import kz.production.kuanysh.alphadaily.data.DataManager;
import kz.production.kuanysh.alphadaily.di.ApplicationContext;
import kz.production.kuanysh.alphadaily.di.module.ApplicationModule;

/**
 * Created by User on 11.08.2018.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {


    void inject(AlphaDaily alphaDaily);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}
