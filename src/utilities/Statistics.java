package utilities;


/**
 * Created by Signifies on 10/3/2018 - 15:03.
 */
public enum Statistics{

    STAT_DEATHS("PLR_DEATH",0),
    STAT1("test",1);

    private int count;
    private String name;
    Statistics(String name, int value){
        this.name = name;
        count = value;
    }

    public int getCount(){
        return count;
    }

    public String getDataName()
    {
        return name;
    }



}
