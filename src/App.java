

public class App {
     public static void main(String[] args) {
        new App(args);
    }

    public App(String[] args) {
        init(args);
    }

    private void init(String[] args) {
        String[] mainSketch = (new String[] { getSketchClassName() });
        Visualization.main(mainSketch);
    }

    public static final String getSketchClassName() {
        return Thread.currentThread().getStackTrace()[1].getClassName();
    }

    public static final String[] getSketchNestedClassNames() {
        Class[] nested;

        try {
            nested = Class.forName(getSketchClassName()).getClasses();
        } catch (ClassNotFoundException cause) {
            throw new RuntimeException(cause);
        }
        int idx = 0, len = Math.max(0, nested.length - 2);
        String[] classes = new String[len];

        while (idx != len)
            classes[idx] = nested[idx++].getName();
        return classes;
    }

    
}
