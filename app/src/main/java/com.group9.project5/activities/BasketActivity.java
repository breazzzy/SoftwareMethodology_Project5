package com.group9.project5.activities;

import android.app.AlertDialog;
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

import com.group9.project5.R;
import com.group9.project5.model.MenuItem;
import com.group9.project5.model.Order;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class BasketActivity extends AppCompatActivity {
    private ListView basketListView;
    private TextView txtSubtotal, txtTax, txtTotal;
    private Button placeOrderBTN;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basket_view);

        basketListView = (ListView) findViewById(R.id.ordersListView);
        txtSubtotal = (TextView) findViewById(R.id.txtSubTotal);
        txtTax = (TextView) findViewById(R.id.txtTax);
        txtTotal = (TextView) findViewById(R.id.txtTotal);
        placeOrderBTN = (Button) findViewById(R.id.placeOrderBTN);

        Log.d("ListView", basketListView.toString());
        ArrayList<String> strings = new ArrayList<>();

        loadTotals();

//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.item_view,R.id.,strings);
        BasketAdapter basket = new BasketAdapter(this);

//        for(MenuItem item : Order.getCurrentOrder().getMenuItems()){
//            strings.add(item.toString() + "\t\t\t$" + item.itemPrice());
//        }

        basketListView.setAdapter(basket);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        Context temp = this;
        placeOrderBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(basket.getCount() == 0){
                    //Order is empty
                    AlertDialog alert = builder.create();
                    alert.setTitle(R.string.empty_basket_error_title);
                    alert.show();
                    return;
                }
                Order.getCurrentOrder().FinalizeOrder();
                basket.notifyDataSetChanged();
                loadTotals();
                Toast toast = Toast.makeText(temp, "Order Finalized", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }

    protected void loadTotals(){
        double subtotal = 0;
        double total = 0;
        double tax = 0;

        for(MenuItem item : Order.getCurrentOrder().getMenuItems()){
//            strings.add(item.toString() + "\t\t\t$" + item.itemPrice());
            subtotal += item.itemPrice();
        }
        subtotal = Math.round((subtotal) * 100.0)/100.0;
        tax = Math.round((subtotal * MenuItem.TAX) * 100.0)/100.0;
        total = Math.round((subtotal + tax) * 100.0)/100.0;
        txtTax.setText(tax +"");
        txtTotal.setText(total +"");
        txtSubtotal.setText(subtotal +"");
    }

    private class BasketAdapter extends BaseAdapter{

        private Context context;

        public BasketAdapter(Context context){
            super();
            this.context = context;
        }

        @Override
        public int getCount() {
            return Order.getCurrentOrder().getMenuItems().size();
        }

        @Override
        public Object getItem(int position) {
            return Order.getCurrentOrder().getMenuItems().get(position);
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

            orderText.setText(Order.getCurrentOrder().getMenuItems().get(position).toString() + "\t\t\t$" + Order.getCurrentOrder().getMenuItems().get(position).itemPrice());
            removeBtn.setText("Remove");

            removeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Order.getCurrentOrder().remove(Order.getCurrentOrder().getMenuItems().get(position));
                    notifyDataSetChanged();
                    ((BasketActivity) context).loadTotals();
                    Toast toast = Toast.makeText(context,"Item removed", Toast.LENGTH_SHORT);
                    toast.show();
                }
            });

            return convertView;
        }
    }
}
