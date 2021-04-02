package jp.codeforfun.arknightsdatabase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;

public class PersonalListAdapter extends ArrayAdapter<PersonalNote> {
    private List<PersonalNote> mNote;
    private LayoutInflater mInflater;
    private int mResource;

    public PersonalListAdapter(Context context, int resource, List<PersonalNote> item) {
        super(context, resource, item);

        mResource = resource;
        mNote = item;
        mInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView != null) {
            view = convertView;
        } else {
            view = mInflater.inflate(mResource, null);
        }

        PersonalNote note = mNote.get(position);
        TextView lvName = (TextView)view.findViewById(R.id.lv_name);
        TextView lvPromotion = (TextView)view.findViewById(R.id.lv_promotion);
        TextView lvLv = (TextView)view.findViewById(R.id.lv_lv);
        TextView lvSk = (TextView)view.findViewById(R.id.lv_sklv);
        TextView lvSk1 = (TextView)view.findViewById(R.id.lv_sk1lv);
        TextView lvSk2 = (TextView)view.findViewById(R.id.lv_sk2lv);
        TextView lvSk3 = (TextView)view.findViewById(R.id.lv_sk3lv);
        PersonalDBHelper helper = new PersonalDBHelper(getContext());
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = db.query("personaldb",new String[] {"name","promotion","lv","slv","s1lv","s2lv","s3lv"},
                            null,null,null,null,null);
        c.moveToPosition(position);
        lvName.setText(c.getString(0));
        lvPromotion.setText(c.getString(1));
        lvLv.setText(c.getString(2));
        lvSk.setText(c.getString(3));
        lvSk1.setText(c.getString(4));
        lvSk2.setText(c.getString(5));
        lvSk3.setText(c.getString(6));

        c.close();
        db.close();

        return view;
    }
}
