package br.com.alura.orgs.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.orgs.R
import com.example.orgs.databinding.ActivityFormularioProdutoBinding
import com.example.orgs.databinding.ProdutoItemBinding
import com.example.orgs.model.Produto
import java.text.NumberFormat
import java.util.*


class ListaProdutosAdapter(
        private val context: Context,
        produtos: List<Produto>

) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

        private val produtos = produtos.toMutableList()

    class ViewHolder(private val binding: ProdutoItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun vincula(produto: Produto) {
            val nome = binding.nomeRecyclerView
            nome.text = produto.nome
            val descricao = binding.descricaoRecyclerView
            descricao.text = produto.descricao
            val valor = binding.valorRecyclerView
            val valorEmMoeda: String = formataMoedaBrasileira(produto)
            valor.text = valorEmMoeda
            binding.imageView.load(produto.imagem)
        }

        private fun formataMoedaBrasileira(produto: Produto): String {
            val formatadorMoeda: NumberFormat = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
            return formatadorMoeda.format(produto.valor)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ProdutoItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.vincula(produto)
    }

    override fun getItemCount(): Int = produtos.size
    fun atualiza(produtos: List<Produto>) {
        this.produtos.clear()
        this.produtos.addAll(produtos)
        notifyDataSetChanged()
    }

}
