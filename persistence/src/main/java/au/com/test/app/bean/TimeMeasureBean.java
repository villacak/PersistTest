package au.com.test.app.bean;

/**
 * Created by Klaus on 9/03/14.
 */
public class TimeMeasureBean {

    private String typeTest;
    private long startMills;
    private long endMills;

    public String getTypeTest() {
        return typeTest;
    }

    public void setTypeTest(String typeTest) {
        this.typeTest = typeTest;
    }

    public long getStartMills() {
        return startMills;
    }

    public void setStartMills(long startMills) {
        this.startMills = startMills;
    }

    public long getEndMills() {
        return endMills;
    }

    public void setEndMills(long endMills) {
        this.endMills = endMills;
    }
}
