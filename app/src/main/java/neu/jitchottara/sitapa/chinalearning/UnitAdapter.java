package neu.jitchottara.sitapa.chinalearning;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Dell on 4/3/2559.
 */
public class UnitAdapter extends BaseAdapter{

    //Explicit
    private Context context;
    private String[] iconStrings, titleStrings;

    public UnitAdapter(Context context, String[] iconStrings, String[] titleStrings) {
        this.context = context;
        this.iconStrings = iconStrings;
        this.titleStrings = titleStrings;
    }   //Constructor

    @Override
    public int getCount() {
        return iconStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.unit_listview, viewGroup, false);

        ImageView iconImageView = (ImageView) view1.findViewById(R.id.imageView);
        Picasso.with(context).load(iconStrings[i]).resize(130, 130).into(iconImageView);

        TextView titletextView = (TextView) view1.findViewById(R.id.textView6);
        titletextView.setText(titleStrings[i]);

        return view1;
    }
}   //Main Class
