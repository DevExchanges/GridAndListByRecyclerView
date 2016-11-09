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

public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.ViewHolder> {
    private List<RecyclerViewItem> items;
    private Activity activity;

    public GridViewAdapter(Activity activity, List<RecyclerViewItem> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.item_grid, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GridViewAdapter.ViewHolder viewHolder, int position) {
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
            textView = (TextView)view.findViewById(R.id.text);
            imageView = (ImageView) view.findViewById(R.id.image);
        }
    }
}
