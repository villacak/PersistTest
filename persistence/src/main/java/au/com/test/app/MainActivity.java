package au.com.test.app;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import au.com.test.app.bean.TimeMeasureBean;
import au.com.test.app.test.CreateDummyData;

public class MainActivity extends Activity {

    private String log;
    private int numberOfRecords = 1000;

    private static final int MAP_VALUES = 0;
    private static final int ORDINARY = 1;

    private int initVersion = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        log = this.getClass().getName();

        Log.i(log, "Starting");
        Log.i(log, "Loading up a list with " + numberOfRecords  + " records and start persisting.");

        CreateDummyData dummy = new CreateDummyData();
        TimeMeasureBean timeOne = dummy.testInsert(MAP_VALUES, numberOfRecords, initVersion, getApplicationContext());
        TimeMeasureBean timeTwo = dummy.testInsert(ORDINARY, numberOfRecords, initVersion + 1, getApplicationContext());

        String one = "Map Value - Start Time: " + timeOne.getStartMills() + ", End Time: " + timeOne.getEndMills() + ", time running:" + (timeOne.getEndMills() - timeOne.getStartMills());
        String two = "Ordinary - Start Time: " + timeTwo.getStartMills() + ", End Time: " + timeTwo.getEndMills() + ", time running:" + (timeTwo.getEndMills() - timeTwo.getStartMills());

        TextView tv1 = (TextView) findViewById(R.id.one);
        tv1.setText(one);

        TextView tv2 = (TextView) findViewById(R.id.two);
        tv2.setText(two);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
