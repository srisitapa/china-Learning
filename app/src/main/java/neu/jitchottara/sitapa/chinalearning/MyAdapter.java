package neu.jitchottara.sitapa.chinalearning;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Dell on 3/3/2559.
 */
public class MyAdapter extends BaseAdapter{

    //Explicit
    private Context context;

    public MyAdapter(Context context, String[] titleStrings) {
        this.context = context;
        this.titleStrings = titleStrings;
    }

    private String[] titleStrings;

    @Override
    public int getCount() {
        return titleStrings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.my_listview, viewGroup, false);

        TextView titleTextView = (TextView) view1.findViewById(R.id.textView3);
        titleTextView.setText(titleStrings[i]);

        return view1;
    }
}   //Main Class
