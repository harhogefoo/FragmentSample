package model;

/**
 * Created by shino on 2016/05/04.
 */
public class Counter {
    private String name = "no_name";
    private int count = 0;


    public void setName (String name) {
        this.name = name;
    }
    public String getName () {
        return name;
    }
    public void setCount (int count) {
        this.count = count;
    }
    public int getCount () {
        return count;
    }
}
