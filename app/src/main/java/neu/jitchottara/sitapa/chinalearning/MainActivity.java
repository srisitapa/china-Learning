package neu.jitchottara.sitapa.chinalearning;

import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    //Explicit ประกาศตัวแปร
    private MyManage myManage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Request Database เป็นตัว run ครั้งแรก
        myManage = new MyManage(this);

        //Test Add Value ทดสอบการ test  value
        //testAddValue();

        //Delete All Data
        deleteAllData();

        //SynChronize JSON to SQLite
        synJSONtoSqLite();

    } // Main Method

    private void synJSONtoSqLite() {

        //Connected http:// ทำให้แอนดรอยคอนเนคโปรโตคอล
        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy
                .Builder().permitAll().build();
        StrictMode.setThreadPolicy(threadPolicy);

        int intUnit = 0;
        while (intUnit <= 4) {

            //1. Create InputStream
            InputStream inputStream = null;
            String[] tableStrings = new String[5];
            tableStrings[0] = "http://swiftcodingthai.com/see/php_get_unit1.php";
            tableStrings[1] = "http://swiftcodingthai.com/see/php_get_unit2.php";
            tableStrings[2] = "http://swiftcodingthai.com/see/php_get_unit3.php";
            tableStrings[3] = "http://swiftcodingthai.com/see/php_get_unit4.php";
            tableStrings[4] = "http://swiftcodingthai.com/see/php_get_unit5.php";

            String[] unitStrings = new String[5];
            unitStrings[0] = "บทที่ 1";
            unitStrings[1] = "บทที่ 2";
            unitStrings[2] = "บทที่ 3";
            unitStrings[3] = "บทที่ 4";
            unitStrings[4] = "บทที่ 5";

            String tag = "China";

            try {
                //เป็นการโหลดแบบ inputStream

                HttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost(tableStrings[intUnit]);
                HttpResponse httpResponse = httpClient.execute(httpPost);
                HttpEntity httpEntity = httpResponse.getEntity();
                inputStream = httpEntity.getContent();



            } catch (Exception e) {
                Log.d(tag, "InputStream ==>" + e.toString());
            }


            //2. CreateJSON String
            String strJSON = null;
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
                StringBuilder stringBuilder = new StringBuilder();
                String strLine = null;

                while ((strLine=bufferedReader.readLine()) != null) {
                    stringBuilder.append(strLine);
                }
                inputStream.close();
                strJSON = stringBuilder.toString();

            } catch (Exception e) {
                Log.d(tag, "JSON String ==>" + e.toString());
            }

            //3. Updateto SQLite
            try {

                JSONArray jsonArray = new JSONArray(strJSON);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String strUnit = unitStrings[intUnit];
                    String strLevel = jsonObject.getString(MyManage.column_Level);
                    String strImage = jsonObject.getString(MyManage.column_Image);
                    String strVocap = jsonObject.getString(MyManage.column_Vocabulary);
                    String strRead = jsonObject.getString(MyManage.column_Read);
                    String strMeaning = jsonObject.getString(MyManage.column_Meaning);
                    String strSound = jsonObject.getString(MyManage.column_Sound);

                    myManage.addLearn(strUnit, strLevel, strImage, strVocap, strRead,
                            strMeaning, strSound);

                }//for loop

            } catch (Exception e) {
                Log.d(tag, "update ==>" + e.toString());
            }

            intUnit += 1;


        }   //while loop

    }   //SynJSONtoSQLite

    private void deleteAllData() {
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        sqLiteDatabase.delete(MyManage.lean_table, null, null);
    }

    private void testAddValue() {
        myManage.addLearn("testUnit", "ง่าย", "urlImage", "二 ", "read", "meaning", "urlSound");
    }
} // Main Class
