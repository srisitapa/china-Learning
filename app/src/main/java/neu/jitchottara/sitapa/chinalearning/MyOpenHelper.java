package neu.jitchottara.sitapa.chinalearning;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dell on 3/3/2559.
 */
public class MyOpenHelper extends SQLiteOpenHelper {
    //Explicit ทำการประกาศตัวแปร
    public static final String database_name = "China.db";
    private static final int database_version = 1;
    private static final String create_learn_table = "create table learnTABLE (" +
            "_id integer primary key, " +
            "Unit text, " +
            "Level text, " +
            "Image text, " +
            "Vocabulary text," +
            "Read text, " +
            "Meaning text, " +
            "Sound text);";

    private static final String create_test_table = "create table testTABLE (" +
            "_id integer primary key, " +
            "Unit text, " +
            "Question text, " +
            "Image text, " +
            "Sound text, " +
            "Choice1 text, " +
            "Choice2 text, " +
            "Choice3 text, " +
            "Choice4 text, " +
            "Answer text);";

    private static final String create_user_table = "create table userTABLE (" +
            "_id integer primary key, " +
            "Date text, " +
            "Unit text, " +
            "Score text);";


    public MyOpenHelper(Context context) {
        super(context, database_name, null, database_version);
    } // Constructor เป็นเมทธอดที่ทำงานตัวแรก

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(create_learn_table);//สร้างฐานข้อมูล china
        sqLiteDatabase.execSQL(create_test_table);
        sqLiteDatabase.execSQL(create_user_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
} //Main Class
