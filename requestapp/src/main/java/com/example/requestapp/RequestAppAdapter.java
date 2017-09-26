package com.example.requestapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 9/26/2017.
 */

public class RequestAppAdapter extends RecyclerView.Adapter<RequestAppAdapter.ViewHolder> {

    RecyclerView rvCelebList;
    private RequestAppAdapter.OnViewHolderInteractionListener mListener;
    private static final String TAG = "RecyclerViewAdapterCeleb";
    List<ContactObj> carList = new ArrayList<>();
    Context context;

    public RequestAppAdapter( List<ContactObj> carList) {

        this.carList = carList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvName ;
        private TextView tvPhone ;




        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvPhone= itemView.findViewById(R.id.tvPhone);


        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //    Log.d(TAG, "onCreateViewHolder: ");
        context = parent.getContext();
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.rv_car_item, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        //  Log.d(TAG, "onBindViewHolder position: "+position);
        ContactObj car = carList.get(position);

        holder.tvName.setText(car.getName());
        holder.tvPhone.setText(car.getPhone());



/*
        holder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListener != null) {
                    //  Toast.makeText(context, position+"" , Toast.LENGTH_SHORT).show();
                    mListener.onViewHolderInteraction(String.valueOf(position));
                }
                //  Toast.makeText(context, "click" , Toast.LENGTH_SHORT).show();
            }
        });
*/




    }

    @Override
    public int getItemCount() {

        return carList.size();
    }

    //Dismiss
    public void dismissCar(int pos) {
        this.carList.remove(pos);
        this.notifyItemRemoved(pos);
    }


    public interface OnViewHolderInteractionListener {
        void onViewHolderInteraction(String data);
    }

    public void setListener(RequestAppAdapter.OnViewHolderInteractionListener listener) {
        this.mListener = listener;
    }

}
