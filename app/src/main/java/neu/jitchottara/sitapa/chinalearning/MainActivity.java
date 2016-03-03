package neu.jitchottara.sitapa.chinalearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
        testAddValue();

    } // Main Method

    private void testAddValue() {
        myManage.addLearn("testUnit", "ง่าย", "urlImage", "二 ", "read", "meaning", "urlSound");
    }
} // Main Class
