package droidowl.cowcounter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

//import com.firebase.client.DataSnapshot;
//import com.firebase.client.Firebase;
//import com.firebase.client.FirebaseError;
//import com.firebase.client.ValueEventListener;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.LongClick;
import org.androidannotations.annotations.PreferenceScreen;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.sharedpreferences.Pref;
import org.androidannotations.annotations.sharedpreferences.SharedPref;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CowCounterFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CowCounterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
@EFragment(R.layout.fragment_cow_count)
public class CowCounterFragment extends Fragment {

    @App
    CowCounterApplication mApplication;

    @Pref
    CownterPrefs_ prefs;

//    Firebase firebase;

//    Firebase teamFirebase;

    String team;

    TeamCount flex;

    TeamCount larosa;

    boolean toggle = false;

    @ViewById(R.id.blue_score)
    TextView blue;

    @ViewById(R.id.red_score)
    TextView red;

    @ViewById(R.id.team_text_view)
    TextView teamTextView;

    private String teamFlex = "Flex";
    private String teamLaRosa = "LaRosa";

    private OnFragmentInteractionListener mListener;

    public CowCounterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment CowCounterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CowCounterFragment newInstance() {
        CowCounterFragment fragment = new CowCounterFragment_();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        team = teamFlex;
        flex = new TeamCount();
        larosa = new TeamCount();
//        firebase = new Firebase("https://tripmate.firebaseio.com/");
//        teamFirebase = firebase.child(team);

        flex.setBlue(prefs.flexblue().get());
        flex.setRed(prefs.flexred().get());
        larosa.setBlue(prefs.larosablue().get());
        larosa.setRed(prefs.larosared().get());

        setHasOptionsMenu(true);
//        firebase.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                if (dataSnapshot.getChildren().iterator().hasNext()) {
//                    for (DataSnapshot next : dataSnapshot
//                            .getChildren()) {
//                        if (next.getKey().equalsIgnoreCase(teamFlex) &&
//                                !toggle) {
//                            flex = next.getValue(TeamCount.class);
//                            prefs.flexblue().put(flex.getBlue());
//                            prefs.flexred().put(flex.getRed());
//                            blue.setText(Integer.toString(prefs.flexblue()
//                                    .get()));
//                            red.setText(Integer.toString(prefs.flexred().get()));
//                        }
//                        if (next.getKey().equalsIgnoreCase
//                                (teamLaRosa) && toggle) {
//                            larosa = next.getValue(TeamCount.class);
//                            prefs.larosablue().put(larosa.getBlue());
//                            prefs.larosared().put(larosa.getRed());
//                            blue.setText(Integer.toString(prefs.larosablue()
//                                    .get()));
//                            red.setText(Integer.toString(prefs.larosared().get()));
//                        }
//                    }
//                }
//            }

//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//
//            }
//        });
    }


    @AfterViews
    void setup() {
        teamTextView.setText(team);
        updateTextFields(flex);
    }

    private void updateTextFields(TeamCount teamCount) {
        blue.setText(Integer.toString(teamCount.getBlue()));
        red.setText(Integer.toString(teamCount.getRed()));
    }

    private void updatePrefs() {
        prefs.flexblue().put(flex.getBlue());
        prefs.flexred().put(flex.getRed());
        prefs.larosablue().put(larosa.getBlue());
        prefs.larosared().put(larosa.getRed());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_switch) {
            switchCars();
        }

