package com.example.android.puzzle;

/**
 * Created by sibby on 4/7/2017.
 */
public class Globals {
    private static Globals instance;
    private static int[] time = new int[12];
    int i;

    private Globals() {
    }
    public void settime(int t, int i){
        time[i] = t;
    }
    public int gettime(int i){
        return time[i];
    }
    public static synchronized Globals getInstance(){
        if(instance==null){
            instance=new Globals();
            for (int i = 0; i < 12; i++) {
                time[i] = 0;
            }
        }
        return instance;
    }
}
