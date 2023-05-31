package br.edu.ifsuldeminas.mch.pizzaria;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText pizzaEditText;
    private Button addButton;
    private Button showButton;
    private TextView pizzaListTextView;

    private ArrayList<String> pizzaList;
    private StringBuilder pizzaListBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pizzaEditText = findViewById(R.id.pizzaEditText);
        addButton = findViewById(R.id.addButton);
        showButton = findViewById(R.id.showButton);
        pizzaListTextView = findViewById(R.id.pizzaListTextView);

        pizzaList = new ArrayList<>();
        pizzaListBuilder = new StringBuilder();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pizza = pizzaEditText.getText().toString();
                if (!pizza.isEmpty()) {
                    pizzaList.add(pizza);
                    pizzaListBuilder.append(pizza).append("\n");
                    pizzaEditText.setText("");
                }
            }
        });

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder pizzas = new StringBuilder();
                for (String pizza : pizzaList) {
                    pizzas.append(pizza).append("\n");
                }
                pizzaListTextView.setText(pizzas.toString());
            }
        });
    }
    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private List<String> dataList;

        public MyAdapter(List<String> dataList) {
            this.dataList = dataList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            String item = dataList.get(position);
            holder.textViewItem.setText(item);
        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView textViewItem;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                textViewItem = itemView.findViewById(R.id.textViewItem);
            }
        }
    }

}
