package com.example.firebasedatatorecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class myadapter extends FirebaseRecyclerAdapter<model,myadapter.myViewholde>{
    public myadapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewholde holder, int position, @NonNull model model) {
     holder.name.setText(model.getName());
     holder.email.setText(model.getEmail());
     holder.course.setText(model.getCourse());
        Glide.with(holder.img.getContext()).load(model.purl).into(holder.img);

    }

    @NonNull
    @Override
    public myViewholde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row,parent,false);
        return new myViewholde(view);

    }

    class myViewholde extends RecyclerView.ViewHolder
    {
        CircleImageView img;
        TextView name,course,email;
        public myViewholde(@NonNull View itemView) {
            super(itemView);

            img=itemView.findViewById(R.id.image1);
            name=itemView.findViewById(R.id.nametext);
            course=itemView.findViewById(R.id.coursetext);
            email=itemView.findViewById(R.id.emailtext);

        }
    }
}
