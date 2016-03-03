package neu.jitchottara.sitapa.chinalearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class HubAllUnit extends AppCompatActivity {
    //Explicit
    private TextView showUserChooseTextView;
    private ListView unitListView;
    private String userChooseString;
    private int indexAnint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub_all_unit);

        //Bind Widget
        bindWidget();

        //show view
        showView();

        //create ListView
        creteListView();

    }   //Main method

    private void creteListView() {
        String[] titleStrings = {"บทที่ 1","บทที่ 2","บทที่ 3","บทที่ 4","บทที่ 5"};

        MyAdapter myAdapter = new MyAdapter(HubAllUnit.this, titleStrings);
        unitListView.setAdapter(myAdapter);

    }   //createListView

    private void showView() {
        userChooseString = getIntent().getStringExtra("userChoose");
        indexAnint = getIntent().getIntExtra("index", 0);
        String[] showTextStrings = {"ง่าย","ปานกลาง","ยาก"};

        showUserChooseTextView.setText(showTextStrings[indexAnint]);

    }

    private void bindWidget() {
        showUserChooseTextView = (TextView) findViewById(R.id.textView4);
        unitListView = (ListView) findViewById(R.id.listView2);

    }
}   //Main Class
