package kz.production.kuanysh.alphadaily.di.component;

import dagger.Component;
import kz.production.kuanysh.alphadaily.di.PerActivity;
import kz.production.kuanysh.alphadaily.di.module.ActivityModule;
import kz.production.kuanysh.alphadaily.ui.main.MainActivity;

/**
 * Created by User on 11.08.2018.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);
}
