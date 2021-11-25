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

                int[] Arr = new int[20000];
                Random rand = new Random();
                for (int i = 0; i < 20000; i++) {
                    Arr[i] = rand.nextInt(50000);
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                final long sTime = System.currentTimeMillis();
                OBS(Arr, binding);
                final long eTime = System.currentTimeMillis();
                System.out.println("Optimized: " + (eTime - sTime));
                binding.Optimized.setText(Long.toString(eTime - sTime));

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final long startTime = System.currentTimeMillis();
                UBS(Arr, binding);
                final long endTime = System.currentTimeMillis();

                System.out.println("Unoptimized Time: " + (endTime - startTime));
                binding.Unoptimized.setText(Long.toString(endTime - startTime));

            }});
    }

    private void UBS(int[] Arr, FragmentSecondBinding binding) {

        //Unoptimized Bubble Sort
            for (int j = 0; j < Arr.length - 1; j++) {
                // Vergleiche und swap die einträge wenn j > j+1
                if (Arr[j] > Arr[j + 1]) {
                    int t = Arr[j];
                    Arr[j] = Arr[j + 1];
                    Arr[j + 1] = t;
                }
        }


        binding.textView.setText("");
        String ergebnis = "";
        for (int i = 0; i < Arr.length; i++) {
            ergebnis += Arr[i] + ", ";

        }
        // binding.textView.setText(ergebnis);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public static void OBS(int[] Arr, FragmentSecondBinding binding){
        // Optimized Bubble Sort

        StringBuilder s = new StringBuilder();
        int n = Arr.length;

        for (int i = 1; i < n - 1; i++) {
            boolean sorted = true;
            // skip the already sorted largest elements
            for (int j = 0; j < n - 1 ; j++) {
                if (Arr[j] > Arr[j + 1]) {
                    int temp = Arr[j];
                    Arr[j] = Arr[j + 1];
                    Arr[j + 1] = temp;
                    sorted = false;
                }
            }
            if (sorted)
                break;
        }


        for (int j = 0; j < n; j++) {
            s.append(Arr[j] + ",");
        }




        // binding.textView2.setText(s);




    }

}