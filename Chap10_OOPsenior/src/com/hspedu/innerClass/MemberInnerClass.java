package com.hspedu.innerClass;

public class MemberInnerClass {
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        Outer02.Inner02 inner02 = outer02.new Inner02();
        Outer02.Inner03 inner03 = new Outer02.Inner03();
    }
}

class Outer02 {
    public String name = "this is Outer02.name";
    public class Inner02 {
        public String name = "this is Inner02.name(成员内部类)";
    }

    public static class Inner03{
        public String name = "this is Inner03.name(静态内部类)";
    }
}
