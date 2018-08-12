package kz.production.kuanysh.alphadaily.ui.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import java.lang.reflect.Field;

import javax.inject.Inject;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import kz.production.kuanysh.alphadaily.R;
import kz.production.kuanysh.alphadaily.ui.base.BaseActivity;
import kz.production.kuanysh.alphadaily.ui.base.BaseFragment;

public class MainActivity extends BaseActivity implements MainMvpView {

    @Inject
    MainPresenter<MainMvpView> mPresenter;

    private static final String TAG = "MainActivity";

    @BindView(R.id.content_nav_bottom)
    BottomNavigationView mBottomNavigationView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(MainActivity.this);

        mPresenter.onClickOpenMenuFragment();
        mPresenter.removeShiftMode(mBottomNavigationView);



        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.bottom_nav_games:
                        mPresenter.onClickOpenGamesFragment();

                        break;
                    case R.id.bottom_nav_translate:
                        // go to translate fragment
                        mPresenter.onClickOpenTranslateFragment();
                        break;
                    case R.id.bottom_nav_camera:
                        // go to camera fragment
                        mPresenter.onClickOpenCameraFragment();
                        break;
                    case R.id.bottom_nav_alphabet:
                        // go to alphabet fragment
                        mPresenter.onClickOpenAlphabetFragment();
                        break;
                    case R.id.bottom_nav_menu:
                        // go to menu fragment
                        mPresenter.onClickOpenMenuFragment();
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void setUp() {}


    @Override
    public void onOpenGamesFragmentClickListener() {
        Log.d(TAG, "onOpenGamesFragmentClickListener: clicked");
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                //.replace(R.id.containerDrawerFragments, CheckListFragment.newInstance(), DocumentsFragment.TAG)
                .commit();
    }

    @Override
    public void onOpenTranslateFragmentClickListener() {
        Log.d(TAG, "onOpenTranslateFragmentClickListener: clicked");
    }

    @Override
    public void onOpenCameraFragmentClickListener() {
        Log.d(TAG, "onOpenCameraFragmentClickListener: clicked");
    }

    @Override
    public void onOpenAlphabetFragmentClickListener() {
        Log.d(TAG, "onOpenAlphabetFragmentClickListener: clicked");
    }

    @Override
    public void onOpenMenuFragmentClickListener() {
        Log.d(TAG, "onOpenMenuFragmentClickListener: clicked");
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }


    @Override
    @SuppressLint("RestrictedApi")
    public void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                //noinspection RestrictedApi
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                //noinspection RestrictedApi
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.e("BNVHelper", "Unable to get shift mode field", e);
        } catch (IllegalAccessException e) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e);
        }
    }
}
