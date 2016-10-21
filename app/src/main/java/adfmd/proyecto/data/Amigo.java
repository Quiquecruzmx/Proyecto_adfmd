package adfmd.proyecto.data;

import android.content.ContentValues;

import java.util.UUID;

/**
 * Created by Enrique on 19/10/2016.
 */

public class Amigo {
    private String id;
    private String nombre;
    private String record;
    private String avatarUri;

    public Amigo(String nombre, String record, String avatarUri){
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.record = record;
        this.avatarUri = avatarUri;
    }
    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(AmigoContract.AmigoEntry.ID, id);
        values.put(AmigoContract.AmigoEntry.NOMBRE, nombre);
        values.put(AmigoContract.AmigoEntry.RECORD, record);
        values.put(AmigoContract.AmigoEntry.AVATAR_URI, avatarUri);
        return values;
    }
    public String getId(){
        return id;
    }
    public String getNombre(){
        return nombre;
    }
    public String getRecord(){
        return record;
    }
    public String getAvatarUri(){
        return avatarUri;
    }
}