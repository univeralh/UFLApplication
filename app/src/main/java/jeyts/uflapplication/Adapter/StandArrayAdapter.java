package jeyts.uflapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import jeyts.uflapplication.R;
import jeyts.uflapplication.Model.MyDataModel;

import java.util.List;

public class StandArrayAdapter extends ArrayAdapter<MyDataModel> {

    List<MyDataModel> modelList;
    Context context;
    private LayoutInflater mInflater;

    // Constructors
    public StandArrayAdapter(Context context, List<MyDataModel> objects) {
        super(context, 0, objects);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        modelList = objects;
    }

    @Override
    public MyDataModel getItem(int position) {
        return modelList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if (convertView == null) {
            View view = mInflater.inflate(R.layout.layout2_row_view, parent, false);
            vh = ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        MyDataModel item = getItem(position);

        vh.textViewTeamStand.setText(item.getTeamStand());
        vh.textViewStandScore.setText(item.getStandScore());




        return vh.rootView;
    }

    /**
     * ViewHolder class for layout.<br />
     * <br />
     * Auto-created on 2016-01-05 00:50:26 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private static class ViewHolder {
        public final RelativeLayout rootView;

        public final TextView textViewTeamStand;
        public final TextView textViewStandScore;

        private ViewHolder(RelativeLayout rootView, TextView textViewTeamStand, TextView textViewStandScore) {
            this.rootView = rootView;
            this.textViewTeamStand = textViewTeamStand;
            this.textViewStandScore = textViewStandScore;
        }

        public static ViewHolder create(RelativeLayout rootView) {
            TextView textViewTeamStand = (TextView) rootView.findViewById(R.id.textViewStandings);
            TextView textViewStandScore = (TextView) rootView.findViewById(R.id.textViewScore);
//            TextView textViewCompletions = (TextView) rootView.findViewById(R.id.textViewCompletions);



            return new ViewHolder(rootView, textViewTeamStand, textViewStandScore);
        }
    }
}