package com.example.bankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.bankingapp.DB.CustomerContract.CustomerEntry;
import com.example.bankingapp.Data.Customers;

public class CustomerHelper extends SQLiteOpenHelper {

    String TABLE_NAME = CustomerEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "Customers.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public CustomerHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + CustomerEntry.TABLE_NAME + " ("
                + CustomerEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + CustomerEntry.COLUMN_USER_NAME + " VARCHAR, "
                + CustomerEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + CustomerEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + CustomerEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + CustomerEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(1000,'Shivsundar Bankar', 'shivsundar1@gmail.com','1215','8626089373', 50000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1001,'Sushant Dalvi', 'sushant1@gmail.com','1216','8888950102', 100000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1002,'Sahil Sayyed', 'sahil1@gmail.com','1217','9988332211', 70000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1003,'Joystan Bardeskar', 'joystan1@gmail.com','1218','9945108812', 80000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1004,'Soham Phirke', 'soham1@gmail.com','1219','9995356962', 75000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1005,'Aditya Karale', 'aditya@gmail.com','1220','8855640452', 65000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1006,'Vaibhav Ambekar', 'vaibhav1@gmail.com','1221','8895640452', 45000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1007,'Onkar Gadade', 'onkar1@gmail.com','1222','9985021533', 25000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1008,'Pratik Borate', 'pratik@gmail.com','1223','4405265238', 105000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1009,'Harsh Dake', 'harsh1@gmail.com','1224','8890123355', 50000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1010,'Anupama jk', 'anupama@gmail.com','1225','8945641630', 9800)");
        db.execSQL("insert into " + TABLE_NAME + " values(1011,'Atik S', 'atik1@gmail.com','1226','9445644599', 31000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1012,'Mithilesh Agarwal', 'mithilesh@gmail.com','1227','9319451001', 38000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1013,'Dhanashree Lunawat', 'dhanashree1@gmail.com','1228','9091642205', 5500)");
        db.execSQL("insert into " + TABLE_NAME + " values(1014,'Anjali Tripati', 'anjali1@gmail.com','1229','9295651666', 30000)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + CustomerEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + CustomerEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + CustomerEntry.TABLE_NAME + " where " +
                CustomerEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + CustomerEntry.TABLE_NAME + " set " + CustomerEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                CustomerEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}