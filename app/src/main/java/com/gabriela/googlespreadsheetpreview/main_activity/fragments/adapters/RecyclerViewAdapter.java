package com.gabriela.googlespreadsheetpreview.main_activity.fragments.adapters;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.gabriela.googlespreadsheetpreview.R;
import com.gabriela.googlespreadsheetpreview.utils.TableUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Map<String, String> cellsAndData = new HashMap<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_element, parent, false);
        return new ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setHeaderAndParentColumn();
        holder.updateList();
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public void addData(Map<String, String> cellsAndData) {
        this.cellsAndData.clear();
        this.cellsAndData.putAll(cellsAndData);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tableLayout)
        TableLayout mTableLayout;

        @BindView(R.id.tableLayoutFixedHeader)
        TableLayout tableLayoutForHeader;

        @BindView(R.id.tableLayoutFixedParentColumn)
        TableLayout tableLayoutForParentColumn;


        @BindView(R.id.emptyTableLayout)
        TableLayout emptyTableLayout;

        @BindView(R.id.scrollView)
        ScrollView scrollView;

        @BindView(R.id.horizontalScrollView)
        HorizontalScrollView horizontalScrollView;

        char[] alphabet = "ABCDEFGHIJKLMNOPRSTUVZ".toCharArray();


        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
        private void setHeaderAndParentColumn() {
            tableLayoutForHeader.removeAllViews();
            tableLayoutForParentColumn.removeAllViews();
            mTableLayout.removeAllViews();
            emptyTableLayout.removeAllViews();

            emptyTableLayout.addView(TableUtils.getTextView("", R.drawable.empty_cell_shape, itemView.getContext()));

            TableRow row = new TableRow(itemView.getContext());
            row.setGravity(Gravity.CENTER);
            for (Character character : TableUtils.getAlphabetList(alphabet)) {
                row.addView(TableUtils.getTextView(String.valueOf(character), R.drawable.cell_shape_header, itemView.getContext()));
            }
            tableLayoutForHeader.addView(row);

            for (int i = 1; i < 31; i++) {
                TextView fixedView = TableUtils.getTextView(String.valueOf(i), R.drawable.cell_shape_header, itemView.getContext());
                fixedView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                fixedView.setBackgroundResource(R.drawable.cell_shape_header);
                tableLayoutForParentColumn.addView(fixedView);

                row = new TableRow(itemView.getContext());
                for (int j = 0; j < alphabet.length; j++) {
                    row.setGravity(Gravity.CENTER);
                    row.addView((TableUtils.getTextView("", R.drawable.cell_shape, itemView.getContext())));
                }
                mTableLayout.addView(row);
            }
        }

        private void updateList() {
            for (String key : cellsAndData.keySet()) {
                List<String> dividedKey = TableUtils.parse(key);
                for (int i = 1; i < 31; i++) {
                    for (char anAlphabet : alphabet) {
                        if (dividedKey.get(0).equals(String.valueOf(anAlphabet)) && dividedKey.get(1).equals(String.valueOf(i))) {
                            TableRow specificRow = (TableRow) mTableLayout.getChildAt(i - 1);
                            TextView specificTv = (TextView) specificRow.getChildAt(TableUtils.getPositionInArray(anAlphabet, alphabet));
                            specificTv.setText(cellsAndData.get(key));
                        }
                    }
                }
            }
        }
    }
}

