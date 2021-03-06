package max.go.myapplication.ui.fractal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

public class FractalFragment extends Fragment {

    private FractalViewModel fractalViewModel;

    public static FractalFragment newInstance() {
        return new FractalFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return new SurfaceFractal(super.getContext());
        //return inflater.inflate( R.layout.life_fragment, container, false );
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fractalViewModel = ViewModelProviders.of(this).get(FractalViewModel.class);
        // TODO: Use the ViewModel
    }
}

class SurfaceFractal extends SurfaceView implements SurfaceHolder.Callback {
    final String TAG = "TEST_SPACE";

    public SurfaceFractal(Context context) {
        super(context);
        getHolder().addCallback(this);
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        new max.go.myapplication.ui.fractal.SurfaceFractal.drawThread(holder).start();

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    class drawThread extends Thread {
        private SurfaceHolder surfaceHolder;
        private volatile boolean running = true;
        Paint paint1 = new Paint();
        Paint paint2 = new Paint();

        public drawThread(SurfaceHolder surfaceHolder) {
            this.surfaceHolder = surfaceHolder;
        }

        public void requestStop() {
            running = false;
        }

        @Override
        public void run() {
            Canvas canvas = surfaceHolder.lockCanvas();
            if (canvas != null) {

                Cellular cellular = new Cellular(canvas.getWidth(), canvas.getHeight(), 18);
                int [][] matrix = cellular.getArray();

                canvas.drawColor(Color.WHITE);
                paint1.setColor(Color.BLACK);
                paint2.setColor(Color.WHITE);

                for (int i = 0; i < canvas.getWidth(); i++) {       //making white background
                    for (int j = 0; j < canvas.getHeight(); j++) {
                        if(matrix[j][i] == 1){
                            canvas.drawPoint(i, j, paint1);
                        }/*else{
                            canvas.drawPoint(i, j, paint2);
                        }*/

                    }
                }

                getHolder().unlockCanvasAndPost(canvas);

            }
        }
    }
}

