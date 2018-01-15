package com.santous.fastadaptertest.flexible;

import android.view.View;
import android.widget.TextView;

import com.santous.fastadaptertest.R;

import java.util.List;
import java.util.Objects;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;
import eu.davidea.viewholders.FlexibleViewHolder;

/**
 * Created by Steven on 2018/1/5.
 */

public class FDSubItem extends AbstractFlexibleItem<FDSubItem.ESI_ViewHolder> {
    private long id;
    private String description;

    public FDSubItem(long id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FDSubItem that = (FDSubItem) o;
        return id == that.id &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.expandable_sub_item;
    }

    @Override
    public ESI_ViewHolder createViewHolder(View view, FlexibleAdapter adapter) {
        return new ESI_ViewHolder(view, adapter);
    }

    @Override
    public void bindViewHolder(FlexibleAdapter adapter, ESI_ViewHolder holder, int position, List payloads) {
        holder.tv_description.setText(description);
    }

    static class ESI_ViewHolder extends FlexibleViewHolder {
        private TextView tv_description;

        ESI_ViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter);
            tv_description = view.findViewById(R.id.tv_message);
        }
    }
}
