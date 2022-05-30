package com.java.firebasecrudapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CourseRVAdapter extends RecyclerView.Adapter<CourseRVAdapter.CourseRVViewHolder> {
    private ArrayList<CourseRVModel> courseRVModelArrayList;
    private Context context;
    int lastPos = -1;
    public CourseClickInterface courseClickInterface;

    public CourseRVAdapter(ArrayList<CourseRVModel> courseRVModelArrayList, Context context, CourseClickInterface courseClickInterface) {
        this.courseRVModelArrayList = courseRVModelArrayList;
        this.context = context;
        this.courseClickInterface = courseClickInterface;
    }

    @NonNull
    @Override
    public CourseRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.course_rv_item,parent,false);

        return new CourseRVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseRVViewHolder holder, int position) {
            CourseRVModel courseRVModel = courseRVModelArrayList.get(position);
            holder.courseNameTV.setText(courseRVModel.getCourseName());
            holder.coursePriceTV.setText("Rs. " + courseRVModel.getCoursePrice());
            setAnimation(holder.itemView,position);
        Picasso.get().load(courseRVModel.getCourseImg()).into(holder.courseIV);
        holder.itemView.setOnClickListener(v->{
            courseClickInterface.onCourseClick(position);
        });
    }

    private void setAnimation(View itemView, int position) {
        if(position>lastPos){
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            itemView.setAnimation(animation);
            lastPos = position;
        }
    }


    @Override
    public int getItemCount() {
        return courseRVModelArrayList.size();
    }

    class CourseRVViewHolder extends RecyclerView.ViewHolder {

        private TextView courseNameTV,coursePriceTV;
        private ImageView courseIV;

        public CourseRVViewHolder(@NonNull View itemView) {
            super(itemView);
            courseNameTV = itemView.findViewById(R.id.idTVCourseName);
            coursePriceTV = itemView.findViewById(R.id.idTVPrice);
            courseIV = itemView.findViewById(R.id.idIVCourse);

        }
    }

    public interface CourseClickInterface{
        void onCourseClick(int position);
    }
}
