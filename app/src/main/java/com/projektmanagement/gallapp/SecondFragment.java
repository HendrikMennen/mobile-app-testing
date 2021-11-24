package com.projektmanagement.gallapp;

import android.os.Build;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.projektmanagement.gallapp.databinding.FragmentSecondBinding;

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
        binding.textView2.setText("");

        binding.textView.setMovementMethod(new ScrollingMovementMethod());
        binding.textView2.setMovementMethod(new ScrollingMovementMethod());
        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {

                binding.textView.setText("");
                binding.textView2.setText("");
                int[] Arr = new int[1000];
                Random rand = new Random();
                for(int i = 0; i < 1000; i++){
                    Arr[i] = rand.nextInt(10000);
                }


                final long startTime = System.currentTimeMillis();

                //Unoptimized Bubble Sort
                for(int i = 0; i < Arr.length - 1; i++) {
                    for(int j = 0; j < Arr.length - 1; j++) {
                        // Vergleiche und swap die einträge wenn j > j+1
                        if(Arr[j] > Arr[j+1]){
                            int t = Arr[j];
                            Arr[j] = Arr[j+1];
                            Arr[j+1] = t;
                        }
                    }
                }



                binding.textView.setText("");
                String ergebnis = "";
                for(int i = 0; i < Arr.length; i++) {
                    ergebnis += Arr[i] + ", ";

                    binding.textView.setText(ergebnis);
                }


                final long endTime = System.currentTimeMillis();

                System.out.println("Unoptimized Time: " + (endTime - startTime));
                binding.Unoptimized.setText(Long.toString(endTime - startTime));

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Optimized Bubble Sort
                final long sTime = System.currentTimeMillis();
                int n = Arr.length - 1;
                boolean sorted = false;
                int zaehler = 0;

                while(!sorted) {
                    sorted = true;
                    for(int i = 0; i < n-zaehler; i++){
                        if(Arr[i] > Arr[i+1]){
                            int t = Arr[i];
                            Arr[i] = Arr[i+1];
                            Arr[i+1] = t;
                            sorted = false;
                            zaehler++;
                        }
                    }
                }


                for (int j = 0; j < n; j++) {
                    binding.textView2.append(Arr[j] + ", ");
                }

                final long eTime = System.currentTimeMillis();
                System.out.println((eTime - sTime));
                binding.Optimized.setText( Long.toString(eTime - sTime));



            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}