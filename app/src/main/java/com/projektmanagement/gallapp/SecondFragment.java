package com.projektmanagement.gallapp;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.projektmanagement.gallapp.databinding.FragmentSecondBinding;

import java.lang.reflect.Array;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.textView.setText("");

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {

                binding.textView.setText("");
                int[] Arr = new int[10000];
                Random rand = new Random();
                for(int i = 0; i < 10000; i++){
                    Arr[i] = rand.nextInt(10000);
                }
                binding.textView.setText("Numbers generated");


                //Normal Bubble Sort
                final long startTime = System.currentTimeMillis();

                for(int i = 0; i < Arr.length - 1; i++) {
                    for(int j = 0; j < Arr.length - 1; j++) {
                        // Comparing and swapping the elements
                        if(Arr[j] > Arr[j+1]){
                            int t = Arr[j];
                            Arr[j] = Arr[j+1];
                            Arr[j+1] = t;
                        }
                    }
                }



                binding.textView.setText("");
//                for(int i = 0; i < Arr.length; i++) {
//                    binding.textView.append(Integer.toString(Arr[i]) + ", ");
//                }

                final long endTime = System.currentTimeMillis();

                System.out.println("Time: " + (endTime - startTime));


                final long sTime = System.currentTimeMillis();
                int n = Arr.length - 1;
                boolean sorted = false;
                int numOfIterations = 0;

                while(!sorted) {
                    sorted = true;
                    for(int i = 0; i < n-numOfIterations; i++){
                        if(Arr[i] > Arr[i+1]){
                            int t = Arr[i];
                            Arr[i] = Arr[i+1];
                            Arr[i+1] = t;
                            sorted = false;
                            numOfIterations++;
                        }
                    }
                }

                binding.textView.setText("");
//                for(int i = 0; i < Arr.length; i++) {
//                    binding.textView.append(Integer.toString(Arr[i]) + ", ");
//                }

                final long eTime = System.currentTimeMillis();
                System.out.println("Time: " + (eTime - sTime));

                // binding.textView.setText(Arr.toString());

                /*LocalDate date = LocalDate.now();
                DayOfWeek Day = date.getDayOfWeek();
                new ArrayList<>();
                String[] Days = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
                binding.textView.setText("");

                for(int i = 0; i<200000; i++){
                    int a = 0;
                    a += i;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(int i = 0; i < Days.length ;i++) {
                    try {

                         if (Day.toString().equalsIgnoreCase(Days[i])) {
                             binding.textView.setText(Days[i]);
                        } else {
                        }
                    } catch(Exception e){
                        break;
                    }
                }
*/
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}