package com.santous.fastadaptertest.flexible;

import android.view.View;
import android.widget.TextView;

import com.santous.fastadaptertest.R;

import java.util.List;
import java.util.Objects;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractHeaderItem;
import eu.davidea.viewholders.ExpandableViewHolder;


public class FDHeader extends AbstractHeaderItem<FDHeader.FDH_ViewHolder> {
    private long id;
    private String mTitle;

    public FDHeader(long id, String title) {
        super();
        this.id = id;
        this.mTitle = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FDHeader that = (FDHeader) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.header;
    }

    @Override
    public FDH_ViewHolder createViewHolder(View view, FlexibleAdapter adapter) {
        return new FDH_ViewHolder(view, adapter);
    }

    @Override
    public void bindViewHolder(FlexibleAdapter adapter, FDH_ViewHolder holder, int position, List payloads) {
        holder.tv_title.setText(mTitle);
    }

    static class FDH_ViewHolder extends ExpandableViewHolder {
        TextView tv_title;

        FDH_ViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter);
            tv_title = itemView.findViewById(R.id.tv_title);
        }
    }
}
