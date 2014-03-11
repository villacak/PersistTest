package au.com.test.app.test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import au.com.test.app.bean.BrandBean;
import au.com.test.app.bean.TimeMeasureBean;
import au.com.test.app.persistence.BrandCreateDB;
import au.com.test.app.persistence.BrandCrudMapValues;
import au.com.test.app.persistence.BrandCrudOrdinary;

/**
 * Created by Klaus on 9/03/14.
 */
public class CreateDummyData {

    private static final int ORDINARY = 1;
    private static final String NAME = "Name Dummy ";
    private static final String ADDRESS = "Address Address ";

    private String log;

    private SQLiteDatabase db;
    private Context ctx;



    public TimeMeasureBean testInsert(int type, int numberOfRecords, int version, Context ctx) {
        log = this.getClass().getName();
        long endTime = 0l;
        this.ctx = ctx;
        String typeDescription = "Performance";
        if (type == ORDINARY) {
            typeDescription = "Ordinary";
        }
        List<BrandBean> bbList = populateBeamWithDummyData(numberOfRecords);
        TimeMeasureBean tmb = new TimeMeasureBean();
        tmb.setTypeTest(typeDescription);
        tmb.setStartMills(new Date().getTime());

        if (type == ORDINARY) {
            endTime = insertOrd(bbList, version);
        } else {
            endTime = insertPerf(bbList, version);
        }

        tmb.setEndMills(endTime);
        return tmb;
    }


    private List<BrandBean> populateBeamWithDummyData(int numberOfRecords) {
        List<BrandBean> bbList = new ArrayList<BrandBean>();
        if (numberOfRecords > 0) {
            BrandBean bb = null;
            for (int i = 0; i < numberOfRecords; i++) {
                bb = new BrandBean(i, CreateDummyData.NAME + i, CreateDummyData.ADDRESS + i);
                bbList.add(bb);
                bb = null;
            }
        }
        return bbList;
    }


    private long insertPerf(List<BrandBean> listToPersist, int version) {
        try {
            db = (new BrandCreateDB(ctx, version)).getWritableDatabase();
            BrandCrudMapValues bcf = new BrandCrudMapValues(ctx, db);
            for (BrandBean b : listToPersist) {
                bcf.insert(b);
//                Log.i(log, b.getBrandName());
            }
        } catch (Exception e) {
            Log.e(log, e.getLocalizedMessage());
        } finally {
            if (db != null)
                db.close();
        }
        return (new Date().getTime());
    }

    private long insertOrd(List<BrandBean> listToPersist, int version) {
       try {
            db = (new BrandCreateDB(ctx, version)).getWritableDatabase();
            BrandCrudOrdinary bco = new BrandCrudOrdinary(ctx, db);
            for (BrandBean b : listToPersist) {
                bco.insert(b);
//                Log.i(log, b.getBrandName());
            }
       } catch (Exception e) {
           Log.e(log, e.getLocalizedMessage());
       } finally {
           if (db != null)
               db.close();
       }
       return (new Date().getTime());
    }
}
