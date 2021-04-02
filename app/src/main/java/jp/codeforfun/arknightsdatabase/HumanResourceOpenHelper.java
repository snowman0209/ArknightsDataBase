package jp.codeforfun.arknightsdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HumanResourceOpenHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "HumanDB.db";
    private static final String TABLE_NAME = "humandb";
    private static final String _ID = "_id";
    private static final String NAME = "name";
    private static final String RARE = "rare";
    private static final String POSITION = "position";
    private static final String ER11 = "er11";
    private static final String ER12 = "er12";
    private static final String ER21 = "er21";
    private static final String ER22 = "er22";
    private static final String SR21 = "sr21";
    private static final String SR22 = "sr22";
    private static final String SR3 = "sr3";
    private static final String SR41 = "sr41";
    private static final String SR42 = "sr42";
    private static final String SR5 = "sr5";
    private static final String SR61 = "sr61";
    private static final String SR62 = "sr62";
    private static final String SR111 = "sr111";
    private static final String SR112 = "sr112";
    private static final String SR121 = "sr121";
    private static final String SR122 = "sr122";
    private static final String SR131 = "sr131";
    private static final String SR132 = "sr132";
    private static final String SR211 = "sr211";
    private static final String SR212 = "sr212";
    private static final String SR221 = "sr221";
    private static final String SR222 = "sr222";
    private static final String SR231 = "sr231";
    private static final String SR232 = "sr232";
    private static final String SR311 = "sr311";
    private static final String SR312 = "sr312";
    private static final String SR321 = "sr321";
    private static final String SR322 = "sr322";
    private static final String SR331 = "sr331";
    private static final String SR332 = "sr332";
    private static final String ER11n = "er11n";
    private static final String ER12n = "er12n";
    private static final String ER21n = "er21n";
    private static final String ER22n = "er22n";
    private static final String SR21n = "sr21n";
    private static final String SR22n = "sr22n";
    private static final String SR3n = "sr3n";
    private static final String SR41n = "sr41n";
    private static final String SR42n = "sr42n";
    private static final String SR5n = "sr5n";
    private static final String SR61n = "sr61n";
    private static final String SR62n = "sr62n";
    private static final String SR111n = "sr111n";
    private static final String SR112n = "sr112n";
    private static final String SR121n = "sr121n";
    private static final String SR122n = "sr122n";
    private static final String SR131n = "sr131n";
    private static final String SR132n = "sr132n";
    private static final String SR211n = "sr211n";
    private static final String SR212n = "sr212n";
    private static final String SR221n = "sr221n";
    private static final String SR222n = "sr222n";
    private static final String SR231n = "sr231n";
    private static final String SR232n = "sr232n";
    private static final String SR311n = "sr311n";
    private static final String SR312n = "sr312n";
    private static final String SR321n = "sr321n";
    private static final String SR322n = "sr322n";
    private static final String SR331n = "sr331n";
    private static final String SR332n = "sr332n";



    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE "+ TABLE_NAME + " (" +
                    _ID +" INTEGER PRIMARY KEY," +
                    NAME + " TEXT," +
                    RARE + " TEXT," +
                    POSITION + " TEXT," +
                    ER11 + " TEXT," + ER12 + " TEXT," +
                    ER21 + " TEXT," + ER22 + " TEXT," +
                    SR21 + " TEXT," + SR22 + " TEXT," +
                    SR3 + " TEXT," +
                    SR41 + " TEXT," + SR42 + " TEXT," +
                    SR5 + " TEXT," +
                    SR61 + " TEXT," + SR62 + " TEXT," +
                    SR111 + " TEXT,"+ SR112 + " TEXT,"+
                    SR121 + " TEXT,"+ SR122 + " TEXT,"+
                    SR131 + " TEXT,"+ SR132 + " TEXT,"+
                    SR211 + " TEXT,"+ SR212 + " TEXT,"+
                    SR221 + " TEXT,"+ SR222 + " TEXT,"+
                    SR231 + " TEXT,"+ SR232 + " TEXT,"+
                    SR311 + " TEXT,"+ SR312 + " TEXT,"+
                    SR321 + " TEXT,"+ SR322 + " TEXT,"+
                    SR331 + " TEXT,"+ SR332 + " TEXT,"+
                    ER11n + " INTEGER," + ER12n + " INTEGER," +
                    ER21n + " INTEGER," + ER22n + " INTEGER," +
                    SR21n + " INTEGER," + SR22n + " INTEGER," +
                    SR3n + " INTEGER," +
                    SR41n + " INTEGER," + SR42n + " INTEGER," +
                    SR5n + " INTEGER," +
                    SR61n + " INTEGER," + SR62n + " INTEGER," +
                    SR111n + " INTEGER,"+ SR112n + " INTEGER,"+
                    SR121n + " INTEGER,"+ SR122n + " INTEGER,"+
                    SR131n + " INTEGER,"+ SR132n + " INTEGER,"+
                    SR211n + " INTEGER,"+ SR212n + " INTEGER,"+
                    SR221n + " INTEGER,"+ SR222n + " INTEGER,"+
                    SR231n + " INTEGER,"+ SR232n + " INTEGER,"+
                    SR311n + " INTEGER,"+ SR312n + " INTEGER,"+
                    SR321n + " INTEGER,"+ SR322n + " INTEGER,"+
                    SR331n + " INTEGER,"+ SR332n + " INTEGER)";

    private static final String SQL_DELETE_ENTRIES =
        "DROP TABLE IF EXISTS " + TABLE_NAME;





    HumanResourceOpenHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                SQL_CREATE_ENTRIES
        );

        saveData(db,"ブレイズ",6,"前衛",
                "初級装置",5,"初級アケトン",4,"D32鋼",4,"上級装置",6,
                "破壊装置",4,"エステル原料",4,"初級源岩",7,"初級糖源",4,"初級アケトン",4,
                "中級源岩",8,"人口ゲル",4,"中級異鉄",4,"上級装置",3,"中級異鉄",4,
                "上級装置",3,"上級異鉄",6,"D32鋼",6,"上級装置",4,
                "上級合成コール",4,"中級アケトン",8,"上級合成コール",4, "上級アケトン",8,
                "ナノフレーク",6,"上級マンガン",5,"上級マンガン",4,"中級装置",4,
                "上級マンガン",4,"上級装置",5,"融合剤",6,"上級装置",4);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(
                SQL_DELETE_ENTRIES
        );
        onCreate(db);
    }
    public void saveData(SQLiteDatabase db, String name, int rare, String position,
                         String er11,int er11n,String er12,int er12n,String er21,int er21n,
                         String er22,int er22n, String sr21,int sr21n,String sr22,int sr22n,
                         String sr3,int sr3n,String sr41,int sr41n,String sr42,int sr42n,
                         String sr5,int sr5n,String sr61,int sr61n,String sr62,int sr62n,
                         String sr111,int sr111n,String sr112,int sr112n,
                         String sr121,int sr121n, String sr122,int sr122n,
                         String sr131,int sr131n, String sr132,int sr132n,
                         String sr211,int sr211n,String sr212,int sr212n,
                         String sr221,int sr221n, String sr222,int sr222n,
                         String sr231,int sr231n, String sr232,int sr232n,
                         String sr311,int sr311n, String sr312,int sr312n,
                         String sr321,int sr321n, String sr322,int sr322n,
                         String sr331,int sr331n, String sr332,int sr332n){

        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("rare",rare);
        values.put("position",position);
        values.put("er11",er11);
        values.put("er11n",er11n);
        values.put("er12",er12);
        values.put("er12n",er12n);
        values.put("er21",er21);
        values.put("er21n",er21n);
        values.put("er22",er22);
        values.put("er22n",er22n);
        values.put("sr21",sr21);
        values.put("sr21n",sr21n);
        values.put("sr22",sr22);
        values.put("sr22n",sr22n);
        values.put("sr3",sr3);
        values.put("sr3n",sr3n);
        values.put("sr41",sr41);
        values.put("sr41n",sr41n);
        values.put("sr42",sr42);
        values.put("sr42n",sr42n);
        values.put("sr5",sr5);
        values.put("sr5n",sr5n);
        values.put("sr61",sr61);
        values.put("sr61n",sr61n);
        values.put("sr62",sr62);
        values.put("sr62n",sr62n);
        values.put("sr111",sr111);
        values.put("sr111n",sr111n);
        values.put("sr112",sr112);
        values.put("sr112n",sr112n);
        values.put("sr121",sr121);
        values.put("sr121n",sr121n);
        values.put("sr122",sr122);
        values.put("sr122n",sr122n);
        values.put("sr131",sr131);
        values.put("sr131n",sr131n);
        values.put("sr132",sr132);
        values.put("sr132n",sr132n);
        values.put("sr211",sr211);
        values.put("sr211n",sr211n);
        values.put("sr212",sr212);
        values.put("sr212n",sr212n);
        values.put("sr221",sr221);
        values.put("sr221n",sr221n);
        values.put("sr222",sr222);
        values.put("sr222n",sr222n);
        values.put("sr231",sr231);
        values.put("sr231n",sr231n);
        values.put("sr232",sr232);
        values.put("sr232n",sr232n);
        values.put("sr311",sr311);
        values.put("sr311n",sr311n);
        values.put("sr312",sr312);
        values.put("sr312n",sr312n);
        values.put("sr321",sr321);
        values.put("sr321n",sr321n);
        values.put("sr322",sr322);
        values.put("sr322n",sr322n);
        values.put("sr331",sr331);
        values.put("sr331n",sr331n);
        values.put("sr332",sr332);
        values.put("sr332n",sr332n);

        db.insert("humandb",null,values);
    }

}
