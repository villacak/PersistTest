package au.com.test.app.persistence;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import au.com.test.app.bean.BrandBean;

/**
 * Created by Klaus on 9/03/14.
 */
public class BrandCrudOrdinary extends BrandMaster {

    public BrandCrudOrdinary(Context ctx, SQLiteDatabase db) {
        this.ctx = ctx;
        initVars(db);
    }


    @Override
    public boolean insert(BrandBean bean) {
        boolean isSuccess = false;
        Cursor cursor = null;
        try {
            String sql = "INSERT INTO " + brandHq + " VALUES (" +
                    bean.getBrandId() + ", '" +
                    bean.getBrandName() + "', '" +
                    bean.getBrandAddress() + "');";
            cursor = db.rawQuery(sql, null);
            if (cursor != null && cursor.getCount() > 0) {
                isSuccess = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            isSuccess = false;
        }
        return isSuccess;
    }
}
