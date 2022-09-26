package com.example.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import com.example.orgs.R
import com.example.orgs.dao.ProdutosDao
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaProdutosActivity : AppCompatActivity(R.layout.activity_lista_produtos) {

    private val dao = ProdutosDao()
    private val adapter = ListaProdutosAdapter(context = this, produtos = dao.buscaTodos())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        configuraRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscaTodos())
        configuraFab()
    }

    private fun configuraRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
    }

    private fun configuraFab(){
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener(){
            redirecionaFormulario()
        }
    }

    private fun redirecionaFormulario(){
        val intent = Intent(this,FormularioProdutoActivity::class.java)
        startActivity(intent)
    }

}