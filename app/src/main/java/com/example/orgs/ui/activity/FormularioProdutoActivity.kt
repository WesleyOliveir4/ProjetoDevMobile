package com.example.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.orgs.R
import com.example.orgs.dao.ProdutosDao
import com.example.orgs.databinding.ActivityFormularioProdutoBinding
import com.example.orgs.model.Produto
import com.google.android.material.textfield.TextInputLayout
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFormularioProdutoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        val campoNome = binding.nome
        val campoDescricao = binding.descricao
        val campoValor = binding.valor
        val btn_BotaoSalvar = binding.botaoSalvar

        binding.imagemFormulario.setOnClickListener{
            AlertDialog.Builder(this)
                .setTitle("Titulo teste")
                .setMessage("Titulo mensagem")
                .setView(R.layout.formulario_imagem)
                .setPositiveButton("Confirmar"){_, _ ->

                }
                .setNegativeButton("Cancelar"){_, _ ->

                }
                .show()
        }


        btn_BotaoSalvar.setOnClickListener() {
            criaProduto(campoNome,campoDescricao,campoValor)
            }

    }

    private fun criaProduto( campoNome:TextInputLayout,campoDescricao:TextInputLayout,campoValor: TextInputLayout){
        val nome = campoNome.editText?.text.toString()
        val descricao = campoDescricao.editText?.text.toString()
        val valorEmTexto = campoValor.editText?.text.toString()

        val valor = if(campoValor.editText?.text.toString().isBlank()){
            BigDecimal.ZERO
        } else{
            BigDecimal(valorEmTexto)
        }

        val produtoNovo = Produto(
            nome = nome,
            descricao = descricao,
            valor = valor
        )

        val dao = ProdutosDao()
        dao.adiciona(produtoNovo)

        finish()
    }
}