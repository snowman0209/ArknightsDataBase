package jp.codeforfun.arknightsdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class HumanResourceActivity extends AppCompatActivity implements TextWatcher {

    static final String[] NAMES = new String[]{
            "ぶれいず", "ブレイズ"
    };

    EditText skilllv;
    EditText skill1lv;
    EditText skill2lv;
    EditText skill3lv;
    TextView sk1;
    TextView sk2;
    TextView sk3;
    EditText edlv;
    Spinner spinner;
    AutoCompleteTextView autoCompleteTextView;
    String name;
    ListView listView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_human_resorce);

        loadNote();
        autoCompleteTextView = findViewById(R.id.autocomplete_name);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.name_list, NAMES);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.addTextChangedListener(this);
        edlv = findViewById(R.id.lv);
        spinner = findViewById(R.id.spinner);
        skilllv = findViewById(R.id.slv);
        /*listView.setOnContextClickListener(new View.OnCreateContextMenuListener(){
            @Override
            public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                getMenuInflater().inflate(R.menu.context_menu,contextMenu);
            }
        });*/

        skilllv.addTextChangedListener(this);
        skilllv.setFilters(new InputFilter[]{new InputFilterMinMax("1","4")});
        skill1lv = findViewById(R.id.sk1lv);
        skill1lv.setFilters(new InputFilter[]{new InputFilterMinMax("1","3")});
        skill2lv = findViewById(R.id.sk2lv);
        skill2lv.setFilters(new InputFilter[]{new InputFilterMinMax("1","3")});
        skill3lv = findViewById(R.id.sk3lv);
        skill3lv.setFilters(new InputFilter[]{new InputFilterMinMax("1","3")});
        sk1 = findViewById(R.id.skill1);
        sk2 = findViewById(R.id.skill2);
        sk3 = findViewById(R.id.skill3);
        skilllv = findViewById(R.id.slv);
        Button button = findViewById(R.id.button);
        listView = findViewById(R.id.listView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(name != null){
                    HumanResourceOpenHelper helper = new HumanResourceOpenHelper(getApplicationContext());
                    SQLiteDatabase db = helper.getReadableDatabase();
                    Cursor c = db.query("humandb",new String[] {"name","rare"},
                            null,null,null,null,null);
                    c.moveToFirst();
                    PersonalDBHelper personalDBHelper = new PersonalDBHelper(getApplicationContext());
                    SQLiteDatabase pdb = personalDBHelper.getWritableDatabase();
                    for(int i = 0; i < c.getCount(); i++){
                        if(hiragana2Katakana(autoCompleteTextView.getText().toString()).equals(c.getString(0))){
                            String name = hiragana2Katakana(autoCompleteTextView.getText().toString());
                            String rare =  c.getString(1);
                            String promotion = (String)spinner.getSelectedItem();
                            String lv = edlv.getText().toString();
                            String sl = skilllv.getText().toString();
                            String s1lv;
                            String s2lv;
                            String s3lv;
                            if(skill1lv != null) {
                                s1lv = skill1lv.getText().toString();
                            }else{
                                s1lv = "0";
                            }
                            if(skill2lv != null) {
                                s2lv = skill2lv.getText().toString();
                            }else{
                                s2lv = "0";
                            }
                            if(skill3lv != null) {
                                s3lv = skill3lv.getText().toString();
                            }else{
                                s3lv = "0";
                            }
                            Cursor pdbC =  pdb.query("personaldb",new String[] {"name"},null,null,null,null,null,null);
                            pdbC.moveToFirst();
                            int a = 0;
                            for(int j = 0; j < pdbC.getCount(); j++) {
                                if(name.equals(pdbC.getString(0))){
                                    ContentValues cv = new ContentValues();
                                    cv.put("promotion",promotion);
                                    cv.put("lv",lv);
                                    cv.put("slv",sl);
                                    cv.put("s1lv",s1lv);
                                    cv.put("s2lv",s2lv);
                                    cv.put("s3lv",s3lv);
                                    String whereName = "name="+name;
                                    pdb.update("personaldb",cv,null,null);
                                    a = 1;
                                }
                                pdbC.moveToNext();
                            }
                            if(a == 0){
                                PersonalDBHelper.saveData(pdb, name, rare, promotion, lv, sl, s1lv, s2lv, s3lv);
                            }
                            loadNote();
                            break;
                        }
                        c.moveToNext();
                    }
                    c.close();
                    db.close();
                    pdb.close();

                }
                PersonalDBHelper helper = new PersonalDBHelper(getApplicationContext());
                SQLiteDatabase db = helper.getReadableDatabase();
                Cursor c = db.query("personaldb",new String[] {"name","rare","promotion","lv","slv","s1lv","s2lv","s3lv"},null,null,null,null,null);
                c.moveToFirst();
                for(int i = 0; i < c.getCount(); i++ ) {
                    c.moveToNext();
                }
                    c.close();
                    db.close();
            }

        });

    }

    private void loadNote() {
        listView = findViewById(R.id.listView);
        ArrayList<PersonalNote> listItems= new ArrayList<>();
        PersonalDBHelper helper = new PersonalDBHelper(getApplicationContext());
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = db.query("personaldb",new String[]{"name","rare",},null,null,null,null,null);
        for(int i = 0; i < c.getCount(); i++){
            PersonalNote item = new PersonalNote();
            listItems.add(item);
        }
        PersonalListAdapter adapter = new PersonalListAdapter(this,R.layout.personalrow,listItems);
        listView.setAdapter(adapter);
        c.close();
        db.close();
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        String promotion = (String)spinner.getSelectedItem();
        if(charSequence.length() == 1)
        if (charSequence.toString().equals("7")&&promotion.equals("昇進2")) {
            sk1.setVisibility(View.VISIBLE);
            sk2.setVisibility(View.VISIBLE);
            sk3.setVisibility(View.VISIBLE);
            skill1lv.setVisibility(View.VISIBLE);
            skill2lv.setVisibility(View.VISIBLE);
            skill3lv.setVisibility(View.VISIBLE);
        }else{
            sk1.setVisibility(View.INVISIBLE);
            sk2.setVisibility(View.INVISIBLE);
            sk3.setVisibility(View.INVISIBLE);
            skill1lv.setVisibility(View.INVISIBLE);
            skill2lv.setVisibility(View.INVISIBLE);
            skill3lv.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if(editable.length() > 1){
            //カタカナに自動変換するプログラム模索中
            //エラーが起きやすいためコメント
            /*if(!editable.toString().matches("^[\\u30A0-\\u30FF]+$")){
                autoCompleteTextView.setText(hiragana2Katakana(editable.toString()));
                autoCompleteTextView.setSelection(autoCompleteTextView.length()-1);
            }*/
            HumanResourceOpenHelper helper = new HumanResourceOpenHelper(this);
            SQLiteDatabase db = helper.getReadableDatabase();
            String e = hiragana2Katakana(editable.toString());
            Log.d("",e);

            Cursor c = db.query("humandb", new String[]{"name", "rare"}, null, null, null, null, null);
            c.moveToFirst();
            edlv.setFilters(new InputFilter[]{new InputFilterMinMax("1","30")});

            for (int i = 0; i < c.getCount(); i++) {
                if(c.getString(0).equals(e)){
                    name = e;
                    String rare = c.getString(1);
                    switch (rare){
                        case "1":
                        case "2":
                            edlv.setFilters(new InputFilter[]{new InputFilterMinMax("1", "30")});
                            break;
                        case "3":
                            edlv.setFilters(new InputFilter[]{new InputFilterMinMax("1", "40")});
                            break;
                        case "4":
                            edlv.setFilters(new InputFilter[]{new InputFilterMinMax("1", "45")});
                            break;
                        case "5":
                        case "6":
                            edlv.setFilters(new InputFilter[]{new InputFilterMinMax("1","50")});
                            break;
                    }

                    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                            long id = adapterView.getItemIdAtPosition(i);
                            switch (rare) {
                                case "1":
                                case "2":
                                        edlv.setFilters(new InputFilter[]{new InputFilterMinMax("1", "30")});
                                    skilllv.setFilters(new InputFilter[]{new InputFilterMinMax("0","0")});
                                    break;
                                case "3":
                                    if (id == 0) {
                                        edlv.setFilters(new InputFilter[]{new InputFilterMinMax("1", "40")});
                                    } else if (id == 1) {
                                        edlv.setFilters(new InputFilter[]{new InputFilterMinMax("1", "55")});
                                        skilllv.setFilters(new InputFilter[]{new InputFilterMinMax("1","7")});
                                    }
                                    break;
                                case "4":
                                    if (id == 0) {
                                        edlv.setFilters(new InputFilter[]{new InputFilterMinMax("1", "45")});
                                    } else if (id == 1) {
                                        edlv.setFilters(new InputFilter[]{new InputFilterMinMax("1", "60")});
                                        skilllv.setFilters(new InputFilter[]{new InputFilterMinMax("1","7")});
                                    } else if (id == 2) {
                                        edlv.setFilters(new InputFilter[]{new InputFilterMinMax("1", "70")});
                                        skilllv.setFilters(new InputFilter[]{new InputFilterMinMax("1","7")});
                                    }
                                    break;
                                case "5":
                                    if (id == 0) {
                                        edlv.setFilters(new InputFilter[]{new InputFilterMinMax("1", "50")});
                                    } else if (id == 1) {
                                        edlv.setFilters(new InputFilter[]{new InputFilterMinMax("1", "70")});
                                        skilllv.setFilters(new InputFilter[]{new InputFilterMinMax("1","7")});
                                    } else if (id == 2) {
                                        edlv.setFilters(new InputFilter[]{new InputFilterMinMax("1", "80")});
                                        skilllv.setFilters(new InputFilter[]{new InputFilterMinMax("1","7")});
                                    }
                                    break;
                                case "6":
                                    Log.d("","6");
                                    if (id == 0) {
                                        edlv.setFilters(new InputFilter[]{new InputFilterMinMax("1", "50")});
                                    } else if (id == 1) {
                                        edlv.setFilters(new InputFilter[]{new InputFilterMinMax("1", "80")});
                                        skilllv.setFilters(new InputFilter[]{new InputFilterMinMax("1","7")});
                                    } else if (id == 2) {
                                        edlv.setFilters(new InputFilter[]{new InputFilterMinMax("1", "90")});
                                        skilllv.setFilters(new InputFilter[]{new InputFilterMinMax("1","7")});
                                    }
                                    break;
                                default:
                                    break;
                            }
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }else{
                    name = null;
                }
                c.moveToNext();
            }
            c.close();
            db.close();
        }
    }

    public static String hiragana2Katakana(String str) {
        int delta = 'ア' - 'あ';
        StringBuilder buf = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char code = str.charAt(i);
            Character.UnicodeBlock block = Character.UnicodeBlock.of(code);
            if (block != null && block.equals(Character.UnicodeBlock.HIRAGANA)) {
                buf.append((char)(code + delta));
            } else {
                buf.append(code);
            }
        }
        return buf.toString();
    }


    public class InputFilterMinMax implements InputFilter {

        private int min, max;

        public InputFilterMinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public InputFilterMinMax(String min, String max) {
            this.min = Integer.parseInt(min);
            this.max = Integer.parseInt(max);
        }

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            try {
                int input = Integer.parseInt(dest.toString() + source.toString());
                if (isInRange(min, max, input))
                    return null;
            } catch (NumberFormatException nfe) {
            }
            return "";
        }

        private boolean isInRange(int a, int b, int c) {
            return b > a ? c >= a && c <= b : c >= b && c <= a;
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,view,menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.delete:
                return  true;
            default:
                return super.onContextItemSelected(item);
        }
    }



}