        return super.onOptionsItemSelected(item);
    }

    @Click(R.id.blue_one)
    void blueOneTapped() {
        if (!toggle) {
            flex.incBlue(1);
            updateTextFields(flex);
//            teamFirebase.setValue(flex);
        } else {
            larosa.incBlue(1);
            updateTextFields(larosa);
//            teamFirebase.setValue(larosa);
        }
        updatePrefs();
    }

    @LongClick(R.id.blue_one)
    void blueOneLong() {
        if (!toggle) {
            flex.incBlue(-1);
            updateTextFields(flex);
//            teamFirebase.setValue(flex);
        } else {
            larosa.incBlue(-1);
            updateTextFields(larosa);
//            teamFirebase.setValue(larosa);
        }
        updatePrefs();
    }

    @Click(R.id.red_one)
    void redOneTapped() {
        if (!toggle) {
            flex.incRed(1);
            updateTextFields(flex);
//            teamFirebase.setValue(flex);
        } else {
            larosa.incRed(1);
            updateTextFields(larosa);
//            teamFirebase.setValue(larosa);
        }
        updatePrefs();
    }

    @LongClick(R.id.red_one)
    void redOneLong() {
        if (!toggle) {
            flex.incRed(-1);
            updateTextFields(flex);
//            teamFirebase.setValue(flex);
        } else {
            larosa.incRed(-1);
            updateTextFields(larosa);
//            teamFirebase.setValue(larosa);
        }
        updatePrefs();
    }

    @Click(R.id.red_five)
    void redFiveTapped() {
        if (!toggle) {
            flex.incRed(5);
            updateTextFields(flex);
//            teamFirebase.setValue(flex);
        } else {
            larosa.incRed(5);
            updateTextFields(larosa);
//            teamFirebase.setValue(larosa);
        }
        updatePrefs();
    }

    @Click(R.id.blue_five)
    void blueFiveTapped() {
        if (!toggle) {
            flex.incBlue(5);
            updateTextFields(flex);
//            teamFirebase.setValue(flex);
        } else {
            larosa.incBlue(5);
            updateTextFields(larosa);
//            teamFirebase.setValue(larosa);
        }
        updatePrefs();
    }

    @LongClick(R.id.red_five)
    void redFiveLongTapped() {
        if (!toggle) {
            flex.incRed(-5);
            updateTextFields(flex);
//            teamFirebase.setValue(flex);
        } else {
            larosa.incRed(-5);
            updateTextFields(larosa);
//            teamFirebase.setValue(larosa);
        }
        updatePrefs();
    }

    @LongClick(R.id.blue_five)
    void blueFiveLongTapped() {
        if (!toggle) {
            flex.incBlue(-5);
            updateTextFields(flex);
//            teamFirebase.setValue(flex);
        } else {
            larosa.incBlue(-5);
            updateTextFields(larosa);
//            teamFirebase.setValue(larosa);
        }
        updatePrefs();
    }

    @Click(R.id.blue_field)
    void blueFieldTapped() {
        if (!toggle) {
            flex.incBlue(30);
            updateTextFields(flex);
//            teamFirebase.setValue(flex);
        } else {
            larosa.incBlue(30);
            updateTextFields(larosa);
//            teamFirebase.setValue(larosa);
        }
        updatePrefs();
    }

    @Click(R.id.red_field)
    void redFieldTapped() {
        if (!toggle) {
            flex.incRed(30);
            updateTextFields(flex);
//            teamFirebase.setValue(flex);
        } else {
            larosa.incRed(30);
            updateTextFields(larosa);
//            teamFirebase.setValue(larosa);
        }
        updatePrefs();
    }

    @LongClick(R.id.blue_field)
    void blueFieldLongTapped() {
        if (!toggle) {
            flex.incBlue(-30);
            updateTextFields(flex);
//            teamFirebase.setValue(flex);
        } else {
            larosa.incBlue(-30);
            updateTextFields(larosa);
//            teamFirebase.setValue(larosa);
        }
        updatePrefs();
    }

    @LongClick(R.id.red_field)
    void redFieldLongTapped() {
        if (!toggle) {
            flex.incRed(-30);
            updateTextFields(flex);
//            teamFirebase.setValue(flex);
        } else {
            larosa.incRed(-30);
            updateTextFields(larosa);
//            teamFirebase.setValue(larosa);
        }
        updatePrefs();
    }

    @Click(R.id.blue_grave)
    void blueGraveyardTapped() {
        if (!toggle) {
            flex.setPrevBlue(flex.getBlue());
            flex.setBlue(0);
            updateTextFields(flex);
//            teamFirebase.setValue(flex);
        } else {
            larosa.setPrevBlue(larosa.getBlue());
            larosa.setBlue(0);
            updateTextFields(larosa);
//            teamFirebase.setValue(larosa);
        }
        updatePrefs();
    }

    @Click(R.id.red_grave)
    void redGraveyardTapped() {
        if (!toggle) {
            flex.setPrevRed(flex.getRed());
            flex.setRed(0);
            updateTextFields(flex);
//            teamFirebase.setValue(flex);
        } else {
            larosa.setPrevRed(larosa.getRed());
            larosa.setRed(0);
            updateTextFields(larosa);
//            teamFirebase.setValue(larosa);
        }
        updatePrefs();
    }

    @LongClick(R.id.blue_grave)
    void blueGraveyardLongTapped() {
        if (!toggle) {
            flex.setBlue(flex.getPrevBlue());
            updateTextFields(flex);
//            teamFirebase.setValue(flex);
        } else {
            larosa.setBlue(larosa.getPrevBlue());
            updateTextFields(larosa);
//            teamFirebase.setValue(larosa);
        }
        updatePrefs();
    }

    @LongClick(R.id.red_grave)
    void redGraveyardLongTapped() {
        if (!toggle) {
            flex.setRed(flex.getPrevRed());
            updateTextFields(flex);
//            teamFirebase.setValue(flex);
        } else {
            larosa.setRed(larosa.getPrevRed());
            updateTextFields(larosa);
//            teamFirebase.setValue(larosa);
        }
        updatePrefs();
    }

    void switchCars() {
        toggle = !toggle;
        team = toggle ? teamLaRosa : teamFlex;
//        teamFirebase = firebase.child(team);
        teamTextView.setText(team);
        if (!toggle) {
            updateTextFields(flex);
        } else {
            updateTextFields(larosa);
        }
        Toast.makeText(mApplication.getApplicationContext(), team, Toast.LENGTH_SHORT).show();
    }
}
