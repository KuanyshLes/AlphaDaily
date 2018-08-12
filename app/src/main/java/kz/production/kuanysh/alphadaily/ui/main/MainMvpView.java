package kz.production.kuanysh.alphadaily.ui.main;

import android.support.design.widget.BottomNavigationView;

import kz.production.kuanysh.alphadaily.ui.base.MvpView;

public interface MainMvpView extends MvpView {

    void onOpenGamesFragmentClickListener();

    void onOpenTranslateFragmentClickListener();

    void onOpenCameraFragmentClickListener();

    void onOpenAlphabetFragmentClickListener();

    void onOpenMenuFragmentClickListener();

    void disableShiftMode(BottomNavigationView view);


}
