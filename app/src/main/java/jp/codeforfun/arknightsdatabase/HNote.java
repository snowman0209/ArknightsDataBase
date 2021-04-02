package jp.codeforfun.arknightsdatabase;

public class HNote {
    protected int id;
    protected String name;
    protected  String lv;
    protected String material;

    public HNote(int id, String name, String lv, String material){
        this.id = id;
        this.name = name;
        this.lv = lv;
        this.material = material;
    }

    public String getName(){
        return name;
    }

    public String getLv(){
        return lv;
    }

    public String getmaterial(){
        return material;
    }


    public int getId(){
        return id;
    }

}