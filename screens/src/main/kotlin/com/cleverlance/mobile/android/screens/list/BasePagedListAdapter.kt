package com.cleverlance.mobile.android.screens.list

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil

abstract class BasePagedListAdapter<V : ListItemView<P>, P : Any>(
    dif: DiffUtil.ItemCallback<P>
) : PagedListAdapter<P, ListItemViewHolder<V, P>>(dif) {

    override fun onCreateViewHolder(container: ViewGroup, viewType: Int): ListItemViewHolder<V, P> {
        val itemView = createView(viewType)
        return ListItemViewHolder(itemView.createView(container), itemView)
    }

    abstract fun createView(viewType: Int): V

    override fun onBindViewHolder(holder: ListItemViewHolder<V, P>, position: Int) {
        getItem(position)?.let { holder.listItem.presenter = it }
    }

    override fun onViewAttachedToWindow(holder: ListItemViewHolder<V, P>) {
        super.onViewAttachedToWindow(holder)
        holder.bind()
    }

    override fun onViewDetachedFromWindow(holder: ListItemViewHolder<V, P>) {
        holder.unbind()
        super.onViewDetachedFromWindow(holder)
    }
}