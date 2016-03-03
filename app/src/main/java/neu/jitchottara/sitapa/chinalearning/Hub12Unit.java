package neu.jitchottara.sitapa.chinalearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Hub12Unit extends AppCompatActivity {
    //Explicit
    private TextView showUserChooseTextView;
    private ListView unit12ListView;
    private Button loadMoreButton;
    private String userChooseString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub12_unit);

        //Bind Widget
        binWidget();

        //show view
        showView();

        //Create ListView
        createListView();

    }   //Main Method

    private void createListView() {

        String[] titleStrings = {"บทที่ 1","บทที่ 2"};
        MyAdapter myAdapter = new MyAdapter(Hub12Unit.this, titleStrings);
        unit12ListView.setAdapter(myAdapter);
    }   //Create ListView


    private void showView() {
        userChooseString = getIntent().getStringExtra("userChoose");
        int intIndex = getIntent().getIntExtra("index", 0);
        String[] showTextStrings = {"ง่าย","ปานกลาง","ยาก"};

        showUserChooseTextView.setText(showTextStrings[intIndex]);
    }

    private void binWidget() {
        showUserChooseTextView = (TextView) findViewById(R.id.textView2);
        unit12ListView = (ListView) findViewById(R.id.listView);
        loadMoreButton = (Button) findViewById(R.id.button4);
    }

}   //Main Class
