package net.kwmt27.roomwordsample

import android.content.Context
import android.os.Bundle
import android.view.*
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_main.*
import net.kwmt27.roomwordsample.infrastructure.WordEntity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = WordListAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    class WordListAdapter internal constructor(
        context: Context
    ) : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

        private val inflater: LayoutInflater = LayoutInflater.from(context)
        private var words = emptyList<WordEntity>() // Cached copy of words

        inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val wordItemView: TextView = itemView.findViewById(R.id.textView)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
            val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
            return WordViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
            val current = words[position]
            holder.wordItemView.text = current.word
        }

        internal fun setWords(words: List<WordEntity>) {
            this.words = words
            notifyDataSetChanged()
        }

        override fun getItemCount() = words.size
    }
}
