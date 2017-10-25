package droidowl.cowcounter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

//import com.firebase.client.ChildEventListener;
//import com.firebase.client.DataSnapshot;
//import com.firebase.client.Firebase;
//import com.firebase.client.FirebaseError;
//import com.firebase.ui.FirebaseListAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ItemLongClick;
import org.androidannotations.annotations.ViewById;

/**
 * Created by droidowl on 3/8/16.
 */
@EFragment(R.layout.fragment_chat)
public class ChatFragment extends Fragment {

    @App
    CowCounterApplication mApplication;

    @ViewById(R.id.chat_list_view)
    ListView listView;

    @ViewById(R.id.username_edit_text)
    EditText username;

    @ViewById(R.id.msg_edit_text)
    EditText message;

//    FirebaseListAdapter mAdapter;
//
//    Firebase chatBase;

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setHasOptionsMenu(false);
//
//
//        chatBase = new Firebase("https://tripmate.firebaseio.com/")
//                .child("chat");
//        chatBase.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//
//            }
//        });
//
//    }

    @AfterViews
    void setup() {
        listView.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        listView.setStackFromBottom(true);
//        mAdapter = new FirebaseListAdapter<ChatMessage>(getActivity(), ChatMessage
//                .class, R.layout.chat_list_item, chatBase) {
//            @Override
//            protected void populateView(View view, ChatMessage chatMessage, int i) {
//                ((TextView)view.findViewById(R.id.name_text_view)).setText
//                        (chatMessage.getName());
//                ((TextView)view.findViewById(R.id.message_text_view)).setText
//                        (chatMessage.getMessage());
//            }
//        };
//        listView.setAdapter(mAdapter);
    }
    @Click(R.id.send_msg_button)
    void send() {
        ChatMessage msg = new ChatMessage();
        msg.setName(username.getText().toString());
        msg.setMessage(message.getText().toString());
        message.setText("");
//        Firebase ref = chatBase.push();
//        ref.setValue(msg);
    }

    @ItemLongClick(R.id.chat_list_view)
    void listItemLongClick(int pos) {
//        Firebase ref = mAdapter.getRef(pos);
//        ref.removeValue();
//        mAdapter.notifyDataSetChanged();
    }
}
