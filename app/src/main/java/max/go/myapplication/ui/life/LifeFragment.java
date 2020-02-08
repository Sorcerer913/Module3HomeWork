package max.go.myapplication.ui.life;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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

import max.go.myapplication.R;

public class LifeFragment extends Fragment {

    private LifeViewModel lViewModel;

    public static LifeFragment newInstance() {
        return new LifeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return new Surface(super.getContext());
        //return inflater.inflate( R.layout.life_fragment, container, false );
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lViewModel = ViewModelProviders.of(this).get(LifeViewModel.class);
        // TODO: Use the ViewModel
    }
}

class Surface extends SurfaceView implements SurfaceHolder.Callback {
    private float x = -1000;
    private float y = -1000;
    private int r;
    final String TAG = "TEST_SPACE";

    public Surface(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    public boolean onTouchEvent(MotionEvent event) {
        x = event.getX();
        y = event.getY();
        r = 0;
        Log.d(TAG, x + " " + y);
        return true;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        new drawThread(holder).start();

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
        Paint paint = new Paint();

        public drawThread(SurfaceHolder surfaceHolder) {
            this.surfaceHolder = surfaceHolder;
        }

        public void requestStop() {
            running = false;
        }

        @Override
        public void run() {
            while (running) {
                Canvas canvas = surfaceHolder.lockCanvas();
                if (canvas != null) {
                    x = canvas.getWidth()/2;
                    y = canvas.getHeight()/2;
                    r = canvas.getWidth()/2;
                    canvas.drawColor(Color.YELLOW);
                    paint.setColor(Color.YELLOW);
                    canvas.drawCircle(x, y, r, paint);
                    getHolder().unlockCanvasAndPost(canvas);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

                canvas = surfaceHolder.lockCanvas();
                if (canvas != null) {
                    x = canvas.getWidth()/2;
                    y = canvas.getHeight()/2;
                    r = canvas.getWidth()/2;
                    canvas.drawColor(Color.YELLOW);
                    paint.setColor(Color.RED);
                    canvas.drawCircle(x, y, r, paint);
                    getHolder().unlockCanvasAndPost(canvas);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

