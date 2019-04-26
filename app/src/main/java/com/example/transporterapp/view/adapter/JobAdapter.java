package com.example.transporterapp.view.adapter;


import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.example.transporterapp.R;
import com.example.transporterapp.model.Job;
import com.example.transporterapp.view.callback.JobClickCallback;
import java.util.List;
import java.util.Objects;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.JobViewHolder> {

  List<? extends Job> jobList;

  @Nullable
  private final JobClickCallback jobClickCallback;

  public JobAdapter(@Nullable JobClickCallback jobClickCallback) {
    this.jobClickCallback = jobClickCallback;
  }

  public void setJobList(final List<? extends Job> jobList) {
    if (this.jobList == null) {
      this.jobList = jobList;
      notifyItemRangeInserted(0, jobList.size());
    } else {
      DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
        @Override
        public int getOldListSize() {
          return JobAdapter.this.jobList.size();
        }

        @Override
        public int getNewListSize() {
          return jobList.size();
        }

        @Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
          return JobAdapter.this.jobList.get(oldItemPosition).getId() ==
              jobList.get(newItemPosition).getId();
        }

        @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
          Job job = jobList.get(newItemPosition);
          Job old = jobList.get(oldItemPosition);
          return (job.getId() == old.getId());
        }
      });
      this.jobList = jobList;
      result.dispatchUpdatesTo(this);
    }
  }

  @Override
  public JobViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    ProjectListItemBinding binding = DataBindingUtil
        .inflate(LayoutInflater.from(parent.getContext()), R.layout.project_list_item,
            parent, false);

    binding.setCallback(projectClickCallback);

    return new ProjectViewHolder(binding);
  }

  @Override
  public void onBindViewHolder(ProjectViewHolder holder, int position) {
    holder.binding.setProject(projectList.get(position));
    holder.binding.executePendingBindings();
  }

  @Override
  public int getItemCount() {
    return projectList == null ? 0 : projectList.size();
  }

  static class ProjectViewHolder extends RecyclerView.ViewHolder {

    final ProjectListItemBinding binding;

    public ProjectViewHolder(ProjectListItemBinding binding) {
      super(binding.getRoot());
      this.binding = binding;
    }
  }
}
