package max.go.myapplication.ui.life;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import max.go.myapplication.R;

public class LifeToolbarFragment extends Fragment {

    private LifeViewModel lViewModel;

    public static max.go.myapplication.ui.main.MainToolbarFragment newInstance() {
        return new max.go.myapplication.ui.main.MainToolbarFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.life_toolbar_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lViewModel = ViewModelProviders.of(this).get(LifeViewModel.class);
        // TODO: Use the ViewModel
    }
}
