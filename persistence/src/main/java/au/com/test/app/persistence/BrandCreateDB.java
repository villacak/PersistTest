package au.com.test.app.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Klaus on 9/03/14.
 */
public class BrandCreateDB extends SQLiteOpenHelper {

    private String brandHq = "brand_hq";

    public BrandCreateDB(Context context, int version) {
        super(context, "branch.db", null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + brandHq + " ( "
                + "brandHqId INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "brandName TEXT, "
                + "brandFullAddress TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        dropTable(db);
        onCreate(db);
    }

    public void dropTable(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + brandHq);
    }
}
