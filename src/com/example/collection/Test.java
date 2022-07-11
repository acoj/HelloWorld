package com.example.collection;

public class Test {
    public static void main(String[] args) {
        Generic<String> generic = new Generic<>();
        generic.setFlag("admin");
        String flag = generic.getFlag();
        System.out.println(flag);

        Generic<Integer> generic1 = new Generic<>();
        generic1.setFlag(100);
        Integer flag1 = generic1.getFlag();
        System.out.println(flag1);

        generic.method(new String[]{"a", "b", "c"});
        generic.method(new Integer[]{0, 1, 2});

        ShowMsg showMsg = new ShowMsg();
        //showMsg.showFlag(generic);
        showMsg.showFlag(generic1);

        Generic<Number> generic2 = new Generic<>();
        generic2.setFlag(50);
        showMsg.showFlag(generic2);

        showMsg.showFlag(new Generic<>());

    }
}
