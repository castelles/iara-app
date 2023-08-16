package castelles.com.github.iaraapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import castelles.com.github.iaraapp.model.Category
import castelles.com.github.iaraapp.databinding.ItemCategoryHomeBinding

class CategoryAdapter(
    private val onClick: (Category) -> Unit
): ListAdapter<Category, CategoryAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        with(LayoutInflater.from(parent.context)) {
            val binding = ItemCategoryHomeBinding.inflate(this, parent, false)
            ViewHolder(binding)
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemCategoryHomeBinding
    ): RecyclerView.ViewHolder(binding.root)
    {
        fun bind(item: Category) {
            binding.imvIcon.setImageDrawable(item.imageIcon)
            binding.txvName.text = item.name
        }
    }

    companion object {
        private val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<Category>() {
                override fun areItemsTheSame(oldItem: Category, newItem: Category) =
                    oldItem.id == newItem.id

                override fun areContentsTheSame(oldItem: Category, newItem: Category) =
                    oldItem == newItem
            }
    }
}