package kz.production.kuanysh.alphadaily.data;

import kz.production.kuanysh.alphadaily.data.prefs.PreferencesHelper;

/**
 * Created by User on 11.08.2018.
 */

public interface DataManager  extends PreferencesHelper{


    void setUserAsLoggedOut();

    void updateUserInfo(
            String accessToken,
            Long userId,
            LoggedInMode loggedInMode,
            String userName,
            String phone,
            String status);

    enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_SERVER(3);

        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }
    }

}
