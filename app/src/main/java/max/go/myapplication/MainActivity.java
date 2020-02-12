package max.go.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import max.go.myapplication.ui.fractal.FractalFragment;
import max.go.myapplication.ui.main.MainFragment;
import max.go.myapplication.ui.main.MainToolbarFragment;
import max.go.myapplication.ui.music.MusicFragment;

public class MainActivity extends AppCompatActivity {

    ImageButton [] buttonsFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        buttonsFragments = new ImageButton[]{
                findViewById(R.id.button_fragment_0),
                findViewById(R.id.button_fragment_1),
                findViewById(R.id.button_fragment_2),
                findViewById(R.id.button_fragment_3),
                findViewById(R.id.button_fragment_4)
        };

        if (savedInstanceState == null) {
            buildFragments(0);
        }else if(true){
            buildFragments(1);
        }
        for (int i = 0; i < buttonsFragments.length; i++) {
            buttonsFragments[i].setOnClickListener(buttonsFragmentsOnClickListener);
        }
    }

    private void buildFragments(int fragment_num){

        switch (fragment_num){
            case 0:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, MainFragment.newInstance())
                        .commitNow();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.toolbar, MainToolbarFragment.newInstance())
                        .commitNow();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, MusicFragment.newInstance())
                        .commitNow();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, FractalFragment.newInstance())
                        .commitNow();
                break;
            case 3:

                break;
            case 4:
                break;
        }
    }

    View.OnClickListener buttonsFragmentsOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.button_fragment_0:
                    buildFragments(0);
                    break;
                case R.id.button_fragment_1:
                    buildFragments(1);
                    break;
                case R.id.button_fragment_2:
                    buildFragments(2);
                    break;
                case R.id.button_fragment_3:
                    buildFragments(3);
                    break;
                case R.id.button_fragment_4:
                    buildFragments(4);
                    break;
            }
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
