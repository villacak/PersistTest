package au.com.test.app.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import au.com.test.app.bean.BrandBean;

/**
 * Created by Klaus on 9/03/14.
 *
 * Instead Strings try put everything into string.xml, from resource folder.
 * I just have used String to make it faster to develop
 *
 */
public class BrandCrudMapValues extends BrandMaster {



    public BrandCrudMapValues(Context ctx, SQLiteDatabase db) {
        this.ctx = ctx;
        initVars(db);
    }





    public boolean insert(BrandBean bean) {
        boolean success = false;
        try {
            ContentValues args = getContentValues(bean);
            db.insert(brandHq, null, args);
            success = true;
            args = null;
        } catch (Exception e) {
            Log.e(this.getClass().getName(), e.getLocalizedMessage());
            success = false;
        }
        return success;
    }




}
