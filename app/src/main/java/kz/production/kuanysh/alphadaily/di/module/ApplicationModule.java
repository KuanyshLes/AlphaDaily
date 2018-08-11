package kz.production.kuanysh.alphadaily.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import kz.production.kuanysh.alphadaily.data.AppDataManager;
import kz.production.kuanysh.alphadaily.data.DataManager;
import kz.production.kuanysh.alphadaily.data.prefs.AppPreferencesHelper;
import kz.production.kuanysh.alphadaily.data.prefs.PreferencesHelper;
import kz.production.kuanysh.alphadaily.di.ApplicationContext;
import kz.production.kuanysh.alphadaily.di.PreferenceInfo;
import kz.production.kuanysh.alphadaily.utils.AppConst;

/**
 * Created by User on 11.08.2018.
 */
@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConst.PREFERENCE_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }


}
