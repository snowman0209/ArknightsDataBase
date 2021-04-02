package jp.codeforfun.arknightsdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ToDoActivity extends AppCompatActivity {
    static List<HNote> noteList = new ArrayList<HNote>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);
    }

    private class NoteListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return noteList.size();
        }

        @Override
        public Object getItem(int position) {
            return noteList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView noteTextView;
            TextView TimeTextView;
            View v = convertView;
            if (v == null) {
                LayoutInflater inflater =
                        (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = inflater.inflate(R.layout.row, null);
            }
            HNote note = (HNote) getItem(position);
            if (note != null) {
                noteTextView = (TextView) v.findViewById(R.id.noteTextView);
                TimeTextView = (TextView) v.findViewById(R.id.TimeTextView);
                noteTextView.setText(note.getName());
                TimeTextView.setText(note.getLv());
                v.setTag(R.id.noteTextView, note);
            }
            return v;
        }
    }
}