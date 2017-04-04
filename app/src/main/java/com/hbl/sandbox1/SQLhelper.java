package com.hbl.sandbox1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.hbl.sandbox1.models.Banners;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hbl on 4/4/2017.
 */

public class SQLhelper extends SQLiteOpenHelper {

    private static String dbName = "sandbox.db";
    private static int version = 1;
    private static String tablename = "basic";
    private String _0 = "zero";
    private String entityId = "entity_id";
    private String _1 = "one";
    private String sku = "sku";

    public SQLhelper(Context context) {
        super(context, dbName, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + tablename +
                " (" + _0 + " TEXT, " + entityId + " TEXT, " + _1 + " TEXT, " + sku + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tablename);
    }

    public void addBanners(List<Banners> banners) {
        if (banners != null)
            for (Banners banner : banners)
                addBanner(banner);
    }

    public void addBanner(Banners banners) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues(4);
        values.put(_0, banners.get0_num());
        values.put(entityId, banners.getEntityId());
        values.put(_1, banners.get1());
        values.put(sku, banners.getSku());
        db.insert(tablename, null, values);
    }

    @Nullable
    public Banners getBanner(String id) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + tablename + " WHERE " + this._0 + " = " + id + " LIMIT 1", new String[]{});
        if (null == cursor)
            return null;

        cursor.moveToFirst();
        Banners banner = new Banners();
        banner.set0(cursor.getString(0));
        banner.setEntityId(cursor.getString(1));
        banner.set1(cursor.getString(2));
        banner.setSku(cursor.getString(3));
        cursor.close();
        return banner;
    }

    @Nullable
    public List<Banners> getAllBanners() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + tablename, null);
        if (cursor == null)
            return null;
        List<Banners> banners = new ArrayList<>();
        while (cursor.moveToNext()) {
            Banners banner = new Banners();
            banner.set0(cursor.getString(0));
            banner.setEntityId(cursor.getString(1));
            banner.set1(cursor.getString(2));
            banner.setSku(cursor.getString(3));
            banners.add(banner);
        }
        cursor.close();
        return banners;
    }

    public int getBannersCount() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + tablename, null);
        if (null == cursor)
            return -1;
        cursor.moveToFirst();
        int count = cursor.getInt(0);
        cursor.close();
        return count;
    }

    public int updateBanner(Banners banner) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues(4);
        values.put(_0, banner.get0_num());
        values.put(entityId, banner.getEntityId());
        values.put(_1, banner.get1());
        values.put(sku, banner.getSku());
        return db.update(tablename, values, this._0 + " = " + banner.get0(), new String[0]);
    }

    public int deleteBanner(Banners banner) {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(tablename, this._0 + " = " + banner.get0(), new String[0]);
    }
}
