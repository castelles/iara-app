package castelles.com.github.iaraapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import castelles.com.github.iaraapp.databinding.ItemPlaceListBinding
import castelles.com.github.iaraapp.model.Place


class PlaceListAdapter(
    private val onClick: Action<Place>
): ListAdapter<Place, PlaceListAdapter.ViewHolder>(DIFF_CALBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        with(LayoutInflater.from(parent.context)) {
            val binding = ItemPlaceListBinding.inflate(this, parent, false)
            ViewHolder(binding)
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemPlaceListBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Place) {
            binding.item = item
        }

    }

    companion object {
        private val DIFF_CALBACK = object: DiffUtil.ItemCallback<Place>() {
            override fun areItemsTheSame(oldItem: Place, newItem: Place): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Place, newItem: Place): Boolean =
                oldItem == newItem
        }
    }

}