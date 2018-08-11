package kz.production.kuanysh.alphadaily.data.prefs;

import kz.production.kuanysh.alphadaily.data.DataManager;

/**
 * Created by User on 11.08.2018.
 */

public interface PreferencesHelper {

    int getCurrentUserLoggedInMode();

    void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode);

    Long getCurrentUserId();

    void setCurrentUserId(Long userId);

    String getCurrentUserName();

    void setCurrentUserName(String userName);

    String getCurrentUserEmail();

    void setCurrentUserEmail(String email);


    String getAccessToken();

    void setAccessToken(String accessToken);
}
