package _9_inner_class;


public class OuterClass {

    InnerClass innerClass;

    public OuterClass() {
        new InnerClass("", "", "", "");
        new StaticInnerClass("", "", "", "");

        new InnerClass("").methodPublic();
        new InnerClass("").methodProtected();
        new InnerClass("").method();
        new InnerClass("").methodPrivate();

        new StaticInnerClass("").methodPublic();
        new StaticInnerClass("").methodProtected();
        new StaticInnerClass("").method();
        new StaticInnerClass("").methodPrivate();

        StaticInnerClass.staticMethodPublic();
        StaticInnerClass.staticMethodProtected();
        StaticInnerClass.staticMethod();
        StaticInnerClass.staticMethodPrivate();
    }

    protected OuterClass(String arg1) {
    }

    OuterClass(String arg1, String arg2, String arg3) {
    }

    private OuterClass(String arg1, String arg2, String arg3, String arg4) {
    }


    public static void staticMethodPublic() {
        /*
        new InnerClass();
        new InnerClass("", "");
        new InnerClass("", "", "");
        new InnerClass("", "", "", "");

        new InnerClass().methodPublic();
        new InnerClass().methodProtected();
        new InnerClass().method();
        new InnerClass().methodPrivate();
        */

        new StaticInnerClass("", "", "", "");

        new StaticInnerClass("").methodPublic();
        new StaticInnerClass("").methodProtected();
        new StaticInnerClass("").method();
        new StaticInnerClass("").methodPrivate();

        StaticInnerClass.staticMethodPublic();
        StaticInnerClass.staticMethodProtected();
        StaticInnerClass.staticMethod();
        StaticInnerClass.staticMethodPrivate();
    }

    protected static void staticMethodProtected() {
    }

    static void staticMethod() {
    }

    public static void staticMethodPrivate() {
    }

    public void methodPublic() {
        new InnerClass("", "", "", "");
        new StaticInnerClass("", "", "", "");

        new InnerClass("").methodPublic();
        new InnerClass("").methodProtected();
        new InnerClass("").method();
        new InnerClass("").methodPrivate();

        new StaticInnerClass("").methodPublic();
        new StaticInnerClass("").methodProtected();
        new StaticInnerClass("").method();
        new StaticInnerClass("").methodPrivate();

        StaticInnerClass.staticMethodPublic();
        StaticInnerClass.staticMethodProtected();
        StaticInnerClass.staticMethod();
        StaticInnerClass.staticMethodPrivate();
    }

    protected void methodProtected() {
    }

    void method() {
    }

    public void methodPrivate() {
    }

    private class InnerClass {

        public Integer i = 0;

        public InnerClass() {
            new OuterClass("", "", "", "");
            new StaticInnerClass("", "", "", "");

            new OuterClass("").methodPublic();
            new OuterClass("").methodProtected();
            new OuterClass("").method();
            new OuterClass("").methodPrivate();

            OuterClass.staticMethodPublic();
            OuterClass.staticMethodProtected();
            OuterClass.staticMethod();
            OuterClass.staticMethodPrivate();

            new OuterClass.StaticInnerClass("", "", "", "");

            new StaticInnerClass("").methodPublic();
            new StaticInnerClass("").methodProtected();
            new StaticInnerClass("").method();
            new StaticInnerClass("").methodPrivate();

            StaticInnerClass.staticMethodPublic();
            StaticInnerClass.staticMethodProtected();
            StaticInnerClass.staticMethod();
            StaticInnerClass.staticMethodPrivate();
        }

        protected InnerClass(String arg1) {
            i++;
        }

        InnerClass(String arg1, String arg2, String arg3) {
        }

        private InnerClass(String arg1, String arg2, String arg3, String arg4) {
        }

        public void methodPublic() {
        }

        protected void methodProtected() {
        }

        void method() {
        }

        private void methodPrivate() {
        }

        @Override
        public String toString() {
            return "InnerClass{" +
                    "i=" + i +
                    '}';
        }
    }

    static class StaticInnerClass {

        Integer i = 0;
        static Integer staticI = 0;

        public StaticInnerClass() {
            new OuterClass("", "", "", "");
            new OuterClass().new InnerClass("", "", "", "");

            new OuterClass("").methodPublic();
            new OuterClass("").methodProtected();
            new OuterClass("").method();
            new OuterClass("").methodPrivate();

            OuterClass.staticMethodPublic();
            OuterClass.staticMethodProtected();
            OuterClass.staticMethod();
            OuterClass.staticMethodPrivate();


            new OuterClass("").new InnerClass("").methodPublic();
            new OuterClass("").new InnerClass("").methodProtected();
            new OuterClass("").new InnerClass("").method();
            new OuterClass("").new InnerClass("").methodPrivate();

        }

        protected StaticInnerClass(String arg1) {
            i++;
            staticI++;
        }

        StaticInnerClass(String arg1, String arg2, String arg3) {
        }

        private StaticInnerClass(String arg1, String arg2, String arg3, String arg4) {
        }

        public static void staticMethodPublic() {
        }

        protected static void staticMethodProtected() {
        }

        static void staticMethod() {
        }

        private static void staticMethodPrivate() {
        }

        public void methodPublic() {
        }

        protected void methodProtected() {
        }

        void method() {
        }

        private void methodPrivate() {
        }

        @Override
        public String toString() {
            return "StaticInnerClass{" +
                    "i=" + i +
                    '}';
        }
    }


    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();

        OuterClass.InnerClass innerClass = new OuterClass().new InnerClass();
//        OuterClass.InnerClass innerClass = new InnerClass();

        OuterClass.StaticInnerClass staticInnerClass = new StaticInnerClass();
//        OuterClass.StaticInnerClass staticInnerClass1 = new OuterClass().new StaticInnerClass();

        System.out.println(innerClass.i);
        System.out.println(staticInnerClass.i);
        System.out.println(staticInnerClass.staticI);
    }
}
