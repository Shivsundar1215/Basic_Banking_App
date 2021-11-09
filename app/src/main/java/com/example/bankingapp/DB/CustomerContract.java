package com.example.bankingapp.DB;

import android.provider.BaseColumns;

import com.example.bankingapp.Data.Customers;

public final class CustomerContract {
    private CustomerContract() {}

    public static final class CustomerEntry implements BaseColumns {
        /** Name of database table for pets */
        public final static String TABLE_NAME = "customer";

        /** Table Fields */
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_USER_NAME ="name";
        public final static String COLUMN_USER_ACCOUNT_NUMBER ="accountNo";
        public final static String COLUMN_USER_EMAIL ="email";
        public final static String COLUMN_USER_IFSC_CODE ="ifscCode";
        public final static String COLUMN_USER_PHONE_NO ="phoneNo";
        public final static String COLUMN_USER_ACCOUNT_BALANCE ="balance";
    }
}