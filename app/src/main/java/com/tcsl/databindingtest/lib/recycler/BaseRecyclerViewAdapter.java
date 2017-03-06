package com.tcsl.databindingtest.lib.recycler;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    private int ITEM_TYPE_HEADER = 0x00000111;
    private int ITEM_TYPE_FOOTER = 0x00000333;
    private int ITEM_TYPE_EMPTY = 0x00000555;
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
     * 是否允许加载更多
     */
    private boolean mOpenLoadMore = false;


    public void setOnItemClickListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

    public OnItemClickListener getmListener() {
        return mListener;
    }

    public void setmListener(OnItemClickListener mListener) {
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

        BaseViewHolder holder = null;
        if (viewType == ITEM_TYPE_HEADER) {
            holder = new BaseViewHolder(headView);
        } else if (viewType == ITEM_TYPE_EMPTY) {
            holder = new BaseViewHolder(emptyView);
        } else if (viewType == ITEM_TYPE_FOOTER) {
            holder = new BaseViewHolder(footView);
        } else {
            holder = onCreateDefViewHolder(parent, viewType);
        }
        return (K) holder;
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

        return (K)baseViewHolder ;
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
        int realPosition = getRealPosition(position);
        T t = mDatas.get(realPosition);
        if(mListener!=null){
            holder.getItemView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position1 = holder.getLayoutPosition();
                    if(position1!=NO_POSITION) {
                        int realPosition = getRealPosition(position1);
                        mListener.onItemClick(holder.getItemView(),realPosition);
                    }
                }
            });
        }
        convert(viewHolder,t);
    }

    protected abstract void convert(K viewHolder, T t);

    @Override
    public int getItemCount() {
        int itemCount = mDatas == null ? 0 : mDatas.size();
        if (null != emptyView && itemCount == 0) {
            itemCount++;
        }
        if (null != headView) {
            itemCount++;
        }
        if (null != footView) {
            itemCount++;
        }
        return itemCount;
    }

    @Override
    public int getItemViewType(int position) {
        if (null != headView && position == 0) {
            return ITEM_TYPE_HEADER;
        }
        if (null != footView && position == getItemCount() - 1) {
            return ITEM_TYPE_FOOTER;
        }
        if (emptyView != null && mDatas.size() == 0) {
            return ITEM_TYPE_EMPTY;
        }
        return getDefaultItemViewType(getRealPosition(position));
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

    public void addHeadView(View headView) {
        this.headView = headView;
        notifyItemInserted(0);
    }

    public void addFootView(View footView) {
        this.footView = footView;
        notifyItemInserted(getItemCount() - 1);
    }

    public void setEmptyView(View emptyView) {
        this.emptyView = emptyView;
        notifyDataSetChanged();
    }

    public void setLoadMoreEnabled(boolean mOpenLoadMore) {
        this.mOpenLoadMore = mOpenLoadMore;
    }

    @Override
    public void onViewAttachedToWindow(K holder) {
        //http://blog.csdn.net/qibin0506/article/details/49716795
        super.onViewAttachedToWindow(holder);
        int viewType = holder.getItemViewType();
        if (viewType == ITEM_TYPE_FOOTER || viewType == ITEM_TYPE_HEADER) {
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
                    if (viewType == ITEM_TYPE_FOOTER || viewType == ITEM_TYPE_HEADER) {
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


}
