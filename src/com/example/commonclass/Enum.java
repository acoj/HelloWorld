package com.example.commonclass;

import org.junit.Test;

public class Enum {
    @Test
    public void test1(){
        System.out.println(Season.SPRING );
    }
    @Test
    public void test2() {
        System.out.println(Season1.SPRING);
        System.out.println(Season1.class.getSuperclass());
//        java.lang.Enum
        Season1[] values = Season1.values();
        for(Season1 s : values){
            System.out.println(s);
        }
        System.out.println(Season1.valueOf("WINTER"));
        Season1.SPRING.show();
    }
}

interface Info{
    void show();
}

enum Season1 implements Info{
    SPRING("spring", "warm"){
        @Override
        public void show() {
            System.out.println("this is spring");
        }
    },
    SUMMER("summer", "hot"){
        @Override
        public void show() {

        }
    },
    AUTUMN("autumn", "cool"){
        @Override
        public void show() {

        }
    },
    WINTER("winter", "cold"){
        @Override
        public void show() {

        }
    };

    private final String seasonName;
    private final String seasonDec;

    private Season1(String seasonName, String seasonDec){
        this.seasonName = seasonName;
        this.seasonDec = seasonDec;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDec() {
        return seasonDec;
    }

//    @Override
//    public String toString() {
//        return "Season1{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDec='" + seasonDec + '\'' +
//                '}';
//    }
}

class Season{
    private final String seasonName;
    private final String seasonDec;

    private Season(String seasonName, String seasonDec){
        this.seasonName = seasonName;
        this.seasonDec = seasonDec;
    }
    public static final Season SPRING = new Season("spring", "warm");
    public static final Season SUMMER = new Season("summer", "hot");
    public static final Season AUTUMN = new Season("autumn", "cool");
    public static final Season WINTER = new Season("winter", "cold");

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDec() {
        return seasonDec;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDec='" + seasonDec + '\'' +
                '}';
    }
}