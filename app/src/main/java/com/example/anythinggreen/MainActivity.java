package com.example.anythinggreen;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.anythinggreen.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewPager2 = findViewById(R.id.view_pager2);

        // Disables swiping in ViewPager2
        viewPager2.setUserInputEnabled(false);

        // Set up transition between fragments on ViewPager2
        viewPager2.setPageTransformer(new FadePageTransformer());

        // Set up the ViewPager2 with FragmentStateAdapter MyFragmentStateAdapter
        viewPager2.setAdapter(new MyFragmentStateAdapter(this));

        // Implements bottomNavigationView using setOnItemSelectedListener
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    viewPager2.setCurrentItem(0);
                    return true;
                case R.id.information:
                    viewPager2.setCurrentItem(1);
                    return true;
                case R.id.rewards:
                    viewPager2.setCurrentItem(2);
                    return true;
                case R.id.settings:
                    viewPager2.setCurrentItem(3);
                    return true;
                default:
                    return false;
            }
        });
    }

    // Create an inner class for MyFragmentStateAdapter as FragmentStateAdapter to be set on viewPager2
    private static class MyFragmentStateAdapter extends FragmentStateAdapter {
        MyFragmentStateAdapter(FragmentActivity fragmentActivity){
            super(fragmentActivity);
        }

        @NonNull
        public Fragment createFragment(int position){
            switch (position){
                case 0:
                    return new HomeFragment();
                case 1:
                    return new InfoFragment();
                case 2:
                    return new RewardsFragment();
                case 3:
                    return new SettingsFragment();
                default:
                    throw new IllegalStateException("Invalid position: "+ position);
            }
        }

        public int getItemCount(){
            // Return the number of fragments
            return 4;
        }
    }

    // Implements the fade in and out transition between fragments in the ViewPager2
    private static class FadePageTransformer implements ViewPager2.PageTransformer {
        @Override
        public void transformPage(@NonNull View view, float position) {
            view.setAlpha(0f);
            view.setVisibility(View.VISIBLE);

            // Start Animation for a period of time
            view.animate()
                    .alpha(1f)
                    // Set duration in milliseconds
                    .setDuration(50);
        }
    }
}