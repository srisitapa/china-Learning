package neu.jitchottara.sitapa.chinalearning;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Dell on 3/3/2559.
 */
public class MyManage {

    //Explicit การประกาศตัวแปร
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String lean_table = "learnTABLE";
    public static final String column_Unit = "Unit";
    public static final String column_Level = "Level";
    public static final String column_Image = "Image";
    public static final String column_Vocabulary = "Vocabulary";
    public static final String column_Read = "Read";
    public static final String column_Meaning = "Meaning";
    public static final String column_Sound = "Sound";


    public MyManage(Context context) {

        //Create& Connected database
        myOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = myOpenHelper.getWritableDatabase();
        readSqLiteDatabase = myOpenHelper.getReadableDatabase();

    } //Constructor
    public long addLearn(String strUnit,
                         String strLevel,
                         String strImage,
                         String strVocabulary,
                         String strRead,
                         String strMeaning,
                         String strSound) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(column_Unit,strUnit);
        contentValues.put(column_Level,strLevel);
        contentValues.put(column_Image,strImage);
        contentValues.put(column_Vocabulary,strVocabulary);
        contentValues.put(column_Read,strRead);
        contentValues.put(column_Meaning,strMeaning);
        contentValues.put(column_Sound,strSound);

        return writeSqLiteDatabase.insert(lean_table,null,contentValues);
    }

} //Main Class
