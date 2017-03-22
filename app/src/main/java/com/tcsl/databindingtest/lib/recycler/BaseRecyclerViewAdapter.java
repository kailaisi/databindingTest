package com.tcsl.databindingtest.lib.recycler;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tcsl.databindingtest.recyclerview.RequestLoadMoreListener;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import static android.support.v7.widget.RecyclerView.NO_POSITION;

/**
 * 描述:基类适配器，可以设置头，尾和空布局
 * <p/>作者：wjx
 * <p/>创建时间: 2017/2/23 13:18
 */
public abstract class BaseRecyclerViewAdapter<T, K extends BaseViewHolder> extends RecyclerView.Adapter<K> {

    private static int ITEM_TYPE_HEADER = 0x00000111;
    private static int ITEM_TYPE_LOAD_MORE = 0x00000222;
    private static int ITEM_TYPE_FOOTER = 0x00000333;
    private static int ITEM_TYPE_EMPTY = 0x00000555;
    private View headView;
    private View footView;
    private View emptyView;
    protected Context mContext;
    protected final LayoutInflater mLayoutInflater;
    /**
     * 数据
     */
    protected List<T> mDatas;
    /**
     * 加载更多的动画
     */
    private LoadMoreView mLoadMoreView = new SimpleLoadMore();
    /**
     * 发起请求更多
     */
    private RequestLoadMoreListener mLoadMoreListener;
    /**
     * 是否正在加载数据
     */
    private boolean mLoading = false;
    /**
     * 是否允许加载更多数据
     */
    private boolean mNextLoadEnable = false;
    /**
     * 允许加载更多的状态。
     */
    private boolean mLoadMoreEnable = false;
    /**
     * whether use empty view
     */
    private boolean isUseEmpty = true;
    /**
     * when size is small than this, don`t load more
     */
    private int mAutoLoadMoreSize = 1;


    public void setOnItemClickListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

    public OnItemClickListener getmListener() {
        return mListener;
    }

    public void setItemClickListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

    OnItemClickListener mListener;

