package castelles.com.github.iaraapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import castelles.com.github.iaraapp.model.Place
import castelles.com.github.iaraapp.databinding.ItemPlaceBinding

class HomeMainAdapter(
    private val onClick: (Place) -> Unit
): ListAdapter<Place, HomeMainAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        with(LayoutInflater.from(parent.context)) {
            val binding = ItemPlaceBinding.inflate(this, parent, false)
            ViewHolder(binding)
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemPlaceBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Place) {
            binding.imvItem.setImageDrawable(item.image)
            binding.root.setOnClickListener {
                onClick.invoke(item)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<Place>() {
                override fun areItemsTheSame(oldItem: Place, newItem: Place) =
                    oldItem.id == newItem.id

                override fun areContentsTheSame(oldItem: Place, newItem: Place) =
                    oldItem == newItem
            }
    }
}