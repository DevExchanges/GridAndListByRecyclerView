package info.devexchanges.gridlistrecyclerview.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import info.devexchanges.gridlistrecyclerview.R;
import info.devexchanges.gridlistrecyclerview.RecyclerViewItem;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.ViewHolder> {
    private Activity activity;
    private List<RecyclerViewItem> items;

    public ListViewAdapter(Activity activity, List<RecyclerViewItem> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.item_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.imageView.setImageResource(items.get(position).getDrawableId());
        viewHolder.textView.setText(items.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    /**
     * View holder to display each RecylerView item
     */
    protected class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public ViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.image);
            textView = (TextView)view.findViewById(R.id.text);
        }

    }
}
