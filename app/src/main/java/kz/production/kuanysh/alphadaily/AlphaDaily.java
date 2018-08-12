package kz.production.kuanysh.alphadaily;

import android.app.Application;

import javax.inject.Inject;

import kz.production.kuanysh.alphadaily.data.DataManager;
import kz.production.kuanysh.alphadaily.di.component.*;
import kz.production.kuanysh.alphadaily.di.module.ApplicationModule;

/**
 * Created by User on 11.08.2018.
 */

public class AlphaDaily extends Application {

    @Inject
    DataManager mDataManager;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);

    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }


    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
