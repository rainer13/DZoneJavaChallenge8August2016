package main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by rainerretzler on 08.08.2016.
 */
public class Main {

    public static void main(String[] args){
        System.out.println(args[0]+" "+args[1]);
        System.out.println(isSymbol(args[0],args[1]));
        System.out.println(" "+('a'-'A'));
        System.out.println(firstSymbol(args[0]));
        System.out.println(""+possibleSymbolCounter(args[0]));
    }

    private static boolean isSymbol(String a, String b){

        b=b.toLowerCase();
        a=a.toLowerCase();
        if(b.length()!=2)
            return false;
        char c1=b.charAt(0);
        char c2=b.charAt(1);
        int i1=a.indexOf(c1);
        if(i1<0)
            return  false;
        if(i1+1==a.length())
            return  false;
        int i2=a.indexOf(c2,i1+1);
        if(i2<0)
            return  false;
        return  true;

    }


    public static Set<String> toSymbolSet(String a){
        HashSet<String> s = new HashSet<String>();



        a=a.toLowerCase();
        int n=a.length();
        String ss="";
        for(int i=0;i<n-1;++i)
            for(int j=i+1;j<n;++j){
                ss="";
                ss+=a.charAt(i);
                ss+=a.charAt(j);
                s.add(ss);

            }
        return s;
    }

    public static String firstSymbol(String a){
        Set<String> possibleSymbols = toSymbolSet(a);
        String ret="zz";
        for(String val:possibleSymbols){
            if(ret.compareTo(val)>0)
                ret=val;
        }
        String ret1=ret.substring(0,1);
        ret1=ret1.toUpperCase();
        ret1+=ret.charAt(1);
        return ret1;
    }


    public  static int possibleSymbolCounter(String a){
        Set<String> ss=toSymbolSet(a);
        return ss.size();
    }

}