    public BaseRecyclerViewAdapter(Context context, List<T> mDatas) {
        mContext = context;
        this.mDatas = mDatas;
        this.mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public K onCreateViewHolder(ViewGroup parent, int viewType) {

        K holder = null;
        if (viewType == ITEM_TYPE_HEADER) {
            holder = createBaseViewHolder(headView);
        } else if (viewType == ITEM_TYPE_EMPTY) {
            holder = createBaseViewHolder(emptyView);
        } else if (viewType == ITEM_TYPE_FOOTER) {
            holder = createBaseViewHolder(footView);
        } else if (viewType == ITEM_TYPE_LOAD_MORE) {
            holder = getLoadingView(parent);
        } else {
            holder = onCreateDefViewHolder(parent, viewType);
        }
        return holder;
    }

    private K getLoadingView(ViewGroup parent) {
        View view = getItemView(mLoadMoreView.getLayoutId(), parent);
        K holder = createBaseViewHolder(view);
        holder.getItemView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLoadMoreView.getLoadMoreStatus() == LoadMoreView.STATUS_FAIL) {
                    mLoadMoreView.setLoadMoreStatus(LoadMoreView.STATUS_DEFAULT);
                    notifyItemChanged(getHeadViewCount() + mDatas.size() + getFootViewCount());
                }
            }
        });
        return holder;
    }

    protected K onCreateDefViewHolder(ViewGroup parent, int viewType) {
        return createBaseViewHolder(parent, getItemLayout());
    }

    protected K createBaseViewHolder(ViewGroup parent, int layoutResId) {
        return createBaseViewHolder(getItemView(layoutResId, parent));
    }

    /**
     * 如果是子类的话，必须通过反射机制进行对象的实例化
     *
     * @param view
     * @return
     */
    private K createBaseViewHolder(final View view) {
        ParameterizedType pType = (ParameterizedType) getClass().getGenericSuperclass();//获取当前new的对象的父类的类型
        Class<K> z = (Class<K>) pType.getActualTypeArguments()[1];//获取实际的类型
        Constructor constructor;
        final BaseViewHolder baseViewHolder = new BaseViewHolder(view);
        try {
            String buffer = Modifier.toString(z.getModifiers());
            String className = z.getName();
            if (className.contains("$") && !buffer.contains("static")) {
                constructor = z.getDeclaredConstructor(getClass(), View.class);
                return (K) constructor.newInstance(this, view);
            } else {
                constructor = z.getDeclaredConstructor(View.class);
                return (K) constructor.newInstance(view);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return (K) baseViewHolder;
    }

    protected View getItemView(int layoutResId, ViewGroup parent) {
        View view = mLayoutInflater.inflate(layoutResId, parent, false);
        return view;
    }

    /**
     * 获取实际位置，去除掉head
     *
     * @param position
     * @return
     */
    public int getRealPosition(int position) {
        if (null != headView) {
            return position - 1;
        }
        return position;
    }

    /**
     * 获取布局
     *
     * @return
     */
    public abstract int getItemLayout();

    @Override
    public void onBindViewHolder(final K holder, int position) {
        K viewHolder = holder;
        int type = getItemViewType(position);
        if (type == ITEM_TYPE_HEADER || type == ITEM_TYPE_EMPTY || type == ITEM_TYPE_FOOTER) {
            return;
        }
        if (type == ITEM_TYPE_LOAD_MORE) {
            mLoadMoreView.convert(holder);
            return;
        }
        int realPosition = holder.getLayoutPosition() - getHeadViewCount();
        T t = mDatas.get(realPosition);
        if (mListener != null) {
            holder.getItemView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position1 = holder.getLayoutPosition();
                    if (position1 != NO_POSITION) {
                        mListener.onItemClick(holder.getItemView(), holder.getLayoutPosition() - getHeadViewCount());
                    }
                }
            });
        }
        convert(viewHolder, t);
    }

    protected abstract void convert(K viewHolder, T t);

    @Override
    public int getItemCount() {
        int itemCount = mDatas == null ? 0 : mDatas.size();
        return itemCount + getHeadViewCount() + getFootViewCount() + getLoadMoreViewCount() + getEmptyViewCount();
    }

    /**
     * emptyview count
     *
     * @return if show empty view return 1,else return 0
     */
    private int getEmptyViewCount() {
        if (emptyView == null) {
            return 0;
        }
        if (!isUseEmpty) {
            return 0;
        }
        if (mDatas.size() != 0) {
            return 0;
        }
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (getEmptyViewCount()!=0 && mDatas.size() == 0) {
            return ITEM_TYPE_EMPTY;
        }
        if (position<getHeadViewCount()) {
            return ITEM_TYPE_HEADER;
        }
        if (getFootViewCount()!=0 && position == getItemCount() - getHeadViewCount() - getLoadMoreViewCount()) {
            return ITEM_TYPE_FOOTER;
        }
        autoLoadMore(position);
        if (getLoadMoreViewCount() != 0 && position == getItemCount() - 1) {
            return ITEM_TYPE_LOAD_MORE;
        }
        return getDefaultItemViewType(getRealPosition(position));
    }

    /**
     * load relay on postion,
     *
     * @param position
     */
    private void autoLoadMore(int position) {
        if (getLoadMoreViewCount() == 0) {
            return;
        }
        if (position < getItemCount() - mAutoLoadMoreSize) {
            return;
        }
        if (mLoadMoreView.getLoadMoreStatus() != LoadMoreView.STATUS_DEFAULT) {
            return;
        }
        mLoadMoreView.setLoadMoreStatus(LoadMoreView.STATUS_LOADING);
        if (!mLoading) {
            mLoading = true;
            mLoadMoreListener.onLoadMoreRequest();
        }
    }

    /**
     * 根据位置获取viewType，如果是多条目，子类可以覆写该类
     *
     * @param position
     * @return
     */
    protected int getDefaultItemViewType(int position) {
        return super.getItemViewType(position);
    }

    /**
     * 增加headview
     *
     * @param headView
     */
    public void addHeadView(View headView) {
        this.headView = headView;
        notifyItemInserted(0);
    }

    /**
     * 增加footview
     *
     * @param footView
     */
    public void addFootView(View footView) {
        this.footView = footView;
        notifyItemInserted(getItemCount() - 1);
    }

    /**
     * 设置数据为空的时候，显示的view
     *
     * @param emptyView
     */
    public void setEmptyView(View emptyView) {
        isUseEmpty = true;
        boolean inSert = false;
        if (this.emptyView != null) {
            inSert = true;
        }
        this.emptyView = emptyView;
        if (inSert && getEmptyViewCount() == 1) {
            int position = getHeadViewCount();
            notifyItemInserted(position);
        }
    }

    @Override
    public void onViewAttachedToWindow(K holder) {
        //http://blog.csdn.net/qibin0506/article/details/49716795
        super.onViewAttachedToWindow(holder);
        int viewType = holder.getItemViewType();
        if (viewType == ITEM_TYPE_FOOTER || viewType == ITEM_TYPE_HEADER || viewType == ITEM_TYPE_LOAD_MORE) {
            setFullPan(holder);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) manager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    int viewType = getItemViewType(position);
                    if (viewType == ITEM_TYPE_FOOTER || viewType == ITEM_TYPE_HEADER || viewType == ITEM_TYPE_LOAD_MORE) {
                        //如果是表头或者底部，则占据的行数为gridlayout的行数
                        return gridLayoutManager.getSpanCount();
                    }
                    return 1;
                }
            });
        }
    }

    /**
     * 如果是表头或者底部栏，并且是纵向显示，则占据一行
     *
     * @param holder
     */
    private void setFullPan(K holder) {
        ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
        if (params != null && params instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) params).setFullSpan(true);
        }
    }

    /**
     * 设置加载更多时的动画，继承
     */
    public void setLoadMoreView(LoadMoreView view) {
        this.mLoadMoreView = view;
    }

    /**
     * 获取加载更多所占据的数量
     *
     * @return
     */
    private int getLoadMoreViewCount() {
        if (mLoadMoreListener == null || !mLoadMoreEnable) {//don`t have the function
            return 0;
        }
        if (!mNextLoadEnable && mLoadMoreView.getLoadMoreStatus() == LoadMoreView.STATUS_END) {//load is over
            return 0;
        }
        if (mDatas.size() == 0) {//has no data
            return 0;
        }
        return 1;
    }

    /**
     * 设置监听
     *
     * @param loadMoreListener
     */
    public void setLoadMoreListener(RequestLoadMoreListener loadMoreListener) {
        this.mLoadMoreListener = loadMoreListener;
        mLoadMoreEnable = true;
        mNextLoadEnable = true;
        mLoading = false;
    }

    /**
     * 加载更多功能是否关闭，当根据页面进行加载的时候，如果当前加载的数据少于每页的长度，则表示，数据已经全部加载完成，不再需要进行加载更多的操作
     *
     * @param end
     */
    public void loadMoreEnd(boolean end) {
        if (getLoadMoreViewCount() == 0) {
            return;
        }
        mLoading = false;
        mNextLoadEnable = false;
        if (end) {//不再显示加载更多的图标和数据
            notifyItemRemoved(mDatas.size() + getFootViewCount() + getHeadViewCount());
        } else {
            mLoadMoreView.setLoadMoreStatus(LoadMoreView.STATUS_END);
            notifyItemChanged(mDatas.size() + getFootViewCount() + getHeadViewCount());
        }
    }

    /**
     * 数据加载更多成功
     */
    public void loadMoreComplete() {
        if (getLoadMoreViewCount() == 0) {
            return;
        }
        mLoading = false;
        mLoadMoreView.setLoadMoreStatus(LoadMoreView.STATUS_DEFAULT);
        notifyItemChanged(getHeadViewCount() + getFootViewCount() + mDatas.size());
    }

    /**
     * 数据加载更多失败
     */
    public void loadMoreFail() {
        if (getLoadMoreViewCount() == 0) {
            return;
        }
        mLoading = false;
        mLoadMoreView.setLoadMoreStatus(LoadMoreView.STATUS_FAIL);
        notifyItemChanged(getHeadViewCount() + mDatas.size() + getFootViewCount());
    }

    /**
     * Set the enable status of load more.eg:when pull to refresh ,loadmore is not enabled.
     *
     * @param enable true if more is enable ,false is not enable
     */
    public void setEnableLoadMore(boolean enable) {
        int oldCount = getLoadMoreViewCount();
        mLoadMoreEnable = enable;
        int newCount = getLoadMoreViewCount();
        if (newCount == 1 && oldCount == 0) {//not enable->enable
            mLoadMoreView.setLoadMoreStatus(LoadMoreView.STATUS_DEFAULT);
            notifyItemInserted(getHeadViewCount() + getFootViewCount() + mDatas.size());
        }
        if (newCount == 0 && oldCount == 1) {//enable ->not enable
            notifyItemRemoved(getHeadViewCount() + getFootViewCount() + mDatas.size());
        }

    }

    private int getFootViewCount() {
        return footView == null ? 0 : 1;
    }

    private int getHeadViewCount() {
        return headView == null ? 0 : 1;
    }
}
