package com.example.batch2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * WordListAdapter intermediary b/w data and list item
 */
public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    LayoutInflater mInflater;
    LinkedList<String> mWordList;
    WordListAdapter mAdapter;

    public WordListAdapter(Context context,LinkedList<String> wordList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
    }

    /**
     * this method will create a view holder[wooden plank]
     * @param viewGroup
     * @param i
     * @return
     */
    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {//viewgroup/parent -- which holds all the wooden plank
        View mItemView = mInflater.inflate(
                R.layout.list_row_layout, viewGroup, false);
        return new WordViewHolder(mItemView, this);
    }

    /**
     * bind the data with the viewholder[wooden plank]
     * @param wordViewHolder
     * @param i
     */
    @Override
    public void onBindViewHolder(@NonNull WordViewHolder wordViewHolder, int position) {
        // Retrieve the data for that position
        String mCurrent = mWordList.get(position);
        // Add the data to the view
        wordViewHolder.wordItemView.setText(mCurrent);


    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }


    /**
     * it represents one row in the recycler view -- [one wooden plank]
     */
    public class WordViewHolder extends RecyclerView.ViewHolder // WordViewHolder = one wooden plan
            implements View.OnClickListener {

        private final WordListAdapter mAdapter;
        TextView wordItemView;


        public WordViewHolder(View mItemView, WordListAdapter wordListAdapter) {
            super(mItemView);
            // Get the layout
            wordItemView = (TextView) itemView.findViewById(R.id.mytextView);
            // Associate with this adapter
            this.mAdapter = wordListAdapter;
            // Add click listener, if desired
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

        }
    }
}
