package com.group9.project5.activities;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.group9.project5.R;
import com.group9.project5.model.Order;

import java.util.ArrayList;

public class OrdersActivity extends AppCompatActivity {
    private ListView ordersListView;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orders_view);

        ordersListView = (ListView) findViewById(R.id.ordersListView);
        ArrayList<String> strings = new ArrayList<String>();

        for (Order order : Order.FINALIZED_ORDERS){
            strings.add("Order# " + order.getOrderNumber() + " \t\t$" + order.getTotal());
        }

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.item_view,R.id.orderText,strings);

        OrdersAdapter adapter = new OrdersAdapter(this);

        ordersListView.setAdapter(adapter);
    }

    private class OrdersAdapter extends BaseAdapter {


        private Context context;

        public OrdersAdapter(Context context){
            super();
            this.context = context;
        }

        @Override
        public int getCount() {
            return Order.FINALIZED_ORDERS.size();
        }

        @Override
        public Object getItem(int position) {
            return Order.FINALIZED_ORDERS.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_view, parent, false);

            TextView orderText = (TextView) convertView.findViewById(R.id.orderText);
            Button removeBtn = (Button) convertView.findViewById(R.id.removeButtonView);

            orderText.setText(Order.FINALIZED_ORDERS.get(position).toString());

            View finalConvertView = convertView;
            removeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("Order#", (position+1) +" ");
                    int orderNum = Order.FINALIZED_ORDERS.get(position).getOrderNumber();
                    Order.FINALIZED_ORDERS.remove(Order.FINALIZED_ORDERS.get(position));
                    notifyDataSetChanged();
                    Toast toast = Toast.makeText(finalConvertView.getContext(),"Removed Order# " + orderNum,Toast.LENGTH_SHORT);
                    toast.show();
                }
            });

            return convertView;
        }
    }
}
