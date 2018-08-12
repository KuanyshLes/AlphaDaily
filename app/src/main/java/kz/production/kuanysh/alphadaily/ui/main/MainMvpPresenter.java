package kz.production.kuanysh.alphadaily.ui.main;

import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;

import kz.production.kuanysh.alphadaily.di.PerActivity;
import kz.production.kuanysh.alphadaily.ui.base.MvpPresenter;

@PerActivity
public interface MainMvpPresenter <V extends MainMvpView> extends MvpPresenter<V> {

    void onClickOpenGamesFragment();

    void onClickOpenTranslateFragment();

    void onClickOpenCameraFragment();

    void onClickOpenAlphabetFragment();

    void onClickOpenMenuFragment();

    void removeShiftMode(BottomNavigationView view);
}
