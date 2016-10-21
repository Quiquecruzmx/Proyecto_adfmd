package adfmd.proyecto.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Enrique on 19/10/2016.
 */
public class AmigoDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Amigos.db";

    public AmigoDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL("CREATE TABLE " + AmigoContract.AmigoEntry.TABLE_NAME + " ("
                + AmigoContract.AmigoEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + AmigoContract.AmigoEntry.ID + " TEXT NOT NULL,"
                + AmigoContract.AmigoEntry.NOMBRE + " TEXT NOT NULL,"
                + AmigoContract.AmigoEntry.RECORD + " TEXT NOT NULL,"
                + AmigoContract.AmigoEntry.AVATAR_URI + " TEXT,"
                + "UNIQUE (" + AmigoContract.AmigoEntry.ID + "))");

        mockData(sqLiteDatabase);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long saveAmigo(Amigo amigo){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.insert(AmigoContract.AmigoEntry.TABLE_NAME, null, amigo.toContentValues());
    }

    private void mockData(SQLiteDatabase sqLiteDatabase){
        mockAmigo(sqLiteDatabase, new Amigo("Carlos Perez       26 hrs.", "5000", "carlos_perez.jpg"));
        mockAmigo(sqLiteDatabase, new Amigo("Enrique Cruz       22 hrs.", "5050", "carlos_perez.jpg"));
        mockAmigo(sqLiteDatabase, new Amigo("Sergio Tenorio     21.5 hrs", "3000", "carlos_perez.jpg"));
        mockAmigo(sqLiteDatabase, new Amigo("Jorge Perez        8 hrs.", "6800", "carlos_perez.jpg"));
        mockAmigo(sqLiteDatabase, new Amigo("El Kevin           2 hrs.", "2100", "carlos_perez.jpg"));
        mockAmigo(sqLiteDatabase, new Amigo("El Brayan          45 min.", "80000", "carlos_perez.jpg"));

    }

    public long mockAmigo(SQLiteDatabase db, Amigo amigo) {
        return db.insert(
                AmigoContract.AmigoEntry.TABLE_NAME,
                null,
                amigo.toContentValues());
    }


    public Cursor getAllAmigos() {
        return getReadableDatabase()
                .query(
                        AmigoContract.AmigoEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }

    public Cursor getAmigoById(String amigoId) {
        Cursor c = getReadableDatabase().query(
                AmigoContract.AmigoEntry.TABLE_NAME,
                null,
                AmigoContract.AmigoEntry.ID + " LIKE ?",
                new String[]{amigoId},
                null,
                null,
                null);
        return c;
    }

    public int deleteAmigo(String amigoId) {
        return getWritableDatabase().delete(
                AmigoContract.AmigoEntry.TABLE_NAME,
                AmigoContract.AmigoEntry.ID + " LIKE ?",
                new String[]{amigoId});
    }

    public int updateAmigo(Amigo amigo, String amigoId) {
        return getWritableDatabase().update(
                AmigoContract.AmigoEntry.TABLE_NAME,
                amigo.toContentValues(),
                AmigoContract.AmigoEntry.ID + " LIKE ?",
                new String[]{amigoId}
        );
    }
}
