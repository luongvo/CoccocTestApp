package com.coccoc.coccoctestapp.ui.main;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.databinding.library.baseAdapters.BR;
import com.coccoc.coccoctestapp.R;
import com.coccoc.coccoctestapp.models.Movie;

import java.util.List;

/**
 * Created by luongvo on 1/20/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private List<Movie> mMovies;

    class ViewHolder extends RecyclerView.ViewHolder {

        private ViewDataBinding binding;

        private ViewHolder(View view) {
            super(view);
            binding = DataBindingUtil.bind(view);
        }

        public ViewDataBinding getBinding() {
            return binding;
        }
    }

    public MovieAdapter(List<Movie> movies) {
        mMovies = movies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item_movie, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Movie movie = mMovies.get(position);
        holder.getBinding().setVariable(BR.movie, movie);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mMovies != null ? mMovies.size() : 0;
    }
}
