package adfmd.proyecto.data;

import android.provider.BaseColumns;

/**
 * Created by Enrique on 19/10/2016.
 */

public class AmigoContract {
    public static abstract class AmigoEntry implements BaseColumns {
        public static final String TABLE_NAME ="amigo";
        public static final String ID = "id";
        public static final String NOMBRE = "nombre";
        public static final String RECORD = "record";
        public static final String AVATAR_URI = "avatarUri";
    }
}
