package jp.codeforfun.arknightsdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

public class PersonalDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "personalDB.db";
    private static final String TABLE_NAME = "personaldb";
    private static final String _ID = "_id";
    private static final String NAME = "name";
    private static final String RARE = "rare";
    private static final String PROMOTION = "promotion";
    private static final String LV = "lv";
    private static final String SLV = "slv";
    private static final String S1LV = "s1lv";
    private static final String S2LV = "s2lv";
    private static final String S3LV = "s3lv";




    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + "("+
                    _ID + " INTEGER PRIMARY KEY," +
                    NAME + " TEXT," +
                    RARE + " TEXT,"+
                    PROMOTION + " TEXT,"+
                    LV + " TEXT,"+
                    SLV + " TEXT,"+
                    S1LV + " TEXT,"+
                    S2LV + " TEXT,"+
                    S3LV + " TEXT)";



    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;


    PersonalDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
            SQL_CREATE_ENTRIES
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(
                SQL_DELETE_ENTRIES
        );
        onCreate(db);
    }

    public static void saveData(SQLiteDatabase db, String name, String rare, String promotion, String lv, String slv, String s1lv, String s2lv, String s3lv){
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("rare",rare);
        values.put("promotion",promotion);
        values.put("lv",lv);
        values.put("slv",slv);
        values.put("s1lv",s1lv);
        values.put("s2lv",s2lv);
        values.put("s3lv",s3lv);

        db.insert("personaldb",null,values);
    }
}
