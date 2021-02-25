package willy.willyframework.base.recyclerview;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * recyclerView的二次封装adapter,封装了一些基础的点击功能
 * Created by willy on 16/7/19.
 */
public abstract class BaseRecyclerViewAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public void onBindViewHolder(final VH holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = holder.getAdapterPosition();
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(v, pos);
                }
            }
        });
    }
}
