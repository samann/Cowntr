package droidowl.cowcounter;

import android.app.Application;

//import com.firebase.client.Firebase;

import org.androidannotations.annotations.EApplication;

/**
 * Created by droidowl on 3/1/16.
 */
@EApplication
public class CowCounterApplication extends Application {
//    Firebase mFirebase;

    @Override
    public void onCreate() {
        super.onCreate();
//        Firebase.setAndroidContext(this);
//        mFirebase = new Firebase("https://tripmate.firebaseio.com/");
//        mFirebase.keepSynced(true);
    }
}
