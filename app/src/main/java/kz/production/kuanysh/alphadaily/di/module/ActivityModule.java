package kz.production.kuanysh.alphadaily.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import kz.production.kuanysh.alphadaily.di.ActivityContext;
import kz.production.kuanysh.alphadaily.ui.main.MainMvpPresenter;
import kz.production.kuanysh.alphadaily.ui.main.MainMvpView;
import kz.production.kuanysh.alphadaily.ui.main.MainPresenter;
import kz.production.kuanysh.alphadaily.utils.rx.AppSchedulerProvider;
import kz.production.kuanysh.alphadaily.utils.rx.SchedulerProvider;

/**
 * Created by User on 11.08.2018.
 */

@Module
public class ActivityModule {
    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }

    @Provides
    MainMvpPresenter<MainMvpView> provideMainPresenter(MainPresenter<MainMvpView> presenter){
        return presenter;
    }

}
