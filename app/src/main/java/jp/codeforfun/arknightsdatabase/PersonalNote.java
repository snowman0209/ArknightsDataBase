package jp.codeforfun.arknightsdatabase;

import android.graphics.Bitmap;

public class PersonalNote {
    protected int id;
    protected String name;
    protected String rare;
    protected String promotion;
    protected String lv;
    protected String sklv;
    protected String s1lv;
    protected String s2lv;
    protected String s3lv;

    public PersonalNote(){}

    public PersonalNote(int id,String name,String rare, String promotion, String lv,
                        String sklv, String s1lv, String s2lv, String s3lv){
        this.id = id;
        this.name = name;
        this.promotion = promotion;
        this.rare = rare;
        this.lv = lv;
        this.sklv = sklv;
        this.s1lv = s1lv;
        this.s2lv = s2lv;
        this.s3lv = s3lv;
    }

    public String getName() {
        return name;
    }

    public String getRare(){
        return rare;
    }

    public String getPromotion(){
        return promotion;
    }

    public String getLv(){
        return lv;
    }

    public String getSklv(){
        return sklv;
    }

    public String getS1lv(){
        return sklv;
    }

    public String getS2lv(){
        return s2lv;
    }

    public String getS3lv(){
        return s3lv;
    }

}
