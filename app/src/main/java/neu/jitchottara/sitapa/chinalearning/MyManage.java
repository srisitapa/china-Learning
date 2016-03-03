package neu.jitchottara.sitapa.chinalearning;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Dell on 3/3/2559.
 */
public class MyManage {

    //Explicit การประกาศตัวแปร
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public MyManage(Context context) {

        //Create& Connected database
        myOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = myOpenHelper.getWritableDatabase();
        readSqLiteDatabase = myOpenHelper.getReadableDatabase();

    } //Constructor
} //Main Class
