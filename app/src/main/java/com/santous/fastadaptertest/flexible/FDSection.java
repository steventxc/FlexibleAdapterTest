package com.santous.fastadaptertest.flexible;

import android.view.View;
import android.widget.TextView;

import com.santous.fastadaptertest.R;

import java.util.List;
import java.util.Objects;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractExpandableItem;
import eu.davidea.flexibleadapter.items.ISectionable;
import eu.davidea.viewholders.ExpandableViewHolder;

/**
 * Created by Steven on 2018/1/5.
 */

public class FDSection extends AbstractExpandableItem<FDSection.ES_ViewHolder, FDSubItem>
        implements ISectionable<FDSection.ES_ViewHolder, FDHeader> {
    private FDHeader header;
    private String userName;
    private String suggestion;

    public FDSection(FDHeader header, String userName) {
        this.header = header;
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FDSection section = (FDSection) o;
        return Objects.equals(userName, section.userName) &&
                Objects.equals(suggestion, section.suggestion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, suggestion);
    }

    @Override
    public FDHeader getHeader() {
        return header;
    }

    @Override
    public void setHeader(FDHeader header) {
        this.header = header;
    }

    @Override
    public int getExpansionLevel() {
        // level 1 级的可以通过点击展开折叠
        return 1;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.expandable_section;
    }

    @Override
    public ES_ViewHolder createViewHolder(View view, FlexibleAdapter adapter) {
        return new ES_ViewHolder(view, adapter);
    }

    @Override
    public void bindViewHolder(FlexibleAdapter adapter, ES_ViewHolder holder, int position, List payloads) {
        holder.tv_userName.setText(userName);
        holder.tv_suggestion.setText(suggestion);
    }

    static class ES_ViewHolder extends ExpandableViewHolder {
        private TextView tv_userName;
        private TextView tv_suggestion;

        ES_ViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter);
            mAdapter.invalidateItemDecorations(100);
            tv_userName = view.findViewById(R.id.tv_user_name);
            tv_suggestion = view.findViewById(R.id.tv_eatable);
        }

        @Override
        protected boolean shouldNotifyParentOnClick() {
            // 每次 展开/关闭 的时候都会获得相应的事件
            return true;
        }

        @Override
        protected void expandView(int position) {
            super.expandView(position);
            mAdapter.invalidateItemDecorations(100);
        }
    }

}
