package willy.willyframework.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * fragment的基类
 * Created by willy on 16/7/18.
 */
public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getViewId(),null,false);
    }

    /**
     * 获取fragment的layout id
     * @return  layout的id
     */
    protected abstract int getViewId();

    @SuppressWarnings("unchecked")
    protected <T extends View> T findViewById(int resId){
        return (T) getActivity().findViewById(resId);
    }

    /**
     * 跳转到其他fragment
     * @param fragment      需要跳转的fragment
     * @param replaceResId  替换的fragment的id
     */
    protected final void toFragment(Fragment fragment,int replaceResId){
        FragmentMrg.toFragment(getActivity(),fragment,replaceResId,true);
    }
}
