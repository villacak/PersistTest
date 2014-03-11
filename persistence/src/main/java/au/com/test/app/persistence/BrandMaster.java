package au.com.test.app.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import au.com.test.app.bean.BrandBean;

/**
 * Created by Klaus on 9/03/14.
 */
public abstract class BrandMaster {
    protected Context ctx;
    protected SQLiteDatabase db;

    protected String brandHq = "brand_hq";
    protected String id = "brandHqId";
    protected String name = "brandName";
    protected String address = "brandFullAddress";

    public void initVars(SQLiteDatabase db) {
        this.db = db;
    }

    public void closeDB() {
        if (db != null) {
            db.close();
            db = null;
        }
    }

    protected ContentValues getContentValues(BrandBean bean) {
        ContentValues args = new ContentValues();
        args.put(id, bean.getBrandId());
        args.put(name, bean.getBrandName());
        args.put(address, bean.getBrandAddress());
        return args;
    }

    protected BrandBean getBeanFromCursor(Cursor cursor) {
        final int idIndex = cursor.getColumnIndexOrThrow(id);
        final int nameIndex = cursor.getColumnIndexOrThrow(name);
        final int addressIndex = cursor.getColumnIndexOrThrow(address);
        return new BrandBean(cursor.getInt(idIndex), cursor.getString(nameIndex), cursor.getString(addressIndex));
    }

    private Cursor loadAll() {
        String sql = "SELECT * FROM " + brandHq;
        Cursor cursor = db.rawQuery(sql, null);
        sql = null;
        return cursor;
    }

    public List<BrandBean> findAll() {
        List<BrandBean> listWithAll = new ArrayList<BrandBean>();
        Cursor cursor = loadAll();
        try {
            BrandBean bean = null;
            if (cursor != null && cursor.getCount() >= 1) {
                cursor.moveToFirst();
                int counter = cursor.getCount();
                for (int i = 0; i < counter; i++) {
                    bean = getBeanFromCursor(cursor);
                    listWithAll.add(bean);
                    cursor.moveToNext();
                    if (cursor.isAfterLast()) {
                        break;
                    }
                }
                bean = null;
            }
        } finally {
            cursor.close();
            cursor = null;
        }
        return listWithAll;
    }


    public abstract boolean insert(BrandBean bean);

}
