package kz.production.kuanysh.alphadaily.ui.main;

import android.support.design.widget.BottomNavigationView;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import kz.production.kuanysh.alphadaily.data.DataManager;
import kz.production.kuanysh.alphadaily.ui.base.BasePresenter;
import kz.production.kuanysh.alphadaily.utils.rx.SchedulerProvider;

public class MainPresenter <V extends MainMvpView> extends BasePresenter<V>
        implements MainMvpPresenter<V> {

    private static final String TAG = "MainPresenter";

    @Inject
    public MainPresenter(DataManager dataManager,
                             SchedulerProvider schedulerProvider,
                             CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onClickOpenGamesFragment() {
        getMvpView().onOpenGamesFragmentClickListener();
    }

    @Override
    public void onClickOpenTranslateFragment() {
        getMvpView().onOpenTranslateFragmentClickListener();
    }

    @Override
    public void onClickOpenCameraFragment() {
        getMvpView().onOpenCameraFragmentClickListener();
    }

    @Override
    public void onClickOpenAlphabetFragment() {
        getMvpView().onOpenAlphabetFragmentClickListener();
    }

    @Override
    public void onClickOpenMenuFragment() {
        getMvpView().onOpenMenuFragmentClickListener();
    }

    @Override
    public void removeShiftMode(BottomNavigationView view) {
        getMvpView().disableShiftMode(view);
    }
}
