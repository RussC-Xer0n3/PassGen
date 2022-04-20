package com.local.russellclarke.passgen;
/**
 * Key Generator helper class
 * reCreated by russellclarke on 18/11/2017.
 * Modified from: https://stackoverflow.com/questions/41107/how-to-generate-a-random-alpha-numeric-string
 * User: cmpbah - https://stackoverflow.com/posts/10177396/revisions
 */
import java.util.Random;

public class Jenny {

    private static String dCase = "";
    private static String uCase = "";
    private static String num = "";
    private static String sym = "";
    private static int uLength = 24;
    private static String kee = "";

    private static Random r = new Random();

    public static String Generate(){
        int l = getUCase().length();
        int u = getDCase().length();
        int n = getNum().length();
        int s = getSym().length();

        while (getKee().length () != getULength()){
            int rJen = r.nextInt(4);
            switch (rJen){
                case 0:
                    if(getDCase() == ""){
                        break;
                    }else {
                        int lGrab = r.nextInt(u);
                        setKee(getKee() + getDCase().charAt(lGrab));
                    }break;
                case 1:
                    if(getUCase() == ""){
                        break;
                    }else {
                        int uGrab = r.nextInt(l);
                        setKee(getKee() + getUCase().charAt(uGrab));
                    }break;
                case 2:
                    if(getSym() == ""){
                        break;
                    }else {
                        int sGrab = r.nextInt(s);
                        setKee(getKee() + getSym().charAt(sGrab));
                    }break;
                case 3:
                    if(getNum() == ""){
                        break;
                    }else {
                        int nGrab = r.nextInt(n);
                        setKee(getKee() + getNum().charAt(nGrab));
                    }break;
            }
        }
        return getKee();
    }

    public static void main (String[] args) {
        String key = Generate();
        System.out.println(key);
    }

    public static String getDCase() {
        return dCase;
    }

    public static String getUCase() {
        return uCase;
    }

    public static String getSym() {
        return sym;
    }

    public static String getNum() {
        return num;
    }

    public static String getKee() {
        return kee;
    }

    public static int getULength() {
        return uLength;
    }

    public static void setDCase(String dCase) { Jenny.dCase = dCase; }

    public static void setUCase(String uCase) { Jenny.uCase = uCase; }

    public static void setNum(String num) { Jenny.num = num; }

    public static void setSym(String sym) { Jenny.sym = sym; }

    public static void setKee(String kee) { Jenny.kee = kee; }

    public static void setULength(int uLength) { Jenny.uLength = uLength; }

}