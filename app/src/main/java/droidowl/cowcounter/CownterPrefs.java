package droidowl.cowcounter;

import org.androidannotations.annotations.sharedpreferences.DefaultInt;
import org.androidannotations.annotations.sharedpreferences.SharedPref;

/**
 * Created by droidowl on 3/22/16.
 */
@SharedPref
public interface CownterPrefs {

    @DefaultInt(0)
    int flexblue();

    @DefaultInt(0)
    int flexred();

    @DefaultInt(0)
    int larosablue();

    @DefaultInt(0)
    int larosared();
}
